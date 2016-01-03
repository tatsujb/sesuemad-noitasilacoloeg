package Class;

import java.io.File;
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


    private Donnees donnees;
    private Path fichier;

    public String getNom(){
        return donnees.getIdentifiantDameuse();
    }


    public Dameuse(Donnees donnees) throws IOException {
        this.setDonnees(donnees);
        creationFichier(this.getNom());
    }

    private void creationFichier(String nom) throws IOException {

        File fich = new File("./src/Historiques");
        if (!fich.exists()) {
            fich.mkdir();
        }

        this.fichier = Paths.get("./src/Historiques/" + nom + ".txt");
        String message = "";
        Files.write(fichier, message.getBytes(),StandardOpenOption.CREATE,StandardOpenOption.WRITE,StandardOpenOption.APPEND);

        fich = new File("./src/Historiques/" + nom + ".txt");
        if (fich.length() == 0){
            initialiserFichier();
        }
    }


    public void setDonnees(Donnees donnees) {
        this.donnees = donnees;
    }


    public Donnees getDonnees() {
        return donnees;
    }


    public void ecrireDansLhistorique () throws IOException {

        String message = this.toString()+"\r\n";
        Files.write(fichier,message.getBytes(), StandardOpenOption.CREATE,StandardOpenOption.WRITE,StandardOpenOption.APPEND);
    }

    public void initialiserFichier () throws IOException {

        String message = "Historique " + this.getNom() + " \r\n\r\n";
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

        return "Dameuse "+ this.getNom() +" : "+ donnees.toString()+"\r\n";
    }
}
