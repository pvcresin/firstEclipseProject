package firstEclipseProject;

import javax.swing.JFrame;

public class myJFrame extends JFrame {
    private static final long serialVersionUID = 1L;
 
    public static void main(String[] args) { 
        JFrame frame = new myJFrame();
        
        frame.setTitle("my JFrame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setBounds(10, 10, 300, 250);
        frame.setVisible(true);
    }
}