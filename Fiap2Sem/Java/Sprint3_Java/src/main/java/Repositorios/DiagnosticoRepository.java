package Repositorios;
import Entidade.Diagnostico;
import Infraestrutura.DatabeConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DiagnosticoRepository implements _CrudRepository<Diagnostico> {

    @Override
    public void Insert(Diagnostico diagnostico) {
        String query = "INSERT INTO DIAGNOSTICO (ID_DIAGNOSTICO, ID_CARRO, DESCRICAO, DATA_DIAGNOSTICO, NOME_MECANICO) " +
                "VALUES (diagnostico_seq.NEXTVAL, ?, ?, ?, ?)";
        try (Connection conn = DatabeConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, diagnostico.getIdCarro());
            stmt.setString(2, diagnostico.getDescricao());
            stmt.setString(3, diagnostico.getDataDiagnostico());
            stmt.setString(4, diagnostico.getNomeMecanico());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Update(Diagnostico diagnostico, int id) {
        String query = "UPDATE DIAGNOSTICO SET ID_CARRO = ?, DESCRICAO = ?, DATA_DIAGNOSTICO = ?, NOME_MECANICO = ? WHERE ID_DIAGNOSTICO = ?";
        try (Connection conn = DatabeConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, diagnostico.getIdCarro());
            stmt.setString(2, diagnostico.getDescricao());
            stmt.setString(3, diagnostico.getDataDiagnostico());
            stmt.setString(4, diagnostico.getNomeMecanico());
            stmt.setInt(5, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Delete(int id) {
        String query = "DELETE FROM DIAGNOSTICO WHERE ID_DIAGNOSTICO = ?";
        try (Connection conn = DatabeConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Diagnostico> GetById(int id) {
        Optional<Diagnostico> diagnostico = Optional.empty();
        String query = "SELECT * FROM DIAGNOSTICO WHERE ID_DIAGNOSTICO = ?";
        try (Connection conn = DatabeConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int rsId = rs.getInt("ID_DIAGNOSTICO");
                int rsIdCarro = rs.getInt("ID_CARRO");
                String rsDescricao = rs.getString("DESCRICAO");
                String rsDataDiagnostico = rs.getString("DATA_DIAGNOSTICO");
                String rsNomeMecanico = rs.getString("NOME_MECANICO");
                diagnostico = Optional.of(new Diagnostico(rsId, rsIdCarro, rsDescricao, rsDataDiagnostico, rsNomeMecanico));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return diagnostico;
    }

    @Override
    public List<Diagnostico> GetAll() {
        List<Diagnostico> diagnosticos = new ArrayList<>();
        String query = "SELECT * FROM DIAGNOSTICO ORDER BY ID_DIAGNOSTICO";
        try (Connection conn = DatabeConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int rsId = rs.getInt("ID_DIAGNOSTICO");
                int rsIdCarro = rs.getInt("ID_CARRO");
                String rsDescricao = rs.getString("DESCRICAO");
                String rsDataDiagnostico = rs.getString("DATA_DIAGNOSTICO");
                String rsNomeMecanico = rs.getString("NOME_MECANICO");
                diagnosticos.add(new Diagnostico(rsId, rsIdCarro, rsDescricao, rsDataDiagnostico, rsNomeMecanico));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return diagnosticos;
    }
}
