import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by tatsu on 15/11/2015.
 */
public class MainSimulateur {

    public static void main(String[] args) {

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        Runnable sendNewDameuseInfo = null;

        sendNewDameuseInfo = new Runnable() {
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
        executor.scheduleAtFixedRate(sendNewDameuseInfo, 0, 3, TimeUnit.SECONDS); //Nombre de secondes d'intervale d'�xcecution. ici 3
    }
}
