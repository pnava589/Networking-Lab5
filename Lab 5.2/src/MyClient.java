import java.io.*;
import java.net.*;


public class MyClient {

	public static void main (String [] args) throws IOException
	{
		Socket s = new Socket("localhost",5000);
		
		PrintWriter pr = new PrintWriter(s.getOutputStream());
		pr.println("GM, RU COMING B4 NOON? PLZ WB ASAP. TYVM. GTG, TTYL.");
		pr.flush();
	}

}
