package edu.touro.cs.mcon364;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class DrawApp  extends JFrame {
    private JLabel statusLabel = new JLabel("init");
    //private int number;
    private JButton incButton;
    private JTextField numberTextField;

    public DrawApp() {
        super("Draw 1.0"); // must be first line

        this.setSize(500, 300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel canvasPanel = new JPanel();
        this.add(canvasPanel, BorderLayout.CENTER);
        this.add(statusLabel, BorderLayout.SOUTH);


        canvasPanel.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

                Graphics g = canvasPanel.getGraphics();
                g.fillOval(e.getXOnScreen(),e.getY(),5,5);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
            }
        });


        this.setVisible(true);
    }
}