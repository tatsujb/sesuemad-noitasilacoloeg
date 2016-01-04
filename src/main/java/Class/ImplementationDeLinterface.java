package Class;

import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

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

    /*private BeanRemplissage beanRemplissage;
    public ImplementationDeLinterface() throws IOException {

        beanRemplissage = new BeanRemplissage();
    }*/

    //http://code.makery.ch/blog/javafx-8-tableview-sorting-filtering/
    @FXML
    public void initialize() throws IOException {
        setBeanRemplissage(new BeanRemplissage());
        //FilteredList<BeanDeDameuse> filteredList = new FilteredList<>(beanRemplissage.getBeans(), p -> true);
        ColoneDameuses.setCellValueFactory(param -> param.getValue().dameusesProperty()); //param -> celldata
        ColoneLongitude.setCellValueFactory(param -> param.getValue().longitudeProperty());
        ColoneLatitude.setCellValueFactory(param -> param.getValue().latitudeProperty());
        //ColoneAltitude.setCellValueFactory(param -> param.getValue().altitudeProperty());
        //ColoneOrientation.setCellValueFactory(param -> param.getValue().orientationProperty());
        ColoneJour.setCellValueFactory(param -> param.getValue().jourProperty());
        ColoneHeure.setCellValueFactory(param -> param.getValue().heureProperty());


    }

    public void setBeanRemplissage(BeanRemplissage beanRemplissage) {
        // Add observable list data to the table
        TableAffichageDonnees.setItems(beanRemplissage.getBeans());
    }

    public void ActiverParJour(){

    }
}
