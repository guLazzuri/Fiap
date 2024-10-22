package Repository;

import Entities.Category;
import Infraestrutura.DatabeConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CategoryRepository implements _CrudRepository<Category> {

    @Override
    public void Insert(Category category) {
        String query = "INSERT INTO CATEGORY (ID_CATEGORY, NAME_CATEGORY) VALUES (category_seq.NEXTVAL, ?)";
        try (Connection conn = DatabeConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, category.getNameCategory());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Update(Category category, int id) {
        String query = "UPDATE CATEGORY SET NAME_CATEGORY = ? WHERE ID_CATEGORY = ?";
        try (Connection conn = DatabeConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, category.getNameCategory());
            stmt.setInt(2, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void Delete(int id) {
        String query = "DELETE FROM CATEGORY WHERE ID_CATEGORY = ?";
        try (Connection conn = DatabeConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Category> GetById(int id) {
        Optional<Category> category = Optional.empty();
        String query = "SELECT * FROM CATEGORY WHERE ID_CATEGORY = ?";
        try (Connection conn = DatabeConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String rsName = rs.getString("NAME_CATEGORY");
                category = Optional.of(new Category(id, rsName, new ArrayList<>())); // Inicializa a lista de produtos como vazia
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    @Override
    public List<Category> GetAll() {
        List<Category> categories = new ArrayList<>();
        String query = "SELECT * FROM CATEGORY ORDER BY ID_CATEGORY";
        try (Connection conn = DatabeConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int rsId = rs.getInt("ID_CATEGORY");
                String rsName = rs.getString("NAME_CATEGORY");
                categories.add(new Category(rsId, rsName, new ArrayList<>())); // Inicializa a lista de produtos como vazia
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }
}
