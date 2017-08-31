package ver_01.views.menu;

import ver_01.Main;
import ver_01.managers.SaveManager;
import ver_01.model.State;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class Menu {

    public SaveManager saveManager;
    public State lastState;
    @FXML
    private Button newGameBtn;
    @FXML
    private Button loadGameBtn;

    //** Makes sure that the game is a new game instead of a loaded game **\\
    @FXML
    private void startNewGame() {
        Main.setLoadGame(false);
        startGame();
    }

    //** Will check if there is a saved game if not then load game button will not show **\\
    @FXML
    private void initialize() {

        saveManager = Main.saveManager;
        lastState = Main.getLastState();
        if(lastState == null) {
            loadGameBtn.setDisable(true);
        } else {
            loadGameBtn.setDisable(false);
        }
    }

    @FXML
    public void loadGame() {

        Main.setLoadGame(true);
        Main.setCurrentState(saveManager.getSavedGame());
        startGame();
    }

    private void startGame() {

        try {
            BorderPane root = FXMLLoader.load(getClass().getResource("../game/TowersOfHanoi.fxml"));
            Main.getWindow().setScene(new Scene(root, 600, 400));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
