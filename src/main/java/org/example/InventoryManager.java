package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class Inventory {

    Map<String, Item> itemMap = new HashMap<>();
    List<Item> items = new ArrayList<>();

//    AddItem(Amul, Milk, 100)


    public void addItem(String brand, String category, int price) {
        String itemId = brand.concat("_").concat(category);
        if (nonNull(itemMap.get(itemId))) {
            throw new RuntimeException("Item already exists");
        }

        Item item = new Item();
        item.setCategory(category);
        item.setBrand(brand);
        item.setId(brand.concat("_").concat(category));
        item.setPrice(price);
        items.add(item);
    }

//AddInventory(Amul, Milk, 10)


    public void addInventory(String brand, String category, int quantity) {
        String itemId = brand.concat("_").concat(category);
        if (isNull(itemMap.get(itemId))) {
            throw new RuntimeException("item doesn't exists");
        }
        Item item = itemMap.get(itemId);
        item.setQuantity(item.getQuantity()+quantity);
    }
}
