package Sample2;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ListViewExample extends Application {

  ListView<String> list;
  Stage window;

  public static void main(String[] args) {
    launch(args);
  }

  public void start(Stage stage) {
    window = stage;
    window.setTitle("List View Demo");

    Button button = new Button("Submit");

    list = new ListView<>();
    list.getItems().addAll("Momos", "Wraps", "Burger", "Truffle");
    list.getItems().add("Coffee");

    //Allowing multiple selections
    list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

    VBox box = new VBox(10);
    box.setPadding(new Insets(20, 20, 20, 20));
    box.getChildren().addAll(list, button);

    //Getting selected items
    button.setOnAction(e -> printItem(list.getSelectionModel().getSelectedItems()));

    Scene scene = new Scene(box, 300, 200);
    window.setScene(scene);
    window.show();
  }

  private void printItem(ObservableList<String> items) {
    for (String m : items) {
      System.out.println(m);
    }
  }
}
