package edu.touro.cs.mcon364;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class ThreadSafeList<T> implements List<T>
{
    static synchronized void foo(){
        synchronized ( ThreadSafeList.class ) // means the same as static synchronized
        {

        }
    }
    private List<T> bs = new LinkedList<>();


    @Override
    public int size() {
        return bs.size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        synchronized (this)
        {
            return bs.add(t);
        }
    }

    @Override
    public synchronized boolean remove(Object o) {
        return bs.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public  void clear() {
        synchronized (this)
        {
            // t1
        }
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ThreadSafeList<?> that = (ThreadSafeList<?>) o;
        return Objects.equals(bs, that.bs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bs);
    }
}

class MyThread extends Thread{
    static Object ob = new Object();
    private List list;
    public MyThread(List list){
        this.list = list;
    }
    @Override
    public void run(){ // main for a thread

        for (int i=0;i<10_000_000;i++)
        {
            synchronized (ob) // synchronized block
            {
                list.add(i);
            }

        }
        System.out.println("Hi from thread "+ Thread.currentThread().getName());
    }
}
// Task
class MyRunnable implements Runnable{
    static Object ob = new Object();
    private List list;
    public MyRunnable(List list){
        this.list = list;
    }

    @Override
    public void run(){ // main for a thread

        for (int i=0;i<10_000_000;i++)
        {
            synchronized (ob) // synchronized block
            {
                list.add(i);
            }

        }
        System.out.println("Hi from thread "+ Thread.currentThread().getName());
    }
}

public class _23_Multithreading {

    public static void main2(String[] args) throws IOException {
        for (int i=0;i<5;i++)
        {
            Process process = new ProcessBuilder("notepad.exe").start();
        }
    }

    public static void main1(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i=0;i<20;i++)
        {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("Start " + Thread.currentThread().getName());
                        Thread.sleep(new Random().nextInt(5000)+2000);
                        System.out.println("Ended " + Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                    }
                }
            });
            executorService.submit( () -> { System.out.println("Hello");  }
            );
        }
        Runnable r =         () -> System.out.println("Hello");
        executorService.shutdown();
        try {
            executorService.awaitTermination(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
        }
        executorService.shutdownNow();
    }


    static void doAction(Runnable method, int times){
        for (int i=0;i<times;i++)
        {
           method.run();
        }
    }

    static int doAction(int seed, TwoArgs op, int []list)
    {
        int total = seed;
        for (int elt: list) {
            total = op.operation(total, elt);
        }
        return total;
    }

    interface TwoArgs
    {
        abstract int operation(int a, int b);
    }

    static class Add implements TwoArgs
    {
        public int operation(int a, int b){
            return a + b;
        }
    }
    public static void main(String[] args) {
        doAction(()-> System.out.println("Hooray"), 10);

        var list = new int[]{1,2,3,4,3,2,1};
        int t = doAction( 1, (a, b) -> a * b, list);
        System.out.println(t);

        System.out.println(Arrays.stream(list).count());
        System.out.println(Arrays.stream(list).average());
        Arrays.stream(Arrays.stream(list).filter(q -> q % 2 == 0)
                .distinct().toArray())
                .forEach(System.out::println);

    }

    public static void main8(String[] args) throws InterruptedException {



        List list =  new ArrayList();
        Thread t1 = new MyThread(list);
        Thread t2 = new MyThread(list);
        Thread t3 = new Thread(new MyRunnable(list));

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("Hi from thread "+ Thread.currentThread().getName());
        System.out.println(list.size());
    }
}
