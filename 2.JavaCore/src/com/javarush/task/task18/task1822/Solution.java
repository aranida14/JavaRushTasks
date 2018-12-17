package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        if (args.length == 0) return;
        String fileName = "";
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); BufferedReader fileReader =
        new BufferedReader(new FileReader(reader.readLine()))) {
            String productData;
            while ((productData = fileReader.readLine()) != null) {
                if (productData.startsWith(args[0] + " ")) { //todo что если разделены не пробелом, а tab'ом
                    System.out.println(productData);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
