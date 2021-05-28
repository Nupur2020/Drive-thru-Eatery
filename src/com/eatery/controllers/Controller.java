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

    public Controller(FirstWindow firstWindow) throws SQLException, ClassNotFoundException {
        this.subscribers = new ArrayList<>();
        this.firstWindow = firstWindow;
        this.dbHelper = MySqlHelper.getInstance();
        this.data = (ArrayList<Item>) dbHelper.getItems();
    }

    /*    public void initView() {

            adminWindow1.getItemTextField().setText("ItemName");
            adminWindow1.getSetPriceTextField().setText("Set Price");
            adminWindow1.getChangePriceTextField().setText("Change Price");
            adminWindow1.getChangeOfferTextField().setText("Change Offer");

        }*/
    public void initAdminView(AdminWindow1 adminWindow1) {

        //adminWindow1.getItemTextField().setText("ItemName");
        //adminWindow1.getSetPriceTextField().setText("Set Price");
        adminWindow1.getChangePriceTextField().setText("Change Price");
        adminWindow1.getChangeOfferTextField().setText("Change Offer");

    }

    private void initCustomerView(CustomerWindow1 customerWindow) {
    }

    public void initController() {
        firstWindow.getStartButton().addActionListener(e -> startApplication());
        System.out.println("Entered save");


        //  adminWindow1.getItemsCBPrice().addItem(getItemNames());
        //  adminWindow1.getItemsCBOffer().addItem(getItemNames());
        //  customerWindow1.getBurgersCB().addItem(getItemNames());
        //  adminWindow1.getAddFoodItemButton().addActionListener(e -> saveFoodItem());
        //   adminWindow1.getPriceUpdateButton().addActionListener(e -> saveUpdatedPrice());
        //  adminWindow1.getOfferUpdateButton().addActionListener(e -> saveUpdatedOffer());


    }

    private void startApplication() {
        String[] options = {"Administrator", "Customer"};
        int opt = JOptionPane.showOptionDialog(FirstWindow.parent,
                "Choose Account type",
                "Accounts",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        if (opt == 1) {
            CustomerWindow1 customerWindow = new CustomerWindow1();
            FirstWindow.parent.setVisible(false);
            initCustomerView(customerWindow);
            //doCustomerStuff(customerWindow);
        } else {
            AdminWindow1 adminWindow = new AdminWindow1(this);
            FirstWindow.parent.setVisible(false);
            initAdminView(adminWindow);
            //doAdminStuff(adminWindow);
        }
    }

    /*private void doCustomerStuff(CustomerWindow1 customerWindow) {
        customerWindow1.getBurgersCB().addItem(getItemNames());
    }*/


    /*private void doAdminStuff(AdminWindow1 adminWindow1) {
        String[] itemNames = getItemNames();
        for (int i = 0; i < itemNames.length; i++) {
            adminWindow1.getItemsCBPrice().addItem(itemNames[i]);
        }
        for (int i = 0; i < itemNames.length; i++) {
            adminWindow1.getItemsCBOffer().addItem(itemNames[i]);
        }
        //adminWindow1.getItemsCBPrice().addItem(getItemNames());
        //adminWindow1.getItemsCBOffer().addItem(getItemNames());
        //adminWindow1.getAddFoodItemButton().addActionListener(e -> saveFoodItem(adminWindow1));
        adminWindow1.getAddFoodItemButton().addActionListener(e -> new AddItemWindow(this));
        //adminWindow1.getPriceUpdateButton().addActionListener(e -> saveUpdatedPrice(adminWindow1));
        //adminWindow1.getOfferUpdateButton().addActionListener(e -> saveUpdatedOffer(adminWindow1));

    }*/

    /*private void saveFoodItem(AdminWindow1 adminWindow1) {

        mysqlCon.insertItemInAdminWindow1(adminWindow1);
    }*/

    private String getComboSelectedItemPrice(AdminWindow1 adminWindow1) {
        String item = (String) adminWindow1.getItemsCBPrice().getItemAt(adminWindow1.getItemsCBPrice().getSelectedIndex());
        return item;
    }

    private String getComboSelectedItemOffer(AdminWindow1 adminWindow1) {
        String item = (String) adminWindow1.getItemsCBOffer().getItemAt(adminWindow1.getItemsCBOffer().getSelectedIndex());
        return item;
    }


    /*private void saveUpdatedPrice(AdminWindow1 adminWindow1) {
        mysqlCon.updatePriceInAdminWindow1(adminWindow1, getComboSelectedItemPrice(adminWindow1));
    }*//*

    private void saveUpdatedOffer(AdminWindow1 adminWindow1) {
        mysqlCon.updateOfferInAdminWindow1(adminWindow1, getComboSelectedItemOffer(adminWindow1));
    }*/

    /*private String[] getItemNames() {
        String[] itemNames = new String[data.size()];

        for (int i = 0; i < data.size(); i++) {
            itemNames[i] = data.get(i).getItemName();
        }
        return itemNames;
    }*/

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







