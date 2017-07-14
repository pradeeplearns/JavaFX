package Sample2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TreeViewExample extends Application {
  Stage window;
  TreeView<String> tree;

  public static void main(String[] args) {
    launch(args);
  }

  public void start(Stage stage) {
    window = stage;
    window.setTitle("List View Demo");

    Button button = new Button("Submit");

    TreeItem<String> root, dog, food;

    //Root of tree
    root = new TreeItem<>();
    root.setExpanded(true);

    //Dog branch
    dog = makeBranch("dog", root);
    makeBranch("Husky", dog);
    makeBranch("Pomsky", dog);
    makeBranch("Pitbul", dog);

    //Food Branch
    food = makeBranch("food", root);
    makeBranch("Burrito", food);
    makeBranch("Rajma", food);

    tree = new TreeView<>(root);
    tree.setShowRoot(false);
    //Adding listener
    tree.getSelectionModel().selectedItemProperty()
        .addListener( (v, oldVal, newVal) -> {
          if (newVal != null)
          System.out.println(newVal.getValue());
        } );

    HBox box = new HBox(10);
    box.setPadding(new Insets(20, 20, 20, 20));
    box.getChildren().addAll(tree, button);

    Scene scene = new Scene(box, 300, 250);
    window.setScene(scene);
    window.show();
  }

  //Creating Branches
  private TreeItem<String> makeBranch(String title, TreeItem<String> parent) {
    TreeItem<String> treeItem = new TreeItem<>(title);
    treeItem.setExpanded(true);
    parent.getChildren().add(treeItem);

    return treeItem;
  }

}
