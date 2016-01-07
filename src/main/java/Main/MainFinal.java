package Main;

import Class.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

/**
 * Created by Fabienne_2 on 15/11/2015.
 */
public class MainFinal extends Application {


    private static boolean stop;

    public static void main(String[] args) throws IOException, InterruptedException {
        MainController main = new MainController();
        ImplementationDeLinterface impl = new ImplementationDeLinterface();
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
                String sms=communicator.getLastSMS();
                if (sms != ".") {

                    System.out.println(sms);

                    List<String> message = traitement.traitement(sms);
                    Dameuse dameuse = null;
                    try {
                        dameuse = new Dameuse(new Donnees(message));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    try {
                        lesDameuses.ajouterDameuse(dameuse);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    //System.out.println(lesDameuses);
                    traitement.afficheDameuseDisponible(lesDameuses);
                }
            }
        });
        thread.start();

        launch(args);

        stop = true;

        communicator.disconnect();
    } //  JOptionPane.showMessageDialog(null,"Merci de votre visite");

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/mainControler.fxml"));
        fxmlLoader.load();
        //messageViewController= (MessageViewController) fxmlLoader.getController();
        Parent root = fxmlLoader.getRoot();
        Stage stage = new Stage();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();


    }


}