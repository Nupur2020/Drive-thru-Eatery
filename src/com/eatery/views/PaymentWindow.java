package com.eatery.views;

import com.eatery.controllers.IController;
import com.eatery.data.MysqlCon;
import com.eatery.models.Item;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PaymentWindow extends View{
    JFrame billingFrame = new JFrame();
    JButton payButton;

    JLabel detailsMessage;
    JLabel creditCardNum;
    JLabel creditCardName;
    JLabel creditCardExpiry;
    JLabel creditCardCVV;

    JLabel successMessage;
    JLabel failureMessage;
    JTextField creditCardNumTextField;
    JTextField creditCardNameTextField;
    JTextField creditCardExpiryTextField;
    JTextField creditCardCVVTextField;


    public PaymentWindow(IController controller){
        billingFrame.setTitle("Payment Window");
        billingFrame.setBounds(50, 50, 500, 300);
        billingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        billingFrame.getContentPane().setLayout(null);

        detailsMessage =new JLabel();
        detailsMessage.setBounds(20, 15, 300, 23);
        detailsMessage.setText("ENTER CARD DETAILS:");
        billingFrame.add(detailsMessage);

        creditCardNum =new JLabel();
        creditCardNum.setBounds(20, 50, 100, 23);
        creditCardNum.setText("Card Number:");
        billingFrame.add(creditCardNum);

        creditCardName =new JLabel();
        creditCardName.setBounds(20, 80, 100, 23);
        creditCardName.setText("Card Name:");
        billingFrame.add(creditCardName);

        creditCardExpiry =new JLabel();
        creditCardExpiry.setBounds(20, 110, 100, 23);
        creditCardExpiry.setText("Card Expiry:");
        billingFrame.add(creditCardExpiry);

        creditCardCVV =new JLabel();
        creditCardCVV.setBounds(20, 140, 100, 23);
        creditCardCVV.setText("Card CVV:");
        billingFrame.add(creditCardCVV);

        successMessage =new JLabel();
        successMessage.setBounds(20, 200, 300, 23);

        billingFrame.add(successMessage);

        failureMessage =new JLabel();
        failureMessage.setBounds(20, 220, 300, 23);

        billingFrame.add(failureMessage);

        creditCardNumTextField = new JTextField();
        creditCardNumTextField.setBounds(120, 50, 200, 23);
        billingFrame.getContentPane().add(creditCardNumTextField);

        creditCardNameTextField = new JTextField();
        creditCardNameTextField.setBounds(120, 80, 250, 23);
        billingFrame.getContentPane().add(creditCardNameTextField);

        creditCardExpiryTextField = new JTextField();
        creditCardExpiryTextField.setBounds(120, 110, 150, 23);
        billingFrame.getContentPane().add(creditCardExpiryTextField);

        creditCardCVVTextField = new JTextField();
        creditCardCVVTextField.setBounds(120, 140, 50, 23);
        billingFrame.getContentPane().add(creditCardCVVTextField);


        payButton = new JButton("Pay");
        payButton.setBounds(320, 200, 100, 23);
        billingFrame.add(payButton);



        billingFrame.setVisible(true);
        CustomerWindow1.frame.setVisible(false);

        payButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String cardNum = creditCardNumTextField.getText();
                String cardName = creditCardNameTextField.getText();
                String cardExpiry = creditCardExpiryTextField.getText();
                String cardCVV = creditCardCVVTextField.getText();
                if (cardNum.matches("[0-9]+") && cardNum.length() == 16 && cardName.matches("^[a-zA-Z]([-']?[a-zA-Z]+)*( [a-zA-Z]([-']?[a-zA-Z]+)*)+$") && cardCVV.matches("[0-9]+") && cardCVV.length() == 3 &&
                cardExpiry.matches("\\d{2}/\\d{2}")){
                    successMessage.setText("Payment Successful. Enjoy your meal!!");
                }else
                {
                    failureMessage.setText("Payment failed.Please try again.");
                }

            }
        });



    }


    public JTextField getCreditCardNumTextField() {
        return creditCardNumTextField;
    }

    public void setCreditCardNumTextField(JTextField creditCardNumTextField) {
        this.creditCardNumTextField = creditCardNumTextField;
    }

    public JTextField getCreditCardNameTextField() {
        return creditCardNameTextField;
    }

    public void setCreditCardNameTextField(JTextField creditCardNameTextField) {
        this.creditCardNameTextField = creditCardNameTextField;
    }

    public JTextField getCreditCardExpiryTextField() {
        return creditCardExpiryTextField;
    }

    public JButton getPayButton() {
        return payButton;
    }

    public void setPayButton(JButton payButton) {
        this.payButton = payButton;
    }

    public void setCreditCardExpiryTextField(JTextField creditCardExpiryTextField) {
        this.creditCardExpiryTextField = creditCardExpiryTextField;
    }

    public JTextField getCreditCardCVVTextField() {
        return creditCardCVVTextField;
    }

    public void setCreditCardCVVTextField(JTextField creditCardCVVTextField) {
        this.creditCardCVVTextField = creditCardCVVTextField;
    }

    @Override
    public void onItemsChanged(List<Item> items) {

    }
}
