package Class;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CompletionStage;

/**
 * Created by tatsu on 27/12/2015.
 */
public class BeanReplissage {

    private Path fichier;



    public Remplir() throws IOException {

        BeanDeDameuse truc = new BeanDeDameuse();
        Traitement trait = new Traitement();
        List<String> liste;

        Scanner fic = new Scanner(fichier.toFile());
        do{
            System.out.println(fic.nextLine());
            liste=trait.separeLesDonnees(fic.nextLine());
            truc.setDonnees(liste);
        }while (fic.hasNextLine());
        fic.close();



    }
}
