package viewV;


import java.awt.*;
import java.awt.event.ActionListener;
import controllerC.*;
import javax.swing.*;


public class BasicView extends JFrame {
	
	//Attributes and objects
	
    public static JPanel jPMain=new JPanel();
	public static JPanel jPSide=new JPanel();
	public static JPanel jPTop=new JPanel();
	private JButton jBArti,jBResearch,jBCheck,jBLogOut;
	private JLabel jLTopic,jLMiddle;
	private ImageIcon baseImage=new ImageIcon("base.jpg");
	
public BasicView() {//constructor
		
		    
	setSize(1065,720);
	setBounds(0,0,1065,720);
	setTitle("NORTHAMPTON RESEARCH CENTER");
	setDefaultCloseOperation(EXIT_ON_CLOSE); 
	setResizable(false);
	setLocationRelativeTo(null);
	setLayout(null);
	Container contain= getContentPane();
	setVisible(true);
	contain.setLayout(null);
		     
	jPTop= new JPanel();
	jPTop.setBounds(0, 0, 1065, 80);
	jPTop.setLayout(null);
	jPTop.setBackground(new Color(119, 115, 155));
	contain.add(jPTop);
		    
	jLTopic=new JLabel("NOTHAMPTON   RESEARCH   CENTER");
	jLTopic.setBounds(223,13,600,60);
	jLTopic.setFont(new Font("Sitka Text", Font.BOLD, 26));
	jPTop.add(jLTopic);
		    
	jBLogOut=new JButton("LOG OUT");
	jBLogOut.setBounds(890,0,160,80);
	jBLogOut.setFont(new Font("Sitka Text", Font.BOLD, 26));
	jBLogOut.setForeground(Color.WHITE);
	jBLogOut.setBackground(Color.BLACK);
	jPTop.add(jBLogOut);
		    
		    
	jPSide=new JPanel();
	jPSide.setBounds(0,80,300,640);
	jPSide.setLayout(null);
	jPSide.setBackground(new Color(109, 146, 153));
	contain.add(jPSide);
		    
	jBArti=new JButton("ARTICLES");
	jBArti.setBounds(80,50,130,50);
	jBArti.setForeground(Color.WHITE);
	jBArti.setBackground(Color.BLACK);
	jPSide.add(jBArti);
		    
		    
		    
	jBResearch=new JButton("RESEARCHERS");
	jBResearch.setBounds(80,440,130,50);
	jBResearch.setForeground(Color.WHITE);
	jBResearch.setBackground(Color.BLACK);
	jPSide.add(jBResearch);
	    
	jLMiddle=new JLabel(baseImage);
	jLMiddle.setBounds(300,80,765,640);
	contain.add(jLMiddle);
	//controller call	    
	BasicViewController bcont=new BasicViewController(this);
	bcont.baseManage();
		
	}

	
	//action listener for the respective buttons
public void actionArticle(ActionListener a) 
{
	 jBArti.addActionListener(a);
}
	
public void actionResearcher(ActionListener a)
{ jBResearch.addActionListener(a);}


public void actionCheck(ActionListener a)
	{ jBCheck.addActionListener(a);}

public void actionLogout(ActionListener a) 
	{
		jBLogOut.addActionListener(a);
}
}
