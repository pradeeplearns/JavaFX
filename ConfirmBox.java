package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {
  static boolean answer;
  public static boolean display(String title, String message) {
    Stage window = new Stage();
    window.initModality(Modality.APPLICATION_MODAL);

    window.setTitle(title);
    window.setMinWidth(250);
    Label label = new Label(message);

    Button yesButton = new Button("Yes");
    yesButton.setOnAction(e -> {
      answer = true;
      window.close();
    });

    Button noButton = new Button("No");
    noButton.setOnAction(e -> {
      answer = false;
      window.close();
    });

    VBox box = new VBox(10);
    box.getChildren().addAll(label, yesButton, noButton);
    box.setAlignment(Pos.CENTER);

    Scene scene = new Scene(box);
    window.setScene(scene);
    window.showAndWait();

    return answer;
  }
}
