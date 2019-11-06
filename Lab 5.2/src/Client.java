import java.io.*;
import java.util.*;
import java.net.*;


public class Client {

	public static void main (String [] args) throws IOException
	{
		Socket s = new Socket("localhost",4100);
		PrintWriter pr = new PrintWriter(s.getOutputStream());
		Scanner scan = new Scanner(System.in);
		//String input = scan;
		pr.println("GM, RU COMING B4 NOON? PLZ WB ASAP. TYVM. GTG, TTYL.");
		pr.flush();
		s.close();
	}

}
