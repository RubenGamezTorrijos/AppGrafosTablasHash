// Arbol Expansión Mínima
package algoritmos;

import java.util.*;

public class ArbolExpansionMinima {

    public static void prim(int[][] grafo, int inicio) {
        long tiempoInicio = System.nanoTime();

        int n = grafo.length;
        int[] key = new int[n];
        int[] parent = new int[n];
        boolean[] mstSet = new boolean[n];

        Arrays.fill(key, Integer.MAX_VALUE);
        key[inicio] = 0;
        parent[inicio] = -1;

        PriorityQueue<Nodo> pq = new PriorityQueue<>(Comparator.comparingInt(nodo -> nodo.key));
        pq.offer(new Nodo(inicio, key[inicio]));

        while (!pq.isEmpty()) {
            int u = pq.poll().indice;

            if (mstSet[u]) continue;
            mstSet[u] = true;

            for (int v = 0; v < n; v++) {
                if (grafo[u][v] > 0 && !mstSet[v]) {
                    if (grafo[u][v] < key[v]) {
                        key[v] = grafo[u][v];
                        parent[v] = u;
                        pq.offer(new Nodo(v, key[v]));
                    }
                }
            }
        }

        System.out.println("Árbol de Expansión Mínima (Prim) desde el nodo " + inicio + ":");
        int total = 0;
        for (int i = 1; i < n; i++) {
            System.out.println(parent[i] + " - " + i + " : " + key[i]);
            total += key[i];
        }
        System.out.println("Peso total del MST: " + total);
        System.out.println("Tiempo de ejecución: " + (System.nanoTime() - tiempoInicio) + " ns\n");
    }

    private static class Nodo {
        int indice;
        int key;

        public Nodo(int indice, int key) {
            this.indice = indice;
            this.key = key;
        }
    }
}