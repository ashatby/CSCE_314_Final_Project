public class WordChecker {
    public WordChecker(Word corrWord, Word guessWord){
        correctWord = corrWord;
        guessedWord = guessWord;
    }
    public Boolean isGuessAWord(String word){
        return FileIO.CheckWord(word);
    }
    public void CompareWords(){
        Boolean in = false;
        for (int i =0; i< 5; i++){
            in = false;
            if (correctWord.listofcharacters.get(i) == (guessedWord.listofcharacters.get(i))){
                System.out.println(guessedWord.listofcharacters.get(i)+" in the right spot in word");
                in = true;
            }
            else if (correctWord.listofcharacters.contains(guessedWord.listofcharacters.get(i))){
                System.out.println(guessedWord.listofcharacters.get(i)+" in word");
                in = true;
            } 
            else{
                System.out.println(guessedWord.listofcharacters.get(i)+" is not in word");

            }
            // if (correctWord.listofcharacters.get(i) == (guessedWord.listofcharacters.get(i))){
            //     System.out.println(guessedWord.listofcharacters.get(i)+" in the right spot in word");
            //     in = true;
            // } 

            // if(!in){
            //     System.out.println(guessedWord.listofcharacters.get(i)+" is not in word");
            // }
        }
    }
    Word correctWord;
    Word guessedWord;
}
