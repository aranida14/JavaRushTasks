package com.javarush.task.task20.task2009;

import java.io.*;

/*
Как сериализовать static?
*/
public class Solution {
    public static class ClassWithStatic implements Serializable {
        public static String staticString = "This is a static test string";
        public int i;
        public int j;
    }

    public static void main(String[] args) {
        ClassWithStatic classWithStatic = new ClassWithStatic();

        classWithStatic.i = 2;
        classWithStatic.j = 3;

        try {
            File myFile = File.createTempFile("file2009_", null);
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(myFile));
            oos.writeObject(classWithStatic);

            classWithStatic.staticString = "Changed string";

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(myFile));
            ClassWithStatic loadedObj = (ClassWithStatic) ois.readObject();
            System.out.println("loadedObj: staticString = " + loadedObj.staticString + ", i = " + loadedObj.i + ", j " +
                    "= " + loadedObj.j);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
