import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class pyatnashkiForm extends JFrame {
    private JFrame frame;
    private JPanel pictureBox;
    private gamePanel gamePanel;
    private startPanel startPanel;
    public pyatnashkiForm() {
        frame = new JFrame("Пятнашки");
        pictureBox = new JPanel();
        frame.pack();
        frame.setContentPane(pictureBox);
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
        pictureBox.setBackground(Color.BLUE);
        startPanel = new startPanel();
        pictureBox.add(startPanel.getStartPanel());
    }
}
