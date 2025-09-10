package com.umg.api.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.umg.api.model.Cursomodel;
import org.apache.hc.client5.http.classic.methods.HttpDelete;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.classic.methods.HttpPut;
import org.apache.hc.client5.http.entity.EntityBuilder;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class CursoServer1 {
    private static final String BASE_URL = "https://proyecto-1-4omi.onrender.com/api/curso";
    private static final ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    // GET todos los cursos
    public List<Cursomodel> getCursos() throws Exception {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(BASE_URL);
            try (CloseableHttpResponse response = client.execute(request)) {
                
                if (response.getCode() != 200) {
                    throw new Exception("Error HTTP: " + response.getCode());
                }
                
                InputStream is = response.getEntity().getContent();
                return mapper.readValue(is, new TypeReference<List<Cursomodel>>() {});
            }
        }
    }

    // GET curso por NOMBRE
    public Cursomodel getCursoByNombre(String nombre) throws Exception {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            String encodedNombre = URLEncoder.encode(nombre, StandardCharsets.UTF_8);
            HttpGet request = new HttpGet(BASE_URL + "/nombre/" + encodedNombre);
            
            try (CloseableHttpResponse response = client.execute(request)) {
                
                if (response.getCode() != 200) {
                    throw new Exception("Error HTTP: " + response.getCode());
                }
                
                InputStream is = response.getEntity().getContent();
                return mapper.readValue(is, Cursomodel.class);
            }
        }
    }

    // GET cursos por búsqueda de nombre (like)
    public List<Cursomodel> searchCursosByNombre(String searchTerm) throws Exception {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            String encodedTerm = URLEncoder.encode(searchTerm, StandardCharsets.UTF_8);
            HttpGet request = new HttpGet(BASE_URL + "?nombre=" + encodedTerm);
            
            try (CloseableHttpResponse response = client.execute(request)) {
                
                if (response.getCode() != 200) {
                    throw new Exception("Error HTTP: " + response.getCode());
                }
                
                InputStream is = response.getEntity().getContent();
                return mapper.readValue(is, new TypeReference<List<Cursomodel>>() {});
            }
        }
    }

    // POST crear curso - MÉTODO CORREGIDO
    public Cursomodel createCurso(Cursomodel curso) throws Exception {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpPost request = new HttpPost(BASE_URL);
            
            // Convertir objeto a JSON
            String json = mapper.writeValueAsString(curso);
            
            request.setEntity(EntityBuilder.create()
                    .setText(json)
                    .setContentType(ContentType.APPLICATION_JSON)
                    .build());
            
            try (CloseableHttpResponse response = client.execute(request)) {
                int statusCode = response.getCode();
                String responseBody = EntityUtils.toString(response.getEntity());
                
                // El servidor responde con 201 (Created) en lugar de 200
                if (statusCode == 201) {
                    // Parsear la respuesta JSON a objeto Cursomodel
                    return mapper.readValue(responseBody, Cursomodel.class);
                } else {
                    throw new Exception("Error al crear curso: " + statusCode + " - " + responseBody);
                }
            }
        }
    }

    // PUT actualizar por NOMBRE
    public String updateCursoByNombre(String nombre, Cursomodel curso) throws Exception {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            String encodedNombre = URLEncoder.encode(nombre, StandardCharsets.UTF_8);
            String url = BASE_URL + "/nombre/" + encodedNombre;

            HttpPut request = new HttpPut(url);

            // Configurar headers para UTF-8
            request.setHeader("Content-Type", "application/json; charset=UTF-8");
            request.setHeader("Accept", "application/json");

            // Convertir objeto Curso a JSON
            String json = mapper.writeValueAsString(curso);
            request.setEntity(EntityBuilder.create()
                    .setText(json)
                    .setContentType(ContentType.APPLICATION_JSON.withCharset(StandardCharsets.UTF_8))
                    .build());

            try (CloseableHttpResponse response = client.execute(request)) {
                int statusCode = response.getCode();

                // Revisar si hay entidad
                String responseBody = "";
                if (response.getEntity() != null) {
                    responseBody = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8).trim();
                }

                if (statusCode >= 200 && statusCode < 300) {
                    // Manejo seguro si viene vacío
                    if (responseBody.isEmpty()) {
                        return "Curso actualizado exitosamente (sin contenido en la respuesta)";
                    } else {
                        // Intentar mapear a JSON; si falla, devolver como texto plano
                        try {
                            Cursomodel updated = mapper.readValue(responseBody, Cursomodel.class);
                            return "Curso actualizado: " + updated.getNombre();
                        } catch (Exception ex) {
                            return responseBody; // Devuelve lo que venga
                        }
                    }
                } else {
                    throw new Exception("Error HTTP " + statusCode + ": " + responseBody);
                }
            }
        }
    }

    // DELETE eliminar por NOMBRE
    public String deleteCursoByNombre(String nombre) throws Exception {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            String encodedNombre = URLEncoder.encode(nombre, StandardCharsets.UTF_8);
            HttpDelete request = new HttpDelete(BASE_URL + "/nombre/" + encodedNombre);
            
            try (CloseableHttpResponse response = client.execute(request)) {
                
                if (response.getCode() != 200) {
                    String errorBody = EntityUtils.toString(response.getEntity());
                    throw new Exception("Error al eliminar curso: " + response.getCode() + " - " + errorBody);
                }
                
                // Tu backend devuelve un mensaje de texto
                String responseBody = EntityUtils.toString(response.getEntity());
                return responseBody;
            }
        }
    }

    // Método adicional para debuggear
    public String debugCursoObject(Cursomodel curso) throws Exception {
        try {
            return mapper.writeValueAsString(curso);
        } catch (Exception e) {
            return "Error al convertir a JSON: " + e.getMessage();
        }
    }
}