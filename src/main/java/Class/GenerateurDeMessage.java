package Class;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

/**
 * Created by Fabienne_2 on 16/11/2015.
 */
public class GenerateurDeMessage {

    public String genereMessage () {

        return getDate()+" "+getHeure()+" "+getLattitude()+" "+getLongitude()+" "+getIdentifiantDameuse();
    }

    private String getIdentifiantDameuse() {
        Random random = new Random();
        int i = random.nextInt(IdentifiantDameuse.values().length);
        return String.valueOf(IdentifiantDameuse.valueOf("DAM"+i)).toLowerCase();
    }

    private String getLongitude() {
        double d = - Math.random() * 9999;
        return Double.toString(d);
    }

    private String getLattitude() {
        double d = Math.random() * 9999;
        return Double.toString(d);

    }

    private String getHeure() {
        return new SimpleDateFormat("HH:mm:ss",Locale.FRANCE).format(new Date());
    }

    public String getDate() {
        return  new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE).format(new Date());
    }


}
