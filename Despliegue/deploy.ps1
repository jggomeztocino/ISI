# Leer las rutas de un archivo de texto
$rutas = Get-Content ".\rutas.txt"

$carpetaEsquema = $rutas[0]
$carpetaPatrones = $rutas[1]
$carpetaDestino = $rutas[2]
$carpetaEliminar = $rutas[3]

# Eliminar todos los archivos en la carpeta especificada
Remove-Item "$carpetaEliminar\*" -Force

# Array con las rutas de origen de los archivos en estricto orden
$rutasOrigen = @(
    "$carpetaEsquema\condicionesClimaticas.epl",
    "$carpetaEsquema\estadoPlanta.epl",
    "$carpetaEsquema\gases.epl",
    "$carpetaEsquema\recursos.epl",
    "$carpetaPatrones\calidadAire\1_nivelCO2.epl",
    "$carpetaPatrones\calidadAire\2_nivelO2.epl",
    "$carpetaPatrones\calidadAire\nivelBajoCO2.epl",
    "$carpetaPatrones\calidadAire\nivelAltoCO2.epl",
    "$carpetaPatrones\calidadAire\nivelBajoO2.epl",
    "$carpetaPatrones\calidadAire\nivelAltoO2.epl",
    "$carpetaPatrones\cicloVentilacion\cicloDiurno.epl",
    "$carpetaPatrones\cicloVentilacion\cicloNocturno.epl",
    "$carpetaPatrones\climatizacion\1_activarCalefaccion.epl",
    "$carpetaPatrones\climatizacion\2_activarEnfriamiento.epl",
    "$carpetaPatrones\climatizacion\3_incendio.epl",
    "$carpetaPatrones\consumo\consumoIneficienteAgua.epl",
    "$carpetaPatrones\consumo\consumoIneficienteElectrico.epl",
    "$carpetaPatrones\consumo\cortocircuito.epl",
    "$carpetaPatrones\consumo\fuga.epl",
    "$carpetaPatrones\humedad\1_medicionSueloIndividual.epl",
    "$carpetaPatrones\humedad\2_medicionSuelo.epl",
    "$carpetaPatrones\humedad\3_medicionAmbiente.epl",
    "$carpetaPatrones\humedad\4_activarRiego.epl",
    "$carpetaPatrones\humedad\5_excesoSuelo.epl",
    "$carpetaPatrones\humedad\6_excesoAmbiente.epl",
    "$carpetaPatrones\luminosidad\1_faltaLuz.epl",
    "$carpetaPatrones\luminosidad\2_luzSuficiente.epl",
    "$carpetaPatrones\luminosidad\3_contexto.epl",
    "$carpetaPatrones\salud\1_enfermedad.epl",
    "$carpetaPatrones\salud\2_desequilibrioNutrientes.epl",
    "$carpetaPatrones\salud\3_crecimiento.epl",
    "$carpetaPatrones\salud\4_humedad.epl",
    "$carpetaPatrones\salud\5_estresHidrico.epl",
    "$carpetaPatrones\salud\6_contaminacion.epl",
    "$carpetaPatrones\salud\7_plaga.epl"
)

# Pausar el script y esperar a que el usuario presione ENTER
Read-Host "Pulse ENTER cuando el proyecto de Anypoint Studio haya sido desplegado"

# Copiar archivos con pausa de 2 segundos entre cada copia
ForEach ($ruta in $rutasOrigen) {
    $archivo = Get-Item $ruta
    Copy-Item $ruta -Destination (Join-Path $carpetadestino $archivo.Name) -Force
    Start-Sleep -Seconds 1
}

Write-Host "Archivos copiados exitosamente a $carpetadestino"