import java.io.*;
import java.util.*;

public class Driver {
    public static String[] splitintoletters(String word){
        return (word.split(""));
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Word word = new Word();
        word.setAsCorrectWord();
        Boolean stoppedEarly=false;
        int i=1;
        //FileIO.getStats();
        while (i <=6){
            System.out.println("Guess "+i+", make a guess: ");
            String inputguess = scanner.nextLine();
            Word guess = new Word(inputguess);
            if (guess.word.equals("stop")){
                FileIO.writeToOutputFile(Integer.toString(i));
                stoppedEarly=true;
                i=7;
                break;
            }
            //System.out.println(word.letterstoString());
            System.out.println(guess.letterstoString());
            WordChecker wChecker = new WordChecker(word, guess);
            System.out.println("Valid Guess: "+wChecker.isValidWord(guess));
            if (wChecker.isValidWord(guess)){
                wChecker.CompareWords();
                if (wChecker.isCorrectWord()){
                    FileIO.writeToOutputFile(Integer.toString(i));
                    stoppedEarly=true;
                    break;
                }
                i++;
            }
            else{
                System.out.println("Invalid Guess");
            }
        }

        scanner.close();
        if (!stoppedEarly){
        FileIO.writeToOutputFile("7");
        }

        Statistics.displayStats();
        System.out.println("The word was " + word.letterstoString());

    }


}