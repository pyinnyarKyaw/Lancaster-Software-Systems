import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class BarChart extends JPanel {

    private double[] values;
    private String[] labels;
    private Color[] colors;

    public BarChart(double[] values, String[] labels, Color[] colors) {
        this.values = values;
        this.labels = labels;
        this.colors = colors;
    }

    @Override
    protected void paintComponent(Graphics g) {
        // Code generated by ChatGPT
        // PROMPT: "could you write me code that displays a bar chart like the pie chart one you created earlier"
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int width = getWidth();
        int height = getHeight();
        int barSpacing = 10;
        int barWidth = (width - (values.length - 1) * barSpacing) / values.length;

        double maxValue = Double.MIN_VALUE;
        for (double value : values) {
            if (value > maxValue) {
                maxValue = value;
            }
        }

        double unitHeight = height / maxValue;

        int x = 0;
        for (int i = 0; i < values.length; i++) {
            int barHeight = (int) (values[i] * unitHeight);
            g2d.setColor(colors[i]);
            g2d.fillRect(x, height - barHeight, barWidth, barHeight);
            g2d.setColor(Color.BLACK);
            g2d.drawString(labels[i], x + barWidth / 2 - g2d.getFontMetrics().stringWidth(labels[i]) / 2, height - 5);
            x += barWidth + barSpacing;
        }
    }
}
