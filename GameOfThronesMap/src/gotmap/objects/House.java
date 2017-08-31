package gotmap.objects;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class House {
    public String houseName;
    public String motto;
    public String region;
    public String mainFort;
    public String coordinates;
    public String imageName;
    public String[] members;
    public Castle[] castles;

    public House(String houseName, String motto, String region, String mainFort, String coordinates, String imageName) {
        this.houseName = houseName;
        this.motto = motto;
        this.region = region;
        this.mainFort = mainFort;
        this.coordinates = coordinates;
        this.imageName = imageName;
    }

    public StringProperty houseNameProperty() {
        return new SimpleStringProperty(houseName);
    }

    public StringProperty mottoProperty() {
        return new SimpleStringProperty(motto);
    }

    public StringProperty regionProperty() {
        return new SimpleStringProperty(region);
    }

    public StringProperty mainFortProperty() {
        return new SimpleStringProperty(mainFort);
    }

    public StringProperty coordinatesProperty() {
        return new SimpleStringProperty(coordinates);
    }
}
