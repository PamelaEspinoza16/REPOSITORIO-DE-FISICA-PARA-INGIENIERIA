/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.programamatrices4;

/**
 *
 * @author pamee
 */
import java.util.Scanner;

public class ProgramaMatrices4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario el número de filas y columnas
        System.out.print("Ingrese el número de filas de la matriz: ");
        int filas = scanner.nextInt();
        System.out.print("Ingrese el número de columnas de la matriz: ");
        int columnas = scanner.nextInt();

        // Crear la matriz e ingresar sus elementos
        int[][] matriz = new int[filas][columnas];
        System.out.println("Ingrese los elementos de la matriz:");

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("Elemento en la posición [" + (i + 1) + "][" + (j + 1) + "]: ");
                matriz[i][j] = scanner.nextInt();
            }
        }

        // Mostrar información sobre la matriz
        System.out.println("\nInformación sobre la matriz:");
        mostrarTipoMatriz(matriz);
        calcularYMostrarTraza(matriz);
        mostrarPropiedades(matriz);

        // Calcular y mostrar el determinante usando la regla de Sarrus
        if (esCuadrada(matriz) && matriz.length == 3) {
            int determinanteSarrus = calcularDeterminanteSarrus(matriz);
            System.out.println("Determinante (regla de Sarrus): " + determinanteSarrus);
        }
    }

    private static void mostrarTipoMatriz(int[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;

        // Verificar si la matriz es cuadrada
        if (filas == columnas) {
            System.out.println("La matriz es cuadrada.");

            // Verificar si la matriz es simétrica
            boolean esSimetrica = true;
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    if (matriz[i][j] != matriz[j][i]) {
                        esSimetrica = false;
                        break;
                    }
                }
            }

            if (esSimetrica) {
                System.out.println("La matriz es simétrica.");
            }
        }

        // Verificar si la matriz es diagonal
        boolean esDiagonal = true;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (i != j && matriz[i][j] != 0) {
                    esDiagonal = false;
                    break;
                }
            }
        }

        if (esDiagonal) {
            System.out.println("La matriz es diagonal.");
        }

        // Verificar si la matriz es identidad
        boolean esIdentidad = true;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if ((i == j && matriz[i][j] != 1) || (i != j && matriz[i][j] != 0)) {
                    esIdentidad = false;
                    break;
                }
            }
        }

        if (esIdentidad) {
            System.out.println("La matriz es la matriz identidad.");
        }

        if (!esCuadrada(matriz) && !esDiagonal && !esIdentidad) {
            System.out.println("La matriz no cumple con ninguna propiedad especial.");
        }
    }

    private static void mostrarPropiedades(int[][] matriz) {
        System.out.println("\nPropiedades de la matriz:");

        // Verificar propiedad conmutativa
        boolean esConmutativa = verificarConmutativa(matriz);
        System.out.println("Propiedad conmutativa: " + (esConmutativa ? "Cumple" : "No cumple"));

        // Verificar propiedad asociativa
        boolean esAsociativa = verificarAsociativa(matriz);
        System.out.println("Propiedad asociativa: " + (esAsociativa ? "Cumple" : "No cumple"));

        // Verificar elemento neutro
        boolean tieneElementoNeutro = verificarElementoNeutro(matriz);
        System.out.println("Tiene elemento neutro: " + (tieneElementoNeutro ? "Sí" : "No"));

        // Verificar elemento opuesto
        boolean tieneElementoOpuesto = verificarElementoOpuesto(matriz);
        System.out.println("Tiene elemento opuesto: " + (tieneElementoOpuesto ? "Sí" : "No"));
    }

    private static boolean verificarConmutativa(int[][] matriz) {
        // Verificar si A * B = B * A para matrices cuadradas
        int filas = matriz.length;
        int columnas = matriz[0].length;

        if (filas == columnas) {
            int[][] matrizTranspuesta = obtenerMatrizTranspuesta(matriz);

            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    if (matriz[i][j] != matrizTranspuesta[i][j]) {
                        return false;
                    }
                }
            }
            return true;
        }

        return false;
    }

    private static boolean verificarAsociativa(int[][] matriz) {
        // Verificar si (A * B) * C = A * (B * C) para matrices cuadradas
        int filas = matriz.length;
        int columnas = matriz[0].length;

        if (filas == columnas) {
            int[][] matrizB = new int[filas][columnas];
            int[][] matrizC = new int[filas][columnas];

            // Crear matrices B y C con elementos aleatorios para la verificación
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    matrizB[i][j] = (int) (Math.random() * 10);
                    matrizC[i][j] = (int) (Math.random() * 10);
                }
            }

            int[][] resultado1 = multiplicarMatrices(multiplicarMatrices(matriz, matrizB), matrizC);
            int[][] resultado2 = multiplicarMatrices(matriz, multiplicarMatrices(matrizB, matrizC));

            // Verificar si (A * B) * C = A * (B * C)
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    if (resultado1[i][j] != resultado2[i][j]) {
                        return false;
                    }
                }
            }
            return true;
        }

        return false;
    }

    private static boolean verificarElementoNeutro(int[][] matriz) {
        // Verificar si existe una matriz identidad que cumple A * I = A
        int filas = matriz.length;
        int columnas = matriz[0].length;

        if (filas == columnas) {
            int[][] matrizIdentidad = obtenerMatrizIdentidad(filas);

            int[][] resultado = multiplicarMatrices(matriz, matrizIdentidad);

            // Verificar si A * I = A
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    if (matriz[i][j] != resultado[i][j]) {
                        return false;
                    }
                }
            }
            return true;
        }

        return false;
    }

    private static boolean verificarElementoOpuesto(int[][] matriz) {
        // Verificar si existe una matriz opuesta que cumple A + (-A) = 0
        int filas = matriz.length;
        int columnas = matriz[0].length;
        int[][] matrizOpuesta = obtenerMatrizOpuesta(matriz);

        int[][] resultado = sumarMatrices(matriz, matrizOpuesta);

        // Verificar si A + (-A) = 0
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (resultado[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int[][] obtenerMatrizTranspuesta(int[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;
        int[][] transpuesta = new int[columnas][filas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                transpuesta[j][i] = matriz[i][j];
            }
        }
        return transpuesta;
    }

    private static int[][] multiplicarMatrices(int[][] matrizA, int[][] matrizB) {
        int filasA = matrizA.length;
        int columnasA = matrizA[0].length;
        int columnasB = matrizB[0].length;

        int[][] resultado = new int[filasA][columnasB];

        for (int i = 0; i < filasA; i++) {
            for (int j = 0; j < columnasB; j++) {
                for (int k = 0; k < columnasA; k++) {
                    resultado[i][j] += matrizA[i][k] * matrizB[k][j];
                }
            }
        }
        return resultado;
    }

    private static int[][] obtenerMatrizIdentidad(int orden) {
        int[][] identidad = new int[orden][orden];

        for (int i = 0; i < orden; i++) {
            identidad[i][i] = 1;
        }
        return identidad;
    }

    private static int[][] obtenerMatrizOpuesta(int[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;
        int[][] opuesta = new int[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                opuesta[i][j] = -matriz[i][j];
            }
        }
        return opuesta;
    }

    private static void calcularYMostrarTraza(int[][] matriz) {
        int trazaPrincipal = 0;
        int trazaSecundaria = 0;

        for (int i = 0; i < matriz.length; i++) {
            trazaPrincipal += matriz[i][i];
            trazaSecundaria += matriz[i][matriz.length - i - 1];
        }

        System.out.println("\nTraza en diagonal principal: " + trazaPrincipal);
        System.out.println("Traza en diagonal secundaria: " + trazaSecundaria);
    }

    private static boolean esCuadrada(int[][] matriz) {
        return matriz.length == matriz[0].length;
    }

    private static int[][] sumarMatrices(int[][] matrizA, int[][] matrizB) {
        int filas = matrizA.length;
        int columnas = matrizA[0].length;
        int[][] resultado = new int[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado[i][j] = matrizA[i][j] + matrizB[i][j];
            }
        }
        return resultado;
    }

    private static int calcularDeterminanteSarrus(int[][] matriz) {
        int determinante = 0;

        if (matriz.length == 3 && matriz[0].length == 3) {
            determinante = matriz[0][0] * matriz[1][1] * matriz[2][2]
                    + matriz[0][1] * matriz[1][2] * matriz[2][0]
                    + matriz[0][2] * matriz[1][0] * matriz[2][1]
                    - matriz[0][2] * matriz[1][1] * matriz[2][0]
                    - matriz[0][1] * matriz[1][0] * matriz[2][2]
                    - matriz[0][0] * matriz[1][2] * matriz[2][1];
        }

        return determinante;
    }
}

