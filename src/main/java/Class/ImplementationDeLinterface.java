package Class;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ImplementationDeLinterface {

    @FXML
    TextField motCle;

    @FXML
    TableView<BeanDeDameuse> TableAffichageDonnees;

    @FXML
    TableColumn<BeanDeDameuse, String> ColoneDameuses;

    @FXML
    TableColumn<BeanDeDameuse, String> ColoneLongitude;

    @FXML
    TableColumn<BeanDeDameuse, String> ColoneLatitude;

    @FXML
    TableColumn<BeanDeDameuse, String> ColoneDate;

    @FXML
    TableColumn<BeanDeDameuse, String> ColoneHeure;

    @FXML
    public void initialize() throws IOException {
        setBeanRemplissage();
        ColoneDameuses.setCellValueFactory(param -> param.getValue().dameusesProperty());
        ColoneLongitude.setCellValueFactory(param -> param.getValue().longitudeProperty());
        ColoneLatitude.setCellValueFactory(param -> param.getValue().latitudeProperty());
        ColoneDate.setCellValueFactory(param -> param.getValue().dateProperty());
        ColoneHeure.setCellValueFactory(param -> param.getValue().heureProperty());
    }



    public void setBeanRemplissage() throws IOException {
        BeanRemplissage truc = new BeanRemplissage();
        ObservableList<BeanDeDameuse> temp = truc.getBeans();
        FilteredList<BeanDeDameuse> BeanTrie = new FilteredList<>(temp, p -> true);

        motCle.textProperty().addListener((observable, oldValue, newValue) -> {
            BeanTrie.setPredicate(beanDeDameusePredicate -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true; //tout les resultats
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (beanDeDameusePredicate.getDameuses().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter dameuse
                } else if (beanDeDameusePredicate.getDate().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter par date
                } else if (beanDeDameusePredicate.getHeure().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter par heure
                }
                return false; // aucun resultats
            });
        });

        SortedList<BeanDeDameuse> resultatBeanTrie = new SortedList<>(BeanTrie);

        resultatBeanTrie.comparatorProperty().bind(TableAffichageDonnees.comparatorProperty());

        TableAffichageDonnees.setItems(resultatBeanTrie);
    }

}
