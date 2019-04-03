package com.javarush.task.task22.task2207;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); BufferedReader fileReader =
                new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine()), Charset.forName("UTF-8")))) {
            String line;
            while ((line = fileReader.readLine()) != null) {
                if (!line.isEmpty()) {
                    words.addAll(Arrays.asList(line.split("\\s+")));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

//        for (String word : words) {
//            System.out.printf("\"%s\"%n", word);
//        }

        Iterator<String> iterator = words.iterator();
        while (!words.isEmpty()) {
            String word = words.get(0);
            words.remove(word);
            String reversedWord = new StringBuilder(word).reverse().toString();
            if (words.remove(reversedWord)) {
                Pair pair = new Pair(word, reversedWord);
                if (!result.contains(pair)) {
                    result.add(pair);
                }
            }
        }

//        for (Pair pair : result) {
//            System.out.println(pair);
//        }

    }

    public static class Pair {
        String first;
        String second;

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        public Pair() {
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null && second != null ? second :
                            second == null && first != null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
