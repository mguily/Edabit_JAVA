package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Object[] cities = {
                new Object[]{"Madrid", 32230000L},
                new Object[]{"Barcelona", 1620000L},
                new Object[]{"Sevilla", 1800000L},
                new Object[]{"Valencia", 800000L},
                new Object[]{"Bilbao", 345000L}
        };
        Object[] result = Hard.millionsRounding(cities);

        // Mostrar el resultado correctamente
        for (Object city : result) {
            // Cast a Object[] para obtener los elementos de cada ciudad
            Object[] ciudad = (Object[]) city;
            // Imprimir nombre y población redondeada
            System.out.println("Ciudad: " + ciudad[0] + ", Población redondeada: " + ciudad[1]);
        }
    }
}
