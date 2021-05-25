package com.eatery.views;

import com.eatery.data.MysqlCon;

import javax.swing.*;

public class PaymentWindow {
    MysqlCon mysqlCon;
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


    public PaymentWindow(MysqlCon mysqlCon){
        this.mysqlCon = mysqlCon;
        billingFrame.setTitle("Payment Window");
        billingFrame.setBounds(50, 50, 500, 300);
        billingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        billingFrame.getContentPane().setLayout(null);

        detailsMessage.setBounds(20, 15, 300, 23);
        detailsMessage.setText("ENTER CARD DETAILS:");
        billingFrame.add(detailsMessage);

        creditCardNum.setBounds(20, 50, 100, 23);
        creditCardNum.setText("Card Number:");
        billingFrame.add(creditCardNum);

        creditCardName.setBounds(20, 80, 100, 23);
        creditCardName.setText("Card Name:");
        billingFrame.add(creditCardName);

        creditCardExpiry.setBounds(20, 110, 100, 23);
        creditCardExpiry.setText("Card Expiry:");
        billingFrame.add(creditCardExpiry);

        creditCardCVV.setBounds(20, 140, 100, 23);
        creditCardCVV.setText("Card CVV:");
        billingFrame.add(creditCardCVV);

        successMessage.setBounds(20, 200, 300, 23);
        successMessage.setText("Payment Successful. Enjoy your meal!!");
        billingFrame.add(successMessage);

        creditCardNumTextField.setBounds(120, 50, 200, 23);
        billingFrame.getContentPane().add(creditCardNumTextField);

        creditCardNameTextField.setBounds(120, 80, 250, 23);
        billingFrame.getContentPane().add(creditCardNameTextField);

        creditCardExpiryTextField.setBounds(120, 110, 150, 23);
        billingFrame.getContentPane().add(creditCardExpiryTextField);

        creditCardCVVTextField.setBounds(120, 140, 50, 23);
        billingFrame.getContentPane().add(creditCardCVVTextField);

        payButton = new JButton("Pay");
        payButton.setBounds(320, 200, 100, 23);
        billingFrame.add(payButton);



        billingFrame.setVisible(true);
        CustomerWindow1.frame.setVisible(false);
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

}
