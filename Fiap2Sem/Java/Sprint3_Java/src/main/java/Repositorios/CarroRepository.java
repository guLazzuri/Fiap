package Repositorios;

import Entidade.Carro;
import Infraestrutura.DatabeConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CarroRepository implements _CrudRepository<Carro> {

    @Override
    public void Insert(Carro carro) {
        String query = "INSERT INTO CARRO (ID_CARRO, PLACA, MARCA, MODELO, ANO, COR, KM) " +
                "VALUES (carro_seq.NEXTVAL, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabeConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, carro.getPlaca());
            stmt.setString(2, carro.getMarca());
            stmt.setString(3, carro.getModelo());
            stmt.setInt(4, carro.getAno());
            stmt.setString(5, carro.getCor());
            stmt.setInt(6, carro.getKm());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Update(Carro carro, int id) {
        String query = "UPDATE CARRO SET PLACA = ?, MARCA = ?, MODELO = ?, ANO = ?, COR = ?, KM = ? WHERE ID_CARRO = ?";
        try (Connection conn = DatabeConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, carro.getPlaca());
            stmt.setString(2, carro.getMarca());
            stmt.setString(3, carro.getModelo());
            stmt.setInt(4, carro.getAno());
            stmt.setString(5, carro.getCor());
            stmt.setInt(6, carro.getKm());
            stmt.setInt(7, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Delete(int id) {
        String query = "DELETE FROM CARRO WHERE ID_CARRO = ?";
        try (Connection conn = DatabeConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Carro> GetById(int id) {
        Optional<Carro> carro = Optional.empty();
        String query = "SELECT * FROM CARRO WHERE ID_CARRO = ?";
        try (Connection conn = DatabeConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int rsId = rs.getInt("ID_CARRO");
                String rsPlaca = rs.getString("PLACA");
                String rsMarca = rs.getString("MARCA");
                String rsModelo = rs.getString("MODELO");
                int rsAno = rs.getInt("ANO");
                String rsCor = rs.getString("COR");
                int rsKm = rs.getInt("KM");
                carro = Optional.of(new Carro(rsId, rsPlaca, rsMarca, rsModelo, rsAno, rsCor, rsKm));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carro;
    }

    @Override
    public List<Carro> GetAll() {
        List<Carro> carros = new ArrayList<>();
        String query = "SELECT * FROM CARRO ORDER BY ID_CARRO";
        try (Connection conn = DatabeConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int rsId = rs.getInt("ID_CARRO");
                String rsPlaca = rs.getString("PLACA");
                String rsMarca = rs.getString("MARCA");
                String rsModelo = rs.getString("MODELO");
                int rsAno = rs.getInt("ANO");
                String rsCor = rs.getString("COR");
                int rsKm = rs.getInt("KM");
                carros.add(new Carro(rsId, rsPlaca, rsMarca, rsModelo, rsAno, rsCor, rsKm));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carros;
    }
}
