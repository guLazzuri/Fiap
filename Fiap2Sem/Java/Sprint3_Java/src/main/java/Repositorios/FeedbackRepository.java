package Repositorios;

import Entidade.Feedback;
import Infraestrutura.DatabeConfig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FeedbackRepository implements _CrudRepository<Feedback> {

    @Override
    public void Insert(Feedback feedback) {
        String query = "INSERT INTO FEEDBACK (ID_FEEDBACK, ID_USUARIO, ID_AGENDAMENTO, NOTA, COMENTARIOS) " +
                "VALUES (feedback_seq.NEXTVAL, ?, ?, ?, ?)";
        try (Connection conn = DatabeConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, feedback.getIdUsuario());
            stmt.setInt(2, feedback.getIdAgendamento());
            stmt.setInt(3, feedback.getNota());
            stmt.setString(4, feedback.getComentarios());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Update(Feedback feedback, int id) {
        String query = "UPDATE FEEDBACK SET ID_USUARIO = ?, ID_AGENDAMENTO = ?, NOTA = ?, COMENTARIOS = ? WHERE ID_FEEDBACK = ?";
        try (Connection conn = DatabeConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, feedback.getIdUsuario());
            stmt.setInt(2, feedback.getIdAgendamento());
            stmt.setInt(3, feedback.getNota());
            stmt.setString(4, feedback.getComentarios());
            stmt.setInt(5, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Delete(int id) {
        String query = "DELETE FROM FEEDBACK WHERE ID_FEEDBACK = ?";
        try (Connection conn = DatabeConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Feedback> GetById(int id) {
        Optional<Feedback> feedback = Optional.empty();
        String query = "SELECT * FROM FEEDBACK WHERE ID_FEEDBACK = ?";
        try (Connection conn = DatabeConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int rsId = rs.getInt("ID_FEEDBACK");
                int rsIdUsuario = rs.getInt("ID_USUARIO");
                int rsIdAgendamento = rs.getInt("ID_AGENDAMENTO");
                int rsNota = rs.getInt("NOTA");
                String rsComentarios = rs.getString("COMENTARIOS");
                feedback = Optional.of(new Feedback(rsId, rsIdUsuario, rsIdAgendamento, rsNota, rsComentarios));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return feedback;
    }

    @Override
    public List<Feedback> GetAll() {
        List<Feedback> feedbacks = new ArrayList<>();
        String query = "SELECT * FROM FEEDBACK ORDER BY ID_FEEDBACK";
        try (Connection conn = DatabeConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int rsId = rs.getInt("ID_FEEDBACK");
                int rsIdUsuario = rs.getInt("ID_USUARIO");
                int rsIdAgendamento = rs.getInt("ID_AGENDAMENTO");
                int rsNota = rs.getInt("NOTA");
                String rsComentarios = rs.getString("COMENTARIOS");
                feedbacks.add(new Feedback(rsId, rsIdUsuario, rsIdAgendamento, rsNota, rsComentarios));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return feedbacks;
    }
}

