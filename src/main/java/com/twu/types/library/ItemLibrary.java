package com.twu.types.library;

import com.twu.types.item.Item;

public class ItemLibrary {
    private Item item;
    private boolean isAvailable;

    public ItemLibrary(Item item){
        this.item = item;
        this.isAvailable = true;
    }

    public Item getItem(){
        return this.item;
    }

    public void modifyAvailableItemStatus(boolean status){
        this.isAvailable = status;
    }

    public boolean isAvailable(){
        return this.isAvailable;
    }

    @Override
    public String toString() {
        return "Item Name: " + item.getName();

    }
}
