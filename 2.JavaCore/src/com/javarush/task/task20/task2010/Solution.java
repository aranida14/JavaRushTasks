package com.javarush.task.task20.task2010;

import java.io.*;

/*
Как сериализовать что-то свое?
*/
public class Solution {

    public static class Object implements Serializable {
        public String string1;
        public String string2;
    }

    public static int stringCount;

    public static class String implements Serializable{
        private final int number;

        public String() {
            number = ++stringCount;
        }

        public void print() {
            System.out.println("string #" + number);
        }
    }


    public static void main(java.lang.String[] args) {
        try {
            File file = File.createTempFile("file2010_", null);
            Object firstObj = new Object();
            firstObj.string1 = new String();
            firstObj.string2 = new String();
            System.out.println(stringCount);
            firstObj.string1.print();
            firstObj.string2.print();

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(firstObj);

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            Object loadedObj = (Object) ois.readObject();
            System.out.println(stringCount);
            loadedObj.string1.print();
            loadedObj.string2.print();

            oos.close();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
