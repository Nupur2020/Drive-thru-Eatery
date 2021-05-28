package com.eatery.views;

import com.eatery.data.MysqlCon;
import com.eatery.models.Item;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CustomerWindow1 extends View {
    static JFrame frame = new JFrame();
    JLabel l;
    JLabel ll;

    JLabel burgerorder;
    JLabel friesorder;
    JLabel cokeorder;

    JLabel burgersLabel;
    JLabel addonsLabel;
    JLabel friesLabel;
    JLabel cokeLabel;

    JButton buyButton;

    JComboBox burgersCB;
    JComboBox toppingsCB;
    JComboBox cokeSizeCB;

    public CustomerWindow1(){
        super();
        frame.setTitle("Customer Window");
        frame.setBounds(50, 50, 500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        l = new JLabel("label1");
        l.setText("CHOOSE AND PAY");
        l.setBounds(30,50, 150,50);
        frame.add(l);

        ll = new JLabel("label2");
        ll.setText("YOUR ORDER");
        ll.setBounds(320,50, 150,50);
        frame.add(ll);

        burgerorder = new JLabel();
        burgerorder.setBounds(320,80, 150,50);
        frame.add(burgerorder);

        friesorder = new JLabel();
        friesorder.setBounds(320,150, 150,50);
        frame.add(friesorder);

        cokeorder = new JLabel();
        cokeorder.setBounds(320,230, 150,50);
        frame.add(cokeorder);

        burgersLabel = new JLabel("Burgers");
        burgersLabel.setBounds(20, 100, 89, 23);
        frame.add(burgersLabel);

        addonsLabel = new JLabel("ADD ON'S");
        addonsLabel.setBounds(30,170,150,50);
        frame.add(addonsLabel);

        friesLabel = new JLabel("Fries");
        friesLabel.setBounds(20,240,89,23);
        frame.add(friesLabel);

        cokeLabel = new JLabel("Coke");
        cokeLabel.setBounds(20,310,89,23);
        frame.add(cokeLabel);

        buyButton = new JButton("BUY");
        //buyButton.addActionListener(BuyListener);
        buyButton.setBounds(60,380,150,23);
        frame.add(buyButton);

        //String[] itemsArray = (String[]) list.toArray(new String[0]);
        burgersCB = new JComboBox();
        burgersCB.setBounds(120,100,89,23);
        frame.add(burgersCB);
        burgersCB.setVisible(true);

        String [] toppingsArray = {"Cheese Topping :  $5", "Caramel Topping : $3"};
        toppingsCB = new JComboBox(toppingsArray);
        toppingsCB.setBounds(120,240,89,23);
        frame.add(toppingsCB);
        toppingsCB.setVisible(true);

        String [] cokeSizeArray = {"Small Coke : $4", "Large Coke : $ 6"};
        cokeSizeCB = new JComboBox(cokeSizeArray);
        cokeSizeCB.setBounds(120,310,89,23);
        frame.add(cokeSizeCB);
        cokeSizeCB.setVisible(true);


        frame.setTitle("Customer Order");
        frame.setVisible(true);

        burgersCB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getBurgersList();
            }
        });
    }

    public void getBurgersList(){
        List<Item> itemList = controller.getItems();
        for(int i =0;i<itemList.size();i++){
            burgersCB.addItem(itemList.get(i).getItemName());
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

    public JComboBox getToppingsCB() {
        return toppingsCB;
    }

    public void setToppingsCB(JComboBox toppingsCB) {
        this.toppingsCB = toppingsCB;
    }

    public JComboBox getCokeSizeCB() {
        return cokeSizeCB;
    }

    public void setCokeSizeCB(JComboBox cokeSizeCB) {
        this.cokeSizeCB = cokeSizeCB;
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
