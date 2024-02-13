/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.leetconverter;

/**
 *
 * @author pamee
 */
import java.util.Scanner;

public class LeetConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario que ingrese un texto
        System.out.print("Ingresa un texto: ");
        String texto = scanner.nextLine();

        // Convertir el texto a Leet
        String leetText = convertirALeet(texto);

        // Mostrar el resultado
        System.out.println("Texto en Leet: " + leetText);
    }

    private static String convertirALeet(String texto) {
        // Crear un mapa de caracteres para la conversión Leet
        String[] leetMap = {"4", "8", "<", "|)", "3", "f", "6", "#", "|", "j", "k", "|_", "m", "|\\/|", "0", "|o", "q", "|2", "5", "7", "u", "\\/", "\\/\\/", "><", "¥", "2"};

        // Convertir cada caracter del texto
        StringBuilder leetText = new StringBuilder();
        for (char c : texto.toCharArray()) {
            if (Character.isLetter(c)) {
                int index = Character.toLowerCase(c) - 'a';
                if (index >= 0 && index < leetMap.length) {
                    leetText.append(leetMap[index]);
                } else {
                    leetText.append(c);
                }
            } else {
                leetText.append(c);
            }
        }

        return leetText.toString();
    }
}

