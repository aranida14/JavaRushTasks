package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        if (args.length < 2) return;
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0])); BufferedWriter writer = new
                BufferedWriter(new FileWriter(args[1]))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.matches(".*[0-9]+.*")) {
                        writer.write(word + " ");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
