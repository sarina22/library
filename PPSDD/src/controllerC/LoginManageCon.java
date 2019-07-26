package controllerC;
import controllerC.*;
import modelM.UserLoginModel;

import javax.swing.*;

import viewV.*;
import controllerC.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import viewV.*;
public class LoginManageCon extends JDialog {

	LoginPageView loginview; 
	UserLoginModel usermodel;
	public LoginManageCon(LoginPageView viewL,UserLoginModel usermodel) {// constructor
		this.loginview=viewL;  
		this.usermodel=usermodel;
	}
	
	public void fromLoginCon(){
		
		loginview.getjBLogin().addActionListener(new ActionListener() {// method carried out when the login button is clicked
			public void actionPerformed(ActionEvent e){  
				String forName = loginview.getjTUser();// to get user from the login page
				char[] password =loginview.getjTPass();// to get the password from the login page
				String adminorResear =loginview.getGroup().getSelection().getActionCommand();
				char[] c= {'a','d','m','i','n'};
				if(adminorResear.equals("Admin")) { // if the user is admin
					if(forName.equals("a")){
						if( Arrays.equals(password,c)){
							JOptionPane.showMessageDialog(null, "Welcome admin! Login Successfull.");
							loginview.dispose();
							BasicView bBase = new BasicView();
						}
						else {
							JOptionPane.showMessageDialog(null,"Password incorrect");
						}
					}
					else {
						JOptionPane.showMessageDialog(null,"Login has Failed");
					}
				}
				else {// for the login of the researcher
					if(usermodel.reLogin(loginview)) {
						JOptionPane.showMessageDialog(null, "Welcome researcher!.");
						loginview.dispose();
						IndividualResearcherFormat indi=new IndividualResearcherFormat();
					}
					else {
						JOptionPane.showMessageDialog(null, "Incorrect!");
					}
				}
			}
		});
		loginview.getjBExit().addActionListener(new ActionListener() {// method to exit the system
			public void actionPerformed(ActionEvent arg0) 
			{
				System.exit(0);

			}
		});
	}
}



