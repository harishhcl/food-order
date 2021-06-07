package com.hcl.foodorder.search.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.foodorder.search.model.MenuItem;
import com.hcl.foodorder.search.repository.MenuItemRepository;

@RestController
@RequestMapping("/rest/search")
public class SearchController {

    @Autowired
    MenuItemRepository menuItemRepository;

    @GetMapping(value = "/name/{itemName}")
    public List<MenuItem> searchName(@PathVariable final String itemName) {
        return menuItemRepository.findByName(itemName);
    }

    @GetMapping(value = "/{itemId}")
    public Optional<MenuItem> searchId(@PathVariable final Long itemId) {
        return menuItemRepository.findById(itemId.toString());
    }

    @GetMapping(value = "/all")
    public List<MenuItem> searchAll() {
        List<MenuItem> itemList = new ArrayList<>();
        Iterable<MenuItem> items = menuItemRepository.findAll();
        items.forEach(itemList::add);
        return itemList;
    }

}
