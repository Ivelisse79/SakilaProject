# SakilaProject - Proyecto Final Java Programming (JP INF514) 

**Universidad Autónoma de Santo Domingo**  
**Facultad de Ciencias - Escuela de Informática**  
**INF514 Z06 2021-10**  
**Autor:** Ivelisse Alfonseca  

---------

## Descripción

SakilaProject es un sistema de gestión de renta de películas desarrollado en **Java** con conexión a la base de datos **MySQL Sakila**. Implementa el patrón de diseño **MVC (Modelo-Vista-Controlador)** con una arquitectura orientada a objetos que incluye interfaces, clases abstractas y clases concretas.

---

##  Tecnologías Utilizadas

| Tecnología | Versión | Uso                  |
|-----------|---------|-----------------------|
| Java      | JDK 26  | Lenguaje principal    |
| MySQL     | 8.0.46  | Base de datos         |
| MySQL Workbench | 8.0| Administración de BD |
| Eclipse IDE     | 2026 | Entorno de desarrollo |
| MySQLConnector/J | 9.7.0 | Conexión Java-MySQL |

---

##  Estructura del Proyecto

SakilaProject/
└── src/
    └── com/
        └── sakila/
            ├── data/
            │   ├── Conexion.java
            │   ├── DataContext.java (abstract)
            │   ├── IDataPost.java (interface)
            │   ├── ActorDAO.java
            │   ├── FilmDAO.java
            │   ├── CustomerDAO.java
            │   ├── RentalDAO.java
            │   ├── PaymentDAO.java
            │   └── InventoryDAO.java
            ├── models/
            │   ├── Actor.java
            │   ├── Film.java
            │   ├── Customer.java
            │   ├── Rental.java
            │   ├── Payment.java
            │   └── Inventory.java
            ├── controllers/
            │   ├── ActorController.java
            │   ├── FilmController.java
            │   ├── CustomerController.java
            │   ├── RentalController.java
            │   ├── PaymentController.java
            │   └── InventoryController.java
            ├── views/
            │   ├── MenuPrincipal.java
            │   ├── MenuActor.java
            │   ├── MenuFilm.java
            │   ├── MenuCustomer.java
            │   ├── MenuRental.java
            │   ├── MenuInventory.java
            │   ├── MenuPayment.java
            │   └── MenuReportes.java
            └── reports/
                └── ReporteGeneral.java

-----------------------

### Diagrama de Jerarquía de Clases

«interface»
IDataPost<T>
    |
    ↑ implements
    |
«abstract»
DataContext
    |
    ↑ extends
    |
    ├── ActorDAO (final)
    ├── FilmDAO (final)
    ├── CustomerDAO (final)
    ├── RentalDAO (final)
    ├── PaymentDAO (final)
    └── InventoryDAO (final)


### Patrón MVC


Vista (views)          Controlador (controllers)      Modelo (models/data)
─────────────          ─────────────────────────      ───────────────────
MenuPrincipal    →     ActorController          →     ActorDAO → MySQL
MenuActor        →     FilmController           →     FilmDAO  → MySQL
MenuFilm         →     CustomerController       →     CustomerDAO → MySQL
...              →     ...                      →     ...




##  Requisitos Previos

Antes de ejecutar el proyecto necesitas tener instalado:

1. **Java JDK 8 o superior**
   - Descarga: https://www.oracle.com/java/technologies/downloads/

2. **MySQL Server 8.0+**
   - Descarga: https://dev.mysql.com/downloads/installer/

3. **MySQL Workbench**
   - Incluido en el instalador de MySQL

4. **Eclipse IDE**
   - Descarga: https://www.eclipse.org/downloads/

5. **MySQL Connector/J**
   - Descarga: https://dev.mysql.com/downloads/connector/j/

--------------

##  Instalación y Configuración:

### Paso 1: Configurar la Base de Datos

1. Abre **MySQL Workbench**
2. Conéctate con tu usuario `root`
3. Verifica que la base de datos **Sakila** esté disponible:
    sql
SHOW DATABASES;

4. Confirma que tiene datos:
    sql
SELECT * FROM sakila.actor LIMIT 5;


### Paso 2: Configurar el Proyecto en Eclipse

1. Abre **Eclipse IDE**
2. Importa el proyecto:
   
   File → Import → Git → Projects from Git → Clone URI
   
3. Pega la URL del repositorio:
   
   https://github.com/Ivelisse79/SakilaProject.git
   

### Paso 3: Agregar el MySQL Connector

1. Haz clic derecho sobre el proyecto
2. Selecciona:
   
   Build Path → Configure Build Path → Libraries → Add External JARs
   
3. Selecciona el archivo: mysql-connector-j-9.7.0.jar

### Paso 4: Configurar la Conexión

Abre el archivo: "src/com/sakila/data/Conexion.java" y ajusta:

```java
private static final String URL = "jdbc:mysql://localhost:3306/sakila";
private static final String USUARIO = "root";
private static final String CONTRASENA = "tuContraseña"; // ← cambia esto
```

### Paso 5: Ejecutar el Sistema

1. Abre: src/com/sakila/views/MenuPrincipal.java
2. Haz clic derecho → `Run As → Java Application`

-----------

## 💻 Uso del Sistema

Al ejecutar el programa verás el menú principal:

```
========================================
   SISTEMA DE RENTA DE PELICULAS SAKILA
========================================
1. Gestión de Actores
2. Gestión de Películas
3. Gestión de Clientes
4. Gestión de Rentas
5. Gestión de Inventario
6. Gestión de Pagos
7. Reportes y Estadísticas
0. Salir
Seleccione una opción:
```

### Operaciones CRUD disponibles

Cada módulo permite:

| Operación | Descripción |
|-----------|-------------|
| **Listar** | Muestra todos los registros |
| **Buscar** | Busca por ID |
| **Agregar** | Crea un nuevo registro |
| **Actualizar** | Modifica un registro existente |
| **Eliminar** | Elimina un registro |

### Reportes y Estadísticas


=== REPORTES Y ESTADÍSTICAS ===
1. Listar tabla y exportar CSV
2. Listar tabla y exportar JSON
3. Top 10 películas en inventario
4. Top 10 clientes con más rentas
5. Top 10 clientes por pagos
6. Top 10 actores con más películas

---

## 🗄️ Modelos de Datos

### Actor
| Campo | Tipo | Descripción |
|-------|------|-------------|
| actorId | int | ID único (PK) |
| firstName | String | Nombre |
| lastName | String | Apellido |
| lastUpdate | String | Fecha actualización |

### Film
| Campo | Tipo | Descripción |
|-------|------|-------------|
| filmId | int | ID único (PK) |
| title | String | Título |
| description | String | Descripción |
| releaseYear | int | Año de lanzamiento |
| languageId | int | ID del idioma (FK) |
| rentalDuration | int | Duración de renta |
| rentalRate | double | Precio de renta |
| replacementCost | double | Costo de reemplazo |
| rating | String | Clasificación |

### Customer
| Campo | Tipo | Descripción |
|-------|------|-------------|
| customerId | int | ID único (PK) |
| storeId | int | ID de tienda (FK) |
| firstName | String | Nombre |
| lastName | String | Apellido |
| email | String | Correo electrónico |
| addressId | int | ID de dirección (FK) |
| active | boolean | Estado activo |

### Rental
| Campo | Tipo | Descripción |
|-------|------|-------------|
| rentalId | int | ID único (PK) |
| rentalDate | String | Fecha de renta |
| inventoryId | int | ID inventario (FK) |
| customerId | int | ID cliente (FK) |
| returnDate | String | Fecha devolución |
| staffId | int | ID empleado (FK) |

### Payment
| Campo | Tipo | Descripción |
|-------|------|-------------|
| paymentId | int | ID único (PK) |
| customerId | int | ID cliente (FK) |
| staffId | int | ID empleado (FK) |
| rentalId | int | ID renta (FK) |
| amount | double | Monto |
| paymentDate | String | Fecha de pago |

### Inventory
| Campo | Tipo | Descripción |
|-------|------|-------------|
| inventoryId | int | ID único (PK) |
| filmId | int | ID película (FK) |
| storeId | int | ID tienda (FK) |

---

##  Exportación de Datos

El sistema permite exportar cualquier tabla a:

- **CSV**: `nombreTabla.csv`
- **JSON**: `nombreTabla.json`

Los archivos se guardan en el directorio raíz del proyecto.

-------

##  Normas de Desarrollo

-  Documentación Javadoc en todas las clases y métodos
-  Paquete general `com.sakila` dividido en subpaquetes
-  Uso de `ArrayList` y `HashMap` para colecciones
-  Respeto de llaves primarias (autoincrement) y foráneas
-  Patrón MVC implementado
-  Interface `IDataPost` como estándar CRUD
-  Clase abstracta `DataContext` con métodos `final`

-
