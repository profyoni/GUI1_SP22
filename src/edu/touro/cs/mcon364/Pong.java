package edu.touro.cs.mcon364;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
 class FooBar
        {

          private int f;
        }
public class Pong extends JFrame {
    public static void main(String[] args) {
        new Pong();
    }
    private JLabel statusLabel = new JLabel("init");
    //private int number;
    private JButton incButton;
    private JTextField numberTextField;

    public Pong() {
        super("Draw 1.0"); // must be first line

        this.setSize(850, 610);
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });

        JPanel canvasPanel = new GamePanel();
        this.add(canvasPanel, BorderLayout.CENTER);
        this.add(statusLabel, BorderLayout.SOUTH);

        this.setVisible(true);
    }


    class GamePanel extends JPanel
    {
        int minX=0, maxX=700, minY=0, maxY=500;
        int dx=1,dy=1;
        int paddleDy = 0;
        int ballSize = 25;
        Point ball, paddle;
        GamePanel() {
            setBackground(Color.BLACK);
            ball = new Point( maxX /2, maxY/2);
            paddle = new Point(10, maxY/2);

            Timer timer = new Timer(5,
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (ball.y + ballSize >= maxY || ball.y <= minY)
                                dy = -dy;
                            if (ball.x  + ballSize >= maxX || ball.x <= minX)
                                dx = -dx;
                            ball.translate(dx, dy);

                            repaint();
                        }
                    });

            timer.start();

            this.addMouseWheelListener(new MouseWheelListener() {
                @Override
                public void mouseWheelMoved(MouseWheelEvent e) {
                    paddleDy += e.getWheelRotation()* 10;
                }
            });
        }

        @Override
        public void paint(Graphics g)
        {
            super.paint(g);
            g.setColor(Color.WHITE);
            g.drawRect(minX, minY, maxX-minX, maxY-minY);
            g.fillOval(ball.x, ball.y, ballSize, ballSize);


            g.fillRect(paddle.x, paddleDy, 25,150);
        }
    }
}

