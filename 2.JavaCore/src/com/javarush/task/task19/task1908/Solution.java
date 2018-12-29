package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); BufferedReader fileReader =
        new BufferedReader(new FileReader(reader.readLine())); BufferedWriter fileWriter = new BufferedWriter(new
                FileWriter(reader.readLine()))) {
            String line;
            while ((line = fileReader.readLine()) != null) {
                StringBuilder resultLine = new StringBuilder();
                Pattern pattern = Pattern.compile("\\b[0-9]+\\b");
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    resultLine.append(matcher.group()).append(" ");
                }
                fileWriter.write(resultLine.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
