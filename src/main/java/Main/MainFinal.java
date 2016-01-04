package Main;

import Class.*;
import extra.SerialCommunication;
import gnu.io.RXTXCommDriver;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Fabienne_2 on 15/11/2015.
 */
public class MainFinal extends Application {


    private static boolean stop;

    public static void main(String[] args) throws IOException, InterruptedException {
        LesDameuses lesDameuses = new LesDameuses();
        Traitement traitement = new Traitement();

        SerialCommunication communicator = new SerialCommunication();
        communicator.connect();
        if (communicator.initIOStream() == true) {
            communicator.initListener();
        }
        System.out.println("Application launched");


        Thread thread = new Thread(() -> {
            while (!stop) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(communicator.getLastSMS());
                if (communicator.getLastSMS() != ".") {

                    //final int nbIncrementation = 2;

                    //  GenerateurDeMessage generateurDeMessage = new GenerateurDeMessage();


                    try {
                        simulationSMS(/*nbIncrementation,*/ communicator.getLastSMS(), lesDameuses, traitement);
                    } catch (IOException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }


                    traitement.afficheDameuseDisponible(lesDameuses);
                } else {
                    System.out.println("pas de message");
                }

                //fonctionne pas hors du while
       /*for (Dameuse d : lesDameuses.getLesDameuses()) {
            d.lireLhistorique();
            System.out.println();
        }*/
            }
        });
        thread.start();

        launch(args);
        stop = true;

        communicator.disconnect();
    }
    /*private static void choixHistorique(LesDameuses lesDameuses, Traitement traitement, int choix) throws InterruptedException, IOException {
        switch (choix){
            case 0:
                //oui
                //traitement.traitementEnCours(1000);
                traitement.afficheDameuseDisponible(lesDameuses);

                //traitement.traitementEnCours(1000);


                for (Dameuse d : lesDameuses.getLesDameuses()){
                    d.lireLhistorique();
                    System.out.println();
                }

                break;
            default :
                JOptionPane.showMessageDialog(null,"Merci de votre visite");
        }
    }*/

    private static void simulationSMS(/*int nbIncrementation,GenerateurDeMessage generateurDeMessage,*/String sms, LesDameuses lesDameuses, Traitement traitement) throws IOException, InterruptedException {
        int i = 0;

        // do {
        //String sms = generateurDeMessage.genereMessage();

        List<String> message = traitement.traitement(sms);
        Dameuse dameuse = new Dameuse(new Donnees(message));

        lesDameuses.ajouterDameuse(dameuse);
        System.out.println(lesDameuses);
        //i++;
        //Thread.sleep(1000);
        //} while (i < nbIncrementation);

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


}