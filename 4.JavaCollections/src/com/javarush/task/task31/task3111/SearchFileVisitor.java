package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {

    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;

    private List<Path> foundFiles = new ArrayList<>();

    public List<Path> getFoundFiles() {
        return foundFiles;
    }
    public String getPartOfName() {
        return partOfName;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public String getPartOfContent() {
        return partOfContent;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public int getMinSize() {
        return minSize;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file); // размер файла: content.length
        String contentStr = new String(content);
//        Files.readAllLines(file);
//        boolean isMeetCriteria = true;
        if (partOfName != null && !file.getFileName().toString().contains(partOfName))
            return FileVisitResult.CONTINUE;
        if (partOfContent != null && !contentStr.contains(partOfContent))
            return FileVisitResult.CONTINUE;
        if (minSize > 0 && content.length < minSize)
            return FileVisitResult.CONTINUE;
        if (maxSize > 0 && content.length > maxSize)
            return FileVisitResult.CONTINUE;
        foundFiles.add(file);

        return FileVisitResult.CONTINUE;
    }
}
