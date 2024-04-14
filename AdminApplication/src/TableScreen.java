import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class TableScreen extends JPanel implements ActionListener {
    private JPanel topPanel, bottomBPanel2, bottomPanel, bottomTPanel, bottomBPanel;
    private HashMap<String, String[][]> dataMap;
    private String[][] data , data2;

    private String[] column1, column2, column3;
    private JComboBox<String> dateComboBox;
    private JTextField searchTextField;
    private JScrollPane jScrollPane;
    private JTable overviewJTable, jTable;

    private JLabel turnoverJLabel, tablesBookedJLabel, coversJLabel;

    private int type;
    public TableScreen(int type){
        this.type = type;
        this.setLayout(new BorderLayout());

        dateComboBox = new JComboBox<>();



        searchTextField = new JTextField(20);

        topPanel = new JPanel(new FlowLayout());

        topPanel.add(new JLabel("Select Date:"));
        topPanel.add(dateComboBox);
        topPanel.add(new JLabel("Search:"));
        topPanel.add(searchTextField);

        bottomBPanel2 = new JPanel(new BorderLayout());

        bottomPanel = new JPanel(new BorderLayout());

        bottomTPanel = new JPanel(new GridLayout(1, 3));

        if(type == 1) {
            turnoverJLabel = new JLabel("Turnover: ");
            turnoverJLabel.setFont(new Font("Turnover", Font.PLAIN, 20));

            tablesBookedJLabel = new JLabel("Tables booked: ");
            tablesBookedJLabel.setFont(new Font("Turnover", Font.PLAIN, 20));

            coversJLabel = new JLabel("Covers: ");
            coversJLabel.setFont(new Font("Turnover", Font.PLAIN, 20));

            bottomTPanel.add(turnoverJLabel);
            bottomTPanel.add(tablesBookedJLabel);
            bottomTPanel.add(coversJLabel);
        }


        bottomPanel = new JPanel(new BorderLayout());

        bottomBPanel = new JPanel(new BorderLayout());

        readInData();
        setUpTable();

        searchTextField.addActionListener(this);
        dateComboBox.addActionListener(this);

        bottomPanel.add(bottomTPanel, BorderLayout.NORTH);
        bottomPanel.add(bottomBPanel, BorderLayout.CENTER);
        bottomPanel.add(bottomBPanel2, BorderLayout.SOUTH);

        this.add(topPanel, BorderLayout.NORTH);
        this.add(bottomPanel, BorderLayout.CENTER);
        this.setSize(1280, 720);
        this.setVisible(true);
    }

    public void readInData(){
        // temp data
        if(type == 1){
            data = new String[][]{
                    {"1", "Spaghetti Carbonara", "12.99", "5.50", "7.49", "35", "262.15"},
                    {"2", "Grilled Salmon", "15.99", "8.00", "7.99", "20", "159.80"},
                    {"3", "Chicken Alfredo", "11.99", "4.50", "7.49", "45", "337.05"},
                    {"4", "Caesar Salad", "8.99", "3.00", "5.99", "18", "107.82"},
                    {"5", "Margherita Pizza", "10.99", "3.50", "7.49", "30", "224.70"}
            };


            data2 = new String[][]{
                    {"1", "Spaghetti Carbonara", "12.99", "5.50", "7.49", "25", "187.25"},
                    {"2", "Grilled Salmon", "15.99", "8.00", "7.99", "18", "143.82"},
                    {"3", "Chicken Alfredo", "11.99", "4.50", "7.49", "30", "224.70"},
                    {"4", "Caesar Salad", "8.99", "3.00", "5.99", "12", "71.88"},
                    {"5", "Margherita Pizza", "10.99", "3.50", "7.49", "20", "149.80"}
            };
        } else if (type == 2) {
            data = new String[][] {
                    {"101", "John Doe", "Waiter", "7", "40", "8", "0", "No", "0"},
                    {"102", "Jane Smith", "Host", "4", "32", "8", "0", "Yes", "5"},
                    {"103", "Julie Lancaster", "Restaurant Manager", "5", "45", "9", "0", "No", "0"},
                    {"104", "Robert Lancaster", "Sommelier", "5", "40", "8", "0", "No", "0"},
                    {"105", "Ana Lancaster", "Head Chef", "6", "50", "10", "0", "No", "0"},
                    {"106", "Sarah Brown", "Sous Chef", "6", "45", "9", "0", "No", "0"},
                    {"107", "Thomas Lee", "Line Chef", "6", "45", "9", "0", "No", "0"},
                    {"108", "Alice Jones", "Admin", "5", "40", "8", "0", "No", "0"},
                    {"109", "Robert Clark", "Admin", "5", "40", "8", "0", "No", "0"}
            };


            data2 = new String[][] {
                    {"101", "John Doe", "Waiter", "5", "40", "8", "0", "No", "0"},
                    {"102", "Jane Smith", "Host", "4", "32", "8", "0", "Yes", "5"},
                    {"103", "Julie Lancaster", "Restaurant Manager", "5", "45", "9", "0", "No", "0"},
                    {"104", "Robert Lancaster", "Sommelier", "5", "40", "8", "0", "No", "0"},
                    {"105", "Ana Lancaster", "Head Chef", "6", "50", "10", "0", "No", "0"},
                    {"106", "Sarah Brown", "Sous Chef", "6", "45", "9", "0", "No", "0"},
                    {"107", "Thomas Lee", "Line Chef", "6", "45", "9", "0", "No", "0"},
                    {"108", "Alice Jones", "Admin", "5", "40", "8", "0", "No", "0"},
                    {"109", "Robert Clark", "Admin", "5", "40", "8", "0", "No", "0"}
            };
        } else if(type == 3){
            data = new String[][] {
                    {"Wagyu Beef", "2.0"},
                    {"Foie Gras", "0.5"},
                    {"Truffles", "0.1"},
                    {"Caviar", "0.25"},
                    {"Lobster", "1.0"},
                    {"Saffron", "5"},
                    {"Oysters", "24"},
                    {"Chanterelle Mushrooms", "0.5"},
                    {"Artisanal Cheese", "1.0"},
                    {"Tartufo Nero (Black Truffle)", "0.1"},
                    {"Chicken Breast", "5.0"},
                    {"Salmon Fillet", "2.0"},
                    {"Potatoes", "10.0"},
                    {"Extra Virgin Olive Oil", "2.0"},
                    {"Balsamic Vinegar", "1.0"},
                    {"Basmati Rice", "5.0"},
                    {"Broccoli", "2.0"},
                    {"Garlic", "1.0"},
                    {"Lemons", "24"}
            };

            data2 = data;
        }
        dataMap = new HashMap<>();
        dataMap.put("07/04/24", data2);
        dataMap.put("08/04/24", data);

        for (Map.Entry<String, String[][]> entry : dataMap.entrySet()) {
            dateComboBox.addItem(entry.getKey());
        }
    }

    private void setUpTable(){
        if(type == 1){
            column1 = new String[]{"Total Sales(£)", "Total Ingredients Cost(£)","Total Quantity Sold", "Total Profit(£)"};
            column2 = new String[]{"DishID","Dish Name","Price(£)", "Ingredients Cost per Dish(£)", "Profit per Dish(£)", "Quantity Sold", "Total Profit per Dish(£)"};
            // test data for overview table
            String[][] test = new String[][] {
                    {"£596.34", "183.02", "124", "413.32"}
            };

            overviewJTable = new JTable(test, column1);
            JScrollPane sp2=new JScrollPane(overviewJTable);
            bottomBPanel2.add(sp2);

        } else if (type == 2) {
            column2 = new String[]{"StaffID", "Staff Name", "Staff Role", "Days per Week", "Hours per Week", "Hours per Shift", "Hours Completed", "On Holiday (Yes/No)", "Holidays Accrued"};
        } else if (type == 3) {
            column2 = new String[]{"Ingredient Name", "Quantity"};
        }

        jTable = new JTable(dataMap.get("08/04/24"), column2);
        jTable.setCellSelectionEnabled(true);
        ListSelectionModel select= jTable.getSelectionModel();
        select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        select.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                String Data = null;
                int[] row = jTable.getSelectedRows();
                int[] columns = jTable.getSelectedColumns();
                for (int i = 0; i < row.length; i++) {
                    for (int j = 0; j < columns.length; j++) {
                        Data = (String) jTable.getValueAt(row[i], columns[j]);
                    } }
                System.out.println("Table element selected is: " + Data);
            }
        });
        JScrollPane sp=new JScrollPane(jTable);
        bottomBPanel.add(sp);
    }

    private void updateTable(String date){
        if(type == 1){
            column2 = new String[]{"DishID","Dish Name","Price(£)", "Ingredients Cost per Dish(£)", "Profit per Dish(£)", "Quantity Sold", "Total Profit(£)"};
        } else if (type == 2) {
            column2 = new String[]{"StaffID", "Staff Name", "Staff Role", "Days per Week", "Hours per Week", "Hours per Shift", "Hours Completed", "On Holiday (Yes/No)", "Holidays Accrued"};
        } else if (type == 3) {
            column2 = new String[]{"Ingredient Name", "Quantity"};
        }
        jTable =new JTable(dataMap.get(date), column2);
        jTable.setCellSelectionEnabled(true);
        ListSelectionModel select= jTable.getSelectionModel();
        select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        select.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                String Data = null;
                int[] row = jTable.getSelectedRows();
                int[] columns = jTable.getSelectedColumns();
                for (int i = 0; i < row.length; i++) {
                    for (int j = 0; j < columns.length; j++) {
                        Data = (String) jTable.getValueAt(row[i], columns[j]);
                    } }
                System.out.println("Table element selected is: " + Data);
            }
        });
        jScrollPane =new JScrollPane(jTable);
        bottomBPanel.remove(0);
        bottomBPanel.add(jScrollPane);
        bottomBPanel.revalidate();
    }

    public void actionPerformed(ActionEvent ae)
    {
        String date;
        if(type == 1) {
            setTurnover("£28.43");
            setTablesBooked("15");
            setCovers("9");
        }
        if(ae.getSource().equals(searchTextField)){
            date = searchTextField.getText();
            if(date.length() > 0){
                updateTable(date);
            }
        } else if (ae.getSource().equals(dateComboBox)) {
            date = (String) dateComboBox.getSelectedItem();
            updateTable(date);
        }
    }

    public void setTurnover(String turnover){
        turnoverJLabel.setText("Turnover: " + turnover);
    }

    public void setTablesBooked(String tablesBooked){
        tablesBookedJLabel.setText("Tables booked: " + tablesBooked);
    }

    public void setCovers(String covers){
        coversJLabel.setText("Covers: " + covers);
    }
}