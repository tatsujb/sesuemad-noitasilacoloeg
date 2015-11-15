import java.io.IOException;

/**
 * Created by fabienne on 14/11/15.
 */
public class MainOfficiel {

    public static void main(String[] args) throws IOException {

        Traitement t = new Traitement();
        Donnees donnees = new Donnees(t.traitement("125 489 674 233 479"));
        Dameuse dameuse1 = new Dameuse("dam1");
        dameuse1.setDonnees(donnees);
        Dameuse dameuse2  = dameuse1.clone();
        dameuse2.setNom("dam2");
        Donnees donnees1 = new Donnees(t.traitement("111 111 222 222 333"));
        dameuse2.setDonnees(donnees1);
        LesDameuses lesDameuses = new LesDameuses();
        lesDameuses.ajouterDameuse(dameuse1);
        lesDameuses.ajouterDameuse(dameuse2);
        dameuse1.ecrireDansLhistorique();
        System.out.println(lesDameuses);
    }
}
