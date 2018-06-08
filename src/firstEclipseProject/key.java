package firstEclipseProject;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class key extends Applet {	
  private static final long serialVersionUID = 1L;
  
  StringBuffer strP = new StringBuffer(), 
		  strR = new StringBuffer(), 
		  strT = new StringBuffer();
  boolean P = false, R = false, T = false;
  
  public void init() {
    addKeyListener(new myKeyListener());
  }
  public void paint(Graphics g) {
    g.drawString(strP.toString(),10,20);
    g.drawString(strR.toString(),10,40);
    g.drawString(strT.toString(),10,60);
    if(P) {
      g.fillOval(0,10,10,10);
      P = false;
    }
    if(R) {
      g.fillOval(0,30,10,10);
      R = false;
    }
    if(T) {
      g.fillOval(0,50,10,10);
      T = false;
    }
  }
  
  class myKeyListener implements KeyListener{
	  
    public void keyPressed(KeyEvent e) {
      strP.append(e.getKeyChar());
      
      if(e.getKeyCode() == KeyEvent.VK_ENTER) {
        strP.delete(0,strP.length());
        strR.delete(0,strR.length());
        strT.delete(0,strT.length());
      }
      P = true;
      repaint();
    }
    public void keyReleased(KeyEvent e) {
      strR.append(e.getKeyChar());
      R = true;
      repaint();
    }
    public void keyTyped(KeyEvent e) {
      strT.append(e.getKeyChar());
      T = true;
      repaint();
    }
  }
}