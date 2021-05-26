package com.eatery.data;

import com.eatery.models.Item;

import java.sql.SQLException;
import java.util.List;

/**
 * Responsible for CRUD operation with Database as data source
 */
public interface DBHelper {

    //CREATE ITEMS
    public abstract int createItem(Item item) throws SQLException;

    //READ ITEMS
    public abstract Item getItem(int itemId) throws SQLException;

    public abstract List<Item> getItems();

    //UPDATE ITEM
    public abstract boolean updateItem(Item item) throws SQLException;

    //DELETE ITEM
    public abstract boolean deleteItem(Item item) throws SQLException;
}
