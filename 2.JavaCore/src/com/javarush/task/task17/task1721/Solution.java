package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args)  {
        String fileName1 = "";
        String fileName2 = "";
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName1 = reader.readLine();
            fileName2 = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(BufferedReader fileReader1 = new BufferedReader(new FileReader(fileName1)); BufferedReader fileReader2 = 
                new BufferedReader(new FileReader(fileName2))) {
            String line;
            while ((line = fileReader1.readLine()) != null) {
                allLines.add(line);
            }
            while ((line = fileReader2.readLine()) != null) {
                forRemoveLines.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Solution solution = new Solution();
        try {
            solution.joinData();
        } catch (CorruptedDataException e) {
            System.out.println("Oops, data is corrupted! :( ");
        }

//        System.out.println("allLines:");
//        for (String s : allLines) {
//            System.out.println(s);
//        }
//        System.out.println("forRemoveLines:");
//        for (String s : forRemoveLines) {
//            System.out.println(s);
//        }
    }


    public void joinData() throws CorruptedDataException {
        // хм, похоже можно было обойтись без цикла - containsAll()
        for (String s : forRemoveLines) {
            if (allLines.contains(s)) {
                allLines.remove(s);
            } else {
                allLines.clear();
                throw new CorruptedDataException();
            }
        }

    }
}
