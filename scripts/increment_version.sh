#!/bin/bash

# Leer la versión actual del archivo version.txt
VERSION=$(cat version.txt)
echo "Current version: $VERSION"

# Incrementar el número de versión
IFS='.' read -r -a VERSION_PARTS <<< "$VERSION"
VERSION_PARTS[2]=$((VERSION_PARTS[2] + 1))
NEW_VERSION="${VERSION_PARTS[0]}.${VERSION_PARTS[1]}.${VERSION_PARTS[2]}"
echo "New version: $NEW_VERSION"

# Escribir la nueva versión en el archivo version.txt
echo "$NEW_VERSION" > version.txt

# Imprimir la nueva versión para usarla en el flujo de trabajo
echo "$NEW_VERSION"
