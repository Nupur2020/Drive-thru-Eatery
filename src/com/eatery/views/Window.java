package com.eatery.views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Window {
    public static void main(String[]args) {
        JFrame frame = new JFrame();
        frame.setBounds(50, 50, 500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JButton foodItemButton = new JButton("FoodItem");
        foodItemButton.setBounds(20, 30, 89, 23);
        frame.add(foodItemButton);

        JButton prizeButton = new JButton("Price");
        prizeButton.setBounds(20,100,89,23);
        frame.add(prizeButton);

        JButton offersButton = new JButton("Offers");
        offersButton.setBounds(20,170,89,23);
        frame.add(offersButton);

        JButton addButton = new JButton("Add");
        addButton.setBounds(320,30,89,23);
        frame.add(addButton);

        frame.setVisible(true);


        class AddInterestListener implements ActionListener {
            public void actionPerformed(ActionEvent event) {
                System.out.println("hello, I was pressed");
            }
        }

        ActionListener listener = new AddInterestListener();
        foodItemButton.addActionListener(listener);


        JButton btnClickMe = new JButton("Item");
        btnClickMe.setBounds(120, 30, 89, 23);
        frame.getContentPane().add(btnClickMe);

        final JPopupMenu menu = new JPopupMenu();

        JMenuItem item1 = new JMenuItem("Burger");
        JMenuItem item2 = new JMenuItem("Fries");
        JMenuItem item3 = new JMenuItem("Coke");

        menu.add(item1);
        menu.add(item2);
        menu.add(item3);

        btnClickMe.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == 1) { // 1-left, 2-middle, 3-right button
                    menu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });
        frame.add(menu);

        item1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev){
                String item = "Burger";
            }
        });



        JButton btnpriceclick = new JButton("Price");
        btnpriceclick.setBounds(220,30,89,23);
        frame.getContentPane().add(btnpriceclick);

        final JPopupMenu price = new JPopupMenu();

        JMenuItem price1 = new JMenuItem("$5");
        JMenuItem price2 = new JMenuItem("$3");
        JMenuItem price3 = new JMenuItem("$7");

        price.add(price1);
        price.add(price2);
        price.add(price3);

        btnpriceclick.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == 1) { // 1-left, 2-middle, 3-right button
                    price.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });
        frame.add(price);




    }}