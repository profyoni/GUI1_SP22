package edu.touro.cs.mcon364;

import java.io.Console;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegexTestHarness {

    public static void main(String[] args) {
//        Console console = System.console();
//        if (console == null) {
//            System.err.println("No console.");
//            System.exit(1);
//        }
        //while (true)
        {

            Pattern pattern =
                    Pattern.compile("\\d+");

            Matcher matcher =
                    pattern.matcher("20398\n" +
                            "ffsdfg20939tttwt" +
                            "w3rr2843984errer");

            boolean found = false;
            while (matcher.find()) {
                System.out.printf("I found the text" +
                                " \"%s\" starting at " +
                                "index %d and ending at index %d.%n",
                        matcher.group(),
                        matcher.start(),
                        matcher.end());
                found = true;
            }
            if (!found) {
                System.out.printf("No match found.%n");
            }
        }
    }
}

