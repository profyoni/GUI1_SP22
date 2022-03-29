package edu.touro.cs.mcon364;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MyThread extends Thread{
    private List list;
    public MyThread(List list){
        this.list = list;
    }
    @Override
    public void run(){ // main for a thread

        for (int i=0;i<1_000_000;i++)
        {
            list.add(i);
        }
        System.out.println("Hi from thread "+ Thread.currentThread().getName());
    }
}
public class _23_Multithreading {


    public static void main(String[] args) throws InterruptedException {
        List list = Collections.synchronizedList(new ArrayList());
        Thread t1 = new MyThread(list);
        Thread t2 = new MyThread(list);

        t1.start();
        t2.start();
        Thread.sleep(2000);
        System.out.println("Hi from thread "+ Thread.currentThread().getName());
        System.out.println(list.size());
    }
}
