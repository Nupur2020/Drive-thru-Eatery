package com.eatery.models;

public class Fries extends Item {
    public Fries(int itemId, String itemName, int price, Boolean visibility, int offers) {
        super(itemId, itemName, price, visibility, offers, "fries");
    }

    @Override
    public int getTotalPrice() {
        return 0;
    }

}
