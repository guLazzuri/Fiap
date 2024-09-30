package org.example.controllers;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.example.models.JsonTeste;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JsonTeste getIt() {
        return new JsonTeste(0, "Got it!");
    }

    @GET
    @Path("novarota")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonTeste novaRota(){
        return new JsonTeste(1, "Nova rota!");
    }
}
