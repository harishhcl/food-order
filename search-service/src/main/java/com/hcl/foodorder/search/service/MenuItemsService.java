package com.hcl.foodorder.search.service;

import org.springframework.data.elasticsearch.core.SearchHits;

import com.hcl.foodorder.search.model.MenuItem;

public interface MenuItemsService {

    String save(MenuItem menuItem);
    SearchHits<MenuItem> searchMultiField(String name, int qty);
    SearchHits<MenuItem> getMenuNameSearchData(String input);
    SearchHits<MenuItem> multiMatchQuery(Long id);
    SearchHits<MenuItem> getMenuItemsByPriceRange(final Double itemPriceMin, final Double itemPriceMax);
    SearchHits<MenuItem> getMenuItemsByDescriptions(final String descriptions);
}
