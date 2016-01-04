package Class;

import gnu.io.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

public class SerialCommunication implements SerialPortEventListener{
	
	private String tampon = new String();
	private Queue<String> queue = new LinkedList();
	private int count = 0;
	
	//Contient tout les port trouvé
    private Enumeration ports = null;
    //contient le nom des port trouvé
    private HashMap portMap = new HashMap();

    //contient le port ouvert par l'app
    private CommPortIdentifier selectedPortIdentifier = null;
    private SerialPort serialPort = null;

    //objet utilisé pour envoyer et recevoir de la data
    private InputStream input = null;
    private OutputStream output = null;

    //just a boolean flag that i use for enabling
    //and disabling buttons depending on whether the program
    //is connected to a serial port or not
    private boolean bConnected = false;

    //la valeur d'attente max
    final static int TIMEOUT = 2000;

    //quelque valeur ascii
    final static int SPACE_ASCII = 32;
    final static int DASH_ASCII = 45;
    final static int NEW_LINE_ASCII = 10;

    //a string for recording what goes on in the program
    //this string is written to the GUI
    String logText = "";
	
	public void rechercheDesPorts()
    {
        ports = CommPortIdentifier.getPortIdentifiers();

        while (ports.hasMoreElements())
        {
            CommPortIdentifier curPort = (CommPortIdentifier)ports.nextElement();

            //get only serial ports
            if (curPort.getPortType() == CommPortIdentifier.PORT_SERIAL)
            {
                portMap.put(curPort.getName(), curPort);
            }
        }
    }
	
	public boolean initIOStream()
    {
        //return value for whether opening the streams is successful or not
        boolean successful = false;

        try {
            //
            input = serialPort.getInputStream();
            output = serialPort.getOutputStream();
            //writeData(0, 0);

            return true;
        }
        catch (IOException e) {
            logText = "I/O Streams failed to open. (" + e.toString() + ")";
            System.out.println(logText);
            return successful;
        }
    }
	
	public void initListener()
    {
        try
        {
            serialPort.addEventListener(this);
            serialPort.notifyOnDataAvailable(true);
        }
        catch (TooManyListenersException e)
        {
            logText = "Too many listeners. (" + e.toString() + ")";
            System.out.println(logText);
        }
    }
	
	  public void disconnect()
	    {
	        //close the serial port
	        try
	        {
	            //writeData(0, 0);

	            serialPort.removeEventListener();
	            serialPort.close();
	            input.close();
	            output.close();
	            //setConnected(false);

	            logText = "Disconnected.";

	        }
	        catch (Exception e)
	        {
	            logText = "Failed to close " + serialPort.getName()
	                              + "(" + e.toString() + ")";
	            System.out.println(logText);
	        }
	    }
	  public void serialEvent(SerialPortEvent evt) {
	        if (evt.getEventType() == SerialPortEvent.DATA_AVAILABLE)
	        {
	            try
	            {
	                byte singleData = (byte)input.read();

	                if (singleData != NEW_LINE_ASCII)
	                {
	                    if(count==2)
	                    {
		                    logText = new String(new byte[] {singleData});
		                    tampon = tampon.concat(logText);	
	                    }
	                    if(singleData == 13)
	                    {
	                    	this.count++;
	                    	if(count==3)
	                    	{
	                    		count = 0;
		                    	queue.add(tampon);
		                    	tampon = "";
	                    	}
	                    }
	                    
	                }
	            }
	            catch (Exception e)
	            {
	                logText = "Failed to read data. (" + e.toString() + ")";
	                
	            }
	        }
	    }
	  
	  public String getLastSMS()
	  {
		if(queue.peek()==null)
		{
			return ".";
		}else
		{
			return queue.peek().substring(0, queue.poll().length()-1);
		}
	  }
	  public void connect()
	    {
	        String selectedPort = "COM3"; //Fabienne "COM4" Jacques et Loic "COM3"
	        this.rechercheDesPorts();
	        selectedPortIdentifier = (CommPortIdentifier)portMap.get(selectedPort);

	        CommPort commPort = null;

	        try
	        {
	            //the method below returns an object of type CommPort
	            commPort = selectedPortIdentifier.open("TigerControlPanel", TIMEOUT);
	            //the CommPort object can be casted to a SerialPort object
	            serialPort = (SerialPort)commPort;

	            //for controlling GUI elements

	            //logging
	            logText = selectedPort + " opened successfully.";
	            System.out.println(logText);

	            //CODE ON SETTING BAUD RATE ETC OMITTED
	            //XBEE PAIR ASSUMED TO HAVE SAME SETTINGS ALREADY

	            //enables the controls on the GUI if a successful connection is made

	        }
	        catch (PortInUseException e)
	        {
	            logText = selectedPort + " is in use. (" + e.toString() + ")";

	            System.out.println(logText);
	        }
	        catch (Exception e)
	        {
	            logText = "Failed to open " + selectedPort + "(" + e.toString() + ")";
	            System.out.println(logText);
	        }
	    }
}
