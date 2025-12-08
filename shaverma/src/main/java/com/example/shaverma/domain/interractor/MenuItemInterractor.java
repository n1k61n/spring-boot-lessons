package com.example.shaverma.domain.interractor;

import com.example.shaverma.domain.model.MenuItem;
import com.example.shaverma.domain.enums.MenuSection;
import com.example.shaverma.domain.repo.MenuItemRepo;

import java.util.List;

public class MenuItemInterractor{

    private final MenuItemRepo menuItemRepo;

    public MenuItemInterractor(MenuItemRepo menuItemRepo) {
        this.menuItemRepo = menuItemRepo;
    }

    public MenuItem saveMenuItem(MenuItem menuItem){
        return menuItemRepo.saveMenuItem(menuItem);
    }

    public MenuItem updateMenuItem(MenuItem menuItem){
        return menuItemRepo.updateMenuItem(menuItem);
    }

    public MenuItem getMenuItemById(Long id){
        return menuItemRepo.getMenuItemById(id);
    }

    public List<MenuItem> getMenuItemsByMenuSection(MenuSection menuSection){
        return menuItemRepo.getMenuItemsByMenuSection(menuSection);
    }

    public void deleteMenuItem(MenuItem menuItem){
        menuItemRepo.deleteMenuItem(menuItem);
    }

}

