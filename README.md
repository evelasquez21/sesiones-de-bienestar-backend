# Sesiones de bienestar
![Lenguaje](https://img.shields.io/badge/language-Java-blue)
![Framework](https://img.shields.io/badge/framework-Spring%20Boot-green)
![Base de Datos](https://img.shields.io/badge/database-PostgreSQL-blue)
![Base de Datos](https://img.shields.io/badge/database-H2-blue)

# Guía de Instalación y Ejecución: Servicio "Sesión de Bienestar"

Este documento describe los pasos necesarios para configurar y ejecutar el backend del sistema "Sesión de Bienestar".

El servicio está construido con **Spring Boot**, utiliza **PostgreSQL** como base de datos y está securizado con **Spring Security** y **JSON Web Tokens (JWT)**.

## 1. Prerrequisitos
Antes de comenzar, asegúrate de tener instalado el siguiente software:

* **JDK 17** (o superior): Spring Boot 3 requiere Java 17.
* **Apache Maven**: Para compilar el proyecto y gestionar las dependencias.
* **PostgreSQL**: El sistema de gestión de base de datos.
* **Un IDE**: Como NetBeans (usado en el desarrollo), IntelliJ IDEA o VS Code.
* **Postman**: Para probar la API.

## 2. Configuración del Proyecto
Sigue estos pasos para configurar el entorno de desarrollo.

### Paso 1: Obtener el Código Fuente
(Asumiendo que ya tienes el proyecto en tu máquina local).

### Paso 2: Configuración de la Base de Datos (PostgreSQL)
El servicio espera una base de datos PostgreSQL para conectarse.

1.  Abre `pgAdmin` o tu cliente de PostgreSQL preferido.
2.  Crea una nueva base de datos. Para este ejemplo, la llamaremos: `sesion_bienestar_db`.

    ```sql
    CREATE DATABASE sesion_bienestar_db;
    ```
3.  **Importante**: No necesitas crear las tablas manualmente. Spring Data JPA (Hibernate) las creará y gestionará automáticamente al iniciar la aplicación.

### Paso 3: Configurar las Variables de Entorno
Este es el paso más importante. Abre el archivo de configuración del proyecto:

**`src/main/resources/application.properties`**

Copia el siguiente contenido y **modifica los valores** para que coincidan con tu configuración local.

```properties
# ===================================================================
# CONFIGURACIÓN DEL SERVIDOR
# ===================================================================
# Puerto en el que correrá la aplicación
server.port=8080

# ===================================================================
# CONFIGURACIÓN DE LA BASE DE DATOS (POSTGRESQL)
# ===================================================================
# URL de conexión JDBC. Asegúrate de que el puerto (5432) y el nombre de la BD (sesion_bienestar_db) sean correctos.
spring.datasource.url=jdbc:postgresql://localhost:5432/sesion_bienestar_db

# Usuario de tu base de datos (por defecto es 'postgres')
spring.datasource.username=postgres

# Contraseña de tu base de datos (cámbiala por tu contraseña real)
spring.datasource.password=tu_contraseña_de_postgres

# Driver de PostgreSQL
spring.datasource.driver-class-name=org.postgresql.Driver

# ===================================================================
# CONFIGURACIÓN DE JPA/HIBERNATE
# ===================================================================
# (update) Actualiza el esquema de la BD al iniciar, creando tablas si no existen.
# (validate) Valida que el esquema coincida.
# (create-drop) Crea las tablas al inicio y las borra al final (útil para pruebas).
spring.jpa.hibernate.ddl-auto=update

# Muestra las consultas SQL en la consola (útil para depurar)
spring.jpa.properties.hibernate.show_sql=true
spring.jpa.properties.hibernate.format_sql=true

# Dialecto de PostgreSQL
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect

# ===================================================================
# CONFIGURACIÓN DE SEGURIDAD (JWT)
# ===================================================================
# Pega aquí la clave secreta en Base64 que generaste para firmar los tokens.
# Si no tienes una, genera una nueva (ver Manual Técnico, sección de JwtUtil).
jwt.secret.key=f3QoNnRoYXJldGhlYmVzdHNlY3JldGtleW5ldmVyISE=