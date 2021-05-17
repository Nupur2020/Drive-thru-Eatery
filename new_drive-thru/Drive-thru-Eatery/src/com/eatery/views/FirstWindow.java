package com.eatery.views;

import javax.swing.*;


import javax.swing.JButton;
        import javax.swing.JFrame;
        import javax.swing.JOptionPane;

public class FirstWindow {

    public static void main(final String[] args) {
        JFrame parent = new JFrame();
        JLabel welcomeMessage = new JLabel();
        welcomeMessage.setBounds(100,50,300,100);
        welcomeMessage.setText("***WELCOME TO THE CAFE***");

        parent.getContentPane().setLayout(null);
        parent.add(welcomeMessage);

        JButton button = new JButton();
        button.setText("Start Application");
        button.setBounds(120, 150, 150, 23);
        parent.add(button);
        parent.setSize(400,400);
        parent.setVisible(true);

        button.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //String name = JOptionPane.showInputDialog(parent,
                //  "Choose Account type", null);

                String[] options = {"Administrator", "Customer"};
                int opt = JOptionPane.showOptionDialog(parent,
                        "Choose Account type",
                        "Accounts",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

                System.out.println("opt"+opt);

                if(opt == 1){
                    CustomerWindow.main();
                    parent.setVisible(false);
                }


            }
        });
    }
}






