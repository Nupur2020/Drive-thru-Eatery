package com.eatery.controllers.handlers;

import com.eatery.models.Item;
import com.eatery.models.Operation;
import java.sql.SQLException;


public class SaveClickHandler extends ClickHandler {

    public SaveClickHandler(Operation operation) {
        super(operation);
    }

    @Override
    public int doOperation(Item item) {
        try {
            return dbHelper.createItem(item);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
