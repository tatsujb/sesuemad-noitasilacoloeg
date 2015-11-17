import java.io.IOException;

/**
 * Created by tatsu on 15/11/2015.
 */
public class MainSimulateur {

    public static void main(String[] args) throws IOException {

        //                                               Jour mois annee seconde minute heure
        SimulateurVariables var = new SimulateurVariables(16   ,11   ,2015    ,0    ,30     ,12);
        //SimulateurVariables var = new SimulateurVariables(0   ,0   ,2015    ,2    ,0     ,0);
        Donnees.Simulateur simulateur = new Donnees.Simulateur();

        /*ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        Runnable sendNewDameuseInfo = null;

        sendNewDameuseInfo = new Runnable() {
            @Override
            public void run() {


                try {*/
        //             nombre de lignes simulees a generer
        for (int i = 0; i < 25; i++) {
            //                       nombre de dameuses actives
            simulateur.faireDonneesAlleatoires(5);
        }


                /*} catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        executor.scheduleAtFixedRate(sendNewDameuseInfo, 0, 1, TimeUnit.SECONDS);*/ //Nombre de secondes d'intervale d'excecution. ici 3

    }
}
