import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class LoginScreen extends JPanel implements ActionListener
{
    private MainFrame mainFrame;
    JButton submitButton, forgotUsernameButton, forgotPasswordButton;
    private JPanel leftPanel, rightPanel;
    private JLabel loginLabel, usernameLabel, passwordLabel;
    final JTextField usernameTextField, passwordTextField;


    LoginScreen(MainFrame mainFrame)
    {
        this.mainFrame = mainFrame;
        leftPanel = new ImagePanel("data/images/nebula.jpg");
        rightPanel = new JPanel();


        loginLabel = new JLabel();
        loginLabel.setText("Login");
        loginLabel.setFont(new Font("Monaco", Font.PLAIN, 35));
        loginLabel.setForeground(new Color(255,255,255));


        usernameLabel = new JLabel();
        usernameLabel.setText("Username: ");
        usernameLabel.setFont(new Font("Monaco", Font.PLAIN, 20));
        usernameLabel.setForeground(new Color(255,255,255));


        usernameTextField = new JTextField(15);
        usernameTextField.setFont(new Font("Monaco", Font.PLAIN, 20));


        passwordLabel = new JLabel();
        passwordLabel.setText("Password: ");
        passwordLabel.setFont(new Font("Monaco", Font.PLAIN, 20));
        passwordLabel.setForeground(new Color(255,255,255));


        passwordTextField = new JPasswordField(15);
        passwordTextField.setFont(new Font("Monaco", Font.PLAIN, 20));

        forgotUsernameButton = new JButton("Forgot Username");
        forgotUsernameButton.setFocusPainted(false);
        forgotUsernameButton.setContentAreaFilled(false);
        forgotUsernameButton.setOpaque(false);
        forgotUsernameButton.setForeground(Color.WHITE);
        forgotUsernameButton.addActionListener(this);


        forgotPasswordButton = new JButton("Forgot Password");
        forgotPasswordButton.setFocusPainted(false);
        forgotPasswordButton.setContentAreaFilled(false);
        forgotPasswordButton.setOpaque(false);
        forgotPasswordButton.setForeground(Color.WHITE);
        forgotPasswordButton.addActionListener(this);

        submitButton = new JButton("SUBMIT");
        submitButton.setBounds(200,100,250, 150);
        submitButton.setFocusPainted(false);
        submitButton.setBackground(new Color(255, 255, 255));

        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEADING, 0, 0);
        JPanel forgotButtonPanel = new JPanel(flowLayout);
        forgotButtonPanel.setOpaque(false);
        forgotButtonPanel.add(forgotUsernameButton);
        forgotButtonPanel.add(forgotPasswordButton);

        rightPanel.setBackground(new Color(29, 29, 38));
        rightPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 30));
        rightPanel.add(loginLabel);
        rightPanel.add(Box.createVerticalStrut(100));
        rightPanel.add(Box.createHorizontalStrut(100));
        rightPanel.add(usernameLabel);
        rightPanel.add(usernameTextField);
        rightPanel.add(Box.createVerticalStrut(15));
        rightPanel.add(Box.createHorizontalStrut(500));
        rightPanel.add(passwordLabel);
        rightPanel.add(passwordTextField);
        rightPanel.add(Box.createVerticalStrut(15));
        rightPanel.add(Box.createHorizontalStrut(1));
        rightPanel.add(forgotButtonPanel);
        rightPanel.add(Box.createVerticalStrut(15));
        rightPanel.add(Box.createHorizontalStrut(100));
        rightPanel.add(submitButton);

        this.setLayout(new GridLayout(1,2));

        this.add(leftPanel);
        this.add(rightPanel);

        submitButton.addActionListener(this);
    }


    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==submitButton){
            String username = usernameTextField.getText();
            String password = passwordTextField.getText();

            mainFrame.changeScreen("HOME");
        /*
        if (username.equals("username") && password.equals("pass")) {
            mainFrame.changeScreen("Home Screen");
        }
        else{
            System.out.println("Incorrect username or password");
        }
         */
        }   else if (ae.getSource()==forgotUsernameButton){
            JOptionPane.showMessageDialog(this, "A reset link has been sent to your email.", "Reset Link Sent", JOptionPane.INFORMATION_MESSAGE);
        }  else if (ae.getSource()==forgotPasswordButton){
            JOptionPane.showMessageDialog(this, "A reset link has been sent to your email.", "Reset Link Sent", JOptionPane.INFORMATION_MESSAGE);
        }

    }
}
