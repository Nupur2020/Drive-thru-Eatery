package com.eatery.models;

/**
 * Builder Pattern
 */
public class Burger extends Item {
    Burger(int itemId, String itemName, double price, Boolean visibility, int offers) {
        super(itemId, itemName, price, visibility, offers, "burger");
    }

    @Override
    public double getTotalPrice() {
        System.out.println("Burger method offer "+offers);
        System.out.println("Burger method old price "+price);

        double subtract = (offers*0.01) * (price);
        System.out.println("Burger method subtract "+subtract);
        price = price - subtract;
        System.out.println("Burger method "+price);
        return price;

    }

}
