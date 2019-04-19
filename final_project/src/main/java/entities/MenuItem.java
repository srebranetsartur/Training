package entities;

import java.math.BigDecimal;
import java.util.Objects;

public class MenuItem {
    private long ID;
    private String title;
    private String description;
    private BigDecimal price;
    private Category category;

    public MenuItem(String title, String description, BigDecimal price, Category category) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    public MenuItem() {
    }

    public Long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;

        if(!(obj instanceof MenuItem))
            return false;

        MenuItem menuItem = (MenuItem) obj;
        return menuItem.title.equals(title) && menuItem.category.equals(category)
                && menuItem.price.equals(price) && menuItem.description.equals(description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, price, category);
    }
}
