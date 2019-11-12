import java.io.*;
import java.util.*;
import java.net.*;


public class Client {

	public static void main (String [] args) throws IOException
	{
		Socket s = new Socket("localhost",4101);
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your text");
		String input = scan.nextLine();
		PrintWriter pr = new PrintWriter(s.getOutputStream());
		//pr.println("GM, RU COMING B4 NOON? PLZ WB ASAP. TYVM. GTG, TTYL.");
		// the code does not use special characters, once the user inputs exit the communication terminates
		while(!input.contains("exit"))
		{
			pr.println(input);
			pr.flush();
			System.out.println("Enter your text");
			input = scan.nextLine();
		}
		
		
		pr.flush();
		s.close();
	}

}
