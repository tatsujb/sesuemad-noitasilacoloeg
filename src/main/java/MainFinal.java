import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Fabienne_2 on 15/11/2015.
 */
public class MainFinal {

    private static int COMPTEUR = 0;

    public static void main(String[] args) throws IOException {

        //final SimulateurVariables var = new SimulateurVariables(16   ,11   ,2015    ,0    ,30     ,12);
        final Simulateur simulateur = new Simulateur(/*var*/);
        final Traitement traitement = new Traitement();
        final LesDameuses lesDameuses = new LesDameuses();
        final int ARRET = 5;

        final ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        Runnable sendNewDameuseInfo = null;

        sendNewDameuseInfo = new Runnable() {
            @Override
            public void run() {
                try {

                    String message = simulateur.faireDonneesAlleatoires(25);
                    Donnees donnees = new Donnees(traitement.traitement(message));
                    Dameuse dameuse = new Dameuse(donnees);
                    dameuse.setDonnees(donnees);
                    System.out.println(dameuse.toString());
                    dameuse.ecrireDansLhistorique();
                    lesDameuses.ajouterDameuse(dameuse);

                    if (COMPTEUR == ARRET)
                         executor.shutdown();

                    COMPTEUR++;

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        executor.scheduleAtFixedRate(sendNewDameuseInfo, 0, 1, TimeUnit.SECONDS); //Nombre de secondes d'intervale d'excecution. ici 3

        for (Dameuse d : lesDameuses.getLesDameuses().values()){
            d.lireLhistorique();
        }
        System.out.print(lesDameuses.getLesDameuses().values().size());
    }
}
