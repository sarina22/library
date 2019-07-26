package controllerC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelM.UserLoginModel;
import viewV.IndividualResearcherFormat;
import viewV.LoginPageView;

public class IndividualResearcherFormatController
{               IndividualResearcherFormat indi;
	
	
	
public IndividualResearcherFormatController(IndividualResearcherFormat fc)// constructor for  this class
{
		this.indi=fc;
}
	
	
// method for return articles  to researchers when the return button is clicked	
public void methodFNotLoanJourn() 
{
		
		indi.listenTonotLoan(new ActionListener() 
{
					
public void actionPerformed(ActionEvent a)
{	
		indi.notloanJournTab();
}
});
}
	
// method for providing loan to researchers when the hire button is clicked
public void methodFLoanJourn() 
{
		
		indi.listenToLoan(new ActionListener() 
{
				
public void actionPerformed(ActionEvent a)
{	
		indi.loanJournTab();
}
});
}
	
// method to logout of the system
public void methodlogOUT()
{
		
		indi.logout(new ActionListener() 
{
				
public void actionPerformed(ActionEvent a)
{	
		indi.dispose();
		LoginPageView login=new LoginPageView();
		UserLoginModel mc=new UserLoginModel();
		LoginManageCon clog = new LoginManageCon(login,mc);
		clog.fromLoginCon();
}
});
}
}
