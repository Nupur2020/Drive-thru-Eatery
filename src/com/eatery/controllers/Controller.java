package com.eatery.controllers;

import com.eatery.data.MySqlHelper;
import com.eatery.data.MysqlCon;
import com.eatery.models.Item;
import com.eatery.views.*;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Controller implements IController {
    private ArrayList<Item> data;
    private ArrayList<ItemChangedListener> subscribers;


    //private AdminWindow1 adminWindow1;
    private CustomerWindow1 customerWindow1;
    private FirstWindow firstWindow;
    private PaymentWindow paymentWindow;
    private MysqlCon mysqlCon;
    private MySqlHelper dbHelper;

    public Controller() throws SQLException, ClassNotFoundException {
        this.subscribers = new ArrayList<>();
        this.dbHelper = MySqlHelper.getInstance();
        this.data = (ArrayList<Item>) dbHelper.getItems();
    }

    public void initAdminView(AdminWindow1 adminWindow1) {

        //adminWindow1.getItemTextField().setText("ItemName");
        //adminWindow1.getSetPriceTextField().setText("Set Price");
        adminWindow1.getChangePriceTextField().setText("Change Price");
        adminWindow1.getChangeOfferTextField().setText("Change Offer");

    }





    @Override
    public void startApplication() {
        String[] options = {"Administrator", "Customer"};
        int opt = JOptionPane.showOptionDialog(FirstWindow.parent,
                "Choose Account type",
                "Accounts",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        if (opt == 1) {
            CustomerWindow1 customerWindow = new CustomerWindow1(this);
            FirstWindow.parent.setVisible(false);
           // initCustomerView(customerWindow);

        } else {
            AdminWindow1 adminWindow = new AdminWindow1(this);
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
        try {
            int id = dbHelper.createItem(item);
            item.setItemId(id);
            data.add(item);

            notifyDataChanged(data);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onUpdateClicked(Item item) {

        try {
            boolean check = dbHelper.updateItem(item);
            if (check) {
                notifyDataChanged(data);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
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







