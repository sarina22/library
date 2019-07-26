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

public class WriteReadBook {
      ArrayList<SerialMoBook> serialBook = new ArrayList<SerialMoBook>();//Arranging the data of the book chapters in an arraylists
	  SerialMoBook fileswrite;//object
	  // objects required for the JTable
	  DefaultTableModel defaultTabBook = new DefaultTableModel(0, 9);    
	  private JTable tabeBook=new JTable(defaultTabBook);
	  private JScrollPane scrollBook = new JScrollPane(tabeBook);


// method for the filesWrite to the files
public void forWritePrac() 
{
	 		            	
	try {
		FileOutputStream outBook = new FileOutputStream("src/infoStorage/BookChapter.dat");
		ObjectOutputStream objBook = new ObjectOutputStream(outBook);
		objBook.writeObject(serialBook);
		objBook.close();
		}catch (Exception e) { }	
		
}
//constructor for the class
public WriteReadBook() {
		researReadFileMetho();
}

				  	
//Reading from the respected  file data
				@SuppressWarnings("unchecked")
public  ArrayList<SerialMoBook> resReadArrayMethod()
{
		ArrayList<SerialMoBook> initialJouArray = null;
		try{//read from files method
		FileInputStream inBook = new FileInputStream("src/infoStorage/BookChapter.dat");
		ObjectInputStream objjBook = new ObjectInputStream(inBook);
		Object newobjBook= objjBook.readObject();
		initialJouArray = (ArrayList<SerialMoBook>)newobjBook;
		objjBook.close();
           }
		catch (FileNotFoundException e){
        e.printStackTrace();
} catch (IOException e) {
    	e.printStackTrace();
} catch (ClassNotFoundException e) {
        e.printStackTrace();
}
		return initialJouArray;
}
//Method for writing data to the files
public void bookWriteFileMetho(ArticlesManage fromViewRe)
		{
	try {
        fileswrite = new SerialMoBook(fromViewRe.getjTBookAddID().getText(),
        fromViewRe.getjTBTitle().getText(),
	    fromViewRe.getjTBAutho().getText(),fromViewRe.getjTBYear().getText(),
	    fromViewRe.getjTBEditor().getText(),
	    fromViewRe.getjTBPage().getText(),fromViewRe.getjTBLocation().getText(),
	    fromViewRe.getjTBPublisher().getText(),fromViewRe.getjTBookReHire().getText());

   if(resReadArrayMethod()!=null)
{
		 serialBook= resReadArrayMethod();
		 serialBook.add(fileswrite);
		 forWritePrac();			
		  JOptionPane.showMessageDialog(null, "Book Added");
						
}
					
    else {
		  serialBook.add(fileswrite);
		  forWritePrac();		
		  JOptionPane.showMessageDialog(null, "Book Added");
		
		  
		  
		  //catch(NullPointerException nll) {}
	 }
	}
     catch(NullPointerException nll) {

	}
}
	

//respective getters and setters	  	
public JTable gettabeBook() {
	  return tabeBook;
}
public void settabeConfu(JTable tabeConfu) {
	  this.tabeBook = tabeConfu;
}
public JScrollPane getscrollBook() {
	  return scrollBook;
}
public void setscrollBook(JScrollPane scrollBook) {
	  this.scrollBook = scrollBook;
}




				//Mentioned below is the method to read data from the file to JTable
public void researReadFileMetho() {
    if(resReadArrayMethod()!=null) {
		  serialBook=resReadArrayMethod();
		  SerialMoBook serialBooks=new SerialMoBook();
	for(int j=0;j<serialBook.size();j++) {
		  serialBooks=serialBook.get(j);//for the below mentioned getjTRID changed ,getjTRPhone
		  Object[] allReGetDataObj= {serialBooks.getjBID(),serialBooks.getjBTitle(),serialBooks.getjBAuthor(),
		  serialBooks.getjBpublicationYear(),serialBooks.getjBeditors(),serialBooks.getjBpageNum(),
		  serialBooks.getjBLocation(),serialBooks.getjBPublisher(),serialBooks.getjBhireID()};
		  defaultTabBook.addRow(allReGetDataObj);
}
}
					
		  Object getColumnReData[]= {"ID","Title","Author","PublicationYear","Editors","PageNum","Location",
				  "Publisher","HireID"};
		  defaultTabBook.setColumnIdentifiers(getColumnReData);
		  tabeBook.setRowHeight(20);
		  TableColumnModel tableCMoo=tabeBook.getColumnModel();
					
		  tableCMoo.getColumn(0).setPreferredWidth(36);
				
}
				

//Below is the code to edit the data added to the table
public void bookRelatedEdit(ArticlesManage bookEdi, int i) throws FileNotFoundException, IOException {
		 serialBook=resReadArrayMethod();
		 fileswrite= new SerialMoBook(bookEdi.getjTBookViewID(),bookEdi.getjTBookViewTitle(),
		 bookEdi.getjTBookViewAutho(),bookEdi.getjTBookViewYear(),bookEdi.getjTBookViewEdit(),
		 bookEdi.getjTBookViewPage(),bookEdi.getjTBookViewLocat(),bookEdi.getjTBookViewPublisher(),bookEdi.getjTBookReHire().getText());
		 serialBook.set(i,fileswrite);
		 forWritePrac();
         
}
//method to delete the data selected from the table
public void deleteMethodBook(ArticlesManage rese,int i) {
	serialBook=resReadArrayMethod();
	serialBook.remove(i);
	forWritePrac();
    JOptionPane.showMessageDialog(null, " Delete this Book Chapter?");
}


public void loanbookMethod(ArticlesManage mann, int i) throws FileNotFoundException, IOException {
	bookRelatedEdit(mann, i);
	
	JOptionPane.showMessageDialog(null, "Hired");
}
}

			
