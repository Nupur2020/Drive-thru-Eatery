package com.eatery.controllers;
import com.eatery.data.MysqlCon;
import com.eatery.models.Item;
//import com.eatery.views.AdminWindow;
import com.eatery.views.AdminWindow1;

public class Controller {

    private AdminWindow1 view;
    private Item model;
    private MysqlCon mysqlCon;

    // private Object event;
   // private JButton myButton;

    public Controller(AdminWindow1 view, Item model, MysqlCon mysqlCon) {
            this.model = model;
            this.view = view;
            this.mysqlCon = mysqlCon;
            initView();
        }

       public void initView(){

           view.getItemTextField().setText("ItemName");
           view.getSetPriceTextField().setText("Set Price");
           view.getChangePriceTextField().setText("Change Price");
           view.getChangeOfferTextField().setText("Change Offer");

        }

    public void initController() {
 /*   JButton addFoodItemButton = new JButton();
        addFoodItemButton = view.getAddFoodItemButton();
        addFoodItemButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {*/

                System.out.println("Entered save");
                view.getAddFoodItemButton().addActionListener(e-> saveFoodItem());
                view.getPriceUpdateButton().addActionListener(e-> saveUpdatedPrice());
                view.getOfferUpdateButton().addActionListener(e-> saveUpdatedOffer());
           //     view.getItemsCB().addActionListener(e-> saveUpdatedOffer());

    }

    private void saveFoodItem(){

        mysqlCon.insertItemInAdminWindow1(view);
    }

    private String getComboSelectedItemPrice(){
        String item = (String) view.getItemsCBPrice().getItemAt(view.getItemsCBPrice().getSelectedIndex());
        return item;
    }

    private String getComboSelectedItemOffer(){
        String item = (String) view.getItemsCBOffer().getItemAt(view.getItemsCBOffer().getSelectedIndex());
        return item;
    }





    private void saveUpdatedPrice(){
        //item.setItemName(window.getAddItemName().getText());
        // String _item_name = item.getItemName();
        mysqlCon.updatePriceInAdminWindow1(view,getComboSelectedItemPrice());
    }

    private void saveUpdatedOffer(){
        //item.setItemName(window.getAddItemName().getText());
        // String _item_name = item.getItemName();
        mysqlCon.updateOfferInAdminWindow1(view,getComboSelectedItemOffer());
    }



                                                          /* try {
                                                               Class.forName("com.mysql.cj.jdbc.Driver");
                                                               Connection con = DriverManager.getConnection(
                                                                       "jdbc:mysql://localhost:3306/drive_thru", "root", "mysql95");
                                                               System.out.println("connection created");
                                                               String query = " insert into items (ItemId, ItemName, Price, Visibility, Offers, Type)"
                                                                       + " values (?, ?, ?, ?, ?, ?)";

                                                               // create the mysql insert prepared statement
                                                               PreparedStatement preparedStmt = con.prepareStatement(query);
                                                               preparedStmt.setString(1, "4");
                                                               preparedStmt.setString(2,view.getItemTextField().getText());
                                                               preparedStmt.setInt(3, 100);
                                                               preparedStmt.setBoolean(4, true);
                                                               preparedStmt.setInt(5, 10);
                                                               preparedStmt.setString(6, "Burger");

                                                               // execute the prepared statement
                                                               preparedStmt.executeUpdate();

                                                               con.close();
                                                           } catch (Exception s) {
                                                               System.out.println(s);
                                                           }
                                                       }
                                                   });
                                               }
*/
                                                   // AddIBurgerListener addListener = new AddIBurgerListener();

                                                   // myButton = view.getAddFoodItemButton();
                                                   // myButton.addActionListener(addlistener);

                                                   // class addlistener implements ActionListener {
                                                   //   public void actionPerformed(ActionEvent event) {


                                                   // }

            }










   /* ActionListener BuyListener = new ActionListener() {
        public void actionPerformed(ActionEvent event) {

            JFrame billingFrame = new JFrame();

            billingFrame.setSize(300,300);
            billingFrame.setTitle("Success");
            JLabel thankyouMessage = new JLabel();
            thankyouMessage.setBounds(150,100,10,20);
            thankyouMessage.setText("       Payment Succesful. Enjoy your meal!!");

            billingFrame.add(thankyouMessage);

            billingFrame.setVisible(true);
            frame.setVisible(false);

        }
    };*/



