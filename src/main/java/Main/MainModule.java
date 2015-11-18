package Main;

import com.sun.comm.Win32Driver;

import javax.comm.CommPortIdentifier;
import java.util.Enumeration;

/**
 * Created by Fabienne_2 on 14/11/2015.
 */
public class MainModule {

    //psvm
    public static void main(String[] args) {

        //initialisation du driver
        Win32Driver w32Driver = new Win32Driver();
        w32Driver.initialize();
        //récupération de l'énumération
        Enumeration portList = CommPortIdentifier.getPortIdentifiers();
        //affichage des noms des ports
        CommPortIdentifier portId;
        while (portList.hasMoreElements()) {
            portId = (CommPortIdentifier) portList.nextElement();
            System.out.println(portId.getName());
        }
    }
}


