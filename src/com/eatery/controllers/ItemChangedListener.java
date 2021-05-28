package com.eatery.controllers;

import com.eatery.models.Item;

import java.util.List;

public interface ItemChangedListener {

    public void onItemsChanged(List<Item> items);

}
