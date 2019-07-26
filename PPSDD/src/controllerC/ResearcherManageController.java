package controllerC;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import viewV.*;

import controllerC.*;

import modelM.WriteReadResearcInfoData;

public class ResearcherManageController 
{
	  WriteReadResearcInfoData addRData = new WriteReadResearcInfoData();
	  ResearcherManage resear;
public ResearcherManageController(ResearcherManage v)
{// parameterized constructor
	  this.resear=v;
}
			//For the method to bring out the add form
public void methodFFormResearch()
{// method for the  add research form
				
		resear.buttonFFormResearch(new ActionListener() 
{
					
public void actionPerformed(ActionEvent a)
{	
		resear.addFormResearch();
}
});
}
		
		
		//For the method to View the details of the researchers
public void methodFViewResearch()
{
			
			resear.buttonFViewResearch(new ActionListener() 
{
				
public void actionPerformed(ActionEvent a)
{	
			resear.viewTableFResearch();
}
});	
}
			//For the method to get back to the basicview
public void methodFMainBack()
{
			resear.buttonFBack(new ActionListener() 
{
				
public void actionPerformed(ActionEvent a)
{	
			resear.dispose();
			BasicView baseVv=new BasicView();
					
}
});
}
		
//For the method that helps in the addition of data to the file.
public void methodFFormAdd() 
{
			 
			resear.buttonFRAdd(new ActionListener() 
{
				
public void actionPerformed(ActionEvent a)
{	
	
	
	if(resear.getjTRID().getText().isEmpty() ||resear.getjTRName().getText().isEmpty() ||
			resear.getjTRAddress().getText().isEmpty() ||resear.getjTRPhone().getText().isEmpty()||
			resear.getjTREmail().getText().isEmpty()||resear.getjTRUsername().getText().isEmpty()
			||resear.getjTRPassword().getText().isEmpty()							
)
{
					JOptionPane.showMessageDialog(null, "Completely Fill the Values");
}
	else
		addRData.researWriteFileMetho(resear);
}
});
}
		
// for the table related for the researcher
public void researchTabletab()
{
			
				
				JScrollPane js = addRData.getJSP();
				resear.setTabe(addRData.getTabe());
				resear.setJSP(js);
}
}
	

