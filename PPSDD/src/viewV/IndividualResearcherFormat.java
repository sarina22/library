package viewV;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controllerC.ArticlesManageController;
import controllerC.IndividualResearcherFormatController;
import controllerC.ResearcherManageController;
import modelM.WriteReadJournal;
import modelM.WriteReadBook;
import modelM.WriteReadConference;
//import modelM.WriteReadJooLoan;

public class IndividualResearcherFormat extends JFrame {
	//attributes for the respective data
        private JButton jBLoanJournal,jBNotLoanJournal,logOUT;
        private JPanel panelToSide,panelTocenter;
        private JLabel label1,label2;
        
        WriteReadJournal readJournal=new WriteReadJournal();
        WriteReadConference readConference=new WriteReadConference();
        WriteReadBook readBook=new WriteReadBook();
        //WriteReadJooLoan loan=new WriteReadJooLoan();
        
         private JTable tabe=new JTable();
    	 private JScrollPane JSP ; 
    	 private int data;
    	public void setIndex(int i) {data= i;}

    	
    	//getters and setter for the respective attributes
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
	
//constructor of the class
public IndividualResearcherFormat() {
	setSize(900,680);
	setBounds(0,0,900,680);
	setTitle("NORTHAMPTON RESEARCH CENTER");
	setDefaultCloseOperation(EXIT_ON_CLOSE); 
	setResizable(false);
	setLocationRelativeTo(null);
	setLayout(null);
	Container contain= getContentPane();
	setVisible(true);
	contain.setLayout(null);


	panelToSide=new JPanel();
	panelToSide.setBounds(0,0,180,680);
	panelToSide.setBackground(new Color(109, 146, 153));
	panelToSide.setLayout(null);
	contain.add(panelToSide);
	
	
	jBLoanJournal=new JButton("Borrowed");
	jBLoanJournal.setFont(new Font("ITALIAN",Font.BOLD,20));
	jBLoanJournal.setBounds(30,350,130,70);
	panelToSide.add(jBLoanJournal);
	
	
	jBNotLoanJournal=new JButton("Articles");
	jBNotLoanJournal.setFont(new Font("ITALIAN",Font.BOLD,20));
	jBNotLoanJournal.setBounds(30,90,140,70);
	panelToSide.add(jBNotLoanJournal);
	
	logOUT=new JButton("LOGOUT");
	logOUT.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,20));
	logOUT.setBounds(0,560,150,80);
	panelToSide.add(logOUT);

	
	panelTocenter=new JPanel();
	panelTocenter.setBounds(180,0,680,680);
	contain.add(panelTocenter);
	
	
	IndividualResearcherFormatController incc=new IndividualResearcherFormatController(this);
	incc.methodFLoanJourn();
	incc.methodFNotLoanJourn();
	incc.methodlogOUT();
	
	}
	
	//methods for the button listener
public void listenTonotLoan(ActionListener a)
	{ jBNotLoanJournal.addActionListener(a);}
	
public void listenToLoan(ActionListener a)
	{ jBLoanJournal.addActionListener(a);}
	
public void logout(ActionListener a)
{ logOUT.addActionListener(a);}

	//method for books not on loan
public void notloanJournTab() {
		
		panelTocenter.removeAll();
		panelTocenter.setLayout(null);


		
		JScrollPane js = readJournal.getJSP();
		setTabe(readJournal.getTabe());
		setJSP(js);
    	JLabel journal=new JLabel("Journal");
		journal.setBounds(300,0,60,20);
		journal.setBackground(Color.BLACK);
		panelTocenter.add(journal);
		
		JSP=new JScrollPane(tabe);
		JSP.setBounds(0,20,680,130);
		panelTocenter.add(JSP);
		
		JLabel conference=new JLabel("Conference");
		conference.setBackground(Color.BLACK);
		conference.setBounds(300,160,90,20);
		panelTocenter.add(conference);
		
		JScrollPane confSc = readConference.getscrollConfu();
		setTabe(readConference.gettabeConfu());
		setJSP(confSc);

		JSP=new JScrollPane(tabe);
		JSP.setBounds(0,200,680,130);
		panelTocenter.add(JSP);
		
		
		JLabel book=new JLabel("Book Chapters");
		book.setBackground(Color.BLACK);
		book.setBounds(300,350,150,20);
		panelTocenter.add(book);
		
		
		JScrollPane scBook = readBook.getscrollBook();
		setTabe(readBook.gettabeBook());
		setJSP(scBook);

		JSP=new JScrollPane(tabe);
		JSP.setBounds(0,400,680,130);
		panelTocenter.add(JSP);
		
		
		
		revalidate();
		repaint();	
	
	}
	
//method for the articles/book chapters not on loan	
   public void loanJournTab() {
	
		
		panelTocenter.removeAll();
		panelTocenter.setLayout(null);
		
		
		JLabel journal2=new JLabel("Hired ");
		journal2.setBounds(300,0,130,20);
		journal2.setBackground(Color.BLACK);
		panelTocenter.add(journal2);
		
		JSP=new JScrollPane(tabe);
		JSP.setBounds(0,20,680,130);
        panelTocenter.add(JSP);
        
   

		revalidate();
		repaint();
	}
	
	
	
}
