package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ComboBoxExample extends Application {

  Stage window;
  ComboBox<String> comboBox;

  public static void main(String[] args) {
    launch(args);
  }

  public void start(Stage stage) {
    window = stage;
    window.setTitle("ComboBox Demo");

    Button button = new Button("Submit");

    comboBox = new ComboBox<>();
    //Promptext will disappear
    comboBox.setEditable(true);

    comboBox.getItems().addAll("Wonder Woman",
                               "Captain America",
                               "SpiderMan The Begining");
    comboBox.getItems().add("Rise of the Ape Planet");

    comboBox.setPromptText("Choose your favorite movie");

    //Choicebox doesn't have this property
    comboBox.setOnAction(e -> printSelection());

    HBox box = new HBox(10);
    box.setPadding(new Insets(20, 20, 20, 20));
    box.getChildren().addAll(comboBox, button);

    Scene scene = new Scene(box, 300, 200);

    window.setScene(scene);
    window.show();
  }

  private void printSelection() {
    System.out.println(comboBox.getValue());
  }
}

