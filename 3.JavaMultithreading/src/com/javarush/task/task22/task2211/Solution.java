package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length >= 2) {
            StringBuilder fileContent = new StringBuilder();
            try(FileInputStream fis = new FileInputStream(args[0])) {
                byte[] buff = new byte[2048];
                while (fis.available() > 0) {
                    int readCount = fis.read(buff);
                    fileContent.append(new String(buff, 0, readCount, Charset.forName("Windows-1251")));
                }
            }

            byte[] fileContentUTF8 = fileContent.toString().getBytes(Charset.forName("utf8"));
            try(FileOutputStream fos =new FileOutputStream(args[1])) {
                fos.write(fileContentUTF8);
            }
        }
    }
}
