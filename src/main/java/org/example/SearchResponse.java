package org.example;

public class SearchResponse {

    //brand, category, price, remaining_inventory_coun


    private String brand;
    private String category;
    private double price;
    private int remainingCount;


    public SearchResponse(String brand, String category, double price , int remainingCount){
        this.brand = brand;
        this.category = category;
        this.price = price;
        this.remainingCount = remainingCount;
    }
}
