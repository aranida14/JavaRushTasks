package com.javarush.task.task20.task2016;

import java.io.*;

/* 
Минимум изменений
*/
public class Solution implements Serializable{
    public class A implements Serializable {
        String name = "A";

        public A(String name) {
            this.name += name;
            System.out.println("A constructor");
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public class B extends A {
        String name = "B";

        public B(String name) {
            super(name);
            this.name += name;
            System.out.println("B constructor");
        }
    }

    public class C extends B {
        String name = "C";

        public C(String name) {
            super(name);
            this.name = name;
            System.out.println("C constructor");
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\Java\\file1.txt"));
        Solution sol = new Solution();
        C cObj = sol.new C("myObject");
        System.out.println("writing object");
        oos.writeObject(cObj);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\Java\\file1.txt"));
        System.out.println("reading object");
        C cObjReloaded = (C) ois.readObject();
        System.out.println(cObjReloaded);

    }
}
