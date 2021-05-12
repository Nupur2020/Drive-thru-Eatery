
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.awt.event.MouseAdapter;
        import java.awt.event.MouseEvent;

public class customerWindow {
    public static void main() {


        JFrame frame = new JFrame();

        JLabel l;
        l = new JLabel("label1");
        l.setText("CHOOSE AND PAY");
        l.setBounds(30,50, 150,50);

        frame.add(l);

        JLabel ll;
        ll = new JLabel("label2");
        ll.setText("YOUR ORDER");
        ll.setBounds(320,50, 150,50);

        frame.add(ll);

        JLabel burgerorder;
        burgerorder = new JLabel();

        burgerorder.setBounds(320,80, 150,50);

        frame.add(burgerorder);

        JLabel friesorder;
        friesorder = new JLabel();

        friesorder.setBounds(320,150, 150,50);

        frame.add(friesorder);

        JLabel cokeorder;
        cokeorder = new JLabel();

        cokeorder.setBounds(320,230, 150,50);

        frame.add(cokeorder);



        frame.setBounds(50, 50, 500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JButton burgersButton = new JButton("Burgers");
        burgersButton.setBounds(20, 100, 89, 23);
        frame.add(burgersButton);

        JButton friesButton = new JButton("Fries");
        friesButton.setBounds(20,170,89,23);
        frame.add(friesButton);

        JButton cokeButton = new JButton("Coke");
        cokeButton.setBounds(20,240,89,23);
        frame.add(cokeButton);





        ActionListener BuyListener = new ActionListener() {
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
        };

        JButton addButton = new JButton("BUY");
        addButton.addActionListener(BuyListener);
        addButton.setBounds(60,310,150,23);
        frame.add(addButton);

        frame.setTitle("Customer Order");
        frame.setVisible(true);








        class AddInterestListener implements ActionListener {
            public void actionPerformed(ActionEvent event) {
                System.out.println("hello, I was pressed");
            }
        }

        ActionListener listener = new AddInterestListener();
        burgersButton.addActionListener(listener);


        JButton btnClickMe = new JButton("Item");
        btnClickMe.setBounds(120, 100, 89, 23);
        frame.getContentPane().add(btnClickMe);

        final JPopupMenu menu = new JPopupMenu();



        ActionListener menuListener = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.out.println("Popup menu item ["
                        + event.getActionCommand() + "] was pressed.");
                burgerorder.setText(event.getActionCommand());
            }
        };


        JMenuItem item1 = new JMenuItem("CheeseBurger"+" "+"$2.99");
        item1.addActionListener(menuListener);
        JMenuItem item2 = new JMenuItem("HamBurger" +" $3.99");
        item2.addActionListener(menuListener);
        JMenuItem item3 = new JMenuItem("VeggieBurger"+" $4.99");
        item3.addActionListener(menuListener);



        menu.add(item1);
        menu.add(item2);
        menu.add(item3);

        btnClickMe.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == 1) {
                    //order.setText("Cheese");// 1-left, 2-middle, 3-right button
                    menu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });
        frame.add(menu);


     //   ====
        JButton btntoppingclick = new JButton("Topping");
        btntoppingclick.setBounds(120,170,89,23);
        frame.getContentPane().add(btntoppingclick);

        final JPopupMenu topping = new JPopupMenu();

        ActionListener friesListener = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.out.println("Popup menu item ["
                        + event.getActionCommand() + "] was pressed.");
                friesorder.setText(event.getActionCommand());
            }
        };

        JMenuItem topping1 = new JMenuItem("Cheese"+" :$5");
        topping1.addActionListener(friesListener);
        JMenuItem topping2 = new JMenuItem("Caramel"+" :$3");
        topping2.addActionListener(friesListener);
       // JMenuItem price3 = new JMenuItem("$7");




        topping.add(topping1);
        topping.add(topping2);
       // price.add(price3);

        btntoppingclick.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == 1) { // 1-left, 2-middle, 3-right button
                    topping.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });
        frame.add(topping);


        JButton btncokeclick = new JButton("Size");
        btncokeclick.setBounds(120,240,89,23);
        frame.getContentPane().add(btncokeclick);

        final JPopupMenu coke = new JPopupMenu();


        ActionListener cokeListener = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.out.println("Popup menu item ["
                        + event.getActionCommand() + "] was pressed.");
                cokeorder.setText(event.getActionCommand());
            }
        };


        JMenuItem coke1 = new JMenuItem("Small" +" :$5");
        coke1.addActionListener(cokeListener);
        JMenuItem coke2 = new JMenuItem("Large" +" :$9");
        coke2.addActionListener(cokeListener);
        // JMenuItem price3 = new JMenuItem("$7");

        coke.add(coke1);
        coke.add(coke2);
        // price.add(price3);

        btncokeclick.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == 1) { // 1-left, 2-middle, 3-right button
                    coke.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });
        frame.add(coke);

















       /* JButton btnpriceclick = new JButton("Price");
        btnpriceclick.setBounds(220,170,89,23);
        frame.getContentPane().add(btnpriceclick);

        final JPopupMenu topping = new JPopupMenu();

        JMenuItem price1 = new JMenuItem("$5");
        JMenuItem price2 = new JMenuItem("$3");
        JMenuItem price3 = new JMenuItem("$7");

        price.add(price1);
        price.add(price2);
        price.add(price3);

        btnpriceclick.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == 1) { // 1-left, 2-middle, 3-right button
                    price.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });
        frame.add(price);*/


    }}