package com.javarush.task.task31.task3113;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

/* 
Что внутри папки?
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        String pathStr = "";
        try (Scanner sc = new Scanner(System.in)) {
            pathStr = sc.nextLine();
        }
        Path path = Paths.get(pathStr);
        if (!Files.isDirectory(path)) {
            System.out.println(path.toAbsolutePath().toString() + " - не папка");
            return;
        }
        MyFileVisitor myFileVisitor = new MyFileVisitor();
        Files.walkFileTree(path, myFileVisitor);
        System.out.println("Всего папок - " + (myFileVisitor.getDirectoriesAndSelfCount()-1));
        System.out.println("Всего файлов - " + myFileVisitor.getFilesCount());
        System.out.println("Общий размер - " + myFileVisitor.getBytesCount());
    }

    static class MyFileVisitor extends SimpleFileVisitor<Path> {


        private int directoriesAndSelfCount = 0;
        private int filesCount = 0;
        private long bytesCount = 0L;

        public int getDirectoriesAndSelfCount() {
            return directoriesAndSelfCount;
        }

        public int getFilesCount() {
            return filesCount;
        }

        public long getBytesCount() {
            return bytesCount;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            filesCount++;
            bytesCount += attrs.size();
            return super.visitFile(file, attrs);
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            directoriesAndSelfCount++;
            return super.postVisitDirectory(dir, exc);
        }
    }
}
