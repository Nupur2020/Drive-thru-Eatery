package com.eatery.views;

import com.eatery.controllers.IController;
import com.eatery.data.MysqlCon;
import com.eatery.models.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerWindow extends View {
    static JFrame frame = new JFrame();
    JLabel l;
    JLabel ll;
    String addOnName;

    JLabel burgerorder;
    JLabel addOnsorder;
 //   JLabel iceCreamorder;
     Item burger;

    JLabel burgersLabel;
    JLabel addonsLabel;

    JLabel iceCreamLabel;
    JLabel totalOrder;

    JButton buyButton;
    JButton  calculatePriceButton;

    JComboBox burgersCB;

    JComboBox addOnsCB;
    JComboBox iceCreamCB;
    private ArrayList<Item> items = new ArrayList<Item>() ;
    private ArrayList<Item> allItems;
    private double price;
    private double totalPrice;

    public CustomerWindow(IController controller) {
        super(controller);

        allItems = (ArrayList<Item>) controller.getItems();
        for (int i = 0; i < allItems.size(); i++) {
            if (allItems.get(i).getVisibility() == true) {
                items.add(allItems.get(i));
            }

        }

        frame.setTitle("Customer Window");
        frame.setBounds(50, 50, 500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        l = new JLabel("label1");
        l.setText("CHOOSE AND PAY");
        l.setBounds(30, 50, 150, 50);
        frame.add(l);

        ll = new JLabel("label2");
        ll.setText("YOUR ORDER");
        ll.setBounds(320, 50, 150, 50);
        frame.add(ll);

        burgerorder = new JLabel();
        burgerorder.setBounds(320, 80, 150, 50);
        frame.add(burgerorder);

        addOnsorder = new JLabel();
        addOnsorder.setBounds(320, 100, 150, 50);
        frame.add(addOnsorder);

        /*iceCreamorder = new JLabel();
        iceCreamorder.setBounds(320, 120, 150, 50);
        frame.add(iceCreamorder);*/

        totalOrder = new JLabel("Total Price");
        totalOrder.setBounds(320, 150, 150, 50);

        frame.add(totalOrder);

        burgersLabel = new JLabel("Burgers");
        burgersLabel.setBounds(20, 100, 89, 23);
        frame.add(burgersLabel);

        addonsLabel = new JLabel("ADD ON'S");
        addonsLabel.setBounds(30, 170, 150, 50);
        frame.add(addonsLabel);

        addonsLabel = new JLabel("Choose:");
        addonsLabel.setBounds(20, 240, 89, 23);
        frame.add(addonsLabel);


        calculatePriceButton = new JButton("Calculate Price");
        //buyButton.addActionListener(BuyListener);
        calculatePriceButton.setBounds(60, 320, 150, 23);
        frame.add(calculatePriceButton);

        buyButton = new JButton("BUY");
        //buyButton.addActionListener(BuyListener);
        buyButton.setBounds(60, 380, 150, 23);
        frame.add(buyButton);

        //String[] itemsArray = (String[]) list.toArray(new String[0]);
        burgersCB = new JComboBox();
        burgersCB.setBounds(120, 100, 120, 23);
        frame.add(burgersCB);
        burgersCB.setVisible(true);
        addItems(burgersCB);

        String[] addOnsArray = {"ChocoChip: $5", "BlueBerry: $3","Butterscotch: $4", "Mint: $6"};
        addOnsCB = new JComboBox(addOnsArray);
        addOnsCB.setBounds(120, 240, 120, 23);
        frame.add(addOnsCB);
        addOnsCB.setVisible(true);



        frame.setTitle("Customer Order");
        frame.setVisible(true);


        burgersCB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int indexCB =  burgersCB.getSelectedIndex();
                Item item = items.get(indexCB);

                String itemName = item.getItemName();
                double itemPrice = item.getPrice();
                int itemOffer = item.getOffers();

                burger = new BurgerBuilder(itemName,itemPrice).setVisibility(item.getVisibility()).setOffers(item.getOffers()).build();
                burgerorder.setText(itemName+" : $"+burger.getTotalPrice());
            }
        });

        calculatePriceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                 totalPrice = calculateTotalPrice(addOnName);
                 System.out.println(totalPrice);
                totalOrder.setText("Total Price  :"+totalPrice);
            }
        });

        addOnsCB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int indexCB =  addOnsCB.getSelectedIndex();
                addOnsorder.setText(String.valueOf(addOnsArray[indexCB]));
                String[] choices =addOnsArray[indexCB].split(":");
                addOnName = choices[0];


            }
        });
        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                PaymentWindow paymentWindow = new PaymentWindow(controller);
            }
        });



    }
    public double calculateTotalPrice(String addOnName){

        if(addOnName.equalsIgnoreCase("ChocoChip")){
            ChocoChipDecorator chocoChipDecorator = new ChocoChipDecorator(burger);
            price = chocoChipDecorator.getTotalPrice();
        } else if(addOnName.equalsIgnoreCase("BlueBerry")){
            BlueBerryDecorator blueBerryDecorator = new BlueBerryDecorator(burger);
            price = blueBerryDecorator.getTotalPrice();
        } else if(addOnName.equalsIgnoreCase("Butterscotch")){
            ButterscotchDecorator butterscotchDecorator = new ButterscotchDecorator(burger);
            price = butterscotchDecorator.getTotalPrice();
        } else if(addOnName.equalsIgnoreCase("Mint")){
            MintDecorator mintDecorator = new MintDecorator(burger);
            price = mintDecorator.getTotalPrice();
        }else{
            price = burger.getTotalPrice();
        }
        return price;
    }



    public void addItems(JComboBox comboBox){
        for(int i =0;i<items.size();i++){
            if(items.get(i).getVisibility() == true) {
                comboBox.addItem(items.get(i).getItemName());
            }
        }
    }

    public JButton getBuyButton() {
        return buyButton;
    }

    public void setBuyButton(JButton buyButton) {
        this.buyButton = buyButton;
    }

    public JComboBox getBurgersCB() {
        return burgersCB;
    }

    public void setBurgersCB(JComboBox burgersCB) {
        this.burgersCB = burgersCB;
    }





    @Override
    public void onItemsChanged(List<Item> items) {
        toChangeComboBOX(burgersCB,items);
    }

    private void toChangeComboBOX(JComboBox comboBox, List<Item> items){
        comboBox.removeAllItems();
        for (int i = 0; i < items.size(); i++) {
            comboBox.addItem(items.get(i));
        }
    }
}
