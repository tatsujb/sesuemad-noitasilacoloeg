import java.io.IOException;

/**
 * Created by tatsu on 15/11/2015.
 */
public class MainSimulateur {

    public static void main(String[] args) throws IOException {

      /*  ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        Runnable sendNewDameuseInfo = new Runnable() {
            @Override
            public void run() {
                Simulateur simulateur = new Simulateur();
                try {
                    simulateur.faireDonneesAlleatoires();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        executor.scheduleAtFixedRate(sendNewDameuseInfo, 0, 3, TimeUnit.SECONDS); //Nombre de secondes d'intervale d'excecution. ici 3*/

        Simulateur simulateur = new Simulateur();
        int i = 0;
        while (i <29){
            simulateur.faireDonneesAlleatoires();
            i++;
        }

    }
}
