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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class PageReservationController implements Initializable {

   
    @FXML
    private Button actualiser;

  
       String[][]Tableau = new String[100][15];
    @FXML
    private Label lbldisplay;
    @FXML
     private void Actualiser(ActionEvent event) throws IOException, InterruptedException {
                
                 Scanner lecteur = null;
          String s = "";
         try{
            int i = 0;
             lecteur = new Scanner(new FileReader("Reservation.txt"));
             while(lecteur.hasNextLine()){
                 String ligne = lecteur.nextLine();
                 String[] ligneTableau = ligne.split(",");
                 Tableau[i] = ligneTableau;
                 System.out.println(Arrays.toString(Tableau[i]));
                    s+=(Arrays.toString(Tableau[i])+"\n");
                 
                }
             lbldisplay.setText(s);
               
         }
         catch(Exception e){
             System.out.println("Fin de lecture");
         }
         finally{
         if(lecteur != null){lecteur.close();} 
         }
     }
     
     
     

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    
 
}
    
    
    

