package ver_01;

import alerts.CloseAlert;
import javafx.application.Application;
import ver_01.managers.SaveManager;
import ver_01.model.State;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application {

    public static SaveManager saveManager;
    private static State lastState;
    private static Stage window;
    private static State currentState;
    private static boolean loadGame = false;

    public static void main(String[] args) {
        launch(args);
    }

    public static Stage getWindow() {
        return window;
    }

    //** Save game when window is closed **\\
    private static void closeProgram(Event e) {

        if (CloseAlert.display()) {
            saveManager.saveGame();
            window.close();
        }
        e.consume();
    }

    //** Set current state **\\
    public static void setCurrentState(State currentState) {
        Main.currentState = currentState;
    }

    public static State getLastState() {
        return lastState;
    }

    public static boolean isLoadGame() {
        return loadGame;
    }

    //** Check if new game or load last game **\\
    public static void setLoadGame(boolean loadGame) {
        Main.loadGame = loadGame;
    }

    public  void start(Stage window) throws Exception {

        this.window = window;
        saveManager = new SaveManager();
        lastState = saveManager.getSavedGame();
        BorderPane root = FXMLLoader.load(getClass().getResource("views/menu/Menu.fxml"));
        window.setTitle("Towers of Hanoi");
        window.setOnCloseRequest(e -> closeProgram(e));
        window.setScene(new Scene(root, 600, 400));
        window.show();
    }
}

