package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GridPaneLoginExample extends Application {

  Stage window;

  public static void main(String[] args) {
    launch(args);
  }

  public void start(Stage stage) {
    window = stage;
    window.setTitle("Grid example");

    GridPane gridPane = new GridPane();
    gridPane.setPadding(new Insets(10, 10, 10, 10));
    gridPane.setVgap(8);
    gridPane.setHgap(10);

    //Name lable
    Label name = new Label("UserName:");
    GridPane.setConstraints(name, 0, 0);

    //name input
    TextField nameText = new TextField("Pradex");   //Default text
    GridPane.setConstraints(nameText, 1, 0);

    //Password lable
    Label password = new Label("Password:");
    GridPane.setConstraints(password, 0, 1);

    //Password input
    PasswordField passText = new PasswordField();   //Default text
    passText.setPromptText("password");
    GridPane.setConstraints(passText, 1, 1);

    Button submit = new Button("Login");
    GridPane.setConstraints(submit, 0, 2);

    gridPane.getChildren().addAll(name, nameText, password, passText, submit);

    Scene scene = new Scene(gridPane, 300, 200);

    window.setScene(scene);
    window.show();
  }
}
