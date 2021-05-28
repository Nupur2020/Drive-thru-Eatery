package com.eatery.views;

import com.eatery.controllers.IController;
import com.eatery.models.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AddItemWindow  extends View {

    JFrame frame = new JFrame();
    JLabel addItemNameLabel = new JLabel();
    JLabel addPriceLabel = new JLabel();
    JLabel addVisibilityLabel = new JLabel();
    JLabel addOfferLabel = new JLabel();
    JLabel addItemType = new JLabel();

    JTextField addItemNameTextField = new JTextField();
    JTextField addPriceTextField = new JTextField();
    JTextField addVisibilityTextField = new JTextField();
    JTextField addOfferTextField = new JTextField();
    JTextField addItemTypeTextField = new JTextField();

    JButton saveFoodItemButton = new JButton();


    public AddItemWindow(IController controller) {
        super(controller);
        controller.subscribe(this);

        frame.setTitle("Admin Account");
        frame.setBounds(50, 50, 500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        addItemNameLabel.setBounds(20, 30, 100, 23);
        addItemNameLabel.setFont(new Font("Arial", Font.PLAIN, 13));
        addItemNameLabel.setText("Enter Item Name");
        frame.add(addItemNameLabel);

        addPriceLabel.setBounds(20, 60, 100, 23);
        addPriceLabel.setFont(new Font("Arial", Font.PLAIN, 13));
        addPriceLabel.setText("Enter Item Price");
        frame.add(addPriceLabel);

        addVisibilityLabel.setBounds(20, 90, 100, 23);
        addVisibilityLabel.setFont(new Font("Arial", Font.PLAIN, 13));
        addVisibilityLabel.setText("Enter Item Visibility");
        frame.add(addVisibilityLabel);

        addOfferLabel.setBounds(20, 120, 100, 23);
        addOfferLabel.setFont(new Font("Arial", Font.PLAIN, 13));
        addOfferLabel.setText("Enter Item Offer");
        frame.add(addOfferLabel);

        addItemType.setBounds(20, 150, 100, 23);
        addItemType.setFont(new Font("Arial", Font.PLAIN, 13));
        addItemType.setText("Enter Item Type");
        frame.add(addItemType);

        addItemNameTextField.setBounds(170, 30, 89, 23);
        frame.getContentPane().add(addItemNameTextField);

        addPriceTextField.setBounds(170, 60, 89, 23);
        frame.getContentPane().add(addPriceTextField);

        addVisibilityTextField.setBounds(170, 90, 89, 23);
        frame.getContentPane().add(addVisibilityTextField);

        addOfferTextField.setBounds(170, 120, 89, 23);
        frame.getContentPane().add(addOfferTextField);

        addItemTypeTextField.setBounds(170, 150, 89, 23);
        frame.getContentPane().add(addItemTypeTextField);

        saveFoodItemButton = new JButton("Save Item");
        saveFoodItemButton.setBounds(70, 190, 90, 23);
        frame.add(saveFoodItemButton);
        frame.setVisible(true);

        saveFoodItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onSaveClicked();
            }
        });
    }

    private void onSaveClicked() {
        String itemName = addItemNameTextField.getText();
        int itemPrice = Integer.parseInt(addPriceTextField.getText());
        Boolean itemVisibility = Boolean.parseBoolean(addVisibilityTextField.getText());
        int itemOffer = Integer.parseInt(addOfferTextField.getText());
        String itemType = addItemTypeTextField.getText();


        //TODO add values to properties of Burger
        if (itemType.equalsIgnoreCase("burger")) {
            Burger burger = new BurgerBuilder(itemName, itemPrice)
                    .setVisibility(itemVisibility)
                    .setOffers(itemOffer)
                    .build();

            controller.onSaveClicked(burger);
        } else if (itemType.equalsIgnoreCase("Fries")) {
            Fries fries = new FriesBuilder(itemName, itemPrice)
                    .setVisibility(itemVisibility)
                    .setOffers(itemOffer)
                    .build();
            controller.onSaveClicked(fries);
        } else {
            Drinks drinks = new DrinksBuilder(itemName, itemPrice)
                    .setVisibility(itemVisibility)
                    .setOffers(itemOffer)
                    .build();
            controller.onSaveClicked(drinks);
        }

    }

    @Override
    public void onItemsChanged(List<Item> items) {
        //Do Nothing
    }
}
