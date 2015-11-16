import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

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

    public Dameuse(Donnees donnees) throws IOException {
        this.nom = donnees.getIdentifiantDameuse();
        Traitement t = new Traitement();
        this.setDonnees(donnees);
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

         Scanner fic = new Scanner(fichier.toFile());
        do{
            System.out.println(fic.nextLine());
        }while (fic.hasNextLine());
    }

    @Override
    public String toString() {

        return "Dameuse "+ nom +" : "+ donnees.toString();
    }
}
