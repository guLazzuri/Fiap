package Repositorios;

import Entidade.Problema;
import Infraestrutura.DatabeConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProblemaRepository implements _CrudRepository<Problema> {

    @Override
    public void Insert(Problema problema) {
        String query = "INSERT INTO PROBLEMA (ID_PROBLEMA, ID_DIAGNOSTICO, DESCRICAO, TP_PROBLEMA, STATUS) " +
                "VALUES (problema_seq.NEXTVAL, ?, ?, ?, ?)";
        try (Connection conn = DatabeConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, problema.getIdDiagnostico());
            stmt.setString(2, problema.getDescricao());
            stmt.setString(3, problema.getTpProblema());
            stmt.setString(4, problema.getStatus());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Update(Problema problema, int id) {
        String query = "UPDATE PROBLEMA SET ID_DIAGNOSTICO = ?, DESCRICAO = ?, TP_PROBLEMA = ?, STATUS = ? WHERE ID_PROBLEMA = ?";
        try (Connection conn = DatabeConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, problema.getIdDiagnostico());
            stmt.setString(2, problema.getDescricao());
            stmt.setString(3, problema.getTpProblema());
            stmt.setString(4, problema.getStatus());
            stmt.setInt(5, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Delete(int id) {
        String query = "DELETE FROM PROBLEMA WHERE ID_PROBLEMA = ?";
        try (Connection conn = DatabeConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Problema> GetById(int id) {
        Optional<Problema> problema = Optional.empty();
        String query = "SELECT * FROM PROBLEMA WHERE ID_PROBLEMA = ?";
        try (Connection conn = DatabeConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int rsId = rs.getInt("ID_PROBLEMA");
                int rsIdDiagnostico = rs.getInt("ID_DIAGNOSTICO");
                String rsDescricao = rs.getString("DESCRICAO");
                String rsTpProblema = rs.getString("TP_PROBLEMA");
                String rsStatus = rs.getString("STATUS");
                problema = Optional.of(new Problema(rsId, rsIdDiagnostico, rsDescricao, rsTpProblema, rsStatus));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return problema;
    }

    @Override
    public List<Problema> GetAll() {
        List<Problema> problemas = new ArrayList<>();
        String query = "SELECT * FROM PROBLEMA ORDER BY ID_PROBLEMA";
        try (Connection conn = DatabeConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int rsId = rs.getInt("ID_PROBLEMA");
                int rsIdDiagnostico = rs.getInt("ID_DIAGNOSTICO");
                String rsDescricao = rs.getString("DESCRICAO");
                String rsTpProblema = rs.getString("TP_PROBLEMA");
                String rsStatus = rs.getString("STATUS");
                problemas.add(new Problema(rsId, rsIdDiagnostico, rsDescricao, rsTpProblema, rsStatus));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return problemas;
    }
}
