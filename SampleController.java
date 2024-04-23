import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class SampleController {

    @FXML
    private Label Wordle_Title, middleLabel;// = new Label();
    @FXML
    private Button a_Buton, b_Buton, backspace_Buton, c_Buton, d_Buton, e_Buton, enter_Buton, f_Buton, g_Buton , h_Buton, i_Buton, j_Buton, k_Buton, l_Buton, m_Buton, n_Buton, o_Buton, p_Buton, q_Buton, r_Buton, s_Buton, t_Buton, u_Buton, v_Buton, w_Buton, x_Buton, y_Buton, z_Buton;

    @FXML
    private TextField letter00, letter01, letter02, letter03, letter04, letter10, letter11, letter12, letter13, letter14, letter20, letter21, letter22, letter23, letter24, letter30, letter31, letter32, letter33, letter34, letter40, letter41, letter42, letter43, letter44, letter50, letter51, letter52, letter53, letter54;
    
    @FXML
    private Button Start_Button;

    private Word correct_word= new Word();

    public void submitguess(int currword_iterator_input, List<List<TextField>> allwords){//List<TextField> currword, List<TextField> nextword
        List<TextField> currword = allwords.get(currword_iterator_input);
        List<TextField> nextword;
        if (currword_iterator_input !=5){
            nextword = allwords.get(currword_iterator_input+1);
        }
        else{
            nextword = null;
        }
        System.out.println(correct_word.listofcharacters);
        Word guessed_word = new Word(currword);
        System.out.println(guessed_word.word);
        System.out.println(guessed_word.word);
        WordChecker wChecker = new WordChecker(correct_word, guessed_word);
        System.out.println(wChecker.isValidWord(guessed_word));
        if (wChecker.isValidWord(guessed_word)){
            middleLabel.setText("Make A Guess!");
            for (TextField letter : currword){
                letter.setDisable(true);
            }
            if (nextword != null){
                for (TextField letter : nextword){
                    letter.setDisable(false);
                }
            }
            wChecker.CompareWords();
            if (wChecker.isCorrectWord()){

                System.out.println("Correct Word!!");
            }
            currword_iterator++;

        }
        else{
            System.out.println("Invalid Guess");
            middleLabel.setText("Invalid Guess");
        }
    }

    public void handleKeyPress(KeyEvent e) {
        if (e.getCode() == KeyCode.ENTER) {
            //System.out.println("hi");
            submitguess(currword_iterator, allwords);
        }
    }
    
    //List<List<TextField>> allwords = new ArrayList<List<TextField>>(Arrays.asList(word1tf, word2tf, word3tf, word4tf, word5tf, word6tf));
    public List<TextField> word1tf = new ArrayList<TextField>(Arrays.asList(letter00, letter01, letter02, letter03, letter04));
    public List<TextField> word2tf = new ArrayList<TextField>(Arrays.asList(letter10, letter11, letter12, letter13, letter14));
    public List<TextField> word3tf = new ArrayList<TextField>(Arrays.asList(letter20, letter21, letter22, letter23, letter24));
    public List<TextField> word4tf = new ArrayList<TextField>(Arrays.asList(letter30, letter31, letter32, letter33, letter34));
    public List<TextField> word5tf = new ArrayList<TextField>(Arrays.asList(letter40, letter41, letter42, letter43, letter44));
    public List<TextField> word6tf = new ArrayList<TextField>(Arrays.asList(letter50, letter51, letter52, letter53, letter54));
    public List<List<TextField>> allwords = new ArrayList<List<TextField>>(Arrays.asList(word1tf, word2tf, word3tf, word4tf, word5tf, word6tf));

    //private TextField currTextField= letter00;
    //private List<List<TextField>> allwords; 

    private int currword_iterator = 0;
    public void initialize(){

        List<TextField> word1tf = new ArrayList<TextField>(Arrays.asList(letter00, letter01, letter02, letter03, letter04));
        List<TextField> word2tf = new ArrayList<TextField>(Arrays.asList(letter10, letter11, letter12, letter13, letter14));
        List<TextField> word3tf = new ArrayList<TextField>(Arrays.asList(letter20, letter21, letter22, letter23, letter24));
        List<TextField> word4tf = new ArrayList<TextField>(Arrays.asList(letter30, letter31, letter32, letter33, letter34));
        List<TextField> word5tf = new ArrayList<TextField>(Arrays.asList(letter40, letter41, letter42, letter43, letter44));
        List<TextField> word6tf = new ArrayList<TextField>(Arrays.asList(letter50, letter51, letter52, letter53, letter54));
        List<List<TextField>> allwords = new ArrayList<List<TextField>>(Arrays.asList(word1tf, word2tf, word3tf, word4tf, word5tf, word6tf));
        //middleLabel.setText("Invalid Guess");
        enter_Buton.setOnAction(event -> submitguess(currword_iterator, allwords));
        correct_word.setAsCorrectWord();


    }


}
