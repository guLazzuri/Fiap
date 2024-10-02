package Repositories;

import Infrastructure.DatabeConfig;
import entities.Artist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ArtistRepositories implements _CrudRepositorie<Artist> {

    @Override
    public void Insert(Artist artist) {
        String query = "INSERT INTO ARTIST (ID, NAME, GENRE) VALUES (artist_seq.NEXTVAL, ?, ?)";
        try (Connection conn = DatabeConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, artist.getName());
            stmt.setString(2, artist.getGenre());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Update(Artist artist, int id) {
        String query = "UPDATE ARTIST SET NAME = ?, GENRE = ? WHERE ID = ?";
        try (Connection conn = DatabeConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, artist.getName());
            stmt.setString(2, artist.getGenre());
            stmt.setInt(3, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Delete(int id) {
        String query = "DELETE FROM ARTIST WHERE ID = ?";
        try (Connection conn = DatabeConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Artist> GetById(int id) {
        Optional<Artist> artist = Optional.empty();
        String query = "SELECT * FROM ARTIST WHERE ID = ?";
        try (Connection conn = DatabeConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int rsId = rs.getInt("ID");
                String rsNome = rs.getString("NAME");
                String rsGenre = rs.getString("GENRE");
                artist = Optional.of(new Artist(rsId, rsNome, rsGenre));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return artist;
    }

    @Override
    public List<Artist> GetAll() {
        List<Artist> artists = new ArrayList<>();
        String query = "SELECT * FROM ARTIST ORDER BY ID";
        try (Connection conn = DatabeConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int rsId = rs.getInt("ID");
                String nome = rs.getString("NAME");
                String genre = rs.getString("GENRE");
                artists.add(new Artist(rsId, nome, genre));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return artists;
    }
}
