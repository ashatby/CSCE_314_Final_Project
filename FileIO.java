import java.io.*;
import java.util.*;

public class FileIO {

	public static void main(String[] args) {
        System.out.println(getword());
    }
	public static String getword() 
	{		
		Scanner infile = null;
        int randline = RandomNumGen.getrandint(116);
        int randword = RandomNumGen.getrandint(20);
        String line="";
		try
		{
		      infile = new Scanner(new FileReader("wordlewords.txt"));
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("File not found");
			e.printStackTrace(); 
			System.exit(0); 
		}		
        for (int i =0; i< randline; i++){
            line = infile.nextLine();
        }
        String[] words = line.split("	");
        String finalwordchoice = words[randword];
        infile.close( );
        return finalwordchoice;

	}
}

