package gotmap.menu;

import gotmap.application.GotMap;
import gotmap.data.HouseProvider;
import gotmap.objects.Castle;
import gotmap.objects.House;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import java.util.ArrayList;
import java.util.List;

public class MenuController {
    @FXML private TableView houseTable;
    @FXML private ListView familyList;
    @FXML private MenuBar menuBar;
    @FXML private BorderPane container;

    private final String imageBase = "/gotmap/images/";

    public void init(String displayCastle, HouseProvider provider) {
        ArrayList<House> houses = provider.GetAll();

        ArrayList<Menu> menus = new ArrayList<>();
        ArrayList<String> processedRegions = new ArrayList<>();
        for(House house : houses) {

            if(!processedRegions.contains(house.region)) {
                menus.add(BuildRegionMenu(house.region, houses));
                processedRegions.add(house.region);
            }

            for(Castle castle : house.castles) {
                if(castle.castleName.equals(displayCastle)) {
                    TableColumn<House, String> houseNameCol = new TableColumn<>("House Name");
                    houseNameCol.setCellValueFactory(new PropertyValueFactory<>("houseName"));
                    houseTable.getColumns().add(houseNameCol);

                    TableColumn<House, String> mottoCol = new TableColumn<>("Motto");
                    mottoCol.setCellValueFactory(new PropertyValueFactory<>("motto"));
                    houseTable.getColumns().add(mottoCol);

                    TableColumn<House, Integer> castleNameCol = new TableColumn<>("Castle");
                    castleNameCol.setCellValueFactory(new PropertyValueFactory<>("mainFort"));
                    houseTable.getColumns().add(castleNameCol);

                    TableColumn<House, Integer> regionCol = new TableColumn<>("Region");
                    regionCol.setCellValueFactory(new PropertyValueFactory<>("region"));
                    houseTable.getColumns().add(regionCol);

                    TableColumn<House, Integer> coordinatesCol = new TableColumn<>("Coordinates");
                    coordinatesCol.setCellValueFactory(new PropertyValueFactory<>("coordinates"));
                    houseTable.getColumns().add(coordinatesCol);

                    houseTable.getItems().add(house);

                    familyList.getItems().addAll(house.members);

                    String imagePath = imageBase + house.imageName;
                    Image image = new Image(getClass().getResourceAsStream(imagePath),100, 100, false, false);;
                    ImageView houseImage = new ImageView(image);

                    container.setBottom(houseImage);
                }
            }
        }

        Menu master = new Menu();
        master.setText("Regions");
        master.getItems().addAll(menus);
        menuBar.getMenus().add(master);
    }

    @FXML public void displayHouse(ActionEvent evt) {
        try {
            MenuItem control = (MenuItem) evt.getSource();
            String houseName = control.getId();

            GotMap.openMenu(houseName);
        }
        catch(Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Error!");
            alert.setContentText("There was an error trying to display house information!");

            alert.showAndWait();
        }
    }

    @FXML public void slideshow() {
        GotMap.openSlideshow();
    }

    private Menu BuildRegionMenu(String region, List<House> houses) {
        Menu menu = new Menu();
        menu.setText(region);
        for(House house : houses) {
                if(house.region.equals(region)) {
                    MenuItem item = new MenuItem();

                    item.setId(house.mainFort);
                    item.setText(house.houseName);
                    item.setOnAction(this::displayHouse);

                    menu.getItems().addAll(item);
                }
        }

        return menu;
    }
}
