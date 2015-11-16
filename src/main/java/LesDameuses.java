
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Fabienne_2 on 14/11/2015.
 */
public class LesDameuses {

    private Map<String,Dameuse> lesDameuses;

    public LesDameuses() {
        this.lesDameuses = new HashMap<String, Dameuse>();
    }

    public void ajouterDameuse (Dameuse p_dameuse) throws IllegalArgumentException, IOException {
        if (p_dameuse == null)
            throw new IllegalArgumentException("Paramètre invalide, dameuse erronée");

            this.lesDameuses.put(p_dameuse.getNom(),p_dameuse);
            p_dameuse.ecrireDansLhistorique();
            System.out.println("message reçu");

    }


    public Map<String, Dameuse> getLesDameuses() {
        return lesDameuses;
    }

    @Override
    public String toString() {
        String resultat = "";
        for (Dameuse d : this.lesDameuses.values()){
            resultat += d.toString()+"\n";
        }
        return resultat;
    }
}
