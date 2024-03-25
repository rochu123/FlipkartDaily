package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class SearchService {


    public List<SearchResponse> searchProducts(SearchRequest searchRequest, List<Item> items) {

        if (searchRequest.getPrice() == 0) {
            searchRequest.setPrice(20000000);
        }
        System.out.println("search req" + searchRequest.getPrice()+ " " + searchRequest.getCategory());
        List<Item> selectedItems = items.stream()
                .filter(item -> (Objects.isNull(searchRequest.getCategory())) || searchRequest.getCategory().equals(item.getCategory()))
                .filter(item -> (Objects.isNull(searchRequest.getBrand())) || searchRequest.getBrand().equals(item.getBrand()))
                .filter(item -> searchRequest.getPrice() >= item.getPrice())
                .collect(Collectors.toList());

        List<SearchResponse> response = new ArrayList<>();
        for (Item item : selectedItems) {
            System.out.println("item selected is" + item.getCategory() + item.getBrand() + item.getQuantity());
            SearchResponse searchResponse = new SearchResponse(item.getBrand(), item.getCategory(), item.getPrice(), item.getQuantity());
            response.add(searchResponse);
        }

        return response;


    }
}
