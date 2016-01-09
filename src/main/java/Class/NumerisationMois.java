package Class;

import java.util.HashMap;
import java.util.Map;


public class NumerisationMois {
    private static NumerisationMois instance;

    private Map<String, String> mois;

    private NumerisationMois() {
        this.mois = new HashMap<String, String>();
        this.mois.put("Jan", "01");
        this.mois.put("Fev", "02");
        this.mois.put("Mar", "03");
        this.mois.put("Apr", "04");
        this.mois.put("May", "05");
        this.mois.put("Jun", "06");
        this.mois.put("Jul", "07");
        this.mois.put("Aug", "08");
        this.mois.put("Sep", "09");
        this.mois.put("Oct", "10");
        this.mois.put("Nov", "11");
        this.mois.put("Dev", "12");
    }

    public static synchronized NumerisationMois getInstance()
    {
        if (instance == null)
            instance = new NumerisationMois();

        return instance;
    }

    public String returnMois(String valeur){
        return this.mois.get(valeur);
    }
}

