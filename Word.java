import java.util.ArrayList;

public class Word {
    public String word="";
    public ArrayList<Character> listofcharacters;

    public Word(){
        word="";
    }

    public Word(String input){
        word= input;
        listofcharacters = splitintoletters(word);

    }

    public void setAsCorrectWord(){
        word= FileIO.getword();
        listofcharacters = splitintoletters(word);
    }
    public static ArrayList<Character> splitintoletters(String word){
        String[] listofstrings = word.split("");
        ArrayList<Character> listofchars = new ArrayList<Character>();
        //char[] listofchars={'a','a','a','a','a'};
        for (int i = 0; i<5; i++){
            listofchars.add(Character.toUpperCase(listofstrings[i].charAt(0)));
            //Character.toUpperCase(lowercaseChar)
        }
        return listofchars;
    }




    public String letterstoString(){
        //char[] charlist = listofcharacters;
        // for (int i =0; i<5; i++){
        //     System.out.print(charlist);
        // }
        return (listofcharacters.get(0)+" "+listofcharacters.get(1)+" "+listofcharacters.get(2)+" "+listofcharacters.get(3)+" "+listofcharacters.get(4));
    }
}
