package com.javarush.task.task20.task2013;

import java.io.*;
import java.util.Arrays;
import java.util.List;

/* 
Externalizable Person
*/
public class Solution {
    public static class Person implements Externalizable {
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;

        /**
         * Public constructor without arguments
         */
        public Person() {}
        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(mother);
            out.writeObject(father);
            out.writeObject(firstName);
            out.writeObject(lastName);
            out.writeInt(age);
            out.writeObject(children);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            mother = (Person)in.readObject();
            father = (Person)in.readObject();
            firstName = (String) in.readObject();
            lastName = (String) in.readObject();
            age = in.readInt();
            children = (List)in.readObject();
        }

        @Override
        public String toString() {
            StringBuilder childrenString = new StringBuilder();
            for (Person child : children) {
                childrenString.append(child.firstName).append(" ");
            }
            StringBuilder parentsString = new StringBuilder(System.lineSeparator());
            parentsString.append("mother: ").append(this.mother.firstName).append(" ").append(this.mother.lastName);
            parentsString.append(System.lineSeparator());
            parentsString.append("father: ").append(this.father.firstName).append(" ").append(this.father.lastName);
            return "firstName = " + this.firstName + "\nlastName = " + this.lastName + "\nage = " + this.age +
                    "\nchildren:\n" + childrenString.toString() + parentsString.toString();
        }
    }

    public static void main(String[] args) throws Exception{
        Person myPerson = new Person("Ivan", "Ivanov", 30);
        myPerson.setChildren(Arrays.asList(new Person("Ann", "Ivanova", 2), new Person("Max", "Ivanov", 1)));
        myPerson.setFather(new Person("Alex", "Ivanov", 60));
        myPerson.setMother(new Person("Maria", "Ivanova", 57));

        System.out.println("serializing...");
        File file = new File("D:\\Java\\file1.txt");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(myPerson);
        oos.close();

        System.out.println("de-serializing...");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Person restoredPerson = (Person) ois.readObject();
        ois.close();

        System.out.println("Person:");
        System.out.println(restoredPerson.toString());
    }
}
