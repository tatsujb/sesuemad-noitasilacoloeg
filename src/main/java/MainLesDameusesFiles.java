import java.io.IOException;

/**
 * Created by fabienne on 14/11/15.
 */
public class MainLesDameusesFiles {

    public static void main(String[] args) throws IOException {

        Traitement t = new Traitement();
        Donnees donnees = new Donnees(t.traitement("125 489 674 233 479"));
        Dameuse dameuse1 = new Dameuse("dam1");
        dameuse1.setDonnees(donnees);
        Dameuse dameuse2  = new Dameuse(("dam2"));
        Donnees donnees1 = new Donnees(t.traitement("111 111 222 222 333"));
        dameuse2.setDonnees(donnees1);
        Dameuse dameuse3  = new Dameuse(("dam3"));
        Donnees donnees3 = new Donnees(t.traitement("555 551 222 222 333"));
        dameuse3.setDonnees(donnees3);

        LesDameuses lesDameuses = new LesDameuses();
        lesDameuses.ajouterDameuse(dameuse1);
        lesDameuses.ajouterDameuse(dameuse2);
        lesDameuses.ajouterDameuse(dameuse3);


        int i = 0;
        do {
            dameuse1.ecrireDansLhistorique();
            dameuse2.ecrireDansLhistorique();
            i++;
        }while (i <5);
        System.out.println(lesDameuses);
    }
}
