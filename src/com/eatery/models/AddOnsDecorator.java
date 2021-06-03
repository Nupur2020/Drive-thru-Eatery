package com.eatery.models;

public abstract class AddOnsDecorator {
    Item itemToBeDecorated;
    double price;

    public AddOnsDecorator(Item itemToBeDecorated){
        this.itemToBeDecorated = itemToBeDecorated;

    }

    public  double getTotalPrice() {
        double price = itemToBeDecorated.getPrice();
        return price;
    }
}
