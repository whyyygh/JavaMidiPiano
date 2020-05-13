//LongMiniPianoPanel.java
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.applet.*;
import java.io.*;
import javax.swing.*;

public class LongMiniPianoPanel extends JPanel
{
	Toolkit toolkit = Toolkit.getDefaultToolkit();
	Image   image1=toolkit.getImage("image/longKey650/longMiniKey650.jpg");;
	Image   image2=toolkit.getImage("image/longKey/longMiniKeyMask237x45.gif");;
	Image tr_image2 = createImage(new FilteredImageSource(
				image2.getSource(), new DissolveFilter(170)));
	//Image   image3=toolkit.getImage("gifs/imagepanel02.jpg");;
	//Image   image4=toolkit.getImage("gifs/imagepanel03.gif");;
	public static int currentX = 59*3;
	public static int currentY = 0;
	public static int maskPosition = 4;// 1~8 default is 4
	
	public void setCurrentXY(int x,int y)
	{
		currentX = x;
		currentY = y;	
	}	
	public LongMiniPianoPanel()
	{
			
	}
	
	public void paint(Graphics g)	
	{
		MediaTracker tracker = new MediaTracker(this);
		tracker.addImage(image1,0);
		tracker.addImage(tr_image2,1);
		try
		{
			tracker.waitForAll();
		}catch(Exception e){}	
			
		g.drawImage(image1,0,0,this);
		g.drawImage(tr_image2,currentX,currentY,this);		
	}
	
	public void drawKeyboardMaskCurrentPosition(int position)
	{
		maskPosition = position;//equal 1 - 8
		switch(maskPosition)
		{
			case 1:
				currentX = 0;
				currentY = 0;
				break;	
			case 2:
				currentX = 59;
				currentY = 0;
				break;	
			case 3:
				currentX = 59*2;
				currentY = 0;
				break;	
			case 4:
				currentX = 59*3;
				currentY = 0;
				break;	
			case 5:
				currentX = 59*4;
				currentY = 0;
				break;	
			case 6:
				currentX = 59*5;
				currentY = 0;
				break;	
			case 7:
				currentX = 59*6;
				currentY = 0;
				break;	
			case 8:
				currentX = 59*7;
				currentY = 0;
				break;
		}
		repaint();
		
	}
	
}