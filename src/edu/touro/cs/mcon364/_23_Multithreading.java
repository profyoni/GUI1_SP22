package edu.touro.cs.mcon364;

import java.util.*;

class ThreadSafeList<T> implements List<T>
{
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
    public void clear() {

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
public class _23_Multithreading {


    public static void main(String[] args) throws InterruptedException {
        List list =  new ArrayList();
        Thread t1 = new MyThread(list);
        Thread t2 = new MyThread(list);

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println("Hi from thread "+ Thread.currentThread().getName());
        System.out.println(list.size());
    }
}
