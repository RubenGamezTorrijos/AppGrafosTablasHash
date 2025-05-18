// GeneradorGrafos.java
package grafo;

import java.util.Random;

public class GeneradorGrafos {
    private static Random rand = new Random();

    public static int[][] generarGrafoAleatorio(int numVertices, double densidad) {
        int[][] grafo = new int[numVertices][numVertices];

        for (int i = 0; i < numVertices; i++) {
            for (int j = i + 1; j < numVertices; j++) {
                if (rand.nextDouble() <= densidad) {
                    int peso = rand.nextInt(10) + 1;
                    grafo[i][j] = peso;
                    grafo[j][i] = peso;
                } else {
                    grafo[i][j] = 0;
                    grafo[j][i] = 0;
                }
            }
        }

        return grafo;
    }

    public static int elegirTamañoAleatorio() {
        return rand.nextInt(20) + 1;
    }
}