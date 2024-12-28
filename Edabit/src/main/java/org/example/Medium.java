package org.example;

public class Medium {
    /* Create a function that takes two numbers as arguments (num, length) and returns an array of multiples of num
    until the array length reaches length.
     */
    public static int[] arrayOfMultiples(int num, int length) {
        int[] solution  = new int[length];
        for (int x = 0; x < length; x++) solution[x] = num * (x+1);
        return solution;
    }
}
