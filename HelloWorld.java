package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloWorld extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Hello World");

    Button click = new Button();
    click.setText("Click me");

//    Button button = new Button("I am another button");
    Label label = new Label();
    label.setText("You can click the button or look at me");

    TextField input = new TextField();
    input.setPromptText("What's on your mind?");

    click.setOnAction( e -> printInput(input));

    VBox box = new VBox(10);
    box.setPadding(new Insets(20, 20, 20, 20));
    box.getChildren().addAll(input, label, click);

    Scene scene = new Scene(box, 300, 200);

    primaryStage.setScene(scene);
    primaryStage.show();
  }

  private void printInput(TextField txt) {
    System.out.println(txt.getText());
  }
}
