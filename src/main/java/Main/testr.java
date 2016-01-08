package Main;

/**
 * Created by Fabienne_2 on 04/01/2016.
 */

import Class.SerialCommunication;

public class testr
{

    public static void main(String[] args) {
        SerialCommunication communicator = new SerialCommunication();
        communicator.connect();
        if (communicator.initIOStream() == true)
        {
            communicator.initListener();
        }
        while(true)
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(communicator.getLastSMS());
        }
    }
}