package com.eatery.views;

import com.eatery.controllers.IController;
import com.eatery.models.*;

import javax.swing.*;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminWindow1 extends View {
    JFrame frame = new JFrame();

    private JButton addFoodItemButton;
    private JButton priceUpdateButton;
    private JButton offerUpdateButton;

    JLabel addFoodItem = new JLabel();
    JLabel changePrice = new JLabel();
    JLabel changeOffers = new JLabel();


    JTextField changePriceTextField = new JTextField();
    JTextField changeOfferTextField = new JTextField();


    private JComboBox itemsCBPrice;
    private JComboBox itemsCBOffer;

    private ArrayList<Item> items;

    public AdminWindow1(IController controller) {
        super(controller);
        controller.subscribe(this);
        items = (ArrayList<Item>) controller.getItems();


        frame.setTitle("Admin Account");
        frame.setBounds(50, 50, 500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);


        addFoodItem.setBounds(20, 30, 100, 23);
        addFoodItem.setText("Add FoodItem");
        frame.add(addFoodItem);


        /*itemTextField.setBounds(120, 30, 89, 23);
        frame.getContentPane().add(itemTextField);

        setPriceTextField.setBounds(220, 30, 89, 23);
        frame.getContentPane().add(setPriceTextField);*/

        addFoodItemButton = new JButton("AddButton");
        addFoodItemButton.setBounds(320, 30, 120, 23);
        frame.add(addFoodItemButton);


        changePrice.setBounds(20, 100, 89, 23);
        changePrice.setText("Change Price");
        frame.add(changePrice);

        itemsCBPrice = new JComboBox();
        itemsCBPrice.setBounds(120, 100, 89, 23);// change the bounds
        frame.add(itemsCBPrice);
        itemsCBPrice.setVisible(true);
        addItems(itemsCBPrice);

        changePriceTextField.setBounds(220, 100, 89, 23);
        frame.getContentPane().add(changePriceTextField);

        priceUpdateButton = new JButton("UpdatePrice");
        priceUpdateButton.setBounds(320, 100, 120, 23);
        frame.add(priceUpdateButton);


        changeOffers.setBounds(20, 170, 89, 23);
        changeOffers.setText("Change Offers");
        frame.add(changeOffers);

        itemsCBOffer = new JComboBox();
        itemsCBOffer.setBounds(120, 170, 89, 23);// change the bounds
        frame.add(itemsCBOffer);
        itemsCBOffer.setVisible(true);
        addItems(itemsCBOffer);


        frame.setVisible(true);

        changeOfferTextField.setBounds(220, 170, 89, 23);
        frame.getContentPane().add(changeOfferTextField);

        offerUpdateButton = new JButton("UpdateOffer");
        offerUpdateButton.setBounds(320, 170, 120, 23);
        frame.add(offerUpdateButton);

        addFoodItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onAddClicked();
            }
        });

        priceUpdateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    onPriceUpdateClicked();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        offerUpdateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    onOfferUpdateClicked();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

    }

    public void addItems(JComboBox comboBox){
        for(int i =0;i<items.size();i++){
            comboBox.addItem(items.get(i).getItemName());
        }
    }

    private void onAddClicked(){

        AddItemWindow addItemWindow = new AddItemWindow(controller);

    }

    private void onPriceUpdateClicked() throws SQLException {
        int newPrice = Integer.parseInt(changePriceTextField.getText());
        int indexCB =  itemsCBPrice.getSelectedIndex();
        Item item = items.get(indexCB);
        item.setPrice(newPrice);
        controller.onUpdateClicked(item);
    }

    private void onOfferUpdateClicked() throws SQLException {
        int newOffer = Integer.parseInt(changeOfferTextField.getText());
        int indexCB =  itemsCBOffer.getSelectedIndex();
        Item item = items.get(indexCB);
        item.setOffers(newOffer);
        controller.onUpdateClicked(item);
    }


    public JTextField getChangePriceTextField(){ return changePriceTextField;}

    public JTextField getChangeOfferTextField(){ return changeOfferTextField;}

    public JButton getAddFoodItemButton() {
        return this.addFoodItemButton;
    }

    public JButton getPriceUpdateButton() {
        return this.priceUpdateButton;
    }

    public JButton getOfferUpdateButton() {
        return this.offerUpdateButton;
    }

    public JComboBox getItemsCBPrice(){
        return itemsCBPrice;
    }

    public JComboBox getItemsCBOffer(){
        return itemsCBOffer;
    }


    @Override
    public void onItemsChanged(List<Item> items) {
        toChangeComboBOX(itemsCBPrice,items);
        toChangeComboBOX(itemsCBOffer,items);
    }

    private void toChangeComboBOX(JComboBox comboBox, List<Item> items){
        comboBox.removeAllItems();
        for (int i = 0; i < items.size(); i++) {
            comboBox.addItem(items.get(i).getItemName());
        }
    }
}
