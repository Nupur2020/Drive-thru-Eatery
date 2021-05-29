package com.eatery.controllers.handlers;

import com.eatery.data.MySqlHelper;
import com.eatery.models.Item;
import com.eatery.models.Operation;

import java.sql.SQLException;

public abstract class ClickHandler {

    protected ClickHandler nextHandler;
    protected Operation supportedOperation;
    protected MySqlHelper dbHelper;

    public ClickHandler(Operation operation) {
        this.supportedOperation = operation;
        try {
            this.dbHelper = MySqlHelper.getInstance();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void setNextHandler(ClickHandler clickHandler) {
        this.nextHandler = clickHandler;
    }

    public int handle(Operation operation, Item item) {
        if (operation == supportedOperation) {
            return doOperation(item);

        }

        if (nextHandler != null) {
           return  nextHandler.handle(operation, item);
        }

        return -1;
    }

    public abstract int doOperation(Item item);
}
