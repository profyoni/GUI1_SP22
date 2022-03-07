package edu.touro.cs.mcon364;

import java.io.*;
import java.util.Scanner;

class Person implements Serializable
{
    int id;
    String firstName, lastName;

    String initials;
    String formalName;

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
                ", initials='" + initials + '\'' +
                ", formalName='" + formalName + '\'' +
                '}';
    }
}

public class Serialization_20 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Person p = new Person();
        p.id = 987;
        p.firstName="Doovid";
        p.lastName="Duskis";
        p.initials="DD";
        p.formalName= " The Honorable Dovid Duskis, Excelsior";
//
//        String s = p.serializeAsString();
//
//        Person q = new Person();
//        q.deserializeFromString(s);
//
//        System.out.println(q);






//        FileOutputStream fos = new FileOutputStream("people.obj");
//        ObjectOutputStream oos = new ObjectOutputStream(fos );
//
//        oos.writeObject( "Hello World");
//        oos.writeObject(p);
//        oos.close();

        ObjectInputStream ois = new ObjectInputStream( new FileInputStream("people.obj"));

        String ob1 = (String) ois.readObject( );
        Person ob2 = (Person) ois.readObject( );

        ois.close();

        System.out.println(ob1);
        System.out.println(ob2);
    }
}
