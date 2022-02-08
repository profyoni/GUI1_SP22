package edu.touro.cs.mcon364;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FilesIntro2 {
    public static void main(String[] args) {
        // try with resources auto closes resource = file

        try (PrintWriter pw = new PrintWriter("myfirstoutputfile.txt")) {
            for (int i = 0; i < 5; i++) {
                pw.println("Yosef says Hi");
                pw.println("Aaron says Bye");
            }
            // autoclosed on exit from block pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


//        return;

        try (Scanner sc = new Scanner(new File("myfirstoutputfile.txt"));) {
            while (sc.hasNext()) {
                System.out.println(sc.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
