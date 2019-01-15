package com.javarush.task.task20.task2012;

import java.io.*;

/* 
OutputToConsole
*/
public class Solution {
    public static String greeting = "Hello world";

    /**
     * OutputToConsole is an inner base class for improving your attentiveness.
     * An OutputToConsole object encapsulates the information needed
     * for displaying the [greeting] variable to the console.
     * @author JavaRush
     */
    public static class OutputToConsole implements Externalizable {
        private int counter;

        /**
         * @param out A stream for externalization
         * @throws java.io.IOException
         */
        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeInt(counter);
        }

        /**
         * @param in A stream for de-externalization
         * @throws java.io.IOException
         * @throws ClassNotFoundException
         */
        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            counter = in.readInt();
        }

        /**
         * Class constructor that sets the private counter field.
         */
        public OutputToConsole(int counter) {
            this.counter = counter;
        }

        /**
         * Class constructor without arguments
         */
        public OutputToConsole() {}

        /**
         * Prints greeting message to console counter times.
         */
        public void printMessage() {
            for (int i = 0; i < counter; i++) {
                System.out.println(greeting);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        OutputToConsole otc = new OutputToConsole(4);
        System.out.println("call printMessage method before serialization...");
        otc.printMessage();

        File file = File.createTempFile("file2012_", null);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(otc);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        OutputToConsole otcReloaded = (OutputToConsole) ois.readObject();
        ois.close();

        System.out.println("call printMessage method after de-serialization...");
        otcReloaded.printMessage();
    }
}
