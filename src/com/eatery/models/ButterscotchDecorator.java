package com.eatery.models;

public class ButterscotchDecorator extends AddOnsDecorator {
    public ButterscotchDecorator(Item itemToBeDecorated) {
        super(itemToBeDecorated);
    }
    @Override
    public double getTotalPrice() {
        return super.getTotalPrice() + 4;
    }
}
