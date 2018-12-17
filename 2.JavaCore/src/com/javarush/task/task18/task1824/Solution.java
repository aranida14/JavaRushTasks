package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        String fName = "";
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                fName = reader.readLine();
                FileInputStream inputStream = new FileInputStream(fName);
                inputStream.close();
            }
        } catch (FileNotFoundException fe) {
            System.out.println(fName);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
