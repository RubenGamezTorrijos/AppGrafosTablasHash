// Ventana principal GUI
package gui;

import grafo.GeneradorGrafos;
import algoritmos.AlgoritmosBusqueda;
import algoritmos.CaminosMinimos;
import algoritmos.ArbolExpansionMinima;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.PrintStream;
import java.io.OutputStream;

public class VentanaPrincipal extends JFrame {
    private PanelGrafo panelGrafo;
    private JTextArea salida;
    private JTextField campoVertices, campoDensidad, campoInicio;

    private int[][] grafoActual;
    private int numVertices;
    private double densidad;
    private int inicio;

    public VentanaPrincipal() {
        setTitle("Grafos y Tablas Hash | Desarrollado por Rubén Gámez Torrijos (UEM-TPA)");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Configurar layout principal
        setLayout(new BorderLayout());

        // Panel lateral izquierdo: Botones de acciones + campos de entrada
        JPanel panelLateral = new JPanel();
        panelLateral.setLayout(new BoxLayout(panelLateral, BoxLayout.Y_AXIS));
        panelLateral.setBorder(BorderFactory.createTitledBorder("Acciones"));

        // Panel de botones
        JPanel panelBotones = new JPanel(new GridLayout(4, 1, 5, 5));
        JButton botonGenerar = new JButton("1. Generar Grafo");
        botonGenerar.addActionListener(this::generarGrafo);
        panelBotones.add(botonGenerar);

        JButton botonBFSDFS = new JButton("2. Ejecutar BFS/DFS");
        botonBFSDFS.addActionListener(this::ejecutarBFS_DFS);
        panelBotones.add(botonBFSDFS);

        JButton botonDJPRIM = new JButton("3. Ejecutar Dijkstra/Prim");
        botonDJPRIM.addActionListener(this::ejecutarDijkstra_Prim);
        panelBotones.add(botonDJPRIM);

        JButton botonLimpiar = new JButton("Borrar datos");
        botonLimpiar.addActionListener(this::limpiarDatos);
        panelBotones.add(botonLimpiar);

        panelLateral.add(panelBotones);
        panelLateral.add(Box.createRigidArea(new Dimension(0, 10)));

        // Panel de campos de entrada
        JPanel panelEntrada = new JPanel(new GridLayout(4, 2, 5, 5));
        panelEntrada.setBorder(BorderFactory.createTitledBorder("Datos del Grafo"));

        panelEntrada.add(new JLabel("Número de vértices (1-20):"));
        campoVertices = new JTextField();
        panelEntrada.add(campoVertices);

        panelEntrada.add(new JLabel("Densidad (0.0 - 1.0):"));
        campoDensidad = new JTextField();
        panelEntrada.add(campoDensidad);

        panelEntrada.add(new JLabel("Nodo inicio:"));
        campoInicio = new JTextField();
        panelEntrada.add(campoInicio);

        panelLateral.add(panelEntrada);

        // Panel central: Vista gráfica y resultados
        JPanel panelDivision = new JPanel(new GridLayout(1, 2, 10, 10));

        panelGrafo = new PanelGrafo();
        panelDivision.add(panelGrafo);

        salida = new JTextArea();
        salida.setEditable(false);
        JScrollPane scroll = new JScrollPane(salida);
        panelDivision.add(scroll);

        add(panelLateral, BorderLayout.WEST);
        add(panelDivision, BorderLayout.CENTER);
    }

    private void generarGrafo(ActionEvent e) {
        try {
            numVertices = Integer.parseInt(campoVertices.getText());
            densidad = Double.parseDouble(campoDensidad.getText());
            inicio = Integer.parseInt(campoInicio.getText());

            if (numVertices < 1 || numVertices > 20 || densidad < 0.0 || densidad > 1.0 || inicio < 0 || inicio >= numVertices) {
                JOptionPane.showMessageDialog(this, "¡Datos incorrectos! Vértices entre 1 y 20. Densidad entre 0.0 y 1.0. Nodo inicio válido.");
                return;
            }

            grafoActual = GeneradorGrafos.generarGrafoAleatorio(numVertices, densidad);
            panelGrafo.setGrafo(grafoActual);
            panelGrafo.repaint();

            salida.setText("Matriz de Adyacencia:\n");
            for (int[] fila : grafoActual) {
                for (int valor : fila) {
                    salida.append(String.format("%3d", valor));
                }
                salida.append("\n");
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, introduce valores válidos.");
        }
    }

    private void ejecutarBFS_DFS(ActionEvent e) {
        if (grafoActual == null) {
            JOptionPane.showMessageDialog(this, "Primero genere un grafo.");
            return;
        }

        try {
            inicio = Integer.parseInt(campoInicio.getText());
            if (inicio < 0 || inicio >= grafoActual.length) {
                JOptionPane.showMessageDialog(this, "Nodo de inicio inválido.");
                return;
            }

            panelGrafo.limpiarRecorrido();
            panelGrafo.repaint();

            salida.append("\n--- Recorrido BFS ---\n");
            salida.append("Recorrido desde nodo " + inicio + ":\n");
            salida.append(algoritmoToString(() -> AlgoritmosBusqueda.bfs(grafoActual, inicio)));
            panelGrafo.resaltarRecorrido(AlgoritmosBusqueda.obtenerRecorridoBFS(grafoActual, inicio));
            panelGrafo.repaint();

            salida.append("\n--- Recorrido DFS ---\n");
            salida.append("Recorrido desde nodo " + inicio + ":\n");
            salida.append(algoritmoToString(() -> AlgoritmosBusqueda.dfs(grafoActual, inicio)));
            panelGrafo.resaltarRecorrido(AlgoritmosBusqueda.obtenerRecorridoDFS(grafoActual, inicio));
            panelGrafo.repaint();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Introduce un nodo válido.");
        }
    }

    private void ejecutarDijkstra_Prim(ActionEvent e) {
        if (grafoActual == null) {
            JOptionPane.showMessageDialog(this, "Primero genere un grafo.");
            return;
        }

        try {
            inicio = Integer.parseInt(campoInicio.getText());
            if (inicio < 0 || inicio >= grafoActual.length) {
                JOptionPane.showMessageDialog(this, "Nodo de inicio inválido.");
                return;
            }

            panelGrafo.limpiarRecorrido();
            panelGrafo.repaint();

            salida.append("\n--- Algoritmo de Dijkstra ---\n");
            salida.append(algoritmoToString(() -> CaminosMinimos.dijkstra(grafoActual, inicio)));

            salida.append("\n--- Algoritmo de Prim ---\n");
            salida.append(algoritmoToString(() -> ArbolExpansionMinima.prim(grafoActual, inicio)));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Introduce un nodo válido.");
        }
    }

    // Redirige la salida del sistema a String
    private String algoritmoToString(Runnable algoritmo) {
        StringBuilder sb = new StringBuilder();
        PrintStream originalOut = System.out;

        OutputStream output = new OutputStream() {
            @Override
            public void write(byte[] bytes, int off, int len) {
                sb.append(new String(bytes, off, len));
            }

            @Override
            public void write(int b) {
                sb.append((char) b);
            }
        };

        System.setOut(new PrintStream(output));

        try {
            algoritmo.run();
        } finally {
            System.setOut(originalOut);
        }

        return sb.toString();
    }

    // 🔥 Método nuevo: limpiar datos
    private void limpiarDatos(ActionEvent e) {
        // Limpiar campos de texto
        campoVertices.setText("");
        campoDensidad.setText("");
        campoInicio.setText("");

        // Limpiar área de resultados
        salida.setText("");

        // Limpiar vista gráfica
        if (panelGrafo != null) {
            panelGrafo.limpiarRecorrido();
            panelGrafo.setGrafo(null); // Opcional: eliminar el grafo dibujado
            panelGrafo.repaint();
        }

        // Resetear grafo actual
        grafoActual = null;

        JOptionPane.showMessageDialog(this, "¡Datos borrados correctamente!");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VentanaPrincipal().setVisible(true);
        });
    }
}