package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CheckboxExample extends Application {
  Stage window;

  public static void main(String[] args) {
    launch(args);
  }

  public void start(Stage stage) {
    window = stage;
    window.setTitle("Checkboxes");

    //Checkboxes
    CheckBox checkBox1 = new CheckBox("Old");
    CheckBox checkBox2 = new CheckBox("Young");
    checkBox1.setSelected(true);

    RadioButton radioButton1 = new RadioButton("male");
    RadioButton radioButton2 = new RadioButton("female");
    radioButton1.setSelected(true);

    Button button = new Button("Submit");
    button.setOnAction(e -> showInfo(checkBox1, checkBox2));

    VBox box = new VBox(10);
    box.setPadding(new Insets(20, 20, 20, 20));
    box.getChildren().addAll(checkBox1, checkBox2, radioButton1, radioButton2, button);
    Scene scene = new Scene(box, 300, 200);
    window.setScene(scene);
    window.show();
  }

  private void showInfo(CheckBox box1, CheckBox box2) {
    String info = "You are: ";
    if (box1.isSelected())
      info += box1.getText();
    if (box2.isSelected())
      info += box2.getText();

    System.out.println(info);
  }

}
