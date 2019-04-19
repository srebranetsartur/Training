package entities;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Order {
    private long ID;
    private Map<MenuItem, Integer> orderItems;

    public Map<MenuItem, Integer> getOrderItems() {
        return orderItems;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public void setOrderItems(Map<MenuItem, Integer> orderItems) {
        Objects.requireNonNull(orderItems);

        this.orderItems = orderItems;
    }

    public void addToOrder(MenuItem menuItem) {
        if(orderItems == null)
            orderItems = new HashMap<>();

        if(orderItems.containsKey(menuItem))
            orderItems.compute(menuItem, (k,v) -> v++);
        else {
            orderItems.put(menuItem, 1);
        }
    }

    public void removeFromOrder(MenuItem menuItem) {
        Objects.requireNonNull(menuItem);

        orderItems.remove(menuItem);
    }

    public int getMenuItemCount(MenuItem menuItem) {
        Objects.requireNonNull(menuItem);

        return orderItems.get(menuItem);
    }
}
