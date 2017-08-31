package gotmap.map;

import gotmap.application.GotMap;
import gotmap.data.HouseProvider;
import gotmap.objects.Castle;
import gotmap.objects.House;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Alert;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class MapController {
    @FXML private GridPane mapContainer;
    private HouseProvider houseProvider;
    private final String imageBase = "/gotmap/images/";

    public void init(HouseProvider provider) {
        houseProvider = provider;
        ArrayList<House> houses = houseProvider.GetAll();

        for(House house : houses) {
            for(Castle castle : house.castles) {
                String imagePath = imageBase + house.imageName;
                Image image = new Image(getClass().getResourceAsStream(imagePath));
                ImageView imageView = new ImageView(image);
                imageView.setFitHeight(35);
                imageView.setFitWidth(34);
                Label label = new Label(null, imageView);

                GridPane.setConstraints(label, castle.display.columnIndex, castle.display.rowIndex);
                GridPane.setMargin(label, castle.display.toInsets());

                label.setId(castle.castleName);
                label.setOnMouseClicked(this::displayHouse);
                label.setPrefHeight(33);
                label.setPrefWidth(61);
                label.setCursor(Cursor.OPEN_HAND);

                mapContainer.getChildren().addAll(label);
            }
        }
    }

    public void displayHouse(MouseEvent evt) {
        try {
            Control control = (Control) evt.getSource();
            String castleName = control.getId();

            GotMap.openMenu(castleName);
        }
        catch(Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Error!");
            alert.setContentText("There was an error trying to display house information!");

            alert.showAndWait();
        }
    }
}
