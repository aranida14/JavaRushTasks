package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); FileReader fileReader = new
                FileReader(reader.readLine())) {
            StringBuilder fileContent = new StringBuilder();
            int ch;
            while ((ch = fileReader.read()) != -1) {
                fileContent.append((char) ch);
            }
            String[] words = fileContent.toString().split("[^A-Za-z]+");
            //лучше было регуляркой через "\bworld\b", т.к. у меня могут засчитываться слова типа world123
            //System.out.println(Arrays.toString(words));
            int wordCount = 0;
            for (String word: words) {
                if (word.equals("world")) {
                    wordCount++;
                }
            }
            System.out.println(wordCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
