package Class;

import java.util.List;

/**
 * Created by Fabienne_2 on 14/11/2015.
 */
public class Donnees {

    private String lattitude;
    private String longitude;
    private String date;
    private String heure;
    private String identifiantDameuse;



    public Donnees(List<String> p_donnees) {
        if (p_donnees.size() == 9 && p_donnees.get(8) != null && p_donnees.get(8) != "null"){
            NumerisationMois mapMois = NumerisationMois.getInstance();

            this.date = p_donnees.get(2)+'/'+mapMois.returnMois(p_donnees.get(1))+'/'+p_donnees.get(5);
            this.heure = p_donnees.get(3);
            this.lattitude = p_donnees.get(6);
            this.longitude = p_donnees.get(7);
            if (p_donnees.get(8).length() == 1){
                this.identifiantDameuse = "DAM0"+p_donnees.get(8);
            }else{
                this.identifiantDameuse = "DAM"+p_donnees.get(8);
            }
        }

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

        return date+"   "+heure+"   "+lattitude+"   "+longitude/*+" "+identifiantDameuse*/;
    }

    public String getHeure() {

        return heure;
    }

    public String getDate() {

        return date;
    }


}
