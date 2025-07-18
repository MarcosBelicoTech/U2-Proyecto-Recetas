# U2-Proyecto-Recetas
# 🍲 Generador de Recetas de Cocina Personalizadas

Universidad Politécnica De Victoria  
⮕Ingeniería En Tecnologías De La Información  
⮕Materia: Programación Orientada A Objetos  
⮕Grupo: ITI 6-1  
⮕Periodo: Mayo – Agosto 2025  
⮕Ciudad Victoria, Tamaulipas**

## 🧑‍💻 Integrantes

- Marcos García Vázquez  
- Salvador de la Garza Cavazos  
- **Docente**: M.I. Lidia Ivaanery García Juárez  

---

## 📌 Descripción del Proyecto

Este sistema permite generar recetas de cocina basadas en los ingredientes disponibles y las **preferencias alimenticias** del usuario. Utiliza Java y la biblioteca Swing para crear una interfaz gráfica que facilita la selección de ingredientes y preferencias como:

- Vegano
- Sin gluten
- Sin lactosa
- Sin restricciones

El algoritmo filtra las recetas compatibles y muestra resultados personalizados.

---

## 🧠 Justificación y Algoritmo

### ¿Por qué este algoritmo?

Se usó un algoritmo de **búsqueda y filtrado** simple, ideal para comparar ingredientes seleccionados con los necesarios por cada receta. Es rápido, escalable y fácil de entender.

### Complejidad Computacional

> **O(n × m)**  
Donde `n` es el número de recetas y `m` el número de ingredientes por receta. El sistema compara cada ingrediente con los disponibles.

### Aplicación Real

Este algoritmo es útil para:

- Apps de cocina personalizadas
- Programas de nutrición
- Personas con alergias o restricciones dietéticas

## 📂 Explicación del Código

### 🔸 `GeneradorRecetasUnico.java`
Clase principal. Inicia la interfaz gráfica, gestiona ingredientes y preferencias, y ejecuta el algoritmo que genera las recetas compatibles.

- Usa Swing (`JFrame`, `JPanel`, `JButton`, `JToggleButton`)
- Contiene la lista de objetos `Receta`
- Filtra las recetas según ingredientes seleccionados

### 🔸 `Receta.java`
Clase modelo de una receta de cocina. Contiene:

- Nombre
- Ingredientes
- Tiempo de preparación
- Porciones
- Nivel de dificultad
- Restricción alimenticia (vegano, sin gluten, etc.)
- Pasos detallados

### 🔸 `RecetaDialog.java`
Subclase de `JDialog`. Muestra una receta completa en una ventana modal con los detalles seleccionados por el usuario.

---

## 🧰 Estructuras de Datos Utilizadas

- `ArrayList` para listas dinámicas de recetas e ingredientes  
- `LinkedHashMap` para mantener el orden de categorías  
- `ButtonGroup` para agrupar opciones de preferencia alimenticia  

---

## 📚 Librerías Usadas

- **Java Swing**: Para construir la interfaz gráfica
- `JFrame`, `JPanel`, `JButton`, `JToggleButton`, `JList`, `JDialog`
- `ActionListener`, `ItemListener`: Para capturar eventos

---

## 💻 Ejecución del Programa

### ✔️ Requisitos

- Java JDK 8 o superior
- Cualquier IDE como IntelliJ, NetBeans, Eclipse, o terminal con `javac`

### ⚙️ Pasos para compilar y ejecutar

bash
# 1. Clonar el repositorio
git clone https://github.com/usuario/U2-Proyecto-Recetas.git
cd U2-Proyecto-Recetas

# 2. Compilar el código
javac src/*.java

# 3. Ejecutar el programa
java -cp src GeneradorRecetasUnico

🧪 Pruebas Realizadas
Verificación de filtrado correcto de recetas con ingredientes válidos

Pruebas con diferentes combinaciones de preferencias (vegano, sin gluten, etc.)

Validación de interfaz gráfica

Revisión del funcionamiento de los botones y eventos

🖼️ Capturas de Pantalla
Selección de ingredientes y preferencias

Lista de recetas generadas

Vista detallada de una receta

✅ Conclusiones
Este proyecto logra generar recetas personalizadas eficientemente con una interfaz gráfica intuitiva. El algoritmo empleado es simple pero funcional para el contexto de selección por ingredientes y restricciones alimenticias.

Swing fue una buena elección por su facilidad de uso y su integración directa con Java.

## 🏗️ Estructura del Proyecto

U2-Proyecto-Recetas/
├── README.md                 # Documentación del proyecto
├── /src/                    # Código fuente en Java
│   ├── GeneradorRecetasUnico.java  # Clase principal con GUI y lógica del programa
│   ├── Receta.java                 # Clase modelo de receta
│   └── RecetaDialog.java          # Ventana modal para mostrar recetas
├── /resources/              # Recursos estáticos (opcional)
│   └── ingredientes.png           # Imágenes o íconos de la interfaz
├── /docs/                   # Documentación adicional y capturas
│   ├── Reporte_Proyecto.pdf       # Reporte técnico en PDF
│   ├── Diagrama_Clases.png        # Diagrama UML de clases
│   └── Instrucciones_Instalacion.txt # Instrucciones complementarias
├── /test/                   # Pruebas del sistema
│   └── pruebas.txt               # Casos de prueba manuales
├── .gitignore               # Archivos ignorados por Git
└── build/                   # Carpeta de compilación (opcional si usas IDE)


📚 Referencias
Documentación de Java: https://docs.google.com/document/d/1ExIDcHN4Zw6xvEa4iLns8wox2-6f5fTTTWbI6rgp3uU/edit?usp=sharing

Tutorial oficial de Swing: https://docs.oracle.com/javase/tutorial/uiswing/

Algoritmos de filtrado de datos aplicados a cocina y nutrición

Repositorio GitHub: [U2-Proyecto-Recetas](https://github.com/MarcosBelicoTech/U2-Proyecto-Recetas.git)
