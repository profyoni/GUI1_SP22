package edu.touro.cs.mcon364;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.List;

public class DrawApp  extends JFrame {
    private JLabel statusLabel = new JLabel("init");
    //private int number;
    private JButton incButton;
    private JTextField numberTextField;

    public DrawApp() {
        super("Draw 1.0"); // must be first line

        this.setSize(500, 300);
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

        @Override
        public void paint(Graphics g)
        {
            super.paint(g);
            if (originalWidth == 0 && originalHeight == 0) // set width/height first time
            {
                originalWidth = this.getWidth();
                originalHeight = this.getHeight();
            }
            Color c = new Color( (int)(Math.random() * 256),(int)(Math.random() * 256),(int)(Math.random() * 256));
            g.setColor( c);
            statusLabel.setText(c.toString());

            double scaleWidth = (double) this.getWidth() / originalWidth;
            double scaleHeight = (double) this.getHeight() / originalHeight;
            for(Point p : pointList)
            {

                g.fillOval((int)(p.getX()*scaleWidth),
                        (int)(p.getY()*scaleHeight),
                        (int)(5 * scaleWidth),
                        (int)(5 * scaleHeight));
            }
        }
    }
}

