import org.marre.SmsSender;
import org.marre.sms.SmsException;

/**
 * Created by Fabienne_2 on 14/11/2015.
 */
public class Dameuse implements Cloneable{
   public SmsSender smsSender = SmsSender.getClickatellSender("username", "password", "apiid");

    private String nom;
    private Donnees donnees;

   public void inititalize() throws IOException, SmsException {
        smsSender.connect();
    }

    public String getNom(){
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

    public Donnees getDonnees() {
        return donnees;
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
