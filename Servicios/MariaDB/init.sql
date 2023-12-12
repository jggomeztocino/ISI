DROP DATABASE IF EXISTS ISI;
CREATE DATABASE ISI;
USE ISI;

CREATE TABLE IF NOT EXISTS condicionesClimaticas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tipoEvento VARCHAR(1024),
    temperatura DOUBLE,
    humedad_ambiente DOUBLE,
    luminosidad DOUBLE,
    timestamp BIGINT
);
/*
INSERT INTO condicionesClimaticas(tipoEvento, temperatura, humedad_ambiente, luminosidad, timestamp)
VALUES(#[payload.tipoEvento], #[payload.temperatura],#[payload.humedad_ambiente],#[payload.luminosidad], #[payload.timestamp]);
*/
CREATE TABLE IF NOT EXISTS estadoPlanta (
    id INT,
    tipoEvento VARCHAR(1024),
    pH DOUBLE,
    nitrogeno DOUBLE,
    fosforo DOUBLE,
    potasio DOUBLE,
    calcio DOUBLE,
    magnesio DOUBLE,
    azufre DOUBLE,
    humedad_suelo DOUBLE,
    humedad_hojas DOUBLE,
    altura DOUBLE,
    patogenos BOOLEAN,
    timestamp BIGINT
);
/*
INSERT INTO estadoPlanta(id, tipoEvento, pH,nitrogeno,fosforo,potasio,calcio,magnesio,azufre,humedad_suelo,humedad_hojas,altura,patogenos,timestamp)
VALUES(#[payload.id], #[payload.tipoEvento], #[payload.pH],#[payload.nitrogeno],#[payload.fosforo],#[payload.potasio],#[payload.calcio],#[payload.magnesio],#[payload.azufre],#[payload.humedad_suelo],#[payload.humedad_hojas],#[payload.altura],#[payload.patogenos],#[payload.timestamp])
*/
CREATE TABLE IF NOT EXISTS gases (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tipoEvento VARCHAR(1024),
    CO2 DOUBLE,
    O2 DOUBLE,
    timestamp BIGINT
);
/*
INSERT INTO gases(CO2,O2,timestamp)
VALUES(#[payload.tipoEvento], #[payload.CO2],#[payload.O2],#[payload.timestamp]);
*/
CREATE TABLE IF NOT EXISTS recursos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tipoEvento VARCHAR(1024),
    consumo_agua DOUBLE,
    consumo_energia DOUBLE,
    timestamp BIGINT
);
/*
INSERT INTO recursos(tipoEvento, consumo_agua,consumo_energia, timestamp)
VALUES(#[payload.tipoEvento], #[payload.consumo_agua],#[payload.consumo_energia],#[payload.timestamp]);
*/

CREATE TABLE IF NOT EXISTS eventosMixtos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tipoEvento VARCHAR(1024),
    mediaSuelo DOUBLE,
    mediaAmbiente DOUBLE,
    timestamp BIGINT
);
/*
INSERT INTO eventosMixtos(tipoEvento, mediaSuelo, mediaAmbiente, timestamp)
VALUES(#[payload.tipoEvento], #[payload.mediaSuelo],#[payload.mediaAmbiente],#[payload.timestamp]);
*/

CREATE TABLE IF NOT EXISTS eventosDetectados (
    id INT AUTO_INCREMENT PRIMARY KEY,
    detalles VARCHAR(1024)
);
/*
INSERT INTO eventosDetectados(detalles, timestamp)
VALUES(#[payload]);
*/