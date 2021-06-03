package com.eatery.views;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

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



    public FirstWindow(IController controller) throws IOException {
        super(controller);
        welcomeMessage = new JLabel();
        welcomeMessage.setBounds(100,150,300,100);
        welcomeMessage.setText("***WELCOME TO THE CAFE***");

        parent.getContentPane().setLayout(null);
        parent.add(welcomeMessage);

        BufferedImage img = ImageIO.read(new URL("https://img.icons8.com/plasticine/2x/hamburger.png"));
        ImageIcon icon = new ImageIcon(img);
        JLabel lbl = new JLabel();
        lbl.setBounds(100,10,200,200);
        lbl.setIcon(icon);
        parent.add(lbl);

        startButton = new JButton();
        startButton.setText("Click Here to Begin");
        startButton.setBounds(120, 230, 150, 23);
        parent.add(startButton);
        parent.setSize(400,400);
        //parent.add(new JLabel(new ImageIcon()));
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







