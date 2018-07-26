import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
public class ATMJApplet extends JApplet implements ActionListener
{ 
	void addClickMe(String buttonName, int x, int y, int size, TextField tf) 
	{
		JButton clickMe = new JButton(nazwaGuzika);
		setLayout(null);
		clickMe.setBounds(x,y,size,size);
		clickMe.addActionListener( new ActionListener()
		{
			public void actionPerformed(ActionEvent whatsUp){
			String sampleString = tf.getText();
			tf.setText(sampleString + buttonName);
		}});

		add(clickMe);
	}
	
	void addKeyboard(TextField tf)
	{
		addClickMe("1", 10, 100, 60, tf);
		addClickMe("2", 70, 100, 60, tf);
		addClickMe("3", 130, 100, 60, tf);
		
		addClickMe("4", 10, 160, 60, tf);
		addClickMe("5", 70, 160, 60, tf);
		addClickMe("6", 130, 160, 60, tf);
		
		addClickMe("7", 10, 220, 60, tf);
		adClickMe("8", 70, 220, 60, tf);
		addClickMe("9", 130, 220, 60, tf);
		
		addClickMe("0", 70, 280, 60, tf);
		
		JButton clickMeHash = new JButton("#");
		setLayout(null);
		clickMeHash.setBounds(10,280,60,60);
		clickMeHash.addActionListener( new ActionListener()
		{
			public void actionPerformed(ActionEvent whatsUp){
			tf.setText("");
		}});
		add(clickMeHash);
		
	}
	
	public void init()
	{
		setSize(200,400);
		setVisible(true);
		setLayout (null);
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		Container c = this.getContentPane();
		TextField tf = new TextField();
		tf.setBounds(30,60,145,30); 
		add(tf);
		addKeyboard(tf);
		
		
		JButton clickMeEnter = new JButton("e");
		clickMeEnter.setBounds(130,280,60,60);
		clickMeEnter.addActionListener( 
				new ActionListener()
				{
					public void actionPerformed(ActionEvent whatsUp)
					{	
						JFrame f = new JFrame("SUmthing");
	
						MyClass a = new MyClass(tf);
						f.getContentPane().add(a);
						f.setSize(800, 300);
						f.setVisible(true);
						
					}
				});
		add(clickMeEnter);	
	
	
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	}

}

class MyClass extends JPanel
{
	private static final long serialVersionUID = 1L;
	private int price;
	private int [] transaction = {0,0,0,0,0,0,0,0}; //8
	private String [] nominalsUS= {"  $500","  $200","  $100","   $50","   $20","   $10","    $5","    $1"};
	private final int[] nominals = {500, 200, 100, 50, 20, 10, 5, 1};
	private int index = 0;
	
	public MyClass(TextField tf)
	{
		this.price=Integer.parseInt(tf.getText());
		
	    System.out.println("Start: $"+price);
	    while(price!=0.0)
	    {
	    	if((kwota-nominals[index])>=0)
	    	{
	    		kwota = kwota - nominals[index];
	    		System.out.print("Kwota = " +price+"; ");
	    		transaction[index] = transaction[index]+1;
	    		System.out.println("transakcja["+index+"] = "+transaction[index]+";");
	    	}
	    	else
	    	{
	    		index++;
	    	}
	    }
	    	
	}
	
	public void paint(Graphics g)
	{
		int x = 15, y = 15;
		index=0;
		for(index=0;index<8;index++)
		{
			for(int i = 0; i<transaction[index];i++) 
			{
				g.setColor(Color.GREEN);
				g.fillRect(x+(i*1), y+(i*10), 40, 20);
				g.setColor(Color.BLACK);
				g.drawRect(x+(i*1), y+(i*10), 40, 20);
				g.drawString(nominals_US[index],x+(i*1),y+(15+i*10));
				
			}
			x+=60;
		}
		x = 15; // u can also use "x-=(60*index) otherwise the program will start drawing dollars from x = 475 
		
	
	}
}
