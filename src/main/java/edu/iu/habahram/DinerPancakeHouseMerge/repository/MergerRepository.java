package edu.iu.habahram.DinerPancakeHouseMerge.repository;

import edu.iu.habahram.DinerPancakeHouseMerge.model.*;
import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuComponent;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MergerRepository {
    public List<MenuItemRecord> getTheBreakfast(){
        MenuComponent allMenus = new Menu("All Menus", "All menus combined");

        allMenus.add(new PancakeHouseMenu("PANCAKE HOUSE MENU", "Breakfast"));


        List<MenuItem> menuItems = new ArrayList<>();
        traverseMenu(allMenus, menuItems);
        return menuItems.stream()

                .map(item -> new MenuItemRecord(item.getName(), item.getDescription(), item.isVegetarian(), item.getPrice()))
                .toList();
    }

    public List<MenuItemRecord> getTheLunch(){
        MenuComponent allMenus = new Menu("All Menus", "All menus combined");
        allMenus.add(new DinerMenu("DINER MENU", "Lunch"));
        List<MenuItem> menuItems = new ArrayList<>();
        traverseMenu(allMenus, menuItems);
        return menuItems.stream()
                .map(item -> new MenuItemRecord(item.getName(), item.getDescription(), item.isVegetarian(), item.getPrice()))
                .toList();}

    public List<MenuItemRecord> getTheDinner(){
        MenuComponent allMenus = new Menu("All Menus", "All menus combined");
        allMenus.add(new CafeMenu("CAFE MENU", "Dinner"));
        List<MenuItem> menuItems = new ArrayList<>();
        traverseMenu(allMenus, menuItems);
        return menuItems.stream()
                .map(item -> new MenuItemRecord(item.getName(), item.getDescription(), item.isVegetarian(), item.getPrice()))
                .toList();
    }

    public List<MenuItemRecord> getTheMenuItems(){
        MenuComponent allMenus = new Menu("All Menus", "All menus combined");
        allMenus.add(new DinerMenu("DINER MENU", "Lunch"));
        allMenus.add(new PancakeHouseMenu("PANCAKE HOUSE MENU", "Breakfast"));
        allMenus.add(new CafeMenu("CAFE MENU", "Dinner"));

        List<MenuItem> menuItems = new ArrayList<>();
        traverseMenu(allMenus, menuItems);
        return menuItems.stream()
                .map(item -> new MenuItemRecord(item.getName(), item.getDescription(), item.isVegetarian(), item.getPrice()))
                .toList();
    }

    private void traverseMenu(MenuComponent menu, List<MenuItem> menuItems) {
        // Check if the current menu component is a MenuItem
        if (menu instanceof MenuItem) {
            menuItems.add((MenuItem) menu); // Safely cast and add to the list
        } else {
            // If it's not a MenuItem, iterate through its children recursively
            CompositeIterator iterator = new CompositeIterator(menu.createIterator());
            while (iterator.hasNext()) {
                traverseMenu(iterator.next(), menuItems);
            }
        }
    }
}
