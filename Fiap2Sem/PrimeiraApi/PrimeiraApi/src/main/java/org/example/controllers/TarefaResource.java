package org.example.controllers;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.models.Tarefa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Path("tarefa")
public class TarefaResource {

    public static List<Tarefa> tarefas = new ArrayList<Tarefa>(Arrays.asList(
        new Tarefa(1, "Estudar Java para melhorar minhas habilidades"),
        new Tarefa(2, "Estudar Python para melhorar minhas habilidades"),
        new Tarefa(3, "Estudar JavaScript para melhorar minhas habilidades")
    ));


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tarefa> getTarefas(){
        return tarefas;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Tarefa getTarefa(@PathParam("id") int id){
        return tarefas.stream()
                .filter(tarefa -> tarefa.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addTarefa(Tarefa novaTarefa){
        tarefas.add(novaTarefa);
    }



    @DELETE
    @Path("{id}")
    public void deleteTarefa(@PathParam("id") int id){
        tarefas.removeIf(tarefa -> tarefa.getId() == id);
    }
}
