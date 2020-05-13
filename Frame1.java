//package wholeframe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class Frame1 extends JFrame 
{
  JPanel contentPane;
  BorderLayout borderLayout1 = new BorderLayout();
  JPanel jPanel1 = new JPanel();
  BorderLayout borderLayout2 = new BorderLayout();


  JSplitPane jSplitPane1 = new JSplitPane();
  //KeyboardPlayerPanel
  //JPanel jPanel2 = new JPanel();
  KeyboardPlayer KPPanel = new KeyboardPlayer();
  
  //get icon image
  Toolkit kit = Toolkit.getDefaultToolkit();
  Image img = kit.getImage("IMAGE/JMS/KPIcon.gif");
  
  
  JPanel jPanel3 = new JPanel();
  JSplitPane jSplitPane2 = new JSplitPane();
  BorderLayout borderLayout3 = new BorderLayout();
  JMenuBar jMenuBar1 = new JMenuBar();
  JMenu jMenu1 = new JMenu();
  JMenuItem jMenuItem1 = new JMenuItem();
  JMenuItem jMenuItem2 = new JMenuItem();
  JMenu jMenu2 = new JMenu();
  JPanel jPanel4 = new JPanel();
  JPanel jPanel5 = new JPanel();
  BorderLayout borderLayout4 = new BorderLayout();
  BorderLayout borderLayout5 = new BorderLayout();
  JSplitPane jSplitPane3 = new JSplitPane();
  JSplitPane jSplitPane4 = new JSplitPane();
  JPanel jPanel6 = new JPanel();
  JPanel jPanel7 = new JPanel();
  JPanel jPanel8 = new JPanel();
  
  //MiniKeyboardPanel MKPanel = new MiniKeyboardPanel();
  JPanel CPanel = new ChanelPanel();
  JPanel MKPanel = new MiniKeyboardPanel();
  JPanel LMPPanel = new LongMiniPianoPanel();
  PCKeyboardPanel PCKPanel = new PCKeyboardPanel();

  //Construct the frame
  public Frame1() {
    enableEvents(AWTEvent.WINDOW_EVENT_MASK);
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  //Component initialization
  private void jbInit() throws Exception  {
    contentPane = (JPanel) this.getContentPane();
    contentPane.setLayout(borderLayout1);
    this.setSize(new Dimension(800, 580));
    this.setTitle("KeyboardPlayer");
    jPanel1.setLayout(borderLayout2);
    jSplitPane1.setEnabled(false);
    KPPanel.setDebugGraphicsOptions(0);
    jPanel3.setLayout(borderLayout3);
    jPanel3.setMaximumSize(new Dimension(32767, 32767));
    jPanel3.setVerifyInputWhenFocusTarget(true);

    jSplitPane2.setOrientation(JSplitPane.VERTICAL_SPLIT);
    jSplitPane2.setLastDividerLocation(450);
    jMenu1.setText("Option");
    jMenuItem1.setText("Setting");
    jMenuItem2.setText("Exit");
    jMenu2.setText("Moldle");
    jPanel4.setLayout(borderLayout4);
    jPanel5.setLayout(borderLayout5);
    jSplitPane3.setOrientation(JSplitPane.VERTICAL_SPLIT);
    jSplitPane4.setOrientation(JSplitPane.VERTICAL_SPLIT);
    contentPane.add(jPanel1,  BorderLayout.CENTER);
    jPanel1.add(jSplitPane1,  BorderLayout.CENTER);
    jSplitPane1.add(KPPanel, JSplitPane.LEFT);
    jSplitPane1.add(jPanel3, JSplitPane.RIGHT);
    jPanel3.add(jSplitPane2,  BorderLayout.CENTER);
    jSplitPane2.add(jPanel4, JSplitPane.TOP);
    jPanel4.add(jSplitPane3,  BorderLayout.CENTER);
    jSplitPane2.add(jPanel5, JSplitPane.BOTTOM);
    jMenuBar1.add(jMenu1);
    jMenuBar1.add(jMenu2);
    jMenu1.add(jMenuItem1);
    jMenu1.addSeparator();
    jMenu1.add(jMenuItem2);
    jPanel5.add(jSplitPane4,  BorderLayout.CENTER);
    jSplitPane3.add(CPanel, JSplitPane.TOP);
    jSplitPane3.add(LMPPanel, JSplitPane.BOTTOM);
    jSplitPane4.add(MKPanel, JSplitPane.TOP);
    jSplitPane4.add(PCKPanel, JSplitPane.BOTTOM);
    
    jSplitPane1.setDividerLocation(133);
    jSplitPane1.setEnabled(false);
    jSplitPane2.setDividerLocation(266);
    jSplitPane2.setEnabled(false);
    jSplitPane3.setDividerLocation(226);
    jSplitPane3.setEnabled(false);
    jSplitPane4.setDividerLocation(94);
    jSplitPane4.setEnabled(false);
    
    //setJMenuBar(jMenuBar1);
    setIconImage(img);
    setResizable(false);
    
    KPPanel.getMKPanel(MKPanel);
    KPPanel.getLMPPanel(LMPPanel);
    KPPanel.getPCKPanel(PCKPanel);
    KPPanel.getFrame(this);
  }
  //Overridden so we can exit when window is closed
  protected void processWindowEvent(WindowEvent e) {
    super.processWindowEvent(e);
    if (e.getID() == WindowEvent.WINDOW_CLOSING) {
    	//System.out.println("window is closing...");
    	//try{Thread.sleep(2000);}catch(Exception ee){}
      System.exit(0);
    }
  }
  
 
  //====================================================
  //=================inner class========================
  //====================================================
  
}
