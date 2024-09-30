package org.example.controllers;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.models.Tarefa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Path("tarefa")
public class TarefaResource {

    public static List<Tarefa> tarefas = new ArrayList<>(Arrays.asList(
            new Tarefa(1, "Estudar Java para melhorar minhas habilidades"),
            new Tarefa(2, "Estudar Python para melhorar minhas habilidades"),
            new Tarefa(3, "Estudar JavaScript para melhorar minhas habilidades")
    ));

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getTarefa(@PathParam("id") int id) {
        Tarefa t = tarefas.stream()
                .filter(tarefa -> tarefa.getId() == id)
                .findFirst()
                .orElse(null);

        if (t != null) {
            return Response.status(Response.Status.OK)
                    .header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Credentials", "true")
                    .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                    .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                    .entity(t)
                    .build();
        }
        return Response.status(Response.Status.NOT_FOUND)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addTarefa(Tarefa novaTarefa) {
        tarefas.add(novaTarefa);
        return Response.status(Response.Status.CREATED)
                .entity(novaTarefa)
                .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("page/{page}")
    public List<Tarefa> gettarrefaPaginas(@PathParam("page") int page, @QueryParam("pageSize") int pageSize) {
        int fromIndex = (page - 1) * pageSize;
        if (fromIndex >= tarefas.size()) {
            return new ArrayList<>();
        }
        return tarefas.subList(fromIndex, Math.min(fromIndex + pageSize, tarefas.size()));
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateTarefas(@PathParam("id") int id, Tarefa tarefaAtualizada) {
        boolean updated = tarefas.stream()
                .filter(tarefa -> tarefa.getId() == id)
                .peek(tarefa -> tarefa.setDescricao(tarefaAtualizada.getDescricao()))
                .count() > 0;

        if (updated) {
            return Response.status(Response.Status.OK).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response deleteTarefa(@PathParam("id") int id) {
        boolean removed = tarefas.removeIf(tarefa -> tarefa.getId() == id);
        if (removed) {
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @OPTIONS
    public Response options() {
        return Response.ok()
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .build();
    }
}
