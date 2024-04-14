import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateAccountScreen extends JPanel implements ActionListener {

    private MainFrame mainFrame;
    private JPanel leftPanel, rightPanel;
    private JLabel createAccountLabel, usernameLabel, emailLabel, passwordLabel,securityQuestionLabel,securityAnswerLabel,accountTypeLabel;
    private JTextField usernameTextField, emailTextField, passwordTextField,securityAnswerTextField;
    private JComboBox<String> securityQuestionComboBox,accountTypeComboBox;
    JButton submitButton;

    CreateAccountScreen(MainFrame mainFrame){

        this.mainFrame = mainFrame;
        leftPanel = new ImagePanel("data/images/nebula.jpg");
        rightPanel = new JPanel();

        createAccountLabel = new JLabel("Create Account");
        createAccountLabel.setFont(new Font("Monaco", Font.PLAIN, 35));
        createAccountLabel.setForeground(Color.WHITE);

        usernameLabel = new JLabel("Username: ");
        usernameLabel.setFont(new Font("Monaco", Font.PLAIN, 20));
        usernameLabel.setForeground(Color.WHITE);

        usernameTextField = new JTextField(15);

        emailLabel = new JLabel("Email: ");
        emailLabel.setFont(new Font("Monaco", Font.PLAIN, 20));
        emailLabel.setForeground(Color.WHITE);

        emailTextField = new JTextField(15);

        passwordLabel = new JLabel("Password: ");
        passwordLabel.setFont(new Font("Monaco", Font.PLAIN, 20));
        passwordLabel.setForeground(Color.WHITE);

        passwordTextField = new JPasswordField(15);

        accountTypeLabel = new JLabel("Account type: ");
        accountTypeLabel.setFont(new Font("Monaco", Font.PLAIN, 20));
        accountTypeLabel.setForeground(Color.WHITE);

        String[] accountTypes = {"Admin","Manager","Sommelier"};
        accountTypeComboBox = new JComboBox<>(accountTypes);

        securityQuestionLabel = new JLabel("Security Questions: ");
        securityQuestionLabel.setFont(new Font("Monaco", Font.PLAIN, 20));
        securityQuestionLabel.setForeground(Color.WHITE);

        String[] questions = {"What is your pet's name?", "What is your mother's maiden name?", "What was the name of your first school?"};
        securityQuestionComboBox = new JComboBox<>(questions);

        securityAnswerLabel = new JLabel("Security Question Answer: ");
        securityAnswerLabel.setFont(new Font("Monaco", Font.PLAIN, 20));
        securityAnswerLabel.setForeground(Color.WHITE);
        securityAnswerTextField = new JTextField(15);

        submitButton = new JButton("SUBMIT");
        submitButton.setBounds(200,100,250, 150);
        submitButton.setFocusPainted(false);
        submitButton.setBackground(Color.WHITE);

        rightPanel.setBackground(new Color(29, 29, 38));
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.add(Box.createVerticalStrut(60));
        rightPanel.add(createAccountLabel);
        rightPanel.add(Box.createVerticalStrut(20));
        rightPanel.add(usernameLabel);
        rightPanel.add(usernameTextField);
        rightPanel.add(Box.createVerticalStrut(15));
        rightPanel.add(emailLabel);
        rightPanel.add(emailTextField);
        rightPanel.add(Box.createVerticalStrut(15));
        rightPanel.add(passwordLabel);
        rightPanel.add(passwordTextField);
        rightPanel.add(Box.createVerticalStrut(15));
        rightPanel.add(accountTypeLabel);
        rightPanel.add(accountTypeComboBox);
        rightPanel.add(Box.createVerticalStrut(15));
        rightPanel.add(securityQuestionLabel);
        rightPanel.add(securityQuestionComboBox);
        rightPanel.add(Box.createVerticalStrut(15));
        rightPanel.add(securityAnswerLabel);
        rightPanel.add(securityAnswerTextField);
        rightPanel.add(Box.createVerticalStrut(15));
        rightPanel.add(submitButton);

        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        centerPanel.setBackground(new Color(29, 29, 38));
        centerPanel.add(rightPanel);

        this.setLayout(new GridLayout(1, 2));
        this.add(leftPanel);
        this.add(centerPanel);

        submitButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mainFrame.changeScreen("Home Screen");
    }
}
