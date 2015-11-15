import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by Fabienne_2 on 14/11/2015.
 */
public class Dameuse implements Cloneable{


    private String nom;
    private Donnees donnees;
    private Path fichier;


    public String getNom(){
        return nom;
    }

    public Dameuse(String nom) {
        this.fichier = Paths.get("./Historique/"+nom+".txt");
        //Files.write(fichier,)
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


    public void ecrireDansLhistorique () throws IOException {

        Files.write(fichier,this.toString().getBytes(), StandardOpenOption.CREATE,StandardOpenOption.WRITE,StandardOpenOption.APPEND);
    }

    @Override
    public String toString() {

        return "Dameuse "+ nom +" : "+ donnees.toString();
    }
}
