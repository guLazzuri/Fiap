package Repository;

import Entities.Products;
import Infraestrutura.DatabeConfig;
import Repository._CrudRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductsRepository implements _CrudRepository<Products> {

    @Override
    public void Insert(Products product) {
        String query = "INSERT INTO PRODUCTS (ID_PRODUCT, NAME, QTD, TYPE, PRICE) VALUES (product_seq.NEXTVAL, ?, ?, ?, ?)";
        try (Connection conn = DatabeConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, product.getName());
            stmt.setInt(2, product.getQtd());
            stmt.setString(3, product.getType());
            stmt.setDouble(4, product.getPrice());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Update(Products product, int id) {
        String query = "UPDATE PRODUCTS SET NAME = ?, QTD = ?, TYPE = ?, PRICE = ? WHERE ID_PRODUCT = ?";
        try (Connection conn = DatabeConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, product.getName());
            stmt.setInt(2, product.getQtd());
            stmt.setString(3, product.getType());
            stmt.setDouble(4, product.getPrice());
            stmt.setInt(5, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Delete(int id) {
        String query = "DELETE FROM PRODUCTS WHERE ID_PRODUCT = ?";
        try (Connection conn = DatabeConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Products> GetById(int id) {
        Optional<Products> product = Optional.empty();
        String query = "SELECT * FROM PRODUCTS WHERE ID_PRODUCT = ?";
        try (Connection conn = DatabeConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String rsName = rs.getString("NAME");
                int rsQtd = rs.getInt("QTD");
                String rsType = rs.getString("TYPE");
                double rsPrice = rs.getDouble("PRICE");
                product = Optional.of(new Products(id, rsName, rsQtd, rsType, rsPrice));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public List<Products> GetAll() {
        List<Products> products = new ArrayList<>();
        String query = "SELECT * FROM PRODUCTS ORDER BY ID_PRODUCT";
        try (Connection conn = DatabeConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int rsId = rs.getInt("ID_PRODUCT");
                String rsName = rs.getString("NAME");
                int rsQtd = rs.getInt("QTD");
                String rsType = rs.getString("TYPE");
                double rsPrice = rs.getDouble("PRICE");
                products.add(new Products(rsId, rsName, rsQtd, rsType, rsPrice));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}
