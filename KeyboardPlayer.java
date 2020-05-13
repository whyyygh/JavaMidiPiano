//KeyboardPlayer.java
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.io.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.sound.midi.*;

import com.borland.jbcl.layout.*;
import javax.swing.border.*;


class KeyboardPlayer extends JPanel
{
  	private Synthesizer synthesizer;                     // The synthesizer
  	private MidiChannel channel;
  	private MidiChannel channels [] ;                       // The channel we will use
  	private Instrument instruments[];                    // Available instruments
  	//private JComboBox instrumentChoice;                  // Choice of instruments
  	private static int velocity = 127;   // Note velocity, 0-127 min to max

  	public static MidiChannel currentChannel []=new MidiChannel [16];
  	public static Instrument  currentInstrument;
  	public static int currentPatch;
  	public static int currentBankNumber=0;
  	public static int currentProgramNumber=0;
  	public static int currentChannelNumber=0;
  	public static int currentNote;
  	public static int currentPressVelocity=0;
  	public static int currentReleaseVelocity=0;

  	public static boolean isPianoStyle = false;

  	MiniKeyboardPanel MKPanel;
  	LongMiniPianoPanel LMPPanel;
  	PCKeyboardPanel PCKPanel;

  	JLabel jLabel1 = new JLabel();
  	VerticalFlowLayout verticalFlowLayout1 = new VerticalFlowLayout();

  	JLabel jLabel2 = new JLabel();
  	JLabel jLabel3 = new JLabel();
  	JLabel jLabel4 = new JLabel();
  	JLabel jLabel5 = new JLabel();
  	JLabel jLabel6 = new JLabel();
  	JLabel jLabel7 = new JLabel();
  	JLabel jLabel8 = new JLabel();
  	JLabel jLabel9 = new JLabel();
  	JLabel jLabel10 = new JLabel();
  	JLabel jLabel11 = new JLabel();
  	JLabel jLabel12 = new JLabel();
  	JLabel jLabel13 = new JLabel();
  	JLabel jLabel14 = new JLabel();
  	JLabel jLabel15 = new JLabel();
  	JLabel jLabel16 = new JLabel();
  	//
  	JButton jButton1 = new JButton();
  	//
  	JTextField jTextField1 = new JTextField();
  	JTextField jTextField2 = new JTextField();
  	//
  	JCheckBox jCheckBox1 = new JCheckBox();

  	//
  	TitledBorder titledBorder1;
  	TitledBorder titledBorder2;
  	TitledBorder titledBorder3;
  	Border border1;
  	TitledBorder titledBorder4;
  	Border border2;
  	Border border3;
  	Border border4;
  	TitledBorder titledBorder5;
  	Border border5;
  	TitledBorder titledBorder6;
  	//

  	JSlider jSlider1 = new JSlider();
  	JSlider jSlider2 = new JSlider();
  	//JCheckBox jCheckBox1 = new JCheckBox();
  	JCheckBox jCheckBox2 = new JCheckBox();
  	JCheckBox jCheckBox3 = new JCheckBox();
  	JLabel jLabel17 = new JLabel();

  	JFrame mainFrame;



  	//so this method to get instance MiniKeyboardPanel in Frame,
  	//since have this method, i can call any instance easier.hehe :>
  	//i think this is a prime key method :>
  	public void getMKPanel(JPanel obj)
  	{
  		MKPanel=(MiniKeyboardPanel)obj;
  	}
  	public void getLMPPanel(JPanel obj)
	{
		LMPPanel=(LongMiniPianoPanel)obj;
	}
	public void getPCKPanel(JPanel obj)
	{
		PCKPanel=(PCKeyboardPanel)obj;
	}
	public void getFrame(JFrame f)
	{
		mainFrame=(Frame1)f;
	}

	public KeyboardPlayer()
	{
		setLayout(verticalFlowLayout1);
		jLabel1.setText("jLabel1");
		jLabel2.setText("jLabel2");
    	jLabel3.setText("jLabel3");
    	jLabel4.setText("jLabel4");
    	jLabel5.setText("jLabel5");
    	jLabel6.setText("jLabel6");
    	jLabel7.setText("jLabel7");
    	jLabel8.setText("jLabel8");
    	jLabel9.setText("jLabel9");
    	jLabel10.setText("Percussion");
    	jLabel11.setText("jLabel11");
    	jLabel12.setText("jLabel12");
    	jLabel13.setText("jLabel13");
    	jLabel14.setText("jLabel14");
    	jLabel15.setText("jLabel15");
    	jLabel16.setText("jLable16");
    	jLabel17.setText("Instrument");
    	jButton1.setText("Setting");
    	jButton1.addActionListener(new Frame1_jButton1_actionAdapter(this));
    	jTextField1.setText("Bank Number");
    	jTextField1.addActionListener(new Frame1_jTextField1_actionAdapter(this));
    	jTextField2.setText("Program Number");
    	jTextField2.addActionListener(new Frame1_jTextField2_actionAdapter(this));

    	jCheckBox1.setFont(new java.awt.Font("DialogInput", 0, 11));
    	jCheckBox1.setForeground(Color.blue);
    	jCheckBox1.setText(" PC or Piano");
    	jCheckBox1.addActionListener(new Frame1_jCheckBox1_actionAdapter(this));

    	jLabel1.setFont(new java.awt.Font("DialogInput", 0, 11));
    	jLabel2.setFont(new java.awt.Font("DialogInput", 0, 11));
    	jLabel3.setFont(new java.awt.Font("DialogInput", 0, 11));
    	jLabel4.setFont(new java.awt.Font("DialogInput", 0, 11));
    	jLabel5.setFont(new java.awt.Font("DialogInput", 0, 11));
    	jLabel6.setFont(new java.awt.Font("DialogInput", 0, 11));
    	jLabel7.setFont(new java.awt.Font("DialogInput", 0, 11));
    	jLabel8.setFont(new java.awt.Font("DialogInput", 0, 11));
    	jLabel9.setFont(new java.awt.Font("DialogInput", 0, 11));
    	jLabel10.setFont(new java.awt.Font("DialogInput", 0, 11));
    	jLabel11.setFont(new java.awt.Font("DialogInput", 0, 11));
    	jLabel12.setFont(new java.awt.Font("DialogInput", 0, 11));
    	jLabel13.setFont(new java.awt.Font("DialogInput", 0, 11));
    	jLabel14.setFont(new java.awt.Font("DialogInput", 0, 11));
    	jLabel15.setFont(new java.awt.Font("DialogInput", 0, 11));
    	jLabel16.setFont(new java.awt.Font("DialogInput", 0, 11));
    	jLabel17.setFont(new java.awt.Font("DialogInput", 0, 11));
    	jButton1.setFont(new java.awt.Font("DialogInput", 0, 11));
    	jTextField1.setFont(new java.awt.Font("DialogInput", 0, 11));
    	jTextField1.setForeground(Color.blue);
    	jTextField1.setHorizontalAlignment(SwingConstants.CENTER);
    	jTextField2.setFont(new java.awt.Font("DialogInput", 0, 11));
    	jTextField2.setForeground(Color.blue);
    	jTextField2.setHorizontalAlignment(SwingConstants.CENTER);

    	jLabel1.setBorder(BorderFactory.createLineBorder(Color.black));
		add(jLabel1, null);
		add(jLabel2, null);
		add(jLabel3, null);
		add(jLabel4, null);
		add(jLabel5, null);
		add(jLabel6, null);
		add(jLabel7, null);
		add(jLabel8, null);
		add(jLabel9, null);
		add(jLabel10, null);
		add(jLabel11, null);
		add(jLabel12, null);
		add(jLabel13, null);
		add(jLabel14, null);
		add(jLabel15, null);
		add(jLabel16, null);
		add(jButton1, null);
		add(jTextField1, null);
		add(jTextField2, null);
		add(jCheckBox1, null);
		add(jLabel17, null);
    	try
    	{
    	  synthesizer = MidiSystem.getSynthesizer();       // Get the synthesizer...
    	  synthesizer.open();                              // ...and open it
    	}
    	catch(MidiUnavailableException e)
    	{
  			JOptionPane.showMessageDialog(null,
  								"No synthesizer available – terminating...",
                                "MIDI Error", JOptionPane.ERROR_MESSAGE);
      		System.exit(1);
    	}

		channels = synthesizer.getChannels();    // Get the channels
    	for(int i = 0 ; i< channels.length ; i++)        // Get first non-null channel
    	{
      		if(channels[i] != null)
      		{
      	 	 	channel = channels[i];

      	 	 	//System.out.println(channels.length);
      	 	 	break;
      		}
      	}

    	instruments = synthesizer.getAvailableInstruments();   // Get the instruments
    	if(instruments.length == 0)                       // ...and check we have some
    	{
  			JOptionPane.showMessageDialog(null, "No instruments available – terminating...",
                                "MIDI Error", JOptionPane.ERROR_MESSAGE);
     	 	System.exit(1);
    	}

    	for(int i = 0 ; i<Math.min(16384,instruments.length);i++)
    	{
    		//System.out.println("Synthesizer available instruments NUM: "
    		//					+instruments.length);
    		/*System.out.println(instruments[i].getPatch().getBank()
    							+"  "+instruments[i].getPatch().getProgram()
    							+"  "+instruments[i].getName()
    							+"  "+i);*/
    	}

   		MiniKeyboardPanel MKPanel = new MiniKeyboardPanel();
		PCKeyboard pck = new PCKeyboard();
		addKeyListener(pck);

    	for(int i=0;i<16;i++)
    	{
			//get sound group per 8 program
    		channels[i].programChange(0,i*8);

    		String iName = instruments[i*8].getName();
    		int patchBank = instruments[i*8].getPatch().getBank();
    		int patchProgram = instruments[i*8].getPatch().getProgram();
    		System.out.println("Bank="+patchBank+"  Program="+patchProgram
    							+"  Patch Name="+iName);
    		int ch = i+1;//ch is label number
    		changeLabelText(ch,iName);
    	}

     	Patch patch = instruments[3].getPatch();
     	channel.programChange(currentBankNumber,currentProgramNumber);
    	//channel.programChange(patch.getBank(),patch.getProgram());
    	//channel.programChange(1,45);
		//channel.programChange(78);

    	setVisible(true);
	}


	public boolean isFocusTraversable()
	{
		return true;
	}

    //===========================================
	//==========inner class PCKeyboard===========
	//===========================================
	class PCKeyboard implements KeyListener
	{
      	final static int width = 20;                      // White key width
     	final static int height = 100;                    // White key length
     	//keydown is judge the PCKeyboard is down,
     	//because PC key is listening ,so sent many signal different Piano
      	private boolean keydown = false;
      	//pianoKeydown is judge the Piano Key is down,
      	//because Piano key sometime pressed some mseconds,then released
      	//so define this symble like the real Piano.
      	private boolean pianoKeydown = false;
      	//this symble is to choose Piano Style or PC Style,
      	//Piano style is slowly press and release,
      	//PC style is like PC key anytime listen press and release.
      	//private boolean isPianoStyle =false;

      	private Color color;                              // Key color
      	int noteNumber;
      	int keyboardPosition=4;//between 1-8 defualt is 4
      	Frame1 frame1;

      	public void readKeyPress(KeyEvent event,int key_code)
      	{
      		int keyCode=key_code;
      		//if press "~" or "Backspace",
      		//equal keyboard move left or right 8 degrees
			if(keyCode == 192 || keyCode == 8)
			{
				if(keyCode == 192)//move left
				{
					if(keyboardPosition >=2)
					{
						--keyboardPosition;
						LMPPanel.drawKeyboardMaskCurrentPosition(keyboardPosition);
					}
					else{}
						//do nothing
				}
				else //move right
				{
					if(keyboardPosition <=7)
					{
						++keyboardPosition;
						LMPPanel.drawKeyboardMaskCurrentPosition(keyboardPosition);
					}
					else{}
						//do nothing
				}
			}
			//up,down,left,right Key down
			//to change currentProgramNumber
			else if(keyCode <= 40 && keyCode >=37)
			{
				switch(keyCode)
				{
					case 37://left ,add Patch bank num +1
						//bank -1
						plusBank(2);
						//set Bank TextField's Text

						break;
					case 38://up ,add Patch program num +1
						//program -1
						plusProgram(2);
						//channel.programChange(patch.getBank(),patch.getProgram());
						//set Program TextField's Text

						break;
					case 39://right ,add Patch bank num -1
						//bank +1
						plusBank(1);
						//set Bank TextField's Text

						break;
					case 40://down ,add Patch program num -1
						//program +1
						plusProgram(1);
						//set Program TextField's Text

						break;
				}
			}
      		//Shift Down
			else if(event.isShiftDown())
			{
				if(event.isShiftDown() && (keyCode <= 123 && keyCode >= 112))
				{//Shift + F1~F12 ,equal choose the Patch

				}
				else if(event.isShiftDown())
				{//Shift + 3,4--7,8,9
	 			 //        E,R--U,I.O
	 			 //        D,F--J,K,L
	 			 //        C,V--M,<,>
	 			 //equal press black Key
	 			//|||||||||||||BLACK KEY A~Z Down|||||||||||||||
	 			switch(keyCode)
	 			{	//===================layer 1
	 				case 51://3
	 					noteNumber = 1;
						keyToSound(noteNumber);
	 					break;
	 				case 52://4
	 					noteNumber = 3;
						keyToSound(noteNumber);
	 					break;
	 				case 55://7
	 					noteNumber = 6;
						keyToSound(noteNumber);
	 					break;
	 				case 56://8
	 					noteNumber = 8;
						keyToSound(noteNumber);
	 					break;
	 				case 57://9
	 					noteNumber = 10;
						keyToSound(noteNumber);
	 					break;
	 				//===================layer 2
	 				case 69://E
	 					noteNumber = 13;
						keyToSound(noteNumber);
	 					break;
	 				case 82://R
	 					noteNumber = 15;
						keyToSound(noteNumber);
	 					break;
	 				case 85://U
	 					noteNumber = 18;
						keyToSound(noteNumber);
	 					break;
	 				case 73://I
	 					noteNumber = 20;
						keyToSound(noteNumber);
	 					break;
	 				case 79://O
	 					noteNumber = 22;
						keyToSound(noteNumber);
	 					break;
	 				//===================layer 3
	 				case 68://D
	 					noteNumber = 25;
						keyToSound(noteNumber);
	 					break;
	 				case 70://F
	 					noteNumber = 27;
						keyToSound(noteNumber);
	 					break;
	 				case 74://J
	 					noteNumber = 30;
						keyToSound(noteNumber);
	 					break;
	 				case 75://K
	 					noteNumber = 32;
						keyToSound(noteNumber);
	 					break;
	 				case 76://L
	 					noteNumber = 34;
						keyToSound(noteNumber);
	 					break;
	 				//===================layer 4
	 				case 67://C
	 					noteNumber = 37;
						keyToSound(noteNumber);
	 					break;
	 				case 86://V
	 					noteNumber = 39;
						keyToSound(noteNumber);
	 					break;
	 				case 77://M
	 					noteNumber = 42;
						keyToSound(noteNumber);
	 					break;
	 				case 44://<
	 					noteNumber = 44;
						keyToSound(noteNumber);
	 					break;
	 				case 46://>
	 					noteNumber = 46;
						keyToSound(noteNumber);
	 					break;
	 				}

				}
			}
			//Control or Alt Down
			else if(event.isControlDown() || event.isAltDown())
			{	//because all chanel is 16, and only F12 in PCKeyboard
				if(event.isControlDown() && (keyCode <= 121 && keyCode >= 112))
				{//Ctrl + F1~F10 ,equal fellowing chanel is open or close
				 //to show channal 1 -10
				 //ctrl + F11 or F12 not using in windows
					switch(keyCode)
					{
						case 112:
							setLabelBorder();
							jLabel1.setForeground(Color.blue);
							jLabel1.setBorder(BorderFactory.createLineBorder(Color.blue));
							//jLabel1.setText("1 ");
							changeChannel(0);
							break;
						case 113:
							setLabelBorder();
							jLabel2.setForeground(Color.blue);
							jLabel2.setBorder(BorderFactory.createLineBorder(Color.blue));
							//jLabel2.setText("1 ");
							changeChannel(1);
							break;
						case 114:
							setLabelBorder();
							jLabel3.setForeground(Color.blue);
							jLabel3.setBorder(BorderFactory.createLineBorder(Color.blue));
							//jLabel3.setText("1 ");
							changeChannel(2);
							break;
						case 115:
							setLabelBorder();
							jLabel4.setForeground(Color.blue);
							jLabel4.setBorder(BorderFactory.createLineBorder(Color.blue));
							//jLabel4.setText("1 ");
							changeChannel(3);
							break;
						case 116:
							setLabelBorder();
							jLabel5.setForeground(Color.blue);
							jLabel5.setBorder(BorderFactory.createLineBorder(Color.blue));
							//jLabel5.setText("1 ");
							changeChannel(4);
							break;
						case 117:
							setLabelBorder();
							jLabel6.setForeground(Color.blue);
							jLabel6.setBorder(BorderFactory.createLineBorder(Color.blue));
							//jLabel6.setText("1 ");
							changeChannel(5);
							break;
						case 118:
							setLabelBorder();
							jLabel7.setForeground(Color.blue);
							jLabel7.setBorder(BorderFactory.createLineBorder(Color.blue));
							//jLabel7.setText("1 ");
							changeChannel(6);
							break;
						case 119:
							setLabelBorder();
							jLabel8.setForeground(Color.blue);
							jLabel8.setBorder(BorderFactory.createLineBorder(Color.blue));
							//jLabel8.setText("1 ");
							changeChannel(7);
							break;
						case 120:
							setLabelBorder();
							jLabel9.setForeground(Color.blue);
							jLabel9.setBorder(BorderFactory.createLineBorder(Color.blue));
							//jLabel9.setText("1 ");
							changeChannel(8);
							break;
						case 121:
							setLabelBorder();
							jLabel10.setForeground(Color.blue);
							jLabel10.setBorder(BorderFactory.createLineBorder(Color.blue));
							//jLabel10.setText("1 ");
							changeChannel(9);
							break;
					}
				}
				else if(event.isAltDown() && (keyCode <= 123 && keyCode >= 118))
				{//Alt + F7~F12 ,equal fellowing chanel is open or close
				 //jump Alt + F4 this is close application Key
				 //choose  F7 - F12 show channel 11 - 16
					switch(keyCode)
					{
						case 118:
							setLabelBorder();
							jLabel11.setForeground(Color.blue);
							jLabel11.setBorder(BorderFactory.createLineBorder(Color.blue));
							//jLabel11.setText("1 ");
							changeChannel(10);
							System.out.println("F10");
							break;
						case 119:
							setLabelBorder();
							jLabel12.setForeground(Color.blue);
							jLabel12.setBorder(BorderFactory.createLineBorder(Color.blue));
							//jLabel12.setText("1 ");
							changeChannel(11);
							System.out.println("F11");
							break;
						case 120:
							setLabelBorder();
							jLabel13.setForeground(Color.blue);
							jLabel13.setBorder(BorderFactory.createLineBorder(Color.blue));
							//jLabel13.setText("23");
							changeChannel(12);
							break;
						case 121:
							setLabelBorder();
							jLabel14.setForeground(Color.blue);
							jLabel14.setBorder(BorderFactory.createLineBorder(Color.blue));
							//jLabel14.setText("23");
							changeChannel(13);
							break;
						case 122:
							setLabelBorder();
							jLabel15.setForeground(Color.blue);
							jLabel15.setBorder(BorderFactory.createLineBorder(Color.blue));
							//jLabel15.setText("23");
							changeChannel(14);
							break;
						case 123:
							setLabelBorder();
							jLabel16.setForeground(Color.blue);
							jLabel16.setBorder(BorderFactory.createLineBorder(Color.blue));
							//jLabel16.setText("23");
							changeChannel(15);
							break;
					}
				}
			}
			//Space Key down
			else if(keyCode == 32)
			{//equal Space Key down
				channel.allNotesOff();
				System.out.println("allNoteOff");
			}
			//F1-F12 Key down
			else if(keyCode <= 123 && keyCode >= 112)
			{//Key F1 ~F12 down to choose a current channel play
				switch(keyCode)
				{
					case 112://F1
						//jLabel1.setBorder(BorderFactory.createLineBorder(Color.black));
						break;
					case 113://F2
						//jLabel1.setBorder(null);
						setLabelBorder();
						jLabel2.setBorder(BorderFactory.createLineBorder(Color.black));
						break;
					case 114://F1
						jLabel1.setBorder(BorderFactory.createLineBorder(Color.black));
						break;
					case 115://F1
						jLabel1.setBorder(BorderFactory.createLineBorder(Color.black));
						break;
					case 116://F1
						jLabel1.setBorder(BorderFactory.createLineBorder(Color.black));
						break;
					case 117://F1
						jLabel1.setBorder(BorderFactory.createLineBorder(Color.black));
						break;
					case 118://F1
						jLabel1.setBorder(BorderFactory.createLineBorder(Color.black));
						break;
					case 119://F1
						jLabel1.setBorder(BorderFactory.createLineBorder(Color.black));
						break;
					case 120://F1
						jLabel1.setBorder(BorderFactory.createLineBorder(Color.black));
						break;
					case 121://F1
						jLabel1.setBorder(BorderFactory.createLineBorder(Color.black));
						break;
					case 122://F1
						jLabel1.setBorder(BorderFactory.createLineBorder(Color.black));
						break;
					case 123://F1
						jLabel1.setBorder(BorderFactory.createLineBorder(Color.black));
						break;


				}
			}
			//escape Key press
			else if(keyCode == 27)
			{
				//System.exit(0);
				//mainFrame.setVisible(false);
				mainFrame.toBack();
				//mainFrame.hide();
			}

			//|||||||||||||WHITE KEY A~Z Down|||||||||||||||
			else
			{///////////// 2,3,4|5--6|7,8,9
				 //        W,E,R|T--Y|U,I.O
				 //        S,D,F|G--H|J,K,L
				 //        X,C,V|B--N|M,<,>
	 			 //equal press white Key
				switch(keyCode)
				{

					//===================layer 1
					case 50://2
						noteNumber = 0;
						keyToSound(noteNumber);
						break;
					case 51://3
						noteNumber = 2;
						keyToSound(noteNumber);
						break;
					case 52://4
						noteNumber = 4;
						keyToSound(noteNumber);
						break;
					case 53://5 same
						noteNumber = 5;
						keyToSound(noteNumber);
						break;
					case 54://6 same
						noteNumber = 5;
						keyToSound(noteNumber);
						break;
					case 55://7
						noteNumber = 7;
						keyToSound(noteNumber);
						break;
					case 56://8
						noteNumber = 9;
						keyToSound(noteNumber);
						break;
					case 57://9
						noteNumber = 11;
						keyToSound(noteNumber);
						break;
					//===================layer 2
					case 87://W
						noteNumber = 12;
						keyToSound(noteNumber);
						break;
					case 69://E
						noteNumber = 14;
						keyToSound(noteNumber);
						break;
					case 82://R
						noteNumber = 16;
						keyToSound(noteNumber);
						break;
					case 84://T same
						noteNumber = 17;
						keyToSound(noteNumber);
						break;
					case 89://Y same
						noteNumber = 17;
						keyToSound(noteNumber);
						break;
					case 85://U
						noteNumber = 19;
						keyToSound(noteNumber);
						break;
					case 73://I
						noteNumber = 21;
						keyToSound(noteNumber);
						break;
					case 79://O
						noteNumber = 23;
						keyToSound(noteNumber);
						break;
					//===================layer 3
					case 83://S
						noteNumber = 24;
						keyToSound(noteNumber);
						break;
					case 68://D
						noteNumber = 26;
						keyToSound(noteNumber);
						break;
					case 70://F
						noteNumber = 28;
						keyToSound(noteNumber);
						break;
					case 71://G same
						noteNumber = 29;
						keyToSound(noteNumber);
						break;
					case 72://H same
						noteNumber = 29;
						keyToSound(noteNumber);
						break;
					case 74://J
						noteNumber = 31;
						keyToSound(noteNumber);
						break;
					case 75://K
						noteNumber = 33;
						keyToSound(noteNumber);
						break;
					case 76://L
						noteNumber = 35;
						keyToSound(noteNumber);
						break;
					//===================layer 4
					case 88://X
						noteNumber = 36;
						keyToSound(noteNumber);
						break;
					case 67://C
						noteNumber = 38;
						keyToSound(noteNumber);
						break;
					case 86://V
						noteNumber = 40;
						keyToSound(noteNumber);
						break;
					case 66://B same
						noteNumber = 41;
						keyToSound(noteNumber);
						break;
					case 78://N same
						noteNumber = 41;
						keyToSound(noteNumber);
						break;
					case 77://M
						noteNumber = 43;
						keyToSound(noteNumber);
						break;
					case 44://<
						noteNumber = 45;
						keyToSound(noteNumber);
						break;
					case 46://>
						noteNumber = 47;
						keyToSound(noteNumber);
						break;
				}
			}


      	}

      	public void readKeyRelease(KeyEvent event,int key_code)
      	{
      		int keyCode=key_code;

      		//Shift Down
			if(event.isShiftDown())
			{
				if(event.isShiftDown() && (keyCode <= 123 && keyCode >= 112))
				{//Shift + F1~F12 ,equal choose the Patch

				}
				else if(event.isShiftDown())
				{//Shift + 3,4--7,8,9
	 			//        E,R--U,I.O
	 			//        D,F--J,K,L
	 			//        C,V--M,<,>
	 			//equal press black Key
	 			//|||||||||||||BLACK KEY A~Z Down|||||||||||||||
	 			switch(keyCode)
	 			{	//===================layer 1
	 				case 51://3
	 					noteNumber = 1;
						keyToSound(noteNumber);
	 					break;
	 				case 52://4
	 					noteNumber = 3;
						keyToSound(noteNumber);
	 					break;
	 				case 55://7
	 					noteNumber = 6;
						keyToSound(noteNumber);
	 					break;
	 				case 56://8
	 					noteNumber = 8;
						keyToSound(noteNumber);
	 					break;
	 				case 57://9
	 					noteNumber = 10;
						keyToSound(noteNumber);
	 					break;
	 				//===================layer 2
	 				case 69://E
	 					noteNumber = 13;
						keyToSound(noteNumber);
	 					break;
	 				case 82://R
	 					noteNumber = 15;
						keyToSound(noteNumber);
	 					break;
	 				case 85://U
	 					noteNumber = 18;
						keyToSound(noteNumber);
	 					break;
	 				case 73://I
	 					noteNumber = 20;
						keyToSound(noteNumber);
	 					break;
	 				case 79://O
	 					noteNumber = 22;
						keyToSound(noteNumber);
	 					break;
	 				//===================layer 3
	 				case 68://D
	 					noteNumber = 25;
						keyToSound(noteNumber);
	 					break;
	 				case 70://F
	 					noteNumber = 27;
						keyToSound(noteNumber);
	 					break;
	 				case 74://J
	 					noteNumber = 30;
						keyToSound(noteNumber);
	 					break;
	 				case 75://K
	 					noteNumber = 32;
						keyToSound(noteNumber);
	 					break;
	 				case 76://L
	 					noteNumber = 34;
						keyToSound(noteNumber);
	 					break;
	 				//===================layer 4
	 				case 67://C
	 					noteNumber = 37;
						keyToSound(noteNumber);
	 					break;
	 				case 86://V
	 					noteNumber = 39;
						keyToSound(noteNumber);
	 					break;
	 				case 77://M
	 					noteNumber = 42;
						keyToSound(noteNumber);
	 					break;
	 				case 44://<
	 					noteNumber = 44;
						keyToSound(noteNumber);
	 					break;
	 				case 46://>
	 					noteNumber = 46;
						keyToSound(noteNumber);
	 					break;
	 				}
				}
			}
			//Control or Alt Down
			else if(event.isControlDown() || event.isAltDown())
			{	//because all chanel is 16, and only F12 in PCKeyboard
				if(event.isControlDown() && (keyCode <= 123 && keyCode >= 112))
				{//Ctrl + F1~F12 ,equal fellowing chanel is open or close

				}
				else if(event.isAltDown() && (keyCode <= 115 && keyCode >= 112))
				{//Alt + F1~F4 ,equal fellowing chanel is open or close

				}
			}
			//|||||||||||||WHITE KEY A~Z Down|||||||||||||||
			else
			{///////////// 2,3,4|5--6|7,8,9
				 //        W,E,R|T--Y|U,I.O
				 //        S,D,F|G--H|J,K,L
				 //        X,C,V|B--N|M,<,>
	 			 //equal press white Key
				switch(keyCode)
				{

					//===================layer 1
					case 50://2
						noteNumber = 0;
						keyToSound(noteNumber);
						break;
					case 51://3
						noteNumber = 2;
						keyToSound(noteNumber);
						break;
					case 52://4
						noteNumber = 4;
						keyToSound(noteNumber);
						break;
					case 53://5 same
						noteNumber = 5;
						keyToSound(noteNumber);
						break;
					case 54://6 same
						noteNumber = 5;
						keyToSound(noteNumber);
						break;
					case 55://7
						noteNumber = 7;
						keyToSound(noteNumber);
						break;
					case 56://8
						noteNumber = 9;
						keyToSound(noteNumber);
						break;
					case 57://9
						noteNumber = 11;
						keyToSound(noteNumber);
						break;
					//===================layer 2
					case 87://W
						noteNumber = 12;
						keyToSound(noteNumber);
						break;
					case 69://E
						noteNumber = 14;
						keyToSound(noteNumber);
						break;
					case 82://R
						noteNumber = 16;
						keyToSound(noteNumber);
						break;
					case 84://T same
						noteNumber = 17;
						keyToSound(noteNumber);
						break;
					case 89://Y same
						noteNumber = 17;
						keyToSound(noteNumber);
						break;
					case 85://U
						noteNumber = 19;
						keyToSound(noteNumber);
						break;
					case 73://I
						noteNumber = 21;
						keyToSound(noteNumber);
						break;
					case 79://O
						noteNumber = 23;
						keyToSound(noteNumber);
						break;
					//===================layer 3
					case 83://S
						noteNumber = 24;
						keyToSound(noteNumber);
						break;
					case 68://D
						noteNumber = 26;
						keyToSound(noteNumber);
						break;
					case 70://F
						noteNumber = 28;
						keyToSound(noteNumber);
						break;
					case 71://G same
						noteNumber = 29;
						keyToSound(noteNumber);
						break;
					case 72://H same
						noteNumber = 29;
						keyToSound(noteNumber);
						break;
					case 74://J
						noteNumber = 31;
						keyToSound(noteNumber);
						break;
					case 75://K
						noteNumber = 33;
						keyToSound(noteNumber);
						break;
					case 76://L
						noteNumber = 35;
						keyToSound(noteNumber);
						break;
					//===================layer 4
					case 88://X
						noteNumber = 36;
						keyToSound(noteNumber);
						break;
					case 67://C
						noteNumber = 38;
						keyToSound(noteNumber);
						break;
					case 86://V
						noteNumber = 40;
						keyToSound(noteNumber);
						break;
					case 66://B same
						noteNumber = 41;
						keyToSound(noteNumber);
						break;
					case 78://N same
						noteNumber = 41;
						keyToSound(noteNumber);
						break;
					case 77://M
						noteNumber = 43;
						keyToSound(noteNumber);
						break;
					case 44://<
						noteNumber = 45;
						keyToSound(noteNumber);
						break;
					case 46://>
						noteNumber = 47;
						keyToSound(noteNumber);
						break;
				}
			}
      	}

      	public void keyToDraw(int keyOrder,int keyPosition)
      	{
      		int KeyOrder=keyOrder;
      		int longKeyMaskPosition=keyPosition;
      		if(keydown)
      		{
      			MKPanel.drawKeyPressed(KeyOrder);

      		}
      		else
      		{
      			MKPanel.drawKeyReleased(KeyOrder);
      		}

      	}
      	public void keyToSound(int keyCode)
     	{
      		//Frame1 frame1;
      		int keyOrder=keyCode;
      		switch(keyboardPosition)
      		{
      			case 1:
      				noteNumber=keyOrder+0*12;
        			if(keydown)
      				{
      					if(isPianoStyle)
      					{
      						if( !pianoKeydown )
      						{//toSound
        						channel.noteOn(noteNumber, velocity);
        						pianoKeydown=true;
        					}

      					}
      					else
      					{//toSound
        					channel.noteOn(noteNumber, velocity);
        				}
        				//toDrawKey
        				keyToDraw(keyOrder,keyboardPosition);
        				System.out.println("noteOn    "+noteNumber+"   keyOrder  "+keyCode);
        			}
        			else
        			{
        				channel.noteOff(noteNumber, velocity/2);
        				//toDrawKey
        				keyToDraw(keyOrder,keyboardPosition);
        				System.out.println("noteOff   "+noteNumber);
        				System.out.println(keyboardPosition);
        			}
      				break;
      			case 2:
      				noteNumber=keyOrder+1*12;
        			if(keydown)
      				{
        				if(isPianoStyle)
      					{
      						if( !pianoKeydown )
      						{//toSound
        						channel.noteOn(noteNumber, velocity);
        						pianoKeydown=true;
        					}

      					}
      					else
      					{//toSound
        					channel.noteOn(noteNumber, velocity);
        				}
        				//toDrawKey
        				keyToDraw(keyOrder,keyboardPosition);
        				System.out.println("noteOn    "+noteNumber+"   keyOrder  "+keyCode);
        			}
        			else
        			{
        				channel.noteOff(noteNumber, velocity/2);
        				//toDrawKey
        				keyToDraw(keyOrder,keyboardPosition);
        				System.out.println("noteOff   "+noteNumber);
        				System.out.println(keyboardPosition);
        			}
      				break;
      			case 3:
      				noteNumber=keyOrder+2*12;
        			if(keydown)
      				{
        				if(isPianoStyle)
      					{
      						if( !pianoKeydown )
      						{//toSound
        						channel.noteOn(noteNumber, velocity);
        						pianoKeydown=true;
        					}

      					}
      					else
      					{//toSound
        					channel.noteOn(noteNumber, velocity);
        				}
        				//toDrawKey
        				keyToDraw(keyOrder,keyboardPosition);
        				System.out.println("noteOn    "+noteNumber+"   keyOrder  "+keyCode);
        			}
        			else
        			{
        				channel.noteOff(noteNumber, velocity/2);
        				//toDrawKey
        				keyToDraw(keyOrder,keyboardPosition);
        				System.out.println("noteOff   "+noteNumber);
        				System.out.println(keyboardPosition);
        			}
      				break;
      			case 4:
      				noteNumber=keyOrder+3*12;
      				if(keydown)
      				{
      					if(isPianoStyle)
      					{
      						if( !pianoKeydown )
      						{//toSound
        						channel.noteOn(noteNumber, velocity);
        						pianoKeydown=true;
        					}

      					}
      					else
      					{//toSound
        					channel.noteOn(noteNumber, velocity);
        				}
        				//toDrawKey
        				keyToDraw(keyOrder,keyboardPosition);
        				System.out.println("noteOn    "+noteNumber+"   keyOrder  "+keyCode);
        			}
        			else
        			{
        				channel.noteOff(noteNumber,velocity/2);
        				//toDrawKey
        				keyToDraw(keyOrder,keyboardPosition);
        				System.out.println("noteOff   "+noteNumber);
        				System.out.println(keyboardPosition);
        			}
      				break;
      			case 5:
      				noteNumber=keyOrder+4*12;
        			if(keydown)
      				{
        				if(isPianoStyle)
      					{
      						if( !pianoKeydown )
      						{//toSound
        						channel.noteOn(noteNumber, velocity);
        						pianoKeydown=true;
        					}

      					}
      					else
      					{//toSound
        					channel.noteOn(noteNumber, velocity);
        				}
        				//toDrawKey
        				keyToDraw(keyOrder,keyboardPosition);
        				System.out.println("noteOn    "+noteNumber+"   keyOrder  "+keyCode);
        			}
        			else
        			{
        				channel.noteOff(noteNumber, velocity/2);
        				//toDrawKey
        				keyToDraw(keyOrder,keyboardPosition);
        				System.out.println("noteOff   "+noteNumber);
        				System.out.println(keyboardPosition);
        			}
      				break;
      			case 6:
      				noteNumber=keyOrder+5*12;
        			if(keydown)
      				{
        				if(isPianoStyle)
      					{
      						if( !pianoKeydown )
      						{//toSound
        						channel.noteOn(noteNumber, velocity);
        						pianoKeydown=true;
        					}

      					}
      					else
      					{//toSound
        					channel.noteOn(noteNumber, velocity);
        				}
        				//toDrawKey
        				keyToDraw(keyOrder,keyboardPosition);
        				System.out.println("noteOn    "+noteNumber+"   keyOrder  "+keyCode);
        			}
        			else
        			{
        				channel.noteOff(noteNumber, velocity/2);
        				//toDrawKey
        				keyToDraw(keyOrder,keyboardPosition);
        				System.out.println("noteOff   "+noteNumber);
        				System.out.println(keyboardPosition);
        			}
      				break;
      			case 7:
      				noteNumber=keyOrder+6*12;
        			if(keydown)
      				{
        				if(isPianoStyle)
      					{
      						if( !pianoKeydown )
      						{//toSound
        						channel.noteOn(noteNumber, velocity);
        						pianoKeydown=true;
        					}

      					}
      					else
      					{//toSound
        					channel.noteOn(noteNumber, velocity);
        				}
        				//toDrawKey
        				keyToDraw(keyOrder,keyboardPosition);
        				System.out.println("noteOn    "+noteNumber+"   keyOrder  "+keyCode);
        			}
        			else
        			{
        				channel.noteOff(noteNumber, velocity/2);
        				//toDrawKey
        				keyToDraw(keyOrder,keyboardPosition);
        				System.out.println("noteOff   "+noteNumber);
        				System.out.println(keyboardPosition);
        			}
      				break;
      			case 8:
      				noteNumber=keyOrder+7*12;
        			if(keydown)
      				{
        				if(isPianoStyle)
      					{
      						if( !pianoKeydown )
      						{//toSound
        						channel.noteOn(noteNumber, velocity);
        						pianoKeydown=true;
        					}

      					}
      					else
      					{//toSound
        					channel.noteOn(noteNumber, velocity);
        				}
        				//toDrawKey
        				keyToDraw(keyOrder,keyboardPosition);
        				System.out.println("noteOn    "+noteNumber+"   keyOrder  "+keyCode);
        			}
        			else
        			{
        				channel.noteOff(noteNumber, velocity/2);
        				//toDrawKey
        				keyToDraw(keyOrder,keyboardPosition);
        				System.out.println("noteOff   "+noteNumber);
        				System.out.println(keyboardPosition);
        			}
      				break;
      		}
      	}

		public void keyPressed(KeyEvent event)
		{
			int keyCode=event.getKeyCode();
			keydown = true;// Set indicator
			//pianoKeyDown = true;
			readKeyPress(event,keyCode);
        	System.out.println(keyCode);
		}

		public void keyReleased(KeyEvent event)
		{
			int keyCode=event.getKeyCode();
			keydown = false;// Reset the indicator
			pianoKeydown = false;
			readKeyRelease(event,keyCode);
		}
		public void keyTyped(KeyEvent event)
		{

		}
		//setLableBorder to null and black color foreground
		public void setLabelBorder()
		{
			jLabel1.setBorder(null);jLabel1.setForeground(Color.black);
			jLabel2.setBorder(null);jLabel2.setForeground(Color.black);
			jLabel3.setBorder(null);jLabel3.setForeground(Color.black);
			jLabel4.setBorder(null);jLabel4.setForeground(Color.black);
			jLabel5.setBorder(null);jLabel5.setForeground(Color.black);
			jLabel6.setBorder(null);jLabel6.setForeground(Color.black);
			jLabel7.setBorder(null);jLabel7.setForeground(Color.black);
			jLabel8.setBorder(null);jLabel8.setForeground(Color.black);
			jLabel9.setBorder(null);jLabel9.setForeground(Color.black);
			jLabel10.setBorder(null);jLabel10.setForeground(Color.black);
			jLabel11.setBorder(null);jLabel11.setForeground(Color.black);
			jLabel12.setBorder(null);jLabel12.setForeground(Color.black);
			jLabel13.setBorder(null);jLabel13.setForeground(Color.black);
			jLabel14.setBorder(null);jLabel14.setForeground(Color.black);
			jLabel15.setBorder(null);jLabel15.setForeground(Color.black);
			jLabel16.setBorder(null);jLabel16.setForeground(Color.black);
		}
		//ctrl or alt + F1 - F12 to choose a instrument
		//the instrument is already setted ok
		//so channel 10 is in System's control
		public void changeChannel(int i)
		{
			//this symble i is MidiSystem's real Channel since 0 to 15
			channel = channels[i];
			currentChannelNumber = i;
			currentBankNumber = 1;
			currentProgramNumber = 0;
		}
		//use up and down Key to plus or unplus instrument's program
		public void plusProgram(int i)
		{
			//when i=1 is program plus  -1
			//when i=2 is program plus   1
			int ii = i;
			//int p;
			if(currentProgramNumber > currentChannelNumber * 8 +7
				|| currentProgramNumber < currentChannelNumber * 8 -7)
			{
				currentProgramNumber = currentChannelNumber * 8;
				String name = instruments[currentProgramNumber].getName();
				setCurrentInstrumentNameText(name);
			}
			if(ii == 1)
			{
				currentProgramNumber += 1;
				setPatchBankProgramText(currentBankNumber,currentProgramNumber);
				String name = instruments[currentProgramNumber].getName();
				setCurrentInstrumentNameText(name);
				//setting the Patch
				channel.programChange(currentBankNumber,currentProgramNumber);
			}
			else if(ii == 2)
			{
				currentProgramNumber -= 1;
				setPatchBankProgramText(currentBankNumber,currentProgramNumber);
				String name = instruments[currentProgramNumber].getName();
				setCurrentInstrumentNameText(name);
				channel.programChange(currentBankNumber,currentProgramNumber);
			}
			else
			{}
			//channel.programChange(currentBank,p);
		}
		//use left and right Key to plus or unplus instrument's bank
		public void plusBank(int i)
		{
			//when i=1 is bank plus  -1
			//when i=2 is bank plus   1
			int ii = i;
			//int p;
			if(currentBankNumber <= 127 && currentBankNumber >= 0)
			{
				/*if((currentBankNumber <= 127 && currentBankNumber >= 0) && ii == 2)
				{
					currentBankNumber += 1;
					System.out.println("right");

				}
				else if((currentBankNumber <= 127 && currentBankNumber >= 0) && ii == 1)
				{
					currentBankNumber -= 1;
					System.out.println("left");

				}*/
				if(ii == 2)
				{
					currentBankNumber-=1;
				}
				else
				{
					currentBankNumber+=1;
				}

				setPatchBankProgramText(currentBankNumber,currentProgramNumber);
				String name =
					instruments[currentBankNumber*127 + currentProgramNumber].getName();
				setCurrentInstrumentNameText(name);
				//setting the Patch
				channel.programChange(currentBankNumber,currentProgramNumber);
			}
		}

	}
	//set Patch's bank and program number in TextField
	public void setPatchBankProgramText(int b, int p)
	{
		String bank = Integer.toString(b);
		String program = Integer.toString(p);
		jTextField1.setText(bank);
		jTextField2.setText(program);
	}
	//set use up and down Key choose's istrument's name in label 17
	public void setCurrentInstrumentNameText(String n)
	{
		jLabel17.setText(n);
	}
	//change label text to instrument's name
		public void changeLabelText(int i,String name)
		{
			int labelNum = i;
			String s = name;
			switch(labelNum)
			{
				case 1:
					jLabel1.setText(s);
					break;
				case 2:
					jLabel2.setText(s);
					break;
				case 3:
					jLabel3.setText(s);
					break;
				case 4:
					jLabel4.setText(s);
					break;
				case 5:
					jLabel5.setText(s);
					break;
				case 6:
					jLabel6.setText(s);
					break;
				case 7:
					jLabel7.setText(s);
					break;
				case 8:
					jLabel8.setText(s);
					break;
				case 9:
					jLabel9.setText(s);
					break;
				case 10:
					jLabel10.setText(s);
					break;
				case 11:
					jLabel11.setText(s);
					break;
				case 12:
					jLabel12.setText(s);
					break;
				case 13:
					jLabel13.setText(s);
					break;
				case 14:
					jLabel14.setText(s);
					break;
				case 15:
					jLabel15.setText(s);
					break;
				case 16:
					jLabel16.setText(s);
					break;
			}
		}
	//setting botton
	void jButton1_actionPerformed(ActionEvent e)
	{

  	}
  	//bank
  	void jTextField1_actionPerformed(ActionEvent e) {

  	}
	//program
  	void jTextField2_actionPerformed(ActionEvent e) {

  	}
  	//pc or piano
  	void jCheckBox1_actionPerformed(ActionEvent e) {
		if(isPianoStyle == false)
		{
			isPianoStyle = true;
		}
		else
		{
			isPianoStyle = false;
		}
  	}
    //===========================================
	//==========inner class mini Keyboard===========
	//===========================================
	class MiniKeyboard
	{
		public MiniKeyboard()
		{

		}
	}

}

class Frame1_jButton1_actionAdapter implements java.awt.event.ActionListener
	{
  		KeyboardPlayer adaptee;

  		Frame1_jButton1_actionAdapter(KeyboardPlayer adaptee)
  		{
    		this.adaptee = adaptee;
  		}
  		public void actionPerformed(ActionEvent e)
  		{
    		adaptee.jButton1_actionPerformed(e);
  		}
	}
class Frame1_jTextField1_actionAdapter implements java.awt.event.ActionListener {
  KeyboardPlayer adaptee;

  Frame1_jTextField1_actionAdapter(KeyboardPlayer adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jTextField1_actionPerformed(e);
  }
}
class Frame1_jTextField2_actionAdapter implements java.awt.event.ActionListener {
  KeyboardPlayer adaptee;

  Frame1_jTextField2_actionAdapter(KeyboardPlayer adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jTextField2_actionPerformed(e);
  }
}
class Frame1_jCheckBox1_actionAdapter implements java.awt.event.ActionListener {
  KeyboardPlayer adaptee;

  Frame1_jCheckBox1_actionAdapter(KeyboardPlayer adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jCheckBox1_actionPerformed(e);
  }
}









