package com.eatery.models;

public class BurgerBuilder extends ItemBuilder {
    private String name;
    private boolean isVisible = false;
    private double price;
    private int id = -1;
    private int offers = 0;


    public BurgerBuilder(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public BurgerBuilder(Burger burger) {
        this.name = burger.getItemName();

    }

    public BurgerBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public BurgerBuilder setVisibility(boolean isVisible) {
        this.isVisible = isVisible;
        return this;
    }

    public BurgerBuilder setOffers(int offers){
        this.offers = offers;
        return this;
    }

    public Burger build() {
        return new Burger(id, name, price, isVisible, offers);
    }
}
