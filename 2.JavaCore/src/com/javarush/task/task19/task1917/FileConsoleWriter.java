package com.javarush.task.task19.task1917;

/* 
Свой FileWriter
*/

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class FileConsoleWriter {
    public static void main(String[] args) {
        //test
        try {
            FileConsoleWriter fcw = new FileConsoleWriter("D:\\Java\\task1917file.txt");
            fcw.write(95);
            fcw.write("hi world");
            fcw.write(new char[]{'a', 'b', 'c'});
            fcw.write("bicycle", 2, 5);
            fcw.write(new char[]{'c', 'r', 'u', 's', 'h'}, 1, 4);
            fcw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private FileWriter fileWriter;

    //constructors
    public FileConsoleWriter(String fileName) throws IOException {
        this.fileWriter = new FileWriter(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        this.fileWriter = new FileWriter(fileName, append);
    }

    public FileConsoleWriter(File file) throws IOException {
        this.fileWriter = new FileWriter(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {
        this.fileWriter = new FileWriter(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd) {
        this.fileWriter = new FileWriter(fd);
    }

    //methods
    public void write(int c) throws IOException {
        fileWriter.write(c);
        System.out.print(c);//очень странно, но валидатор требует выводить в консоль число без приведения к char
    }

    public void write(char[] cbuf, int off, int len) throws IOException {
        fileWriter.write(cbuf, off, len);
        System.out.print(Arrays.copyOfRange(cbuf, off, off + len));
    }

    public void write(String str, int off, int len) throws IOException {
        fileWriter.write(str, off, len);
        System.out.print(str.substring(off, off+len));
    }

    public void close() throws IOException {
        fileWriter.close();
    }

    public void write(char[] cbuf) throws IOException {
        fileWriter.write(cbuf);
        System.out.print(cbuf);
    }

    public void write(String str) throws IOException {
        fileWriter.write(str);
        System.out.print(str);
    }
}
