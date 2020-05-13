//ChanelPanel.java
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import javax.swing.*;

public class ChanelPanel extends JPanel
{
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		
		Image   image1   =toolkit.getImage("image/tempimage/temp.jpg");
		
	public static int currentX;
	public static int currentY;
	public ChanelPanel()
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
		
		try
		{
			tracker.waitForAll();
		}catch(Exception e){}
		
		g.drawImage(image1,0,0,this);
		//System.out.println("now is paint()" + isKeyDown);	
		
		
	}
	public void drawKey()
	{	
	
	}
	public void drawKeyPressed(int keyOrder)
	{
			
	}
	public void drawKeyReleased(int keyOrder)
	{
	}
}