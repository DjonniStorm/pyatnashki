import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static javax.swing.JOptionPane.YES_NO_OPTION;

public class pyatnashkiForm extends JFrame {
    private JFrame frame;
    private JLabel backgroundLabel;
    private JPanel pictureBox;
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
    public void closeFrame() {
        frame.dispose();
    }
    public JFrame getFrame() {
        return frame;
    }

    class startPanel {
        private JPanel startPanel;
        public startPanel() {
            startPanel = new JPanel();
            startPanel.setSize(600, 600);
            startPanel.setPreferredSize(new Dimension(600, 552));
            startPanel.setLayout(new BoxLayout(this.getStartPanel(), BoxLayout.Y_AXIS));
            decorateStartPanel(new Dimension(300, 80));
            startPanel.setOpaque(false);
        }
        public JPanel getStartPanel() {
            return startPanel;
        }
        private void decorateStartPanel(Dimension dimension) {
            JButton buttonStart     = new JButton("Начать");
            JButton buttonOptions   = new JButton("Настройки");
            JButton buttonClose     = new JButton("Выйти");

            buttonStart.setBorder(BorderFactory.createMatteBorder( 4, 4, 4, 4, new Color(0, 0, 0)));
            buttonClose.setBorder(BorderFactory.createMatteBorder( 4, 4, 4, 4, new Color(0, 0, 0)));
            buttonOptions.setBorder(BorderFactory.createMatteBorder( 4, 4, 4, 4, new Color(0, 0, 0)));

            buttonStart.setBackground(new Color(228, 203, 138));
            buttonClose.setBackground(new Color(228, 203, 138));
            buttonOptions.setBackground(new Color(228, 203, 138));

            buttonStart.setForeground(new Color(0, 0, 0));
            buttonClose.setForeground(new Color(0, 0, 0));
            buttonOptions.setForeground(new Color(0, 0, 0));



            buttonStart.setAlignmentX(Component.CENTER_ALIGNMENT);
            buttonOptions.setAlignmentX(Component.CENTER_ALIGNMENT);
            buttonClose.setAlignmentX(Component.CENTER_ALIGNMENT);
            buttonStart.setPreferredSize(dimension);
            buttonOptions.setPreferredSize(dimension);
            buttonClose.setPreferredSize(dimension);
            buttonStart.setMaximumSize(dimension);
            buttonOptions.setMaximumSize(dimension);
            buttonClose.setMaximumSize(dimension);
            buttonStart.setMinimumSize(dimension);
            buttonOptions.setMinimumSize(dimension);
            buttonClose.setMinimumSize(dimension);

            Font font = new Font("Cascadia Code SemiBold", Font.BOLD, 44);
            buttonStart.setFont(font);
            buttonOptions.setFont(font);
            buttonClose.setFont(font);

            startPanel.add(Box.createVerticalStrut(140));
            startPanel.add(buttonStart);
            startPanel.add(Box.createVerticalStrut(50));
            startPanel.add(buttonOptions);
            startPanel.add(Box.createVerticalStrut(50));
            startPanel.add(buttonClose);

            final Color col = buttonStart.getBackground();

            buttonStart.setFocusPainted(false);
            buttonClose.setFocusPainted(false);
            buttonOptions.setFocusPainted(false);

            buttonClose.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int n = JOptionPane.showConfirmDialog(
                            frame,
                            "Вы уверены, что хотите выйти?",
                            "Не уходите",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            new ImageIcon("Source//sad.png")
                    );
                    switch (n) {
                        case 0:
                            frame.dispose();
                            break;
                        case 1:
                            break;
                    }
                }
            });
            buttonStart.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.remove(backgroundLabel);
                    gamePanel panel = new gamePanel();
                    frame.add(panel.getGameLabel());
                    frame.repaint();
                }
            });
        }
    }
    class gamePanel {
        private JLabel backImg;
        private ArrayList<JButton> buttons;
        private JPanel gamePanel;
        public gamePanel() {

            backImg = new JLabel();
            backImg.setSize(new Dimension(frame.getWidth(), frame.getHeight()));

            gamePanel = new JPanel();
            gamePanel.setSize(new Dimension(frame.getWidth() / 2, frame.getHeight() / 5 * 4));
            gamePanel.setBackground(Color.BLUE);
            backImg.add(gamePanel);

            buttons = new ArrayList<>();
            MakeButtons(4);


        }

        public JLabel getGameLabel() {
            return backImg;
        }
        private void MakeButtons(int numberOfElements) { //делаем кнопочки
            for (int i = 1; i < (int)Math.pow(numberOfElements, 2); i++) { //ну а что, перемножать их чтоле?
                JButton button = new JButton(Integer.toString(i));
                button.setMinimumSize(new Dimension(100, 100));
                button.setMaximumSize(new Dimension(100, 100));
                button.setPreferredSize(new Dimension(100, 100));
                buttons.add(button);
                gamePanel.add(button);
            }
        }
    }

}
