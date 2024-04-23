import java.io.*;
import java.util.*;

public class Statistics {

    public static void displayStats(){
        List<Integer> statslist = FileIO.getStats();
        //games played, games won, current streak, max streak, correct in 1 guess, correct in 2 guesses, correct in 3 guesses, correct in 4 guesses, correct in 5 guesses, correct in 6 guesses//
        System.out.println("Games played: "+statslist.get(0));
        System.out.println("Percent won: "+(statslist.get(1)*100)/statslist.get(0)+"%"); //games won* 100/ games played
        System.out.println("Current streak: "+statslist.get(2));
        System.out.println("Max streak: "+statslist.get(3));
        System.out.println("Guess Distribution: ");
        System.out.println("Guess 1: "+statslist.get(4));
        System.out.println("Guess 2: "+statslist.get(5));
        System.out.println("Guess 3: "+statslist.get(6));
        System.out.println("Guess 4: "+statslist.get(7));
        System.out.println("Guess 5: "+statslist.get(8));
        System.out.println("Guess 6: "+statslist.get(9));
    }


}