/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source;

/**
 *
 * @author Ziham
 */
public class EncapLogin {
    
    private static String this_username;
    private static String this_password;

    //setting default values to username and password
    public EncapLogin(){
     this_username = "";
     this_password = "";
    }
    /*
     public Login_encapsulation(String username, String password){
     this.this_username = username;
     this.this_password = password;
    }
    */
    
    //setting username
       public static void setUsername(String username) {
           
        this_username = username;                              //settting username
        
    }
        
  
        public static void setPassword(String password) {
            
        this_password = password;                              //settting passowrd
        
    }    
    
 
     public static String getUsername() {                      //return the username
         
        return this_username;
        
    }
     
 
     public static String getPassword() {
         
        return this_password;                                  //return the password
        
    }


    
    
}


