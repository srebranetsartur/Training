package dao;

import entities.Category;
import entities.MenuItem;
import java.util.List;
import java.util.Optional;

public interface MenuDAO {
    List<MenuItem> findAll();
    Optional<MenuItem> findMenuItemByID(long id);
    List<MenuItem> findMenuItemsByCategory(String categoryTitle, int page);
    Optional<MenuItem> findMenuItemsByTitle(String title);

    List<Category> findAllCategory();
}

