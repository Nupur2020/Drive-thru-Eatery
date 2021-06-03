package com.eatery;

import com.eatery.controllers.Controller;
import com.eatery.data.MySqlHelper;
import com.eatery.models.Item;
import com.eatery.views.FirstWindow;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class App {

        public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {

            // TODO: STEP 1 Create a Database connection
               //MySqlHelper mySqlHelper = MySqlHelper.getInstance();

            // TODO STEP 2 Read the data from database
                //ArrayList<Item> data = (ArrayList<Item>) mySqlHelper.getItems();

            // TODO STEP 1 Init Controller
            Controller c = new Controller();

            // TODO STEP 2 Initialize UI
            FirstWindow firstWindow = new FirstWindow(c);
        }
    }

