package com.eatery.models;

public class Drinks extends Item {
    Drinks(int itemId, String itemName, int price, Boolean visibility, int offers) {
        super(itemId, itemName, price, visibility, offers, "drinks");
    }

    @Override
    public int getTotalPrice() {
        return 0;
    }

}
