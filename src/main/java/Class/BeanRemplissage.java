package Class;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
    public ObservableList<BeanDeDameuse> beans = FXCollections.observableArrayList();

    public BeanRemplissage() throws IOException {


        Traitement traitmnt = new Traitement();


        this.fichier = Paths.get("./src/Historiques/historiqueGeneral.txt");
        Scanner fic = new Scanner(fichier.toFile());
        fic.nextLine();
        fic.nextLine();
        do{
            int i =0;
            List<String> liste=traitmnt.traitement(fic.nextLine());
            if (liste.size()>5) {
                System.out.println(liste);

                BeanDeDameuse beanDeDameuse = new BeanDeDameuse();
                beanDeDameuse.setDonnees(liste);

                beans.add(beanDeDameuse);
                i++;
            }
        }while (fic.hasNextLine());
        System.out.println();
        fic.close();


    }



    public ObservableList<BeanDeDameuse> getBeans() {
        return beans;
    }
}