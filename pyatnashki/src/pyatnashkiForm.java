import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;

public class pyatnashkiForm extends JFrame {
    private JFrame frame;
    private JPanel pictureBox;
    public pyatnashkiForm() {
        frame = new JFrame("Пятнашки");
        pictureBox = new JPanel();
        frame.pack();
        frame.setContentPane(pictureBox);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(1000, 600);
        frame.setLocation(250, 100);
        pictureBox.setBackground(Color.BLUE);
        try {frame.setIconImage(new ImageIcon(ImageIO.read(new File("Source//frameIcon1.png"))).getImage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
