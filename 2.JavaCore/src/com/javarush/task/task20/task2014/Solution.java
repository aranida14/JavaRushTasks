package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) {
        Solution savedObject = new Solution(4);
        System.out.println(savedObject);
        String fileName = "D:\\Java\\file1.txt";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName)); ObjectInputStream ois =
                new ObjectInputStream(new FileInputStream(fileName))) {
            oos.writeObject(savedObject); //сохранили объект в файл

            Solution loadedObject = (Solution) ois.readObject(); //загрузили сохраненный объект
            System.out.println("are strings equal: " + savedObject.string.equals(loadedObject.string)); //сравнение
            System.out.println("loadedObject.pattern = " + loadedObject.pattern);
            System.out.println("loadedObject.currentDate = " + loadedObject.currentDate);
            System.out.println("loadedObject.temperature = " + loadedObject.temperature);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private final transient String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
