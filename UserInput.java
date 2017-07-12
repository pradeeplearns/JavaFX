package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UserInput extends Application {

  Stage window;

  public static void main(String[] args) {
    launch(args);
  }

  public void start(Stage stage) {
    window = stage;
    window.setTitle("User Input box");

    TextField input = new TextField();
    input.setPromptText("Enter your keywords here");

    Button submit = new Button("Submit");
    submit.setOnAction(e -> {
      isInt(input.getText());
    });

    VBox box = new VBox(10);
    box.setPadding(new Insets(20, 20, 20, 20));
    box.getChildren().addAll(input, submit);

    Scene scene = new Scene(box, 300, 200);

    window.setScene(scene);
    window.show();
  }

  private Boolean isInt(String message) {
    try {
      int age = Integer.parseInt(message);
      System.out.println("User is:" + age);
      return true;
    } catch (NumberFormatException e) {
      System.out.println("User has not entered a number");
    }
    return false;
  }

}
