/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.cifradocesar;

/**
 *
 * @author pamee
 */
import java.util.Scanner;

public class  CifradoCesar{

    public static String cifrarCesar(String texto, int desplazamiento) {
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < texto.length(); i++) {
            char caracter = texto.charAt(i);

            if (Character.isLetter(caracter)) {
                char inicio = Character.isLowerCase(caracter) ? 'a' : 'A';
                caracter = (char) ((caracter - inicio + desplazamiento) % 26 + inicio);
            }

            resultado.append(caracter);
        }

        return resultado.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el texto a cifrar: ");
        String textoOriginal = scanner.nextLine();

        System.out.print("Introduce el desplazamiento: ");
        int desplazamiento = scanner.nextInt();

        String textoCifrado = cifrarCesar(textoOriginal, desplazamiento);

        System.out.println("Texto cifrado: " + textoCifrado);
    }
}