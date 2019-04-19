package dao.impl;

import dao.MenuDAO;
import dao.mapper.RowMapper;
import entities.Category;
import entities.MenuItem;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class JdbcMenuDAO implements MenuDAO {
    private DataSource dataSource;

    private RowMapper<MenuItem> menuRowMapper = rs -> {
        MenuItem menuItem = new MenuItem();

        menuItem.setID(rs.getLong("id"));
        menuItem.setTitle(rs.getString("title"));
        menuItem.setDescription(rs.getString("description"));
        menuItem.setPrice(rs.getBigDecimal("price"));

        Category category = new Category();
        category.setId(rs.getLong("dc.id"));
        category.setTitle(rs.getString("dc.title"));
        category.setUnitMeasure(rs.getString("dc.unit"));
        menuItem.setCategory(category);

        return menuItem;
    };

    private RowMapper<Category> categoryRowMapper = rs -> {
        Category category = new Category();
        category.setId(rs.getLong("dish_category.id"));
        category.setTitle(rs.getString("dish_category.title"));
        category.setUnitMeasure(rs.getString("dish_category.unit"));

        return category;
    };


    public JdbcMenuDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public List<MenuItem> findAll() {

        try(Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("select * from dish as d inner join dish_category as dc on d.category_id = dc.id");
            ResultSet rs = statement.executeQuery();
            List<MenuItem> menu = new ArrayList<>();

            while(rs.next()) {
                MenuItem menuItem = menuRowMapper.mapToObject(rs);
                menu.add(menuItem);
            }

            return menu;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }

    @Override
    public Optional<MenuItem> findMenuItemByID(long id) {
        try(Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("select * from menu as c inner join dish_category as c on c.category_id = c.id where c.id = ?")) {
            statement.setLong(1, id);

            ResultSet rs = statement.executeQuery();
            return Optional.of(menuRowMapper.mapToObject(rs));
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public List<MenuItem> findMenuItemsByCategory(String categoryTitle, int page) {
        try (Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection
                .prepareStatement("select * from menu as c inner join dish_category as c on c.category_id = c.id where c.title = ? limit ?, 20")) {
            statement.setString(1, categoryTitle);
            statement.setInt(2, page);

            ResultSet rs = statement.executeQuery();
            List<MenuItem> menuItems = new ArrayList<>();
            while(rs.next()) {
                menuItems.add(menuRowMapper.mapToObject(rs));
            }

            return menuItems;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }

    @Override
    public Optional<MenuItem> findMenuItemsByTitle(String title) {
        try(Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection
                .prepareStatement("select * from menu as c inner join dish_category as c on c.category_id = c.id where c.title = ? limit ?, 20")) {
            ResultSet rs = statement.executeQuery();
            return Optional.of(menuRowMapper.mapToObject(rs));
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public List<Category> findAllCategory() {

        try(Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection
                .prepareStatement("select * from dish_category")) {
            ResultSet rs = statement.executeQuery();

            List<Category> categories = new ArrayList<>();
            while(rs.next()) {
                categories.add(categoryRowMapper.mapToObject(rs));
            }

            return categories;
        }
        catch (SQLException e) {

        }

        return Collections.emptyList();
    }


}
