import java.io.*;
import java.util.*;

public class FileIO {

	public static void main(String[] args) {
        System.out.println(getword());
    }

    public static Boolean CheckWord(String input){
		Scanner infile = null;
        String line="";
        input = input.toLowerCase();
        
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
        for (int i =0; i< 116; i++){
            line = infile.nextLine();
            StringTokenizer tokenizer = new StringTokenizer(line);
            for (int j =0; j<20; j++){
                String word = tokenizer.nextToken();
                //System.out.println(word == );
                if (word.equals(input)){
                    infile.close( );
                    return true;
                }
            }
        }

        infile.close( );
        return false;
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

