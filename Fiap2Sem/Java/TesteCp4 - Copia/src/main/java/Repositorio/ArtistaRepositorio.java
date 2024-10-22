package Repositorio;

import AEntidades.Artista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArtistaRepositorio implements RepositorioGenerico<Artista> {
    private Connection connection;

    public ArtistaRepositorio(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void adicionar(Artista entidade) {
        try {
            String query = "INSERT INTO ARTISTAS (ID, NOME, GENERO_MUSICAL) VALUES (DEFAULT, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, entidade.getNome());
            stmt.setString(2, entidade.getGeneroMusical());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Artista> listar() {
        List<Artista> artistas = new ArrayList<>();
        try {
            String query = "SELECT * FROM ARTISTAS";
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("ID");
                String nome = rs.getString("NOME");
                String generoMusical = rs.getString("GENERO_MUSICAL");
                artistas.add(new Artista(id, nome, generoMusical, new ArrayList<>()));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return artistas;
    }

    @Override
    public void removerPorId(String id) {
        try {
            String query = "DELETE FROM ARTISTAS WHERE ID = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, id);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizarPorNome(String nome, Artista novoArtista) {
        try {
            String query = "UPDATE ARTISTAS SET NOME = ?, GENERO_MUSICAL = ? WHERE NOME = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, novoArtista.getNome());
            stmt.setString(2, novoArtista.getGeneroMusical());
            stmt.setString(3, nome);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
