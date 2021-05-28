package com.eatery.models;

public class ChocoChipDecorator extends AddOnsDecorator{
    public ChocoChipDecorator(Item itemToBeDecorated) {
        super(itemToBeDecorated);
    }

    @Override
    public int getTotalPrice() {
        return super.getTotalPrice() + 5;
    }
}
