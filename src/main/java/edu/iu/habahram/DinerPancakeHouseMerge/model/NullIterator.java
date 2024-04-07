package edu.iu.habahram.DinerPancakeHouseMerge.model;

import java.util.Iterator;

public class NullIterator implements Iterator {



    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }
    public void remove(){
        throw new UnsupportedOperationException();
    }
}
