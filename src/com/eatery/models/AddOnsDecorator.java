package com.eatery.models;

public abstract class AddOnsDecorator {
    Item itemToBeDecorated;
    int price;

    public AddOnsDecorator(Item itemToBeDecorated){
        this.itemToBeDecorated = itemToBeDecorated;

    }

    public  int getTotalPrice() {
    int price = itemToBeDecorated.getTotalPrice();
    return price;
    }
}
