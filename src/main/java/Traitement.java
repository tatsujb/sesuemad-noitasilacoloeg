import java.util.LinkedList;
import java.util.List;

/**
 * Created by tatsu on 13/11/2015.
 */
public class Traitement {

    public List<String> traitement(String p_message) {

        return separeLesDonnees(p_message);
    }

    private List<String> separeLesDonnees(String p_message) {
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


}
