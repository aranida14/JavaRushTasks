package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(consoleReader.readLine()));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(consoleReader.readLine()));

        String initialNumbersString = fileReader.readLine();
        String[] initialNumbersStrArr = initialNumbersString.split("\\s+");
        int[] numbers = new int[initialNumbersStrArr.length];
        for (int i = 0; i < initialNumbersStrArr.length; i++) {
            numbers[i] = Math.round(Float.parseFloat(initialNumbersStrArr[i]));
        }
        StringBuilder builder = new StringBuilder();
        for (int num : numbers) {
            builder.append(num).append(" ");
        }
        fileWriter.write(builder.toString().trim());
        //System.out.println(Math.rint(-3.5f)); //todo

        consoleReader.close();
        fileReader.close();
        fileWriter.close();


    }
}
