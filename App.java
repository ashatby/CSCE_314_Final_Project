//package application; // could be different

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
public class App extends Application { // could be different
    public static void main(String[] args) { launch(args); }
    
    @Override
    public void start(Stage primaryStage) {
        try{
            //AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("wordlescene.fxml"));
            FXMLLoader loader = new FXMLLoader(getClass().getResource("wordlescene.fxml"));
            AnchorPane root = loader.load();
            Scene scene = new Scene(root,550,800);
            SampleController controller = loader.getController();
            //scene.getStylesheets().add(getClass().)
            primaryStage.setScene(scene);
            primaryStage.show();
            scene.setOnKeyPressed(e -> controller.handleKeyPress(e));



        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
