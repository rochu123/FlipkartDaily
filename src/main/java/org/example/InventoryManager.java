package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class InventoryManager {

    private Map<String, Item> itemMap = new HashMap<>();
    private List<Item> items = new ArrayList<>();

    private SearchService searchService = new SearchService();

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
        itemMap.put(itemId,item);
    }

    public Item getItem(String brand, String category) {
        String itemId = brand.concat("_").concat(category);
        if (isNull(itemMap.get(itemId))) {
            throw new RuntimeException("item doesn't exists");
        }
        return itemMap.get(itemId);
    }

//AddInventory(Amul, Milk, 10)


    public void addInventory(String brand, String category, int quantity) {

        Item item = getItem(brand, category);
        item.setQuantity(item.getQuantity() + quantity);
    }



    public void updateInventory(String brand, String category, int quantity) {
        addInventory(brand, category, quantity);
    }

    public  List<SearchResponse>  search(SearchRequest searchRequest){
        return searchService.searchProducts(searchRequest,items);
    }


    public void printInventory(){
        for(Item item : items){
            System.out.println("category"+ item.getCategory() + " "+ item.getBrand() + " "+ item.getQuantity() + " "+ item.getPrice());
        }
    }
}
