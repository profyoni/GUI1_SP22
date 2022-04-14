//package edu.touro.cs.mcon364;
//
//import java.util.*;
//
//public class _25_WrapperClasses {
//    public static void main(String[] args) {
//        List<String> people = new ArrayList<>();
//
//        people = Collections.synchronizedList(people);
//
////        MyThread.process(people);
////        MyThread.process(people);
//
//    // safely iterate through a thread-safe list
//
//        synchronized (people)
//        {
//            for (Iterator<String> it = people.iterator();
//                 it.hasNext(); )
//            {
//                String s = it.next();
//                System.out.println(s);
//            }
//        }
//
//        people = Collections.unmodifiableList(people);
//
//        // immutable objects are inherently thread safe
//        // Effective Java - consider making your classes immutable
//
//        Integer x = new Integer(9);
//        x.intValue();
//}
//
//class MyInt
//{
//    public MyInt(int v)
//    {value = v;}
//
//    private final int value;
//    private StringBuilder sb;
//
//    public int getValue(){return value;}
//    // defensive copy not needed when returning immutable
//    public StringBuilder getSb(){return new StringBuilder(sb);}
//}
//
//class MyCol {
//    /**
//     *     static factory method - Design Pattern
//     */
//
//    public static <T> List<T> syncList(List<T> list){
//        return new SyncedList<>(list);
//    }
//
//
//    /**
//     Synchronized wrapper class for <code>List</code>
//     */
//    private static class SyncedList<T> implements List<T>
//    {
//        final private List<T> bs;
//        SyncedList(List<T> list){
//            bs = list;
//        }
//
//        @Override
//        public int size() {
//            return 0;
//        }
//
//        @Override
//        public boolean isEmpty() {
//            return false;
//        }
//
//        @Override
//        synchronized public boolean contains(Object o) {
//            return bs.contains(o);
//        }
//
//        @Override
//        public Iterator<T> iterator() {
//            return null;
//        }
//
//        @Override
//        public Object[] toArray() {
//            return new Object[0];
//        }
//
//        @Override
//        public <T1> T1[] toArray(T1[] a) {
//            return null;
//        }
//
//        @Override
//        public boolean add(T t) {
//            return false;
//        }
//
//        @Override
//        public boolean remove(Object o) {
//            return false;
//        }
//
//        @Override
//        public boolean containsAll(Collection<?> c) {
//            return false;
//        }
//
//        @Override
//        public boolean addAll(Collection<? extends T> c) {
//            return false;
//        }
//
//        @Override
//        public boolean addAll(int index, Collection<? extends T> c) {
//            return false;
//        }
//
//        @Override
//        public boolean removeAll(Collection<?> c) {
//            return false;
//        }
//
//        @Override
//        public boolean retainAll(Collection<?> c) {
//            return false;
//        }
//
//        @Override
//        public void clear() {
//
//        }
//
//        @Override
//        public T get(int index) {
//            return null;
//        }
//
//        @Override
//        public T set(int index, T element) {
//            return null;
//        }
//
//        @Override
//        public void add(int index, T element) {
//
//        }
//
//        @Override
//        public T remove(int index) {
//            return null;
//        }
//
//        @Override
//        public int indexOf(Object o) {
//            return 0;
//        }
//
//        @Override
//        public int lastIndexOf(Object o) {
//            return 0;
//        }
//
//        @Override
//        public ListIterator<T> listIterator() {
//            return null;
//        }
//
//        @Override
//        public ListIterator<T> listIterator(int index) {
//            return null;
//        }
//
//        @Override
//        public List<T> subList(int fromIndex, int toIndex) {
//            return null;
//        }
//    }
//}