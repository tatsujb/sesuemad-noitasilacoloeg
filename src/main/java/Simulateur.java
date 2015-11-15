import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by tatsu on 15/11/2015.
 */
public class Simulateur {

    //public rand
    Random random = new Random();

    //variables fixes pour l'heure randomisee
    int MXsecondes = 60;
    int MXminutes = 60;
    int MXheures = 12;
    int seconde = 0;
    int minute = 0;
    int heure = 0;
    //variables fixes pour la date randomisee
    final int MXdays = 30;
    final int MXmonths = 12;
    final int MXyears = 2090;
    int day = 0;
    int month = 0;
    int year = 2015;



    ArrayList<Dameuse> listeDameuses = new ArrayList<Dameuse>(); //liste de dammeuses on pourrai aussi randomiser leur nombre mais ici on teste avec 3

    public String dateAlleatoire(){
        String tr = "0/0/2015";

        if(day < MXdays){
            day = random.nextInt(MXdays);
        } else if(month < MXmonths){
            month = random.nextInt(MXmonths);
        }else{
            year = random.nextInt(MXyears);
        }

        return tr.concat(day +"/"+ month +"/"+ year);
    }

    public String heureAlleatoire(){
        String tr = "00:00:00";

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

        return tr.concat(heure +":"+ minute +":"+ seconde);
    }


    public void faireDonneesAlleatoires() throws IOException{
        Dameuse d1 = new Dameuse("DAM01");
        Dameuse d2 = new Dameuse("DAM02");
        Dameuse d3 = new Dameuse("DAM03");
        listeDameuses.add(d1);
        listeDameuses.add(d2);
        listeDameuses.add(d3);
        Dameuse DameuseRandom = listeDameuses.get((int) Math.random() * listeDameuses.size()); //choisi alléatoirement parmis les dameuses quel que soit leur nombre
        Traitement simTraitement = new Traitement();
        Donnees donnees = new Donnees(simTraitement.traitement(dateAlleatoire()+" "+heureAlleatoire()+" 0 0 "+ DameuseRandom.getNom()));  //leur attribue des données alléatoires
        DameuseRandom.setDonnees(donnees);

    }

}
