//PCKeyboardPanel.java
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import javax.swing.*;

public class PCKeyboardPanel extends JPanel
{
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		
		Image   image1   =toolkit.getImage("image/PCKey650/PCKey650_3.jpg");
		Image   image2   =toolkit.getImage("image/PCKey650_2.jpg");;
		Image   key_alt  =toolkit.getImage("image/PCKey/PCKey_alt.gif");
		Image   key_ctrl =toolkit.getImage("image/PCKey/PCKey_ctrl.gif");
		Image   key_shift_L=toolkit.getImage("image/PCKey/PCKey_shift_left.gif");
		Image   key_shift_R=toolkit.getImage("image/PCKey/PCKey_shift_right.gif");
		Image   key_move_L=toolkit.getImage("image/PCKey/PCKey_letter_moveleft.gif");
		Image   key_move_R=toolkit.getImage("image/PCKey/PCKey_letter_moveright.gif");
		Image   key_letter=toolkit.getImage("image/PCKey/PCKey_letter.gif");
		Image   key_space =toolkit.getImage("image/PCKey/PCKey_space.gif");
		
		Image   currentKey_1=toolkit.getImage("image/PCKey");
		Image   currentKey_2=toolkit.getImage("image/PCKey");
		Image   currentKey_3=toolkit.getImage("image/PCKey");
		
	public static int currentX;
	public static int currentY;
	public boolean isKeyDown=false;
	public PCKeyboardPanel()
	{
			
	}
	public void setCurrentXY(int x,int y)
	{
		currentX = x;
		currentY = y;	
	}
	public void paint(Graphics g)	
	{
		MediaTracker tracker = new MediaTracker(this);
		tracker.addImage(image1,0);
		tracker.addImage(currentKey_1,1);
		try
		{
			tracker.waitForAll();
		}catch(Exception e){}
		
		g.drawImage(image1,0,0,this);
		//System.out.println("now is paint()" + isKeyDown);	
		
		if(isKeyDown)
		//if(true)
		{
			g.drawImage(currentKey_1 ,currentX,currentY,this);
			//repaint();
			//isKeyDown = false;
			//System.out.println("now is paint(key)");	
		}		
	}
	public void drawKey()
	{	
		//if want to change the GUI ,then change KeyboardPlayer.java's code
		//in readKeyPress() and readKeyRelease() methods
		//draw letter key
		//draw space key
		//draw F1 - F12 key
		//draw Ctrl  Alt  Shift key
		//	
	}
	public void drawKeyPressed(int keyOrder)
	{
			
	}
	public void drawKeyReleased(int keyOrder)
	{
		//System.out.println("YYYYYYY");
		isKeyDown=false;
		repaint();	
	}
}