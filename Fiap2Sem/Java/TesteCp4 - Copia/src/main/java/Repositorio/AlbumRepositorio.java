package Repositorio;


import AEntidades.Album;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlbumRepositorio implements RepositorioGenerico<Album> {
    private Connection connection;

    public AlbumRepositorio(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void adicionar(Album entidade) {
        try {
            String query = "INSERT INTO ALBUNS (ID, TITULO, ANO_DE_LANCAMENTO, ARTISTA) VALUES (DEFAULT, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, entidade.getTitulo());
            stmt.setInt(2, entidade.getAnoDeLancamento());
            stmt.setString(3, entidade.getArtista());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Album> listar() {
        List<Album> albuns = new ArrayList<>();
        try {
            String query = "SELECT * FROM ALBUNS";
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("ID");
                String titulo = rs.getString("TITULO");
                int anoDeLancamento = rs.getInt("ANO_DE_LANCAMENTO");
                String artista = rs.getString("ARTISTA");
                albuns.add(new Album(id, titulo, anoDeLancamento, artista, new ArrayList<>()));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return albuns;
    }

    @Override
    public void removerPorId(String id) {
        try {
            String query = "DELETE FROM ALBUNS WHERE ID = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, id);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void atualizarPorNome(String nome, Album novoAlbum) {
        try {
            // Aqui você pode usar o título para encontrar o álbum a ser atualizado
            String query = "UPDATE ALBUNS SET TITULO = ?, ANO_DE_LANCAMENTO = ?, ARTISTA = ? WHERE TITULO = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, novoAlbum.getTitulo());
            stmt.setInt(2, novoAlbum.getAnoDeLancamento());
            stmt.setString(3, novoAlbum.getArtista());
            stmt.setString(4, nome); // Usando o nome do álbum para identificar qual atualizar
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
