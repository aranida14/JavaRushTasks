package com.javarush.task.task18.task1813;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream{
    public static String fileName = "C:/tmp/result.txt";
    //public static String fileName = "D:\\Java\\file1.txt";
    private FileOutputStream original;

    public AmigoOutputStream(FileOutputStream stream) throws FileNotFoundException{
        super(fileName);
        original = stream;
    }

    @Override
    public void write(int b) throws IOException {
        original.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        original.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        original.write(b, off, len);
    }

    @Override
    public void close() throws IOException {
        original.flush();
        String s = "JavaRush © All rights reserved.";
        original.write(s.getBytes());
        original.close();
    }

    @Override
    public void flush() throws IOException {
        original.flush();
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
//        AmigoOutputStream a = new AmigoOutputStream(new FileOutputStream(fileName));
//        try {
//            a.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

}
