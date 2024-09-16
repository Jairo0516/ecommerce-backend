#!/bin/bash

# Generar el changelog basado en los mensajes de confirmación
# CHANGELOG.md

echo "Generating changelog"

# Obtener los mensajes de confirmación desde el último tag
git log $(git describe --tags --abbrev=0)..HEAD --pretty=format:"* %s" > CHANGELOG.md

# Agregar detalles al changelog
echo -e "## $(date +'%Y-%m-%d')\n" > CHANGELOG.md
cat CHANGELOG.md >> CHANGELOG.md
