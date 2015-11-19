package Main;

import Class.*;

import javax.swing.*;
import java.io.IOException;
import java.util.List;

/**
 * Created by Fabienne_2 on 15/11/2015.
 */
public class MainFinal {

    public static void main(String[] args) throws IOException, InterruptedException {

        final int nbIncrementation = 10;

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