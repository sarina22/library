import viewV.BasicView;
import viewV.*;
import controllerC.*;
import modelM.UserLoginModel;


public class DefTestClass {
     public static void main(String[]args) {
    	 
    	LoginPageView view=new LoginPageView(); //View for the Login
  	   UserLoginModel model = new UserLoginModel();//LoginModel
    	 LoginManageCon clog = new LoginManageCon(view,model);
  		  clog.fromLoginCon();//method call
    	 
        
     }
	
	
}
