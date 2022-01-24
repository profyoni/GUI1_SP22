package edu.touro.cs.mcon364;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Main {

    public static void main(String[] args) {
        new FirstApp();
    }
}

class FirstApp extends JFrame
{
    //private int number;
    FirstApp()
    {
        super("My First App"); // must be first line

        this.setSize(500, 300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JButton incButton = new JButton("Increment :-)");
        JTextField numberTextField = new JTextField("0", 10);
        incButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int number = Integer.parseInt(numberTextField.getText());
                        numberTextField.setText(Integer.toString(++number));
                    }
                }

        );



        this.setLayout(new FlowLayout());

        this.add(incButton);
        this.add(numberTextField);

        //this.setBackground(Color.GREEN);


        this.setVisible(true);
    }
}