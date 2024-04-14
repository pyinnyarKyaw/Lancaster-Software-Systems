//import required classes and packages
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class HomeScreen extends JPanel implements ActionListener
{
    private MainFrame mainFrame;
    private JLabel label;

    HomeScreen(MainFrame mainFrame)
    {
        this.mainFrame = mainFrame;

        label = new JLabel("Home");
        add(label);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}