import javax.swing.*;


import javax.swing.JButton;
        import javax.swing.JFrame;
        import javax.swing.JOptionPane;

public class firstWindow {

    public static void main(final String[] args) {
        final JFrame parent = new JFrame();
        JButton button = new JButton();

        button.setText("Start Application");
        parent.add(button);
        parent.setSize(600,600);
        parent.pack();
        parent.setVisible(true);

        button.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //String name = JOptionPane.showInputDialog(parent,
                //  "Choose Account type", null);

                String[] options = {"Administrator", "Customer"};
                int opt = JOptionPane.showOptionDialog(parent,
                        "Choose Account type",
                        "Accounts",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

                System.out.println("opt"+opt);






            }
        });
    }
}






