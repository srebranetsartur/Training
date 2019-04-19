package services.impl;

import dao.MenuDAO;
import entities.Category;
import entities.Menu;
import entities.MenuItem;
import services.MenuService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class MenuServiceImpl implements MenuService {
    private MenuDAO menuDAO;

    public MenuServiceImpl(MenuDAO menuDAO) {
        this.menuDAO = menuDAO;
    }

    @Override
    public List<MenuItem> getMenu() {
        return menuDAO.findAll();
    }

    @Override
    public List<MenuItem> getMenuByCategory(String category, int page) {
        return menuDAO.findMenuItemsByCategory(category, page);
    }
}
