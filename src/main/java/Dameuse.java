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

    // Fabienne : Apres moultes tentatives j'entervient ici mais en commentaire de suggestion
    // comme ca il n'y aurra aucune atteinte a ton code.
    //
    // Je comprends que l'on doit ne pas perdre les donnees generes
    // et que cest ce qu'il arrive chaque fois qu'une donnee-Dameuse dans le code de hier soir est
    // genere mais il est imperatif de laisser faireDonneesAlleatoires en void de maniere
    // a preserver sa heute fonctionalite
    // sans quoi on ne peut plus lui donner un sens logique : il se mordrait forcement la queue
    // (vois par toi-meme)
    // donc
    // je propose de remmettre l'in de Dameuse en String (eh oui!) le nom pourra etre resolu par un simple Dameuse.getNom
    // et de faire passer les donnees dans une sous-classe (a se moment la; il en
    // imcombe de la responsabilité de Simulateur d'envoyer donnees (un simple Dameuse.setDonnees)
    // Je trouve que cette implementation serait
    // Comment dire...
    // INFINIMENT
    // ...preferable a ce a quoi je dois actuellement me confronter
    // tu ne penses-pas? :P :)

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
        fic.close();
    }

    @Override
    public String toString() {

        return "Dameuse "+ nom +" : "+ donnees.toString();
    }
}
