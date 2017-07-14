package css.style;

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
    //Adding inline css
    //name.setStyle("-fx-text-fill: chartreuse");

    //name input
    TextField nameText = new TextField("Pradex");   //Default text
    GridPane.setConstraints(nameText, 1, 0);

    //Password lable
    Label password = new Label("Password:");
    password.setId("bold-label");
    GridPane.setConstraints(password, 0, 1);

    //Password input
    PasswordField passText = new PasswordField();   //Default text
    passText.setPromptText("password");
    GridPane.setConstraints(passText, 1, 1);

    Button submit = new Button("Login");
    GridPane.setConstraints(submit, 0, 2);

    Button register = new Button("Sign up");
    GridPane.setConstraints(register, 1, 2);
    register.getStyleClass().add("button-yellow");

    //Changing theme on button click
    //submit.setOnAction( e -> setUserAgentStylesheet(STYLESHEET_CASPIAN));

    gridPane.getChildren().addAll(name, nameText, password, passText, submit, register);

    Scene scene = new Scene(gridPane, 300, 200);
    //Scene contains all the stuff for current window so add style here
    scene.getStylesheets().add(GridPaneLoginExample.class
                                   .getResource("login.css").toExternalForm());

    window.setScene(scene);
    window.show();
  }
}
