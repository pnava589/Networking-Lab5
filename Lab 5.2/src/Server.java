import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
	
	private static ArrayList<String> key = new ArrayList<String>();
	private static ArrayList<String> value = new ArrayList<String>();
	private static ArrayList<String> indexFound = new ArrayList<String>();
	
	public static void main (String [] args) throws IOException 
	{
		ServerSocket ss = new ServerSocket(4100);
		Socket s = ss.accept();
		
		
		System.out.println("client connected");
		
		InputStreamReader in = new InputStreamReader(s.getInputStream());
		BufferedReader bf = new BufferedReader(in);
		
		String str = bf.readLine();
		
		map();
		String[] inputArray = str.split("\\s");
		translate(inputArray);
		
		s.close();
		ss.close();
		
		
	}
	
	public static void map() throws FileNotFoundException 
	{
		//System.out.println("Does this still work?");
		try {
			
		Scanner scan = new Scanner(new File("H:\\git\\repository\\Lab 5.2\\src\\dictionary.txt"));
		scan.useDelimiter("\t");
		String first_word = "";
		
		while(scan.hasNext())
		{
			first_word = scan.nextLine();
			String[] columnDetail = first_word.split("\t");
			String word = columnDetail[0];
			String secondWord = columnDetail[1];
			key.add(word);
			value.add(secondWord);
		}
		
		scan.close();
		
		}
		catch (FileNotFoundException e) 
		{
			System.out.println(e);
		}
		
	}
	
	public static void translate(String[] input)
	{
		for(int i = 0 ; i < input.length; i++)
		{	
			input[i] = input[i].replaceAll("[-+.^:,?]","");
			
			for(int index = 0; index < key.size(); index++)
			{
				if(input[i].equalsIgnoreCase(key.get(index)))
				{
					indexFound.add(value.get(index));
					break;
				}
			}
		}
		
		printResults();
	}
	
	public static void printResults()
	{
		for(int i = 0 ; i<indexFound.size(); i++)
		{
			System.out.print(indexFound.get(i)+" ");
		}
			
	}
	
}