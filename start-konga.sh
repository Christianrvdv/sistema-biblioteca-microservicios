#!/bin/sh
echo "Esperando 120 segundos para estabilizar dependencias..."
sleep 120
echo "Iniciando Konga..."
exec npm start
