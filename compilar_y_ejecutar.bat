@echo off
REM Ruta raíz del proyecto (debe ejecutar este .bat en la carpeta raíz donde está src)

echo Compilando el proyecto...

REM Compilamos todo desde src con salida a build
javac -d build src\main\Main.java src\gui\VentanaPrincipal.java src\gui\PanelGrafo.java src\grafo\*.java src\algoritmos\*.java

REM Comprobar si javac tuvo errores
IF ERRORLEVEL 1 (
    echo.
    echo Error de compilación. Corrige los errores antes de ejecutar.
    pause
    exit /b 1
)

echo.
echo Compilacion correcta.
echo Ejecutando la aplicacion...

java -cp build main.Main

echo.
echo Creando JAR ejecutable...

REM Crear carpeta temporal para el jar
if not exist build-jar mkdir build-jar

REM Crear el manifiesto
echo Main-Class: main.Main > manifest.txt

REM Crear el JAR con todas las clases compiladas
jar cfm build-jar\AppGrafosTablasHash.jar manifest.txt -C build .

echo JAR creado en build-jar\AppGrafosTablasHash.jar

del manifest.txt

pause
