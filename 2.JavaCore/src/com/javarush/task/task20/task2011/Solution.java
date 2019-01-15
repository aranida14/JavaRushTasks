package com.javarush.task.task20.task2011;

import java.io.*;

/*
Externalizable для апартаментов
*/
public class Solution {

    public static class Apartment implements Externalizable{

        private String address;
        private int year;

        /**
         * Mandatory public no-arg constructor.
         */
        public Apartment() { super(); }

        public Apartment(String addr, int y) {
            address = addr;
            year = y;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(address);
            out.writeInt(year);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            this.address = (String) in.readObject();
            this.year = in.readInt();
        }

        /**
         * Prints out the fields used for testing!
         */
        public String toString() {
            return("Address: " + address + "\n" + "Year: " + year);
        }
    }

    public static void main(String[] args) throws Exception {
        Apartment myApartment = new Apartment("Москва, ул. Ленина, д.1", 2000);
        System.out.println("initially: " + myApartment);
        File file = File.createTempFile("file2011_", null);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(myApartment);
        //myApartment.writeExternal(oos);
        oos.close();

        //Apartment restoredApt = new Apartment();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Apartment restoredApt = (Apartment) ois.readObject();
//        restoredApt.readExternal(ois);
        ois.close();
        System.out.println("after de-serialization: " + restoredApt);
    }
}
