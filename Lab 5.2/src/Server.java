import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
	
	private static ArrayList<String> key = new ArrayList<String>();
	private static ArrayList<String> value = new ArrayList<String>();
	private static ArrayList<String> indexFound = new ArrayList<String>();
	
	public static void main (String [] args) throws IOException 
	{
		ServerSocket ss = new ServerSocket(4101);
		Socket s = ss.accept();
		
		
		System.out.println("client connected");
		
		InputStreamReader in = new InputStreamReader(s.getInputStream());
		BufferedReader bf = new BufferedReader(in);
		map();
		
		String str = bf.readLine();
		while(str != null) {
			String[] inputArray = str.split("\\s");
			translate(inputArray);
			str = bf.readLine();
		}
		
		s.close();
		ss.close();
		
		
	}
	
	public static void map() throws FileNotFoundException 
	{
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
		int it = 0;
		indexFound.clear();
		for(int i = 0 ; i < input.length; i++)
		{
			boolean found = false;
			input[i] = input[i].replaceAll("[-+.^:,?]","");
			
			for(int index = 0; index < key.size(); index++)
			{
				if(equals(input[i],key.get(index)))
				{
					it = index;
					found = true;
					break;
				}
			}
			
			if(found){ indexFound.add(value.get(it)); }
			else { indexFound.add(input[i]); }
		}
		
		printResults();
	}
	
	public static void printResults()
	{
		if(indexFound.isEmpty())
		{
			System.out.println("No matches were found");
		}
		else
		{
			for(int i = 0 ; i<indexFound.size(); i++)
				{
					System.out.print(indexFound.get(i)+" ");
				}
			System.out.println();
		}	
	}
	
	public static boolean equals(String input, String key)
	{
		if(input.equalsIgnoreCase(key)) {
			return true;
		}
		else
		{
			return false;
		}
	}
	
}