package sample;

import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ToDoApp extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    primaryStage.setTitle("TO-DO App");

    GridPane pane = new GridPane();

    Label label = new Label("TODO App");
    GridPane.setConstraints(label, 0, 0);

    Label task = new Label("Task:");
    GridPane.setConstraints(label, 0, 1);

    TextField input = new TextField();
    input.setPromptText("What do you want to do?");
    GridPane.setConstraints(input, 1, 1);



  }
}
