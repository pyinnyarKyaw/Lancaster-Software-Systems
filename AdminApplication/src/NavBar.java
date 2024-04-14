//import required classes and packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class NavBar extends JPanel implements ActionListener
{
    private MainFrame mainFrame;

    private JButton homeButton, reportsButton, salesButton, staffingButton, tableLayoutButton, orderButton, logoutButton;
    NavBar(MainFrame mainFrame)
    {
        this.mainFrame = mainFrame;
        setBackground(new Color(44, 44, 59));

        homeButton = new JButton("HOME");
        salesButton = new JButton("SALES");
        staffingButton = new JButton("STAFFING");
        reportsButton = new JButton("REPORTS");
        tableLayoutButton = new JButton("TABLES");
        orderButton = new JButton("ORDERS");
        logoutButton = new JButton("LOGOUT");

        homeButton.addActionListener(this);
        salesButton.addActionListener(this);
        staffingButton.addActionListener(this);
        reportsButton.addActionListener(this);
        tableLayoutButton.addActionListener(this);
        orderButton.addActionListener(this);
        logoutButton.addActionListener(this);

        add(homeButton);
        add(reportsButton);
        add(salesButton);
        add(staffingButton);
        add(tableLayoutButton);
        add(orderButton);
        add(logoutButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(homeButton)){
            mainFrame.changeScreen("HOME");
        }else if (e.getSource().equals(salesButton)) {
            mainFrame.changeScreen("SALES");
        }else if(e.getSource().equals(staffingButton)){
            mainFrame.changeScreen("STAFFING");
        }else if(e.getSource().equals(reportsButton)){
            mainFrame.changeScreen("REPORTS");
        }else if(e.getSource().equals(logoutButton)){
            mainFrame.changeScreen("LOGIN");
        }else if(e.getSource().equals(tableLayoutButton)){
            mainFrame.changeScreen("TABLES");
        }else if(e.getSource().equals(orderButton)){
            mainFrame.changeScreen("ORDERS");
        }
    }
}