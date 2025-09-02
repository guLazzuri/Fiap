package vApi;

import AEntidades.Album;
import CServicos.AlbumService;
import Repositorio.AlbumRepositorio;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/albuns")
public class AlbumResource {

    @Inject
    private AlbumRepositorio albumRepositorio;

    @Inject
    private AlbumService albumService;

    // Endpoint para cadastrar um novo álbum
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

    // Endpoint para listar todos os álbuns
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarAlbuns() {
        List<Album> albuns = albumRepositorio.listar();
        return Response.ok(albuns).build();
    }

    // Endpoint para atualizar um álbum pelo nome
    @PUT
    @Path("/{nome}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizarAlbum(@PathParam("nome") String nome, Album novoAlbum) {
        try {
            albumRepositorio.atualizarPorNome(nome, novoAlbum);
            return Response.ok(novoAlbum).build();
        } catch (Exception e) {  // Tratamento caso o álbum não seja encontrado
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Álbum com nome " + nome + " não encontrado.").build();
        }
    }

    // Endpoint para excluir um álbum pelo ID
    @DELETE
    @Path("/{id}")
    public Response excluirAlbum(@PathParam("id") String id) {
        try {
            albumRepositorio.removerPorId(id);
            return Response.noContent().build();
        } catch (Exception e) { // Tratamento caso o ID não seja encontrado
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Álbum com ID " + id + " não encontrado.").build();
        }
    }
}
