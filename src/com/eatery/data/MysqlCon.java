package com.eatery.data;

import java.sql.*;


class MysqlCon{
    public static void main(String args[]){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test","root","password");
            System.out.println("connection created");
            con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}