package com.eatery.data;

import java.sql.*;


class MysqlCon{
    public static void main(String args[]){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/drive_thru","root","mysql95");
            System.out.println("connection created");
            String query = " insert into items (ItemId, ItemName, Price, Visibility, Offers, Type)"
                    + " values (?, ?, ?, ?, ?, ?)";

            // create the mysql insert prepared statement
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString (1, "11");
            preparedStmt.setString (2, "butter");
            preparedStmt.setInt   (3, 25);
            preparedStmt.setBoolean(4, true);
            preparedStmt.setInt    (5, 10);
            preparedStmt.setString(6,"Burger");

            // execute the prepared statement
            preparedStmt.execute();

            con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}