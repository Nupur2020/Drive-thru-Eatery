package com.eatery.views;

import com.eatery.data.MysqlCon;

import javax.swing.*;
import javax.swing.JTextField;
import java.util.ArrayList;

public class AdminWindow1 {

    JFrame frame = new JFrame();

    private JButton addFoodItemButton;
    private JButton priceUpdateButton;
    private JButton offerUpdateButton;

    JLabel addFoodItem = new JLabel();
    JLabel changePrice = new JLabel();
    JLabel changeOffers = new JLabel();

    JTextField itemTextField = new JTextField();
    JTextField setPriceTextField = new JTextField();
    JTextField changePriceTextField = new JTextField();
    JTextField changeOfferTextField = new JTextField();


    private JComboBox itemsCBPrice;
    private JComboBox itemsCBOffer;





    public AdminWindow1() {

        frame.setTitle("Admin Account");
        frame.setBounds(50, 50, 500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);


        addFoodItem.setBounds(20, 30, 100, 23);
        addFoodItem.setText("Add FoodItem");
        frame.add(addFoodItem);


        itemTextField.setBounds(120, 30, 89, 23);
        frame.getContentPane().add(itemTextField);

        setPriceTextField.setBounds(220, 30, 89, 23);
        frame.getContentPane().add(setPriceTextField);

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


        frame.setVisible(true);

        changeOfferTextField.setBounds(220, 170, 89, 23);
        frame.getContentPane().add(changeOfferTextField);

        offerUpdateButton = new JButton("UpdateOffer");
        offerUpdateButton.setBounds(320, 170, 120, 23);
        frame.add(offerUpdateButton);


    }

    public JTextField getItemTextField() {
        return itemTextField;
    }

    public JTextField getSetPriceTextField(){ return setPriceTextField;}

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




}
