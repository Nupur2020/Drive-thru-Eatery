package com.eatery.models;

/**
 * Builder Pattern
 */
public class Burger extends Item {
    public Burger(int itemId, String itemName, int price, Boolean visibility, int offers) {
        super(itemId, itemName, price, visibility, offers, "burger");
    }

    @Override
    public int getTotalPrice() {
        return this.price - this.offers;
    }

}
