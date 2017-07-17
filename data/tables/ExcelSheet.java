package tables;

import datab.example.ProductDatabase;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ExcelSheet extends Application {
  Stage window;
  TableView<Product> table;

  TextField nameInput, priceInput, quantityInput;
  Button addButton, deleteButton;

  ProductDatabase productDatabase = new ProductDatabase();

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    window = primaryStage;
    window.setTitle("Store Inventory Keeper");

    //Name Column
    TableColumn<Product, String> nameColumn = new TableColumn<>("Name");
    nameColumn.setMinWidth(200);
    nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

    //Price column
    TableColumn<Product, Double> priceCol = new TableColumn<>("Price");
    priceCol.setMinWidth(100);
    priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

    //Quantity Column
    TableColumn<Product, Integer> quantityCol = new TableColumn<>("Quantity");
    quantityCol.setMinWidth(100);
    quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));

    nameInput = new TextField();
    nameInput.setPromptText("Item Name");
    nameInput.setMinWidth(100);

    priceInput = new TextField();
    priceInput.setPromptText("Price");

    quantityInput = new TextField();
    quantityInput.setPromptText("Quantity");

    addButton = new Button("Add Item");
    addButton.setOnAction(e -> addProduct());

    deleteButton = new Button("Delete Item");

    deleteButton.setOnAction(e -> {
      try {
        deleteProduct();
      } catch (SQLException s) {
        System.out.println(s);
      }
    });

    HBox hBox = new HBox();
    hBox.setPadding(new Insets(20, 20, 20, 20));
    hBox.setSpacing(10);
    hBox.getChildren().addAll(nameInput, priceInput, quantityInput, addButton, deleteButton);

    table = new TableView<>();
    table.getColumns().addAll(nameColumn, priceCol, quantityCol);
    table.getItems().addAll(getProduct());
//    table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

    VBox box = new VBox(10);
    box.setPadding(new Insets(10, 10, 10, 10));
    box.getChildren().addAll(table, hBox);

    Scene scene = new Scene(box);
    window.setScene(scene);
    window.show();
  }

  private void deleteProduct() throws SQLException {
    ObservableList<Product> selectedItem, allItems;

    allItems = table.getItems();
    selectedItem = table.getSelectionModel().getSelectedItems();

    for(Product p : selectedItem) {
      allItems.remove(p);
      //Deleting from database
      productDatabase.deleteSql(p.getName());
    }
  }

  private void addProduct() {
    Product p = new Product();
    String name = nameInput.getText();
    Float price = Float.parseFloat(priceInput.getText());
    int quantity = Integer.parseInt(quantityInput.getText());

    p.setName(name);
    p.setPrice(price);
    p.setQuantity(quantity);

    table.getItems().add(p);

    try {
      productDatabase.insertSql(name, price, quantity);
      productDatabase.connectionClose();
    } catch (SQLException e) {
      System.out.println(e);
    }

    nameInput.clear();
    priceInput.clear();
    quantityInput.clear();
  }

  //Get all of the products
  public ObservableList<Product> getProduct() throws SQLException {
    ObservableList<Product> products = FXCollections.observableArrayList();

    ResultSet rs = productDatabase.fetchData();

    while (rs.next()) {
      products.add(new Product(rs.getString(1), rs.getFloat(2), rs.getInt(3)));
    }

    for (Product p: products) {
      System.out.println(p.getName());
    }

    productDatabase.connectionClose();
    return products;
  }
}
