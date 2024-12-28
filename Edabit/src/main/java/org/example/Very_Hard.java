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
        StringBuilder currentCluster = new StringBuilder();
        for (char c : str.toCharArray()) {
            currentCluster.append(c);
            if (c == '(') {
                balance++;
            } else if (c == ')') {
                balance--;
            }
            if (balance == 0) {
                result.add(currentCluster.toString());
                currentCluster.setLength(0);
            }
        }
        return result.toArray(new String[0]);
        // Manejo la solucion con una lista String, con un SB voy guardando los trozos solucion, los añado a la lista.
    }
}
