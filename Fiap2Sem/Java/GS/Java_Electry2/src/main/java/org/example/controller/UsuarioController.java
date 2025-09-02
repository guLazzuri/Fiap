package org.example.controller;


import org.example.dto.UsuarioDto;
import org.example.exceptions.*;
import org.example.model.Usuario;
import org.example.service.UsuarioService;
import org.example.service.UsuarioServiceFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Path("/usuario")
public class UsuarioController {

    private UsuarioService usuarioService = UsuarioServiceFactory.create();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUsuarios() {
        try {
            List<Usuario> usuarios = usuarioService.getAllUsuarios();
            List<UsuarioDto> dtos = usuarios.stream().map(this::mapToDto).collect(Collectors.toList());
            return Response.ok(dtos).build();

        } catch (SQLException e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsuarioById(@PathParam("id") Long id){
        try{
            Usuario usuario = usuarioService.getUsuarioById(id);
            if (usuario != null){
                return Response.ok(mapToDto(usuario)).build();
            }else{
                return Response.status(Response.Status.NOT_FOUND).entity(Map.of("mensagem", "ID não existente")).build();
            }
        } catch (SQLException e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }



    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUsuario(UsuarioDto usuarioDto) {
        try {
            Usuario usuario = new Usuario();
            usuario.setNome(usuarioDto.getNome());
            usuario.setEmail(usuarioDto.getEmail());
            usuario.setSenha(usuarioDto.getSenha());
            usuario.setNumeroCpf(usuarioDto.getNumeroCpf());
            usuario.setIdade(usuarioDto.getIdade());
            usuario.setNumeroTelefone(usuarioDto.getNumeroTelefone());
            usuario.setNumeroCep(usuarioDto.getNumeroCep());
            usuario.setEndereco(usuarioDto.getEndereco());
            usuarioService.createUsuario(usuario);
            return Response.status(Response.Status.CREATED).entity(usuario).build();
        } catch (UsuarioNotAutorizedException | UsuarioInvalidException | SenhaInvalidException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        } catch (ExceptionNotCreated | SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(Map.of("mensagem", "não foi possível salvar o registro")).build();
        }
    }



    @DELETE
    @Path("/{id}")
    public Response deleteUsuario(@PathParam("id") Long id)  {
        try{
            usuarioService.deleteUsuario(id);
            return Response.noContent().build();
        } catch (SQLException e) {
            return Response.serverError().entity(e.getMessage()).build();
        } catch (ExceptionNotFound e){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUsuario(@PathParam("id") Long id, UsuarioDto usuarioDto) {
        try {
            Usuario usuario = usuarioService.getUsuarioById(id);
            if (usuario != null) {
                usuario.setNome(usuarioDto.getNome());
                usuario.setEmail(usuarioDto.getEmail());
                usuario.setSenha(usuarioDto.getSenha());
                usuario.setNumeroCpf(usuarioDto.getNumeroCpf());
                usuario.setIdade(usuarioDto.getIdade());
                usuario.setNumeroTelefone(usuarioDto.getNumeroTelefone());
                usuario.setNumeroCep(usuarioDto.getNumeroCep());
                usuario.setEndereco(usuarioDto.getEndereco());

                usuarioService.updateUsuario(usuario);
                return Response.ok(usuario).build();
            }else{
                return Response.status(Response.Status.NOT_FOUND).entity(Map.of("mensagem", "ID não existente")).build();
            }
        } catch (SQLException | ExceptionNotUpdate e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    private UsuarioDto mapToDto (Usuario usuario){
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setId(usuario.getId());
        usuarioDto.setNome(usuario.getNome());
        usuarioDto.setEmail(usuario.getEmail());
        usuarioDto.setSenha(usuario.getSenha());
        usuarioDto.setNumeroCpf(usuario.getNumeroCpf());
        usuarioDto.setIdade(usuario.getIdade());
        usuarioDto.setNumeroTelefone(usuario.getNumeroTelefone());
        usuarioDto.setNumeroCep(usuario.getNumeroCep());
        usuarioDto.setEndereco(usuario.getEndereco());


        return usuarioDto;
    }
}
