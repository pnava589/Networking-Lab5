import java.io.*;
import java.net.*;


public class Client {

	public static void main (String [] args) throws IOException
	{
		Socket s = new Socket("localhost",4970);
		 PrintWriter pr = new PrintWriter(s.getOutputStream());
		pr.println("GM, RU COMING B4 NOON? PLZ WB ASAP. TYVM. GTG, TTYL.");
		pr.flush();
		s.close();
	}

}
