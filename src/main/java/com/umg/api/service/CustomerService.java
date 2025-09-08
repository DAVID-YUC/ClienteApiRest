/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umg.api.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.umg.api.model.Customer;
import org.apache.hc.client5.http.classic.methods.HttpGet; //CONSULTAR
import org.apache.hc.client5.http.classic.methods.HttpPost; //AGREGAR
import org.apache.hc.client5.http.classic.methods.HttpDelete; //ELIMINAR
import org.apache.hc.client5.http.classic.methods.HttpPut; //MODIFICAR
import org.apache.hc.client5.http.entity.EntityBuilder; //CREAR LA ENTIDAD U OBJETO
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient; //CERRAR EL CONSUMO DE LA API
import org.apache.hc.client5.http.impl.classic.HttpClients; //PETICIONES DE CLIENTES
import org.apache.hc.core5.http.ClassicHttpResponse;//CODGIOS DE RESPUSTA
import org.apache.hc.core5.http.ContentType;

import java.io.InputStream;//ALMACENANDO DATOS EN STREAMING
import java.util.List;// LISTA DE DATOS
import org.apache.hc.client5.http.impl.async.CloseableHttpAsyncClient;

public class CustomerService {
       private static final String BASE_URL = "https://apirest2025umg.onrender.com/api/customer"; //LLAVE PRIVADA PRA QUE NO SE ACCEDA EN OTRA CLASE, PRIVATE STATIC PORQUE NO CAMBIARA EL URL
    private static final ObjectMapper mapper = new ObjectMapper(); // MAPEO DE LOS OBJETOS

    // GET clientes
    public List<Customer> getCustomers() throws Exception { //DEFINIR UN METODO GET, 
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(BASE_URL);
            ClassicHttpResponse response = (ClassicHttpResponse) client.execute(request);
            InputStream is = response.getEntity().getContent();
            return mapper.readValue(is, new TypeReference<List<Customer>>() {});
        }
    }

    // POST crear cliente
    public Customer createCustomer(Customer c) throws Exception {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpPost request = new HttpPost(BASE_URL + "/create");
            
            if (c.getIngreso()== null || c.getIngreso().isEmpty()){
            String now = java.time.Instant.now().toString();
            c.setIngreso(now);
            }
            String json = mapper.writeValueAsString(c);
            request.setEntity(EntityBuilder.create()
                    .setText(json)
                    .setContentType(ContentType.APPLICATION_JSON)
                    .build());
            ClassicHttpResponse response = (ClassicHttpResponse) client.execute(request);
            InputStream is = response.getEntity().getContent();
            return mapper.readValue(is, Customer.class);
        }
    }
    
    //PUT actualizar cliente
public Customer updateCustomer(int id, Customer c) throws Exception{
        try (CloseableHttpClient client = HttpClients.createDefault()){
            HttpPut request = new HttpPut(BASE_URL + "/update/" + id);
            String json = mapper.writeValueAsString(c);
            
            request.setEntity(EntityBuilder.create()
                   .setText(json)
                   .setContentType(ContentType.APPLICATION_JSON)
                   .build());
            ClassicHttpResponse response = (ClassicHttpResponse) client.execute(request);
            InputStream is = response.getEntity().getContent();
            return mapper.readValue(is,Customer.class);
        }
    }
    
}
