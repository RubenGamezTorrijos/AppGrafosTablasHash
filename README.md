# AppGrafos

Aplicación de escritorio en Java para la generación, visualización y análisis de grafos, desarrollada como proyecto académico.
![image](https://github.com/user-attachments/assets/d72dc30e-18b5-4d16-b288-a31e4822e2fe)

---

## 📌 Características

- Generación automática de grafos aleatorios dirigidos o no dirigidos.
- Visualización gráfica de vértices y aristas.
- Representación visual interactiva mediante interfaz gráfica (Swing).
- Arquitectura basada en el patrón Modelo-Vista-Controlador (MVC).
- Preparada para la ejecución autónoma mediante `.jar` o `.bat`.

---

## 📁 Estructura del Proyecto

```
AppGrafos/
├── src/
│   ├── algoritmos/
│   ├── grafo/
│   ├── gui/
│   └── main/
├── build/
│   └── *.class
├── build-jar/
│   └── AppGrafos.jar
├── build_run.bat
└── README.md
```

---

## 🧱 Requisitos

- Java Development Kit (JDK) 17 o superior.
- Sistema operativo Windows, Linux o macOS.
- Editor o IDE recomendado: Visual Studio Code, IntelliJ IDEA o Eclipse.

---

## ▶️ Ejecución

### Opción 1: Ejecutar desde el `.jar`

```bash
java -jar build-jar/AppGrafos.jar
```

### Opción 2: Compilar y ejecutar desde el código fuente

```bash
javac -d build src/**/*.java
java -cp build main.Main
```

### Opción 3: Usar script `.bat` (Windows)

Haz doble clic en `build_run.bat` para compilar y ejecutar automáticamente.

---

## 🧠 Arquitectura

El proyecto está dividido en:

- `main`: Punto de entrada de la aplicación.
- `gui`: Interfaz gráfica con Swing.
- `grafo`: Modelo de datos del grafo (vértices y aristas).
- `algoritmos`: Implementaciones de algoritmos como BFS, DFS y generación de grafos.

---

## 🧪 Funcionalidad

1. Introducir número de vértices y densidad.
2. Pulsar “Generar Grafo”.
3. Visualizar nodos y conexiones en el panel gráfico.
4. Ejecutar futuros algoritmos de recorrido (en expansión).

---

## 📚 Créditos

Desarrollado por **Rubén [Tu Apellido]** para la asignatura **Proyecto de Informática 1** en la Universidad Autónoma de Madrid (UAM).

---

## 📄 Licencia

Este proyecto se distribuye bajo licencia educativa y sin fines comerciales.

---

## Preparación

Bienvenido al mundo de Java en VS Code. Aquí tienes una guía para ayudarte a empezar a escribir código Java en Visual Studio Code.

---

## Introducción

Bienvenido al mundo de Java en VS Code. Aquí tienes una guía para ayudarte a empezar a escribir código Java en Visual Studio Code.

---

## Estructura de carpetas

El espacio de trabajo contiene dos carpetas por defecto:

- `src`: la carpeta donde se guardan las fuentes
- `lib`: la carpeta donde se guardan las dependencias

Mientras tanto, los archivos de salida compilados se generarán en la carpeta `bin` por defecto.

> Si quieres personalizar la estructura de carpetas, abre `.vscode/settings.json` y actualiza la configuración correspondiente.

---

## Gestión de dependencias

La vista `JAVA PROJECTS` te permite gestionar tus dependencias. Puedes encontrar más detalles [aquí](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
