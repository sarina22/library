package modelM;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;

import viewV.LoginPageView;

public class UserLoginModel {
        //attributes for the login details
		private String username;
		private char[] password;
public UserLoginModel() {
			// default constructor
}
//Getters and setters for the above mentioned attributes
public String getUsername() 
{
	return this.username;
}
public void setUsername(String username) 
{
	this.username = username;
}
public char[] getPassword()
{
	return password;
		}
public void setPassword(char[] password) 
{
	this.password = password;
		}

		
//method to check the correct username and password
public boolean validShow(String username, char[] password) {
			String ree= getUsername();
			char[] rePass = getPassword();
if(ree.equals(username)) {
if(Arrays.equals(rePass,password)) {
	return true;
}
else 
	return false;
}
else
	return false;
		
}		
//method for the  login  of the researchers.
public boolean reLogin(LoginPageView view)
{
		boolean exact= false;
		ArrayList<SerialMoResearch> researchh = null;// arranging the data of the researchers in arrayLists
	try {//fileread from the researcher data
		FileInputStream inpuLogs = new FileInputStream("src/infoStorage/Researcher.dat");
		ObjectInputStream objLogs = new ObjectInputStream(inpuLogs);
		Object logname= objLogs.readObject();
		researchh = (ArrayList<SerialMoResearch>)logname;
			
	for (int i = 0; i < researchh.size(); i++) {
		setUsername(researchh.get(i).getSEUsername());
		setPassword(researchh.get(i).getSEPassword());
	if(exact=validShow(view.getjTUser(),view.getjTPass()))
		break;
}
	objLogs.close(); 

	}catch (Exception e) {
}
		return exact;
}

}




