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


        this.fichier = Paths.get("./src/Historiques/dam0.txt");
        Scanner fic = new Scanner(fichier.toFile());
        fic.nextLine();
        fic.nextLine();
        do{
            List<String> liste=traitmnt.traitement(fic.nextLine());
            if (!liste.isEmpty() || liste.get(0)==" ") {
                System.out.println(liste);
                bean.setDonnees(liste);
            }
        }while (fic.hasNextLine());
        System.out.println();
        fic.close();

    }
}
