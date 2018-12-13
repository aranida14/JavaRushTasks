package com.javarush.task.task18.task1812;

import java.io.*;
import java.util.Scanner;

/* 
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {
    private AmigoOutputStream stream;

    public QuestionFileOutputStream(AmigoOutputStream amigoOutputStream) {
        this.stream = amigoOutputStream;
    }
    //test
    /*public static void main(String[] args) {
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        Scanner scanner = new Scanner(System.in);
        String answer = "";

        answer = scanner.nextLine();
        if (answer.equals("Д")) {
            System.out.println("stream closed");
        }

    }*/

    @Override
    public void flush() throws IOException {
        stream.flush();
    }

    @Override
    public void write(int b) throws IOException {
        stream.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        stream.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        stream.write(b, off, len);
    }

    @Override
    public void close() throws IOException {
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        Scanner scanner = new Scanner(System.in);
        String answer = "";
        if (scanner.hasNext()) {
            answer = scanner.nextLine();
            if (answer.equals("Д")) {
                stream.close();
            }
        }

    }
}

