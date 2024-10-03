package Repositorios;

import Entidade.Mecanico;
import Infraestrutura.DatabeConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MecanicoRepository implements _CrudRepository<Mecanico> {

    @Override
    public void Insert(Mecanico mecanico) {
        String query = "INSERT INTO MECANICO (ID_MECANICO, NOME, ESPECIALIDADE, TELEFONE, EMAIL) " +
                "VALUES (mecanico_seq.NEXTVAL, ?, ?, ?, ?)";
        try (Connection conn = DatabeConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, mecanico.getNome());
            stmt.setString(2, mecanico.getEspecialidade());
            stmt.setString(3, mecanico.getTelefone());
            stmt.setString(4, mecanico.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Update(Mecanico mecanico, int id) {
        String query = "UPDATE MECANICO SET NOME = ?, ESPECIALIDADE = ?, TELEFONE = ?, EMAIL = ? WHERE ID_MECANICO = ?";
        try (Connection conn = DatabeConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, mecanico.getNome());
            stmt.setString(2, mecanico.getEspecialidade());
            stmt.setString(3, mecanico.getTelefone());
            stmt.setString(4, mecanico.getEmail());
            stmt.setInt(5, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Delete(int id) {
        String query = "DELETE FROM MECANICO WHERE ID_MECANICO = ?";
        try (Connection conn = DatabeConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Mecanico> GetById(int id) {
        Optional<Mecanico> mecanico = Optional.empty();
        String query = "SELECT * FROM MECANICO WHERE ID_MECANICO = ?";
        try (Connection conn = DatabeConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int rsId = rs.getInt("ID_MECANICO");
                String rsNome = rs.getString("NOME");
                String rsEspecialidade = rs.getString("ESPECIALIDADE");
                String rsTelefone = rs.getString("TELEFONE");
                String rsEmail = rs.getString("EMAIL");
                mecanico = Optional.of(new Mecanico(rsId, rsNome, rsEspecialidade, rsTelefone, rsEmail));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mecanico;
    }

    @Override
    public List<Mecanico> GetAll() {
        List<Mecanico> mecanicos = new ArrayList<>();
        String query = "SELECT * FROM MECANICO ORDER BY ID_MECANICO";
        try (Connection conn = DatabeConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int rsId = rs.getInt("ID_MECANICO");
                String rsNome = rs.getString("NOME");
                String rsEspecialidade = rs.getString("ESPECIALIDADE");
                String rsTelefone = rs.getString("TELEFONE");
                String rsEmail = rs.getString("EMAIL");
                mecanicos.add(new Mecanico(rsId, rsNome, rsEspecialidade, rsTelefone, rsEmail));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mecanicos;
    }
}
