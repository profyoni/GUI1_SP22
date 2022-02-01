package edu.touro.cs.mcon364;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SecondApp extends JFrame {
    private JLabel statusLabel = new JLabel("init");
    //private int number;
    private JButton incButton;
    private JTextField numberTextField;

    SecondApp() {
        super("My 2nd App 1.1"); // must be first line

        this.setSize(500, 300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel canvasPanel = new JPanel();
        this.add(canvasPanel, BorderLayout.CENTER);
        this.add(statusLabel, BorderLayout.SOUTH);

        canvasPanel.setLayout(new GridLayout(6, 5, 4, 4));

        for (int i = 0; i < 30; i++) {
            JTextField tf = new JTextField();
            canvasPanel.add(tf);
            tf.addActionListener(
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            statusLabel.setText(e.getActionCommand());
                            Object o = e.getSource();
                           // if ( o instanceof JComponent)
                                if (o.getClass() == JComponent.class)
                                ((JTextField)o).setBackground(Color.BLUE);
                        }
                    }
            );

        }

        this.setVisible(true);
    }
}
