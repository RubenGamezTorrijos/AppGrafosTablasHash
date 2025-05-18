// Grafo.java
package grafo;

public class Grafo {
    private int[][] matrizAdyacencia;

    public Grafo(int[][] matriz) {
        this.matrizAdyacencia = matriz;
    }

    public void mostrarMatriz() {
        System.out.println("Matriz de Adyacencia:");
        for (int[] fila : matrizAdyacencia) {
            for (int valor : fila) {
                System.out.printf("%3d", valor);
            }
            System.out.println();
        }
        System.out.println();
    }

    public int[][] getMatriz() {
        return matrizAdyacencia;
    }
}