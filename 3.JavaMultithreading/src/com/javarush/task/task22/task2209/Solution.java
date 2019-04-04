package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) {
        StringBuilder words = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); BufferedReader fileReader =
                new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine())))) {
            String line;
            while ((line = fileReader.readLine()) != null && !line.isEmpty()) {
//                words.addAll(Arrays.asList(line.split("\\s+")));
                words.append(line).append(" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//        String[] wordsArr = new String[words.size()];
//        System.out.println(Arrays.toString(words.toString().split("\\s+")));
        StringBuilder result = getLine(words.toString().split("\\s+"));
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder result = new StringBuilder();
        ArrayList<String> wordsList = new ArrayList<>(Arrays.asList(words));
        if (!wordsList.isEmpty()) {
            String word = wordsList.get(0);
            result.append(word);
            wordsList.remove(0);
        }
        boolean isLookForRighthandWord = true;
        while (!wordsList.isEmpty()) {
            if (isLookForRighthandWord) {
                char lastLetter = result.charAt(result.length() - 1);
//                System.out.println("lastLetter: " + lastLetter);
                String nextWord = findWordWithFirstLetter(lastLetter, wordsList);
//                System.out.println(nextWord);
                if (nextWord != null) {
                    result.append(" ").append(nextWord);
                    wordsList.remove(nextWord);
                } else {
                    isLookForRighthandWord = false;
                }
            } else {
                char firstLetter = result.charAt(0);
                String nextWord = findWordWithLastLetter(firstLetter, wordsList);
                if (nextWord != null) {
                    result.insert(0, " ").insert(0, nextWord);
                    wordsList.remove(nextWord);
                } else {
                    break;
                }
            }
        }
        return result;
    }

    private static String findWordWithFirstLetter(char firstLetter, List<String> list) {
        String result = null;
        for (String word : list) {
            if (word != null && word.toLowerCase().indexOf(Character.toLowerCase(firstLetter)) == 0) {
                result = word;
                break;
            }
        }
        return result;
    }

    private static String findWordWithLastLetter(char lastLetter, List<String> list) {
        String result = null;
        for (String word : list) {
            if (word != null && word.toLowerCase().lastIndexOf(Character.toLowerCase(lastLetter)) == word.length()-1) {
                result = word;
                break;
            }
        }
//        if (result == null) {
//            throw new NoSuchElementException("Word ending with letter " + lastLetter + " was not found in the list!");
//        }
        return result;
    }
}
