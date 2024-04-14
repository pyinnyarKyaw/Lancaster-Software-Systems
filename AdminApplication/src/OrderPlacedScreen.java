import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrderPlacedScreen extends JPanel {
    private JLabel orderPlacedJLabel;
    private JLabel receiptJLabel;
    private Box box;
    public OrderPlacedScreen(){
        box = Box.createVerticalBox();
        orderPlacedJLabel = new JLabel("Order Placed");

        // Add code to send order to database

        receiptJLabel = new JLabel("Receipt has been sent to Kitchen");

        box.add(orderPlacedJLabel);
        box.add(receiptJLabel);

        add(box);
    }
}
