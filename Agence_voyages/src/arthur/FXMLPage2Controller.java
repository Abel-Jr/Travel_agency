/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arthur;



import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author mundia
 */
public class FXMLPage2Controller implements Initializable {
    @FXML
    private Button suivant;
    @FXML
    private TableColumn<Vol,String> tabnvol;
    @FXML
    private TableColumn<Vol,String> tabid;
    @FXML
    private TableColumn<Vol,String> tabVilleD;
    @FXML
    private TableColumn<Vol,String> tabDateD;
    @FXML
    private TableColumn<Vol,String> TabVilleA;
    @FXML
    private TableColumn<Vol,String> tabDateA;
    @FXML
    private TableColumn<Vol,String> tabheureD;
    @FXML
    private TableColumn<Vol,String>tabheureA;
    @FXML
    private TableColumn<Vol,String> tabavion1;
    @FXML
    private TableColumn<Vol,String> tabprix;
    @FXML
    private TableView<Vol> tableview;
   
    ObservableList<Vol> list = FXCollections.observableArrayList(
           new Vol("01A","001d","Casablanca","08-06-2018", "16:00:00","Agadir","08-06-2018", "19:00:00","Boeing 707 ","8500" ),
           new Vol("02A","002d","Casablanca","20-06-2018" ," 22:00:00","Dakar","21-06-2018"," 01:00:00","AT78832 ","5000"),
           new Vol("03A","004d","Rabat","03-07-2018"," 10:00:00","Marseille","03-07-2018"," 13:30:00","Concorde 258 ","5200"),
           new Vol("01B","005d","Marrakech","18-07-2018"," 12:00:00","Paris","18-07-2018"," 15:45:00","Boeing 747  ","6000"),
           new Vol("02B","006d","Abidjan","30-07-2018"," 15:00:00","Douala","30-07-2018"," 18:00:00","Airbus A320 ","7500"),
           new Vol("03B","007d","Douala","13-08-2018"," 11:00:00","Libreville","13-08-2018"," 12:30:00","Concorde 985","5500"),
           new Vol("04C","008d","Libreville","25-08-2018"," 23:00:00","Casablanca","26-08-2018 ","08:30:00","Airbus A318 ","5900"),
           new Vol("05C","009d","Abidjan","04-09-2018"," 22:00:00","Casablanca","05-09-2018"," 09:00:00","G325 isr  ","5855 "),
           new Vol("06C","010d","Toronto","03-10-2018"," 21:00:00","Rabat","04-10-2018"," 09:00:00","Concorde 152","9520 "),
           new Vol("07D","011d","Abidjan","25-10-2018"," 10:00:00","Paris","25-10-2018"," 16:30:00","G785 isr ","7410 "),
           new Vol("08D","012d","Paris","04-11-2018"," 09:00:00","Casablanca","04-11-2018"," 12:30:00","Airbus A321","6520 "),
           new Vol("09D","013d","Casablanca","12-11-2018","17:45:00","Madrid","12-11-2018"," 20:45:00","Boeing 727 ","4850 "),
           new Vol("10E","014d","Barcelone","25-11-2018"," 10:00:00","New York","25-11-2018 ","16:30:00","AT78832 ","9000 "),
           
           new Vol("11E","015d","Agadir","08-06-2018", "16:00:00","Casablanca","08-06-2018", "19:00:00","Boeing 707 ","8500 " ),
           new Vol("12E","016d","Dakar","20-06-2018" ," 22:00:00","Casablanca","21-06-2018"," 01:00:00","AT78832 ","5000"),
           new Vol("13F","017d","Marseille","03-07-2018"," 10:00:00","Rabat","03-07-2018"," 13:30:00","Concorde 258 ","5200 "),
           new Vol("14F","018d","Paris","18-07-2018"," 12:00:00","Marrakech","18-07-2018"," 15:45:00","Boeing 747  ","6000 "),
           new Vol("15F","019d","Douala","30-07-2018"," 15:00:00","Abidjan","30-07-2018"," 18:00:00","Airbus A320 ","7500 "),
           new Vol("16G","020d","LIbreville","13-08-2018"," 11:00:00","Abidjan","13-08-2018"," 12:30:00","Concorde 985","5500 "),
           new Vol("17G","021d","Casablanca","25-08-2018"," 23:00:00","Libreville","26-08-2018 ","08:30:00","Airbus A318 ","5900 "),
           new Vol("18G","022d","Tokyo","04-09-2018"," 22:00:00","Casablanca","05-09-2018"," 09:00:00","G325 isr  ","5855 "),
           new Vol("19H","023d","Washington","03-10-2018"," 21:00:00","Rabat","04-10-2018"," 09:00:00","Concorde 152","9520 "),
           new Vol("20H","024d","Pekin","25-10-2018"," 10:00:00","Barcelone","25-10-2018"," 16:30:00","G785 isr ","7410 "),
           new Vol("21H","025d","Paris","04-11-2018"," 09:00:00","Londres","04-10-2018"," 12:30:00","Airbus A321","6520 "),
           new Vol("22I","026d","Casablanca","12-11-2018","17:45:00","Boston","12-11-2018"," 20:45:00","Boeing 727 ","4850"),
           new Vol("23I","027d","Rabat","25-11-2018"," 10:00:00","Kinshasa","25-11-2018 ","16:30:00","AT78832 ","9000 ")
           
   );
    @FXML
    private AnchorPane reservation;
    @FXML
    private Label lblnom;
    @FXML
    private Label lblprenom;
    @FXML
    private Label lblpasseport;
    @FXML
    private Label lblage;
    @FXML
    private TextField txtnom;
    @FXML
    private TextField txtprenom;
    @FXML
    private TextField txtage;
    @FXML
    private TextField txtpassword;
    @FXML
    private Button enregistrer;
    @FXML
    private Label lblmessage1;
    @FXML
    private Label lblmessage2;
    @FXML
    private AnchorPane Table;
    @FXML
    private Button Retour2;
    @FXML
    private Button Retour1;
    @FXML
    private Label Lfailed;
    @FXML
    private Label message;
    @FXML
    private Label lblvilledepart;
    @FXML
    private Label lblheure_depart;
    @FXML
    private Label lblvillearrivee;
    @FXML
    private Label lblheure_arrivee;
    @FXML
    private Label valeur_v_depart;
    @FXML
    private Label valeur_h_depart;
    @FXML
    private Label valeur_v_arrivee;
    @FXML
    private Label valeur_h_arrivee;
    @FXML
    private Label valeur_d_depart;
    @FXML
    private Label valeur_d_arrivee;
    @FXML
    private ProgressIndicator load;
    
    
    
        
    
    public String getNom(){
        return txtnom.getText();
    }
    
    public String getPrenom(){
        return txtprenom.getText();
    }
    public String getAge(){
        return txtage.getText();
        
    }
    public String getPasseport(){
        return txtpassword.getText();
    }
    Random r = new Random();
   
    
    
   
    @FXML
    
    private void handleButtonAction1(ActionEvent event) throws IOException, InterruptedException {
        
       
        if(event.getSource() == suivant){
            Vol selection = tableview.getSelectionModel().getSelectedItem();
            if (selection!=null){
             valeur_v_depart.setText(selection.getVilleD());
             valeur_h_depart.setText(selection.getHeureD());
             valeur_d_depart.setText(selection.getDateD());
             valeur_v_arrivee.setText(selection.getVilleA());
             valeur_h_arrivee.setText(selection.getHeureA());
             valeur_d_arrivee.setText(selection.getDateA());
            suivant.setVisible(false);
            Retour1.setVisible(false);
            reservation.setVisible(true);
            tableview.setVisible(false);
            Table.setVisible(true);
            search.setVisible(false);
            search1.setVisible(false);
            message.setVisible(false);
            Lfailed.setVisible(false);
            } else{
                message.setVisible(true);
            }
            
        }

        if (event.getSource()==Retour1){
               Parent page2 = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Scene page2_scene = new Scene(page2);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(page2_scene);
             app_stage.getIcons().add(new Image("/arthur/logo4.png"));
            app_stage.setTitle("A&A Voyage");
            app_stage.show();
        }
        if (event.getSource()== Retour2){
           search.setVisible(true);
           search1.setVisible(true);
            tableview.setVisible(true);
           reservation.setVisible(false);
           Table.setVisible(true);
           Retour1.setVisible(true);
           suivant.setVisible(true);
      
        }
                if (event.getSource()== enregistrer){
          
               Vol selection = tableview.getSelectionModel().getSelectedItem();
                     if (getNom().equals("") || getPrenom().equals("") || getAge().equals("") || getPasseport().equals("")){
                            Lfailed.setVisible(true);
 
        } else{
                 int valeur = 10000 + r.nextInt(99999 - 10000);
                 FileWriter fw1 = new FileWriter("Reservation.txt",true);     // Ecrit à la suite du texte précédent
            try (BufferedWriter bw1 = new BufferedWriter(fw1)) {
                bw1.write(valeur+","+getNom()+","+getPrenom()+","+getAge()+","+getPasseport()+","+selection.getNvol()+","+selection.getId()+","+selection.getVilleD()+","+selection.getDateD()+","+selection.getHeureD()+","+selection.getVilleA()+","+selection.getDateA()+","+selection.getHeureA()+","+selection.getAvion1()+","+selection.getPrix());
                bw1.newLine();
                 }
             Parent page9 = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
             Scene page9_scene = new Scene(page9);
             load.setVisible(true);
             load.setStyle("-fx-accent :  #E45652;");
                PauseTransition pt = new PauseTransition();
                 pt.setDuration(Duration.seconds(3));
            pt.setOnFinished(ev ->{
                     Stage app_stage9 = (Stage) ((Node) event.getSource()).getScene().getWindow();
                     app_stage9.setScene(page9_scene);
                     app_stage9.getIcons().add(new Image("/arthur/logo4.png"));
                     app_stage9.setTitle("A&A Voyage");
                     app_stage9.show();
                     load.setVisible(false);
            });
            pt.play();
            } 
        
         }
    }
     @FXML
    private TextField search;
    @FXML
    private TextField search1;
   
    @FXML
    private void search(KeyEvent event) {
      
        FilteredList<Vol> filterData = new FilteredList<>(list, p->true);
        search.textProperty().addListener((observable,oldvalue,newvalue) -> {
            filterData.setPredicate(pers ->{
                if(newvalue == null || newvalue.isEmpty()){
                    return true;
                }
                String typedText = newvalue.toLowerCase();
               
                if(pers.getVilleD().toLowerCase().indexOf(typedText) != -1 || pers.getVilleA().toLowerCase().indexOf(typedText) != -1){
                return true;
                }
               
                return false;
            
            });
            SortedList<Vol> sortedList = new SortedList<>(filterData);
            sortedList.comparatorProperty().bind(tableview.comparatorProperty());
            tableview.setItems(sortedList);
        });
         search1.textProperty().addListener((observable,oldvalue,newvalue) -> {
            filterData.setPredicate(pers ->{
                if(newvalue == null || newvalue.isEmpty()){
                    return true;
                }
                String typedText = newvalue.toLowerCase();
               
                if(pers.getVilleA().toLowerCase().indexOf(typedText) != -1 ){
                return true;
                }
               
                return false;
            
            });
            SortedList<Vol> sortedList = new SortedList<>(filterData);
            sortedList.comparatorProperty().bind(tableview.comparatorProperty());
            tableview.setItems(sortedList);
        });
        
    
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tabnvol.setCellValueFactory(new PropertyValueFactory<>("nvol"));
        tabid.setCellValueFactory(new PropertyValueFactory<>("id"));
        tabVilleD.setCellValueFactory(new PropertyValueFactory<>("VilleD"));
        tabDateD.setCellValueFactory(new PropertyValueFactory<>("DateD"));
        tabheureD.setCellValueFactory(new PropertyValueFactory<>("heureD"));
        TabVilleA.setCellValueFactory(new PropertyValueFactory<>("VilleA"));
        tabDateA.setCellValueFactory(new PropertyValueFactory<>("DateA"));
        tabheureA.setCellValueFactory(new PropertyValueFactory<>("heureA"));
        tabavion1.setCellValueFactory(new PropertyValueFactory<>("avion1"));
         tabprix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        tableview.setItems(list);
        tableview.setVisible(true);
     
    }

    @FXML
    private void handleButtonAction1(MouseEvent event) {
    }
 public class Vol{
      public String nvol ; 
      public String id ;
      public String VilleD ;
      public String DateD;
      public String heureD;
      public String VilleA ;
      public String DateA;
      public String heureA;
      public String avion1;
      public String prix;
     
     Vol(){}
    
     Vol(String nvol, String id, String VilleD,String DateD,String heureD, String VilleA,String DateA, String heureA, String avion1,String prix){
     this.nvol = nvol;
     this.id = id;
     this.VilleD = VilleD;
     this.DateD = DateD;
     this.heureA = heureA;
     this.VilleA = VilleA;
     this.DateA = DateA;
     this.heureD = heureD;
     this.avion1 = avion1;
     this.prix = prix;
     
    }
    public String getNvol(){
     return nvol;
    }
    
    public String getId(){
     return id;
    }
    public String getVilleD(){
     return VilleD;
    }
    public String getDateD(){
     return DateD;
    }
     public String getHeureD(){
     return heureD;
    }
     public String getVilleA(){
     return VilleA;
    }
    public String getDateA(){
     return DateA;
    }
     public String getHeureA(){
     return heureA;
    }
      public String getAvion1(){
     return avion1;
    }
       public String getPrix(){
     return prix;
    }
   
 }
}

 

           
        
    

