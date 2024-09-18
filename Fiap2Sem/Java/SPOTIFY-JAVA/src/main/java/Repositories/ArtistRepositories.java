package Repositories;

import Infrastructure.DatabeConfig;
import entities.Artist;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ArtistRepositories implements _CrudRepositorie<Artist> {
    @Override
    public void Insert(Artist artist) {
        try{
            // 1- Registrar o driver, e fazer a conexão
            var conn = DatabeConfig.getConnection();
            // 2 - Criar o statement e definir a query
            var query =
                    "INSERT INTO ARTIST (NAME, GENRE) VALUES (?, ?)";
            var stmt = conn.prepareStatement(query);
            // 2.1 - Setar os valores, substituindo os ? da query
            // eu nao posso só concatenar a query com os valores, pois isso pode ser um risco de segurança
            // por causa do SQL Injection
            stmt.setString(1,artist.getName());
            stmt.setString(2, artist.getGenre());

            // 3 - Executar a query
            stmt.executeUpdate();
            // 4 - Fechar o statement
            stmt.close();
            // 5 - Fechar a conexão
            conn.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }


    @Override
    public void Update(Artist artist, int id) {
        try{
            var conn = DatabeConfig.getConnection();
            var query = "UPDATE PRODUTOS WHERE NAME = ?, SET GENRE = ?";
            var stmt = conn.prepareStatement(query);
            stmt.setString(1, artist.getName());
            stmt.setString(2, artist.getGenre());
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Delete(int id) {
        try{
            // 1- Registrar o driver, e fazer a conexão
            var conn = DatabeConfig.getConnection();
            // 2 - Criar o statement e definir a query
            var query =
                    "DELETE FROM ARTIST WHERE ID = ?";
            var stmt = conn.prepareStatement(query);
            // 2.1 - Setar os valores, substituindo os ? da query
            // eu nao posso só concatenar a query com os valores, pois isso pode ser um risco de segurança
            // por causa do SQL Injection
            stmt.setInt(1, id);
            // 3 - Executar a query
            stmt.executeUpdate();
            // 4 - Fechar o statement
            stmt.close();
            // 5 - Fechar a conexão
            conn.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Artist> GetById(int id) {
        Optional<Artist> artist = Optional.empty();
        try{
            var conn = DatabeConfig.getConnection(); // 1- Registrar o driver, e fazer a conexão
            var query = "SELECT * FROM ARTIST WHERE ID = ?"; // 2 - Criar o statement e definir a query
            var stmt = conn.prepareStatement(query);
            stmt.setInt(1, id); // 2.1 - Setar os valores, substituindo os ? da query
            var rs = stmt.executeQuery(); // 3 - Executar a query
            if(rs.next()){ // 4 - Iterar sobre o resultado
                var rsId = rs.getInt("ID");
                var rsNome = rs.getString("NAME");
                var rsGenre = rs.getString("GENRE");
                artist = Optional.of(new Artist(rsId, rsNome, rsGenre));
            }
            rs.close(); // 5 - Fechar o resultset
            stmt.close(); // 6 - Fechar o statement
            conn.close(); // 7 - Fechar a conexão
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return artist;
    }


    @Override
    public List<Artist> GetAll() {
        List<Artist> artists = new ArrayList<>();
        try{
            // 1- Registrar o driver, e fazer a conexão
            var conn = DatabeConfig.getConnection();
            // 2 - Criar o statement e definir a query
            var query = "SELECT * FROM ARTIST ORDER BY ID";
            var stmt = conn.prepareStatement(query);
            // 3 - Executar a query
            var rs = stmt.executeQuery();
            // 4 - Iterar sobre o resultado
            while (rs.next()){
                var rsId = rs.getInt("ID");
                var nome = rs.getString("NAME");
                var genre = rs.getString("GENRE");
                artists.add(new Artist(rsId, nome, genre));
            }
            // 5 - Fechar o resultset
            rs.close();
            // 6 - Fechar o statement
            stmt.close();
            // 7 - Fechar a conexão
            conn.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return artists;
    }
}
