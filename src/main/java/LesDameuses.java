
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

    public void ajouterDameuse (Dameuse p_dameuse) throws IllegalArgumentException{
        if (p_dameuse == null)
            throw new IllegalArgumentException("Paramètre invalide, dameuse erronée");

        try {
            this.lesDameuses.put(p_dameuse.getNom(),p_dameuse);
        } catch (Exception exeception){
            //nom de la bonne exception à chercher
            System.out.println("La dameuse existe déjà !!");
        }
    }
}
