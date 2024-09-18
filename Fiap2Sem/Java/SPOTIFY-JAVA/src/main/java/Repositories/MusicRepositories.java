package Repositories;

import Infrastructure.DatabeConfig;
import entities.Artist;
import entities.Music;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MusicRepositories implements _CrudRepositorie<Music> {


    @Override
    public void Insert(Music music) {
        try{
            // 1- Registrar o driver, e fazer a conexão
            var conn = DatabeConfig.getConnection();
            // 2 - Criar o statement e definir a query
            var query =
                    "INSERT INTO PRODUTOS (ID,NAME, YEAR, DURATION) VALUES (DEFAULT,?,?)";
            var stmt = conn.prepareStatement(query);
            // 2.1 - Setar os valores, substituindo os ? da query
            // eu nao posso só concatenar a query com os valores, pois isso pode ser um risco de segurança
            // por causa do SQL Injection
            stmt.setInt(1,music.getId());
            stmt.setString(2, music.getName());
            stmt.setString(3, music.getYear());
            stmt.setInt(4, music.getDuration());
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
    public void Update(Music music, int id) {
        try{
            var conn = DatabeConfig.getConnection();
            var query = "UPDATE PRODUTOS SET NAME = ?, YEAR = ?, DURATION = ?, WHERE ID = ?";
            var stmt = conn.prepareStatement(query);
            stmt.setInt(1,music.getId());
            stmt.setString(2, music.getName());
            stmt.setString(3, music.getYear());
            stmt.setInt(4, music.getDuration());
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
    public Optional<Music> GetById(int id) {
        return Optional.empty();
    }

    public List<Music> GetByName(String name){
        var musics = new ArrayList<Music>();
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
                musics.add(new Music(_id, nome, genre,listMusic));
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

        return musics;
    }

    @Override
    public List<Music> GetAll() {
        var musics = new ArrayList<Music>();
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
                musics.add(new Music(_id, nome, genre,listMusic));
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

        return musics;
    }
}
