# Ingeniería de Sistemas de Información

## Descripción del Proyecto

Este repositorio contiene el proyecto final de la asignatura **Ingeniería de Sistemas de Información**, cursada en el **4º curso del Grado en Ingeniería Informática** en la **Universidad de Cádiz**. El proyecto fue evaluado con la calificación de **10 - Matrícula de Honor**.

### Objetivo del Proyecto

El objetivo principal del proyecto fue aplicar las tecnologías aprendidas en la asignatura en un contexto real de **Internet de las Cosas (IoT)** y **Ciudades Inteligentes**. Se integraron tecnologías como procesamiento de eventos complejos (CEP), un bus de servicios empresariales, un bróker de mensajería, APIs RESTful y bases de datos. Los datos sensados fueron simulados y se implementaron patrones de eventos para demostrar el dominio de las técnicas de CEP.

### Principios de EDA y Microservicios

El proyecto sigue los principios de **Arquitectura Dirigida por Eventos (EDA)**, centrándose en la detección y respuesta a eventos en tiempo real. La arquitectura fue diseñada para ser escalable y eficiente, utilizando un bus de servicios y un bróker de mensajería para asegurar la correcta comunicación y procesamiento de los eventos.

Adicionalmente, se adoptaron los **principios de microservicios**, habilitando un contenedor individual para cada servicio utilizado en el proyecto. Esto permitió una mayor modularidad, facilidad de despliegue y mantenimiento del sistema.

### Tecnologías Utilizadas

- **Esper**: Implementación de patrones de eventos complejos (CEP).
- **nITROGEN**: Simulador de eventos para IoT.
- **RabbitMQ**: Bróker de mensajería para la integración de sistemas.
- **Anypoint Studio (Mule)**: Utilizado para diseñar y gestionar los flujos de integración entre los diferentes componentes del proyecto. Anypoint sirvió como el entorno principal para conectar las aplicaciones y sistemas, manejando la transmisión de datos entre los servicios y facilitando la orquestación de procesos complejos.
- **APIs RESTful**: Implementación de servicios REST para extender la funcionalidad del proyecto.
- **Bases de datos SQL (MariaDB)**: Almacenamiento persistente del histórico de eventos simples y complejos.
- **Docker**: Despliegue de los diferentes microservicios en contenedores.
- **Powershell Scripting**: Despliegue automático de esquemas y patrones.

### Estructura del Repositorio

- **Componente Groovy (Script)**: Parser de JSON escrito en Groovy para la manipulación y transformación de datos en formato JSON.
- **Despliegue**: Archivos Docker utilizados para la construcción automática de los microservicios en contenedores Docker.
- **Esquemas**: Esquemas escritos en EPL (Event Processing Language) utilizados para definir los eventos simples en el proyecto.
- **Patrones**: Patrones escritos en EPL, que definen la lógica de detección de eventos complejos en el contexto de IoT y Ciudades Inteligentes.
- **REST**: Implementación de APIs RESTful escritas en Java, proporcionando interfaces para interactuar con el sistema de manera programática.
- **Servicios**: Código relacionado con los servicios que interactúan dentro de la arquitectura del proyecto, integrando componentes como RabbitMQ y MariaDB con Anypoint Studio.
- **Simulación**: Archivo XML que contiene la configuración necesaria para iniciar una simulación de eventos en nITROGEN.
- **README.md**: Este documento, que proporciona una visión general del proyecto, su estructura y los principios utilizados en su desarrollo.
