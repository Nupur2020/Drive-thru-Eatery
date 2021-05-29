package com.eatery.models;

public class Fries extends Item {

    Fries(int itemId, String itemName, double price, Boolean visibility, int offers) {
        super(itemId, itemName, price, visibility, offers, "fries");
    }

    @Override
    public double getTotalPrice() {
        return 0;
    }

}
