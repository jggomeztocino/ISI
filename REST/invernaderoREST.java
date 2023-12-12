package rest_isi;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/invernadero")
public class invernaderoREST {
    private static int numeroEventosSimples = 0;
    private static int numeroEventosComplejos = 0;
    private static int numeroEventosCondicionesClimaticas = 0;
    private static int numeroEventosEstadoPlanta = 0;
    private static int numeroEventosGases = 0;
    private static int numeroEventosRecursos = 0;
    private static int numeroEventosMixtos = 0;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/ISI";
    private static final String USER = "root";
    private static final String PASS = "root";

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String status() {
        return "La API REST funciona.\n";
    }

    @POST
    @Path("/nuevoEventoSimple")
    @Produces(MediaType.TEXT_PLAIN)
    public String eventoSimple() {
        numeroEventosSimples++;
        return "Evento simple registrado correctamente!";
    }

    @POST
    @Path("/nuevoEventoComplejo")
    @Produces(MediaType.TEXT_PLAIN)
    public String eventoComplejo() {
        numeroEventosComplejos++;
        return "Evento complejo registrado correctamente!";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/eventosTotales")
    public String eventosTotales() {
        return "Total eventos simples: " + numeroEventosSimples + ", Total eventos complejos: "
                + numeroEventosComplejos;
    }

    @POST
    @Path("/nuevoEventoCondicionesClimaticas")
    @Produces(MediaType.TEXT_PLAIN)
    public String eventoCondicionesClimaticas() {
        numeroEventosCondicionesClimaticas++;
        return "Evento de condiciones climaticas registrado correctamente!";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/eventosCondicionesClimaticas")
    public String eventosCondicionesClimaticas() {
        return "Total eventos de condiciones climaticas: " + numeroEventosCondicionesClimaticas;
    }

    @POST
    @Path("/nuevoEventoEstadoPlanta")
    @Produces(MediaType.TEXT_PLAIN)
    public String eventoEstadoPlanta() {
        numeroEventosEstadoPlanta++;
        return "Evento de estado de planta registrado correctamente!";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/eventosEstadoPlanta")
    public String eventosEstadoPlanta() {
        return "Total eventos de estado de planta: " + numeroEventosEstadoPlanta;
    }

    @POST
    @Path("/nuevoEventoGases")
    @Produces(MediaType.TEXT_PLAIN)
    public String eventoGases() {
        numeroEventosGases++;
        return "Evento de gases registrado correctamente!";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/eventosGases")
    public String eventosGases() {
        return "Total eventos de gases: " + numeroEventosGases;
    }

    @POST
    @Path("/nuevoEventoRecursos")
    @Produces(MediaType.TEXT_PLAIN)
    public String eventoRecursos() {
        numeroEventosRecursos++;
        return "Evento de recursos registrado correctamente!";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/eventosRecursos")
    public String eventosRecursos() {
        return "Total eventos de recursos: " + numeroEventosRecursos;
    }

    @POST
    @Path("/nuevoEventoMixto")
    @Produces(MediaType.TEXT_PLAIN)
    public String eventoMixto() {
        numeroEventosMixtos++;
        return "Evento mixto registrado correctamente!";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/eventosMixtos")
    public String eventosMixtos() {
        return "Total eventos mixtos: " + numeroEventosMixtos;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/resumen")
    public String resumen() {
        Map<String, fecha> resumenEventos = new HashMap<>();
        String[] tablas = { "condicionesClimaticas", "estadoPlanta", "gases", "recursos", "eventosMixtos" };

        try (Connection conexionBD = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement consulta = conexionBD.createStatement()) {
            for (String tabla : tablas) {
                String sql = String.format(
                        "SELECT tipoEvento, MAX(timestamp) as ultimoTimestamp, COUNT(*) as count FROM %s GROUP BY tipoEvento",
                        tabla);
                try (ResultSet rs = consulta.executeQuery(sql)) {
                    while (rs.next()) {
                        String clave = "\n\n [ " + tabla + " - " + rs.getString("tipoEvento") + " ] ";
                        long ultimoTimestampMs = rs.getLong("ultimoTimestamp");
                        int count = rs.getInt("count");
                        Date d = new Date(ultimoTimestampMs);
                        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                        String ultimoTimestamp = formatoFecha.format(d);
                        resumenEventos.put(clave, new fecha(ultimoTimestamp, count));
                    }
                }
            }
        } catch (SQLException se) {
            se.printStackTrace();
            return "Error al conectarse a la base de datos.";
        }

        return resumenEventos.toString();
    }

    static class fecha {
        String ultimoTimestamp;
        int count;

        fecha(String ultimoTimestamp, int count) {
            this.ultimoTimestamp = ultimoTimestamp;
            this.count = count;
        }

        @Override
        public String toString() {
            return "\nÚltimo evento detectado: " + ultimoTimestamp + ", Veces detectado: " + count + "\n\n";
        }
    }
}
