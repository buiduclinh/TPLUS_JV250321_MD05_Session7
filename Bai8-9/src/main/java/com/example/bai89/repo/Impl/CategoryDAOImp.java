package com.example.bai89.repo.Impl;

import com.example.bai89.model.Category;
import com.example.bai89.repo.CategoryDAO;
import com.example.bai89.util.DBConnection;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryDAOImp implements CategoryDAO {
    @Override
    public List<Category> getAll() {
        List<Category> categories = new ArrayList<>();
        String sql = "{CALL get_all_category()}";
        try (Connection conn = DBConnection.getInstance().getConnection();
             CallableStatement statement = conn.prepareCall(sql);) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setCategoryName(rs.getString("category_name"));
                category.setDescription(rs.getString("description"));
                category.setStatus(rs.getBoolean("status"));
                categories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public Category getById(int id) {
        String sql = "{CALL get_category_by_id(?)}";
        try (Connection conn = DBConnection.getInstance().getConnection();
             CallableStatement statement = conn.prepareCall(sql);) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setCategoryName(rs.getString("category_name"));
                category.setDescription(rs.getString("description"));
                category.setStatus(rs.getBoolean("status"));
                return category;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addCategory(Category category) {
        String sql = "{CALL add_category(?,?)}";
        try (Connection conn = DBConnection.getInstance().getConnection();
             CallableStatement statement = conn.prepareCall(sql);) {
            statement.setString(1, category.getCategoryName());
            statement.setString(2, category.getDescription());
            int result = statement.executeUpdate();
            if (result > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateCategory(Category category) {
        String sql = "{CALL update_category(?,?,?,?)}";
        try (Connection conn = DBConnection.getInstance().getConnection();
             CallableStatement statement = conn.prepareCall(sql);) {
            statement.setInt(1, category.getId());
            statement.setString(2, category.getCategoryName());
            statement.setString(3, category.getDescription());
            statement.setBoolean(4, category.isStatus());
            int result = statement.executeUpdate();
            if (result > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteCategory(int id) {
        String sql = "{CALL delete_category(?)}";
        try (Connection conn = DBConnection.getInstance().getConnection();
             CallableStatement callableStatement = conn.prepareCall(sql);) {
            callableStatement.setInt(1, id);
            int result = callableStatement.executeUpdate();
            if (result > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
