package Class;



import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import java.nio.file.Path;
import java.util.List;


/**
 * Created by tatsu on 27/12/2015.
 */
public class BeanDeDameuse {

    private StringProperty dameuses;
    private StringProperty longitude;
    private StringProperty latitude;
    //private StringProperty altitude;
    //private StringProperty orientation;
    private StringProperty date;
    private StringProperty heure;

    private Path fichier;

    public BeanDeDameuse() {
        dameuses = new SimpleStringProperty();
        longitude = new SimpleStringProperty();
        latitude = new SimpleStringProperty();
        //altitude = new SimpleStringProperty();
        //orientation = new SimpleStringProperty();
        date = new SimpleStringProperty();
        heure = new SimpleStringProperty();
    }

    public String getDameuses() {
        return dameuses.get();
    }

    public StringProperty dameusesProperty() {
        return dameuses;
    }

    public void setDameuses(String dameuses) {
        this.dameuses.set(dameuses);
    }

    public String getLongitude() {
        return longitude.get();
    }

    public StringProperty longitudeProperty() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude.set(longitude);
    }

    public String getLatitude() {
        return latitude.get();
    }

    public StringProperty latitudeProperty() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude.set(latitude);
    }
/*
    public String getAltitude() {
        return altitude.get();
    }

    public StringProperty altitudeProperty() {
        return altitude;
    }

    public void setAltitude(String altitude) {
        this.altitude.set(altitude);
    }

    public String getOrientation() {
        return orientation.get();
    }

    public StringProperty orientationProperty() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation.set(orientation);
    }*/

    public String getDate() {
        return date.get();
    }

    public StringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public String getHeure() {
        return heure.get();
    }

    public StringProperty heureProperty() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure.set(heure);
    }

    public void setDonnees(List<String> l){
        this.setDameuses(l.get(1));
        this.setLatitude(l.get(9));
        this.setLongitude(l.get(12));
        //this.setAltitude(l.get(3));
        //this.setOrientation(l.get(4));
        this.setDate(l.get(3));
        this.setHeure(l.get(6));
    }



}