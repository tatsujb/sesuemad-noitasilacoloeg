package Class;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Fabienne_2 on 14/11/2015.
 */
public class LesDameuses {

    private Map<String,BeanDeDameuse> lesDameuses;

    public LesDameuses() {
        this.lesDameuses = new HashMap<String, BeanDeDameuse>();
    }

    public void ajouterBeanDeDameuse (BeanDeDameuse p_dameuse) throws IllegalArgumentException, IOException {
        if (p_dameuse == null)
            throw new IllegalArgumentException("Paramètre invalide, dameuse erronée");

        this.lesDameuses.put(p_dameuse.getDameuses(),p_dameuse);
        p_dameuse.ecrireDansLhistorique();

        String adresseFichier="./src/Historiques/historiqueGeneral.txt";
        File fich = new File(adresseFichier);
        Path fichier = Paths.get(adresseFichier);

        if (!fich.exists()){
            String message = "Historique Général\r\n\r\n";
            Files.write(fichier,message.getBytes(), StandardOpenOption.CREATE,StandardOpenOption.WRITE,StandardOpenOption.APPEND);
        }

        Files.write(fichier,p_dameuse.toString().getBytes(), StandardOpenOption.CREATE,StandardOpenOption.WRITE,StandardOpenOption.APPEND);

        Date date = new Date();
        String dateCourante  = new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE).format(date);

        String heureCourante = new SimpleDateFormat("HH:mm:ss",Locale.FRANCE).format(date);

        System.out.println(dateCourante+" : message reçu à "+heureCourante+" "+p_dameuse.getDameuses());


    }


    public Collection<BeanDeDameuse> getLesBeanDeDameuses() {
        return lesDameuses.values();
    }

    @Override
    public String toString() {
        String resultat = "";
        for (BeanDeDameuse d : this.lesDameuses.values()){
            resultat += d.toString()+"\n";
        }
        return resultat;
    }
}
