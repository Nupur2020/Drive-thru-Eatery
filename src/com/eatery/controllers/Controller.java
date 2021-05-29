package com.eatery.controllers;

import com.eatery.controllers.handlers.ClickHandler;
import com.eatery.controllers.handlers.SaveClickHandler;
import com.eatery.controllers.handlers.UpdateClickHandler;
import com.eatery.data.MySqlHelper;
import com.eatery.data.MysqlCon;
import com.eatery.models.Item;
import com.eatery.models.Operation;
import com.eatery.views.*;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Controller implements IController {
    private ArrayList<Item> data;
    private ArrayList<ItemChangedListener> subscribers;


    //private AdminWindow1 adminWindow1;
    private CustomerWindow customerWindow;
    private FirstWindow firstWindow;
    private PaymentWindow paymentWindow;
    private MysqlCon mysqlCon;
    private MySqlHelper dbHelper;

    private ClickHandler handler;

    public Controller() throws SQLException, ClassNotFoundException {
        this.subscribers = new ArrayList<>();
        this.dbHelper = MySqlHelper.getInstance();
        this.data = (ArrayList<Item>) dbHelper.getItems();
        handler = new SaveClickHandler(Operation.SAVE);
        handler.setNextHandler(new UpdateClickHandler(Operation.UPDATE));

    }

    public void initAdminView(AdminWindow adminWindow) {

        //adminWindow1.getItemTextField().setText("ItemName");
        //adminWindow1.getSetPriceTextField().setText("Set Price");
        adminWindow.getChangePriceTextField().setText("Change Price");
        adminWindow.getChangeOfferTextField().setText("Change Offer");

    }





    @Override
    public void startApplication() {
        String[] options = {"Administrator", "Customer"};
        int opt = JOptionPane.showOptionDialog(FirstWindow.parent,
                "Choose Account type",
                "Accounts",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        if (opt == 1) {
            CustomerWindow customerWindow = new CustomerWindow(this);
            FirstWindow.parent.setVisible(false);
           // initCustomerView(customerWindow);

        } else {
            AdminWindow adminWindow = new AdminWindow(this);
            FirstWindow.parent.setVisible(false);
           // initAdminView(adminWindow);

        }
    }




    @Override
    public void init() {

    }

    @Override
    public Item getItem(int itemId) throws SQLException {
        Item item = dbHelper.getItem(itemId);
        return item;
    }

    @Override
    public List<Item> getItems() {
        return data;
    }

    @Override
    public void onSaveClicked(Item item) {
        int id = handler.handle(Operation.SAVE, item);
        if (id == -1) {
            System.out.println("Unable to save item");
            return;
        }
        item.setItemId(id);
        data.add(item);
        notifyDataChanged(data);

    }


    @Override
    public void onUpdateClicked(Item item) {
        int check = handler.handle(Operation.UPDATE, item);
        if (check == -1) {
            System.out.println("Unable to update item");
            return;
        }

        for (int i =0; i <data.size(); i++) {
            if (data.get(i).getItemId() == item.getItemId()) {
                data.set(i, item);
            }
        }

        notifyDataChanged(data);
    }


    @Override
    public void subscribe(ItemChangedListener subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void notifyDataChanged(List<Item> newItems) {
        for (ItemChangedListener subscriber : subscribers) {
            subscriber.onItemsChanged(newItems);
        }
    }
}







