import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by tatsu on 15/11/2015.
 */
public class Simulateur {

    //public rand
    private Random random = new Random();
    SimulateurVariables var = new SimulateurVariables(1,1,2015,0,10,0);



    //variables fixes pour la date randomisee
    private int day = 1;
    private int month = 1;
    private int year = 2015;
    //variables fixes pour l'heure randomisee
    private int seconde = 0;
    private int minute = 0;
    private int heure = 0;

    private int MXsecondes = 60;
    private int MXminutes = 60;
    private int MXheures = 12;

    private int MXdays = 30;
    private int MXmonths = 12;
    private int MXyears = 2090;
    //variables randomisees pour la latitude
    private double minLat = -90;
    private double maxLat = +90;
    //variables randomisees pour la longitude
    private double minLon = -180;
    private double maxLon = +180;

    public ArrayList<Dameuse> listeDameuses = new ArrayList<Dameuse>(); //liste de dammeuses on pourrai aussi randomiser leur nombre mais ici on teste avec 3

    public String dateAlleatoire(){
        String ladate = ""; //00/00/00
        String sday = "01";
        String smonth = "01";
        if(day < MXdays){
            day = random.nextInt(MXdays);
        } else if(month < MXmonths){
            month = random.nextInt(MXmonths);
        }else{
            year = random.nextInt(MXyears);
        }
        if (day < 10){
            sday.format("%01d", day);
        }else{
            sday = String.valueOf(day);
        }
        if (month < 10){
            smonth.format("%01d", month);
        }else{
            smonth = String.valueOf(month);
        }

        return ladate.concat(sday +"/"+ smonth +"/"+ year);
    }

    public String heureAlleatoire(){
        String lheure = ""; //00:00:00
        String sseconde = "00";
        String sminute = "00";
        String sheure = "00";
        if(heure == MXheures){
            int seconde = 0;
            int minute = 0;
            int heure = 0;
        }else if(seconde < MXsecondes){
            seconde = random.nextInt(MXsecondes);
        }else if(minute < MXminutes){
            minute = random.nextInt(MXminutes);
        }else{
        heure = random.nextInt(MXheures);
        }
        if (seconde < 10){
            sseconde.format("%01d", seconde);
        }else{
            sseconde = String.valueOf(seconde);
        }
        if (minute < 10){
            sminute.format("%01d", minute);
        }else{
            sminute = String.valueOf(minute);
        }
        if (heure < 10){
            sheure.format("%01d", heure);
        }else{
            sheure = String.valueOf(heure);
        }

        return lheure.concat(sheure +":"+ sminute +":"+ sseconde);
    }

    public double latitudeAlleatoire(){
        return (minLat + (maxLat - minLat) * random.nextDouble());
    }

    public double longitureAlleatoire(){
        return (minLon + (maxLon - minLon) * random.nextDouble());
    }

    public void faireDonneesAlleatoires() throws IOException{
        Dameuse d1 = new Dameuse("DAM01");
        Dameuse d2 = new Dameuse("DAM02");
        Dameuse d3 = new Dameuse("DAM03");
        listeDameuses.add(d1);
        listeDameuses.add(d2);
        listeDameuses.add(d3);
        Dameuse DameuseRandom = listeDameuses.get((int) Math.random() * listeDameuses.size()); //choisi all�atoirement parmis les dameuses quel que soit leur nombre
        Traitement simTraitement = new Traitement();
        Donnees donnees = new Donnees(simTraitement.traitement(dateAlleatoire()+" "+heureAlleatoire()+" "+ latitudeAlleatoire() + " " + latitudeAlleatoire() + " " + DameuseRandom.getNom()));  //leur attribue des donn�es all�atoires
        DameuseRandom.setDonnees(donnees);
        System.out.println(donnees.toString());

    }

}
