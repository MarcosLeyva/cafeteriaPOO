#!/bin/bash

# Directorio raíz del proyecto
DIR="$(cd "$(dirname "$0")" && pwd)"
SRC="$DIR/src"
BUILD="$DIR/build/classes"
LIBS="$DIR/lib/AbsoluteLayout.jar:$DIR/lib/mariadb-java-client.jar"
MAIN="proyecto_ordinario.PROYECTO_ORDINARIO"

# Verificar que Java esté instalado
if ! command -v java &>/dev/null; then
    echo "ERROR: Java no está instalado. Instala JDK 21 o superior."
    exit 1
fi

# Levantar base de datos con Docker si está disponible
if command -v docker &>/dev/null; then
    if [ ! -f "$DIR/.env" ]; then
        echo "AVISO: No se encontró el archivo .env — copiando desde .env.example."
        echo "       Edita $DIR/.env con tus credenciales antes de continuar."
        cp "$DIR/.env.example" "$DIR/.env"
        exit 1
    fi

    STATUS=$(docker inspect -f '{{.State.Status}}' poo_mariadb 2>/dev/null)
    if [ "$STATUS" != "running" ]; then
        echo "Levantando base de datos..."
        docker compose -f "$DIR/docker-compose.yml" up -d
    fi

    echo "Esperando a que la base de datos esté lista..."
    for i in $(seq 1 30); do
        HEALTH=$(docker inspect -f '{{.State.Health.Status}}' poo_mariadb 2>/dev/null)
        [ "$HEALTH" = "healthy" ] && break
        sleep 2
    done
    if [ "$HEALTH" != "healthy" ]; then
        echo "AVISO: La base de datos no respondió a tiempo. La app puede fallar al conectarse."
    else
        echo "Base de datos lista."
    fi
else
    echo "AVISO: Docker no está instalado. La app correrá sin base de datos."
fi

# Compilar si no existen clases o si hay fuentes más recientes
if [ ! -d "$BUILD" ] || find "$SRC" -name "*.java" -newer "$BUILD" | grep -q .; then
    echo "Compilando..."
    if ! command -v javac &>/dev/null; then
        echo "ERROR: javac no encontrado. Instala el JDK (no solo el JRE)."
        exit 1
    fi
    mkdir -p "$BUILD"
    find "$SRC" -name "*.java" > /tmp/sources.txt
    if ! javac -cp "$LIBS" -d "$BUILD" @/tmp/sources.txt 2>&1; then
        echo "ERROR: La compilación falló."
        exit 1
    fi
    # Copiar recursos (imágenes, etc.)
    cp -r "$SRC/proyecto_ordinario/imagenes" "$BUILD/proyecto_ordinario/" 2>/dev/null || true
    echo "Compilación exitosa."
fi

# Correr la aplicación desde el directorio del proyecto (requerido por carrito.txt)
cd "$DIR"
java -cp "$BUILD:$LIBS" "$MAIN"
