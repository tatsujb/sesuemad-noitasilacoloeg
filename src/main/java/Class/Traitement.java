package Class;

import java.util.LinkedList;
import java.util.List;


/**
 * Created by tatsu on 13/11/2015.
 */
public class Traitement {

    public List<String> traitement(String p_message) {
        return separeLesDonnees(p_message);
    }

    public List<String> separeLesDonnees(String p_message) {
        List<String> donnees = new LinkedList<String>();
        String chaineTemporaire ="";

        for (int i=0; i<p_message.length(); i++) {
            if (p_message.charAt(i) == ' ') {
                donnees.add(chaineTemporaire);
                chaineTemporaire = "";
            } else {
                chaineTemporaire += p_message.charAt(i);
            }
        }
        donnees.add(chaineTemporaire);
        return donnees;
    }

    public void traitementEnCours(int tempsMilli) throws InterruptedException {
        System.out.println();
        Thread.sleep(tempsMilli);
        System.out.print("Traitement en cours.");
        Thread.sleep(tempsMilli);
        System.out.print(".");
        Thread.sleep(tempsMilli);
        System.out.println(".\n");
        Thread.sleep(tempsMilli);
        System.out.println();

    }


    public void afficheDameuseDisponible(LesDameuses lesDameuses) {
        System.out.println("Voici les dameuses qui ont été en mouvement : ");
        for (Dameuse d : lesDameuses.getLesDameuses()){
            System.out.println(d.getNom());

        }
    }


}
