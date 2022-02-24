package edu.touro.cs.mcon364;

import java.util.Arrays;
import java.util.Scanner;

public class TransferFunds {

    public static int max(int ... list) //  varargs
    {
        int max = list[0];
        for (int i=1;i<list.length;i++)
            if (list[i] > max)
                max = list[i];
        return max;
    }

    public static void main(String[] args) {
        if (args.length < 3)
        {
            System.out.println("Error");
            return;
        }

        String username = args[0];
        String password = args[1];

        if (!(username.equals("BOB") && password.equals("sl0b")))
            return;
        String amountString;// = args[2];
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter amount");
        amountString = kb.next();

        double amount = Double.parseDouble(amountString);

        Banking.transferNow(amount);
    }
}
