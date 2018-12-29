package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); FileReader fileReader = new
                FileReader(reader.readLine()); FileWriter fileWriter = new FileWriter(reader.readLine())) {
            int i = 1;
            int data;
            while ((data = fileReader.read()) != -1) {
                if (i % 2 == 0) {
                    fileWriter.write(data);
                }
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
