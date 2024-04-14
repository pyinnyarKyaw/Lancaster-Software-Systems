import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class TableLayoutScreen extends JPanel implements ActionListener {
    private JPanel centerPanel, leftPanel;
    private DragnDropTablePanel dragnDropTablePanel;

    private JButton tableJButton, saveButton;

    private JLabel dateJLabel;

    private JTextField dateTextField;

    public TableLayoutScreen(){
        setLayout(new BorderLayout());
        centerPanel = new JPanel(new BorderLayout());
        leftPanel = new JPanel(new FlowLayout());
        dragnDropTablePanel = new DragnDropTablePanel();
        dragnDropTablePanel.setBackground(new Color(0, 255, 0));


        ImageIcon imageIcon = new ImageIcon(new ImageIcon("data/images/Table.png").getImage().getScaledInstance(150, 75, Image.SCALE_SMOOTH));

        tableJButton = new JButton(imageIcon);
        tableJButton.setSize(tableJButton.getPreferredSize());
        tableJButton.setMargin(new Insets(0,0,0,0));
        tableJButton.setBorder(null);
        tableJButton.addActionListener(this);

        dateJLabel = new JLabel("Add date: ");
        dateJLabel.setFont(new Font("Monaco", Font.PLAIN, 15));
        dateJLabel.setForeground(new Color(255,255,255));

        dateTextField = new JTextField(10);
        dateTextField.addActionListener(this);

        saveButton = new JButton("Save");
        saveButton.addActionListener(this);
        saveButton.setPreferredSize(tableJButton.getPreferredSize());

        leftPanel.add(saveButton);
        leftPanel.add(dateJLabel);
        leftPanel.add(dateTextField);
        leftPanel.add(tableJButton);


        leftPanel.setBackground(new Color(41, 46, 43));
        leftPanel.setPreferredSize(new Dimension(tableJButton.getPreferredSize().width + 20, tableJButton.getPreferredSize().height));

        add(leftPanel, BorderLayout.WEST);
        add(dragnDropTablePanel, BorderLayout.CENTER);
        setBackground(new Color(255, 255, 255));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(tableJButton)){
            dragnDropTablePanel.createTable();
        } else if (e.getSource().equals(dateTextField)) {
            dragnDropTablePanel.setTitleJLabel("   Lancaster’s table plan for " + dateTextField.getText());
        } else if(e.getSource().equals(saveButton)){
            BufferedImage image = null;
            try {
                image = new Robot().createScreenCapture(new Rectangle(dragnDropTablePanel.getLocationOnScreen().x, dragnDropTablePanel.getLocationOnScreen().y, dragnDropTablePanel.getWidth(), dragnDropTablePanel.getHeight()));
                File file = new File("data/images/tablePlans/" + dragnDropTablePanel.getTitleJLabel() +".png");
                int n = 1;
                while(file.exists()){
                    file = new File("data/images/tablePlans/" + dragnDropTablePanel.getTitleJLabel() + "(" + n + ")" + ".png");
                    n++;
                }
                file.createNewFile();
                ImageIO.write(image, "png", file);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }
}
