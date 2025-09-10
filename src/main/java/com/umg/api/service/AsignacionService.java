package com.umg.api.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.umg.api.model.Asignacionmodel;
import org.apache.hc.client5.http.classic.methods.HttpDelete;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.classic.methods.HttpPut;
import org.apache.hc.client5.http.entity.EntityBuilder;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class AsignacionService {
    private static final String BASE_URL = "https://proyecto-1-4omi.onrender.com/api/asignacion";
    private static final ObjectMapper mapper = new ObjectMapper();

    static {
        // Configurar ObjectMapper para manejar LocalDate
          mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); }

    // GET todos los maestros
    public List<Asignacionmodel> getAsignacionmodels() throws Exception {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(BASE_URL);
            try (CloseableHttpResponse response = client.execute(request)) {
                
                if (response.getCode() != 200) {
                    throw new Exception("Error HTTP: " + response.getCode());
                }
                
                InputStream is = response.getEntity().getContent();
                return mapper.readValue(is, new TypeReference<List<Asignacionmodel>>() {});
            }
        }
    }


    
     // GET maestro por NOMBRE
    public Asignacionmodel getMaestroByNombre(String nombre) throws Exception {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            String encodedNombre = URLEncoder.encode(nombre, StandardCharsets.UTF_8);
            HttpGet request = new HttpGet(BASE_URL + "/nombre/" + encodedNombre);
            
            try (CloseableHttpResponse response = client.execute(request)) {
                
                if (response.getCode() != 200) {
                    throw new Exception("Error HTTP: " + response.getCode());
                }
                
                InputStream is = response.getEntity().getContent();
                return mapper.readValue(is, Asignacionmodel.class);
            }
        }
    }

    // GET maestros por búsqueda de nombre (like)
    public List<Asignacionmodel> searchAsgnacionByNombre(String searchTerm) throws Exception {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            String encodedTerm = URLEncoder.encode(searchTerm, StandardCharsets.UTF_8);
            HttpGet request = new HttpGet(BASE_URL + "?nombre=" + encodedTerm);
            
            try (CloseableHttpResponse response = client.execute(request)) {
                
                if (response.getCode() != 200) {
                    throw new Exception("Error HTTP: " + response.getCode());
                }
                
                InputStream is = response.getEntity().getContent();
                return mapper.readValue(is, new TypeReference<List<Asignacionmodel>>() {});
            }
        }
    }

    // POST crear maestro
    public Asignacionmodel createAsignacion(Asignacionmodel maestro) throws Exception {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpPost request = new HttpPost(BASE_URL);
            
            // Convertir objeto a JSON
            String json = mapper.writeValueAsString(maestro);
            
            request.setEntity(EntityBuilder.create()
                    .setText(json)
                    .setContentType(ContentType.APPLICATION_JSON)
                    .build());
            
            try (CloseableHttpResponse response = client.execute(request)) {
                
                if (response.getCode() != 200) {
                    // Leer el mensaje de error
                    String errorBody = EntityUtils.toString(response.getEntity());
                    throw new Exception("Error al crear: " + response.getCode() + " - " + errorBody);
                }
                
                InputStream is = response.getEntity().getContent();
                return mapper.readValue(is, Asignacionmodel.class);
            }
        }
    }

    // PUT actualizar por NOMBRE
    // PUT actualizar por NOMBRE
public String updateAsignacionByNombre(String nombre, Asignacionmodel maestro) throws Exception {
    try (CloseableHttpClient client = HttpClients.createDefault()) {
        String encodedNombre = URLEncoder.encode(nombre, StandardCharsets.UTF_8);
        String url = BASE_URL + "/nombre/" + encodedNombre;

        HttpPut request = new HttpPut(url);

        // Configurar headers para UTF-8
        request.setHeader("Content-Type", "application/json; charset=UTF-8");
        request.setHeader("Accept", "application/json");

        // Convertir objeto Maestro a JSON
        String json = mapper.writeValueAsString(maestro);

        request.setEntity(EntityBuilder.create()
                .setText(json)
                .setContentType(ContentType.APPLICATION_JSON.withCharset(StandardCharsets.UTF_8))
                .build());

        try (CloseableHttpResponse response = client.execute(request)) {
            int statusCode = response.getCode();
            String responseBody = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);

            if (statusCode == 200) {
                return responseBody; // Devuelve el JSON { "message": "..." }
            } else {
                throw new Exception("Error " + statusCode + ": " + responseBody);
            }
        }
    }
}


    // DELETE eliminar por NOMBRE
    public String deleteAsignacionByNombre(String nombre) throws Exception {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            String encodedNombre = URLEncoder.encode(nombre, StandardCharsets.UTF_8);
            HttpDelete request = new HttpDelete(BASE_URL + "/nombre/" + encodedNombre);
            
            try (CloseableHttpResponse response = client.execute(request)) {
                
                if (response.getCode() != 200) {
                    String errorBody = EntityUtils.toString(response.getEntity());
                    throw new Exception("Error al eliminar: " + response.getCode() + " - " + errorBody);
                }
                
                // Tu backend devuelve un mensaje de texto
                String responseBody = EntityUtils.toString(response.getEntity());
                return responseBody;
            }
        }
    }

    // Método adicional para debuggear
    public String debugAsignacionObject(Asignacionmodel maestro) throws Exception {
        try {
            return mapper.writeValueAsString(maestro);
        } catch (Exception e) {
            return "Error al convertir a JSON: " + e.getMessage();
        }
    }

}


   
