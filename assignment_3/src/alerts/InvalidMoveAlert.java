package alerts;

import javafx.scene.control.Alert;

public class InvalidMoveAlert {

    public static void display() {

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("InvalidMove");
        alert.setHeaderText("That last move was invalid.");
        alert.setContentText("Please do not put a smaller block on top of a larger one.");
        alert.showAndWait();
    }
}
