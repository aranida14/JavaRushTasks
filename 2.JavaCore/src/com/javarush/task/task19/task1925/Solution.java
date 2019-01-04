package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        if (args.length < 2) return;
        try(BufferedReader reader = new BufferedReader(new FileReader(args[0])); BufferedWriter writer = new
                BufferedWriter(new FileWriter(args[1]))) {
            String line;
            StringBuilder result = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(" ");
                for (String word : words) {
                    if (word.length() > 6) {
                        result.append(word).append(",");
                    }
                }
            }
            result.deleteCharAt(result.length() - 1);
            writer.write(result.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
