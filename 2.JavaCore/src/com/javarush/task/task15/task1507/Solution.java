package com.javarush.task.task15.task1507;

/* 
ООП - Перегрузка
*/

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");

        //test
        printMatrix(3, "h");
    }

    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }
    public static void printMatrix(int n, Object value) {
        System.out.println("Квадратая");
        printMatrix(n, n, value);
    }

    public static void printMatrix(int m, int n) {
        System.out.println("Заполняем натуральными числами");
        int num = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(num);
                num++;
            }
            System.out.println();
        }
    }

    public static void printMatrix(int m, int n, Integer value) {
        System.out.println("Заполняем объектами Integer");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Double value) {
        System.out.println("Заполняем объектами Double");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int n) {
        System.out.println("Заполняем квадратную матрицу натуральными числами");
        printMatrix(n, n);
    }

    public static void printMatrix(int n, Double value) {
        System.out.println("Заполняем квадратную матрицу объектами Double");
        printMatrix(n, (Object) value);
    }

    public static void printMatrix(int n, Integer value) {
        System.out.println("Заполняем квадратную матрицу объектами Integer");
        printMatrix(n, (Object) value);
    }

    public static void printMatrix(int n, String value) {
        System.out.println("Заполняем квадратную матрицу объектами String");
        printMatrix(n, (Object) value);
    }
}
