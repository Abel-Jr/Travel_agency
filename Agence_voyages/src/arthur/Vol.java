/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arthur;

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
     
    public Vol(){}
    
    public Vol(String nvol, String id, String VilleD,String DateD,String heureD, String VilleA,String DateA, String heureA, String avion1,String prix){
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
