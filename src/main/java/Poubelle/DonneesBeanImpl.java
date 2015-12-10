package Poubelle;

import java.util.List;

/**
 * Created by Fabienne_2 on 10/12/2015.
 */
public class DonneesBeanImpl {

        private String lattitude;
        private String longitude;
        private String date;
        private String heure;
        private String identifiantDameuse;


        public DonneesBeanImpl(List<String> p_donnees) {
            this.date = p_donnees.get(0);
            this.heure = p_donnees.get(1);
            this.lattitude = p_donnees.get(2);
            this.longitude = p_donnees.get(3);
            this.identifiantDameuse = p_donnees.get(4);
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

}
