package com.javarush.task.task23.task2305;

import java.util.Arrays;

/*
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution sol1 = new Solution();
        sol1.innerClasses[0] = sol1.new InnerClass();
        sol1.innerClasses[1] = sol1.new InnerClass();

        Solution sol2 = new Solution();
        sol2.innerClasses[0] = sol1.new InnerClass();
        sol2.innerClasses[1] = sol1.new InnerClass();
        return new Solution[]{sol1, sol2};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getTwoSolutions()));
    }
}
