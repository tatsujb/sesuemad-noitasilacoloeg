import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by tatsu on 15/11/2015.
 */
public class Simulateur {

    //public rand


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

    private ArrayList<Dameuse> listeDameuses = new ArrayList<Dameuse>(); //liste de dammeuses on pourrai aussi randomiser leur nombre mais ici on teste avec 3



    private SimulateurVariables var;
    public Simulateur(){
        this.var = new SimulateurVariables(1,1,2015,0,0,0);
    }

    public String dateAlleatoire(){
        Random rand1 = new Random();
        String ladate = ""; //00/00/00
        String sday = "01";
        String smonth = "01";
        if(var.getDay() < MXdays){
            var.setDay(rand1.nextInt(MXdays));
        } else if(var.getMonth() < MXmonths){
            var.setDay(rand1.nextInt(MXmonths));
        }else{
            var.setDay(rand1.nextInt(MXyears));
        }

        if (var.getDay() < 10){
            sday.format("%01d", var.getDay());
        }else{
            sday = String.valueOf(var.getDay());
        }
        if (var.getMonth() < 10){
            smonth.format("%01d", var.getMonth());
        }else{
            smonth = String.valueOf(var.getMonth());
        }
        return ladate.concat(sday +"/"+ smonth +"/"+ var.getYear());
    }

    public String heureAlleatoire(){
        Random rand2 = new Random();
        String lheure = ""; //00:00:00
        String sseconde = "00";
        String sminute = "00";
        String sheure = "00";
        if(var.getHeure() == MXheures){
            int seconde = 0;
            int minute = 0;
            int heure = 0;
        }else if(var.getSeconde() < MXsecondes){
            var.setSeconde(rand2.nextInt(MXsecondes));
        }else if(var.getMinute() < MXminutes){
            var.setMinute(rand2.nextInt(MXminutes));
        }else{
        var.setHeure(rand2.nextInt(MXheures));
        }
        if (var.getSeconde() < 10){
            sseconde.format("%01d", var.getSeconde());
        }else{
            sseconde = String.valueOf(var.getSeconde());
        }
        if (var.getMinute() < 10){
            sminute.format("%01d", var.getMinute());
        }else{
            sminute = String.valueOf(var.getMinute());
        }
        if (var.getHeure() < 10){
            sheure.format("%01d", var.getHeure());
        }else{
            sheure = String.valueOf(var.getHeure());
        }

        return lheure.concat(sheure +":"+ sminute +":"+ sseconde);
    }

    public double latitudeAlleatoire(){
        Random rand3 = new Random();
        return (minLat + (maxLat - minLat) * rand3.nextDouble());
    }

    public double longitureAlleatoire(){
        Random rand4 = new Random();
        return (minLon + (maxLon - minLon) * rand4.nextDouble());
    }

    public String faireDonneesAlleatoires() throws IOException{
        Random rand5 = new Random();
        Traitement simTraitement = new Traitement();
        Dameuse d1 = new Dameuse(new Donnees(simTraitement.traitement("0 0 0 0 dam1")));
        Dameuse d2 = new Dameuse(new Donnees(simTraitement.traitement("0 0 0 0 dam2")));
        Dameuse d3 = new Dameuse(new Donnees(simTraitement.traitement("0 0 0 0 dam3")));
        listeDameuses.add(d1);
        listeDameuses.add(d2);
        listeDameuses.add(d3);
        Dameuse DameuseRandom = listeDameuses.get(rand5.nextInt(3)); //choisi all�atoirement parmis les dameuses quel que soit leur nombre

        Donnees donnees = new Donnees(simTraitement.traitement(dateAlleatoire()+" "+heureAlleatoire()+" "+ latitudeAlleatoire() + " " + latitudeAlleatoire() + " " + DameuseRandom.getNom()));  //leur attribue des donn�es all�atoires
        DameuseRandom.setDonnees(donnees);
        return donnees.toString();
    }

}
