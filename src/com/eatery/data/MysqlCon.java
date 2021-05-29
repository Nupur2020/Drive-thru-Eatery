package com.eatery.data;

import com.eatery.models.BurgerBuilder;
import com.eatery.models.DrinksBuilder;
import com.eatery.models.FriesBuilder;
import com.eatery.models.Item;
import com.eatery.views.AdminWindow;

import java.sql.*;
import java.util.ArrayList;


public class MysqlCon {

    private Connection con;
    Statement statement;
    //Controller controller = new Controller();

    //  public static void main(String args[]){
    // try{
    public MysqlCon() throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/drive_thru", "root", "password");
        System.out.println("Connection Created");
    }

    /*public void insertItemInAdminWindow1(AdminWindow1 view) {
        try {

            String query = " insert into items (ItemName, Price, Visibility, Offers, Type)"
                    + " values (?, ?, ?, ?, ?)";

            // create the mysql insert prepared statement
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, view.getItemTextField().getText());
            preparedStmt.setInt(2, Integer.parseInt(view.getSetPriceTextField().getText()));
            preparedStmt.setBoolean(3, true);
            preparedStmt.setInt(4, 10);
            preparedStmt.setString(5, "Burger");

            // execute the prepared statement
            preparedStmt.executeUpdate();

            con.close();
        } catch (Exception s) {
            System.out.println(s);
        }
    }*/



    public void updatePriceInAdminWindow1(AdminWindow view, String item) {
        try {

            String query = " update items set Price = ? where ItemName= ?" ;


            // create the mysql insert prepared statement
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, Integer.parseInt(view.getChangePriceTextField().getText()));
            preparedStmt.setString(2,item);

            preparedStmt.executeUpdate();

            con.close();
        } catch (Exception s) {
            System.out.println(s);
        }
    }


    public void updateOfferInAdminWindow1(AdminWindow view, String item) {
        try {

            String query = " update items set Offers = ? where ItemName= ?" ;


            // create the mysql insert prepared statement
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, Integer.parseInt(view.getChangeOfferTextField().getText()));
            preparedStmt.setString(2, item);

            preparedStmt.executeUpdate();

            con.close();
        } catch (Exception s) {
            System.out.println(s);
        }
    }



    public ArrayList<Item> getItemsList(){
        ArrayList<Item> result = new ArrayList<>();
        try {
            statement = (Statement) con.createStatement();
            String sql = "select * from items";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int itemId = resultSet.getInt("ItemId");
                String itemName = resultSet.getString("ItemName");
                int price = resultSet.getInt("Price");
                Boolean visibility = resultSet.getBoolean("Visibility");
                int offers = resultSet.getInt("Offers");
                String type = resultSet.getString("Type");


                /*Item item = new Item(itemId, itemName, price, visibility, offers) {
                    @Override
                    public int getTotalPrice() {
                        return 0;
                    }

                };*/
                Item item;
                if(type.equalsIgnoreCase("Burger")) {
                    item = new BurgerBuilder(itemName, price)
                            .setId(itemId)
                            .setVisibility(visibility)
                            .setOffers(offers)
                            .build();
                } else if(type.equalsIgnoreCase("Fries")) {
                    item = new FriesBuilder(itemName, price)
                            .setId(itemId)
                            .setVisibility(visibility)
                            .setOffers(offers)
                            .build();
                } else {
                    item = new DrinksBuilder(itemName, price)
                            .setId(itemId)
                            .setVisibility(visibility)
                            .setOffers(offers)
                            .build();
                }
                result.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

}



