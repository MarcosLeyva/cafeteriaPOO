# Documentación Técnica — Sistema de Punto de Venta para Cafetería

> Documento de referencia para la redacción del reporte IEEE.  
> Proyecto final de Programación Orientada a Objetos.

---

## 1. Descripción General del Sistema

El sistema es una aplicación de escritorio desarrollada en Java que simula el punto de venta (POS) de una cafetería. Permite a los usuarios navegar un catálogo de productos (bebidas y alimentos), agregar artículos a un carrito de compras, revisar el resumen con cálculo de IVA y finalizar la compra. El sistema persiste todos los datos en una base de datos MariaDB.

**Tipo de aplicación:** Desktop GUI  
**Paradigma:** Programación Orientada a Objetos  
**Lenguaje:** Java 21  
**GUI Framework:** Java Swing con AbsoluteLayout (NetBeans GUI Builder)  
**Base de datos:** MariaDB 11.8  
**Infraestructura:** Docker / Docker Compose  

---

## 2. Objetivos del Sistema

- Proveer una interfaz gráfica intuitiva para la gestión de pedidos en una cafetería.
- Implementar autenticación de usuarios con registro y validación contra base de datos.
- Gestionar un catálogo de 18 bebidas (con 3 tamaños) y 14 alimentos con precios individuales.
- Calcular automáticamente el IVA del 16% sobre el subtotal del carrito.
- Registrar el historial de pedidos finalizados por usuario en base de datos.
- Demostrar el uso de conceptos de POO: herencia, encapsulamiento, polimorfismo y patrones de diseño.

---

## 3. Stack Tecnológico

| Componente | Tecnología | Versión |
|---|---|---|
| Lenguaje | Java (OpenJDK) | 21 |
| GUI | Java Swing + AbsoluteLayout | NetBeans 23 |
| Build tool | Apache Ant | — |
| Base de datos | MariaDB | 11.8.6 |
| Driver JDBC | mariadb-java-client | incluido en `lib/` |
| Contenedor BD | Docker / Docker Compose | — |
| Control de versiones | Git | — |

---

## 4. Arquitectura del Sistema

### 4.1 Diagrama de Flujo de Pantallas

```
PROYECTO_ORDINARIO (main)
  └─ Limpia tabla carrito en BD
  └─ Inicio (pantalla de bienvenida / login)
       ├─ [Iniciar sesión]  → valida contra BD → Pantalla_Principal(invitado=false)
       ├─ [Invitado]        → Pantalla_Principal(invitado=true)
       └─ [Crear cuenta]    → CrearCuenta (JFrame modal manual)

Pantalla_Principal (catálogo de productos)
  ├─ [bebida1..18]   → consulta BD → BEBIDAS(nombre, desc, pG, pM, pP, imagen, frame)
  ├─ [alimento1..14] → consulta BD → ALIMENTOS(nombre, desc, precio, imagen, frame)
  └─ [Carrito]       → CARRITO

BEBIDAS (detalle de bebida)
  ├─ Selección de tamaño: Grande / Mediano / Pequeño con contadores ±
  └─ [COMPRAR] → INSERT INTO carrito → regresa a Pantalla_Principal

ALIMENTOS (detalle de alimento)
  ├─ Contador de cantidad ±
  └─ [COMPRAR] → INSERT INTO carrito → regresa a Pantalla_Principal

CARRITO (resumen de compra)
  ├─ Lee SELECT FROM carrito y construye paneles CarritoProducto
  ├─ Muestra subtotal, IVA (16%) y total
  └─ [Finalizar compra] → INSERT INTO pedidos + detalle_pedido → limpia carrito
```

### 4.2 Jerarquía de Clases

```
javax.swing.JFrame
  ├─ Inicio                  — Pantalla de login y bienvenida
  ├─ Pantalla_Principal      — Catálogo de productos
  ├─ BEBIDAS                 — Detalle y selección de bebida
  ├─ ALIMENTOS               — Detalle y selección de alimento
  ├─ CARRITO                 — Resumen del carrito con IVA
  └─ CrearCuenta             — Formulario de registro de usuario

javax.swing.JPanel
  └─ CarritoProducto         — Componente visual por ítem en el carrito

javax.swing.JButton
  └─ Boton_producto          — Botón personalizado con imagen de producto

Clases de servicio / utilería:
  ├─ DBConexion              — Singleton de conexión JDBC a MariaDB
  ├─ DBInit                  — Inicialización de tablas y siembra de productos
  ├─ IconManager             — Caché de íconos escalados (Flyweight pattern)
  └─ Sesion                  — Estado global de sesión (usuario actual)
```

---

## 5. Descripción de Clases

### 5.1 `PROYECTO_ORDINARIO`
Punto de entrada (`main`). Llama a `DBInit.inicializar()` para crear/verificar las tablas y siembra de productos, limpia la tabla `carrito` con `DELETE FROM carrito`, y lanza la pantalla `Inicio`.

### 5.2 `Inicio`
Pantalla de bienvenida. Contiene campos de texto para usuario y contraseña, y tres botones:
- **Iniciar sesión:** Valida contra `SELECT FROM usuarios WHERE usuario=? AND contrasena=?`. Si es exitoso establece `Sesion.usuario` y abre `Pantalla_Principal(invitado=false)`.
- **Invitado:** Establece `Sesion.usuario = "invitado"` y abre `Pantalla_Principal(invitado=true)`.
- **Crear cuenta:** Deshabilita `Inicio` y abre `CrearCuenta`.

### 5.3 `Pantalla_Principal`
Catálogo principal con 18 botones de bebidas y 14 de alimentos (todos con ícono, sin texto). Cada botón ejecuta `abrirBebida(nombre)` o `abrirAlimento(nombre)`, que consulta la BD y construye el objeto de detalle correspondiente. El parámetro `invitado` controla la visibilidad del botón "Log in".

### 5.4 `BEBIDAS`
Pantalla de detalle de bebida. Constructor recibe: `nombre`, `descripcion`, `preciog`, `preciom`, `preciop`, `imagen`, `frame` (referencia al padre para re-habilitar al cerrar). Tiene contadores independientes para cada tamaño (Grande/Mediano/Pequeño). El botón COMPRAR calcula el subtotal según la selección y hace `INSERT INTO carrito`.

### 5.5 `ALIMENTOS`
Pantalla de detalle de alimento. Constructor recibe: `nombre`, `descripcion`, `precio`, `imagen`, `frame`. Tiene un único contador de cantidad. El subtotal es `precio × cantidad`. El botón COMPRAR hace `INSERT INTO carrito`.

### 5.6 `CARRITO`
Lee `SELECT nombre_producto, subtotal, imagen FROM carrito ORDER BY id` y construye un panel `CarritoProducto` por cada fila. Calcula:
```
iva   = subtotal_total × 0.16
total = subtotal_total + iva
```
El botón "Finalizar compra" inserta en `pedidos` y `detalle_pedido`, luego limpia la tabla `carrito`.

### 5.7 `CarritoProducto`
Subclase de `JPanel`. Representa visualmente un producto en el carrito: ícono, nombre, precio unitario y subtotal. Expone campos públicos `nombres` y `subtotal` para que `CARRITO.recalcular()` los lea.

### 5.8 `CrearCuenta`
Formulario de registro. Recibe referencia al `Inicio` padre para re-habilitarlo al cerrar. Al confirmar hace `INSERT INTO usuarios (nombre, usuario, contrasena)`. Contraseña almacenada en texto plano.

### 5.9 `DBConexion`
Singleton de conexión JDBC. Mantiene una única instancia de `Connection` reutilizada en toda la aplicación.
```
URL:  jdbc:mariadb://localhost:3306/cafeteria
USER: root
```

### 5.10 `DBInit`
Crea las tablas si no existen y siembra los 18 productos de bebidas y 14 de alimentos en la primera ejecución (`SELECT COUNT(*) FROM productos > 0` evita re-siembra).

### 5.11 `IconManager`
Implementa el patrón **Flyweight**: mantiene un `HashMap<String, ImageIcon>` como caché. Todas las imágenes se escalan a 80×80 px con `Image.SCALE_SMOOTH` antes de almacenarse.

### 5.12 `Sesion`
Clase utilitaria con un único campo estático `public static String usuario`. Actúa como estado global de sesión compartido entre pantallas.

---

## 6. Modelo de Base de Datos

### 6.1 Esquema ER (tablas)

```
usuarios
  ├─ id           INT PK AUTO_INCREMENT
  ├─ nombre       VARCHAR(100) NOT NULL
  ├─ usuario      VARCHAR(50)  UNIQUE NOT NULL
  └─ contrasena   VARCHAR(255) NOT NULL

productos
  ├─ id           INT PK AUTO_INCREMENT
  ├─ nombre       VARCHAR(100) NOT NULL
  ├─ descripcion  TEXT
  ├─ categoria    ENUM('bebida','alimento') NOT NULL
  ├─ precio_g     DOUBLE   — precio Grande (bebidas)
  ├─ precio_m     DOUBLE   — precio Mediano (bebidas)
  ├─ precio_p     DOUBLE   — precio Pequeño (bebidas)
  ├─ precio       DOUBLE   — precio único (alimentos)
  └─ imagen       VARCHAR(50) NOT NULL

carrito                    — tabla de sesión, se limpia al iniciar la app
  ├─ id                INT PK AUTO_INCREMENT
  ├─ nombre_producto   VARCHAR(100) NOT NULL
  ├─ subtotal          DOUBLE NOT NULL
  └─ imagen            VARCHAR(50) NOT NULL

pedidos                    — historial de compras finalizadas
  ├─ id           INT PK AUTO_INCREMENT
  ├─ usuario      VARCHAR(50) NOT NULL
  ├─ total        DOUBLE NOT NULL
  ├─ iva          DOUBLE NOT NULL
  └─ fecha        DATETIME DEFAULT CURRENT_TIMESTAMP

detalle_pedido
  ├─ id               INT PK AUTO_INCREMENT
  ├─ pedido_id        INT FK → pedidos(id)
  ├─ nombre_producto  VARCHAR(100) NOT NULL
  ├─ subtotal         DOUBLE NOT NULL
  └─ imagen           VARCHAR(50) NOT NULL
```

### 6.2 Catálogo de productos sembrados

**Bebidas (18)** — precios en MXN (Grande / Mediano / Pequeño):

| Nombre | G | M | P |
|---|---|---|---|
| Latte Clásico | $65 | $55 | $45 |
| Cold Brew Infusion | $70 | $60 | $50 |
| Berry Hibiscus | $60 | $50 | $40 |
| Strawberry Cream | $75 | $65 | $55 |
| Strawberry Matcha | $90 | $75 | $60 |
| Dragon Fruit Refresher | $70 | $60 | $50 |
| Iced Americano | $55 | $45 | $35 |
| Iced Macchiato | $80 | $70 | $60 |
| Caramel Frappé | $95 | $80 | $65 |
| Black Hot Coffee | $50 | $40 | $30 |
| Vanilla Cream Cold | $85 | $70 | $55 |
| Mocha Iced | $85 | $70 | $55 |
| Americano Intenso | $50 | $40 | $30 |
| Espresso Cortado | $60 | $50 | $40 |
| Hot Mocha | $80 | $65 | $50 |
| Espresso Doble | $50 | $40 | $35 |
| Frappé Cookies | $95 | $80 | $65 |
| Hot Chocolate | $65 | $55 | $45 |

**Alimentos (14)** — precio único:

| Nombre | Precio |
|---|---|
| Croissant Vegetal | $55 |
| Bagel Caprese | $65 |
| Ciabatta Pollo | $85 |
| Pain au Chocolat | $45 |
| Panini Tres Quesos | $70 |
| Baguette Serrano | $96 |
| Sándwich Pan Negro | $75 |
| Sándwich Pavo Gourmet | $80 |
| Bagel Aguacate | $60 |
| Tarta de Arándanos | $55 |
| Hoja de Hojaldre | $40 |
| Strudel Frutos Rojos | $45 |
| Muffin de Chispas | $35 |
| Cheesecake Frutos | $65 |

---

## 7. Conceptos de POO Aplicados

### 7.1 Herencia
Todas las pantallas extienden `javax.swing.JFrame`. `CarritoProducto` extiende `JPanel`. `Boton_producto` extiende `JButton`. Esto permite reutilizar el comportamiento base de los componentes Swing.

### 7.2 Encapsulamiento
Cada pantalla encapsula su estado interno (contadores, precios seleccionados, referencia al frame padre) con campos `private`. El acceso a la BD se centraliza en `DBConexion` con campo `conn` privado y método `getConexion()` público.

### 7.3 Polimorfismo
Los componentes `BEBIDAS`, `ALIMENTOS` y `CARRITO` comparten la misma interfaz de Swing (`JFrame`) pero implementan lógica de negocio completamente diferente. `CarritoProducto` extiende `JPanel` y se agrega dinámicamente al panel del carrito mediante polimorfismo de componentes.

### 7.4 Patrón Singleton (DBConexion)
`DBConexion` mantiene una única instancia de `Connection` reutilizada en toda la sesión, evitando múltiples conexiones costosas a la BD.

### 7.5 Patrón Flyweight (IconManager)
`IconManager` almacena en caché cada imagen escalada a 80×80 px identificada por su ruta. Si la misma imagen se solicita múltiples veces, se retorna el objeto existente sin recrearlo, reduciendo uso de memoria.

### 7.6 Patrón Observer (Event Listeners)
Toda la interacción de usuario se gestiona mediante el patrón Observer de Java: `ActionListener` en botones (usando referencias a métodos `this::metodoActionPerformed`) y `FocusListener` para limpiar placeholders en campos de texto.

### 7.7 Estado Global (Sesion)
La clase `Sesion` con campo estático `usuario` actúa como un objeto de estado global compartido entre todas las pantallas, permitiendo que `CARRITO.finalizarCompra()` asocie el pedido al usuario autenticado.

---

## 8. Infraestructura Docker

### 8.1 Dockerfile
```dockerfile
FROM mariadb:11
ENV MARIADB_ROOT_PASSWORD=${MARIADB_ROOT_PASSWORD}
ENV MARIADB_DATABASE=${MARIADB_DATABASE}
ENV MARIADB_USER=${MARIADB_USER}
ENV MARIADB_PASSWORD=${MARIADB_PASSWORD}
EXPOSE 3306
```

### 8.2 docker-compose.yml
El servicio `poo_mariadb` expone el puerto `3306`, usa un volumen persistente `mariadb_data` y tiene healthcheck con `healthcheck.sh --connect --innodb_initialized`.

### 8.3 Variables de entorno (.env.example)
```
MARIADB_ROOT_PASSWORD=<contraseña_root>
MARIADB_DATABASE=cafeteria
MARIADB_USER=<usuario>
MARIADB_PASSWORD=<contraseña>
```

> Las tablas y productos se crean automáticamente al primer arranque de la app vía `DBInit.inicializar()`.

---

## 9. Instrucciones de Ejecución

```bash
# 1. Levantar base de datos
cp .env.example .env          # llenar credenciales
docker compose up -d

# 2. Compilar
javac -cp "lib/AbsoluteLayout.jar:lib/mariadb-java-client.jar" \
      -d build/classes \
      src/proyecto_ordinario/*.java

cp -r src/proyecto_ordinario/imagenes build/classes/proyecto_ordinario/

# 3. Ejecutar (desde la raíz del proyecto)
java -cp "build/classes:lib/AbsoluteLayout.jar:lib/mariadb-java-client.jar" \
     proyecto_ordinario.PROYECTO_ORDINARIO
```

> También se puede abrir y ejecutar directamente desde **NetBeans** (proyecto Ant).

---

## 10. Resultados de Pruebas E2E

Las pruebas se realizaron con un driver Java automatizado usando `Robot` + reflexión de campos privados y `doClick()` directo en el EDT.

| Flujo probado | Resultado |
|---|---|
| Inicio renderiza con 3 botones | ✅ PASS |
| Login con credenciales válidas (`marcos`/`cafeteria123`) | ✅ PASS |
| Sesión autenticada: botón "Log in" oculto | ✅ PASS |
| Acceso como invitado | ✅ PASS |
| Catálogo: 18 bebidas + 14 alimentos accesibles | ✅ PASS |
| Detalle bebida: 3 tamaños con contadores ± | ✅ PASS |
| Detalle alimento: contador de cantidad ± | ✅ PASS |
| Agregar bebida al carrito (INSERT a BD verificado) | ✅ PASS |
| Agregar alimento al carrito (INSERT a BD verificado) | ✅ PASS |
| CARRITO abre y muestra productos | ✅ PASS |
| Cálculo IVA 16%: subtotal=$175.00, IVA=$28.00, total=$203.00 | ✅ PASS |
| CrearCuenta abre y deshabilita Inicio | ✅ PASS |

---

## 11. Limitaciones Conocidas

| # | Descripción | Impacto |
|---|---|---|
| 1 | Las contraseñas se almacenan en texto plano | Seguridad — no apto para producción |
| 2 | Imagen `b1.png` referenciada incorrectamente en el carrito (debería ser `D1.png`) | El ícono de "Latte Clásico" no se muestra en el carrito |
| 3 | `DBConexion` reutiliza una sola conexión sin pool | Si la conexión se cierra inesperadamente, la app falla hasta reiniciar |
| 4 | `CrearCuenta` es `JFrame` (no `JDialog`) — la "modalidad" se implementa manualmente con `setEnabled(false)` | Un usuario puede abrir otras ventanas; si la app tiene más frames abiertos, no quedan bloqueados |
| 5 | `Sesion.usuario` es un campo estático global | No soporta múltiples instancias de la app en la misma JVM |

---

## 12. Estadísticas del Proyecto

| Métrica | Valor |
|---|---|
| Clases Java | 13 |
| Líneas de código (total) | ~2,600 |
| Pantallas / JFrames | 6 |
| Componentes personalizados | 2 (CarritoProducto, Boton_producto) |
| Tablas en BD | 5 |
| Productos en catálogo | 32 (18 bebidas + 14 alimentos) |
| Imágenes de assets | ~120 archivos PNG |
| Patrones de diseño aplicados | 4 (Singleton, Flyweight, Observer, State) |

---

## 13. Repositorio

**GitHub:** https://github.com/MarcosLeyva/cafeteriaPOO  
**Rama principal:** `main`  
**Commit inicial:** `feat: initial commit — cafeteria POS app`
