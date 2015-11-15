import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 * Created by Fabienne_2 on 14/11/2015.
 */
public class Dameuse {


    private String nom;
    private Donnees donnees;
    private Path fichier;


    public String getNom(){
        return nom;
    }

    public Dameuse(String nom) throws IOException {
        this.nom = nom;
        Traitement t = new Traitement();
        this.donnees = new Donnees(t.traitement("0 0 0 0 0"));
        creationFichier(nom);
    }

    private void creationFichier(String nom) throws IOException {
        this.fichier = Paths.get("./src/Historiques/"+nom+".txt");
        String message = "Historique "+nom+" \n\n";
        Files.write(fichier,message.getBytes());
    }


    public void setDonnees(Donnees donnees) {
        this.donnees = donnees;
    }


    public Donnees getDonnees() {
        return donnees;
    }


    public void ecrireDansLhistorique () throws IOException {

        String message = this.toString()+"\n";
        Files.write(fichier,message.getBytes(), StandardOpenOption.CREATE,StandardOpenOption.WRITE,StandardOpenOption.APPEND);
    }

    public void lireLhistorique () throws IOException {

        List<String> ligne = Files.readAllLines(this.fichier);

        for (String l : ligne){
            System.out.println(l);
        }
    }

    @Override
    public String toString() {

        return "Dameuse "+ nom +" : "+ donnees.toString();
    }
}
