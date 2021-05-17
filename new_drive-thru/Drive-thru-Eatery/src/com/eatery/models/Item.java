package com.eatery.models;

abstract class Item {
    int itemId;
    String itemName;
    int price;
    Boolean visibility;
    int offers;
    String type;

    public Item(int itemId, String itemName, int price, Boolean visibility, int offers, String type){
        this.itemId = itemId;
        this.itemName = itemName;
        this.price = price;
        this.visibility = visibility;
        this.offers = offers;
        this.type = type;
    }

    abstract public int getTotalPrice();

    abstract public void changePrice();
}
