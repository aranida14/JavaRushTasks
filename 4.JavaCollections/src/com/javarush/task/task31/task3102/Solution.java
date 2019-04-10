package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        File rootFile = new File(root);
        Queue<File> directories = new LinkedList<>();
        directories.add(rootFile);
        ArrayList<String> result = new ArrayList<>();

        while (!directories.isEmpty()) {
            File dir = directories.poll();
//            File[] filesContained = dir.listFiles();
            for (File f : dir.listFiles()) {
                if (f.isFile()) {
                    result.add(f.getAbsolutePath());
                } else if (f.isDirectory()) {
                    directories.add(f);
                }
            }
        }

        return result;

    }

    public static void main(String[] args) throws IOException {
        System.out.println(getFileTree("D:/Java/javarushForTests"));
    }
}
