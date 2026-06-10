# Cafetería POS

Aplicación de escritorio en Java Swing que simula un sistema de punto de venta para una cafetería. Permite navegar productos por categoría (bebidas y alimentos), agregarlos a un carrito y revisar el resumen de compra con IVA incluido.

## Requisitos

- **JDK 21** o superior
- **Docker** (opcional, necesario para funciones con base de datos)

## Inicio rápido

### 1. Clonar el repositorio

```bash
git clone <url-del-repo>
cd PROYECTO_ORDINARIO
```

### 2. Configurar variables de entorno

```bash
cp .env.example .env
```

Edita `.env` con tus credenciales de base de datos:

```env
MARIADB_ROOT_PASSWORD=tu_password_root
MARIADB_DATABASE=cafeteria
MARIADB_USER=tu_usuario
MARIADB_PASSWORD=tu_password
```

### 3. Correr la aplicación

```bash
./run.sh
```

El script se encarga de todo:

- Levanta el contenedor de MariaDB si Docker está disponible
- Compila el proyecto si es necesario
- Ejecuta la aplicación

> Si no tienes Docker, la aplicación corre igual pero sin funciones de base de datos.

## Flujo de pantallas

```
Inicio (login)
  ├─ Iniciar sesión / Invitado → Pantalla Principal
  │     ├─ Bebidas → detalle con tallas (Grande / Mediano / Pequeño)
  │     ├─ Alimentos → detalle con contador de cantidad
  │     └─ Carrito → resumen con subtotal + 16% IVA
  └─ Crear cuenta → formulario de registro
```

## Estructura del proyecto

```
PROYECTO_ORDINARIO/
├── src/proyecto_ordinario/   # Código fuente Java
│   └── imagenes/             # Recursos gráficos
├── lib/                      # Dependencias (AbsoluteLayout, MariaDB driver)
├── build/                    # Clases compiladas (generado por run.sh)
├── docker-compose.yml        # Contenedor MariaDB
├── .env.example              # Plantilla de variables de entorno
└── run.sh                    # Script de compilación y ejecución
```

## Notas

- El archivo `carrito.txt` se crea en el directorio raíz del proyecto al correr la app y se limpia en cada inicio.
- El proyecto fue desarrollado originalmente en NetBeans. Si prefieres usar NetBeans, abre el directorio como proyecto existente y usa `Run Project`.
