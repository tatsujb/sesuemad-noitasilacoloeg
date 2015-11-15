import java.util.*;
import java.util.concurrent.CompletableFuture;
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
        executor.scheduleAtFixedRate(sendNewDameuseInfo, 0, 3, TimeUnit.SECONDS); //Nombre de secondes d'intervale d'éxcecution. ici 3


        sendNewDameuseInfo = new Runnable() {
            @Override
            public void run() {
                Simulateur.faireDonneesAlleatoires();
            }
        };

    }

    }
