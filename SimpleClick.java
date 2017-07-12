package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SimpleClick extends Application implements EventHandler<ActionEvent> {

  Button button;
  TextArea text;
  public static void main(String[] args) {
    launch(args);
  }

  public void start(Stage stage) {
    button = new Button();
    button.setText("Click me");
    button.setOnAction(this);
    button.setAlignment(Pos.BOTTOM_LEFT);

    text = new TextArea("Testing what is it");
    text.setMaxWidth(100);
    text.setMaxHeight(100);

    StackPane root = new StackPane();
    root.getChildren().addAll(button, text);

    Scene scene = new Scene(root, 300, 300);
    stage.setScene(scene);
    stage.setTitle("This is sample");
    stage.show();
  }

  public void handle(ActionEvent event) {
    if (event.getSource() == button) {
      System.out.println("Oooo I like it when you touch me!");
    }

  }
}
