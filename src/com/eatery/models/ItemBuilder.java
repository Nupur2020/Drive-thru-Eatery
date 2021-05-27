package com.eatery.models;

abstract public class ItemBuilder {
    abstract public ItemBuilder setId(int id);
    abstract public ItemBuilder setVisibility(boolean isVisible);
    abstract public ItemBuilder setOffers(int offers);
}
