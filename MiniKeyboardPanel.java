//MiniKeyboardPanel.java
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;
import javax.swing.*;
import java.awt.image.*;

public class MiniKeyboardPanel extends JPanel
{
	Toolkit toolkit = Toolkit.getDefaultToolkit();
	//base map
	Image   image1=toolkit.getImage("image/miniKey650/miniKey644.jpg");
		//press key
	Image   imageB =toolkit.getImage("image/miniKey/pressBlackKey.gif");
	Image   imageW1=toolkit.getImage("image/miniKey/pressWhiteKey01.gif");
	Image   imageW2=toolkit.getImage("image/miniKey/pressWhiteKey02.gif");
	Image   imageW3=toolkit.getImage("image/miniKey/pressWhiteKey03.gif");
	static Image   currentKey;
	
	public static int currentX;
	public static int currentY;
	public int orderNumW [] = {0, 2, 4, 5, 7, 9,11,
							  12,14,16,17,19,21,23,
							  24,26,28,29,31,33,35,
							  36,38,40,41,43,45,47};
	public int orderNumB [] = {  1, 3, 6, 8,10,
								13,15,18,20,22,
								25,27,30,32,34,
								37,39,42,44,46};
							
	public static boolean isKeyDown=false;
	public boolean isWhiteKey=false;
	//Frame1 f1=new Frame1();
		
	public MiniKeyboardPanel()
	{
		//currentX = x;
		//currentY = y;	
	}
	public void setCurrentXY(int x,int y)
	{
		//currentX = x;
		//currentY = y;	
	}
	public void paint(Graphics g)	
	{
		MediaTracker tracker = new MediaTracker(this);
		tracker.addImage(image1,0);
		tracker.addImage(currentKey,1);
		try
		{
			tracker.waitForAll();
		}catch(Exception e){}
				
		g.drawImage(image1,0,0,this);
		//System.out.println("now is paint()" + isKeyDown);	
		
		if(isKeyDown)
		//if(true)
		{
			g.drawImage(currentKey ,currentX,currentY,this);
			//repaint();
			//isKeyDown = false;
			//System.out.println("now is paint(key)");	
		}
		
		
	}
	
	public void drawKeyPressed(int keyOrder)
	{	//System.out.println("XXXXXX");
		isKeyDown=true;
		//order is 0~47
		int order=keyOrder;
		//use order calc drawKey's color and position
		for(int i=0;i<orderNumW.length;i++)
		{
			//judge key 1 or 2 or 3 whiteKey
			if(order == orderNumW[i])
			{
				if( order == 0 || order == 12 || order == 24 || order == 36 ||
					order == 5 || order == 17 || order == 29 || order == 41)
				{	
					currentKey = imageW1;
					System.out.println("1");
					//currentX = i*24;
					//currentY = 0;
				}
				else if( order == 2 || order == 14 || order == 26 || order == 38 ||
						 order == 7 || order == 19 || order == 31 || order == 43 ||
						 order == 9 || order == 21 || order == 33 || order == 45)
				{	
					currentKey = imageW2;
					
				}
				else if( order ==  4 || order == 16 || order == 28 || order == 40 ||
						 order == 11 || order == 23 || order == 35 || order == 47)
				{	currentKey = imageW3;}
				
				currentX = i*23;
				currentY = 0;
			
				repaint();
			}
		}
		for(int i=0;i<orderNumB.length;i++)
		{
			//judge key 1 or 2 or 3 whiteKey
			if(order == orderNumB[i])
			{
				if( order == 1 || order == 13 || order == 25 || order == 37 ||
					order == 3 || order == 15 || order == 27 || order == 39)
				{
					if(order == 1 || order == 3)
					{
						currentX = 17+i*23;
					}	
					else if(order == 13 || order == 15)
					{
						if(order == 13)
							currentX = 23*7+17;
						else
							currentX = 23*8+17;
					}	
					else if(order == 25 || order == 27)
					{
						if(order == 25)
							currentX = 23*14+17;
						else
							currentX = 23*15+17;
					}	
					else if(order == 37 || order == 39)
					{
						if(order == 37)
							currentX = 23*21+17;
						else
							currentX = 23*22+17;
					}
				}
				else if( order ==  6 || order == 18 || order == 30 || order == 42 ||
						 order ==  8 || order == 20 || order == 32 || order == 44 ||
						 order == 10 || order == 22 || order == 34 || order == 46)
				{	
					if(order == 6 || order == 8 || order == 10 )
					{
						switch(order)
						{
							case 6:
								currentX = 23*3+17;
								break;
							case 8:
								currentX = 23*4+17;
								break;
							case 10:
								currentX = 23*5+17;
								break;
						}
					}
					else if(order == 18 || order == 20 || order == 22)
					{
						switch(order)
						{
							case 18:
								currentX = 23*10+17;
								break;
							case 20:
								currentX = 23*11+17;
								break;
							case 22:
								currentX = 23*12+17;
								break;
						}
					}
					else if(order == 30 || order == 32 || order == 34)
					{
						switch(order)
						{
							case 30:
								currentX = 23*17+17;
								break;
							case 32:
								currentX = 23*18+17;
								break;
							case 34:
								currentX = 23*19+17;
								break;
						}
					}
					else if(order == 42 || order == 44 || order == 46)
					{
						switch(order)
						{
							case 42:
								currentX = 23*24+17;
								break;
							case 44:
								currentX = 23*25+17;
								break;
							case 46:
								currentX = 23*26+17;
								break;
						}
					}
				}
				
				currentKey = imageB;
				//currentX = i*23;
				currentY = 0;
			
				repaint();
			}
		}
	}
	public void drawKeyReleased(int keyOrder)
	{
		//System.out.println("YYYYYYY");
		isKeyDown=false;
		repaint();	
	}
}