package Class;

import javafx.fxml.FXML;

import java.io.IOException;

/**
 * Created by tatsu on 07/01/2016.
 */
public class MainController extends ImplementationDeLinterface{

    @FXML
    private ImplementationDeLinterface Controlleur;

    public void initialize() {

    }

    @FXML
    public void rafraichir() throws IOException {
        Controlleur.sousRafraichir();
    }
}
