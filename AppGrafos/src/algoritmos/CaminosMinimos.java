// CaminosMinimos
package algoritmos;

import java.util.*;

public class CaminosMinimos {

    public static void dijkstra(int[][] grafo, int inicio) {
        long tiempoInicio = System.nanoTime();

        int n = grafo.length;
        int[] distancias = new int[n];
        boolean[] visitado = new boolean[n];
        Arrays.fill(distancias, Integer.MAX_VALUE);
        distancias[inicio] = 0;

        PriorityQueue<Nodo> pq = new PriorityQueue<>(Comparator.comparingInt(nodo -> nodo.distancia));
        pq.offer(new Nodo(inicio, distancias[inicio]));

        while (!pq.isEmpty()) {
            Nodo actual = pq.poll();
            int u = actual.indice;

            if (visitado[u]) continue;
            visitado[u] = true;

            for (int v = 0; v < n; v++) {
                if (grafo[u][v] > 0 && !visitado[v]) {
                    int nuevaDistancia = distancias[u] + grafo[u][v];
                    if (nuevaDistancia < distancias[v]) {
                        distancias[v] = nuevaDistancia;
                        pq.offer(new Nodo(v, distancias[v]));
                    }
                }
            }
        }

        System.out.println("Resultado del algoritmo de Dijkstra desde el nodo " + inicio + ":");
        for (int i = 0; i < n; i++) {
            System.out.println("Nodo " + i + ": " + (distancias[i] == Integer.MAX_VALUE ? "Inaccesible" : distancias[i]));
        }

        System.out.println("Tiempo de ejecución: " + (System.nanoTime() - tiempoInicio) + " ns\n");
    }

    private static class Nodo {
        int indice;
        int distancia;

        public Nodo(int indice, int distancia) {
            this.indice = indice;
            this.distancia = distancia;
        }
    }
}