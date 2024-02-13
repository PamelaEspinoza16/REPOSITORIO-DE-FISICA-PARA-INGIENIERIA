/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.conversionnotacion;

/**
 *
 * @author pamee
 */
import java.util.Scanner;

public class ConversionNotacion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario seleccionar la conversión
        System.out.println("Seleccione una opción:");
        System.out.println("1. De notación decimal a científica");
        System.out.println("2. De notación científica a decimal");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                // Conversión de decimal a científica
                System.out.print("Ingresa un número decimal: ");
                double decimal = scanner.nextDouble();
                String notacionCientificaDecimal = convertirANotacionCientifica(decimal);
                System.out.println("Notación Científica: " + notacionCientificaDecimal);
                break;

            case 2:
                // Conversión de científica a decimal
                System.out.print("Ingresa un número en notación científica (por ejemplo, 1.23e-4): ");
                String notacionCientifica = scanner.next();
                double decimalNotacionCientifica = convertirADecimal(notacionCientifica);
                System.out.println("Número Decimal: " + decimalNotacionCientifica);
                break;

            default:
                System.out.println("Opción no válida");
        }
    }

    private static String convertirANotacionCientifica(double numero) {
        // Verificar si el número es cero
        if (numero == 0) {
            return "0.0e0";
        }

        // Calcular el exponente
        int exponente = (int) Math.floor(Math.log10(Math.abs(numero)));

        // Calcular el coeficiente
        double coeficiente = numero / Math.pow(10, exponente);

        // Formatear la notación científica
        return String.format("%.1f", coeficiente) + "e" + exponente;
    }

    private static double convertirADecimal(String notacionCientifica) {
        // Dividir la notación científica en coeficiente y exponente
        String[] partes = notacionCientifica.toLowerCase().split("e");
        double coeficiente = Double.parseDouble(partes[0]);
        double exponente = Double.parseDouble(partes[1]);

        // Calcular el número decimal
        return coeficiente * Math.pow(10, exponente);
    }
}

