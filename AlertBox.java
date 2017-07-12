package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {
  public static void display(String title, String message) {
    Stage window = new Stage();

    //Block interaction to main window
    window.initModality(Modality.APPLICATION_MODAL);

    Label label = new Label(message);
    window.setTitle(title);
    window.setMinWidth(250);

    Button closeButton = new Button("Close the window");
    closeButton.setOnAction(e -> window.close());

    VBox box = new VBox(10);
    box.getChildren().addAll(label, closeButton);
    box.setAlignment(Pos.CENTER);

    Scene scene = new Scene(box);

    window.setScene(scene);
    window.showAndWait();
  }

}
