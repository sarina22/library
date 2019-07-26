package modelM;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;


import viewV.*;


public class WriteReadResearcInfoData { 
	    //creating objects for the the display of the table
	  DefaultTableModel DTM = new DefaultTableModel(0, 7);    
	    private JTable tabe=new JTable(DTM);//object for jTable
		private JScrollPane JSP = new JScrollPane(tabe);//object for the scrollpane
		//creation of arraylist for the related researchers data
    ArrayList<SerialMoResearch> serialResearch = new ArrayList<SerialMoResearch>();
	SerialMoResearch fileswrite;
  


// basic constructor for the related class            	     
 public WriteReadResearcInfoData() {
		researReadFileMetho();
}
//Reading from the respected  file data
	@SuppressWarnings("unchecked")
public  ArrayList<SerialMoResearch> resReadArrayMethod()
{
		ArrayList<SerialMoResearch> initialSeArray = null;
	try{//read file method for researcher.dat
		FileInputStream ResRead = new FileInputStream("src/infoStorage/Researcher.dat");
		ObjectInputStream researchObj = new ObjectInputStream(ResRead);
		Object resu= researchObj.readObject();
		initialSeArray = (ArrayList<SerialMoResearch>)resu;
		researchObj.close();


		}
catch (FileNotFoundException e)
{
       e.printStackTrace();
} catch (IOException e) 
	{
			
		e.printStackTrace();
} catch (ClassNotFoundException e)
{
		e.printStackTrace();
}
return initialSeArray;
	
	}
//Method for writing data to the files
public void researWriteFileMetho(ResearcherManage fromViewRe)
{
		fileswrite = new SerialMoResearch(fromViewRe.getjTRID().getText(),
		fromViewRe.getjTRName().getText(),fromViewRe.getjTRAddress().getText(),
		fromViewRe.getjTRPhone().getText(),fromViewRe.getjTREmail().getText(),
		fromViewRe.getjTRUsername().getText(),fromViewRe.getjTRPassword().getText().toCharArray());

if(resReadArrayMethod()!=null)
{
		serialResearch= resReadArrayMethod();
		serialResearch.add(fileswrite);
		newest();
		JOptionPane.showMessageDialog(null, "Researcher Added");
			
}
		
else {
		newest();
		JOptionPane.showMessageDialog(null, "Researcher Added");
}
}
	
	//Mentioned below is the method to read data from the file to JTable
public void researReadFileMetho() 
{
		
if(resReadArrayMethod()!=null) {
		serialResearch=resReadArrayMethod();
		SerialMoResearch serialRee=new SerialMoResearch();
for(int j=0;j<serialResearch.size();j++) {
		serialRee=serialResearch.get(j);//for the below mentioned getjTRID changed ,getjTRPhone
		Object[] allReGetDataObj= {serialRee.getSEID(),serialRee.getSEName(),
		serialRee.getSEAddress(),serialRee.getSEPhone(),serialRee.getSEEmail(),
		serialRee.getSEUsername(),serialRee.getSEPassword()};
		DTM.addRow(allReGetDataObj);
}
		}
		
		Object getColumnReData[]= {"ID","Name","Address","PhoneNum","EmailAddress","Username","Password"};
		DTM.setColumnIdentifiers(getColumnReData);
		tabe.setRowHeight(20);
		
}
	
	
	//edit all the data related to the researchers for the library system
public void editRelatedResear(ResearcherManage reMAnagE, int i) throws FileNotFoundException, IOException 
{
		
		serialResearch=resReadArrayMethod();
		fileswrite= new SerialMoResearch(reMAnagE.getID(),reMAnagE.getName(),
				reMAnagE.getAddress(),reMAnagE.getContact(),reMAnagE.getEmail(),
				reMAnagE.getUsername(),reMAnagE.getPassword().toCharArray());
		serialResearch.set(i,fileswrite);
		newest();
		JOptionPane.showMessageDialog(null, "Researcher Edited");
		
}
	// method for the write data to file
public void newest() {
		
try {
	 	FileOutputStream researchFileOut = new FileOutputStream("src/infoStorage/Researcher.dat");
		ObjectOutputStream researchObjectOut = new ObjectOutputStream(researchFileOut);
		researchObjectOut.writeObject(serialResearch);
		researchObjectOut.close();
		
}catch (Exception e) { }	
	
}
//delete related for the researchers
public void delRelatedResearcher(ResearcherManage reDelEdi,int i) {
		serialResearch=resReadArrayMethod();
		serialResearch.remove(i);
		newest();
		JOptionPane.showMessageDialog(null, "Researcher Deleted");
}
//for the getters and setters		  	
public JTable getTabe() {
	return tabe;
}
public void setTabe(JTable tabe) {
	this.tabe = tabe;
}
public JScrollPane getJSP() {
	return JSP;
}
public void setJSP(JScrollPane jSP) {
	JSP = jSP;
}

}











