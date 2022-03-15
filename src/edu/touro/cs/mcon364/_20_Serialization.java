package edu.touro.cs.mcon364;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
class MyArrayList implements Serializable
{
    static final long serialVersionUID = 6138658748769875764l;
    private int modCount;
    String s = "Bob";
    private int ip = 0;
    transient private String[] bs;

    MyArrayList()
    {
        bs = new String[100];
    }

    boolean add(String s)
    {
        bs[ip++] = s;
        return true;
    }

    public String get(int index)
    {
        return bs[index];
    }

    private void writeObject(ObjectOutputStream oos) throws IOException
    {
        oos.defaultWriteObject();
        for (int i=0;i<ip;i++)
            oos.writeObject(bs[i]);
        System.out.println("writeObject");
    }


    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject(); // sets ip
        bs = new String[ip];
        for (int i=0;i<ip;i++)
            bs[i] = (String)ois.readObject();
        System.out.println("readObject");
    }
}

class Person implements Serializable
{
    int id;
    String firstName, lastName;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        hasNameChanged = true;
    }

    transient String initials;
    String formalName;

    transient private boolean hasNameChanged;

    public String getInitials() {
        if (initials == null || hasNameChanged) // lazy initialization
        {
            initials = firstName.substring(0,1) + lastName.charAt(0);
            hasNameChanged = false;
        }
        return initials;
    }

    public String serializeAsString() {
        return id + "\n" +
                firstName + "\n" +
                lastName + "\n" +
                initials + "\n" +
                formalName;
    }

    public void  deserializeFromString(String s) {
        Scanner scanner = new Scanner(s);
        id = scanner.nextInt();
        firstName = scanner.next();
        lastName = scanner.next();
        initials = scanner.next();
        scanner.nextLine(); // ignore \n
        formalName = scanner.nextLine();
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", initials='" + getInitials() + '\'' +
                ", formalName='" + formalName + '\'' +
                '}';
    }
}

public class _20_Serialization{

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        MyArrayList list = new MyArrayList();
//        list.add("Bob");
//
//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("list.obj") );
//
//        oos.writeObject( list);
//        oos.close();

        ObjectInputStream ois = new ObjectInputStream( new FileInputStream("list.obj"));

        MyArrayList listRead = (MyArrayList) ois.readObject( );

        ois.close();

        System.out.println(listRead.get(0));

    }
    public static void main2(String[] args) throws IOException, ClassNotFoundException {

        Person p = new Person();
        p.id = 987;
        p.firstName="Dovid";
        p.lastName="Duskis";
        p.initials="DD";
        p.formalName= "The Honorable Dovid Duskis, Excelsior";

//        String s = p.serializeAsString();
//
//        Person q = new Person();
//        q.deserializeFromString(s);
//
//        System.out.println(q);



// Object Serialization

        FileOutputStream fos = new FileOutputStream("people.obj");
        ObjectOutputStream oos = new ObjectOutputStream(fos );

        oos.writeObject( "Hello World");
        oos.writeObject(p);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream( new FileInputStream("people.obj"));

        String ob1 = (String) ois.readObject( );
        Person ob2 = (Person) ois.readObject( );

        ois.close();

        System.out.println(ob1);
        System.out.println(ob2);
        ob2.setFirstName("Shalom");
        System.out.println(ob2);
    }
}
