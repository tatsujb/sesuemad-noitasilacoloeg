package Class;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;


/**
 * Created by tatsu on 27/12/2015.
 */
public class BeanRemplissage {

    private Path fichier;

    public void Remplir() throws IOException {

        BeanDeDameuse bean = new BeanDeDameuse();
        Traitement traitmnt = new Traitement();
        List<String> liste;

        this.fichier = Paths.get("./src/Historiques/dam0.txt");
        Scanner fic = new Scanner(fichier.toFile());
        do{
            System.out.println(fic.nextLine());
            liste=traitmnt.separeLesDonnees(fic.nextLine());
            bean.setDonnees(liste);
        }while (fic.hasNextLine());
        fic.close();




    }
}
