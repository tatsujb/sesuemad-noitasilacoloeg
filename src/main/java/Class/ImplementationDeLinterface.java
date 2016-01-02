package Class;

import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.List;

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

    private List<BeanDeDameuse> BeanDeDameuse;

    private FilteredList<BeanDeDameuse> filteredList;

    public ImplementationDeLinterface() {
        System.out.println("Interface instantiated");
    }

    @FXML
    public void initialize() {
        ColoneDameuses.setCellValueFactory(param -> param.getValue().dameusesProperty());
        ColoneLongitude.setCellValueFactory(param -> param.getValue().longitudeProperty());
        ColoneLatitude.setCellValueFactory(param -> param.getValue().latitudeProperty());
        //ColoneAltitude.setCellValueFactory(param -> param.getValue().altitudeProperty());
        //ColoneOrientation.setCellValueFactory(param -> param.getValue().orientationProperty());
        ColoneJour.setCellValueFactory(param -> param.getValue().jourProperty());
        ColoneHeure.setCellValueFactory(param -> param.getValue().heureProperty());
    }

    public void setUpIfNecessary() throws NullPointerException{
        if (BeanDeDameuse != null) {

        }

/*
        BeanReplissage.Remplir().thenAccept(BeanDeDameuse1 -> {
            if(ImplementationDeLinterface.this.BeanDeDameuse = NULL){
                throw new NullPointerException("woops!");
            }else{
            ImplementationDeLinterface.this.BeanDeDameuse = (List)BeanDeDameuse1;
            filteredList = new FilteredList<>(observableArrayList((List)BeanDeDameuse1));
            TableAffichageDonnees.setItems(filteredList);
            }
        });*/
    }

}
