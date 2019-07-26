package viewV;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;



public class LoginPageView extends JFrame{
   // for the related data
	private JPanel jPMid;
	private JLabel jFImage,jLMain,jLLogin,jLUser,jLPass,jLWhich;
    private JTextField jTUser;
    private JPasswordField jTPass;
    private JButton jBLogin,jBExit;
    private JRadioButton jRAdmin = new JRadioButton("Admin");
    private String mem[]= {"Admin","Researcher"};
    ButtonGroup group = new ButtonGroup();
    private JRadioButton jResearcher = new JRadioButton("Researcher");
    private ImageIcon fullImage=new ImageIcon("uni.jpg");
     	
public LoginPageView(){
	setSize(775,700);
	setBounds(0,0,775,700);
	setTitle("NORTHAMPTON RESEARCH CENTER");
    setDefaultCloseOperation(EXIT_ON_CLOSE); 
	setResizable(false);
	setLocationRelativeTo(null);
	setLayout(null);
	Container contain= getContentPane();
    contain.setLayout(null);
				  
	jFImage=new JLabel(fullImage);
	jFImage.setBounds(0,0,775,700);
	jFImage.setLayout(null);
	contain.add(jFImage);
		
	jLMain=new JLabel("NORTHAMPTON RESEARCH CENTER");
	jLMain.setFont(new Font("Helvetica-Bold",Font.BOLD,30));
	jLMain.setForeground(Color.WHITE);
	jLMain.setBounds(60, 60, 550, 90);
	jFImage.add(jLMain);
		
		
		
	jPMid=new JPanel();
	jPMid.setBounds(180,150,400,410);
	jPMid.setBackground(new Color(0,0,0,65));
	jPMid.setLayout(null);
	jFImage.add(jPMid);
		
	jLLogin=new JLabel("LOG  IN ");
	jLLogin.setBounds(155,9,120,50);
    jLLogin.setForeground(Color.WHITE);
    jLLogin.setFont(new Font("Sitka Text", Font.BOLD, 24));
    jPMid.add(jLLogin);
        
        
    jLUser=new JLabel("Username");
    jLUser.setForeground(Color.WHITE);
    jLUser.setBounds(50,40,80,50);
    jPMid.add(jLUser);
		
	jTUser=new JTextField(20);
	jTUser.setBounds(50,80,270,30);
	jTUser.setBackground(Color.WHITE);
	jPMid.add(jTUser);
	
		
	jLPass=new JLabel("Password");
	jLPass.setBounds(50,110,80,50);
	jLPass.setForeground(Color.WHITE);
    jPMid.add(jLPass);

	jTPass=new JPasswordField(20);
	jTPass.setBounds(50,150,270,30);
	jTPass.setBackground(Color.WHITE);
	jPMid.add(jTPass);
		
		
	jLWhich=new JLabel("Login as:");
	jLWhich.setBounds(50,220,270,30);
    jLWhich.setForeground(Color.WHITE);
	jPMid.add(jLWhich);
		
		
	jRAdmin.setBounds(130,220,90,32);
	jPMid.add(jRAdmin);
    group.add(jRAdmin);
	jRAdmin.setActionCommand("Admin");
		
		
	jResearcher.setBounds(240,220,130,32);
	jPMid.add(jResearcher);
	group.add(jResearcher);
	jResearcher.setActionCommand("Researcher");
			
		
	jBLogin=new JButton("LOGIN");
	jBLogin.setBounds(100,285,100,30);
    jBLogin.setBackground(Color.BLACK);
	jBLogin.setForeground(Color.WHITE);
	jPMid.add(jBLogin);
		
	jBExit=new JButton("EXIT");
	jBExit.setBounds(230,285,100,30);
    jBExit.setBackground(Color.BLACK);
	jBExit.setForeground(Color.WHITE);
	jPMid.add(jBExit);
		
	setVisible(true);
		
				
}

public ButtonGroup getGroup() {
	return group;
}

public void setGroup(ButtonGroup group) {
	this.group = group;
}



   
public String getjTUser()
{
		return  jTUser.getText();
}


public char[] getjTPass() 
{
		return  jTPass.getPassword();
}

public JButton getjBLogin() 
{
		return jBLogin;
}

public void setjBLogin(JButton jBLogin) 
{
		this.jBLogin = jBLogin;
}

public JButton getjBExit() 
{
		return jBExit;
}

public void setjBExit(JButton jBExit) {
		this.jBExit = jBExit;
}



}
	
