import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SendOrderScreen extends JPanel implements ActionListener {
    private OrderPlacedScreen orderPlacedScreen;
    private TableScreen orderTableScreen;
    private JButton submitJButton, fetchJButton, returnJButton;
    private Box verticalBox;
    public SendOrderScreen(){
        verticalBox = Box.createVerticalBox();

        orderTableScreen = new TableScreen(3);
        orderPlacedScreen = new OrderPlacedScreen();

        fetchJButton = new JButton("Fetch Order");
        submitJButton = new JButton("Place Order");
        returnJButton = new JButton("Return");

        fetchJButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        submitJButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        returnJButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        fetchJButton.addActionListener(this);
        submitJButton.addActionListener(this);
        returnJButton.addActionListener(this);

        verticalBox.add(fetchJButton);
        verticalBox.add(orderTableScreen);
        verticalBox.add(submitJButton);

        add(verticalBox);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(submitJButton)){
            // Grey out order button if database contains the date currently being displayed by the table
            verticalBox.remove(orderTableScreen);
            verticalBox.remove(submitJButton);
            verticalBox.add(orderPlacedScreen);
            verticalBox.add(returnJButton);
            revalidate();
        } else if (e.getSource().equals(returnJButton)) {
            verticalBox.remove(orderPlacedScreen);
            verticalBox.remove(returnJButton);
            verticalBox.add(orderTableScreen);
            verticalBox.add(submitJButton);
            revalidate();
        } else if (e.getSource().equals(fetchJButton)) {
            // Call Kitchen Interface to fetch the order
        }
    }
}
