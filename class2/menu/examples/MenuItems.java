package menu.examples;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MenuItems extends Application {
  Stage window;
  BorderPane layout;

  public static void main(String[] args) {
    launch(args);
  }

  public void start(Stage stage) {
    window = stage;
    window.setTitle("Menu Demo");

    //Adding File menu
    Menu fileMenu = new Menu("File");

    //Menu Item
    fileMenu.getItems().add(new MenuItem("New Project..."));
    fileMenu.getItems().add(new MenuItem("New Module..."));
    fileMenu.getItems().add(new MenuItem("Import Project..."));
    fileMenu.getItems().addAll(new SeparatorMenuItem());
    fileMenu.getItems().add(new MenuItem("Settings..."));
    fileMenu.getItems().add(new MenuItem("Project Structure..."));
    fileMenu.getItems().addAll(new SeparatorMenuItem());
    fileMenu.getItems().add(new MenuItem("Import Settings..."));
    fileMenu.getItems().add(new MenuItem("Export Settings..."));

    //Adding Edit menu
    //Adding underscore makes First character as shortcut with Alt + Char
    Menu editMenu = new Menu("_Edit");

    //Edit Menu Item
    MenuItem cutO = new MenuItem("Cut");
    cutO.setOnAction(e -> System.out.println("Cutting it for you.."));
    //cutO.setDisable(true);
    editMenu.getItems().add(cutO);
    editMenu.getItems().add(new MenuItem("Copy"));
    editMenu.getItems().add(new MenuItem("Paste"));

    //Adding Help menu {Checkbox type select menu
    Menu helpMenu = new Menu("_Help");

    CheckMenuItem showLine = new CheckMenuItem("Show line number");
    showLine.setOnAction(e -> {
      if (showLine.isSelected())
        System.out.println("now you can see line numbers");
      else {
        System.out.println("Hiding line numbers");
      }
    });

    CheckMenuItem autoSave = new CheckMenuItem("Enable Autosave");
    autoSave.setSelected(true);

    helpMenu.getItems().addAll(showLine, autoSave);

//    //Theme Radio Menu Items
    Menu themeMenu = new Menu("Theme");
    ToggleGroup toggleGroup = new ToggleGroup();

    RadioMenuItem dark = new RadioMenuItem("Dark Theme");
    RadioMenuItem white = new RadioMenuItem("White Theme");
    RadioMenuItem hazy = new RadioMenuItem("Hazy Theme");
    dark.setSelected(true);

    toggleGroup.getToggles().addAll(dark, white, hazy);
    themeMenu.getItems().addAll(dark, white, hazy);

    //Main menu bar
    MenuBar menuBar = new MenuBar();
    menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu, themeMenu);

    layout = new BorderPane();
    layout.setTop(menuBar);
    Scene scene = new Scene(layout, 400, 300);
    window.setScene(scene);
    window.show();
  }
}
