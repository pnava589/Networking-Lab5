import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
	
	private static ArrayList<String> key = new ArrayList<String>();
	private static ArrayList<String> value = new ArrayList<String>();
	
	public static void main (String [] args) throws IOException 
	{
		ServerSocket ss = new ServerSocket(4970);
		Socket s = ss.accept();
		
		
		System.out.println("client connected");
		
		InputStreamReader in = new InputStreamReader(s.getInputStream());
		BufferedReader bf = new BufferedReader(in);
		
		String str = bf.readLine();
		
		map(str);
		
		s.close();
		ss.close();
		
		
	}
	
	public static void map(String str) throws FileNotFoundException 
	{
		
		System.out.println("Does this still work?");
		
		
		try {
			
		Scanner scan = new Scanner(new File("H:\\git\\repository\\Lab 5.2\\src\\dictionary.txt"));
		scan.useDelimiter("\t");
		String first_word = "";
		String definition = "";
		
		while(scan.hasNext())
		{
			first_word = scan.next();
			definition = scan.next();
			scan.nextLine();
			key.add(new String(first_word));
			value.add(new String(definition));
		}
			
		
		
		
		
		for(int i = 0 ; i < key.size(); i++)
		{
			System.out.print("key"+key.get(i));
			System.out.println("value"+value.get(i));
		}
		
		
		scan.close();
		
		
		}
		catch (FileNotFoundException e) 
		{
			System.out.println(e);
		}
		
		
	}
	
	
	
}