package modelM;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import viewV.ArticlesManage;
import viewV.ResearcherManage;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public class WriteReadJournal
{  // creating related objects for the table
	private static final long serialVersionUID = 1L;
	DefaultTableModel DTM = new DefaultTableModel(0, 7);    
	public JTable tabe=new JTable(DTM);
	public JScrollPane JSP = new JScrollPane(tabe);

	// arranging the data for the journal articles in an arraylist object.
	ArrayList<SerialMoJournal> serialJournal = new ArrayList<SerialMoJournal>();
	SerialMoJournal fileswrite;


	// constructor for the respective class         
	public WriteReadJournal()
	{
		researReadFileMetho();
	}        


	//file write code for the  data of journal articles
	public void readJournu() 
	{

		try {
			FileOutputStream writeJoo = new FileOutputStream("src/infoStorage/JournalArticles.dat");
			ObjectOutputStream objJoo = new ObjectOutputStream(writeJoo);
			objJoo.writeObject(serialJournal);
			objJoo.close();

		}catch (Exception e) { }	
	}


	//Reading from the journal articles files
	@SuppressWarnings("unchecked")
	public  ArrayList<SerialMoJournal> resReadArrayMethod()
	{
		ArrayList<SerialMoJournal> initialJouArray = null;
		try{//file read code
			FileInputStream readJoo = new FileInputStream("src/infoStorage/JournalArticles.dat");
			ObjectInputStream objJoo = new ObjectInputStream(readJoo);
			Object oJourn= objJoo.readObject();
			initialJouArray = (ArrayList<SerialMoJournal>)oJourn;
			objJoo.close();
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
		return initialJouArray;

	}

	//related getter and setter for the table	
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




	//Method for writing data to the files
	public void journalWriteFileMetho(ArticlesManage fromViewRe)
	{ try {
		fileswrite = new SerialMoJournal(fromViewRe.getjTJooAddID().getText(),
				fromViewRe.getjTJootitle().getText(),fromViewRe.getjTJooAutho().getText(),
				fromViewRe.getjTJooYear().getText(),fromViewRe.getjTJooVolu().getText(),
				fromViewRe.getjTJooPage().getText(),fromViewRe.getjTJooReHire().getText());

		if(resReadArrayMethod()!=null)
		{
			serialJournal= resReadArrayMethod();
			serialJournal.add(fileswrite);
			readJournu();
			JOptionPane.showMessageDialog(null, "Journal Added");
		}
		else {
			serialJournal.add(fileswrite);
			readJournu();
			JOptionPane.showMessageDialog(null, "Journal Added");
		}
	}
	catch(NullPointerException nll) {

	}
	}

	//Mentioned below is the method to read data from the file to JTable
	public void researReadFileMetho() {

		if(resReadArrayMethod()!=null) {
			serialJournal=resReadArrayMethod();
			SerialMoJournal serialJoo=new SerialMoJournal();
			for(int j=0;j<serialJournal.size();j++) {
				serialJoo=serialJournal.get(j);//for the below mentioned getjTRID changed ,getjTRPhone
				Object[] allReGetDataObj= {serialJoo.getJEID(),serialJoo.getJJTitle(),serialJoo.getJAuthor(),
						serialJoo.getJpublicationYear(),serialJoo.getJvolumeNum(),serialJoo.getJpageNum(),serialJoo.getJHiredId()};
				DTM.addRow(allReGetDataObj);
			}
		}

		Object getColumnReData[]= {"ID","Title","Author","PublicationYear","VolumeNum","PageNum", "Hired To"};
		DTM.setColumnIdentifiers(getColumnReData);
		tabe.setRowHeight(20);
		TableColumnModel tableCMoo=tabe.getColumnModel();
		tableCMoo.getColumn(0).setPreferredWidth(5);
		tableCMoo.getColumn(1).setPreferredWidth(200);
	}

	//code related to the edit of the added data for the journal articles
	public void editRelatedToJournal(ArticlesManage ediJoo, int i) throws FileNotFoundException, IOException {
		serialJournal=resReadArrayMethod();
		fileswrite= new SerialMoJournal(ediJoo.getjTJooViewID(),ediJoo.getjTJooViewTitle(),
				ediJoo.getjTJooViewAutho(),ediJoo.getjTJooViewPubli(),ediJoo.getjTJooViewVolu(),
				ediJoo.getjTJooViewPage(), ediJoo.getjTJooReHire().getText());
		serialJournal.set(i,fileswrite);
		readJournu();

	}

	// method mentioned below is for the  deletion of the related journal articles
	public void deleteMethodJournal(ArticlesManage rese,int i) {
		serialJournal=resReadArrayMethod();
		serialJournal.remove(i);
		readJournu();
	}

	public void loanjournMethod(ArticlesManage mann, int i) throws FileNotFoundException, IOException {
		editRelatedToJournal(mann, i);
		JScrollPane js =getJSP();
		setTabe(getTabe());
		setJSP(js);
		JOptionPane.showMessageDialog(null, "Hired");
	}
}