import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by tatsu on 15/11/2015.
 */
public class MainSimulateur {

    public static void main(String[] args) {
        final Simulateur simulateur = new Simulateur();

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
        executor.scheduleAtFixedRate(sendNewDameuseInfo, 0, 3, TimeUnit.SECONDS); //Nombre de secondes d'intervale d'excecution. ici 3

    }
}
