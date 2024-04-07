package edu.iu.habahram.DinerPancakeHouseMerge.model;

import java.util.ArrayList;
import java.util.Iterator;

public class Menu extends MenuComponent{
    Iterator<MenuComponent> iterator = null;
    ArrayList<MenuComponent> menuComponents = new ArrayList<MenuComponent>();
    String name;
    String description;
    public Menu(String name, String description){
        this.name = name;
        this.description = description;
    }

    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }
    public void remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }
    public MenuComponent getChild(int i) {
        return menuComponents.get(i);
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
//    public MenuItem[] getItems(){
//        MenuItem [] menuItems = new MenuItem[menuComponents.size()];
//        for(int i = 0; i < menuComponents.size(); i++){
//            menuItems[i] = (MenuItem) menuComponents.get(i);
//        }
//        return menuItems;
//    }
    public Iterator<MenuComponent> createIterator() {
        if(iterator == null){
            iterator = new CompositeIterator(menuComponents.iterator());
        }
        return iterator;
    }

    public String print() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n" + getName());
        stringBuilder.append(", " + getDescription());
        stringBuilder.append("\n---------------------\n");
        Iterator<MenuComponent> iterator = menuComponents.iterator();
        while(iterator.hasNext()){
            MenuComponent menuComponent = iterator.next();
            stringBuilder.append(menuComponent.print());
        }
        return stringBuilder.toString();
    }

}