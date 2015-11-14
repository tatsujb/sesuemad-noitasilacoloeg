import org.marre.SmsSender;
import org.marre.sms.SmsException;
import javax.comm.*;

import java.io.IOException;
import java.util.Enumeration;
import com.sun.comm.Win32Driver;

/**
 * Created by Fabienne_2 on 14/11/2015.
 */
public class Main {

    public SmsSender smsSender = SmsSender.getClickatellSender("username", "password", "apiid");

    public void inititalize() throws IOException, SmsException {
        smsSender.connect();
        //initialisation du driver
        Win32Driver w32Driver= new Win32Driver();
        w32Driver.initialize();
//récupération de l'énumération
        Enumeration portList=CommPortIdentifier.getPortIdentifiers();
//affichage des noms des ports
        CommPortIdentifier portId;
        while (portList.hasMoreElements()){
            portId=(CommPortIdentifier)portList.nextElement();
            System.out.println(portId.getName());
        }
    }
}
