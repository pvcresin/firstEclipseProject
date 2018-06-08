package firstEclipseProject;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Color;

public class myApplet extends Applet {

	private static final long serialVersionUID = 1L;
    
	public void init(){
	    setBackground(Color.BLUE);
	    setForeground(Color.WHITE);
	}
	
	public void paint(Graphics g){
	    g.fillOval(25,25,100,100);
	    
	    g.setColor(new Color(255,128,0));
	    g.fillRect(75,75,100,100);
	}
}