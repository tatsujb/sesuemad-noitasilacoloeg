import java.io.IOException;

/**
 * Created by fabienne on 14/11/15.
 */
public class MainLesDameusesFiles {

    public static void main(String[] args) throws IOException, InterruptedException {

        Traitement t = new Traitement();
        Donnees donnees = new Donnees(t.traitement("489 12:50:45 674 233 dam1"));
        Dameuse dameuse1 = new Dameuse(donnees);
        Donnees donnees1 = new Donnees(t.traitement("111 11:12:31 222 222 dam2"));
        Dameuse dameuse2  = new Dameuse((donnees1));
        Donnees donnees3 = new Donnees(t.traitement("551 00:45:12 222 222 dam3"));
        Dameuse dameuse3  = new Dameuse(donnees3);

        LesDameuses lesDameuses = new LesDameuses();
        int tempsDameuse = 1000;
        int tempsTraitement = 1500;
        int tempsHistorique = 1800;
        lesDameuses.ajouterDameuse(dameuse1);
        Thread.sleep(tempsDameuse);
        lesDameuses.ajouterDameuse(dameuse2);
        Thread.sleep(tempsDameuse);
        lesDameuses.ajouterDameuse(dameuse3);
        Thread.sleep(tempsDameuse);
        lesDameuses.ajouterDameuse(dameuse1);
        Thread.sleep(tempsDameuse);
        dameuse1.setDonnees(new Donnees(t.traitement("999 14:15:56 999 999 dam1")));
        lesDameuses.ajouterDameuse(dameuse1);
        Thread.sleep(tempsDameuse);
        lesDameuses.ajouterDameuse(dameuse1);
        Thread.sleep(tempsDameuse);
        lesDameuses.ajouterDameuse(dameuse2);
        Thread.sleep(tempsDameuse);
        lesDameuses.ajouterDameuse(dameuse1);
        Thread.sleep(tempsDameuse);
        lesDameuses.ajouterDameuse(dameuse3);
        Thread.sleep(tempsTraitement);
        System.out.print("Traitement en cours.");
        Thread.sleep(tempsTraitement);
        System.out.print(".");
        Thread.sleep(tempsTraitement);
        System.out.println(".\n");
        Thread.sleep(tempsTraitement);

        dameuse1.lireLhistorique();
        System.out.println();
        Thread.sleep(tempsHistorique);
        dameuse2.lireLhistorique();
        System.out.println();
        Thread.sleep(tempsHistorique);
        dameuse3.lireLhistorique();

    }
}
