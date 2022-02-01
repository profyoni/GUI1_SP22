package edu.touro.cs.mcon364;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstApp extends JFrame {
    private JLabel statusLabel = new JLabel("init");
    //private int number;
    private JButton incButton;
    private JTextField numberTextField;

    FirstApp() {
        super("My First App 1.1"); // must be first line

        this.setSize(500, 300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        incButton = new JButton("Increment :-)"); // event source
        numberTextField = new JTextField("0", 10);

        IncrementTextField eh = new IncrementTextField();
        numberTextField.addActionListener(eh);

        incButton.addActionListener(eh);

        this.setLayout(new FlowLayout());

        this.add(incButton);
        this.add(statusLabel);
        this.add(numberTextField);

        this.setBackground(Color.GREEN);

        JPanel canvasPanel = new JPanel();
        this.getContentPane().add(canvasPanel, BorderLayout.CENTER); // BorderLayout default
        // canvasPanel.setBackground( new Color(255, 99, 25));

        canvasPanel.setLayout( new GridLayout(6,5,4,4));
        canvasPanel.setBackground(Color.red);
        for (int i=0;i<30;i++)
        {
            JTextField tf = new JTextField();
            canvasPanel.add(tf);
            tf.setBackground(Color.blue);
            tf.addActionListener(new ActionListener() { // anonymous inner class
                @Override
                public void actionPerformed(ActionEvent e) {
                    statusLabel.setText(e.getActionCommand());
                }
            });
        }

        this.add(statusLabel, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    private class IncrementTextField implements ActionListener { // event handler
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int number = Integer.parseInt(numberTextField.getText());
                numberTextField.setText(Integer.toString(++number));
                statusLabel.setText("");
            } catch (NumberFormatException nfe) {
                statusLabel.setText("Please enter a number!");
            }
        }
    }

//    private class MyEventHandler implements ActionListener {
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            FirstApp.this.statusLabel.setText(e.getActionCommand());
//        }
//    }
}
