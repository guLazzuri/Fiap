package Repositorio;

import AEntidades.Musica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MusicaRepositorio implements RepositorioGenerico<Musica> {
    private Connection connection;

    public MusicaRepositorio(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void adicionar(Musica entidade) {
        try {
            String query = "INSERT INTO MUSICAS (ID, TITULO, ALBUM, DURACAO) VALUES (DEFAULT, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, entidade.getTitulo());
            stmt.setString(2, entidade.getAlbum());
            stmt.setInt(3, entidade.getDuracao());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Musica> listar() {
        List<Musica> musicas = new ArrayList<>();
        try {
            String query = "SELECT * FROM MUSICAS";
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("ID");
                String titulo = rs.getString("TITULO");
                String album = rs.getString("ALBUM");
                int duracao = rs.getInt("DURACAO");
                musicas.add(new Musica(id, titulo, album, duracao));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return musicas;
    }

    @Override
    public void removerPorId(String id) {
        try {
            String query = "DELETE FROM MUSICAS WHERE ID = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, id);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizarPorNome(String nome, Musica novaMusica) {
        try {
            String query = "UPDATE MUSICAS SET TITULO = ?, ALBUM = ?, DURACAO = ? WHERE TITULO = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, novaMusica.getTitulo());
            stmt.setString(2, novaMusica.getAlbum());
            stmt.setInt(3, novaMusica.getDuracao());
            stmt.setString(4, nome);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
