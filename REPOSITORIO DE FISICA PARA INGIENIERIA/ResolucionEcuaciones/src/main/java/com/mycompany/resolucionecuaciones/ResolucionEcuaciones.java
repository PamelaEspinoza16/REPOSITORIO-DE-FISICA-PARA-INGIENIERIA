/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.resolucionecuaciones;

/**
 *
 * @author pamee
 */
import java.util.Scanner;

public class ResolucionEcuaciones {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario ingresar los coeficientes y términos independientes
        System.out.println("Ingrese las ecuaciones lineales en el formato ax + by = c:");
        System.out.print("Coeficiente a de la primera ecuación: ");
        double a1 = scanner.nextDouble();
        System.out.print("Coeficiente b de la primera ecuación: ");
        double b1 = scanner.nextDouble();
        System.out.print("Término independiente c de la primera ecuación: ");
        double c1 = scanner.nextDouble();

        System.out.print("Coeficiente a de la segunda ecuación: ");
        double a2 = scanner.nextDouble();
        System.out.print("Coeficiente b de la segunda ecuación: ");
        double b2 = scanner.nextDouble();
        System.out.print("Término independiente c de la segunda ecuación: ");
        double c2 = scanner.nextDouble();

        // Resolver el sistema de ecuaciones
        System.out.println("Método de Igualación:");
        resolverPorIgualacion(a1, b1, c1, a2, b2, c2);

        System.out.println("\nMétodo de Sustitución:");
        resolverPorSustitucion(a1, b1, c1, a2, b2, c2);

        System.out.println("\nMétodo de Reducción:");
        resolverPorReduccion(a1, b1, c1, a2, b2, c2);
    }

    private static void resolverPorIgualacion(double a1, double b1, double c1, double a2, double b2, double c2) {
        double y = (c1 * a2 - c2 * a1) / (b1 * a2 - b2 * a1);
        double x = (c1 - b1 * y) / a1;
        System.out.println("Solución: x = " + x + ", y = " + y);
    }

    private static void resolverPorSustitucion(double a1, double b1, double c1, double a2, double b2, double c2) {
        double y = (c1 * a2 - c2 * a1) / (b1 * a2 - b2 * a1);
        double x = (c1 - b1 * y) / a1;
        System.out.println("Solución: x = " + x + ", y = " + y);
    }

    private static void resolverPorReduccion(double a1, double b1, double c1, double a2, double b2, double c2) {
        double x = (c1 * b2 - c2 * b1) / (a1 * b2 - a2 * b1);
        double y = (c1 - a1 * x) / b1;
        System.out.println("Solución: x = " + x + ", y = " + y);
    }
}
