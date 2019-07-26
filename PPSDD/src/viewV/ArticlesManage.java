package viewV;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controllerC.ArticlesManageController;
import controllerC.ResearcherManageController;
import modelM.WriteReadBook;
import modelM.WriteReadConference;
import modelM.WriteReadJournal;


import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
public class ArticlesManage extends JFrame {
	WriteReadJournal WRjournal = new WriteReadJournal();
	WriteReadConference WRConf=new WriteReadConference();
	WriteReadBook WRBook=new WriteReadBook();
   private JPanel panelside,panelcenter;
   public JButton jButtonJournaArticle,jButtonConferencArticle,jButtonBookChap,jBViewJArticle,jBViewCArticle,jBViewBook,
	jBack;
	//attributes/objects to bring out the table for the journal articles
	
	//DefaultTableModel DTM = new DefaultTableModel();
    private JTable tabe=new JTable();
    private JScrollPane JSP ;          
    private int getJooII;
    public void setIndex(int i) {getJooII= i;}
    
  
	//attributes for the addition of journal articles
	private JButton jBJournAdd,jBJournReset;
	private JTextField jTJootitle,jTJooAddID,jTJooAutho,jTJooYear,jTJooVolu,jTJooPage;
	//attributes for the edit of the journal data
	private JButton jVieJournButtonEdit,jVieJournButtonDelete,jVieJournButtonHire,jVieJournButtonReturn;
	private JTextField jTJooViewID,jTJooViewTitle,jTJooViewAutho,
	jTJooViewPubli,jTJooViewVolu,jTJooViewPage,jTJooReHire;
	
	//attributes for the addition of conference articles
	private JTextField jTConftitle,jTConfAddID,jTConfAutho,jTConfPubli,jTConfEditor,
	jTConfPage,jTConfLocation;
	private JButton jBConfAdd,jBConfReset;
	//attributes for the edit of the conference articles
	private JTextField jTConfViewID,jTConfViewTitle,jTConfViewAutho,
	jTConfViewYear, jTConfViewEdit,jTConfViewPage,jTConfViewLocat,jTConfReHire;
	private JButton jVieConfButtonEdit,jVieConfButtonDelete,jVieConfButtonHire,jVieConfButtonReturn;
	
	
	//attributes for the add form of  book chapters
	private JTextField jTBTitle,jTBookAddID,jTBAutho,jTBYear,jTBEditor,jTBPage,jTBLocation,jTBPublisher;
	private JButton jBBookAdd; 
   //attributes for the edit form of the book chapters
	private JTextField jTBookViewTitle,jTBookViewID,jTBookViewAutho,
	jTBookViewYear,jTBookViewEdit,jTBookViewPage,jTBookViewLocat,jTBookViewPublisher,jTBookReHire;
	private JButton jVieBookButtonEdit,jVieBookButtonDelete,jVieBookButtonHire,jVieBookButtonReturn;
	


	
	// Basic page view for the articles manage
public ArticlesManage() 
{
		
		setSize(900,720);
	    setBounds(0,0,900,720);
	    setTitle("NORTHAMPTON RESEARCH CENTER");
	    //setFont(new Font("Sitka Text", Font.BOLD, 16));
	    setDefaultCloseOperation(EXIT_ON_CLOSE); 
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		Container contain= getContentPane();
		//contain.setBackground(new Color(119, 136, 153));
		setVisible(true);
		contain.setLayout(null);
	     
		
		panelside=new JPanel();
		panelside.setBounds(0,0,180,720);
		panelside.setBackground(new Color(109, 146, 153));
		panelside.setLayout(null);
		//panelside.setBackground(Color.BLACK);
		contain.add(panelside);
		
		 JLabel jAddTopic=new JLabel("Add");
		 jAddTopic.setBounds(59,10,70,30);
		 jAddTopic.setBackground(Color.WHITE);
		 jAddTopic.setFont(new Font("Tahoma", Font.BOLD, 20));
		 panelside.add(jAddTopic);
		 
		 JPanel jLinePanel=new JPanel();
		 jLinePanel.setBounds(4,40,180,6);
		 jLinePanel.setBackground(Color.CYAN);
		 panelside.add(jLinePanel);
		
		jButtonJournaArticle=new JButton("Journal Articles");
		jButtonJournaArticle.setBounds(15,60,150,35);
		panelside.add(jButtonJournaArticle);
		
		
		jButtonConferencArticle=new JButton("Conference Articles");
		jButtonConferencArticle.setBounds(15,130,150,35);
		panelside.add(jButtonConferencArticle);
		
		
		jButtonBookChap=new JButton("Book Chapters");
		jButtonBookChap.setBounds(15,200,150,35);
		panelside.add(jButtonBookChap);
		
		JLabel jViewTopic= new JLabel("View");
		jViewTopic.setBounds(55,265,70,30);
		jViewTopic.setBackground(Color.WHITE);
		jViewTopic.setFont(new Font("Tahoma", Font.BOLD, 20));
		 panelside.add(jViewTopic);
		 
		 
		 JPanel jLinePanel2=new JPanel();
		 jLinePanel2.setBounds(4,300,180,6);
		 jLinePanel2.setBackground(Color.CYAN);
		 panelside.add(jLinePanel2);
		 
		
		
		jBViewJArticle=new JButton("Journal Article");
		jBViewJArticle.setBounds(15,316,150,35);
		panelside.add(jBViewJArticle);
		
		jBViewCArticle=new JButton("Conference Article");
		jBViewCArticle.setBounds(15,372,150,35);
		panelside.add(jBViewCArticle);
		
		jBViewBook=new JButton("Book Chapters");
		jBViewBook.setBounds(15,428,150,35);
		panelside.add(jBViewBook);
		
		
	  
		 
	    jBack=new JButton("BACK");
		jBack.setBounds(0,640,90,40);
		jBack.setBackground(Color.BLACK);
		jBack.setForeground(Color.WHITE);
		panelside.add(jBack);
		
		
		panelcenter=new JPanel();
		panelcenter.setBounds(180,0,720,720);
        contain.add(panelcenter);
		
        JLabel centerTopic=new JLabel("Articles Manage Panel");
        
        centerTopic.setBounds(250,300,200,200);
        centerTopic.setFont(new Font("Sitka Text", Font.BOLD, 36));
        panelcenter.add(centerTopic);
        
        
		// method call for the controllers
		ArticlesManageController artiConcc=new ArticlesManageController(this);
		artiConcc.clickMethodAddJournal();
		artiConcc.clickMethodAddConference();
		artiConcc.clickMethodAddBook();
		artiConcc.clickMainBack();
		artiConcc.clickMethodViewJournal();
		artiConcc.clickMethodViewConference();
		artiConcc.clickMethodViewBooks();
		
		
		
	}
	//actionListener for the related buttons 
public void buttonFFormJournal(ActionListener a)
{ jButtonJournaArticle.addActionListener(a); }

public void buttonFFormConference(ActionListener a)
	{ jButtonConferencArticle.addActionListener(a);}

public void buttonFFormBookCh(ActionListener a)
	{ jButtonBookChap.addActionListener(a);}

	
public void buttonviewJournal(ActionListener a)
	{ jBViewJArticle.addActionListener(a);}
	
public void buttonviewConference(ActionListener a)
	{ jBViewCArticle.addActionListener(a);}
	
public void buttonviewBookCh(ActionListener a)
	{ jBViewBook.addActionListener(a);}
	
	
public void buttonBack(ActionListener a)
	{ jBack.addActionListener(a);}

	
	//The below method is a form for adding a new Journal Article.
public void addJournal()
	{
	panelcenter.removeAll();
	panelcenter.setLayout(null);
	
	
	JLabel mainJournTitle=new JLabel("Add Journal Articles");
	mainJournTitle.setFont(new Font("Italic",Font.BOLD,25));
	mainJournTitle.setBounds(260,20,290,30);
	panelcenter.add(mainJournTitle);
	
	
	 
		JLabel jLtitle=new JLabel("Title");
		jLtitle.setBounds(150,70,40,20);
		jLtitle.setBackground(Color.BLACK);
		jLtitle.setFont(new Font("Tahoma",Font.BOLD,17));
		panelcenter.add(jLtitle);
		
		
		 jTJootitle=new JTextField();
		jTJootitle.setBounds(330,70,150,35);
		panelcenter.add(jTJootitle);
		
		JLabel jLJooAddID=new JLabel("ID");
		jLJooAddID.setBounds(510,72,40,20);
		jLJooAddID.setBackground(Color.BLACK);
		jLJooAddID.setFont(new Font("Tahoma",Font.BOLD,17));
		panelcenter.add(jLJooAddID);
		
		
		 jTJooAddID=new JTextField();
		jTJooAddID.setBounds(540,70,100,35);
		panelcenter.add(jTJooAddID);
		
		
		
		
		
		JLabel jLJooautho=new JLabel("Author");
		jLJooautho.setBounds(150,150,70,20);
		jLJooautho.setBackground(Color.BLACK);
		jLJooautho.setFont(new Font("Tahoma",Font.BOLD,17));
		panelcenter.add(jLJooautho);
		
		 jTJooAutho=new JTextField();
		jTJooAutho.setBounds(330,150,150,35);
		panelcenter.add(jTJooAutho);
		
		
		JLabel jLJooYear=new JLabel("Publication Year");
		jLJooYear.setBounds(150,230,150,20);
		jLJooYear.setBackground(Color.BLACK);
		jLJooYear.setFont(new Font("Tahoma",Font.BOLD,17));
		panelcenter.add(jLJooYear);
		
		
		 jTJooYear=new JTextField();
		jTJooYear.setBounds(330,230,150,35);
		panelcenter.add(jTJooYear);
		
		
		JLabel volume=new JLabel("Volume Number");
		volume.setBounds(150,310,150,20);
		volume.setBackground(Color.BLACK);
		volume.setFont(new Font("Tahoma",Font.BOLD,17));
		panelcenter.add(volume);
		
		
		 jTJooVolu=new JTextField();
		jTJooVolu.setBounds(330,310,150,35);
		panelcenter.add(jTJooVolu);
		
		
		JLabel jLJooPage=new JLabel("Page Number");
		jLJooPage.setBounds(150,390,150,20);
		jLJooPage.setBackground(Color.BLACK);
		jLJooPage.setFont(new Font("Tahoma",Font.BOLD,17));
		panelcenter.add(jLJooPage);
		
		
		 jTJooPage=new JTextField();
		jTJooPage.setBounds(330,390,150,35);
		panelcenter.add(jTJooPage);
		
		
		 jBJournAdd=new JButton("ADD");
		jBJournAdd.setBounds(200,450,90,35);
		jBJournAdd.setFont(new Font("Tahoma",Font.BOLD,17));
		panelcenter.add(jBJournAdd);
		
		
		 jBJournReset=new JButton("RESET");
		jBJournReset.setBounds(400,450,90,35);
		jBJournReset.setFont(new Font("Tahoma",Font.BOLD,17));
		panelcenter.add(jBJournReset);
		
			
        revalidate();
        repaint();
//controller call
  ArticlesManageController amc=new ArticlesManageController(this);
  amc.individualAddJournal();
	
}
	
	//getter and setter for the related attributes
public JTextField getjTJootitle() {
		return jTJootitle;
	}

public void setjTJootitle(JTextField jTJootitle) {
		this.jTJootitle = jTJootitle;
	}

public JTextField getjTJooAddID() {
		return jTJooAddID;
	}

public void setjTJooAddID(JTextField jTJooAddID) {
		this.jTJooAddID = jTJooAddID;
	}

public JTextField getjTJooAutho() {
		return jTJooAutho;
	}

public void setjTJooAutho(JTextField jTJooAutho) {
		this.jTJooAutho = jTJooAutho;
	}

public JTextField getjTJooYear() {
		return jTJooYear;
	}

public void setjTJooYear(JTextField jTJooYear) {
		this.jTJooYear = jTJooYear;
	}

public JTextField getjTJooVolu() {
		return jTJooVolu;
	}

public void setjTJooVolu(JTextField jTJooVolu) {
		this.jTJooVolu = jTJooVolu;
	}

public JTextField getjTJooPage() {
		return jTJooPage;
	}

public void setjTJooPage(JTextField jTJooPage) {
		this.jTJooPage = jTJooPage;
	}

public void buttonJournAdd(ActionListener a) {
		jBJournAdd.addActionListener(a);
	}
	
	
//The below method is for a form to add Conference Article
public void addConference()
{
	
	panelcenter.removeAll();
	panelcenter.setLayout(null);
	
	JLabel mainConTitle=new JLabel("Add Conference Articles");
	mainConTitle.setFont(new Font("Italic",Font.BOLD,25));
	mainConTitle.setBounds(260,20,290,30);
	panelcenter.add(mainConTitle);
	
	

	JLabel jLConftitle=new JLabel("Title");
	jLConftitle.setBounds(150,70,40,20);
	jLConftitle.setBackground(Color.BLACK);
	jLConftitle.setFont(new Font("Tahoma",Font.BOLD,17));
	panelcenter.add(jLConftitle);
	
	
	 jTConftitle=new JTextField();
	jTConftitle.setBounds(330,70,150,35);
	panelcenter.add(jTConftitle);
	
	
	JLabel jLCooAddID=new JLabel("ID");
	jLCooAddID.setBounds(510,72,40,20);
	jLCooAddID.setBackground(Color.BLACK);
	jLCooAddID.setFont(new Font("Tahoma",Font.BOLD,17));
	panelcenter.add(jLCooAddID);
	
	
	 jTConfAddID=new JTextField();
	jTConfAddID.setBounds(540,70,100,35);
	panelcenter.add(jTConfAddID);
	

	JLabel jLConfAutho=new JLabel("Author");
	jLConfAutho.setBounds(150,150,70,20);
	jLConfAutho.setBackground(Color.BLACK);
	jLConfAutho.setFont(new Font("Tahoma",Font.BOLD,17));
	panelcenter.add(jLConfAutho);
	
	 jTConfAutho=new JTextField();
	jTConfAutho.setBounds(330,150,150,35);
	panelcenter.add(jTConfAutho);
	
	
	JLabel jLConfYear=new JLabel("Publication Year");
	jLConfYear.setBounds(150,230,150,20);
	jLConfYear.setBackground(Color.BLACK);
	jLConfYear.setFont(new Font("Tahoma",Font.BOLD,17));
	panelcenter.add(jLConfYear);
	
	
	 jTConfPubli=new JTextField();
	jTConfPubli.setBounds(330,230,150,35);
	panelcenter.add(jTConfPubli);
	
	
	JLabel jLConfEditor=new JLabel("Editors");
	jLConfEditor.setBounds(150,310,150,20);
	jLConfEditor.setBackground(Color.BLACK);
	jLConfEditor.setFont(new Font("Tahoma",Font.BOLD,17));
	panelcenter.add(jLConfEditor);
	
	
	 jTConfEditor=new JTextField();
	jTConfEditor.setBounds(330,310,150,35);
	panelcenter.add(jTConfEditor);
	
	
	JLabel jLConfpage=new JLabel("Page Number");
	jLConfpage.setBounds(150,390,150,20);
	jLConfpage.setBackground(Color.BLACK);
	jLConfpage.setFont(new Font("Tahoma",Font.BOLD,17));
	panelcenter.add(jLConfpage);
	
	
	 jTConfPage=new JTextField();
	jTConfPage.setBounds(330,390,150,35);
	panelcenter.add(jTConfPage);
	
	
	
	JLabel jLConfLocation=new JLabel("Location");
	jLConfLocation.setBounds(150,470,150,20);
	jLConfLocation.setBackground(Color.BLACK);
	jLConfLocation.setFont(new Font("Tahoma",Font.BOLD,17));
	panelcenter.add(jLConfLocation);
	
	
	 jTConfLocation=new JTextField();
	jTConfLocation.setBounds(330,470,150,35);
	panelcenter.add(jTConfLocation);

	
	 jBConfAdd=new JButton("ADD");
	jBConfAdd.setBounds(200,550,90,35);
	jBConfAdd.setFont(new Font("Tahoma",Font.BOLD,17));
	panelcenter.add(jBConfAdd);
	
	
	 jBConfReset=new JButton("RESET");
	jBConfReset.setBounds(400,550,90,35);
	jBConfReset.setFont(new Font("Tahoma",Font.BOLD,17));
	panelcenter.add(jBConfReset);
	
	
	
    revalidate();
    repaint();	

ArticlesManageController amc=new ArticlesManageController(this);
amc.individualAddConference();
		
}


//Getter and setter for the textFields of the  Add form of conference Articles
	
public JTextField getjTConftitle() {
	return jTConftitle;
}


public void setjTConftitle(JTextField jTConftitle) {
	this.jTConftitle = jTConftitle;
}


public JTextField getjTConfAddID() {
	return jTConfAddID;
}


public void setjTConfAddID(JTextField jTConfAddID) {
	this.jTConfAddID = jTConfAddID;
}


public JTextField getjTConfAutho() {
	return jTConfAutho;
}


public void setjTConfAutho(JTextField jTConfAutho) {
	this.jTConfAutho = jTConfAutho;
}


public JTextField getjTConfPubli() {
	return jTConfPubli;
}


public void setjTConfPubli(JTextField jTConfPubli) {
	this.jTConfPubli = jTConfPubli;
}


public JTextField getjTConfEditor() {
	return jTConfEditor;
}


public void setjTConfEditor(JTextField jTConfEditor) {
	this.jTConfEditor = jTConfEditor;
}


public JTextField getjTConfPage() {
	return jTConfPage;
}


public void setjTConfPage(JTextField jTConfPage) {
	this.jTConfPage = jTConfPage;
}


public JTextField getjTConfLocation() {
	return jTConfLocation;
}


public void setjTConfLocation(JTextField jTConfLocation) {
	this.jTConfLocation = jTConfLocation;
}

public void buttonConfAdd(ActionListener a) {
	jBConfAdd.addActionListener(a);
}

public JButton getjBConfReset() {
	return jBConfReset;
}


public void setjBConfReset(JButton jBConfReset) {
	this.jBConfReset = jBConfReset;
}

//method for the add form of the book chapter
public void addBook() {
	
	panelcenter.removeAll();
	panelcenter.setLayout(null);
	
	
	JLabel mainTitle=new JLabel("Add Book");
	mainTitle.setFont(new Font("Italic",Font.BOLD,25));
	mainTitle.setBounds(290,20,150,30);
	panelcenter.add(mainTitle);
	
	
	JLabel jLBtitle=new JLabel("Title");
	jLBtitle.setBounds(150,70,40,20);
	jLBtitle.setBackground(Color.BLACK);
	jLBtitle.setFont(new Font("Tahoma",Font.BOLD,17));
	panelcenter.add(jLBtitle);
	
	
	 jTBTitle=new JTextField();
	jTBTitle.setBounds(330,70,150,35);
	panelcenter.add(jTBTitle);
	
	
	JLabel jLBookAddID=new JLabel("ID");
	jLBookAddID.setBounds(510,72,40,20);
	jLBookAddID.setBackground(Color.BLACK);
	jLBookAddID.setFont(new Font("Tahoma",Font.BOLD,17));
	panelcenter.add(jLBookAddID);
	
	
	 jTBookAddID=new JTextField();
	jTBookAddID.setBounds(540,70,100,35);
	panelcenter.add(jTBookAddID);
	
	
	JLabel jLBAutho=new JLabel("Author");
	jLBAutho.setBounds(150,150,70,20);
	jLBAutho.setBackground(Color.BLACK);
	jLBAutho.setFont(new Font("Tahoma",Font.BOLD,17));
	panelcenter.add(jLBAutho);
	
	 jTBAutho=new JTextField();
	jTBAutho.setBounds(330,150,150,35);
	panelcenter.add(jTBAutho);
	
	
	JLabel jLBYear=new JLabel("Publication Year");
	jLBYear.setBounds(150,230,150,20);
	jLBYear.setBackground(Color.BLACK);
	jLBYear.setFont(new Font("Tahoma",Font.BOLD,17));
	panelcenter.add(jLBYear);
	
	
	 jTBYear=new JTextField();
	jTBYear.setBounds(330,230,150,35);
	panelcenter.add(jTBYear);
	
	
	JLabel jLBEditor=new JLabel("Editors");
	jLBEditor.setBounds(150,310,150,20);
	jLBEditor.setBackground(Color.BLACK);
	jLBEditor.setFont(new Font("Tahoma",Font.BOLD,17));
	panelcenter.add(jLBEditor);
	
	
	 jTBEditor=new JTextField();
	jTBEditor.setBounds(330,310,150,35);
	panelcenter.add(jTBEditor);
	
	
	JLabel jLBpage=new JLabel("Page Number");
	jLBpage.setBounds(150,390,150,20);
	jLBpage.setBackground(Color.BLACK);
	jLBpage.setFont(new Font("Tahoma",Font.BOLD,17));
	panelcenter.add(jLBpage);
	
	
	 jTBPage=new JTextField();
	jTBPage.setBounds(330,390,150,35);
	panelcenter.add(jTBPage);
	
	
	
	JLabel jLBLocation=new JLabel("Place of Publication");
	jLBLocation.setBounds(150,470,180,20);
	jLBLocation.setBackground(Color.BLACK);
	jLBLocation.setFont(new Font("Tahoma",Font.BOLD,17));
	panelcenter.add(jLBLocation);
	
	
	 jTBLocation=new JTextField();
	jTBLocation.setBounds(330,470,150,35);
	panelcenter.add(jTBLocation);

	JLabel jLBPublisher=new JLabel("Publisher");
	jLBPublisher.setBounds(150,550,150,20);
	jLBPublisher.setBackground(Color.BLACK);
	jLBPublisher.setFont(new Font("Tahoma",Font.BOLD,17));
	panelcenter.add(jLBPublisher);
	
	
	 jTBPublisher=new JTextField();
	jTBPublisher.setBounds(330,550,150,35);
	panelcenter.add(jTBPublisher);

	
	
	 jBBookAdd=new JButton("ADD");
	jBBookAdd.setBounds(200,610,90,35);
	jBBookAdd.setFont(new Font("Tahoma",Font.BOLD,17));
	panelcenter.add(jBBookAdd);
	
	
	JButton jBBookReset=new JButton("RESET");
	jBBookReset.setBounds(400,610,90,35);
	jBBookReset.setFont(new Font("Tahoma",Font.BOLD,17));
	panelcenter.add(jBBookReset);
	
	
	revalidate();
	repaint();	
	
	ArticlesManageController amc=new ArticlesManageController(this);
	amc.individualAddBook();
	
	
}
//button listener
public void buttonBookAdd(ActionListener a) {
	jBBookAdd.addActionListener(a);
}


//getters and setters for the texfields
public JTextField getjTBTitle() {
	return jTBTitle;
}


public void setjTBTitle(JTextField jTBTitle) {
	this.jTBTitle = jTBTitle;
}


public JTextField getjTBookAddID() {
	return jTBookAddID;
}


public void setjTBookAddID(JTextField jTBookAddID) {
	this.jTBookAddID = jTBookAddID;
}


public JTextField getjTBAutho() {
	return jTBAutho;
}


public void setjTBAutho(JTextField jTBAutho) {
	this.jTBAutho = jTBAutho;
}


public JTextField getjTBYear() {
	return jTBYear;
}


public void setjTBYear(JTextField jTBYear) {
	this.jTBYear = jTBYear;
}


public JTextField getjTBEditor() {
	return jTBEditor;
}


public void setjTBEditor(JTextField jTBEditor) {
	this.jTBEditor = jTBEditor;
}


public JTextField getjTBPage() {
	return jTBPage;
}


public void setjTBPage(JTextField jTBPage) {
	this.jTBPage = jTBPage;
}


public JTextField getjTBLocation() {
	return jTBLocation;
}


public void setjTBLocation(JTextField jTBLocation) {
	this.jTBLocation = jTBLocation;
}


public JTextField getjTBPublisher() {
	return jTBPublisher;
}


public void setjTBPublisher(JTextField jTBPublisher) {
	this.jTBPublisher = jTBPublisher;
}


//Mentioned below is  the view/storage of the data of the articles added to the library.	
public void viewJournalsA() {
	
	panelcenter.removeAll();
	panelcenter.setLayout(null);
	
	
	ArticlesManageController reCc=new ArticlesManageController(this);
	reCc.viewla();
 
	//THe code below is for the table
	JSP=new JScrollPane(tabe);
	JSP.setBounds(0,0,703,200);
	panelcenter.add(JSP);
	
	
	JLabel jLViewID=new JLabel("ID");
	jLViewID.setBounds(20,300,40,20);
	jLViewID.setBackground(Color.BLACK);
	jLViewID.setFont(new Font("Tahoma",Font.BOLD,15));
	panelcenter.add(jLViewID);
	
	
	 jTJooViewID=new JTextField();
	jTJooViewID.setBounds(180,300,150,35);
	panelcenter.add(jTJooViewID);
	
	
	JLabel jLtitle=new JLabel("Title");
	jLtitle.setBounds(20,345,40,20);
	jLtitle.setBackground(Color.BLACK);
	jLtitle.setFont(new Font("Tahoma",Font.BOLD,15));
	panelcenter.add(jLtitle);
	
	
	 jTJooViewTitle=new JTextField();
	jTJooViewTitle.setBounds(180,345,150,35);
	panelcenter.add(jTJooViewTitle);
	
	
	JLabel jLautho=new JLabel("Author");
	jLautho.setBounds(20,390,90,20);
	jLautho.setBackground(Color.BLACK);
	jLautho.setFont(new Font("Tahoma",Font.BOLD,15));
	panelcenter.add(jLautho);
	
	 jTJooViewAutho=new JTextField();
	jTJooViewAutho.setBounds(180,390,150,35);
	panelcenter.add(jTJooViewAutho);
	
	
	JLabel year=new JLabel("Publication Year");
	year.setBounds(20,435,140,20);
	year.setBackground(Color.BLACK);
	year.setFont(new Font("Tahoma",Font.BOLD,15));
	panelcenter.add(year);
	
	
	 jTJooViewPubli=new JTextField();
	jTJooViewPubli.setBounds(180,435,150,35);
	panelcenter.add(jTJooViewPubli);
	
	
	JLabel volume=new JLabel("Volume Number");
	volume.setBounds(20,480,130,20);
	volume.setBackground(Color.BLACK);
	volume.setFont(new Font("Tahoma",Font.BOLD,15));
	panelcenter.add(volume);
	
	
	 jTJooViewVolu=new JTextField();
	 jTJooViewVolu.setBounds(180,480,150,35);
	panelcenter.add(jTJooViewVolu);
	
	
	JLabel page=new JLabel("Page Number");
	page.setBounds(20,525,130,20);
	page.setBackground(Color.BLACK);
	page.setFont(new Font("Tahoma",Font.BOLD,15));
	panelcenter.add(page);
	
	
	 jTJooViewPage=new JTextField();
	 jTJooViewPage.setBounds(180,525,150,35);
	panelcenter.add(jTJooViewPage);
	
	
	
	
	 jVieJournButtonEdit=new JButton("EDIT");
	jVieJournButtonEdit.setBounds(220,590,100,35);
	panelcenter.add(jVieJournButtonEdit);
	
	jVieJournButtonDelete=new JButton("Delete");
	jVieJournButtonDelete.setBounds(340,595,90,30);
	panelcenter.add(jVieJournButtonDelete);
	
	JLabel  topicEdit=new JLabel("Edit Here");
	topicEdit.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 20));
	topicEdit.setBounds(110,250,100,20);
	panelcenter.add(topicEdit);
	
	JLabel middleTopJoo=new JLabel("JOURNAL");
	middleTopJoo.setBounds(240,200,90,20);
	middleTopJoo.setFont(new Font("ITALIAN",Font.BOLD,17));
	panelcenter.add(middleTopJoo);
	
	JLabel topicHire=new JLabel("Hire Articles Here:");
	topicHire.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 20));
	topicHire.setBounds(370,250,190,20);
	panelcenter.add(topicHire);
	
	
	JLabel hirelabel=new JLabel("Enter Researcher's ID");
	hirelabel.setBounds(380,300,170,30);
	panelcenter.add(hirelabel);
	
	
	jTJooReHire=new JTextField();
	jTJooReHire.setBounds(550,300,80,30);
	panelcenter.add(jTJooReHire);
	
	
	jVieJournButtonHire=new JButton("Hire");
	jVieJournButtonHire.setBounds(550,348,80,35);
	panelcenter.add(jVieJournButtonHire);
	
	jVieJournButtonReturn=new JButton("Return");
	jVieJournButtonReturn.setBounds(550,400,80,35);
	panelcenter.add(jVieJournButtonReturn);
	
	
	

	
	revalidate();
	repaint();	
	
	filling();
	butListen(this);
	
}


public JTextField getjTJooReHire() {
	return jTJooReHire;
}

public JButton getjVieJournButtonEdit() {
	return jVieJournButtonEdit;
}


public String getjTJooViewID() {
	return jTJooViewID.getText();
}

public String getjTJooViewTitle() {
	return jTJooViewTitle.getText();
}

public String getjTJooViewAutho() {
	return jTJooViewAutho.getText();
}


public String getjTJooViewPubli() {
	return jTJooViewPubli.getText();
}

public String getjTJooViewVolu() {
	return jTJooViewVolu.getText();
}


public String getjTJooViewPage() {
	return jTJooViewPage.getText();
}

public   int getallIDD() { return getJooII;}


//setters for the edit form of Journal
public void settee(String jTJooViewID,String jTJooViewTitle, 
		String jTJooViewAutho, String jTJooViewPubli,
		String jTJooViewVolu,String jTJooViewPage, String jTJooReHire)
{
	this.jTJooViewID.setText(jTJooViewID);this.jTJooViewTitle.setText(jTJooViewTitle);
	this.jTJooViewAutho.setText(jTJooViewAutho);this.jTJooViewPubli.setText(jTJooViewPubli);
	this.jTJooViewVolu.setText(jTJooViewVolu);this.jTJooViewPage.setText(jTJooViewPage);this.jTJooReHire.setText(jTJooReHire);
	
}

//method to arrange and fill the edit form when clicked on respective row of the table
public void filling()
{
	 
	tabe.addMouseListener(new java.awt.event.MouseAdapter() {
public void mouseClicked(java.awt.event.MouseEvent e)
		{
	int fillAt;
			
	String jTJooViewID ,jTJooViewTitle,jTJooViewAutho,jTJooViewPubli,jTJooViewVolu,jTJooViewPage, jTJooReHire;
	DefaultTableModel intoTable = (DefaultTableModel)tabe.getModel();
	fillAt=tabe.getSelectedRow();
	jTJooViewID= intoTable.getValueAt(fillAt,0).toString();
	jTJooViewTitle= intoTable.getValueAt(fillAt,1).toString();
	jTJooViewAutho= intoTable.getValueAt(fillAt,2).toString();
	jTJooViewPubli= intoTable.getValueAt(fillAt,3).toString();
	jTJooViewVolu= intoTable.getValueAt(fillAt,4).toString();
	jTJooViewPage= intoTable.getValueAt(fillAt,5).toString();
	jTJooReHire = intoTable.getValueAt(fillAt, 6).toString();
	settee(jTJooViewID,jTJooViewTitle, jTJooViewAutho, jTJooViewPubli, jTJooViewVolu, jTJooViewPage, jTJooReHire);
	setIndex(tabe.getSelectedRow());
	jVieJournButtonDelete.setBackground(Color.RED);
	jVieJournButtonEdit.setBackground(Color.CYAN);
		}
	});
}

//method for the working of the respective buttons
public void butListen(ArticlesManage rMann)
{
	jVieJournButtonEdit.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
     try {
		WRjournal.editRelatedToJournal(rMann, getallIDD());
		JOptionPane.showMessageDialog(null, "Journal Edited!");
	   } 
	catch (FileNotFoundException e1) {
	e1.printStackTrace();
	} catch (IOException e1) {
	e1.printStackTrace();
	}
			
		}
	});
	
	
// for delete button
	jVieJournButtonDelete.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		WRjournal.deleteMethodJournal(rMann, getallIDD());
		JOptionPane.showMessageDialog(null, "Delete this journal?");
		}
			});

	// for the hire button
	jVieJournButtonHire.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			try {
				WRjournal.loanjournMethod(rMann,getallIDD());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	});
	
	// for the return button
	jVieJournButtonReturn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.out.println("a");
		}
		
	});
	
	
	
}
// method to view the details of the conference articles
public void viewConferenceA() {

	panelcenter.removeAll();
	panelcenter.setLayout(null);
	ArticlesManageController reCc=new ArticlesManageController(this);
	reCc.viewTabbConf();
	
	JSP=new JScrollPane(tabe);
	JSP.setBounds(0,0,703,200);
	panelcenter.add(JSP);
	
	JLabel jLViewConfID=new JLabel("ID");
	jLViewConfID.setBounds(20,300,40,20);
	jLViewConfID.setBackground(Color.BLACK);
	jLViewConfID.setFont(new Font("Tahoma",Font.BOLD,15));
	panelcenter.add(jLViewConfID);
	
	
	jTConfViewID=new JTextField();
	jTConfViewID.setBounds(180,300,150,35);
	panelcenter.add(jTConfViewID);
	
	
	JLabel jLVConTitle=new JLabel("Title");
	jLVConTitle.setBounds(20,345,40,20);
	jLVConTitle.setBackground(Color.BLACK);
	jLVConTitle.setFont(new Font("Tahoma",Font.BOLD,15));
	panelcenter.add(jLVConTitle);
	
	
	 jTConfViewTitle=new JTextField();
	jTConfViewTitle.setBounds(180,345,150,35);
	panelcenter.add(jTConfViewTitle);
	
	
	JLabel jLVConAutho=new JLabel("Author");
	jLVConAutho.setBounds(20,390,90,20);
	jLVConAutho.setBackground(Color.BLACK);
	jLVConAutho.setFont(new Font("Tahoma",Font.BOLD,15));
	panelcenter.add(jLVConAutho);
	
	 jTConfViewAutho=new JTextField();
	 jTConfViewAutho.setBounds(180,390,150,35);
	panelcenter.add(jTConfViewAutho);
	
	
	JLabel jLVConYear=new JLabel("Publication Year");
	jLVConYear.setBounds(20,435,140,20);
	jLVConYear.setBackground(Color.BLACK);
	jLVConYear.setFont(new Font("Tahoma",Font.BOLD,15));
	panelcenter.add(jLVConYear);
	
	
	 jTConfViewYear=new JTextField();
	jTConfViewYear.setBounds(180,435,150,35);
	panelcenter.add(jTConfViewYear);
	
	
	JLabel jLVConEdit=new JLabel("Editors");
	jLVConEdit.setBounds(20,480,130,20);
	jLVConEdit.setBackground(Color.BLACK);
	jLVConEdit.setFont(new Font("Tahoma",Font.BOLD,15));
	panelcenter.add(jLVConEdit);
	
	
	 jTConfViewEdit=new JTextField();
	 jTConfViewEdit.setBounds(180,480,150,35);
	panelcenter.add(jTConfViewEdit);
	
	
	JLabel jLVConPage=new JLabel("Page.No");
	jLVConPage.setBounds(20,525,130,20);
	jLVConPage.setBackground(Color.BLACK);
	jLVConPage.setFont(new Font("Tahoma",Font.BOLD,15));
	panelcenter.add(jLVConPage);                   
	                                                 
	
	 jTConfViewPage=new JTextField();
	 jTConfViewPage.setBounds(180,525,150,35);
	panelcenter.add(jTConfViewPage);
	
	
	
	JLabel jLVConLocat=new JLabel("Location");
	jLVConLocat.setBounds(20,570,130,20);
	jLVConLocat.setBackground(Color.BLACK);
	jLVConLocat.setFont(new Font("Tahoma",Font.BOLD,15));
	panelcenter.add(jLVConLocat);
	
	
	 jTConfViewLocat=new JTextField();
	 jTConfViewLocat.setBounds(180,570,150,35);
	panelcenter.add(jTConfViewLocat);
	
	
	 jVieConfButtonEdit=new JButton("EDIT");
	jVieConfButtonEdit.setBounds(220,620,100,35);
	panelcenter.add(jVieConfButtonEdit);
	
	
	jVieConfButtonDelete=new JButton("Delete");
	jVieConfButtonDelete.setBounds(340,624,90,30);
	panelcenter.add(jVieConfButtonDelete);
	
	
	JLabel  topicConfEdit=new JLabel("Edit Here");
	topicConfEdit.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 20));
	topicConfEdit.setBounds(110,250,100,20);
	panelcenter.add(topicConfEdit);
	
	
	JLabel middleTopConf=new JLabel("CONFERENCE");
	middleTopConf.setBounds(240,200,130,20);
	middleTopConf.setFont(new Font("ITALIAN",Font.BOLD,17));
	panelcenter.add(middleTopConf);
	
	
	JLabel topicConHire=new JLabel("Hire Articles Here:");
	topicConHire.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 20));
	topicConHire.setBounds(370,250,190,20);
	panelcenter.add(topicConHire);
	
	
	JLabel hireConlabel=new JLabel("Enter Researcher's ID");
	hireConlabel.setBounds(380,300,170,30);
	panelcenter.add(hireConlabel);
	
	
	jTConfReHire=new JTextField();
	jTConfReHire.setBounds(550,300,80,30);
	panelcenter.add(jTConfReHire);
	
	
	jVieConfButtonHire=new JButton("Hire");
	jVieConfButtonHire.setBounds(550,348,80,35);
	panelcenter.add(jVieConfButtonHire);
	
	
	jVieConfButtonReturn=new JButton("Return");
	jVieConfButtonReturn.setBounds(550,400,80,35);
	panelcenter.add(jVieConfButtonReturn);
	
	
	
	
	
	revalidate();
	repaint();	
	
	
	editOnMouse();
	editListenerConf(this);
	
}


public JTextField getjTConfReHire() {
	return jTConfReHire;
}
public void setjTConfReHire(JTextField jTConfReHire) {
	this.jTConfReHire = jTConfReHire;
}
//respective getters
public String getjTConfViewID() {
	return jTConfViewID.getText();
}


public String getjTConfViewTitle() {
	return jTConfViewTitle.getText();
}


public String getjTConfViewAutho() {
	return jTConfViewAutho.getText();
}


public String getjTConfViewYear() {
	return jTConfViewYear.getText();
}


public String getjTConfViewEdit() {
	return jTConfViewEdit.getText();
}


public String getjTConfViewPage() {
	return jTConfViewPage.getText();
}


public String getjTConfViewLocat() {
	return jTConfViewLocat.getText();
}

//method to set data to the edit form
public void editSetters(String jTConfViewID,String jTConfViewTitle, String jTConfViewAutho, String jTConfViewYear,String jTConfViewEdit,String jTConfViewPage,String jTConfViewLocat,String jTConfReHire)
{
	this.jTConfViewID.setText(jTConfViewID);
	this.jTConfViewTitle.setText(jTConfViewTitle);
	this.jTConfViewAutho.setText(jTConfViewAutho);
	this.jTConfViewYear.setText(jTConfViewYear);
	this.jTConfViewEdit.setText(jTConfViewEdit);
	this.jTConfViewPage.setText(jTConfViewPage);
	this.jTConfViewLocat.setText(jTConfViewLocat);
	this.jTConfReHire.setText(jTConfReHire);
	
	
}

// working of the edit form on the click of the row
public void editOnMouse()
{
	 
     tabe.addMouseListener(new java.awt.event.MouseAdapter() {
public void mouseClicked(java.awt.event.MouseEvent e)
{
	 int fillAt;
			
	String jTConfViewID ,jTConfViewTitle,jTConfViewAutho,jTConfViewYear,jTConfViewEdit,jTConfViewPage,
	 jTConfViewLocat,jTConfReHire;
	DefaultTableModel tableConf = (DefaultTableModel)tabe.getModel();
	fillAt=tabe.getSelectedRow();
	jTConfViewID= tableConf.getValueAt(fillAt,0).toString();
	jTConfViewTitle= tableConf.getValueAt(fillAt,1).toString();
	jTConfViewAutho= tableConf.getValueAt(fillAt,2).toString();
	jTConfViewYear= tableConf.getValueAt(fillAt,3).toString();
	jTConfViewEdit= tableConf.getValueAt(fillAt,4).toString();
	jTConfViewPage= tableConf.getValueAt(fillAt,5).toString();
	jTConfViewLocat= tableConf.getValueAt(fillAt,6).toString();
	jTConfReHire= tableConf.getValueAt(fillAt,7).toString();
	editSetters(jTConfViewID,jTConfViewTitle, jTConfViewAutho, jTConfViewYear, jTConfViewEdit, jTConfViewPage,jTConfViewLocat,jTConfReHire);
	setIndex(tabe.getSelectedRow());
	jVieConfButtonDelete.setBackground(Color.RED);
	jVieConfButtonEdit.setBackground(Color.CYAN);
}
	});
}


//for the edit of the conference
public void editListenerConf(ArticlesManage rMann)
{
	jVieConfButtonEdit.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
	WriteReadConference confF = new WriteReadConference();
try 
{
	confF.editrelatedToConf(rMann, getallIDD());
	JOptionPane.showMessageDialog(null, "Conference Edited!");
} 
catch (FileNotFoundException e1) {
	e1.printStackTrace();
} catch (IOException e1) {
	e1.printStackTrace();
}
			
}	
});
	
	jVieConfButtonDelete.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
			WRConf.deleteMethodConference(rMann, getallIDD());
			}
				});

	jVieConfButtonHire.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
			try {
				WRConf.loanconfMethod(rMann, getallIDD());
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
	});
	
	jVieConfButtonReturn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			WRConf.deleteMethodConference(rMann, getallIDD());
		}
		
	});
	
	
	
	
	
}



//for the details view of the books articles
public void viewBooksA() {

	panelcenter.removeAll();
	panelcenter.setLayout(null);
	
	
	ArticlesManageController reCc=new ArticlesManageController(this);
	reCc.viewTabbBook();
 
	//THe code below is for the table
	JSP=new JScrollPane(tabe);
	JSP.setBounds(0,0,703,200);
	panelcenter.add(JSP);
	
	JLabel jLViewBooksID=new JLabel("ID");
	jLViewBooksID.setBounds(20,300,40,20);
	jLViewBooksID.setBackground(Color.BLACK);
	jLViewBooksID.setFont(new Font("Tahoma",Font.BOLD,15));
	panelcenter.add(jLViewBooksID);
	
	
	 jTBookViewID=new JTextField();
	jTBookViewID.setBounds(180,300,150,35);
	panelcenter.add(jTBookViewID);
	
	
	JLabel jLVBooksTitle=new JLabel("Title");
	jLVBooksTitle.setBounds(20,345,40,20);
	jLVBooksTitle.setBackground(Color.BLACK);
	jLVBooksTitle.setFont(new Font("Tahoma",Font.BOLD,15));
	panelcenter.add(jLVBooksTitle);
	
	
	jTBookViewTitle=new JTextField();
	jTBookViewTitle.setBounds(180,345,150,35);
	panelcenter.add(jTBookViewTitle);
	
	
	JLabel jLVBooksAutho=new JLabel("Author");
	jLVBooksAutho.setBounds(20,390,90,20);
	jLVBooksAutho.setBackground(Color.BLACK);
	jLVBooksAutho.setFont(new Font("Tahoma",Font.BOLD,15));
	panelcenter.add(jLVBooksAutho);
	
	 jTBookViewAutho=new JTextField();
	jTBookViewAutho.setBounds(180,390,150,35);
	panelcenter.add(jTBookViewAutho);
	
	
	JLabel jLVBooksYear=new JLabel("Publication Year");
	jLVBooksYear.setBounds(20,435,140,20);
	jLVBooksYear.setBackground(Color.BLACK);
	jLVBooksYear.setFont(new Font("Tahoma",Font.BOLD,15));
	panelcenter.add(jLVBooksYear);
	
	
	 jTBookViewYear=new JTextField();
	jTBookViewYear.setBounds(180,435,150,35);
	panelcenter.add(jTBookViewYear);
	
	
	JLabel jLVBooksEdit=new JLabel("Editors");
	jLVBooksEdit.setBounds(20,480,130,20);
	jLVBooksEdit.setBackground(Color.BLACK);
	jLVBooksEdit.setFont(new Font("Tahoma",Font.BOLD,15));
	panelcenter.add(jLVBooksEdit);
	
	
	 jTBookViewEdit=new JTextField();
	jTBookViewEdit.setBounds(180,480,150,35);
	panelcenter.add(jTBookViewEdit);
	
	
	JLabel jLVConPage=new JLabel("Page No");
	jLVConPage.setBounds(20,525,130,20);
	jLVConPage.setBackground(Color.BLACK);
	jLVConPage.setFont(new Font("Tahoma",Font.BOLD,15));
	panelcenter.add(jLVConPage);
	
	
	 jTBookViewPage=new JTextField();
	jTBookViewPage.setBounds(180,525,150,35);        //jLVBooksLocat
	panelcenter.add(jTBookViewPage);                 //jTVBooksLocat
	
	
	
	JLabel jLVBooksLocat=new JLabel("Place of Publication");
	jLVBooksLocat.setBounds(20,570,150,20);
	jLVBooksLocat.setBackground(Color.BLACK);
	jLVBooksLocat.setFont(new Font("Tahoma",Font.BOLD,15));
	panelcenter.add(jLVBooksLocat);
	
	
	 jTBookViewLocat=new JTextField();
	jTBookViewLocat.setBounds(180,570,150,35);
	panelcenter.add(jTBookViewLocat);
	
	
	JLabel jLVBooksPublisher=new JLabel("Publisher");
	jLVBooksPublisher.setBounds(20,615,130,20);
	jLVBooksPublisher.setBackground(Color.BLACK);
	jLVBooksPublisher.setFont(new Font("Tahoma",Font.BOLD,15));
	panelcenter.add(jLVBooksPublisher);
	
	
	 jTBookViewPublisher=new JTextField();
	jTBookViewPublisher.setBounds(180,615,150,35);
	panelcenter.add(jTBookViewPublisher);
	
	
	
	 jVieBookButtonEdit=new JButton("EDIT");
	 jVieBookButtonEdit.setBounds(350,620,100,35);
	panelcenter.add(jVieBookButtonEdit);
	
	
	jVieBookButtonDelete=new JButton("Delete");
	jVieBookButtonDelete.setBounds(460,625,90,30);
	panelcenter.add(jVieBookButtonDelete);

	JLabel  topicBookEdit=new JLabel("Edit Here");
	topicBookEdit.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 20));
	topicBookEdit.setBounds(110,250,100,20);
	panelcenter.add(topicBookEdit);
	
	
	
	JLabel middleTopBook=new JLabel("BOOK CHAPTER");
	middleTopBook.setBounds(240,200,150,20);
	middleTopBook.setFont(new Font("ITALIAN",Font.BOLD,17));
	panelcenter.add(middleTopBook);
	
	
	
	JLabel topicBookHire=new JLabel("Hire Articles Here:");
	topicBookHire.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 20));
	topicBookHire.setBounds(370,250,190,20);
	panelcenter.add(topicBookHire);
	
	
	JLabel hireBooklabel=new JLabel("Enter Researcher's ID");
	hireBooklabel.setBounds(380,300,170,30);
	panelcenter.add(hireBooklabel);
	
	
	jTBookReHire=new JTextField();
	jTBookReHire.setBounds(550,300,80,30);
	panelcenter.add(jTBookReHire);
	
	jVieBookButtonHire=new JButton("Hire");
	jVieBookButtonHire.setBounds(550,348,80,35);
	panelcenter.add(jVieBookButtonHire);
	
	jVieBookButtonReturn=new JButton("Return");
	jVieBookButtonReturn.setBounds(550,400,80,35);
	panelcenter.add(jVieBookButtonReturn);
	
	

	
	revalidate();
	repaint();	
	
	
	editClickBookTab();
	editListenerBook(this);
	
	
}

public JTextField getjTBookReHire() {
	return jTBookReHire;
}
public void setjTBookReHire(JTextField jTBookReHire) {
	this.jTBookReHire = jTBookReHire;
}
//for the book chapter view
public String getjTBookViewTitle() {
	return jTBookViewTitle.getText();
}


public String getjTBookViewID() {
	return jTBookViewID.getText();
}


public String getjTBookViewAutho() {
	return jTBookViewAutho.getText();
}


public String getjTBookViewYear() {
	return jTBookViewYear.getText();
}


public String getjTBookViewEdit() {
	return jTBookViewEdit.getText();
}


public String getjTBookViewPage() {
	return jTBookViewPage.getText();
}


public String getjTBookViewLocat() {
	return jTBookViewLocat.getText();
}


public String getjTBookViewPublisher() {
	return jTBookViewPublisher.getText();
}


//method to set the respective data to the edit form for the book chapters.
public void editBookSetters(String jTBookViewID,String jTBookViewTitle, String jTBookViewAutho, 
String jTBookViewYear,String jTBookViewEdit,String jTBookViewPage,String jTBookViewLocat,
String jTBookViewPublisher,String jTBookReHire)
{
this.jTBookViewID.setText(jTBookViewID);this.jTBookViewTitle.setText(jTBookViewTitle);
this.jTBookViewAutho.setText(jTBookViewAutho);this.jTBookViewYear.setText(jTBookViewYear);
this.jTBookViewEdit.setText(jTBookViewEdit);this.jTBookViewPage.setText(jTBookViewPage);
this.jTBookViewLocat.setText(jTBookViewLocat);this.jTBookViewPublisher.setText(jTBookViewPublisher);
this.jTBookReHire.setText(jTBookReHire);
}

// method to work on mouse click for the book chapters
public void editClickBookTab()
{
	 
	tabe.addMouseListener(new java.awt.event.MouseAdapter() {
public void mouseClicked(java.awt.event.MouseEvent e)
{
	int fillAt;
    String jTBookViewID ,jTBookViewTitle,jTBookViewAutho,jTBookViewYear,jTBookViewEdit,
	jTBookViewPage,jTBookViewLocat,jTBookViewPublisher,jTBookReHire;
	DefaultTableModel tableBookCh = (DefaultTableModel)tabe.getModel();
	fillAt=tabe.getSelectedRow();
	jTBookViewID= tableBookCh.getValueAt(fillAt,0).toString();
	jTBookViewTitle= tableBookCh.getValueAt(fillAt,1).toString();
	jTBookViewAutho= tableBookCh.getValueAt(fillAt,2).toString();
	jTBookViewYear= tableBookCh.getValueAt(fillAt,3).toString();
	jTBookViewEdit= tableBookCh.getValueAt(fillAt,4).toString();
	jTBookViewPage= tableBookCh.getValueAt(fillAt,5).toString();
	jTBookViewLocat= tableBookCh.getValueAt(fillAt,6).toString();
	jTBookViewPublisher= tableBookCh.getValueAt(fillAt,7).toString();
	jTBookReHire= tableBookCh.getValueAt(fillAt,8).toString();
	editBookSetters(jTBookViewID,jTBookViewTitle, jTBookViewAutho, jTBookViewYear,
	jTBookViewEdit, jTBookViewPage,jTBookViewLocat,jTBookViewPublisher,jTBookReHire);
	setIndex(tabe.getSelectedRow());
	jVieBookButtonDelete.setBackground(Color.RED);
	jVieBookButtonEdit.setBackground(Color.CYAN);
}
	});
}
//method for buttons listener
public void editListenerBook(ArticlesManage rMann)
{
	jVieBookButtonEdit.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
	WriteReadBook bookto = new WriteReadBook();
try {
	bookto.bookRelatedEdit(rMann, getallIDD());
	JOptionPane.showMessageDialog(null, "Book Edited!");
}   catch (FileNotFoundException e1) {
	e1.printStackTrace();
}   catch (IOException e1) {
	e1.printStackTrace();
}
			
}
});
	
	jVieBookButtonDelete.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
			WRBook.deleteMethodBook(rMann, getallIDD());
			}
});
	
	jVieBookButtonHire.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
			try {
				WRBook.loanbookMethod(rMann, getallIDD());
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
	});
	
	jVieBookButtonReturn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			WRBook.deleteMethodBook(rMann, getallIDD());
		}
		
	});
	

	
}
//getters and setters for the scrollbar and table 
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
