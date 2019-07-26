package controllerC;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;



import modelM.WriteReadBook;
import modelM.WriteReadConference;
import modelM.WriteReadJournal;
import viewV.*;

public class ArticlesManageController 
{

	     ArticlesManage articles;
	     WriteReadJournal seriJourn=new WriteReadJournal();//an object for the read write class for Journal
	     WriteReadConference seriConf=new WriteReadConference();//an object for the read and write class for Conference
	     WriteReadBook seriBook=new WriteReadBook();//object created for the class WriteReadBook
public ArticlesManageController(ArticlesManage v) {//constructor for this class
		this.articles=v;
}

public void clickMethodAddJournal() // method to display the  add form for adding new journals
{ 
			
		articles.buttonFFormJournal(new ActionListener() 
{
			
public void actionPerformed(ActionEvent a)

{
	
	
		articles.addJournal();
					
					
					
}
});
	
}
	
public void clickMethodAddConference() {//method that displays the form for adding the data for new conference articles
	
		articles.buttonFFormConference(new ActionListener() 
{
			
public void actionPerformed(ActionEvent a)
{	
				articles.addConference();
				
				
}
});
		
}
	
	//method helps in displaying the form to add new book chapters.
public void clickMethodAddBook()
{
	
		articles.buttonFFormBookCh(new ActionListener() 
{
			
public void actionPerformed(ActionEvent a)
{	
		articles.addBook();
				
				
}
});
}
	
	//method for the back button 
public void clickMainBack() {
		articles.buttonBack(new ActionListener() 
{
			
public void actionPerformed(ActionEvent a)
{	
		articles.dispose();
		BasicView baseView=new BasicView();
				
				
}
});
		
}
		////Method for the add to file for the journal articles on click of the button
public void individualAddJournal()
{
		
		articles.buttonJournAdd(new ActionListener() 
{
			
public void actionPerformed(ActionEvent a)
{	
			 
	if(articles.getjTJooAddID().getText().isEmpty() ||articles.getjTJootitle().getText().isEmpty() ||
	   articles.getjTJooAutho().getText().isEmpty() ||articles.getjTJooYear().getText().isEmpty()||
	   articles.getjTJooVolu().getText().isEmpty()||articles.getjTJooPage().getText().isEmpty()
					
)
{
			JOptionPane.showMessageDialog(null, "Completely Fill the Values");
}
else
	
	    seriJourn.journalWriteFileMetho(articles);
				
}
});
}
	
	
	//Method to add data to conference file on click of add button
	
	
public void individualAddConference()
{
		
		articles.buttonConfAdd(new ActionListener() 
{
			
public void actionPerformed(ActionEvent a)
{	
	
	if(articles.getjTConfAddID().getText().isEmpty() ||articles.getjTConftitle().getText().isEmpty() ||
	articles.getjTConfAutho().getText().isEmpty() ||articles.getjTConfPubli().getText().isEmpty()||
	articles.getjTConfEditor().getText().isEmpty()||articles.getjTConfPage().getText().isEmpty()||
	articles.getjTConfLocation().getText().isEmpty()
					
)
{
		JOptionPane.showMessageDialog(null, " Fill all the Values");
}
else
	      
		seriConf.confWriteFileMetho(articles);
				
}
});
}



// method to add the book chapter to the library system when the add button is clicked
	
public void individualAddBook()
{
	
	     articles.buttonBookAdd(new ActionListener() 
{
		
public void actionPerformed(ActionEvent a)
{	
	
	if(articles.getjTBookAddID().getText().isEmpty() ||articles.getjTBTitle().getText().isEmpty() ||
	articles.getjTBAutho().getText().isEmpty() ||articles.getjTBYear().getText().isEmpty()||
	articles.getjTBEditor().getText().isEmpty()||articles.getjTBPage().getText().isEmpty()||
	articles.getjTBLocation().getText().isEmpty()||articles.getjTBPublisher().getText().isEmpty()
							
)
{
			JOptionPane.showMessageDialog(null, " Fill all the Values");
}
else
		  seriBook.bookWriteFileMetho(articles);
			
}
});
	
}
	
	
	
// method to show the details of the journal articles added in a tabel.	
public void clickMethodViewJournal() {
		
		articles.buttonviewJournal(new ActionListener() 
	  	{
			
			public void actionPerformed(ActionEvent a)
			{	
			        
			        articles.viewJournalsA();
				
			}
		});
		
	}
	



// method to show the details of the conference articles added 
public void clickMethodViewConference() {
	
	articles.buttonviewConference(new ActionListener() 
  	{
		
		public void actionPerformed(ActionEvent a)
		{	
		        
		        articles.viewConferenceA();
		       
			
		}
	});
	
}


// method to show the details of the book chapter added to the library systems
public void clickMethodViewBooks() {
	
	articles.buttonviewBookCh(new ActionListener() 
  	{
		
		public void actionPerformed(ActionEvent a)
		{	
		        
		        articles.viewBooksA();
		       
			
		}
	});
	
}

	
	
	// for the table
public void viewla() {

	JScrollPane js = seriJourn.getJSP();
	articles.setTabe(seriJourn.getTabe());
	articles.setJSP(js);

}
	
// method for the conference articles's table	
public void viewTabbConf() {
	
	
	JScrollPane confSc = seriConf.getscrollConfu();
	articles.setTabe(seriConf.gettabeConfu());
	articles.setJSP(confSc);


}
	//method related to the table for book chapters
public void viewTabbBook() {
	
	
	JScrollPane confSc = seriBook.getscrollBook();
	articles.setTabe(seriBook.gettabeBook());
	articles.setJSP(confSc);


}
}

