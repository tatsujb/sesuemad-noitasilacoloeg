import java.util.Random;

/**
 * Created by tatsu on 15/11/2015.
 */
public class SimulateurVariables {

    //variables fixes pour la date randomisee
    private int day;
    private int month;
    private int year;
    //variables fixes pour l'heure randomisee
    private int seconde;
    private int minute;
    private int heure;

    //maximum pour l'heure
    private int MXsecondes = 60;
    private int MXminutes = 60;
    private int MXheures = 24;
    //maximum pour la date
    private int MXdays = 30;
    private int MXmonths = 12;
    private int MXyears = 9090;

    //variables randomisees pour la latitude
    private double minLat = -90;
    private double maxLat = +90;
    //variables randomisees pour la longitude
    private double minLon = -180;
    private double maxLon = +180;

    //randomizers
    Random rand1 = new Random();
    Random rand2 = new Random();


    public SimulateurVariables(int day, int month, int year, int seconde, int minute, int heure) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.seconde = seconde;
        this.minute = minute;
        this.heure = heure;
    }

    public int getDay() {
        return day;
    }
    public int getMonth() {
        return month;
    }
    public int getYear() {
        return year;
    }
    public int getSeconde() {
        return seconde;
    }
    public int getMinute() {
        return minute;
    }
    public int getHeure() {
        return heure;
    }
    public int getMXsecondes() {
        return MXsecondes;
    }
    public int getMXminutes() {
        return MXminutes;
    }
    public int getMXheures() {
        return MXheures;
    }
    public int getMXdays() {
        return MXdays;
    }
    public int getMXmonths() {
        return MXmonths;
    }
    public int getMXyears() {
        return MXyears;
    }

    public void setDay(int day) {
        this.day = day;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public void setSeconde(int seconde) {
        this.seconde = seconde;
    }
    public void setMinute(int minute) {
        this.minute = minute;
    }
    public void setHeure(int heure) {
        this.heure = heure;
    }

    public String lheure(){
        String sseconde = "0";
        String sminute = "0";
        String sheure =  "0";
        String lheure = "";
        if (this.getSeconde() < 10){
            sseconde = sseconde.concat(""+ this.getSeconde());
        }else{
            sseconde = String.valueOf(this.getSeconde());
        }
        if (this.getMinute() < 10){
            sminute = sminute.concat("" + this.getMinute());
        }else{
            sminute = String.valueOf(this.getMinute());
        }
        if (this.getHeure() < 10){
            sheure = sheure.concat("" + this.getHeure());
        }else{
            sheure = String.valueOf(this.getHeure());
        }

        return lheure.concat(sheure +":"+ sminute +":"+ sseconde);
    }

    public String ladate(){
        String sday = "0";
        String smonth = "0";
        String ladate = "";
        if (this.getDay() < 10){
            sday = sday.concat(""+ this.getDay());
        }else{
            sday = String.valueOf(this.getDay());
        }
        if (this.getMonth() < 10){
            smonth = smonth.concat(""+ this.getMonth());
        }else{
            smonth = String.valueOf(this.getMonth());
        }

        return ladate.concat(sday +"/"+ smonth +"/"+ this.getYear());
    }

    public double latitudeAlleatoire(){
        return (minLat + (maxLat - minLat) * rand1.nextDouble());
    }

    public double longitureAlleatoire(){
        return (minLon + (maxLon - minLon) * rand2.nextDouble());
    }

    /*public void nextSeconde() {
        setSeconde((int) (this.seconde + Math.floor(Math.random() * getMXsecondes() - this.seconde)));
    }
    public void nextMinute() {
        setMinute((int) (this.minute + Math.floor(Math.random() * getMXminutes() - this.minute)));
    }
    public void nextHeure() {
        setHeure((int) (this.heure + Math.floor(Math.random() * getMXheures() - this.heure)));
    }
    public void nextDay() {
        setDay((int) (this.heure + Math.floor(Math.random() * getMXdays() - this.day)));
    }public void nextMonth() {
        setMonth((int) (this.heure + Math.floor(Math.random() * getMXmonths() - this.month)));
    }public void nextYear() {
        setYear((int) (this.heure + Math.floor(Math.random() * getMXyears() - this.year)));
    }*/

}
