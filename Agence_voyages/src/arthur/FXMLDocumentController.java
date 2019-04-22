/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arthur;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author mundia
 */
public class FXMLDocumentController implements Initializable {

    private Label label;
    @FXML
    private Button reserver;
    @FXML
    private ImageView logo1;
    @FXML
    private ImageView logo2;
    @FXML
    private ImageView logo3;
    @FXML
    private ImageView logo4;
    @FXML
    private ImageView logo6;
    @FXML
    private ImageView logo5;
    @FXML
    private Button reserver1;
    @FXML
    private Button valider;
    @FXML
    private Button annuler;
    @FXML
    private ProgressBar progress;
    @FXML
    
    @SuppressWarnings("empty-statement")
    private void handleButtonAction(ActionEvent event) throws IOException {
        
        if(event.getSource() == reserver){
            Parent page2 = FXMLLoader.load(getClass().getResource("FXMLPage2.fxml"));
            Scene page2_scene = new Scene(page2);
            progress.setVisible(true);
            progress.setStyle("-fx-accent :  #E45652;");
            PauseTransition pt = new PauseTransition();
            pt.setDuration(Duration.seconds(3));
            pt.setOnFinished(ev ->{
             
             
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(page2_scene);
            app_stage.getIcons().add(new Image("/arthur/logo4.png"));
            app_stage.setTitle("A&A Voyage");
            app_stage.show();
            progress.setVisible(false);
            });
                  
            pt.play();
            
        }
        
        if(event.getSource() == reserver1){
        Parent page3 = FXMLLoader.load(getClass().getResource("PageReservation.fxml"));
        Scene page3_scene = new Scene(page3);
        progress.setVisible(true);
                    progress.setStyle("-fx-accent :  #E45652;");

            PauseTransition pt = new PauseTransition();
            pt.setDuration(Duration.seconds(3));
            pt.setOnFinished(ev ->{
             
        Stage app_stage2 = new Stage();
        app_stage2.setScene(page3_scene);
         app_stage2.getIcons().add(new Image("/arthur/logo4.png"));
            app_stage2.setTitle("A&A Voyage");
        app_stage2.show();
            progress.setVisible(false);
            });
         pt.play();
        }
        if(event.getSource() == valider){
        Parent page3 = FXMLLoader.load(getClass().getResource("PagePaiement.fxml"));
        Scene page3_scene = new Scene(page3);
         progress.setVisible(true);
                     progress.setStyle("-fx-accent :  #E45652;");

            PauseTransition pt = new PauseTransition();
            pt.setDuration(Duration.seconds(3));
            pt.setOnFinished(ev ->{
        Stage app_stage2 = new Stage();
        app_stage2.setScene(page3_scene);
         app_stage2.getIcons().add(new Image("/arthur/logo4.png"));
            app_stage2.setTitle("A&A Voyage");
        app_stage2.show();
            progress.setVisible(false);
            });
         pt.play();
        
        }
 
          if (event.getSource()== annuler){
           Parent page3 = FXMLLoader.load(getClass().getResource("Annulation.fxml"));
        Scene page3_scene = new Scene(page3);
         progress.setVisible(true);
                     progress.setStyle("-fx-accent :  #E45652;");

            PauseTransition pt = new PauseTransition();
            pt.setDuration(Duration.seconds(3));
            pt.setOnFinished(ev ->{
        Stage app_stage2 = new Stage();
        app_stage2.setScene(page3_scene);
         app_stage2.getIcons().add(new Image("/arthur/logo4.png"));
            app_stage2.setTitle("A&A Voyage");
        app_stage2.show();
            progress.setVisible(false);
            });
            pt.play();
            
        
          }  
        }
        


    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }



 
   
 }
   

