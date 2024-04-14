import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private LoginScreen loginScreen;
    private CreateAccountScreen createAccountScreen;
    private HomeScreen homeScreen;
    private TableScreen salesScreen;
    private TableScreen staffScreen;
    private ReportsScreen reportsScreen;

    private TableLayoutScreen tableLayoutScreen;

    private SendOrderScreen sendOrderScreen;

    private NavBar navBar;

    private JPanel centerPanel;

    private String currentPanel;
    MainFrame(){

        loginScreen = new LoginScreen(this);
        createAccountScreen = new CreateAccountScreen(this);
        homeScreen = new HomeScreen(this);
        salesScreen = new TableScreen( 1);
        staffScreen = new TableScreen( 2);
        reportsScreen = new ReportsScreen(this);
        tableLayoutScreen = new TableLayoutScreen();
        sendOrderScreen = new SendOrderScreen();
        navBar = new NavBar(this);


        setLayout(new BorderLayout());

        centerPanel = new JPanel();
        centerPanel.setLayout(new CardLayout());

        this.setSize(1280, 720);
        this.setTitle("Admin App");

        centerPanel.add(loginScreen);
        currentPanel = "LOGIN";

        add(navBar, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);

        centerPanel.setVisible(true);
        navBar.setVisible(false);
        setVisible(true);
    }

    public void changeScreen(String nextPanel){
        navBar.setVisible(true);
        if(currentPanel.equals("LOGIN")){
            loginScreen.setVisible(false);
            centerPanel.remove(loginScreen);
        } else if (currentPanel.equals("HOME")) {
            homeScreen.setVisible(false);
            centerPanel.remove(homeScreen);
        }else if (currentPanel.equals("SALES")) {
            salesScreen.setVisible(false);
            centerPanel.remove(salesScreen);
        } else if (currentPanel.equals("STAFFING")) {
            staffScreen.setVisible(false);
            centerPanel.remove(staffScreen);
        } else if (currentPanel.equals("REPORTS")) {
            reportsScreen.setVisible(false);
            centerPanel.remove(reportsScreen);
        }else if (currentPanel.equals("TABLES")) {
            tableLayoutScreen.setVisible(false);
            centerPanel.remove(tableLayoutScreen);
        }else if (currentPanel.equals("ORDERS")) {
            sendOrderScreen.setVisible(false);
            centerPanel.remove(sendOrderScreen);
        }

        if(nextPanel.equals("LOGIN")){
            centerPanel.add(loginScreen);
            navBar.setVisible(false);
            currentPanel = "LOGIN";
            revalidate();
        } else if (nextPanel.equals("HOME")) {
            centerPanel.add(homeScreen);
            currentPanel = "HOME";
            revalidate();
        } else if (nextPanel.equals("SALES")) {
            centerPanel.add(salesScreen);
            currentPanel = "SALES";
            revalidate();
        } else if (nextPanel.equals("STAFFING")) {
            centerPanel.add(staffScreen);
            currentPanel = "STAFFING";
            revalidate();
        } else if (nextPanel.equals("REPORTS")) {
            centerPanel.add(reportsScreen);
            currentPanel = "REPORTS";
            revalidate();
        }else if (nextPanel.equals("TABLES")) {
            centerPanel.add(tableLayoutScreen);
            currentPanel = "TABLES";
            revalidate();
        }else if (nextPanel.equals("ORDERS")) {
            centerPanel.add(sendOrderScreen);
            currentPanel = "ORDERS";
            revalidate();
        }
    }
}