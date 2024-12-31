package org.example;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Medium {
    /*
    There's a great war between the even and odd numbers. Many numbers already lost their lives in this war and it's your task to end this.
    You have to determine which group sums larger: the evens, or the odds. The larger group wins.

    Create a function that takes an array of integers, sums the even and odd numbers separately,
    then returns the difference between the sum of the even and odd numbers.

    Examples
    warOfNumbers([2, 8, 7, 5]) ➞ 2
     */
    public static void warOfNumbers(int[]numbers){
        int resultado = Arrays.stream(numbers).reduce(0, (a, b) -> b % 2 == 0 ? a + b : a - b);
        if (resultado == 0) System.out.println("Empate");
        else if (resultado < 0) System.out.println("Ganan los impares"); else System.out.println("Ganan los pares");
        // Se podria hacer sin usar un Stream pero me propuse hacerlo en el meno numero de lineas posibles.
        // He cambiado un poco la funcion para determinar ganador.
    }

    /* Create a function that takes two numbers as arguments (num, length) and returns an array of multiples of num
    until the array length reaches length.
     */
    public static int[] arrayOfMultiples(int num, int length) {
        int[] solution  = new int[length];
        for (int x = 0; x < length; x++) solution[x] = num * (x+1);
        return solution;
    }
}
