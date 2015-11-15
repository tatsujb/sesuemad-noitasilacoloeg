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

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSeconde() {
        return seconde;
    }

    public void setSeconde(int seconde) {
        this.seconde = seconde;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getHeure() {
        return heure;
    }

    public void setHeure(int heure) {
        this.heure = heure;
    }
}
