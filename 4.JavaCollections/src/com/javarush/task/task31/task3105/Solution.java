package com.javarush.task.task31.task3105;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) return;

        HashMap<ZipEntry, ByteArrayOutputStream> zipEntries = new HashMap<>();
//        String fileToReplace = "";
        try (ZipInputStream zin = new ZipInputStream(new FileInputStream(args[1]))) {
            ZipEntry entry;
            while ((entry = zin.getNextEntry()) != null) {
//                String name = entry.getName();
//                Path pathName = Paths.get(name);
////                System.out.println(pathName);
//                if (pathName.getFileName().toString().equals(Paths.get(args[0]).getFileName().toString())) {
////                    System.out.println("don't save");
//                    //если файл с таким именем уже есть в архиве, сохранять его не нужно - он должен быть перезаписан
//                    fileToReplace = name;
//                    continue;
//                }
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buff = new byte[1024];
                while (zin.available() > 0) {
                    int readCount = zin.read(buff);
                    if (readCount != -1) {
                        baos.write(buff, 0, readCount);
                    }
                }

                zipEntries.put(entry, baos);
                zin.closeEntry();
            }
        }

        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(args[1]))) {
            //добавим указанный файл в new/
            Path fileToAdd = Paths.get(args[0]);
            String newFileName = "new/" + fileToAdd.getFileName().toString();
            ZipEntry newFileToZip = new ZipEntry(newFileName);
            zout.putNextEntry(newFileToZip);
            Files.copy(fileToAdd, zout);
            zout.closeEntry();

            for (Map.Entry<ZipEntry, ByteArrayOutputStream> pair : zipEntries.entrySet()) {
                ZipEntry entry = new ZipEntry(pair.getKey().getName());
                if (entry.getName().endsWith(fileToAdd.getFileName().toString())) {
                    //если файл с таким именем уже есть в архиве, добавлят его не нужно - он должен быть перезаписан
                    continue;
                }
                zout.putNextEntry(entry);
                zout.write(pair.getValue().toByteArray());
                zout.closeEntry();
            }

        }
    }
}
