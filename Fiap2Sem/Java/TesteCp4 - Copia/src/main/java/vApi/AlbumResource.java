package vApi;

import AEntidades.Album;
import CServicos.AlbumService;
import Repositorio.AlbumRepositorio;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/albuns")
public class AlbumResource {

    private AlbumRepositorio albumRepositorio;
    private AlbumService albumService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response cadastrarAlbum(Album album) {
        try {
            albumRepositorio.adicionar(album);
            return Response.status(Response.Status.CREATED).entity(album).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarAlbuns() {
        List<Album> albuns = albumService.Listar();
        return Response.ok(albuns).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Album> getAlbum(){
        return albumRepositorio.listar();
    }

    @GET
    @Path("/{nome}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarAlbum(@PathParam("nome")String nome,Album novoAlbum){
        albumRepositorio.atualizarPorNome(nome, novoAlbum);
        return Response.ok(novoAlbum).build();
    }

    @DELETE
    @Path("/{id}")
    public Response excluirAlbum(@PathParam("id") String id) {
        albumRepositorio.removerPorId(id);
        return Response.noContent().build();
    }








}
