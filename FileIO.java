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

    public static void writeToOutputFile(String output){
        output+="\n";
        try {
            FileWriter writer = new FileWriter("scoredata.txt", true);
            writer.write(output);
            writer.close();
          } catch (IOException e) {
            System.out.println("Error for file writing");
			e.printStackTrace(); 
			System.exit(0); 
          }
    }


	public static ArrayList<Integer> getStats() { 
        //games played, games won, current streak, max streak, correct in 1 guess, correct in 2 guesses, correct in 3 guesses, correct in 4 guesses, correct in 5 guesses, correct in 6 guesses//
        Scanner infile = null;
        Integer games_played=0, games_won=0, curr_streak=0, max_streak=0, oneguess=0, twoguesses=0, threeguesses=0, fourguesses=0, fiveguesses=0, sixguesses=0;
        //ret.as
        String line="";        
        try
		{
		      infile = new Scanner(new FileReader("scoredata.txt"));
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("File not found");
			e.printStackTrace(); 
			System.exit(0); 
		}	
        while (infile.hasNextLine()){
            games_played++;
            line = infile.nextLine();
            //System.out.println(line);
            if (line.equals("1")){
                oneguess++;
                games_won++;
                curr_streak++;
            }
            else if (line.equals("2")){
                twoguesses++;
                games_won++;
                curr_streak++;
            }
            else if (line.equals("3")){
                threeguesses++;
                games_won++;
                curr_streak++;
            }
            else if (line.equals("4")){
                fourguesses++;
                games_won++;
                curr_streak++;
            }
            else if (line.equals("5")){
                fiveguesses++;
                games_won++;
                curr_streak++;
            }
            else if (line.equals("6")){
                sixguesses++;
                games_won++;
                curr_streak++;
            }
            else if (line.equals("7")){
                if (curr_streak > max_streak){
                    max_streak = curr_streak;
                }
                curr_streak=0;
            }
            if (curr_streak > max_streak){
                max_streak = curr_streak;
            }

        }
        infile.close( );
        ArrayList<Integer> ret = new ArrayList<Integer>(Arrays.asList(games_played, games_won, curr_streak, max_streak, oneguess, twoguesses, threeguesses, fourguesses, fiveguesses, sixguesses));
        //ArrayList<Integer> ret = new ArrayList<Integer>(Arrays.asList(0));
        return ret;
    }

}

