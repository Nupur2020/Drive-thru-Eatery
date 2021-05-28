import com.eatery.controllers.Controller;
import com.eatery.data.MySqlHelper;
import com.eatery.data.MysqlCon;
import com.eatery.models.Burger;
import com.eatery.models.Item;
import com.eatery.views.AdminWindow1;
import com.eatery.views.CustomerWindow1;
import com.eatery.views.FirstWindow;
import com.eatery.views.PaymentWindow;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class App {

        public static void main(String[] args) throws SQLException, ClassNotFoundException {
            // Assemble all the pieces of the MVC
            //Fake Data
            //Burger item = new Burger(101, "TofuBurger", 5, true, 10, "burger");
            // TODO: STEP 1 Create a Database connection
            //MysqlCon mysqlCon = new MysqlCon();
            MySqlHelper mySqlHelper = MySqlHelper.getInstance();
            // TODO STEP 2 Read the data from database
            //ArrayList<Item> data = mySqlHelper.getItemsList();
            ArrayList<Item> data = (ArrayList<Item>) mySqlHelper.getItems();
            // TODO STEP 3 Initialize UI
            //AdminWindow1 adminWindow1 = new AdminWindow1();
            //CustomerWindow1 customerWindow1 = new CustomerWindow1();
            FirstWindow firstWindow = new FirstWindow();
           // PaymentWindow paymentWindow= new PaymentWindow();
            // TODO STEP 4 Init Controller
            //Controller c = new Controller(adminWindow1,customerWindow1, firstWindow, paymentWindow, data, mysqlCon);
            Controller c = new Controller(firstWindow);
            c.initController();
        }
    }

