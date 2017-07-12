package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultipleLayout extends Application {

  Stage window;

  public static void main(String[] args) {
    launch(args);
  }

  public void start(Stage stage) {
    window = stage;
    window.setTitle("Multiple Layout");

    //Graceful close from close sign on window
    window.setOnCloseRequest(e -> {
      e.consume();  //Consuming the event to avoid window close on chosing no
      closeProgram();
    });

    HBox topMenu = new HBox();
    Button buttonA = new Button("Home");
    Button buttonB = new Button("Edit");
    Button buttonC = new Button("View");

    topMenu.getChildren().addAll(buttonA, buttonB, buttonC);

    VBox leftMenu = new VBox();
    Button buttonP = new Button("Contact");
    Button buttonQ = new Button("About us");
    Button buttonR = new Button("Map");

    leftMenu.getChildren().addAll(buttonP, buttonQ, buttonR);

    BorderPane borderPane = new BorderPane();
    borderPane.setTop(topMenu);
    borderPane.setLeft(leftMenu);

    Scene scene = new Scene(borderPane, 500, 500);
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
