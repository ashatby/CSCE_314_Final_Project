import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.TextField;

public class Word {
    public String word="";
    public ArrayList<Character> listofcharacters;
    public String[] listofstrings;
    public List<TextField> wordTextFields;

    public Word(){
        word="";
    }

    public Word(String input){
        word= input;
        listofcharacters = splitintoletters(word);
        listofstrings = splitintoStrings();

    }

    Word(List<TextField> wordtf){
        wordTextFields = wordtf;
        word = (wordtf.get(0).getText()+wordtf.get(1).getText()+wordtf.get(2).getText()+wordtf.get(3).getText()+wordtf.get(4).getText());
        listofstrings = splitintoStrings();
        listofcharacters = splitintoletters(word);
    }

    public int length(){
        return word.length();
    }
    
    public String[] splitintoStrings(){
        String[] listofstrings = word.split("");
        return listofstrings;
        
    }

    public void setAsCorrectWord(){
        word= FileIO.getword();
        listofcharacters = splitintoletters(word);
    }
    public static ArrayList<Character> splitintoletters(String word){
        String[] listofstrings = word.split("");
        ArrayList<Character> listofchars = new ArrayList<Character>();
        //char[] listofchars={'a','a','a','a','a'};
        for (int i = 0; i<word.length(); i++){
            listofchars.add(Character.toUpperCase(listofstrings[i].charAt(0)));
            //Character.toUpperCase(lowercaseChar)
        }
        return listofchars;
    }


    public Boolean equals(Word oword){
        return word.equals(oword.word);
    }

    public String letterstoString(){
        //char[] charlist = listofcharacters;
        // for (int i =0; i<5; i++){
        //     System.out.print(charlist);
        // }
        String retstring ="";
        for (int i =0; i<listofcharacters.size(); i++){
            retstring+= listofcharacters.get(i)+" ";
        }
        //return (listofcharacters.get(0)+" "+listofcharacters.get(1)+" "+listofcharacters.get(2)+" "+listofcharacters.get(3)+" "+listofcharacters.get(4));
        return retstring;
    }
}
