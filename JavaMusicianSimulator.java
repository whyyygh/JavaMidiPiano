import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.FilteredImageSource;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class JavaMusicianSimulator extends JFrame
{
	public int frameSizeW=450;//450/1.618
	public int frameSizeH=280;
	public static int appProcess=5;
	public static int mainState=1;
	public int rectLX=340;
	public int rectLY=235;
	public int rectW=40;
	public int rectH=40;
	public String info_1 = "code whyyy";
	public String info_2 = "Java Keyboard Player";


	JPanel contentPane;
	BorderLayout borderLayout1 = new BorderLayout();

	Toolkit toolkit = Toolkit.getDefaultToolkit();
	Image   main_1 = toolkit.getImage("image/jms/main_01.jpg");
	Image   main_2 = toolkit.getImage("image/jms/main_02.jpg");
	Image   main_3 = toolkit.getImage("image/jms/main_03.jpg");
	Image   currentImage = main_1;
    Image imgJavaLogo=toolkit.getImage("image/jms/cupanim.gif");
    Image imgJavaLogo2 = createImage(new FilteredImageSource(
				imgJavaLogo.getSource(), new DissolveFilter(100)));
	Color red_tr = new Color(0.9f,0.1f,0.0f,0.5f);

	public JavaMusicianSimulator()
	{

    	//Center the window
    	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    	if (frameSizeH > screenSize.height) {
     	 frameSizeH = screenSize.height;
    	}
    	if (frameSizeW > screenSize.width) {
    	  frameSizeW = screenSize.width;
    	}
    	setLocation((screenSize.width - frameSizeW) / 2, (screenSize.height - frameSizeH) / 2);
    	setSize(frameSizeW,frameSizeH);
    	setTitle(" JavaMusicianSimulator");
    	this.setResizable(false);
    	Toolkit kit=Toolkit.getDefaultToolkit();
    	Image mainicon=kit.getImage("image/jms/jms_icon.gif");
    	Image imgCursor=kit.getImage("image/jms/Cursor.gif");
    	Image imgJavaLogo=kit.getImage("image/jms/cupanim.gif");
    	Cursor dc=kit.createCustomCursor(imgCursor,new Point(5,5),"point");
    	this.setIconImage(mainicon);
    	this.setCursor(dc);
    	this.setUndecorated(true);

    	MainPanel mp = new MainPanel();
		addKeyListener(mp);
		contentPane = (JPanel) this.getContentPane();
    	contentPane.setLayout(borderLayout1);
    	contentPane.add(mp,BorderLayout.CENTER);

    	setVisible(true);
	}

	public void applicationProcess()
	{
		switch(appProcess)
		{
			case 1://app1
				callOutClass("Application1");
				break;
			case 2://app2
				callOutClass("Application2");
				break;
			case 3://app3
				callOutClass("Application3");
				break;
			case 4://app4
				callOutClass("Application4");
				break;
			case 5://app see mainState = 1 use
				mainState = 2;
				appProcess = 1;
				currentImage = main_3;
				rectLX=265;
				rectLY=23;
				rectW=100;
				rectH=40;

				break;
			case 6://app help


				break;
			case 7://app back when mainState = 2 use
				mainState = 1;
				appProcess = 5;
				currentImage = main_1;
				info_2="Java Keyboard Player";
				rectLX=340;
				rectLY=235;
				rectW=40;
				rectH=40;
				break;
			case 8://app quit mainState = 1 use
				System.exit(0);
				break;
		}
	}

	public void callOutClass(String className)
	{	String outClassName=className;
		//Class[] argListForInvokedMain()
		Class[] argTypes = new Class[1];
		argTypes[0]=String[].class;
		try
		{
			Method mainMethod=Class.forName(outClassName).getDeclaredMethod("main",argTypes);

			Object[] argListForInvokedMain = new Object[1];
			//被调用的main()的参数个数是1
			argListForInvokedMain[0]=new String[2];
			//被调用的main()的参数是一个长度为2的String 数组
			String argsToinvoked[]={"WangShuanglin","Man"};
			argListForInvokedMain[0]=argsToinvoked;
			//设置传递给被调用的外部类的main()方法的参数
			mainMethod.invoke(null,argListForInvokedMain);
			//invoke(Object obj,Object[] args)是调用方法
			//其中obj是方法所在的对象的实例;但是因为这里的main()是静态方法,
			//所以无须实例化,添上null 即可;
			//args是传递给该方法的参数.
		}
		catch(ClassNotFoundException ex)
		{
			System.err.println("Class "+outClassName+" not found in classpath.");
		}
		catch(NoSuchMethodException ex)
		{
			System.err.println("Class "+outClassName+
			" dose not define public static  void main (String[])");
		}
		catch(InvocationTargetException ex)
		{
			System.err.println("Exception while executing "+
			outClassName+":"+ex.getTargetException());
		}
		catch(IllegalAccessException ex)
		{
			System.err.println("main(String[]) in class"+outClassName+"is not public ");
		}
	}


	public static void main(String[] args)
	{
		new JavaMusicianSimulator();

	}

	//======================================================
	//===============inner class MainPanel=====================
	//======================================================
	class MainPanel extends JPanel implements KeyListener
	{

		public void paint(Graphics g)
		{
			Graphics2D g2=(Graphics2D)g;
			if (mainState == 1)
			{
				MediaTracker tracker = new MediaTracker(this);
				tracker.addImage(currentImage,0);
				try
				{
					tracker.waitForAll();
				}catch(Exception e){}
				
				g.drawImage(currentImage,0,0,this);
				g2.setPaint(red_tr);
				g.fillRect(rectLX,rectLY,rectW,rectH);

				//g.drawImage(imgJavaLogo2,450-65,15,this);


				g2.setPaint(Color.black);
				g.setFont(new java.awt.Font("DialogInput", 0, 16));
				g.drawString(info_1,30,260);
				g.drawString(info_1,31,261);
				//System.out.println("paint() "+mainState+rectLX);
			}
			else if(mainState == 2)
			{
				MediaTracker tracker = new MediaTracker(this);
				tracker.addImage(currentImage,0);
				try
				{
					tracker.waitForAll();
				}catch(Exception e){}
				
				g.drawImage(currentImage,0,0,this);
				g2.setPaint(red_tr);
				g.fillRect(rectLX,rectLY,rectW,rectH);

				g2.setPaint(Color.black);

				g.setFont(new java.awt.Font("DialogInput", 0, 16));
				g.drawString(info_2,30,260);
				g.drawString(info_2,31,261);
			}
		}
		public MainPanel()
		{
			addKeyListener(this);

		}

		public void keyPressed(KeyEvent event)
		{
			int key = event.getKeyCode();
			keyControl(key);
			System.out.println("Enter press "+key);
		}
		public void keyReleased(KeyEvent event)
		{

		}
		public void keyTyped(KeyEvent event)
		{

		}

		public void keyControl(int i)
		{
			int keyCode = i;
			switch(mainState)
			{
				case 1://in mainState 1
					if(keyCode == 37)
					{
						rectLX=340;
						rectLY=235;
						rectW=40;
						rectH=40;
						info_1 = "Java Musician Simulator";
						appProcess = 5;
					}
					else if(keyCode == 39)
					{
						rectLX=395;
						rectLY=235;
						rectW=40;
						rectH=40;
						info_1 = "Quit";
						appProcess = 8;
					}
					repaint();
					break;
				case 2://in mainState 2
					if(keyCode == 38)
					{
						switch(appProcess)
						{
							case 1:
								rectLX=265;
								rectLY=23;
								rectW=100;
								rectH=40;
								appProcess = 1;
								info_2="Java Keyboard Player";
								break;
							case 2:
								rectLX=265;
								rectLY=23;
								rectW=100;
								rectH=40;
								appProcess = 1;
								info_2="Java Keyboard Player";
								break;
							case 3:
								rectLX=265;
								rectLY=73;
								rectW=100;
								rectH=40;
								appProcess = 2;
								info_2="Java VOS";
								break;
							case 4:
								rectLX=330;
								rectLY=128;
								rectW=100;
								rectH=40;
								appProcess = 3;
								info_2="Java Recorder";
								break;
							case 7:
								rectLX=330;
								rectLY=180;
								rectW=100;
								rectH=40;
								appProcess = 4;
								info_2="Java MIDI Player";
								break;
						}
					}
					else if(keyCode == 40)//down Key
					{
						switch(appProcess)
						{
							case 1:
								rectLX=265;
								rectLY=73;
								rectW=100;
								rectH=40;
								appProcess = 2;
								info_2="Java VOS";
								break;
							case 2:
								rectLX=330;
								rectLY=128;
								rectW=100;
								rectH=40;
								appProcess = 3;
								info_2="Java Recorder";
								break;
							case 3:
								rectLX=330;
								rectLY=180;
								rectW=100;
								rectH=40;
								appProcess = 4;
								info_2="Java MIDI Player";
								break;
							case 4:
								rectLX=395;
								rectLY=236;
								rectW=40;
								rectH=40;
								appProcess = 7;
								info_2="Back ->";
								break;
							case 7:
								rectLX=395;
								rectLY=236;
								rectW=40;
								rectH=40;
								appProcess = 7;
								info_2="Back ->";
								break;
						}
					}
					repaint();
					System.out.println(mainState+"    "+appProcess);
					break;
			}
			if(keyCode == 10)
			{
				System.out.println("Enter press");
				applicationProcess();
				repaint();
			}
		}
	}



}