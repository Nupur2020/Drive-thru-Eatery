package com.eatery.models;

public class DrinksBuilder extends ItemBuilder{
    private String name;
    private boolean isVisible = false;
    private int price;
    private int id = -1;
    private int offers = 0;

    public DrinksBuilder(String name, int price){
        this.name = name;
        this.price = price;
    }

    public DrinksBuilder(Drinks drinks){
        this.name = drinks.getItemName();
    }

    public DrinksBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public DrinksBuilder setVisibility(boolean isVisible){
        this.isVisible = isVisible;
        return this;
    }

    public DrinksBuilder setOffers(int offers){
        this.offers = offers;
        return this;
    }

    public Drinks build(){
        return new Drinks(id, name, price, isVisible, offers);
    }

}
