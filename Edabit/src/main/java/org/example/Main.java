package org.example;

public class Main {

    public static void main(String[] args) {

        String message1 = "Hello";
        int[] encrypted1 = Very_Hard.encrypt(message1);
        System.out.print("Encrypted 'Hello': ");
        for (int num : encrypted1) System.out.print(num + " ");
        int[] code1 = {72, 33, -73, 84, -12, -3, 13, -13, -68};
        String decrypted1 = Very_Hard.decrypt(code1);
        System.out.println("\nDecrypted message: " + decrypted1);
    }

    // Recuento de retos completados: 35 -> 3 Medium, 24 Hard, 8 Very Hard. (02/01/2025).
}
