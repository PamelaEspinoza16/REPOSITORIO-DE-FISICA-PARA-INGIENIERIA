/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.resolucionecuaciones;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IdentificarGradoEcuacion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario ingresar una ecuación
        System.out.print("Ingrese una ecuación ordinaria: ");
        String ecuacion = scanner.nextLine();

        // Identificar y mostrar el grado de la ecuación
        int grado = identificarGrado(ecuacion);
        System.out.println("El grado de la ecuación es: " + grado);
    }

    private static int identificarGrado(String ecuacion) {
        // Utilizar una expresión regular para identificar los términos con potencias
        Pattern pattern = Pattern.compile("[+-]?\\d*\\*?\\*?x\\^?(\\d+)?");
        Matcher matcher = pattern.matcher(ecuacion);

        int gradoMaximo = 0;

        // Buscar y comparar las potencias para encontrar el grado máximo
        while (matcher.find()) {
            String potenciaStr = matcher.group(1);
            int potencia = (potenciaStr != null && !potenciaStr.isEmpty()) ? Integer.parseInt(potenciaStr) : 1;
            gradoMaximo = Math.max(gradoMaximo, potencia);
        }

        return gradoMaximo;
    }
}
