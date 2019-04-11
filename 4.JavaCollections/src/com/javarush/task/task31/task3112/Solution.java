package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.*;

/* 
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {

        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("D:/Java/javarushForTests"));
        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        // implement this method
        URL url = new URL(urlString);
        ReadableByteChannel source = Channels.newChannel(url.openStream());
        Path tmpFile = Files.createTempFile("tmp_", null);
//        FileChannel dest = FileChannel.open(tmpFile, StandardOpenOption.WRITE);
//        dest.transferFrom(source, 0, Long.MAX_VALUE);
//        System.out.println(tmpFile);

        Files.copy(url.openStream(), tmpFile, StandardCopyOption.REPLACE_EXISTING);
//        System.out.println(Paths.get(url.getPath()));
//        System.out.println(downloadDirectory.resolve(Paths.get(url.getPath()).getFileName()));
        return Files.move(tmpFile, downloadDirectory.resolve(Paths.get(url.getPath()).getFileName()), StandardCopyOption.REPLACE_EXISTING);
    }
}
