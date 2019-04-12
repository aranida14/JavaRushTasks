package com.javarush.task.task31.task3106;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) return;
        String resultFileName = args[0];

        String[] zipParts = new String[args.length - 1];
        System.arraycopy(args, 1, zipParts, 0, args.length - 1);
        Arrays.sort(zipParts);
        Vector<FileInputStream> vector = new Vector<>();

        for (int i = 0; i < zipParts.length; i++) {
            vector.add(new FileInputStream(zipParts[i]));
        }
        try (ZipInputStream is = new ZipInputStream(new SequenceInputStream(vector.elements())); FileOutputStream
                fos = new FileOutputStream(resultFileName)) {
            ZipEntry entry = is.getNextEntry();
            int readCount;
            byte[] buff = new byte[1024];
            while ((readCount = is.read(buff)) != -1) {
                fos.write(buff, 0, readCount);
            }
//            Files.copy(is, Paths.get(resultFileName));
            is.closeEntry();
        }
    }
}
