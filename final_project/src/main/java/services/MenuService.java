package services;

import entities.Category;
import entities.MenuItem;


import java.util.List;
import java.util.Map;

public interface MenuService {
    List<MenuItem> getMenu();
    List<MenuItem> getMenuByCategory(String category, int page);
}

