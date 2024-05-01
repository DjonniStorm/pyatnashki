import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class pyatnashkiForm extends JFrame {
    private JFrame frame;
    private JLabel backgroundLabel;
    private JPanel pictureBox;
    private gamePanel gamePanel;
    private startPanel startPanel;
    public pyatnashkiForm() {
        frame = new JFrame("Пятнашки");

        ImageIcon icon = new ImageIcon("Source//backgroundImage.png");
        backgroundLabel = new JLabel(icon);
        backgroundLabel.setSize(1000, 600);
        pictureBox = new JPanel();
        frame.pack();
        frame.setContentPane(pictureBox);
        pictureBox.add(backgroundLabel);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(1000, 600);
        frame.setLocationRelativeTo(null);

        try {frame.setIconImage(new ImageIcon(ImageIO.read(new File("Source//frameIcon1.png"))).getImage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        frameDecoration();
        frame.setVisible(true);
    }
    private void frameDecoration() {
        startPanel = new startPanel();
        backgroundLabel.add(startPanel.getStartPanel());
    }
}
