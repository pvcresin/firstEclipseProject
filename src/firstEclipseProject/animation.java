package firstEclipseProject;

import java.applet.Applet;
import java.awt.*;

// http://www.mm2d.net/main/legacy/applet-howto/howto-06.html
public class animation extends Applet implements Runnable {
	
	private static final long serialVersionUID = 1L;
	
	private Point      p1;     //�{�[��1�̍��W
    private Point      p2;     //�{�[��2�̍��W
    private Point      v1;     //�{�[��1�̑��x�x�N�g��
    private Point      v2;     //�{�[��2�̑��x�x�N�g��
    private Dimension  size;   //�{�[���̑傫��
    private Rectangle  region; //���W���ړ��ł���̈�
    private boolean    loop;   //���[�v�̌p������
    
    public void init() {
        setBackground(new Color(192,224,255));
        size = new Dimension(40,40);
        p1 = new Point((getWidth()  - size.width )/3,
                       (getHeight() - size.height)/2);
        p2 = new Point((getWidth()  - size.width )*2/3,
                       (getHeight() - size.height)/2);
        v1 = new Point(-5,5);
        v2 = new Point( 5,5);
        region = new Rectangle(0, 0, getWidth() - size.width,
                                     getHeight() - size.height);
        loop = true;
        //������n����Thread�N���X���쐬���X���b�h�N��
        new Thread(this).start();
    }
    
    public void paint(Graphics g) {
        g.setColor(Color.BLUE);   //�{�[��1��ŕ`��
        g.fillOval(p1.x, p1.y, size.width, size.height);
        g.setColor(Color.RED);    //�{�[��2��Ԃŕ`��
        g.fillOval(p2.x, p2.y, size.width, size.height);
    }
    
    //���Wp�𑬓x�x�N�g��v�ɏ]���Ĉړ�����
    //�̈�̊O�ɏo�Ă���ꍇ�͔��˂�����
    private void nextPosition(Point p, Point v, Rectangle region) {
        p.x += v.x;
        p.y += v.y;
        if(p.x < region.x) {
            p.x = region.x * 2 - p.x;
            v.x *= -1;
        }else if(p.x > region.x + region.width) {
            p.x = (region.x + region.width) * 2 - p.x;
            v.x *= -1;
        }
        if(p.y < region.y) {
            p.y = region.y * 2 - p.y;
            v.y *= -1;
        }else if(p.y > region.y + region.height) {
            p.y = (region.y + region.height) * 2 - p.y;
            v.y *= -1;
        }
    }
    public void destroy() {
        loop = false;   //���[�v�̏I��
    }
    public void run() {
        while(loop) {
            nextPosition(p1,v1,region);
            nextPosition(p2,v2,region);
            repaint();
            try {
                Thread.sleep(33);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}