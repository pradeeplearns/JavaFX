package tables;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TableSheet extends Application {

  Stage window;
  TableView<Product> table;

  //Adding Deleting rows
  TextField nameInput, priceInput, quantityInput;
  Button addButton, deleteButton;

  public static void main(String[] args) {
    launch(args);
  }

  public void start(Stage stage) {
    window = stage;
    window.setTitle("Product Sheet");

    //name column
    TableColumn<Product, String> nameCol = new TableColumn<>("Name");
    nameCol.setMinWidth(200);
    nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

    //Price column
    TableColumn<Product, Double> priceCol = new TableColumn<>("Price");
    priceCol.setMinWidth(100);
    priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

    //Quantity Column
    TableColumn<Product, Integer> quantityCol = new TableColumn<>("Quantity");
    quantityCol.setMinWidth(100);
    quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));

    //Adding Name Field
    nameInput = new TextField();
    nameInput.setMinWidth(100);
    nameInput.setPromptText("Name");

    //Adding Name Field
    priceInput = new TextField();
    priceInput.setPromptText("Price");

    //Adding Name Field
    quantityInput = new TextField();
    quantityInput.setPromptText("Quantity");

    addButton = new Button("Add");
    addButton.setOnAction( e -> addProduct());

    deleteButton = new Button("Delete");
    deleteButton.setOnAction( e -> deleteProduct());

    HBox hBox = new HBox();
    hBox.setPadding(new Insets(10, 10, 10, 10));
    hBox.setSpacing(10);
    hBox.getChildren().addAll(nameInput, priceInput, quantityInput, addButton, deleteButton);

    table = new TableView<>();
    table.getColumns().addAll(nameCol, priceCol, quantityCol);
    table.getItems().addAll(getProduct());

    VBox box = new VBox(10);
    box.setPadding(new Insets(10, 10, 10, 10));
    box.getChildren().addAll(table, hBox);

    Scene scene = new Scene(box);

    window.setScene(scene);
    window.show();
  }

  //Get all of the products
  public ObservableList<Product> getProduct() {
    ObservableList<Product> products = FXCollections.observableArrayList();

    products.add(new Product("Moto G4", 14000, 18));
    products.add(new Product("HP Pavelion", 54000, 10));
    products.add(new Product("Coffee Mug", 140, 56));
    products.add(new Product("Ball Pen", 10.50, 132));

    return products;
  }

  private void addProduct() {
    Product product = new Product();
    product.setName(nameInput.getText());
    product.setPrice(Double.parseDouble(priceInput.getText()));
    product.setQuantity(Integer.parseInt(quantityInput.getText()));

    table.getItems().add(product);

    //Clear fields
    nameInput.clear();
    priceInput.clear();
    quantityInput.clear();
  }

  private void deleteProduct() {
    ObservableList<Product> selectedProduct, allProducts;

    allProducts = table.getItems();

    selectedProduct = table.getSelectionModel().getSelectedItems();

    selectedProduct.forEach(allProducts::remove);
  }

}
