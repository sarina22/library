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

import viewV.ArticlesManage;

public class WriteReadConference {
	ArrayList<SerialMoConference> serialConference = new ArrayList<SerialMoConference>();//storing the data of the conference articles in form of arraylist
	SerialMoConference fileswrite;//object
	//related objects created for the table
	DefaultTableModel defaultTabConfu = new DefaultTableModel(0, 8);    
	private JTable tabeConfu=new JTable(defaultTabConfu);
	private JScrollPane scrollConfu = new JScrollPane(tabeConfu);


	//constructor for this class
	public WriteReadConference() {
		researReadFileMetho();
	}
	//Reading from the respected  file data
	@SuppressWarnings("unchecked")
	public  ArrayList<SerialMoConference> resReadArrayMethod()
	{
		ArrayList<SerialMoConference> initialJouArray = null;
		try{
			FileInputStream inputConf = new FileInputStream("src/infoStorage/ConferenceArticles.dat");
			ObjectInputStream objConf = new ObjectInputStream(inputConf);
			Object conferee= objConf.readObject();
			initialJouArray = (ArrayList<SerialMoConference>)conferee;
			objConf.close();
		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}   catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return initialJouArray;

	}
	//Method for writing data to the files
	public void confWriteFileMetho(ArticlesManage fromViewRe)
	{
		try {
			fileswrite = new SerialMoConference(fromViewRe.getjTConfAddID().getText(),
					fromViewRe.getjTConftitle().getText(),fromViewRe.getjTConfAutho().getText(),
					fromViewRe.getjTConfPubli().getText(),fromViewRe.getjTConfEditor().getText(),
					fromViewRe.getjTConfPage().getText(),fromViewRe.getjTConfLocation().getText(),fromViewRe.getjTConfReHire().getText());

			if(resReadArrayMethod()!=null)
			{
				serialConference= resReadArrayMethod();
				serialConference.add(fileswrite);

				try {
					FileOutputStream outConf = new FileOutputStream("src/infoStorage/ConferenceArticles.dat");
					ObjectOutputStream objConf = new ObjectOutputStream(outConf);
					objConf.writeObject(serialConference);
					objConf.close();

				}catch (Exception e) { }	
				JOptionPane.showMessageDialog(null, "Conference Added");

			}
			else {
				serialConference.add(fileswrite);

				try {
					FileOutputStream outConf = new FileOutputStream("src/infoStorage/ConferenceArticles.dat");
					ObjectOutputStream objConf = new ObjectOutputStream(outConf);
					objConf.writeObject(serialConference);
					objConf.close();

				}catch (Exception e) { }	
				JOptionPane.showMessageDialog(null, "Conference Added");
			}
		}
		catch(NullPointerException nll) {

		}
	}

	//Adding the tableColumnModel ,adding data rowwise to the table
	public void researReadFileMetho() 
	{

		if(resReadArrayMethod()!=null) {
			serialConference=resReadArrayMethod();
			SerialMoConference serialConf=new SerialMoConference();
			for(int j=0;j<serialConference.size();j++) {
				serialConf=serialConference.get(j);//for the below mentioned getjTRID changed ,getjTRPhone
				Object[] allReGetDataObj= {serialConf.getjCID(),serialConf.getjCTitle(),
						serialConf.getjCAuthor(),serialConf.getjCpublicationYear(),serialConf.getjCeditors(),
						serialConf.getjCpageNum(),serialConf.getjCLocation(),serialConf.getjChiredId()};
				defaultTabConfu.addRow(allReGetDataObj);
			}
		}

		Object getColumnReData[]= {"ID","Title","Author","PublicationYear","Editors","PageNum","Location","HiredID"};
		defaultTabConfu.setColumnIdentifiers(getColumnReData);
		tabeConfu.setRowHeight(20);
		TableColumnModel tableCMoo=tabeConfu.getColumnModel();
		tableCMoo.getColumn(0).setPreferredWidth(5);
		tableCMoo.getColumn(1).setPreferredWidth(200);
	}


	//method for editing the data from the table for the conference articles
	public void editrelatedToConf(ArticlesManage ediConfe, int i) throws FileNotFoundException, IOException {
		serialConference=resReadArrayMethod();
		fileswrite= new SerialMoConference(ediConfe.getjTConfViewID(),ediConfe.getjTConfViewTitle(),
				ediConfe.getjTConfViewAutho(),ediConfe.getjTConfViewYear(),ediConfe.getjTConfViewEdit(),
				ediConfe.getjTConfViewPage(),ediConfe.getjTConfViewLocat(),ediConfe.getjTConfReHire().getText());
		serialConference.set(i,fileswrite);
		try {//write code
			FileOutputStream outConf = new FileOutputStream("src/infoStorage/ConferenceArticles.dat");
			ObjectOutputStream objConf = new ObjectOutputStream(outConf);
			objConf.writeObject(serialConference);
			objConf.close();

		}catch (Exception e) { }	
		//JOptionPane.showMessageDialog(null, "Conference Edited");
	}
	//related getters and setters for the respective attributes above
	public JTable gettabeConfu() {
		return tabeConfu;
	}
	public void settabeConfu(JTable tabeConfu) {
		this.tabeConfu = tabeConfu;
	}

	public JScrollPane getscrollConfu() {
		return scrollConfu;
	}
	public void setscrollConfu(JScrollPane scrollConfu) {
		this.scrollConfu = scrollConfu;
	}



	// Below method shows the method for deleting the realted conference articles
	public void deleteMethodConference(ArticlesManage rese,int i) 
	{
		serialConference=resReadArrayMethod();
		serialConference.remove(i);
		try {
			FileOutputStream outConf = new FileOutputStream("src/infoStorage/ConferenceArticles.dat");
			ObjectOutputStream objConf = new ObjectOutputStream(outConf);
			objConf.writeObject(serialConference);
			objConf.close();

		}catch (Exception e) { }	

		JOptionPane.showMessageDialog(null, " Delete this Article?");
	}

	public void loanconfMethod(ArticlesManage mann, int i) throws FileNotFoundException, IOException {
		editrelatedToConf(mann, i);
		JOptionPane.showMessageDialog(null, "Hired");
	}

}


