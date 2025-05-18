/**
 * ---------------------------------------------------------------
 * Proyecto: Juego Héroes y Villanos - Árboles y Grafos
 * Autor: Rubén Gámez Torrijos
 * Fecha de creación: 12 de mayo de 2025
 * Versión: 1.0.0
 *
 * Descripción:
 * Aplicación desarrollada en Java+JavaFX como proyecto educativo.
 * Permite jugar como héroes o villanos, recorriendo estructuras
 * tipo árbol y grafo. Incluye interfaz gráfica y lógica de juego.
 * Se podrá seleccionar 1 un jugador contra la máquina o 2 jugadores.
 *
 * Universidad: Universidad Europea Madrid
 * Asignatura: Técnicas de Programación Avanzada (TPA)
 * Actividad: 2 Grafos y Tablas
 * Profesor: Gonzalo Bláquez Gil
 *
 * ---------------------------------------------------------------
 */
// Main.java - Punto de entrada principal que ejecuta la ventana gráfica
package main;

import gui.VentanaPrincipal;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Lanzar la interfaz gráfica en la ruta correcta (Event Dispatch Thread)
        SwingUtilities.invokeLater(() -> {
            VentanaPrincipal ventana = new VentanaPrincipal();
            ventana.setVisible(true);
        });
    }
}