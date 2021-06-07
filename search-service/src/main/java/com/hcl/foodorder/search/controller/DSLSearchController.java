package com.hcl.foodorder.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.foodorder.search.model.MenuItem;
import com.hcl.foodorder.search.service.MenuItemsService;


@RestController
@RequestMapping("/rest/dslSearch")
public class DSLSearchController {
    @Autowired
    private MenuItemsService menuItemsService;

    //Save
    @PostMapping("/menuItems")
    public String saveItems(@RequestBody MenuItem menuItem) {
        return menuItemsService.save(menuItem);
    }


    //Name And Quantity
    @GetMapping("/nameandquantity/{name}/{quantity}")
    public SearchHits<MenuItem> getProductsByNameAndQuantity(
            @PathVariable String name, @PathVariable int quantity){
        return menuItemsService.searchMultiField(name, quantity);
    }

    //By itemName specifically for wildcard characters
    @GetMapping("/wildcard/{searchString}")
    public SearchHits<MenuItem> getMenuNameSearchData(
            @PathVariable String searchString){
        return menuItemsService.getMenuNameSearchData(searchString);
    }

    //Descriptions
    @GetMapping("/description/{descriptions}")
    public SearchHits<MenuItem> getMenuItemsByDescriptions(
            @PathVariable String descriptions){
        return menuItemsService.getMenuItemsByDescriptions(descriptions);
    }

    //By restaurantId Or ItemId
    @GetMapping("/restaurantIdOrItemId/{id}")
    public SearchHits<MenuItem> getMenuItemsByRestaurantIdOrItemId(
            @PathVariable Long id){
        return menuItemsService.multiMatchQuery(id);
    }

    //Items price range
    @GetMapping("/itemsPriceRange/{priceMin}/{priceMax}")
    public SearchHits<MenuItem> getProductsByPriceRange(
            @PathVariable Double priceMin, @PathVariable Double priceMax){
        return menuItemsService.getMenuItemsByPriceRange(priceMin, priceMax);
    }


}