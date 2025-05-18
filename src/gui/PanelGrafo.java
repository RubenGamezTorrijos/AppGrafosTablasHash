// Panel grafo
package gui;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.awt.geom.Point2D;

class PanelGrafo extends JPanel {
    private int[][] grafo;
    private List<Integer> recorrido; 
    private final int RADIO_NODO = 20;

    public PanelGrafo() {
        setBackground(Color.WHITE);
        recorrido = new ArrayList<>();
    }

    public void setGrafo(int[][] grafo) {
        this.grafo = grafo;
        repaint();
    }

    public void resaltarRecorrido(List<Integer> recorrido) {
        this.recorrido = recorrido;
        repaint();
    }

    public void limpiarRecorrido() {
        recorrido.clear();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (grafo == null) return;

        int numVertices = grafo.length;
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        // Posiciones circulares
        Point[] posiciones = new Point[numVertices];
        for (int i = 0; i < numVertices; i++) {
            double angle = 2 * Math.PI * i / numVertices;
            int x = (int) (centerX + Math.cos(angle) * 150);
            int y = (int) (centerY + Math.sin(angle) * 150);
            posiciones[i] = new Point(x, y);
        }

        // Dibujar aristas
        g.setColor(Color.GRAY);
        for (int i = 0; i < numVertices; i++) {
            for (int j = i + 1; j < numVertices; j++) {
                if (grafo[i][j] > 0) {
                    g.drawLine(posiciones[i].x, posiciones[i].y, posiciones[j].x, posiciones[j].y);
                }
            }
        }

        // Dibujar nodos
        for (int i = 0; i < numVertices; i++) {
            Point p = posiciones[i];
            if (recorrido.contains(i)) {
                g.setColor(Color.RED);
            } else {
                g.setColor(Color.BLACK);
            }
            g.fillOval(p.x - RADIO_NODO, p.y - RADIO_NODO, 2 * RADIO_NODO, 2 * RADIO_NODO);
            g.setColor(Color.BLACK);
            g.drawString(String.valueOf(i), p.x - 4, p.y + 4);
        }
    }
}