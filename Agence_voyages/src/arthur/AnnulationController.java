/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arthur;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.Vector;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class AnnulationController implements Initializable {

    @FXML
    private Label Lmess;
    @FXML
    private TextField n_reser;
    @FXML
    private Button continuer;
    @FXML
    private Button retour;
    @FXML
    private Label Lmessage;
    @FXML
    private AnchorPane anchor;
    @FXML
    private Button ok;

    /**
     * Initializes the controller class.
     */
    
    
        @FXML
    
    private void handleButtonAction(ActionEvent event) throws IOException, InterruptedException {
            if (event.getSource()== continuer){
             
                
                 try {
                     String fileName = "Reservation.txt";
        	BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName))); 
            StringBuffer sb = new StringBuffer(); 
            String line = "";    
            int nbLinesRead = 0;
            //while(lecteur.hasNextLine()){
                // String ligne = lecteur.nextLine();
                 
                // if (n_reser.getText().equals(ligneTableau[0])){*/
            while ((line = reader.readLine()) != null) {
                
                String[] ligneTableau = line.split(",");
                if (n_reser.getText().equals(ligneTableau[0])) {
                   
                    
                } else{
                     sb.append(line);
                     sb.append("\n");
                     
                }
                nbLinesRead++;
            }            
            reader.close();
            BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
            out.write(sb.toString());
            out.close();
 
        } 
        catch (Exception e) {
            System.out.println("Fin de lecture");
        }
     anchor.setVisible(true);   
    }
   
    if(event.getSource()==retour){
            Parent page2 = FXMLLoader.load(getClass().getResource("Annulation.fxml"));
            Scene page2_scene = new Scene(page2);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(page2_scene);
             app_stage.getIcons().add(new Image("/arthur/logo4.png"));
            app_stage.setTitle("A&A Voyage");
            app_stage.close();
    }
    if (event.getSource()==ok){
             Parent page2 = FXMLLoader.load(getClass().getResource("Annulation.fxml"));
            Scene page2_scene = new Scene(page2);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(page2_scene);
             app_stage.getIcons().add(new Image("/arthur/logo4.png"));
            app_stage.setTitle("A&A Voyage");
            app_stage.close();
    }
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
 
    
}
