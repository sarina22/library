package controllerC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelM.UserLoginModel;
import viewV.*;


public class BasicViewController {
          BasicView baseCont;
public BasicViewController(BasicView v) //// constructor for this class
{
		 this.baseCont=v;
}

	
public void baseManage() 
{
			
		baseCont.actionLogout(new ActionListener() 
{// method for the logout 
					
public void actionPerformed(ActionEvent a)
{	
		baseCont.dispose();
		LoginPageView login=new LoginPageView();
		UserLoginModel mc=new UserLoginModel();
		LoginManageCon clog = new LoginManageCon(login,mc);
		clog.fromLoginCon();
						
}
});
			
		baseCont.actionArticle(new ActionListener() 
{
				
public void actionPerformed(ActionEvent a)
{	// method used when the baseview is disposed for the articles manage's view
		baseCont.dispose();
		ArticlesManage allArticles=new ArticlesManage();
					
					
					
}
});

		baseCont.actionResearcher(new ActionListener() 
{
				
public void actionPerformed(ActionEvent a)
{	// to dispose the base page and display the researcher manage view.
		baseCont.dispose();
		ResearcherManage allResearchers=new ResearcherManage();
}
});
}
}
