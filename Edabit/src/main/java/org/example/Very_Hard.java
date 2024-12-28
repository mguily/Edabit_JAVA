package org.example;

import java.util.*;

public class Very_Hard {

    /*LEER ESTO -------------------------------------------------------------------------------------------------------
        Siempre dejo una pequeña explicacion de la solucion que realizo en los retos de tipo Very Hard.
     */

    /*
    Write a function that counts how many concentric layers a rug has.
    countLayers([
      "AAAAAAAAA",
      "ABBBBBBBA",
      "ABBAAABBA",
      "ABBBBBBBA",
      "AAAAAAAAA"
    ]) ➞ 3
     */
    public static int countLayers(String[] rug) {
        HashSet<String> layers = new HashSet<>();
        Collections.addAll(layers, rug);
        return layers.size();
        // HashSet para no repetir elementos, los añado todos con addAll, asi tengo numero de capas de la alfombra.
    }

    /*
    Write a function that groups a string into parentheses clusters. Each cluster should be balanced.
    split("((()))(())()()(()())") ➞ ["((()))", "(())", "()", "()", "(()())"]
     */
    public static String[] split(String str) {
        List<String> result = new ArrayList<>();
        int balance = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            sb.append(c);
            if (c == '(') {
                balance++;
            } else if (c == ')') {
                balance--;
            }
            if (balance == 0) {
                result.add(sb.toString());
                sb.setLength(0);
            }
        }
        return result.toArray(new String[0]);
        // Manejo la solucion con una lista String, con un SB voy guardando los trozos solucion, los añado a la lista.
    }

    /*
    The additive persistence of an integer, n, is the number of times you have to replace n with the sum of its digits until n becomes a single digit integer.

    The multiplicative persistence of an integer, n, is the number of times you have to replace n with the product of its digits until n becomes a single digit integer.

    Create two functions that take an integer as an argument and:

    Return its additive persistence.
    Return its multiplicative persistence.
     */
    public static int additivePersistence(int n) {
        if(n < 10) return 0;
        int nuevoN = 0;
        char[] numeros = String.valueOf(n).toCharArray();
        for (char numero : numeros) nuevoN += Character.getNumericValue(numero);
        return 1 + additivePersistence(nuevoN);
        // Convierto int a un array de chars, parseo cada char a un numero y los sumo, utilizo recursividad hasta que queda un solo digito para n.
    }

    public static int multiplicativePersistence(int n) {
        if(n < 10) return 0;
        int nuevoN = 1;
        char[] numeros = String.valueOf(n).toCharArray();
        for (char numero : numeros) nuevoN *= Character.getNumericValue(numero);
        return 1 + multiplicativePersistence(nuevoN);
        // Convierto int a un array de chars, parseo cada char a un numero y los multiplico, utilizo recursividad hasta que queda un solo digito para n.
    }
}
