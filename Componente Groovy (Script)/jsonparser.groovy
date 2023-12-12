import groovy.json.JsonSlurper

def json = payload

def parser = new JsonSlurper()
def obj = parser.parseText(json)

// Extract the key of the outer JSON object
def outerKey = obj.keySet()[0]

// Use this key to extract the inner JSON object
def innerObj = obj[outerKey]

def eventTypeName = innerObj.eventTypeName
def timestamp = innerObj.timestamp

switch(eventTypeName) {
    case "calidadSuelo":
        def pH_suelo = innerObj.pH_suelo
        def conductividad_suelo = innerObj.conductividad_suelo
        payload = [eventTypeName: eventTypeName, timestamp: timestamp, pH_suelo: pH_suelo, conductividad_suelo: conductividad_suelo]
        break

    case "condicionesClimaticas":
        def temperatura = innerObj.temperatura
        def humedad_ambiente = innerObj.humedad_ambiente
        def luminosidad = innerObj.luminosidad
        payload = [eventTypeName: eventTypeName, timestamp: timestamp, temperatura: temperatura, humedad_ambiente: humedad_ambiente, luminosidad: luminosidad]
        break

    case "estadoPlanta":
        def id = innerObj.id
        def pH = innerObj.pH
        def nitrogeno = innerObj.nitrogeno
        def fosforo = innerObj.fosforo
        def potasio = innerObj.potasio
        def calcio = innerObj.calcio
        def magnesio = innerObj.magnesio
        def azufre = innerObj.azufre
        def humedad_suelo = innerObj.humedad_suelo
        def humedad_hojas = innerObj.humedad_hojas
        def altura = innerObj.altura
        def patogenos = innerObj.patogenos
        payload = [eventTypeName: eventTypeName, timestamp: timestamp, id: id, pH: pH, nitrogeno: nitrogeno, fosforo: fosforo, potasio: potasio, calcio: calcio, magnesio: magnesio, azufre: azufre, humedad_suelo: humedad_suelo, humedad_hojas: humedad_hojas, altura: altura, patogenos: patogenos]
        break

    case "gases":
        def CO2 = innerObj.CO2
        def O2 = innerObj.O2
        payload = [eventTypeName: eventTypeName, timestamp: timestamp, CO2: CO2, O2: O2]
        break

    case "recursos":
        def consumo_agua = innerObj.consumo_agua
        def consumo_energia = innerObj.consumo_energia
        payload = [eventTypeName: eventTypeName, timestamp: timestamp, consumo_agua: consumo_agua, consumo_energia: consumo_energia]
        break
}
