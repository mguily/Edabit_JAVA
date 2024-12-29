package org.example;

import java.util.*;
import java.util.stream.Collectors;

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
    Tienes una lista de transacciones financieras representadas por objetos de la clase Transaction. Cada transacción tiene los siguientes campos:

    id (único identificador de la transacción).
    amount (monto de la transacción).
    timestamp (fecha y hora de la transacción).
    La lista de transacciones es extensa y contiene cientos de miles de elementos.

    Tareas:
    Filtrar las transacciones: Necesitas obtener las transacciones que tienen un monto superior a 1000 unidades.
    Agrupar por mes: Posteriormente, debes agrupar las transacciones por el mes y año en que fueron realizadas, con el formato "MM-yyyy".
    Sumar los montos: Finalmente, para cada grupo (mes/año), debes calcular la suma total de las transacciones.

    Entradas: Una lista de objetos Transaction (de tamaño n).
    Salida: Un Map<String, Double>, donde cada clave es una cadena con el formato "MM-yyyy" y el valor es la suma total de los
    montos de las transacciones para ese mes/año.

    Restricciones:

    n es grande, hasta 10^6 elementos en la lista.
    El rendimiento de la solución es crucial debido a la gran cantidad de datos.

    Ejemplo de Transaccion: Transaccion(1, 1500, "2023-03")
     */

    public static class Transaccion {
        private int id;
        private double amount;
        private String timestamp;

        public Transaccion(int id, double amount, String timestamp) {
            this.id = id;
            this.amount = amount;
            this.timestamp = timestamp;
        }

        public int getId() { return id;}
        public double getAmount() { return amount; }
        public String getTimestamp() { return timestamp; }
    }


    public static Map<String, Double> filtrarTransacciones(List<Transaccion> lista) {
        return lista.stream().filter(x -> x.getAmount() > 1000).collect(Collectors.groupingBy(time -> time.getTimestamp().substring(5, 7) + "-" +
                        time.getTimestamp().substring(0,4), Collectors.summingDouble(Transaccion::getAmount)));
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

    /*
    Write a function that takes in three parameters: r, c, i, where:

    r and c are the number of rows and columns to initialize a zero matrix.
    i represents the array of incrementing operations (+1).
    And returns the resulting matrix after applying all the increment operations. Each increment operation will add 1
    to the rows or columns specified in the incrementing array.
     */

    // Pendiente
}
