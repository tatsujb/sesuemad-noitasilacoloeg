package Class;

import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import static javafx.collections.FXCollections.observableArrayList;

/**
 * Created by tatsu on 27/12/2015.
 */
public class ImplementationDeLinterface {

    @FXML
    TableView<BeanDeDameuse> TableAffichageDonnees;

    @FXML
    TableColumn<BeanDeDameuse, String> ColoneDameuses;

    @FXML
    TableColumn<BeanDeDameuse, String> ColoneLongitude;

    @FXML
    TableColumn<BeanDeDameuse, String> ColoneLatitude;

    //@FXML
    //TableColumn<BeanDeDameuse, String> ColoneAltitude;

    //@FXML
    //TableColumn<BeanDeDameuse, String> ColoneOrientation;

    @FXML
    TableColumn<BeanDeDameuse, String> ColoneJour;

    @FXML
    TableColumn<BeanDeDameuse, String> ColoneHeure;

    private List<BeanDeDameuse> beanDeDameuses;

    private FilteredList<BeanDeDameuse> filteredList;

    public ImplementationDeLinterface() {
        System.out.println("Interface instantiated");
    }

    private Path fichier;

    @FXML
    public void initialize(BeanDeDameuse beann) throws IOException {
        ColoneDameuses.setCellValueFactory(param -> param.getValue().dameusesProperty());
        ColoneLongitude.setCellValueFactory(param -> param.getValue().longitudeProperty());
        ColoneLatitude.setCellValueFactory(param -> param.getValue().latitudeProperty());
        //ColoneAltitude.setCellValueFactory(param -> param.getValue().altitudeProperty());
        //ColoneOrientation.setCellValueFactory(param -> param.getValue().orientationProperty());
        ColoneJour.setCellValueFactory(param -> param.getValue().jourProperty());
        ColoneHeure.setCellValueFactory(param -> param.getValue().heureProperty());
        TableAffichageDonnees.getItems().setAll(mettreLesDonnees());
    }

    public void setUpIfNecessary() throws NullPointerException, IOException {
        if (beanDeDameuses != null) {

        }
    }

    private BeanDeDameuse mettreLesDonnees() throws IOException {
        BeanRemplissage BR = new BeanRemplissage();
        BR.Remplir();

        return BR.Remplir();
    }

}
