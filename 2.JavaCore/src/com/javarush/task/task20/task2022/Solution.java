package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
    private String fileName; //added

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName; //added
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        //out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.stream = new FileOutputStream(this.fileName, true); //added
        //in.close();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws Exception {
        Solution sol = new Solution("D:\\Java\\file1.txt");
        sol.writeObject("This string will be written to stream.");
        sol.close();

        FileOutputStream fos = new FileOutputStream("D:\\Java\\file2.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(sol);

        fos.close();
        oos.close();

        FileInputStream fis = new FileInputStream("D:\\Java\\file2.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Solution solReloaded = (Solution) ois.readObject();

        fis.close();
        ois.close();

        solReloaded.writeObject("Second string!");
        solReloaded.close();

    }
}
