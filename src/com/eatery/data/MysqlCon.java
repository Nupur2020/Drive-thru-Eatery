package com.eatery.data;

import com.eatery.controllers.Controller;
import com.eatery.views.AdminWindow1;

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
                "jdbc:mysql://localhost:3306/drive_thru", "root", "mysql95");
        System.out.println("Connection Created");
    }

    public void insertItemInAdminWindow1(AdminWindow1 view) {
        try {

            String query = " insert into items (ItemId, ItemName, Price, Visibility, Offers, Type)"
                    + " values (?, ?, ?, ?, ?, ?)";

            // create the mysql insert prepared statement
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, "4");
            preparedStmt.setString(2, view.getItemTextField().getText());
            preparedStmt.setInt(3, Integer.parseInt(view.getSetPriceTextField().getText()));
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



    public void updatePriceInAdminWindow1(AdminWindow1 view,String item) {
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


    public void updateOfferInAdminWindow1(AdminWindow1 view,String item) {
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



    public ArrayList getItemsList(){
        try {
            ArrayList<String> inner = new ArrayList<String>();
            statement = (Statement) con.createStatement();
            String sql;
            sql = "select * from items";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                inner.add(resultSet.getString("ItemName"));
            }

            return inner;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}



