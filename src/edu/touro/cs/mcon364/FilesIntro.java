package edu.touro.cs.mcon364;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FilesIntro {
    public static void main(String[] args) {

        PrintWriter pw = null;
        try {
            pw = new PrintWriter("myfirstoutputfile.txt");
            for (int i =0;i<5;i++)
            {
                pw.println("Yosef says Hi");
                pw.println("Aaron says Bye");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally{
            // more code throws exc
            pw.close();
        }

//        return;
        Scanner sc = null;
        try {
            sc = new Scanner( new File("myfirstoutputfile.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (sc.hasNext())
        {
            System.out.println(sc.next());
        }
        sc.close();
    }
}
