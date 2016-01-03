package Class;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Fabienne_2 on 14/11/2015.
 */
public class LesDameuses {

    private Map<String,BeanDeDameuse> lesBeanDeDameuses;

    public LesDameuses() {
        this.lesDameuses = new HashMap<String, BeanDeDameuse>();
    }

    public void ajouterBeanDeDameuse (BeanDeDameuse p_dameuse) throws IllegalArgumentException, IOException {
        if (p_dameuse == null)
            throw new IllegalArgumentException("Paramètre invalide, dameuse erronée");

        this.lesBeanDeDameuses.put(p_dameuse.getDameuses(),p_dameuse);
        p_dameuse.ecrireDansLhistorique();

        Date date = new Date();
        String dateCourante  = new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE).format(date);

        String heureCourante = new SimpleDateFormat("HH:mm:ss",Locale.FRANCE).format(date);

        System.out.println(dateCourante+" : message reçu à "+heureCourante+" "+p_dameuse.getDameuses());


    }


    public Collection<BeanDeDameuse> getLesBeanDeDameuses() {
        return lesBeanDeDameuses.values();
    }

    @Override
    public String toString() {
        String resultat = "";
        for (BeanDeDameuse d : this.lesBeanDeDameuses.values()){
            resultat += d.toString()+"\n";
        }
        return resultat;
    }
}
