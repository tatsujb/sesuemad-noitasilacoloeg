import java.io.IOException;

/**
 * Created by tatsu on 15/11/2015.
 */
public class MainSimulateur {

    public static void main(String[] args) throws IOException {

      /*  final SimulateurVariables var = new SimulateurVariables(1,1,2015,0,0,0);

        final Simulateur simulateur = new Simulateur(var);

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        Runnable sendNewDameuseInfo = null;

        sendNewDameuseInfo = new Runnable() {
            @Override
            public void run() {

                try {
                    simulateur.faireDonneesAlleatoires();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        executor.scheduleAtFixedRate(sendNewDameuseInfo, 0, 1, TimeUnit.SECONDS); //Nombre de secondes d'intervale d'excecution. ici 3

    }*/

        Simulateur simulateur = new Simulateur();
        int i = 0;
        while (i <29){
            simulateur.faireDonneesAlleatoires();
            i++;
        }

    }
}
