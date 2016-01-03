package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

import Class.*;

import javax.swing.*;

/**
 * Created by Fabienne_2 on 15/11/2015.
 */
public class MainFinal extends Application{


    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/interface.fxml"));
        fxmlLoader.load();
        Parent root = fxmlLoader.getRoot();
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }


    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Application launched");
        launch(args);
        final int nbIncrementation = 2;

        GenerateurDeMessage generateurDeMessage = new GenerateurDeMessage();
        LesDameuses lesDameuses = new LesDameuses();
        Traitement traitement = new Traitement();

        simulationSMS(nbIncrementation, generateurDeMessage, lesDameuses, traitement);

        Thread.sleep(3000);
        int choix = JOptionPane.showConfirmDialog(null,"Voulez-vous afficher l'historique des dameuses ?");

        choixHistorique(lesDameuses, traitement, choix);

    }

    private static void choixHistorique(LesDameuses lesDameuses, Traitement traitement, int choix) throws InterruptedException, IOException {
        switch (choix){
            case 0:
                //oui
                traitement.traitementEnCours(1000);
                traitement.afficheDameuseDisponible(lesDameuses);

                traitement.traitementEnCours(1000);


                for (Dameuse d : lesDameuses.getLesDameuses()){
                    d.lireLhistorique();
                    System.out.println();
                }

                break;
            default :
                JOptionPane.showMessageDialog(null,"Merci de votre visite");
        }
    }

    private static void simulationSMS(int nbIncrementation, GenerateurDeMessage generateurDeMessage, LesDameuses lesDameuses, Traitement traitement) throws IOException, InterruptedException {
        int i = 0;

        do {
            String sms = generateurDeMessage.genereMessage();
            List<String> message = traitement.traitement(sms);
            Dameuse dameuse = new Dameuse(new Donnees(message));

            lesDameuses.ajouterDameuse(dameuse);
            i++;
            Thread.sleep(1000);
        } while (i < nbIncrementation);

    }


}