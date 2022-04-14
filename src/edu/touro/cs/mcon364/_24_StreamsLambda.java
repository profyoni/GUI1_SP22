package edu.touro.cs.mcon364;

import java.util.*;

public class _24_StreamsLambda {
    public static void main(String[] args) {

        var list = Arrays.asList(new Integer[]{1,2,3,4,5,4,3});

        System.out.println(list.stream().count());
        System.out.println(list.stream().distinct().count());

        for (var i: list.stream().filter( a -> a % 2 == 1 ).toArray()) {
            System.out.println(i);
        }



    }
}

