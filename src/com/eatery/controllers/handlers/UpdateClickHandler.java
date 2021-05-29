package com.eatery.controllers.handlers;

import com.eatery.models.Item;
import com.eatery.models.Operation;

import java.sql.SQLException;

public class UpdateClickHandler extends ClickHandler {

    public UpdateClickHandler(Operation operation) {
        super(operation);
    }

    @Override
    public int doOperation(Item item) {
        try {
            boolean result =  dbHelper.updateItem(item);

            if (result) {
                return 1;
            } else {
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
