package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FlipkartDaily {

    private List<User> users = new ArrayList<>();

    private InventoryManager inventoryManager = new InventoryManager();


    public void addUser(String userName, String address, double walletAmount) {
        validateUserName(userName);
        User user = new User(userName, address, walletAmount);
        users.add(user);
    }

    public void addItem(String brand, String category, int price) {
        inventoryManager.addItem(brand, category, price);
    }

    public void printInventory(){
        inventoryManager.printInventory();
    }

    public void addInventory(String brand, String category, int quantity) {
        inventoryManager.addInventory(brand, category, quantity);
    }

    public void updateInventory(String brand, String category, int quantity) {
        inventoryManager.updateInventory(brand, category, quantity);
    }

    public void addToCart(String userName, String brand, String category, int quantity) {
        User user = getUserByUserName(userName);
        Item item = inventoryManager.getItem(brand, category);
        user.addToCart(item, quantity);
    }

    private User getUserByUserName(String userName) {
        for (User user : users) {
            if (userName.equals(user.getUserName())) {
                return user;
            }
        }
        throw new RuntimeException("User not found");
    }

    public void getCart(String userName) {
        User user = getUserByUserName(userName);
        user.getCart();
    }


    public void checkoutUser(String userName) {
        User user = getUserByUserName(userName);
        Map<Item, Integer> updatedItems = user.checkout();

        for (Map.Entry<Item, Integer> entry : updatedItems.entrySet()) {
            Item item = entry.getKey();
            Integer qty = (-1) * entry.getValue();
            inventoryManager.updateInventory(item.getBrand(), item.getCategory(), qty);
        }


    }

    public void removeFromCart(String brand, String category, String userName) {
        Item item = inventoryManager.getItem(brand, category);
        User user = getUserByUserName(userName);
        user.removeFromCart(item);
    }


    private void validateUserName(String userName) {
        for (User user : users) {
            if (userName.equals(user.getUserName())) {
                throw new RuntimeException("Username exists");
            }
        }
    }


    public List<SearchResponse>  search(SearchRequest searchRequest) {
        return inventoryManager.search(searchRequest);
    }
}
