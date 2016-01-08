package Poubelle;

import javafx.fxml.FXML;

import java.io.IOException;

/**
 * Created by tatsu on 07/01/2016.
 */
public class MainController extends Class.ImplementationDeLinterface {

    @FXML
    private Class.ImplementationDeLinterface Controlleur;

    public void initialize() {

    }

    @FXML
    public void rafraichir() throws IOException {
        Controlleur.sousRafraichir();
    }
}
