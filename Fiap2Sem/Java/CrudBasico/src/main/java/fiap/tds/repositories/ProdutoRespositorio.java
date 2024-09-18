package fiap.tds.repositories;

import fiap.tds.entities.Produto;
import fiap.tds.infrastructure.DatabaseConfig;

import javax.swing.text.html.Option;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProdutoRespositorio implements _CrudRepositorio<Produto> {

    @Override
    public void Insert(Produto produto){
        try{
            // 1- Registrar o driver, e fazer a conexão
            var conn = DatabaseConfig.getConnection();
            // 2 - Criar o statement e definir a query
            var query =
                    "INSERT INTO PRODUTOS (ID,NOME, PRECO) VALUES (DEFAULT,?,?)";
            var stmt = conn.prepareStatement(query);
            // 2.1 - Setar os valores, substituindo os ? da query
            // eu nao posso só concatenar a query com os valores, pois isso pode ser um risco de segurança
            // por causa do SQL Injection
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
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
    public void Update(Produto entity, int id) {
        try{
            var conn = DatabaseConfig.getConnection();
            var query = "UPDATE PRODUTOS SET NOME = ?, PRECO = ? WHERE ID = ?";
            var stmt = conn.prepareStatement(query);
            stmt.setString(1, entity.getNome());
            stmt.setDouble(2, entity.getPreco());
            stmt.setInt(3, id);
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
            var conn = DatabaseConfig.getConnection();
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

    // O optional é um tipo de dado que pode ou não ter um valor
    // ele é usado para evitar o nullpointerexception
    // ele foi introduzido no java 8
    // ele é bastante usado em CRUD para representar um objeto que pode ou não existir
    @Override
    public Optional<Produto> GetById(int id) {
        Optional<Produto> produto = Optional.empty();
        try{
            var conn = DatabaseConfig.getConnection(); // 1- Registrar o driver, e fazer a conexão
            var query = "SELECT * FROM PRODUTOS WHERE ID = ?"; // 2 - Criar o statement e definir a query
            var stmt = conn.prepareStatement(query);
            stmt.setInt(1, id); // 2.1 - Setar os valores, substituindo os ? da query
            var rs = stmt.executeQuery(); // 3 - Executar a query
            if(rs.next()){ // 4 - Iterar sobre o resultado
                var _id = rs.getInt("ID");
                var nome = rs.getString("NOME");
                var preco = rs.getDouble("PRECO");
                produto = Optional.of(new Produto(_id, nome, preco));
            }
            rs.close(); // 5 - Fechar o resultset
            stmt.close(); // 6 - Fechar o statement
            conn.close(); // 7 - Fechar a conexão
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return produto;
    }

    public List<Produto> GetByName(String name){
        var produtos = new ArrayList<Produto>();
        try{
            // 1- Registrar o driver, e fazer a conexão
            var conn = DatabaseConfig.getConnection();
            // 2 - Criar o statement e definir a query
            var query = "SELECT * FROM PRODUTOS WHERE NOME LIKE ? ORDER BY ID";
            var stmt = conn.prepareStatement(query);
            stmt.setString(1, "%" + name + "%");
            // 3 - Executar a query
            var rs = stmt.executeQuery();
            // 4 - Iterar sobre o resultado
            while (rs.next()){
                var id = rs.getInt("ID");
                var nome = rs.getString("NOME");
                var preco = rs.getDouble("PRECO");
                produtos.add(new Produto(id, nome, preco));
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

        return produtos;
    }

    @Override
    public List<Produto> GetAll() {
        var produtos = new ArrayList<Produto>();
        try{
            // 1- Registrar o driver, e fazer a conexão
            var conn = DatabaseConfig.getConnection();
            // 2 - Criar o statement e definir a query
            var query = "SELECT * FROM PRODUTOS ORDER BY ID";
            var stmt = conn.prepareStatement(query);
            // 3 - Executar a query
            var rs = stmt.executeQuery();
            // 4 - Iterar sobre o resultado
            while (rs.next()){
                var id = rs.getInt("ID");
                var nome = rs.getString("NOME");
                var preco = rs.getDouble("PRECO");
                produtos.add(new Produto(id, nome, preco));
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

        return produtos;
    }

}
