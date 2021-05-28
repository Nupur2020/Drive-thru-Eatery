package com.eatery.models;

public class ButterscotchDecorator extends AddOnsDecorator {
    public ButterscotchDecorator(Item itemToBeDecorated) {
        super(itemToBeDecorated);
    }
    @Override
    public int getTotalPrice() {
        return super.getTotalPrice() + 4;
    }
}
