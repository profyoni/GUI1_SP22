package edu.touro.cs.mcon364;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class _26_SwingThreads extends JFrame {
    public static void main(String[] args) {
        new _26_SwingThreads();
//        Integer x = new Integer(0);
//        Integer y = x;
//        // PETO up in arms
//        for (;
//             y.intValue() < 100;
//             x = new Integer(x.intValue() + 1))
//            System.out.print(y);
   }




    private JButton b;
    _26_SwingThreads()
    {
        setSize(600,400);
        b = new JButton("Press Now");
        add(b);
        b.addActionListener(e ->
                new Thread(
                        () -> {
                            slowMethod();
                            SwingUtilities.invokeLater( () -> b.setText(new Random().nextInt(1000) + ""));
                        }
            ).start()
        );

        setDefaultCloseOperation( EXIT_ON_CLOSE );
        setVisible(true);
    }

    private void slowMethod(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
