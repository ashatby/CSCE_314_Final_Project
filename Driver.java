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

        for (int i =0; i< 5; i++){
            System.out.println("make a guess: ");
            String inputguess = scanner.nextLine();
            Word guess = new Word(inputguess);
            System.out.println(word.letterstoString());
            System.out.println(guess.letterstoString());
            WordChecker wChecker = new WordChecker(word, guess);
            wChecker.CompareWords();
        }

        scanner.close();
    }


}