/**
 * Created by tatsu on 15/11/2015.
 */
public class SimulateurVariables {

    //variables fixes pour la date randomisee
    private int day = 1;
    private int month = 1;
    private int year = 2015;
    //variables fixes pour l'heure randomisee
    private int seconde = 0;
    private int minute = 0;
    private int heure = 0;

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
