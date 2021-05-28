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

            // TODO: STEP 1 Create a Database connection
               MySqlHelper mySqlHelper = MySqlHelper.getInstance();

            // TODO STEP 2 Read the data from database
                ArrayList<Item> data = (ArrayList<Item>) mySqlHelper.getItems();

            // TODO STEP 4 Init Controller
            Controller c = new Controller();

            // TODO STEP 3 Initialize UI
            FirstWindow firstWindow = new FirstWindow(c);
        }
    }

