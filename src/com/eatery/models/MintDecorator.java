package com.eatery.models;

public class MintDecorator extends AddOnsDecorator {
    public MintDecorator(Item itemToBeDecorated) {
        super(itemToBeDecorated);

    }
        @Override
        public double getTotalPrice() {
            return super.getTotalPrice() + 6;
        }

}
