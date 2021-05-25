package com.eatery.views;


import com.eatery.models.Burger;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminWindow {
   // static  String itemID;
     static String itemName;
     static int itemPrice;
    private JButton addButton;


    public static int getItemPrice() {
        return itemPrice;

    }

    public static String getItemName() {
        return itemName;

    }

    public static void main(String[]args) {


        JFrame frame = new JFrame();
        frame.setTitle("Admin Account");
        frame.setBounds(50, 50, 500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel addFoodItem = new JLabel();
        addFoodItem.setBounds(20, 30, 100, 23);
        addFoodItem.setText("Add FoodItem");
        frame.add(addFoodItem);


        JLabel changePrice = new JLabel();
        changePrice.setText("Change Price");
        changePrice.setBounds(20,100,89,23);
        frame.add(changePrice);


        JLabel changeOffers = new JLabel();
        changeOffers.setText("Change Offers");
        changeOffers.setBounds(20,170,89,23);
        frame.add(changeOffers);





        JButton addButton = new JButton("Add");
        addButton.setBounds(320,30,89,23);
        frame.add(addButton);




        JButton updateButton1 = new JButton("Update");
        updateButton1.setBounds(320,100,89,23);
        frame.add(updateButton1);

        JButton updateButton2 = new JButton("Update");
        updateButton2.setBounds(320,170,89,23);
        frame.add(updateButton2);






        frame.setVisible(true);

        class AddIBurgerListener implements ActionListener {
            public void actionPerformed(ActionEvent event) {
                System.out.println("hello,burger");
            }
        }
        ActionListener burgerListener = new AddIBurgerListener();
        addButton.addActionListener(burgerListener);


        class AddInterestListener implements ActionListener {
            public void actionPerformed(ActionEvent event) {
                System.out.println("hello, I was pressed");
            }
        }

        //ActionListener listener = new AddInterestListener();
      //  foodItemButton.addActionListener(listener);

        //THIS IS FOR FIRST ROW ITEM BUTTON
        JButton itemButton1 = new JButton("Item");
        itemButton1.setBounds(120, 30, 89, 23);
        frame.getContentPane().add(itemButton1);

        final JPopupMenu menu1 = new JPopupMenu();

        JMenuItem item1 = new JMenuItem("CheeseBurger");
        JMenuItem item2 = new JMenuItem("HamBurger");
        JMenuItem item3 = new JMenuItem("VeggieBurger");


       /* JMenuItem item1 = new JMenuItem("CheeseBurger"+" "+"$2.99");
        item1.addActionListener(menuListener);
        JMenuItem item2 = new JMenuItem("HamBurger" +" $3.99");
        item2.addActionListener(menuListener);
        JMenuItem item3 = new JMenuItem("VeggieBurger"+" $4.99");
        item3.addActionListener(menuListener);*/

        menu1.add(item1);
        menu1.add(item2);
        menu1.add(item3);

        itemButton1.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == 1) { // 1-left, 2-middle, 3-right button
                    menu1.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });
        frame.add(menu1);

        item1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev){

                    itemName = ev.getActionCommand();
                }

            });
        item2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev){

                itemName = ev.getActionCommand();
            }

        });
        item3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev){

                itemName = ev.getActionCommand();
            }

        });



        //THIS IS THE FIRST ROW PRICE BUTTON
        JButton priceButton1 = new JButton("Price");
        priceButton1.setBounds(220,30,89,23);
        frame.getContentPane().add(priceButton1);

        final JPopupMenu prices1 = new JPopupMenu();

        JMenuItem price1 = new JMenuItem("$3");
        JMenuItem price2 = new JMenuItem("$5");
        JMenuItem price3 = new JMenuItem("$7");

        prices1.add(price1);
        prices1.add(price2);
        prices1.add(price3);

        priceButton1.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == 1) { // 1-left, 2-middle, 3-right button
                    prices1.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });
        frame.add(prices1);

        price1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev){

                itemPrice = Integer.parseInt(ev.getActionCommand());
            }

        });
        price2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev){

                itemPrice = Integer.parseInt(ev.getActionCommand());
            }

        });
        price3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev){

                itemPrice = Integer.parseInt(ev.getActionCommand());
            }

        });


        //THIS IS THE SECOND ROW ITEM BUTTON
        JButton itemButton2 = new JButton("Item");
        itemButton2.setBounds(120, 100, 89, 23);
      //  20,100,89,23
        frame.getContentPane().add(itemButton2);

        final JPopupMenu menu2 = new JPopupMenu();

        JMenuItem item4 = new JMenuItem("CheeseBurger1");
        JMenuItem item5 = new JMenuItem("HamBurger");
        JMenuItem item6 = new JMenuItem("VeggieBurger");

        menu2.add(item4);
        menu2.add(item5);
        menu2.add(item6);

        itemButton2.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == 1) { // 1-left, 2-middle, 3-right button
                    menu2.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });
        frame.add(menu2);


        //THIS IS THE THIRD ROW ITEM BUTTON
        JButton itemButton3 = new JButton("Item");
        itemButton3.setBounds(120, 170, 89, 23);
        //  20,100,89,23
        frame.getContentPane().add(itemButton3);

        final JPopupMenu menu3 = new JPopupMenu();

        JMenuItem item7 = new JMenuItem("CheeseBurger2");
        JMenuItem item8 = new JMenuItem("HamBurger");
        JMenuItem item9 = new JMenuItem("VeggieBurger");

        menu3.add(item7);
        menu3.add(item8);
        menu3.add(item9);

        itemButton3.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == 1) { // 1-left, 2-middle, 3-right button
                    menu3.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });
        frame.add(menu3);

        //THIS IS THE SECOND ROW PRICE BUTTON
        JButton priceButton2 = new JButton("Price");
        priceButton2.setBounds(220,100,89,23);
        frame.getContentPane().add(priceButton2);

        final JPopupMenu prices2 = new JPopupMenu();

        JMenuItem price4 = new JMenuItem("$3");
        JMenuItem price5 = new JMenuItem("$5");
        JMenuItem price6 = new JMenuItem("$7");

        prices2.add(price4);
        prices2.add(price5);
        prices2.add(price6);

        priceButton2.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == 1) { // 1-left, 2-middle, 3-right button
                    prices2.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });
        frame.add(prices2);



        //THIS IS THE THIRD ROW OFFER BUTTON
        JButton offerButton = new JButton("Discount");
        offerButton.setBounds(220,170,89,23);
        frame.getContentPane().add(offerButton);

        final JPopupMenu offer = new JPopupMenu();

        JMenuItem offer1 = new JMenuItem("20%");
        JMenuItem offer2 = new JMenuItem("15%");
        JMenuItem offer3 = new JMenuItem("5%");

        offer.add(offer1);
        offer.add(offer2);
        offer.add(offer3);

        offerButton.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == 1) { // 1-left, 2-middle, 3-right button
                    offer.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });
        frame.add(offer);





        //Object creation which we will be saving in the database
        //Burger burger = new Burger(1 , itemName, itemPrice, true , 20, "burger" );





    }}


    
