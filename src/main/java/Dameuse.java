import java.util.HashMap;
import java.util.Map;

/**
 * Created by Fabienne_2 on 14/11/2015.
 */
public class Dameuse implements Cloneable{

    private String nom;
    private Donnees donnees;

    public String getNom() {
        return nom;
    }

    public Dameuse(String nom) {
        this.nom = nom;
        Traitement t = new Traitement();
        this.donnees = new Donnees(t.traitement("0 0 0 0 0"));
    }

    public void setDonnees(Donnees donnees) {
        this.donnees = donnees;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Dameuse clone(){
        Dameuse d = null;
        try {
            d = (Dameuse) super.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return  d;
    }

    @Override
    public String toString() {

        return "Dameuse "+ nom +" : "+ donnees.toString();
    }
}
