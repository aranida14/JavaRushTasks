package com.javarush.task.task32.task3213;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/* 
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor#Dpljr#&C,₷B'3");
        System.out.println(decode(reader, -3));  //Hello Amigo #@)₴?$0

        StringReader reader1 = new StringReader("");
        System.out.println(decode(null, 3));
    }

    public static String decode(StringReader reader, int key) throws IOException {
        StringWriter sw = new StringWriter();
        if (reader != null) {
            int c;
            while ((c = reader.read()) != -1) {
                sw.write(c + key);
            }
//            System.out.println(sw.toString());
            return sw.toString();
        } else {
//            System.out.println("reader is null");
            return "";
        }
    }
}
