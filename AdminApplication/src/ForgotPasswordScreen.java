import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ForgotPasswordScreen extends JPanel implements ActionListener{
    private MainFrame mainFrame;
    private JLabel instructionLabel, usernameLabel, securityQuestionLabel, emailLabel;
    private JTextField usernameTextField, emailTextField;
    private JComboBox<String> securityQuestionComboBox;
    private JTextField securityAnswerTextField;
    private JButton sendEmailButton;

    ForgotPasswordScreen(MainFrame mainFrame){
        this.mainFrame = mainFrame;
        this.setLayout(new GridLayout(5, 2, 10, 10));

        instructionLabel = new JLabel("Please fill in your details:");
        instructionLabel.setFont(new Font("Monaco", Font.BOLD, 16));

        usernameLabel = new JLabel("Username:");
        usernameTextField = new JTextField(15);

        securityQuestionLabel = new JLabel("Security Questions: ");
        String[] questions = {"What is your pet's name?", "What is your mother's maiden name?", "What was the name of your first school?"};
        securityQuestionComboBox = new JComboBox<>(questions);
        securityAnswerTextField = new JTextField(15);

        emailLabel = new JLabel("Email:");
        emailTextField = new JTextField(15);

        sendEmailButton = new JButton("Send Reset Link");
        sendEmailButton.addActionListener(this);

        this.add(instructionLabel);
        this.add(new JLabel("")); // Placeholder for grid layout
        this.add(usernameLabel);
        this.add(usernameTextField);
        this.add(securityQuestionLabel);
        this.add(securityQuestionComboBox);
        this.add(new JLabel("Answer:"));
        this.add(securityAnswerTextField);
        this.add(emailLabel);
        this.add(emailTextField);
        this.add(sendEmailButton);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sendEmailButton) {
            JOptionPane.showMessageDialog(this, "A reset link has been sent to your email.", "Reset Link Sent", JOptionPane.INFORMATION_MESSAGE);

        }

    }
}
