import java.util.*;

public class WordChecker {
    public WordChecker(Word corrWord, Word guessWord){
        correctWord = corrWord;
        guessedWord = guessWord;
    }

    // public Boolean isGuessAWord(String word){
    //     return FileIO.CheckWord(word);
    // }

    public Boolean isValidWord(Word iword){
        if (iword.length() > 5){
            iword.word = iword.word.substring(0,5);
        }
    
        if (iword.length() < 5){
            return false;
        }

        return FileIO.CheckWord(iword.word);

    }
    public void CompareWords(){
        Boolean in = false;
        if (!isValidWord(guessedWord)){
            return;
        }
        for (int i =0; i< 5; i++){
            in = false;
            if (correctWord.listofcharacters.get(i) == (guessedWord.listofcharacters.get(i))){
                //System.out.println(guessedWord.listofcharacters.get(i)+" in the right spot in word");
                System.out.println(guessedWord.listofcharacters.get(i)+": green");
                //textField.setStyle("-fx-control-inner-background: green;")
                guessedWord.wordTextFields.get(i).setStyle("-fx-control-inner-background: green;");
            }
            else if (correctWord.listofcharacters.contains(guessedWord.listofcharacters.get(i))){
                //System.out.println(guessedWord.listofcharacters.get(i)+" in word");
                System.out.println(guessedWord.listofcharacters.get(i)+": yellow");
                guessedWord.wordTextFields.get(i).setStyle("-fx-control-inner-background: yellow;");
            } 
            else{
                //System.out.println(guessedWord.listofcharacters.get(i)+" is not in word");
                System.out.println(guessedWord.listofcharacters.get(i)+": gray");
                guessedWord.wordTextFields.get(i).setStyle("-fx-control-inner-background: gray;");


            }
        }
    }

    public Boolean isCorrectWord(){
        return correctWord.equals(guessedWord);
    }
    Word correctWord;
    Word guessedWord;
}
