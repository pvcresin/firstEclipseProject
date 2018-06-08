package firstEclipseProject;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class mouse extends Applet {
	private static final long serialVersionUID = 1L;
	
	private Point position;
  private Dimension size;
  
  public void init() {
    setBackground(Color.WHITE);
    addMouseListener(new Click());
    position = new Point(getWidth()/2, getHeight()/2);
    size = new Dimension(10,10);
  }
  public void paint(Graphics g) {
    g.fillOval(position.x-size.width/2,
               position.y-size.height/2,
               size.width,size.height);
  }
  
  class Click implements MouseListener{
    public void mouseClicked(MouseEvent e) {
      switch(e.getButton()) {
      case MouseEvent.BUTTON1:  //左クリック
        setForeground(Color.BLACK);
        break;
      case MouseEvent.BUTTON2:  //中クリック
        setForeground(Color.BLUE);
        break;
      case MouseEvent.BUTTON3:  //右クリック
        setForeground(Color.RED);
        break;
      }
      position = e.getPoint();  //マウスポインタの位置を取得
      repaint();
    }
    public void mouseEntered(MouseEvent e) {
      setBackground(new Color(192,224,255));
      repaint();
    }
    public void mouseExited(MouseEvent e) {
      setBackground(Color.WHITE);
      repaint();
    }
    public void mousePressed(MouseEvent e) {
      size.setSize(30,30);
      repaint();
    }
    public void mouseReleased(MouseEvent e) {
      size.setSize(10,10);
      repaint();
    }
  }
}