package Class;


/*import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;*/
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;

/**
 * Created by tatsu on 27/12/2015.
 */
public class BeanDeDameuse {

    private StringProperty dameuses;
    private StringProperty longitude;
    private StringProperty latitude;
    //private StringProperty altitude;
    //private StringProperty orientation;
    private StringProperty jour;
    private StringProperty heure;

    private Path fichier;

    public BeanDeDameuse() {
        dameuses = new SimpleStringProperty();
        longitude = new SimpleStringProperty();
        latitude = new SimpleStringProperty();
        //altitude = new SimpleStringProperty();
        //orientation = new SimpleStringProperty();
        jour = new SimpleStringProperty();
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

    public String getJour() {
        return jour.get();
    }

    public StringProperty jourProperty() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour.set(jour);
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
        this.setDameuses(l.get(0));
        this.setLongitude(l.get(2));
        this.setLatitude(l.get(1));
        //this.setAltitude(l.get(3));
        //this.setOrientation(l.get(4));
        this.setJour(l.get(5));
        this.setHeure(l.get(6));
    }

    private void creationFichier(String nom) throws IOException {

        File fich = new File("./src/Historiques");
        if (!fich.exists()) {
            fich.mkdir();
        }

        this.fichier = Paths.get("./src/Historiques/" + nom + ".txt");
        String message = "";
        Files.write(fichier, message.getBytes(), StandardOpenOption.CREATE,StandardOpenOption.WRITE,StandardOpenOption.APPEND);

        fich = new File("./src/Historiques/" + nom + ".txt");
        if (fich.length() == 0){
            initialiserFichier();
        }
    }



    public void ecrireDansLhistorique () throws IOException {

        String message = this.toString()+"\n";
        Files.write(fichier,message.getBytes(), StandardOpenOption.CREATE,StandardOpenOption.WRITE,StandardOpenOption.APPEND);
    }

    public void initialiserFichier () throws IOException {

        String message = "Historique " + this.getDameuses() + " \n\n";
        Files.write(fichier,message.getBytes(), StandardOpenOption.CREATE,StandardOpenOption.WRITE,StandardOpenOption.APPEND);
    }

    public void lireLhistorique () throws IOException {

        Scanner fic = new Scanner(fichier.toFile());
        do{
            System.out.println(fic.nextLine());
        }while (fic.hasNextLine());
        fic.close();
    }

    @Override
    public String toString() {
        return "BeanDeDameuse{" +
                "dameuses=" + dameuses +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", jour=" + jour +
                ", heure=" + heure +
                '}';
    }
}