package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GracefullExit extends Application {

  Stage window;

  public static void main(String[] args) {
    launch(args);
  }

  public void start(Stage stage) {
    window = stage;
    window.setTitle("This is close example");

    //Graceful close from close sign on window
    window.setOnCloseRequest(e -> {
      e.consume();  //Consuming the event to avoid window close on chosing no
      closeProgram();
    });

    Button button = new Button();
    button.setText("Close");

    //Graceful close from button
    button.setOnAction(e -> closeProgram());

    StackPane root = new StackPane();
    root.getChildren().addAll(button);

    Scene scene = new Scene(root, 300, 300);
    window.setScene(scene);
    window.show();
  }

  private void closeProgram() {
    System.out.println("Saving the file!");
    Boolean result = ConfirmBox.display("Exiting", "Are you sure ?");

    if (result)
      window.close();

  }

}
