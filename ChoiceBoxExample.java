package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChoiceBoxExample extends Application {

  Stage window;

  public static void main(String[] args) {
    launch(args);
  }

  public void start(Stage stage) {
    window = stage;
    window.setTitle("Drop Down Menu");

    Button button = new Button("My New Gym");

    ChoiceBox<String> box = new ChoiceBox<>();
    box.getItems().add("Bomiso");
    box.getItems().add("BoomBox");
    box.getItems().add("Gold");
    box.getItems().addAll("Hype", "Molecule", "Prankster");

    box.setValue("Hype");

    //Alerting on selection
    box.getSelectionModel().selectedItemProperty().addListener( (v, oldVal, newVal) -> System.out
        .println("Old value " + oldVal + " New value " + newVal));

    VBox box1 = new VBox(10);
    box1.setPadding(new Insets(20, 20, 20, 20));
    box1.getChildren().addAll(box, button);

    Scene scene = new Scene(box1, 300, 300);

    button.setOnAction(e -> System.out.println(box.getValue()));

    window.setScene(scene);
    window.show();
  }

}
