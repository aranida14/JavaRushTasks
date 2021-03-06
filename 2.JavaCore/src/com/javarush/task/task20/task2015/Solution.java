package com.javarush.task.task20.task2015;

import java.io.*;

/* 
Переопределение сериализации
*/
public class Solution implements Runnable, Serializable{
    private transient Thread runner;
    private int speed;

    public Solution(int speed) {
        this.speed = speed;
        runner = new Thread(this);
        runner.start();
    }

    public void run() {
        // do something here, doesn't matter what
        System.out.println("Solution's run method");
    }

    /**
     Переопределяем сериализацию.
     Для этого необходимо объявить методы:
     private void writeObject(ObjectOutputStream out) throws IOException
     private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
     Теперь сериализация/десериализация пойдет по нашему сценарию :)
     */
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.runner = new Thread(this);
        this.runner.start();
    }

    public static void main(String[] args) {
        Solution sol = new Solution(4);
        try {
            File file = File.createTempFile("file2015_", null);
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(sol);
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            Solution loadedSol = (Solution) ois.readObject();

            oos.close();
            ois.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
