package alerts;

import ver_01.model.Game;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import java.util.Optional;

public class GameWonAlert {

    public static boolean display(Game game) {
        return displayAlert(game.getNumMoves());
    }

    private static boolean displayAlert(int numMoves) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Game Won");
        alert.setHeaderText("Congratulations... You won the game with " + numMoves + " moves.");
        alert.setContentText("Would you like to restart");

        Optional<ButtonType> result = alert.showAndWait();
        return result.get() == ButtonType.OK;

    }
}
