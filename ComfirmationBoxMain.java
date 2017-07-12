package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ComfirmationBoxMain extends Application {
  public static void main(String[] args) {
    launch(args);
  }

  public void start(Stage window) {
    Button button = new Button("Click me!");

    button.setOnAction(e -> {
      boolean result = ConfirmBox.display("Confirmation", "Are you sure you want to send it?");
      System.out.println(result);
    });

    StackPane root = new StackPane();
    root.getChildren().add(button);

    Scene scene = new Scene(root, 500, 500);

    window.setScene(scene);
    window.setTitle("This is boilercode");
    window.show();
  }
}
