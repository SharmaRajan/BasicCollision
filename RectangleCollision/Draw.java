import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Draw {
        public static void main(String[] args) {
            JFrame frame = new JFrame("Collision Detection");
            frame.setVisible(true);
            frame.setSize(800, 250);
//            frame.setSize(1920, 1080);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new Paint());
        }
}

    class Paint extends JPanel implements ActionListener {
        Rect rect1;
        Rect rect2;
        Timer time;
        boolean collision = false;

        public Paint() {
            rect1 = new Rect(0, 75);
            rect2 = new Rect(700, 75);
            time = new Timer(5, this);
            time.start();
        }

        public void actionPerformed(ActionEvent e) {
            rect1.move();
            rect2.move();
            checkCollision();
            repaint();
        }

        public void paint(Graphics g) {
            super.paint(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.BLACK);
            g2d.fillRect(rect1.x, rect1.y, 100, 50);
            g2d.setColor(Color.RED);
            g2d.fillRect(rect2.x, rect2.y, 100, 50);
            if (collision)
                g2d.drawString("COLLISION", 350, 50);
        }

        public void checkCollision() {
            Rectangle r1 = rect1.getBounds();
            Rectangle r2 = rect2.getBounds();

            if (r1.intersects(r2))
                collision = true;
            else
                collision = false;
        }
    }

