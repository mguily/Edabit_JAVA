package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Very_Hard.Transaccion> transacciones = Arrays.asList(
                new Very_Hard.Transaccion(1, 1500, "2023-03"),
                new Very_Hard.Transaccion(2, 500, "2023-03"),
                new Very_Hard.Transaccion(3, 2000, "2023-04"),
                new Very_Hard.Transaccion(4, 1200, "2023-04"),
                new Very_Hard.Transaccion(5, 2500, "2023-05")
        );
        Map<String, Double> resultado = Very_Hard.filtrarTransacciones(transacciones);
        System.out.println(resultado);
    }
}
