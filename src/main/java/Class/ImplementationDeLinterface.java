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

/**
 * Created by tatsu on 27/12/2015.
 */
public class ImplementationDeLinterface {

    @FXML
    TextField motCle;

    @FXML
    CheckBox ParJour;

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
    TableColumn<BeanDeDameuse, String> ColoneDate;

    @FXML
    TableColumn<BeanDeDameuse, String> ColoneHeure;

    /*private BeanRemplissage beanRemplissage;
    public ImplementationDeLinterface() throws IOException {

        beanRemplissage = new BeanRemplissage();
    }
    //http://stackoverflow.com/questions/32099724/javafx-tableview-doesnt-update-outside-of-initialize-method
    private final Model model ;

    public MainController(Model model) {
        this.model = model ;
    }*/



    //http://code.makery.ch/blog/javafx-8-tableview-sorting-filtering/
    @FXML
    public void initialize() throws IOException {
        setBeanRemplissage();
        //FilteredList<BeanDeDameuse> filteredList = new FilteredList<>(beanRemplissage.getBeans(), p -> true);
        ColoneDameuses.setCellValueFactory(param -> param.getValue().dameusesProperty()); //param -> celldata
        ColoneLongitude.setCellValueFactory(param -> param.getValue().longitudeProperty());
        ColoneLatitude.setCellValueFactory(param -> param.getValue().latitudeProperty());
        //ColoneAltitude.setCellValueFactory(param -> param.getValue().altitudeProperty());
        //ColoneOrientation.setCellValueFactory(param -> param.getValue().orientationProperty());
        ColoneDate.setCellValueFactory(param -> param.getValue().dateProperty());
        ColoneHeure.setCellValueFactory(param -> param.getValue().heureProperty());
    }



    public void setBeanRemplissage() throws IOException {
        BeanRemplissage truc = new BeanRemplissage();
        ObservableList<BeanDeDameuse> temp = truc.getBeans();
        FilteredList<BeanDeDameuse> BeanTrie = new FilteredList<>(temp, p -> true);


        //truc = motCle.addEventFilter(KeyEvent.KEY_TYPED, motCle.textProperty().addListener(t );//motCle(textField.getText().toString())); //new EventHandler<KeyEvent>(),
                /*new EventHandler<KeyEvent>() {
                    public void handle(KeyEvent) { null };
                });*/

        motCle.textProperty().addListener((observable, oldValue, newValue) -> {
            BeanTrie.setPredicate(beanDeDameusePredicate -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
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

    public void ActiverParJour() throws IOException {
        BeanRemplissage truc = new BeanRemplissage();
        ObservableList<BeanDeDameuse> temp = truc.getBeans();
        FilteredList<BeanDeDameuse> BeanTrie = new FilteredList<>(temp, p -> true);
        //boolean coche = false;
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String dateDuJour = dateFormat.format(date);
        ParJour.selectedProperty().addListener((observable, oldValue, newValue) -> {
            BeanTrie.setPredicate(beanDeDameusePredicate -> {
                if (newValue && beanDeDameusePredicate.getHeure().contains(dateDuJour)) {
                    return true;
                }
                return false;


            });
        });
        SortedList<BeanDeDameuse> resultatBeanTrie = new SortedList<>(BeanTrie);

        resultatBeanTrie.comparatorProperty().bind(TableAffichageDonnees.comparatorProperty());

        TableAffichageDonnees.setItems(resultatBeanTrie);

    }

    public void sousRafraichir() throws IOException {
        initialize();
    }


}
