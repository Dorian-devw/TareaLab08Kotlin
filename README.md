# 📱 TECSUP Campus

Proyecto desarrollado en **Kotlin** usando **Jetpack Compose**, correspondiente a la **Semana 08** del curso **Programación en Móviles** en TECSUP.

El objetivo del laboratorio es aplicar los conceptos de:
- Manejo de **Scaffold**
- Uso de **TopAppBar**
- Implementación de un **menú (⋮)**
- Creación de **Cards**
- Listas con **LazyColumn**
- Navegación entre pantallas con **Navigation Compose**

---

## 🧠 Descripción de la App

**TECSUP Campus** es una aplicación sencilla que permite visualizar información básica del campus, como:
- Cursos
- Instructores
- Eventos
- Acerca de la aplicación

La app está diseñada para ser **clara, funcional y comprensible**, ideal para practicar los fundamentos de Jetpack Compose en la octava semana del curso.

---

## 🧩 Estructura principal

app/
└─ src/
└─ main/
├─ java/com/example/tecsupcampus/MainActivity.kt
├─ res/
│ ├─ drawable/
│ │ ├─ imagen1.jpg
│ │ ├─ imagen2.jpg
│ │ └─ imagen3.jpg
│ └─ values/
│ └─ strings.xml


---

## ⚙️ Tecnologías utilizadas

| Tecnología | Descripción |
|-------------|-------------|
| **Kotlin** | Lenguaje principal de desarrollo |
| **Jetpack Compose** | UI declarativa moderna de Android |
| **Material 3** | Componentes visuales modernos (TopAppBar, Cards, etc.) |
| **Navigation Compose** | Navegación entre pantallas con NavHost y NavController |

---

## 🧭 Navegación y menú

La aplicación utiliza un **TopAppBar con tres puntos (⋮)** que abre un menú desplegable con las siguientes secciones:

- 🏠 **Inicio**
- 📘 **Cursos**
- 👩‍🏫 **Instructores**
- 📅 **Eventos**
- ℹ️ **Acerca de**

Cada opción cambia de pantalla mediante **Navigation Compose** y muestra un **Toast** indicando la sección abierta.

---

## 🖼️ Pantallas de la aplicación

### 🏠 Inicio
- Muestra tres **Cards** con acceso rápido a:
  - Cursos  
  - Instructores  
  - Eventos  

### 📘 Cursos
- Lista de cursos en un **LazyColumn** con Cards.
- Cada card muestra:
  - Imagen  
  - Nombre del curso  
  - Breve descripción  

### 👩‍🏫 Instructores
- Lista de instructores con su nombre, especialidad e imagen.

### 📅 Eventos
- Lista de eventos próximos (fecha, título y lugar).

### ℹ️ Acerca de
- Muestra la información básica del proyecto:
  - Nombre de la app  
  - Versión  
  - Autor  

---

## 🧠 Dependencias necesarias

En el archivo `build.gradle (Module: app)` agrega la siguiente línea:

```gradle
implementation("androidx.navigation:navigation-compose:2.8.0")
