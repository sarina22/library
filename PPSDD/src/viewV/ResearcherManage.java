package viewV;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


import controllerC.ResearcherManageController;
import modelM.WriteReadResearcInfoData;

public class ResearcherManage extends JFrame{
	WriteReadResearcInfoData addRData=new WriteReadResearcInfoData();
	ResearcherManage resear;
	private static final long serialVersionUID = 1L;
	private JPanel jPSideRes,JPCenterRes;
	private JButton jBResearchForm,jBResearchForm2,jBack;
	//The below mentioned are for FORM DATA
	private JLabel mainRTitle,jLRID,jLRName,jLRAddress,jLRPhone,jLREmail,jLRUsername,jLRPassword;
	private JTextField jTRID,jTRName,jTRAddress,jTRPhone,jTREmail,jTRUsername,jTRPassword;
	private JButton jBRAdd,jBReset;
	private JTable tabe=new JTable();
	private JScrollPane JSP ;              
	private int getIRow;
	public void setIndex(int i) {getIRow= i;}
	//Data for the edit part of the form
	private JLabel jLEDID,jLEDName,jLEDAddress,jLEDPhone,jLEDEmail,jLEDUsername,jLEDPassword;
	private JTextField jTEDID,jTEDName,jTEDAddress,jTEDPhone,jTEDEmail,jTEDUsername,jTEDPassword;
	private JButton jEDEdit,jEDDelete;


//constructor for the class
public ResearcherManage() {
		setSize(900,720);
		setBounds(0,0,900,720);
		setTitle("NORTHAMPTON RESEARCH CENTER");
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		Container contain= getContentPane();
		setVisible(true);
		contain.setLayout(null);


		jPSideRes=new JPanel();
		jPSideRes.setBounds(0,0,180,720);
		jPSideRes.setBackground(new Color(109, 146, 153));
		jPSideRes.setLayout(null);
		contain.add(jPSideRes);

		JLabel jLAddTopic=new JLabel("ADD");
		jLAddTopic.setBounds(59,30,70,30);
		jLAddTopic.setBackground(Color.WHITE);
		jLAddTopic.setFont(new Font("Tahoma", Font.BOLD, 20));
		jPSideRes.add(jLAddTopic);

		JPanel jLinePanel=new JPanel();
		jLinePanel.setBounds(4,60,180,6);
		jLinePanel.setBackground(Color.CYAN);
		jPSideRes.add(jLinePanel);

		jBResearchForm=new JButton("Researcher");
		//jBResearchForm.setBackground(Color.BLACK);
		//jBResearchForm.setForeground(Color.WHITE);
		jBResearchForm.setBounds(30,90,130,70);
		jPSideRes.add(jBResearchForm);

		JLabel jLViewRTopic=new JLabel("VIEW");
		jLViewRTopic.setBounds(59,350,70,30);
		jLViewRTopic.setBackground(Color.WHITE);
		jLViewRTopic.setFont(new Font("Tahoma", Font.BOLD, 20));
		jPSideRes.add(jLViewRTopic);

		JPanel jLinePanel2=new JPanel();
		jLinePanel2.setBounds(4,380,180,6);
		jLinePanel2.setBackground(Color.CYAN);
		jPSideRes.add(jLinePanel2);

		jBResearchForm2=new JButton("Researcher");
		jBResearchForm2.setBounds(30,460,130,70);
		jPSideRes.add(jBResearchForm2);

		jBack=new JButton("BACK");
		jBack.setBounds(0,640,90,40);
		jBack.setBackground(Color.BLACK);
		jBack.setForeground(Color.WHITE);
		jPSideRes.add(jBack);



		JPCenterRes=new JPanel();
		JPCenterRes.setBounds(180,0,720,720);
        contain.add(JPCenterRes);
     
        JLabel contaiNrES=new JLabel("Manage Researchers");
        contaiNrES.setFont(new Font("Sitka Text", Font.BOLD, 36));
        JPCenterRes.add(contaiNrES);
        
       //controller call
		ResearcherManageController reCc=new ResearcherManageController(this);
		reCc.methodFFormResearch();
		reCc.methodFViewResearch();
		reCc.methodFMainBack();

	}
//action listener for the related buttons
public void buttonFFormResearch(ActionListener a)
{ jBResearchForm.addActionListener(a);}


public void buttonFViewResearch(ActionListener a)
{ jBResearchForm2.addActionListener(a);}


public void buttonFBack(ActionListener a)
{ jBack.addActionListener(a);}

// method for the add form for the researchers
public void addFormResearch() {

		JPCenterRes.removeAll();
		JPCenterRes.setLayout(null);


		mainRTitle=new JLabel("Add Researcher");
		mainRTitle.setFont(new Font("Italic",Font.BOLD,25));
		mainRTitle.setBounds(290,20,210,30);
		JPCenterRes.add(mainRTitle);


		jLRID=new JLabel("ID");
		jLRID.setBounds(150,70,40,20);
		jLRID.setBackground(Color.BLACK);
		jLRID.setFont(new Font("Tahoma",Font.BOLD,17));
		JPCenterRes.add(jLRID);


		jTRID=new JTextField();
		jTRID.setBounds(330,70,150,35);
		JPCenterRes.add(jTRID);


		jLRName=new JLabel("Name");
		jLRName.setBounds(150,150,70,20);
		jLRName.setBackground(Color.BLACK);
		jLRName.setFont(new Font("Tahoma",Font.BOLD,17));
		JPCenterRes.add(jLRName);

		jTRName=new JTextField();
		jTRName.setBounds(330,150,150,35);
		JPCenterRes.add(jTRName);


		jLRAddress=new JLabel("Address");
		jLRAddress.setBounds(150,230,150,20);
		jLRAddress.setBackground(Color.BLACK);
		jLRAddress.setFont(new Font("Tahoma",Font.BOLD,17));
		JPCenterRes.add(jLRAddress);


		jTRAddress=new JTextField();
		jTRAddress.setBounds(330,230,150,35);
		JPCenterRes.add(jTRAddress);


		jLRPhone=new JLabel("Phone Num");
		jLRPhone.setBounds(150,310,150,20);
		jLRPhone.setBackground(Color.BLACK);
		jLRPhone.setFont(new Font("Tahoma",Font.BOLD,17));
		JPCenterRes.add(jLRPhone);


		jTRPhone=new JTextField();
		jTRPhone.setBounds(330,310,150,35);
		JPCenterRes.add(jTRPhone);


		jLREmail=new JLabel("Email Address");
		jLREmail.setBounds(150,390,150,20);
		jLREmail.setBackground(Color.BLACK);
		jLREmail.setFont(new Font("Tahoma",Font.BOLD,17));
		JPCenterRes.add(jLREmail);

		jTREmail=new JTextField();
		jTREmail.setBounds(330,390,150,35);
		JPCenterRes.add(jTREmail);

		jLRUsername=new JLabel("Username");
		jLRUsername.setBounds(150,470,180,20);
		jLRUsername.setBackground(Color.BLACK);
		jLRUsername.setFont(new Font("Tahoma",Font.BOLD,17));
		JPCenterRes.add(jLRUsername);


		jTRUsername=new JTextField();
		jTRUsername.setBounds(330,470,150,35);
		JPCenterRes.add(jTRUsername);

		jLRPassword=new JLabel("Password");
		jLRPassword.setBounds(150,550,150,20);
		jLRPassword.setBackground(Color.BLACK);
		jLRPassword.setFont(new Font("Tahoma",Font.BOLD,17));
		JPCenterRes.add(jLRPassword);


		jTRPassword=new JTextField();
		jTRPassword.setBounds(330,550,150,35);
		JPCenterRes.add(jTRPassword);

		jBRAdd=new JButton("ADD");
		jBRAdd.setBounds(200,610,90,35);
		jBRAdd.setFont(new Font("Tahoma",Font.BOLD,17));
		JPCenterRes.add(jBRAdd);


		jBReset=new JButton("RESET");
		jBReset.setBounds(400,610,90,35);
		jBReset.setFont(new Font("Tahoma",Font.BOLD,17));
		JPCenterRes.add(jBReset);

		JPCenterRes.revalidate();
		JPCenterRes.repaint();	
//method call
		ResearcherManageController reCc=new ResearcherManageController(this);
		reCc.methodFFormAdd();


	}

public void buttonFRAdd(ActionListener a)
{ jBRAdd.addActionListener(a);}

public JTextField getjTRID() {
		return jTRID;
}
public void setjTRID(JTextField jTRID)
{
		this.jTRID = jTRID;
}

public JTextField getjTRName()
{
		return jTRName;
	}

public void setjTRName(JTextField jTRName) 
{
		this.jTRName = jTRName;
	}

public JTextField getjTRAddress()
{
		return jTRAddress;
	}

public void setjTRAddress(JTextField jTRAddress) 
{
		this.jTRAddress = jTRAddress;
	}

public JTextField getjTRPhone()
{
		return jTRPhone;
	}

public void setjTRPhone(JTextField jTRPhone) 
{
		this.jTRPhone = jTRPhone;
	}

public JTextField getjTREmail()
{
		return jTREmail;
	}

public void setjTREmail(JTextField jTREmail) 
{
		this.jTREmail = jTREmail;
	}

public JTextField getjTRUsername()
{
		return jTRUsername;
	}

public void setjTRUsername(JTextField jTRUsername) 
{
		this.jTRUsername = jTRUsername;
	}

public JTextField getjTRPassword()
{
		return jTRPassword;
	}

public void setjTRPassword(JTextField jTRPassword)
{
		this.jTRPassword = jTRPassword;
	}
public JButton getjBReset()
	{
		return jBReset;
	}

public void setjBReset(JButton jBReset) 
	{
		this.jBReset = jBReset;
	}

//setters for the data of researchers

public void settee(String jTEDID,String jTEDName, String jTEDAddress, String jTEDPhone,String jTEDEmail,String jTEDUsername,String jTEDPassword)
{
this.jTEDID.setText(jTEDID);
this.jTEDName.setText(jTEDName);
this.jTEDAddress.setText(jTEDAddress);
this.jTEDPhone.setText(jTEDPhone);
this.jTEDEmail.setText(jTEDEmail);
this.jTEDUsername.setText(jTEDUsername);
this.jTEDPassword.setText(jTEDPassword);

}


public void reMouse()
{
     tabe.addMouseListener(new java.awt.event.MouseAdapter() 
     {
public void mouseClicked(java.awt.event.MouseEvent e)
			{
      int keepAt;

	  String jTEDID ,jTEDName,jTEDAddress,jTEDPhone,jTEDEmail,jTEDUsername,jTEDPassword;
	  DefaultTableModel researchTabs = (DefaultTableModel)tabe.getModel();
	  keepAt=tabe.getSelectedRow();
	  jTEDID= researchTabs.getValueAt(keepAt, 0).toString();
	  jTEDName= researchTabs.getValueAt(keepAt,1).toString();
	  jTEDAddress= researchTabs.getValueAt(keepAt,2).toString();
	  jTEDPhone= researchTabs.getValueAt(keepAt,3).toString();
      jTEDEmail= researchTabs.getValueAt(keepAt,4).toString();
	  jTEDUsername= researchTabs.getValueAt(keepAt,5).toString();
	  jTEDPassword= researchTabs.getValueAt(keepAt,6).toString();
	  settee(jTEDID,jTEDName, jTEDAddress, jTEDPhone, jTEDEmail, jTEDUsername,jTEDPassword);
	  setIndex(tabe.getSelectedRow());
	  jEDDelete.setBackground(Color.RED);
	  jEDEdit.setBackground(Color.CYAN);
	  
			}
	  });
}


	public void viewTableFResearch() {

		JPCenterRes.removeAll();
		JPCenterRes.setLayout(null);

		ResearcherManageController reCc=new ResearcherManageController(this);
		reCc.researchTabletab();

		JSP=new JScrollPane(tabe);
		JSP.setBounds(0,0,703,200);
		JPCenterRes.add(JSP);
		//Attributes for the edit part of the form
		jLEDID=new JLabel("ID");
		jLEDID.setBounds(30,300,40,20);
		jLEDID.setBackground(Color.BLACK);
		jLEDID.setFont(new Font("Tahoma",Font.BOLD,15));
		JPCenterRes.add(jLEDID);


		jTEDID=new JTextField();
		jTEDID.setBounds(135,300,130,30);
		JPCenterRes.add(jTEDID);


		jLEDName=new JLabel("Name");
		jLEDName.setBounds(30,345,50,20);
		jLEDName.setBackground(Color.BLACK);
		jLEDName.setFont(new Font("Tahoma",Font.BOLD,15));
		JPCenterRes.add(jLEDName);

		jTEDName=new JTextField();
		jTEDName.setBounds(135,345,130,30);
		JPCenterRes.add(jTEDName);


		jLEDAddress=new JLabel("Address");
		jLEDAddress.setBounds(30,390,90,20);
		jLEDAddress.setBackground(Color.BLACK);
		jLEDAddress.setFont(new Font("Tahoma",Font.BOLD,15));
		JPCenterRes.add(jLEDAddress);


		jTEDAddress=new JTextField();
		jTEDAddress.setBounds(135,390,130,30);
		JPCenterRes.add(jTEDAddress);


		jLEDPhone=new JLabel("Phone Num");
		jLEDPhone.setBounds(30,435,90,20);
		jLEDPhone.setBackground(Color.BLACK);
		jLEDPhone.setFont(new Font("Tahoma",Font.BOLD,15));
		JPCenterRes.add(jLEDPhone);


		jTEDPhone=new JTextField();
		jTEDPhone.setBounds(135,435,130,30);
		JPCenterRes.add(jTEDPhone);


		jLEDEmail=new JLabel("Email");
		jLEDEmail.setBounds(30,480,90,20);
		jLEDEmail.setBackground(Color.BLACK);
		jLEDEmail.setFont(new Font("Tahoma",Font.BOLD,15));
		JPCenterRes.add(jLEDEmail);

		jTEDEmail=new JTextField();
		jTEDEmail.setBounds(135,480,130,30);
		JPCenterRes.add(jTEDEmail);

		jLEDUsername=new JLabel("Username");
		jLEDUsername.setBounds(30,525,90,20);
		jLEDUsername.setBackground(Color.BLACK);
		jLEDUsername.setFont(new Font("Tahoma",Font.BOLD,15));
		JPCenterRes.add(jLEDUsername);


		jTEDUsername=new JTextField();
		jTEDUsername.setBounds(135,525,130,30);
		JPCenterRes.add(jTEDUsername);

		jLEDPassword=new JLabel("Password");
		jLEDPassword.setBounds(30,570,90,20);
		jLEDPassword.setBackground(Color.BLACK);
		jLEDPassword.setFont(new Font("Tahoma",Font.BOLD,15));
		JPCenterRes.add(jLEDPassword);


		jTEDPassword=new JTextField();
		jTEDPassword.setBounds(135,570,130,30);
		JPCenterRes.add(jTEDPassword);

		jEDEdit=new JButton("EDIT");
		jEDEdit.setBounds(145,610,90,30);
		JPCenterRes.add(jEDEdit);


		jEDDelete=new JButton("DELETE");
		jEDDelete.setBounds(445,610,90,30);
		JPCenterRes.add(jEDDelete);

		JPCenterRes.revalidate();
		JPCenterRes.repaint();

		reMouse();
		reListenButton(this);
	}


public   int getIn() { 
	return getIRow;
	}
public String getID() {
	return jTEDID.getText();
	}
public String getName() {
	return jTEDName.getText();
	}
public String getAddress() {
	return jTEDAddress.getText();
	}
public String getContact() {
	return jTEDPhone.getText();
	}
public String getEmail() { 
	return jTEDEmail.getText();
	}
public String getUsername() { 
	return jTEDUsername.getText();
	}
public String getPassword() {
	return jTEDPassword.getText();
	}


//for the buttonlisteners

public void reListenButton(ResearcherManage reDelEdi)
	{
   jEDEdit.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
	try {
	addRData.editRelatedResear(reDelEdi, getIn());
        } 
	catch (FileNotFoundException e1) {
     e1.printStackTrace();
		} catch (IOException e1) {
	 e1.printStackTrace();
		}
		}
		});
	
   jEDDelete.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
	addRData.delRelatedResearcher(reDelEdi, getIn());
	}
		});
	}




//respective getters and setters method for the table

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