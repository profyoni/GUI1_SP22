package edu.touro.cs.mcon364;


        import javax.swing.*;
        import java.awt.*;
        import java.awt.event.*;

public class KeyManagement extends JFrame {
    private JLabel statusLabel = new JLabel("init");
    //private int number;
    private JButton incButton;
    private JTextField numberTextField;

    public KeyManagement() {
        super("My 2nd App 1.1"); // must be first line

        this.setSize(500, 300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel canvasPanel = new JPanel();
        this.add(canvasPanel, BorderLayout.CENTER);
        this.add(statusLabel, BorderLayout.SOUTH);

        canvasPanel.setLayout(new GridLayout(6, 5, 4, 4));

        JLabel [][]labels = new JLabel[6][5];

        for (int r = 0; r < 6; r++)
            for (int c = 0; c < 5; c++) {
                labels[r][c] = new JLabel();
                labels[r][c].setFont(new Font("SansSerif", Font.PLAIN, 40));
                // 0001 BOLD
                // 0010 ITALIC
                // 0011 BOTH
                canvasPanel.add(labels[r][c]);
            }

        canvasPanel.setFocusable(true);

        canvasPanel.addKeyListener(
                new KeyAdapter() {
                       @Override
                       public void keyTyped(KeyEvent e) {
                           labels[2][4].setText("" + e.getKeyChar());
                       }
                }
        );

        this.setVisible(true);
    }
}
