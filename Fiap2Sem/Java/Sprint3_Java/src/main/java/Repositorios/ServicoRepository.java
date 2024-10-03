package Repositorios;

import Entidade.Servico;
import Infraestrutura.DatabeConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ServicoRepository implements _CrudRepository<Servico> {

    @Override
    public void Insert(Servico servico) {
        String query = "INSERT INTO SERVICO (ID_SERVICO, DESCRICAO, PRECO, DURACAO_ESTIMADA, ID_CARRO) " +
                "VALUES (servico_seq.NEXTVAL, ?, ?, ?, ?)";
        try (Connection conn = DatabeConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, servico.getDescricao());
            stmt.setDouble(2, servico.getPreco());
            stmt.setInt(3, servico.getDuracaoEstimadas());
            stmt.setInt(4, servico.getIdCarro());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Update(Servico servico, int id) {
        String query = "UPDATE SERVICO SET DESCRICAO = ?, PRECO = ?, DURACAO_ESTIMADA = ?, ID_CARRO = ? WHERE ID_SERVICO = ?";
        try (Connection conn = DatabeConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, servico.getDescricao());
            stmt.setDouble(2, servico.getPreco());
            stmt.setInt(3, servico.getDuracaoEstimadas());
            stmt.setInt(4, servico.getIdCarro());
            stmt.setInt(5, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Delete(int id) {
        String query = "DELETE FROM SERVICO WHERE ID_SERVICO = ?";
        try (Connection conn = DatabeConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Servico> GetById(int id) {
        Optional<Servico> servico = Optional.empty();
        String query = "SELECT * FROM SERVICO WHERE ID_SERVICO = ?";
        try (Connection conn = DatabeConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int rsId = rs.getInt("ID_SERVICO");
                String rsDescricao = rs.getString("DESCRICAO");
                double rsPreco = rs.getDouble("PRECO");
                int rsDuracao = rs.getInt("DURACAO_ESTIMADA");
                int rsIdCarro = rs.getInt("ID_CARRO");
                servico = Optional.of(new Servico(rsId, rsDescricao, rsPreco, rsDuracao, rsIdCarro));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return servico;
    }

    @Override
    public List<Servico> GetAll() {
        List<Servico> servicos = new ArrayList<>();
        String query = "SELECT * FROM SERVICO ORDER BY ID_SERVICO";
        try (Connection conn = DatabeConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int rsId = rs.getInt("ID_SERVICO");
                String rsDescricao = rs.getString("DESCRICAO");
                double rsPreco = rs.getDouble("PRECO");
                int rsDuracao = rs.getInt("DURACAO_ESTIMADA");
                int rsIdCarro = rs.getInt("ID_CARRO");
                servicos.add(new Servico(rsId, rsDescricao, rsPreco, rsDuracao, rsIdCarro));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return servicos;
    }
}

