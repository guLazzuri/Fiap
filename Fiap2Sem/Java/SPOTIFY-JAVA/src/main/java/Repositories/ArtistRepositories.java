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
                    "INSERT INTO PRODUTOS (ID,NAME, GENRE, LISTMUSIC) VALUES (DEFAULT,?,?)";
            var stmt = conn.prepareStatement(query);
            // 2.1 - Setar os valores, substituindo os ? da query
            // eu nao posso só concatenar a query com os valores, pois isso pode ser um risco de segurança
            // por causa do SQL Injection
            stmt.setInt(1,artist.getId());
            stmt.setString(2, artist.getName());
            stmt.setString(3, artist.getGenre());
            stmt.setString(4, artist.getListMusic());
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
            var query = "UPDATE PRODUTOS SET NAME = ?, GENRE = ?, LISTMUSIC = ?, WHERE ID = ?";
            var stmt = conn.prepareStatement(query);
            stmt.setInt(1,artist.getId());
            stmt.setString(2, artist.getName());
            stmt.setString(3, artist.getGenre());
            stmt.setString(4, artist.getListMusic());
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
                    "DELETE FROM PRODUTOS WHERE ID = ?";
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
            var query = "SELECT * FROM PRODUTOS WHERE ID = ?"; // 2 - Criar o statement e definir a query
            var stmt = conn.prepareStatement(query);
            stmt.setInt(1, id); // 2.1 - Setar os valores, substituindo os ? da query
            var rs = stmt.executeQuery(); // 3 - Executar a query
            if(rs.next()){ // 4 - Iterar sobre o resultado
                var _id = rs.getInt("ID");
                var name = rs.getString("NAME");
                var genre = rs.getString("GENRE");
                var listMusic = rs.getString("LISTMUSIC");
                artist = Optional.of(new Artist(_id,name,genre,listMusic));
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

    public List<Artist> GetByName(String name){
        var artists = new ArrayList<Artist>();
        try{
            // 1- Registrar o driver, e fazer a conexão
            var conn = DatabeConfig.getConnection();
            // 2 - Criar o statement e definir a query
            var query = "SELECT * FROM ARTIST WHERE NAME LIKE ? ORDER BY ID";
            var stmt = conn.prepareStatement(query);
            stmt.setString(1, "%" + name + "%");
            // 3 - Executar a query
            var rs = stmt.executeQuery();
            // 4 - Iterar sobre o resultado
            while (rs.next()){
                var _id = rs.getInt("ID");
                var nome = rs.getString("NAME");
                var genre = rs.getString("GENRE");
                var listMusic = rs.getString("LISTMUSIC");
                artists.add(new Artist(_id, nome, genre,listMusic));
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

    @Override
    public List<Artist> GetAll() {
        var artists = new ArrayList<Artist>();
        try{
            // 1- Registrar o driver, e fazer a conexão
            var conn = DatabeConfig.getConnection();
            // 2 - Criar o statement e definir a query
            var query = "SELECT * FROM PRODUTOS ORDER BY ID";
            var stmt = conn.prepareStatement(query);
            // 3 - Executar a query
            var rs = stmt.executeQuery();
            // 4 - Iterar sobre o resultado
            while (rs.next()){
                var _id = rs.getInt("ID");
                var nome = rs.getString("NAME");
                var genre = rs.getString("GENRE");
                var listMusic = rs.getString("LISTMUSIC");
                artists.add(new Artist(_id, nome, genre,listMusic));
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
