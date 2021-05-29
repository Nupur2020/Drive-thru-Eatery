package com.eatery.models;

public class FriesBuilder extends ItemBuilder{
    private String name;
    private boolean isVisible = false;
    private double price;
    private int id = -1;
    private int offers = 0;


    public FriesBuilder(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public FriesBuilder(Fries fries) {
        this.name = fries.getItemName();

    }

    public FriesBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public FriesBuilder setVisibility(boolean isVisible) {
        this.isVisible = isVisible;
        return this;
    }

    public FriesBuilder setOffers(int offers){
        this.offers = offers;
        return this;
    }

    public Fries build() {
        return new Fries(id, name, price, isVisible, offers);
    }
}
