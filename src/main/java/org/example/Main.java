package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        FlipkartDaily flipkartDaily = new FlipkartDaily();

        flipkartDaily.addItem("Amul", "Milk", 100);
        flipkartDaily.addItem("Amul", "Curd", 50);
        flipkartDaily.addItem("Nestle", "Milk", 90);
        flipkartDaily.addItem("Nestle", "Curd", 90);

        flipkartDaily.addInventory("Amul", "Milk", 10);
        flipkartDaily.addInventory("Amul", "Milk", 10);
        flipkartDaily.addInventory("Amul", "Curd", 10);
        flipkartDaily.addInventory("Nestle", "Milk", 15);
        flipkartDaily.addInventory("Nestle", "Curd", 10);


        flipkartDaily.addUser("Jhonny", "Flipkart Bellandur, Bangalore 560068", 6000);
        flipkartDaily.addUser("Naruto", "BTM Layout, Bengaluru, 560042", 5000);
        flipkartDaily.addUser("Goku", "Vijay Nagar, Indore, MP", 3500);


        flipkartDaily.updateInventory("Nestle", "Milk", 5);

        flipkartDaily.addToCart("Jhonny", "Amul", "Milk", 5);
        flipkartDaily.addToCart("Naruto", "Nestle", "Curd", 10);
        flipkartDaily.addToCart("Goku", "Nestle", "Curd", 10);

        flipkartDaily.printInventory();

        flipkartDaily.checkoutUser("Naruto");

        flipkartDaily.printInventory();

        flipkartDaily.checkoutUser("Jhonny");

        flipkartDaily.printInventory();

        flipkartDaily.updateInventory("Nestle", "Curd", 20);

        flipkartDaily.printInventory();

        flipkartDaily.checkoutUser("Goku");

        flipkartDaily.printInventory();


        flipkartDaily.addToCart("Goku", "Amul", "Milk", 5);
        flipkartDaily.addToCart("Goku", "Nestle", "Milk", 10);
        flipkartDaily.addToCart("Goku", "Amul", "Curd", 5);
        flipkartDaily.addToCart("Goku", "Nestle", "Curd", 5);

        flipkartDaily.checkoutUser("Goku");

        flipkartDaily.printInventory();



//
////        flipkartDaily.checkoutUser("Jhonny");
//
        flipkartDaily.removeFromCart("Amul", "Milk", "Jhonny");
//
//        flipkartDaily.updateInventory("Nestle", "Milk", 5);
//
//

        flipkartDaily.printInventory();
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.setCategory("Milk");
        searchRequest.setPrice(95);
        List<SearchResponse> searchResponses = flipkartDaily.search(searchRequest);

        flipkartDaily.removeFromCart("Amul", "Milk", "Jhonny");

    }
}