/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arthur;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author user
 */
public class PagePaiementController implements Initializable {

    @FXML
    private Button Annuler;
    @FXML
    private Button valider;
    @FXML
    private Text numcarte;
    @FXML
    private TextField txtreservation;
    @FXML
    private TextField txtsomme;
  
        
      
       
    @FXML
    private Label Lsucces;
    @FXML
    private Label Lfailed;
    @FXML
    private ImageView paiementvalide;
    @FXML
    private ProgressIndicator patience;
    @FXML
    private Text verifie;
    @FXML
    private ImageView paiementvalide1;
       
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
    }    

    @FXML
    private void initialize1(ActionEvent event) throws IOException {
        if(event.getSource()== valider){
            
                     Scanner lecteur = null;
          String s = "";
         try{
            int i = 0;
             lecteur = new Scanner(new FileReader("Reservation.txt"));
             while(lecteur.hasNextLine()){
                 String ligne = lecteur.nextLine();
                 String[] ligneTableau = ligne.split(",");
               
                 if(txtreservation.getText().equals(ligneTableau[0])){
                     float reservation = Float.parseFloat(txtreservation.getText());
                     float somme = Float.parseFloat(txtsomme.getText());
                     float Tsomme = Float.parseFloat(ligneTableau[14]);
                     if (somme<Tsomme){
                         Parent page2 = FXMLLoader.load(getClass().getResource("PagePaiement.fxml"));
            Scene page2_scene = new Scene(page2);
            patience.setVisible(true);
            verifie.setVisible(true);
             PauseTransition p1 = new PauseTransition();
            p1.setDuration(Duration.seconds(3));
            p1.setOnFinished(evt ->{
            patience.setVisible(false);
            verifie.setVisible(false);
            Lsucces.setVisible(false);
                         Lfailed.setVisible(true);
                         paiementvalide1.setVisible(true);
           
             PauseTransition pt1 = new PauseTransition();
            pt1.setDuration(Duration.seconds(3));
            pt1.setOnFinished(ev ->{
                Lfailed.setVisible(false);
                 paiementvalide1.setVisible(false);
            });
            pt1.play();
            });
            p1.play();
                         
                     } else{
            Parent page2 = FXMLLoader.load(getClass().getResource("PagePaiement.fxml"));
            Scene page2_scene = new Scene(page2);
            patience.setVisible(true);
            verifie.setVisible(true);
             PauseTransition p = new PauseTransition();
            p.setDuration(Duration.seconds(3));
            p.setOnFinished(evt ->{
            patience.setVisible(false);
            verifie.setVisible(false);
            Lfailed.setVisible(false);
                         Lsucces.setVisible(true);
                         paiementvalide.setVisible(true);
           
             PauseTransition pt = new PauseTransition();
            pt.setDuration(Duration.seconds(3));
            pt.setOnFinished(ev ->{
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(page2_scene);
             app_stage.getIcons().add(new Image("/arthur/logo4.png"));
            app_stage.setTitle("A&A Voyage");
            app_stage.close();});
            pt.play();
            });
            p.play();
                         

                         
                     }
                     
                     
                 }
                 //System.out.println(Arrays.toString(Tableau[i]));
                    //s+=(Arrays.toString(Tableau[i])+"\n");

                    
                    
                }

         }
         catch(Exception e){
             System.out.println("Fin de lecture");
         }
         finally{
         if(lecteur != null){lecteur.close();} 
         }
    
            
            /*
            Parent page2 = FXMLLoader.load(getClass().getResource("PagePaiement.fxml"));
            Scene page2_scene = new Scene(page2);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(page2_scene);
             app_stage.getIcons().add(new Image("/arthur/logo4.png"));
            app_stage.setTitle("A&A Voyage");
            app_stage.close();
*/
        
        }
        if(event.getSource() == Annuler){
            Parent page2 = FXMLLoader.load(getClass().getResource("PagePaiement.fxml"));
            Scene page2_scene = new Scene(page2);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(page2_scene);
             app_stage.getIcons().add(new Image("/arthur/logo4.png"));
            app_stage.setTitle("A&A Voyage");
            app_stage.close();
        }
    }

    @FXML
    private void initialize1(MouseEvent event) {
    }

}
