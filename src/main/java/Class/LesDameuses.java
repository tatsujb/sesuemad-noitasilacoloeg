package Class;

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

    private Map<String,Dameuse> lesDameuses;

    public LesDameuses() {
        this.lesDameuses = new HashMap<String, Dameuse>();
    }

    public void ajouterDameuse (Dameuse p_dameuse) throws IllegalArgumentException, IOException {
        if (p_dameuse == null)
            throw new IllegalArgumentException("Paramètre invalide, dameuse erronée");


            Path fichier = Paths.get("./src/historiques.txt");
            Files.write(fichier,p_dameuse.toString().getBytes(), StandardOpenOption.CREATE,StandardOpenOption.WRITE,StandardOpenOption.APPEND);


            Date date = new Date();
            String dateCourante  = new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE).format(date);

            String heureCourante = new SimpleDateFormat("HH:mm:ss",Locale.FRANCE).format(date);

            System.out.println(dateCourante+" : message reçu à "+heureCourante+" "+p_dameuse.getNom());


    }


    public Collection<Dameuse> getLesDameuses() {
        return lesDameuses.values();
    }

    @Override
    public String toString() {
        String resultat = "";
        for (Dameuse d : this.lesDameuses.values()){
            resultat += d.toString()+"\n";
        }
        return resultat;
    }
}
