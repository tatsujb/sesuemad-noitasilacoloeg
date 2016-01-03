package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Class.*;

import java.io.IOException;
import java.util.List;

/**
 * Created by Fabienne_2 on 15/11/2015.
 */
public class MainFinal extends Application{

    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println("Application launched");
        launch(args);

        final int nbIncrementation = 2;
        Traitement traitement = new Traitement();
        GenerateurDeMessage generateurDeMessage = new GenerateurDeMessage();
        LesDameuses lesDameuses = new LesDameuses();


        simulationSMS(nbIncrementation, generateurDeMessage, lesDameuses, traitement);


        /*
        traitement.traitementEnCours(1000);
        traitement.afficheDameuseDisponible(lesDameuses);

        traitement.traitementEnCours(1000);
        */

        for (BeanDeDameuse d : lesDameuses.getLesBeanDeDameuses()){
            d.lireLhistorique();
            System.out.println();
        }
    }

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

    private static void simulationSMS(int nbIncrementation, GenerateurDeMessage generateurDeMessage, LesDameuses lesDameuses, Traitement traitement) throws IOException, InterruptedException {
        int i = 0;

        do {
            String sms = generateurDeMessage.genereMessage();
            List<String> message = traitement.traitement(sms);
            BeanDeDameuse dameuse = new BeanDeDameuse();

            lesDameuses.ajouterDameuse(dameuse);
            i++;
            Thread.sleep(1000);
        } while (i < nbIncrementation);

    }


    /*
    public static void main(String[] args) throws IOException, InterruptedException {

        final int nbIncrementation = 50;

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



*/
}