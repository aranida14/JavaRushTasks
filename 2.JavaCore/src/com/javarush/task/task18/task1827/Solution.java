package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length < 4 || !args[0].startsWith("-c")) return;
        String crudFileName = "";
        int maxId = 0;

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); BufferedReader fileReader =
                new BufferedReader(new FileReader(crudFileName = reader.readLine()))) {
            String productStr = "";
            while ((productStr = fileReader.readLine()) != null) {
                int id = Integer.parseInt(productStr.substring(0, 8).trim());
                if(id > maxId) {
                    maxId = id;
                }
            }
        }

        try(FileWriter fileWriter = new FileWriter(crudFileName, true)) {
            String product = String.format("%1$-8s%2$-30s%3$-8s%4$-4s", Integer.toString(++maxId), args[1], args[2],
                    args[3]);
            fileWriter.write("\n" + product);
            fileWriter.flush();
        }
    }
}
