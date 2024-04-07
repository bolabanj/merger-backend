package edu.iu.habahram.DinerPancakeHouseMerge.model;

import java.util.Iterator;

public class CafeMenuIterator implements Iterator<MenuComponent> {
    int position = 0;
    MenuItem[] menuItems;


    public CafeMenuIterator(MenuItem[] menuItems) {
        this.menuItems = menuItems;

    }

    @Override
    public boolean hasNext() {
        if (position >= menuItems.length || menuItems[position] == null) {
            return false;
        }
        return true;
    }

    @Override
    public MenuComponent next() {

        MenuComponent menuItem = menuItems[position];
        position = position + 1;
        return menuItem;
    }
}
