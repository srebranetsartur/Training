package entities;

import java.util.List;
import java.util.Objects;

public class Menu {
    private List<MenuItem> items;

    public List<MenuItem> getItems() {
        return items;
    }

    public void setItems(List<MenuItem> items) {
        this.items = items;
    }

    public void addItem(MenuItem menuItem) {
        Objects.requireNonNull(menuItem);

        items.add(menuItem);
    }

}
