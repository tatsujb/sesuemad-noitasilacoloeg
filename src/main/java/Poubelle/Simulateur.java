/**
 * Created by tatsu on 15/11/2015.
 */

package Poubelle;

import Class.Dameuse;
import Class.Donnees;
import Class.Traitement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Simulateur {

    //private Map<String, Class.Dameuse> listeDameuses = new HashMap<String, Class.Dameuse>(); //le set a l'avantage de permetre une construction semi-automatisee mais pleins de desavantages
    private ArrayList<Dameuse> listeDameuses = new ArrayList<Dameuse>(); //liste de dammeuses on pourrai aussi randomiser leur nombre mais ici on teste avec 3


    private SimulateurVariables var;
    public Simulateur(){
        this.var = new SimulateurVariables(1,1,2015,0,0,0);
    }

    public String dateAlleatoire(){//00/00/00
        if (!(var.getDay() < var.getMXdays())){
            var.setDay(1);
            var.setMonth(var.getMonth()+1);
        }else if (!(var.getMonth() < var.getMXmonths())){
            var.setMonth(1);
            var.setYear(var.getYear()+1);
        }

        return var.ladate();
    }

    public String heureAlleatoire(){
        String lheure = ""; //00:00:00
        //                                            force d'incrementation random des secondes
        int randomSec = var.getSeconde() +(int)Math.floor(Math.random() * 10);

        if(!(var.getHeure() < var.getMXheures())){
            var.setHeure(0);
            var.setDay(var.getDay() + 1);
        }else if(!(var.getMinute() < var.getMXminutes())){
            var.setMinute(0);
            var.setHeure(var.getHeure() + 1);
        }else if(randomSec > var.getMXsecondes()){
            var.setSeconde(0);
            var.setMinute(var.getMinute()+1);
        }else{
            var.setSeconde(randomSec);
        }
        return var.lheure();

    }


    public void faireDonneesAlleatoires(int nombreDeDameuses) throws IOException {
        Random rand5 = new Random();
        for (int i = 0; i < nombreDeDameuses; i++) {
            //   Class.Dameuse d = new Class.Dameuse("DAM"+i);
            // listeDameuses.add(d);
        }

        Dameuse DameuseRandom = listeDameuses.get(rand5.nextInt(listeDameuses.size())); //choisi all�atoirement parmis les dameuses quel que soit leur nombre
        Traitement simTraitement = new Traitement();

        //leur attribue des donn�es alleatoires :
        Donnees donnees = new Donnees(simTraitement.traitement(dateAlleatoire()+" "+heureAlleatoire()+" "+ var.latitudeAlleatoire() + " " + var.latitudeAlleatoire() + " " + DameuseRandom.getNom()));
        DameuseRandom.setDonnees(donnees);

        System.out.println(donnees.toString()); //genere l'affichage a la console


    }

}
