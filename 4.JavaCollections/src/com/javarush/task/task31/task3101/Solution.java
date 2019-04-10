package com.javarush.task.task31.task3101;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.util.*;


/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) {

//        System.out.println(Arrays.toString(args));
        if (args.length < 2) return;

        String path = args[0];
        String resultFileAbsolutePath = args[1];
        ArrayList<File> filesList = new ArrayList<>();

        File file = new File(args[0]);
        searchFiles(file, (file1) -> file1.length() <= 50, filesList);
//        System.out.println("after searching");

        filesList.sort((f1, f2) -> f1.getName().compareTo(f2.getName()));
//        System.out.println("sorted list: " + filesList);

        File resultFile = new File(resultFileAbsolutePath);
//        if (!FileUtils.isExist(resultFile)) return;
//        System.out.println("resultFileAbsolutePath exists");

        File newPath = new File(resultFile.getParent() + "/allFilesContent.txt");
        FileUtils.renameFile(resultFile, newPath);
        resultFile = newPath;

        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(newPath))) {
            for (File f : filesList) {
                byte[] fileBytes = Files.readAllBytes(f.toPath());
                bos.write(fileBytes);
                bos.write("\n".getBytes("utf8"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Searches directory recursively.
     *
     * @param directory directory to search
     * @param filter    FileFilter used to filter found files
     * @param resList   a List where found & filtered files are added to
     */
    public static void searchFiles(File directory, FileFilter filter, List<File> resList) {
        if (directory.isDirectory()) { //если директория, проходимся по всему содержимому
            File[] containedFiles = directory.listFiles();
            for (File f : containedFiles) {
                searchFiles(f, filter, resList);
            }
        } else if (directory.isFile() && filter.accept(directory)) { //если это файл и он соответствует фильтру
            resList.add(directory); //добавляем его в список
        }
    }
}
