package com.eatery.models;

public abstract class Item {
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

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }

    abstract public int getTotalPrice();

}
