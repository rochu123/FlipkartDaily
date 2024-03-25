package org.example;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.isNull;

public class Cart {

    private Map<Item, Integer> cart = new HashMap<>();


    public void addItem(Item item, Integer quantity) {

        Integer existingQty = cart.get(item);
        if (isNull(existingQty)) {
            existingQty = 0;
        }
        cart.put(item, existingQty + quantity);
    }

    public Map<Item, Integer> getCart() {
        for (Map.Entry<Item, Integer> entry : cart.entrySet()) {
            System.out.println("item is " + entry.getValue().toString() + "quantity is " + entry.getKey().getBrand());
        }
        return cart;
    }

    public double getCartValue() {
        double totalAmount = 0;
        for (Map.Entry<Item, Integer> entry : cart.entrySet()) {
            Item item = entry.getKey();
            Integer qty = entry.getValue();
            System.out.println("item is " + entry.getValue().toString() + "quantity is " + entry.getKey().getBrand());
            if (item.getQuantity() < qty) {
                throw new RuntimeException("item now available" + entry.getKey().toString());
            }
            totalAmount += (double) qty * item.getPrice();

        }
        return totalAmount;
    }

    public void clearCart() {
        cart = new HashMap<>();
    }

    public void removeFromCart(Item item) {
        cart.remove(item);
    }
}
