package com.eatery.controllers;

import com.eatery.models.Item;
import com.eatery.models.Operation;

import java.sql.SQLException;
import java.util.List;


public interface IController {

    public void init();

    public Item getItem(int itemId) throws SQLException;

    public List<Item> getItems();

    public void onSaveClicked(Item item);

    public void onUpdateClicked(Item item);

    public void subscribe(ItemChangedListener listener);

    public void notifyDataChanged(List<Item> newItems);

    public void startApplication();
}
