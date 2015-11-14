/**
 * Created by Fabienne_2 on 14/11/2015.
 */
public class Donnees {

    private String lattitude;
    private String longitude;
    private String date;
    private String heure;
    private String identifiantDameuse;


    public Donnees(String p_date, String p_heure, String p_lattitude, String p_longitude,String p_identifiantDameuse) {
        this.date = p_date;
        this.heure = p_heure;
        this.lattitude = p_lattitude;
        this.longitude = p_longitude;
        this.identifiantDameuse = p_identifiantDameuse;
    }

    public void setLattitude(String p_lattitude) {

        this.lattitude = p_lattitude;
    }

    public void setLongitude(String p_longitude) {

        this.longitude = p_longitude;
    }

    public String getLattitude() {

        return lattitude;
    }

    public String getIdentifiantDameuse() {
        return identifiantDameuse;
    }

    public String getLongitude() {

        return longitude;
    }

    public void setHeure(String heure) {

        this.heure = heure;
    }


    public void setDate(String date) {

        this.date = date;
    }

    public String toString(){

        return date+" "+heure+" "+lattitude+" "+longitude+" "+identifiantDameuse;
    }

    public String getHeure() {

        return heure;
    }

    public String getDate() {

        return date;
    }
}
