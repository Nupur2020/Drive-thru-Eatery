import com.eatery.controllers.Controller;
import com.eatery.data.MysqlCon;
import com.eatery.models.Burger;
import com.eatery.models.Item;
import com.eatery.views.AdminWindow1;

import java.sql.SQLException;

public class App {
        public static void main(String[] args) throws SQLException, ClassNotFoundException {
            // Assemble all the pieces of the MVC

    Burger m = new Burger(101, "TofuBurger", 5, true, 10, "burger");
            MysqlCon mysqlCon = new MysqlCon();
            AdminWindow1 v = new AdminWindow1("Admin Window",mysqlCon);

            Controller c = new Controller(v, m, mysqlCon );
            c.initController();
        }
    }

