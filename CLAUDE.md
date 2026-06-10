# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

A Java Swing desktop application simulating a cafeteria ordering system (point-of-sale). Built with NetBeans and the AbsoluteLayout library. The app allows users to browse products by category (bebidas/alimentos), add items to a cart, and review a purchase summary with IVA.

## Build & Run

This is a NetBeans Ant project. Build and run from the project root:

```bash
# Build
ant jar

# Run
ant run

# Clean
ant clean
```

The compiled jar is output to `dist/PROYECTO_ORDINARIO.jar`. The project requires Java 25 and the `AbsoluteLayout` library (configured via `libs.absolutelayout.classpath` in NetBeans).

The application **must be run from the project root directory** because it reads and writes `carrito.txt` relative to the working directory (`new java.io.FileWriter("carrito.txt", ...)`).

## Architecture

### Screen Flow

```
PROYECTO_ORDINARIO (main)
  └─ clears carrito.txt on startup
  └─ Inicio (login screen)
       ├─ iniciar_sesión → Pantalla_Principal(invitado=false)
       ├─ Invitado       → Pantalla_Principal(invitado=true)  [hides Login button]
       └─ Crear cuenta   → CrearCuenta (modal dialog, re-enables Inicio on close)

Pantalla_Principal (product catalog)
  ├─ bebidaN buttons → BEBIDAS(nombre, descripcion, preciog, preciom, preciop, imagen, frame)
  ├─ alimentoN buttons → ALIMENTOS(nombre, descripcion, precio, imagen, frame)
  └─ carrito button → CARRITO

BEBIDAS / ALIMENTOS (product detail)
  └─ COMPRAR → appends to carrito.txt, returns to Pantalla_Principal

CARRITO (cart summary)
  └─ reads carrito.txt line-by-line, creates CarritoProducto panels
  └─ calculates subtotal + 16% IVA
```

### Cart Persistence

`carrito.txt` is a flat file in the working directory used as session-level cart storage. Each product written is exactly 3 lines:
1. Product name
2. Subtotal (as a double string)
3. Image filename (basename only, e.g. `c6.png`)

`PROYECTO_ORDINARIO.main()` truncates this file on every launch.

### Key Classes

| Class | Role |
|---|---|
| `PROYECTO_ORDINARIO` | Entry point; clears cart and opens `Inicio` |
| `Inicio` | Login/welcome screen |
| `Pantalla_Principal` | Product catalog with bebidas and alimentos buttons |
| `BEBIDAS` | Drink detail screen; supports Grande/Mediano/Pequeño sizes with individual prices |
| `ALIMENTOS` | Food detail screen; single price, quantity counter |
| `CARRITO` | Cart view; reads `carrito.txt`, shows per-item panels, totals IVA |
| `CarritoProducto` | JPanel subclass for each cart line item |
| `Boton_producto` | Custom `JButton` that shows a product image + name |
| `IconManager` | Singleton image cache; scales all icons to 80×80px |
| `CrearCuenta` | Account creation form (currently UI-only, no backend persistence) |

### UI Patterns

- All screens use `AbsoluteLayout` (NetBeans `org.netbeans.lib.awtextra.AbsoluteLayout`).
- `.form` files are NetBeans GUI Builder sources; the generated code lives inside `//GEN-BEGIN:initComponents` … `//GEN-END:initComponents` blocks — **do not edit these blocks manually**.
- All screens open maximized (`MAXIMIZED_BOTH`).
- Images live under `src/proyecto_ordinario/imagenes/` and are loaded via `getClass().getResource(...)`.

### Known Limitations / TODOs

- `CrearCuenta` collects fields but does not persist account data anywhere.
- `Inicio.iniciar_sesActionPerformed` does not validate credentials — any input opens `Pantalla_Principal`.
- `carrito.txt` path is relative to CWD, so running the jar from a different directory breaks the cart.
