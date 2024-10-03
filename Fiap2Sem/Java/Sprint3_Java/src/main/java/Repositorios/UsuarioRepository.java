package Repositorios;

import Entidade.Usuario;
import Infraestrutura.DatabeConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioRepository implements _CrudRepository<Usuario> {

    @Override
    public void Insert(Usuario usuario) {
        String query = "INSERT INTO USUARIO (ID_USUARIO, NOME, EMAIL, SENHA, TELEFONE, ENDERECO, DATA_NASCIMENTO, DATA_CADASTRO) " +
                "VALUES (usuario_seq.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabeConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            stmt.setString(4, usuario.getTelefone());
            stmt.setString(5, usuario.getEndereco());
            stmt.setString(6, usuario.getDataNascimento());
            stmt.setString(7, usuario.getDataCadastro());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Update(Usuario usuario, int id) {
        String query = "UPDATE USUARIO SET NOME = ?, EMAIL = ?, SENHA = ?, TELEFONE = ?, ENDERECO = ?, DATA_NASCIMENTO = ?, DATA_CADASTRO = ? WHERE ID_USUARIO = ?";
        try (Connection conn = DatabeConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            stmt.setString(4, usuario.getTelefone());
            stmt.setString(5, usuario.getEndereco());
            stmt.setString(6, usuario.getDataNascimento());
            stmt.setString(7, usuario.getDataCadastro());
            stmt.setInt(8, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Delete(int id) {
        String query = "DELETE FROM USUARIO WHERE ID_USUARIO = ?";
        try (Connection conn = DatabeConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Usuario> GetById(int id) {
        Optional<Usuario> usuario = Optional.empty();
        String query = "SELECT * FROM USUARIO WHERE ID_USUARIO = ?";
        try (Connection conn = DatabeConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int rsId = rs.getInt("ID_USUARIO");
                String rsNome = rs.getString("NOME");
                String rsEmail = rs.getString("EMAIL");
                String rsSenha = rs.getString("SENHA");
                String rsTelefone = rs.getString("TELEFONE");
                String rsEndereco = rs.getString("ENDERECO");
                String rsDataNascimento = rs.getString("DATA_NASCIMENTO");
                String rsDataCadastro = rs.getString("DATA_CADASTRO");
                usuario = Optional.of(new Usuario(rsId, rsNome, rsEmail, rsSenha, rsTelefone, rsEndereco, rsDataNascimento, rsDataCadastro));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    @Override
    public List<Usuario> GetAll() {
        List<Usuario> usuarios = new ArrayList<>();
        String query = "SELECT * FROM USUARIO ORDER BY ID_USUARIO";
        try (Connection conn = DatabeConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int rsId = rs.getInt("ID_USUARIO");
                String rsNome = rs.getString("NOME");
                String rsEmail = rs.getString("EMAIL");
                String rsSenha = rs.getString("SENHA");
                String rsTelefone = rs.getString("TELEFONE");
                String rsEndereco = rs.getString("ENDERECO");
                String rsDataNascimento = rs.getString("DATA_NASCIMENTO");
                String rsDataCadastro = rs.getString("DATA_CADASTRO");
                usuarios.add(new Usuario(rsId, rsNome, rsEmail, rsSenha, rsTelefone, rsEndereco, rsDataNascimento, rsDataCadastro));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }
}

