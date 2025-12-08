package com.example.shaverma.domain.repo;

import com.example.shaverma.domain.model.MenuItem;
import com.example.shaverma.domain.enums.MenuSection;

import java.util.List;

public interface MenuItemRepo{
    MenuItem saveMenuItem(MenuItem menuItem);
    MenuItem updateMenuItem(MenuItem menuItem);
    MenuItem getMenuItemById(Long id);
    List<MenuItem> getMenuItemsByMenuSection(MenuSection menuSection);
    void deleteMenuItem(MenuItem menuItem);
}


