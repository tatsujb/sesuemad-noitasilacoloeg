import java.io.IOException;

/**
 * Created by fabienne on 14/11/15.
 */
public class MainLesDameusesFiles {

    public static void main(String[] args) throws IOException {

        Traitement t = new Traitement();
        Donnees donnees = new Donnees(t.traitement("125 489 674 233 dam1"));
        Dameuse dameuse1 = new Dameuse(donnees);
        Donnees donnees1 = new Donnees(t.traitement("111 111 222 222 dam2"));
        Dameuse dameuse2  = new Dameuse((donnees1));
        Donnees donnees3 = new Donnees(t.traitement("555 551 222 222 dam3"));
        Dameuse dameuse3  = new Dameuse(donnees3);

        LesDameuses lesDameuses = new LesDameuses();
        lesDameuses.ajouterDameuse(dameuse1);
        lesDameuses.ajouterDameuse(dameuse2);
        lesDameuses.ajouterDameuse(dameuse3);
        lesDameuses.ajouterDameuse(dameuse1);
        lesDameuses.ajouterDameuse(dameuse1);
        lesDameuses.ajouterDameuse(dameuse1);
        lesDameuses.ajouterDameuse(dameuse2);
        lesDameuses.ajouterDameuse(dameuse1);
        lesDameuses.ajouterDameuse(dameuse3);

        dameuse1.lireLhistorique();
        System.out.println();
        dameuse2.lireLhistorique();
        System.out.println();
        dameuse3.lireLhistorique();
        System.out.println(lesDameuses.getLesDameuses().size());

    }
}
