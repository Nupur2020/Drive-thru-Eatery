package com.eatery.views;

import com.eatery.controllers.IController;
import com.eatery.models.Item;

import javax.swing.*;


import javax.swing.JButton;
        import javax.swing.JFrame;
        import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class FirstWindow extends View {
    static public JFrame parent = new JFrame();
    JLabel welcomeMessage;

    public JButton getStartButton() {
        return startButton;
    }

    public void setStartButton(JButton startButton) {
        this.startButton = startButton;
    }

    JButton startButton;



    public FirstWindow(IController controller){
        super(controller);
        welcomeMessage = new JLabel();
        welcomeMessage.setBounds(100,50,300,100);
        welcomeMessage.setText("***WELCOME TO THE CAFE***");

        parent.getContentPane().setLayout(null);
        parent.add(welcomeMessage);

        startButton = new JButton();
        startButton.setText("Start Application");
        startButton.setBounds(120, 150, 150, 23);
        parent.add(startButton);
        parent.setSize(400,400);
        parent.setVisible(true);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.startApplication();
            }
        });
    }


    @Override
    public void onItemsChanged(List<Item> items) {

    }
}







