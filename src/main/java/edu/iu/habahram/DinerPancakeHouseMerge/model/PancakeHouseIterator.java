package edu.iu.habahram.DinerPancakeHouseMerge.model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class PancakeHouseIterator implements Iterator<MenuComponent> {

    ArrayList<MenuItem> menuItems;
    int position = 0;
    public PancakeHouseIterator(ArrayList<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public boolean hasNext() {
        if(position >= menuItems.size() || (menuItems.get(position) == null)) {
            return false;
        }
        return true;
    }

    @Override
    public MenuItem next() {
        MenuItem menuItem = menuItems.get(position);
        position += 1;
        return menuItem;
    }

    @Override
    public void remove() {
        if (position <= 0) {
            throw new IllegalStateException
                    ("You can't remove an item until you've done at least one next()");
        }
        if (menuItems.get(position - 1) != null) {
            for (int i = position-1; i < (menuItems.size()-1); i++) {
                menuItems.set(i, menuItems.get(i+1)) ;
            }
            menuItems.set(menuItems.size()-1, null);
        }
    }


}
