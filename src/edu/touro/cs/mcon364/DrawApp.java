package edu.touro.cs.mcon364;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class DrawApp  extends JFrame {
    public static void main(String[] args) {
        new DrawApp();
    }
    private JLabel statusLabel = new JLabel("init");
    //private int number;
    private JButton incButton;
    private JTextField numberTextField;

    public DrawApp() {
        super("Draw 1.0"); // must be first line

        this.setSize(900, 900);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel canvasPanel = new DrawPanel();
        this.add(canvasPanel, BorderLayout.CENTER);
        this.add(statusLabel, BorderLayout.SOUTH);

        this.setVisible(true);
    }


    class DrawPanel extends JPanel
    {
        private List<java.awt.Point> pointList = new LinkedList<>();
        int originalWidth, originalHeight;
        DrawPanel() {
            this.addMouseMotionListener(new MouseMotionAdapter()
            {
                @Override
                public void mouseDragged(MouseEvent e) {
                    pointList.add(e.getPoint()); // persistence
                    Graphics g = DrawPanel.this.getGraphics();
                    g.fillOval(e.getX(), e.getY(), 5, 5);
                }
            });
            setBackground(Color.MAGENTA);


        }

        Random rand = new Random();
        @Override
        public void paint(Graphics g)
        {
            super.paint(g);

            if (originalWidth == 0 && originalHeight == 0) // set width/height first time
            {
                originalWidth = this.getWidth();
                originalHeight = this.getHeight();
            }

            //statusLabel.setText(c.toString());

            double scaleWidth = (double) this.getWidth() / originalWidth;
            double scaleHeight = (double) this.getHeight() / originalHeight;

            Graphics2D g2 = (Graphics2D)g;
            g2.scale(scaleWidth,scaleHeight);
            for(Point p : pointList)
            {
                Color c = new Color(
                        rand.nextInt(256)/*preferred*/,
                        (int)(Math.random() * 256),
                        (int)(Math.random() * 256));
                g.setColor( c);
                g.fillOval((int)p.getX(),
                        (int)p.getY(),
                        5 ,
                        5 );
            }

//            Graphics2D g2 = (Graphics2D)g;
//            g2.setFont(new Font("Sans Serif",Font.BOLD,50));
//            g2.translate(500,500);
//            g2.scale(.2,.2);
//            for (double d=0.0; d < 2 * Math.PI; d+=0.20 )
//            {
//                Color c = new Color(
//                        rand.nextInt(256)/*preferred*/,
//                        rand.nextInt(256),
//                        rand.nextInt(256));
//                g.setColor( c);
//                g2.drawString("Hello There!!!", 100, 300);
//                g2.rotate(0.2);
//            }



        }
    }
}

