import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel {
    private Image image;
    ImagePanel(String pathToBackground){
        image = new ImageIcon(pathToBackground).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
    }
}
