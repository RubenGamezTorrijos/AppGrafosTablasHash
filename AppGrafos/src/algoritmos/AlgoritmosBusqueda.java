// AlgoritmosBusqueda.java
package algoritmos;

import java.util.*;

public class AlgoritmosBusqueda {

    public static void bfs(int[][] grafo, int inicio) {
        long tiempoInicio = System.nanoTime();

        int n = grafo.length;
        boolean[] visitado = new boolean[n];
        Queue<Integer> cola = new LinkedList<>();

        visitado[inicio] = true;
        cola.offer(inicio);

        System.out.println("Recorrido BFS desde el nodo " + inicio + ":");

        while (!cola.isEmpty()) {
            int actual = cola.poll();
            System.out.print(actual + " ");

            for (int i = 0; i < n; i++) {
                if (grafo[actual][i] > 0 && !visitado[i]) {
                    visitado[i] = true;
                    cola.offer(i);
                }
            }
        }

        System.out.println("\nTiempo de ejecución: " + (System.nanoTime() - tiempoInicio) + " ns\n");
    }

    public static void dfs(int[][] grafo, int inicio) {
        long tiempoInicio = System.nanoTime();

        int n = grafo.length;
        boolean[] visitado = new boolean[n];
        Stack<Integer> pila = new Stack<>();

        pila.push(inicio);
        System.out.println("Recorrido DFS desde el nodo " + inicio + ":");

        while (!pila.isEmpty()) {
            int actual = pila.pop();
            if (!visitado[actual]) {
                visitado[actual] = true;
                System.out.print(actual + " ");
                // Agregar en orden inverso para mantener el recorrido DFS correcto
                for (int i = n - 1; i >= 0; i--) {
                    if (grafo[actual][i] > 0 && !visitado[i]) {
                        pila.push(i);
                    }
                }
            }
        }

        System.out.println("\nTiempo de ejecución: " + (System.nanoTime() - tiempoInicio) + " ns\n");
    }

    public static List<Integer> obtenerRecorridoBFS(int[][] grafo, int inicio) {
        int n = grafo.length;
        boolean[] visitado = new boolean[n];
        Queue<Integer> cola = new LinkedList<>();
        List<Integer> recorrido = new ArrayList<>();

        visitado[inicio] = true;
        cola.offer(inicio);

        while (!cola.isEmpty()) {
            int actual = cola.poll();
            recorrido.add(actual);

            for (int i = 0; i < n; i++) {
                if (grafo[actual][i] > 0 && !visitado[i]) {
                    visitado[i] = true;
                    cola.offer(i);
                }
            }
        }

        return recorrido;
    }

    public static List<Integer> obtenerRecorridoDFS(int[][] grafo, int inicio) {
        int n = grafo.length;
        boolean[] visitado = new boolean[n];
        Stack<Integer> pila = new Stack<>();
        List<Integer> recorrido = new ArrayList<>();

        pila.push(inicio);

        while (!pila.isEmpty()) {
            int actual = pila.pop();
            if (!visitado[actual]) {
                visitado[actual] = true;
                recorrido.add(actual);

                for (int i = n - 1; i >= 0; i--) {
                    if (grafo[actual][i] > 0 && !visitado[i]) {
                        pila.push(i);
                    }
                }
            }
        }

        return recorrido;
    }
}