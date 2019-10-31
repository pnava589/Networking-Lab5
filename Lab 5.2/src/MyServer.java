import java.io.*;
import java.net.*;
import java.util.*;

public class MyServer {
	
	
	public static void main (String [] args) throws IOException 
	{
		ServerSocket ss = new ServerSocket(5000);
		Socket s = ss.accept();
		System.out.println("client connected");
		
		InputStreamReader in = new InputStreamReader(s.getInputStream());
		BufferedReader bf = new BufferedReader(in);
		
		String str = bf.readLine();
		map(str);
		
		
		
	}
	
	public static void map(String str) throws FileNotFoundException 
	{
		
		String [] splitStr = str.split("\\s+");
		for(String e : splitStr)
		{
			System.out.println(e);
		}
		
		try {
			
		Scanner scan = new Scanner(new File("dictionary.txt"));
		int count = 0;
		while(scan.hasNextLine())
		{
			count ++;
		}
		
		System.out.println(count);
		}
		catch (FileNotFoundException e) 
		{
			System.out.println(e);
		}
	}
	
	
}