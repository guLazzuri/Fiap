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

    public static List<Tarefa> tarefas = new ArrayList<Tarefa>(Arrays.asList(
        new Tarefa(1, "Estudar Java para melhorar minhas habilidades"),
        new Tarefa(2, "Estudar Python para melhorar minhas habilidades"),
        new Tarefa(3, "Estudar JavaScript para melhorar minhas habilidades")
    ));

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("search")
    public List<Tarefa> searchTarefas(
            @QueryParam("descricao") String descricao,
            @QueryParam("orderBy") String orderBy) {
        return tarefas.stream()
                .filter(tarefa -> descricao == null || tarefa.getDescricao().contains(descricao))
                .sorted((t1, t2) -> {
                    if ("id".equals(orderBy)) {
                        return Integer.compare(t1.getId(), t2.getId());
                    }
                    return t1.getDescricao().compareTo(t2.getDescricao());
                })
                .toList()
    }


    @GET
    @Path("page/{page}")
    public List<Tarefa> getTarefasPaginadas(
            @PathParam("page") int page, @QueryParam("pageSize")int pageSize )
    {
        try{
            int pagesize = 2;
            int fromIndex = (page -1) *pagesize;
            if (fromIndex + pagesize >= tarefas.size()){
                return tarefas.subList(fromIndex -1,tarefas.size());
        }
            return tarefas.subList(fromIndex,fromIndex+ pagesize);
        } catch (Exception e){
            return new ArrayList<Tarefa>();
        }

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tarefa> getTarefas(){
        return tarefas;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getTarefa(@PathParam("id") int id){
        Tarefa t=  tarefas.stream()
                .filter(tarefa -> tarefa.getId() == id)
                .findFirst()
                .orElse(null);

        if(t != null)
            return Response.status(Response.Status.OK).entity(t).build();
        return Response.status(Response.Status.NOT_FOUND).build();

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addTarefa(Tarefa novaTarefa){
        tarefas.add(novaTarefa);
        return Response.status(Response.Status.CREATED).entity(novaTarefa).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateTarefa(@PathParam("id") int id, Tarefa tarefaAtualizada){
        tarefas.stream().filter(tarefa -> tarefa.getId() == id).forEach(tarefa -> tarefa.setDescricao(tarefaAtualizada.getDescricao()));
    }


    @DELETE
    @Path("{id}")
    public void deleteTarefa(@PathParam("id") int id){
        tarefas.removeIf(tarefa -> tarefa.getId() == id);
    }
}
