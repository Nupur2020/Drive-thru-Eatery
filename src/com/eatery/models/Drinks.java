package com.eatery.models;

public class Drinks extends Item {
    Drinks(int itemId, String itemName, double price, Boolean visibility, int offers) {
        super(itemId, itemName, price, visibility, offers, "drinks");
    }

    @Override
    public double getTotalPrice() {
        return 0;
    }

}
