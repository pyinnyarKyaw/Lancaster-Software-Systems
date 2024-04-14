import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ReportsScreen extends JPanel implements ActionListener
{
    private MainFrame mainFrame;

    private JPanel topPanel, bottomPanel, botTPanel, botTLeftPanel, botTRightPanel, botBPanel, botBLeftPanel, botBRightPanel;
    private JLabel label;

    private PieChart pieChart;

    private PieChart pieChart2;

    private BarChart barChart;
    private HeatMap heatMap;
    ReportsScreen(MainFrame mainFrame)
    {
        this.mainFrame = mainFrame;

        this.setLayout(new BorderLayout());
        setBackground(new Color(29, 29, 38));

        topPanel = new JPanel(new FlowLayout());

        bottomPanel = new JPanel(new GridLayout(2, 1));

        botTPanel = new JPanel(new GridLayout(1, 2));

        botTLeftPanel = new JPanel(new BorderLayout());

        botTRightPanel = new JPanel(new BorderLayout());

        botBPanel = new JPanel(new GridLayout(1, 2));

        botBLeftPanel = new JPanel(new BorderLayout());

        botBRightPanel = new JPanel(new BorderLayout());

        label = new JLabel();
        label.setText("Reports Screen");

        topPanel.add(label);

        createPieCharts();
        createBarChart();
        createHeatMap();

        pieChart.setBackground(new Color(29, 29, 38));
        pieChart2.setBackground(new Color(29, 29, 38));
        barChart.setBackground(new Color(29, 29, 38));
        heatMap.setBackground(new Color(29, 29, 38));

        botTPanel.add(botTLeftPanel);
        botTPanel.add(botTRightPanel);

        botBPanel.add(botBLeftPanel);
        botBPanel.add(botBRightPanel);

        bottomPanel.add(botTPanel);
        bottomPanel.add(botBPanel);

        this.add(topPanel, BorderLayout.NORTH);
        this.add(bottomPanel, BorderLayout.CENTER);
    }

    public void createPieCharts(){
        double[] values = {30, 20, 50};
        double[] values2 = {80, 15, 5};
        String[] labels = {"A", "B", "C"};
        Color[] colours = {new Color(115, 0, 255), new Color(212, 0, 255), new Color(51, 0, 255)};
        pieChart = new PieChart(values, labels, colours);
        pieChart2 = new PieChart(values, labels, colours);;

        botTLeftPanel.add(pieChart);
        botTRightPanel.add(pieChart2);
    }

    public void createBarChart(){
        double[] values = {30, 20, 50};
        String[] labels = {"A", "B", "C"};
        Color[] colours = {new Color(115, 0, 255), new Color(212, 0, 255), new Color(51, 0, 255)};
        barChart = new BarChart(values, labels, colours);

        botTLeftPanel.add(barChart);
    }

    public void createHeatMap(){
        int[][] data2023 = new int[7][52];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 52; j++) {
                if (j % 7 == 5 || j % 7 == 6) {
                    data2023[i][j] = (int) (Math.random() * 10) + 45;
                } else {
                    data2023[i][j] = (int) (Math.random() * 51);
                }
            }
        }

        heatMap = new HeatMap(data2023);

        botBRightPanel.add(heatMap);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}