package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PopUpBoxMain extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  public void start(Stage window) {
    Button button = new Button("Click me!");
    button.setOnAction(e -> AlertBox.display("Popup", "That was funny"));

    StackPane root = new StackPane();
    root.getChildren().add(button);

    Scene scene = new Scene(root, 500, 500);

    window.setScene(scene);
    window.setTitle("This is boilercode");
    window.show();
  }

}
