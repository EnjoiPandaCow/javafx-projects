package gotmap.application;

import gotmap.data.HouseProvider;
import gotmap.map.MapController;
import gotmap.menu.MenuController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Pagination;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GotMap extends Application {

    private static HouseProvider houseProvider;

    @Override
    public void start(Stage primaryStage) throws Exception {
        houseProvider = new HouseProvider();
        houseProvider.loadData();

        FXMLLoader mapLoader = new FXMLLoader(getClass().getResource("/gotmap/map/map.fxml"));
        GridPane root = mapLoader.load();

        MapController mapController = mapLoader.getController();

        mapController.init(houseProvider);

        Scene s = new Scene(root);
        primaryStage.setScene(s);
        primaryStage.setTitle("Game of Thrones");
        primaryStage.show();
    }

    public static void openMenu(String castleName) throws Exception {
        Stage menuStage = new Stage();
        FXMLLoader menuLoader = new FXMLLoader(GotMap.class.getResource("/gotmap/menu/menu.fxml"));
        BorderPane root = menuLoader.load();

        MenuController controller  = menuLoader.getController();

        controller.init(castleName, houseProvider);

        Scene menuScene = new Scene(root);

        menuStage.setScene(menuScene);
        menuStage.setTitle("House Information");
        menuStage.show();
    }

    public static void openSlideshow() {
        Stage ps = new Stage();
        String [] photos = {"arryn.jpg", "baratheon.png", "bolton.png", "frey.png", "greyjoy.png", "lannister.png","martell.png","mormont.png","stark.png","targaryen.png","tully.png"};
        Pagination p = new Pagination(photos.length);

        p.setPageFactory((Integer pageIndex) -> {
            return new ImageView(GotMap.class.getResource("/gotmap/images/" + photos[pageIndex]).toExternalForm());});

        ps.setScene(new Scene(p));
        ps.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
