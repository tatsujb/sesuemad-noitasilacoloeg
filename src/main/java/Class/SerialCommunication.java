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

	private boolean bConnected = false;

	//la valeur d'attente max
	final static int TIMEOUT = 2000;

	//quelque valeur ascii
	final static int SPACE_ASCII = 32;
	final static int DASH_ASCII = 45;
	final static int NEW_LINE_ASCII = 10;


	String logText = "";

	public void rechercheDesPorts()
	{
		ports = CommPortIdentifier.getPortIdentifiers();

		while (ports.hasMoreElements())
		{
			CommPortIdentifier curPort = (CommPortIdentifier)ports.nextElement();

			//recuperer tout les ports serial
			if (curPort.getPortType() == CommPortIdentifier.PORT_SERIAL)
			{
				portMap.put(curPort.getName(), curPort);
			}
		}
	}

	public boolean initIOStream()
	{
		boolean successful = false;

		try {
			input = serialPort.getInputStream();
			output = serialPort.getOutputStream();
			try {
				serialPort.setSerialPortParams(115200, serialPort.DATABITS_8, serialPort.STOPBITS_1, serialPort.PARITY_NONE);
			} catch (UnsupportedCommOperationException e) {
				e.printStackTrace();
			}
			input = serialPort.getInputStream();
			output = serialPort.getOutputStream();
			System.out.println("connexion...");
			byte[] b = new byte[400];
			output.write("AT+CPIN?".getBytes()); //rajouter le /r/b !
			output.flush();
			try {
				Thread.sleep(800);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			input.read(b);
			output.flush();
			try {
				Thread.sleep(800);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			input.read(b);
			System.out.println(new String(b));
			output.write("AT+CSCS=\"GSM\"".getBytes());
			output.flush();

			output.write("AT+CMGF=1".getBytes());
			output.flush();

			output.write("AT+CNMI=2,2,0,1,0".getBytes());
			output.flush();

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
		//ferme lle port serie
		try
		{
			serialPort.removeEventListener();
			serialPort.close();
			input.close();
			output.close();
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
		String selectedPort = "COM4";
		this.rechercheDesPorts();
		selectedPortIdentifier = (CommPortIdentifier)portMap.get(selectedPort);

		CommPort commPort = null;

		try
		{
			//methode qui retourne un objet de type comm port
			commPort = selectedPortIdentifier.open("TigerControlPanel", TIMEOUT);
			//cast vers object SerialPort
			serialPort = (SerialPort)commPort;
			//log
			logText = selectedPort + " opened successfully.";
			System.out.println(logText);
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
