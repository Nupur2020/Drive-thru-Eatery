package com.eatery.models;

/**
 * Builder Pattern
 */
public class Burger extends Item {
    Burger(int itemId, String itemName, int price, Boolean visibility, int offers) {
        super(itemId, itemName, price, visibility, offers, "burger");
    }

    @Override
    public int getTotalPrice() {
        int subtract = (offers/100) * (price);
        price = price - subtract;
        return price;
    }

}
