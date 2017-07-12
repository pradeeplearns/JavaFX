package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultipleScene extends Application {

  Scene scene1, scene2;

  public static void main(String[] args) {
    launch(args);
  }

  public void start(Stage window) {

    Label label1 = new Label("This is scene 1");
    Button button1 = new Button("Take me to scene 2");
    button1.setOnAction(e -> window.setScene(scene2));

    VBox vBox = new VBox(20);
    vBox.getChildren().addAll(label1, button1);

    scene1 = new Scene(vBox, 300, 300);

    Button button2 = new Button("Wow this was wasted");
    button2.setOnAction(e -> window.setScene(scene1));

    StackPane stackPane = new StackPane();
    stackPane.getChildren().add(button2);

    scene2 = new Scene(stackPane, 500, 500);

    window.setTitle("This shows multiple scene");
    window.setScene(scene1);
    window.show();
  }

}
