package org.example;

import java.math.*;
import java.util.*;
import java.util.stream.Collectors;

public class Hard {
    /*
    Create a function that will test if a string is a valid PIN or not via a regular expression.

    A valid PIN has:

    Exactly 4 or 6 characters.
    Only numeric characters (0-9).
    No whitespace.
     */
    public static boolean validate(String pin) {
        return pin.matches("^[0-9]{4}$|^[0-9]{6}$");
    }

    /*
    Given an array of integers, return the largest gap between the sorted elements of the array.

        For example, consider the array:

        [9, 4, 26, 26, 0, 0, 5, 20, 6, 25, 5]
        ... in which, after sorting, the array becomes:

        [0, 0, 4, 5, 5, 6, 9, 20, 25, 26, 26]
        ... so that we now see that the largest gap in the array is between 9 and 20 which is 11.
     */
    public static int largestGap(int[] numbers) {
        if (numbers == null || numbers.length < 2) return 0;
        Arrays.sort(numbers);
        int gapActual, mayorGap = 0;
        for (int i = 1; i < numbers.length; i++) {
            gapActual = numbers[i] - numbers[i - 1];
            mayorGap = Math.max(mayorGap, gapActual);
        }
        return mayorGap;
    }

    /*
    Create a recursive function that determines whether a word is a palindrome or not.
     */
    public static boolean isPalindrome(String wrd) {
        int length = wrd.length();
        if (length >= 2) {
            String newWrd = wrd.substring(1, length - 1);
            if (wrd.charAt(0) == wrd.charAt(length - 1)) return isPalindrome(newWrd);
            else return false;
        } else return true;
    }

    /*
    Create a function that recursively counts the integer's number of digits.
     */
    public static int count(int n) {
        if (n < 0) n = -n;
        if (n < 10) return 1;
        return 1 + count(n / 10);
    }

    /*
    A number is said to be Harshad if it's exactly divisible by the sum of its digits. Create a function that
     determines whether a number is a Harshad or not.
     */

    public static boolean isHarshad(int n) {
        int divisor = 0;
        divisor = sumaDigitos(n);
        return (n % divisor == 0);
    }

    public static int sumaDigitos(int num) {
        if (num == 0) return 0;
        return (num % 10) + sumaDigitos(num / 10);
    }

    /*
    Create a function that checks if a given integer is exactly the factorial of an integer or not. true if it is,
     false otherwise.
     */
    public static boolean isFactorial(int n) {
        if (n == 1 || n == 0) return true;
        int index = 1;
        boolean factorial = false;
        int number = 2;
        while (index < n) {
            index *= number;
            factorial = (index == n);
            number++;
        }
        return factorial;
    }

    /*
        Let's say that there exists a machine that gives out free coins, but with a twist!

        Separating two people is a wall, and this machine is placed in such a way that both people are able
        to access it. Spending a coin in this machine will give the person on the other side 3 coins and vice versa.

        If both people continually spend coins for each other (SHARING),
        then they'll both gain a net profit of 2 coins per turn. However,
        there is always the possibility for someone to act  selfishly (STEALING): they spend no coins,
        yet they still receive the generous 3 coin gift from the other person!

        Assuming that both people start with 3 coins each, create a function that calculates both people's
        final number of coins. You will be given two arrays of strings,
        with each string being the words "share" or "steal".
     */
    public static int[] getCoinBalances(String[] r, String[] b) {
        int[] solucion = {3, 3};
        for (int i = 0; i < r.length; i++) {
            calcularIndividual(b[i], r[i], solucion);
            System.out.println(Arrays.toString(solucion));
        }
        return solucion;
    }

    private static void calcularIndividual(String r, String b, int[] solucion) {
        if (r.equals("share") && b.equals("share")) {
            solucion[0] += 2;
            solucion[1] += 2;
        } else if (r.equals("share") && b.equals("steal")) {
            solucion[0] += 3;
            solucion[1] -= 1;
        } else if (r.equals("steal") && b.equals("share")) {
            solucion[0] -= 1;
            solucion[1] += 3;
        }
    }

    /*
    Create a function that determines whether elements in an array can be re-arranged to form a consecutive list
    of numbers where each number appears exactly once.
     */
    public static boolean cons(int[] arr) {
        if (arr == null || arr.length < 2) return false;
        Arrays.sort(arr);
        int index = 1;
        boolean result = true;
        while (index < arr.length && result) {
            if (arr[index] - arr[index - 1] != 1) result = false;
            index++;
        }
        return result;
    }

    /*
    Create a function that takes an array of numbers and return "Boom!" if the digit 7 appears in the array. Otherwise,
    return "there is no 7 in the array".
     */
    public static String sevenBoom(int[] arr) {
        return Arrays.toString(arr).contains("7") ? "Boom!" : "there is no 7 in the array";
    }

    /*
    Write a function that returns true if you can partition an array into one element and the rest, such that this
    element is equal to the product of all other elements excluding itself.
     */
    public static boolean canPartition(int[] arr) {
        if (arr == null || arr.length < 2) return false;
        int ceros = 0; int resultado = 1;
        for (int x  : arr) {
            if (x == 0) ceros++;
            else resultado *= x;
        }
        if (ceros > 1) return true;
        if (ceros == 1) return false;
        else {
            for (int i : arr) if (i != 0 && resultado / i == i) return true;
        }
        return false;
    }

    /*
    Write a function that takes the coordinates of three points and returns the perimeter of the triangle.
    The given points are the vertices of a triangle on a two-dimensional plane.

    perimeter(arr[0]={15, 7}, arr[1]={5, 22}, arr[2]={11, 1}) ➞ 47.08
     */
    public static double perimeter(int[][] point) {
        double primerLado = lado(point[0][0], point[0][1], point[1][0], point[1][1]);
        double segundoLado = lado(point[1][0], point[1][1], point[2][0], point[2][1]);
        double tercerLado = lado(point[2][0], point[2][1], point[0][0], point[0][1]);
        return Double.sum(primerLado, Double.sum(segundoLado, tercerLado));
    }

    private static double lado(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    /*
    Given a positive integer n and if 1 plus 2 times n exactly divides 1 plus 2 raised to the power n, then n is said to be a Curzon number.

    Write a function that determines whether a number is a Curzon number or not.

    isCurzon(10) ➞ false
    // 2 ** 10 + 1 = 1025
    // 2 * 10 + 1 = 21
    // 1025 is not a multiple of 21
     */
    public static boolean isCurzon(int n) {
        BigInteger base = BigInteger.valueOf(2).pow(n).add(BigInteger.valueOf(1));
        BigInteger divider = BigInteger.valueOf(2L * n + 1);
        return base.mod(divider).equals(BigInteger.valueOf(0));
    }

    /*
    Create a function that returns which chapter is nearest to the page you're on. If two chapters are equidistant,
     return the chapter with the higher page number.

     nearestChapter(new Chapter[] { new Chapter("Chapter 1a", 1), new Chapter("Chapter 1b", 5) }, 3) ➞ "Chapter 1b"
     */

    public static class BookChapter {
        public static String nearestChapter(Chapter[] chapter, int page) {
            Chapter capituloCercano = null;
            int menorDif = Integer.MAX_VALUE;
            for (Chapter capitulo : chapter) {
                int difActual = Math.abs(capitulo.getPage() - page);
                if (capituloCercano == null || difActual < menorDif || (menorDif == difActual && capitulo.getPage() > capituloCercano.getPage())) {
                    capituloCercano = capitulo;
                    menorDif = difActual;
                }
            }
            return capituloCercano != null ? capituloCercano.getName() : null;
        }
    }

    public static class Chapter {
        private String name;
        private int page;

        public Chapter(String name, int page) {
            this.name = name;
            this.page = page;
        }
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public int getPage() { return page; }
        public void setPage(int page) { this.page = page; }
    }

    /*
    An array is positive dominant if it contains strictly more unique positive values than unique negative values.
    Write a function that returns true if an array is positive dominant, false, otherwise.
     */

    public static boolean isPositiveDominant(int[] n) {
        long negativos = Arrays.stream(n).filter(x -> x < 0).distinct().count();
        long positivos = Arrays.stream(n).filter(x -> x > 0).distinct().count();
        return positivos > negativos;
    }

    /*
    You have a pack of 5 randomly numbered cards, which can range from 0-9.
    You can win if you can produce a higher two-digit number from your cards than your opponent.
    Return true if your cards win that round.

    winRound([2, 5, 2, 6, 9], [3, 7, 3, 1, 2]) ➞ true
    // Your cards can make the number 96
    // Your opponent can make the number 73
    // You win the round since 96 > 73
     */
    public static boolean winRound(int[] you, int[] opp) {
        Arrays.sort(you); Arrays.sort(opp);
        int mio = you[you.length - 1] * 10 + you[you.length - 2];
        int suyo = opp[opp.length - 1] * 10 + opp[opp.length - 2];
        return mio > suyo;
    }
}