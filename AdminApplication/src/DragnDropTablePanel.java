import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class DragnDropTablePanel extends JLayeredPane {
    private ArrayList<JLabel> jLabelArrayList;

    private JLabel titleJLabel;

    private ImageIcon table = new ImageIcon(new ImageIcon("data/images/Table.png").getImage().getScaledInstance(150, 75, Image.SCALE_SMOOTH));
    private ImageIcon closedTable = new ImageIcon(new ImageIcon("data/images/closedTable.png").getImage().getScaledInstance(150, 75, Image.SCALE_SMOOTH));

    public DragnDropTablePanel() {
        setLayout(new BorderLayout());
        jLabelArrayList = new ArrayList<>();
        titleJLabel = new JLabel("   Lancaster’s table plan for ");
        titleJLabel.setFont(new Font("Monaco", Font.PLAIN, 20));
        add(titleJLabel, BorderLayout.NORTH);
    }
    public void createTable(){
        int x = 0;
        int y = 0;
        // Code from stack overflow
        //ImageIcon imageIcon = new ImageIcon(new ImageIcon("data/images/Table.png").getImage().getScaledInstance(150, 75, Image.SCALE_SMOOTH));
        JLabel label = new JLabel(table);
        label.setText(String.valueOf(jLabelArrayList.size() + 1));
        label.setHorizontalTextPosition(JButton.CENTER);
        label.setVerticalTextPosition(JButton.CENTER);
        label.setSize(label.getPreferredSize());
        label.setLocation(x, y);
        MouseHandler mh  = new MouseHandler();
        label.addMouseListener(mh);
        label.addMouseMotionListener(mh);
        add(label);
        jLabelArrayList.add(label);
    }

    // Code from stack overflow
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 800);
    }

    // Code from stack overflow
    public class MouseHandler extends MouseAdapter {
        private Point offset;

        @Override
        public void mousePressed(MouseEvent e) {
            // Right-clicked = 1, Left-Clicked = 3
            JLabel label = (JLabel) e.getComponent();
            if(e.getButton() == 1){
                moveToFront(label);
                offset = e.getPoint();
            } else if (e.getButton() == 3) {
                label = (JLabel) e.getComponent();
                if(label.getIcon().equals(table)){
                    label.setIcon(closedTable);
                }else{
                    label.setIcon(table);
                }
            }
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            // Code from stack overflow
            int x = e.getPoint().x - offset.x;
            int y = e.getPoint().y - offset.y;
            Component component = e.getComponent();
            Point location = component.getLocation();
            location.x += x;
            location.y += y;
            component.setLocation(location);
        }
    }

    public void setTitleJLabel(String title){
        titleJLabel.setText(title);
    }

    public String getTitleJLabel(){
        return titleJLabel.getText();
    }

}
