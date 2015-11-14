import org.marre.SmsSender;
import org.marre.sms.SmsException;

import javax.c

import java.io.IOException;

/**
 * Created by Fabienne_2 on 14/11/2015.
 */
public class Main {

    public SmsSender smsSender = SmsSender.getClickatellSender("username", "password", "apiid");

    public void inititalize() throws IOException, SmsException {
        smsSender.connect();
    }


}
