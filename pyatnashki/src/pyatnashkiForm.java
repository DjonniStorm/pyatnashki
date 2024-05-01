import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

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
        frame.setSize(1000, 640);
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
                    UIManager.put("OptionPane.yesButtonText"   , "Да" );
                    UIManager.put("OptionPane.noButtonText"   , "Нет" );
                    int n = JOptionPane.showConfirmDialog(
                            frame,
                            "Вы уверены, что хотите выйти?",
                            "Не уходите",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
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
                    backgroundLabel.remove(startPanel);
                    frame.repaint();
                    gamePanel panel = new gamePanel();
                    backgroundLabel.add(panel.getGamePanel());
                }
            });
            buttonOptions.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    backgroundLabel.remove(startPanel);
                    frame.repaint();
                    optionPanel panel = new optionPanel();
                    backgroundLabel.add(panel.getOptionPanel());
                }
            });
        }
    }
    class gamePanel {
        private ArrayList<JButton> buttons;
        private int[][] buttonsVariants;
        private JPanel gamePanel;
        public gamePanel() {

            gamePanel = new JPanel();
            gamePanel.setSize(new Dimension(600, 600));
            gamePanel.setBackground(Color.BLUE);
            gamePanel.setLayout(new GridLayout(4, 4));
            buttons = new ArrayList<>();
            buttonsVariants = new int[4][4];
            init();
            gamePanel.setDoubleBuffered(true);
            gamePanel.setBackground(Color.white);
            repaintField();
            KeyboardFocusManager.getCurrentKeyboardFocusManager()
                    .addKeyEventDispatcher(new KeyEventDispatcher() {
                        @Override
                        public boolean dispatchKeyEvent(KeyEvent e) {
                            System.out.println(e.getKeyCode());
                            if (e.getKeyCode() == 27) {
                                backgroundLabel.remove(gamePanel);
                                frame.repaint();
                                backgroundLabel.add(startPanel.getStartPanel());
                            }
                            if (e.getKeyCode() == 72) {
                                init();
                                repaintField();
                            }
                            if (e.getKeyCode() == 83) {
                                try {
                                    Desktop.getDesktop().browse(new java.net.URI("https://www.youtube.com/watch?v=dQw4w9WgXcQ"));
                                } catch (IOException | URISyntaxException ex) {
                                    throw new RuntimeException(ex);
                                }
                            }
                            return false;
                        }
                    });
        }

        public JPanel getGamePanel() {
            return gamePanel;
        }

        private void init() {
            Random random = new Random();
            int[] invariants = new int[16]; // инициализируем массив с именем invariants из 16 элементов - лт 0 до 15

            for (int i = 0; i < 4; i++) { // перебираем элементы i от 0 до 3
                for (int j = 0; j < 4; j++) { // перебираем элементы j от 0 до 3
                    buttonsVariants[i][j] = 0; // указываем что перебор в цикле начинается с нулевого элемента
                    invariants[i*4 + j] = 0; // определяем какой из 16 элементов будет = 0
                }
            }

            for (int i = 1; i < 16; i++) { // перебираем елементы i от 1 до 15
                int k; //обьявляем переменную k типа int
                int l; //обьявляем переменную l типа int
                do { // цикл с послеусловием
                    k = random.nextInt(100) % 4; // переменной k присваиваем произвольное число от 0 до 100 деленное по модулю на 4
                    l = random.nextInt(100) % 4; // переменной l присваиваем произвольное число от 0 до 100 деленное по модулю на 4
                }
                while (buttonsVariants[k][l] != 0); // до тех пор пока двумерный массив numbers не равен 0
                buttonsVariants[k][l] = i; // присваиваем двумерному массиву numbers значение i в цикле от 1 до 15
                invariants[k*4+l] = i; // определяем позиции всех елементов кроме 0 на сетке
            }

            boolean change = true; // в булевую переменную change заносим значение true
            while (change) {
                change = false;
                for (int i = 0; i < 16; i++) {
                    if (invariants[i] != i) {
                        for (int j = 0; j < 16; j++) {
                            if (invariants[j] == i) {
                                int temp = invariants[i];
                                invariants[i] = invariants[j];
                                invariants[j] = temp;
                                change = true;
                                break;
                            }
                        }
                        break;
                    }
                }
            }
        }
        public void repaintField() {  //метод расстановки кнопок со значениями на сетке
            gamePanel.removeAll();

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    JButton button = new JButton(Integer.toString(buttonsVariants[i][j]));
                    button.setFocusable(false);
                    button.setBounds(j * 150, i * 150, 150, 150);
                    buttons.add(button);
                    gamePanel.add(button);
                    button.setBackground(Color.getHSBColor(0.1059322f, 0.5221239f, 0.8862745f)); // устанавливаем цвет кнопок
                    if (buttonsVariants[i][j] == 0) {
                        button.setVisible(false); // сокрытие нулевого элемента массива
                    } else
                        button.addActionListener(new ClickListener());
                }
            }
            gamePanel.validate();
        }
        public boolean checkWin() { //метод проверки победы
            boolean status = true;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (i == 3 && j > 2) //проверка на то, что последняя ячейка в сетке пустая
                        break;
                    if (buttonsVariants[i][j] != i * 4 + j + 1) { //проверка на соотвествие элементам массива координатам в сетке
                        status = false;
                    }
                }
            }
            return status;
        }
        private class ClickListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton) e.getSource();
                button.setVisible(false);
                String name = button.getText();
                change(Integer.parseInt(name));
            }
        }

        public void change(int num) { // передаем в качестве входящих параметров метода change переменную num типа int
            int i = 0, j = 0; // присваиваем переменным i и j типа int значение равное 0
            for (int k = 0; k < 4; k++) { // перебираем элементы k от 0 до 3
                for (int l = 0; l < 4; l++) { // перебираем элементы l от 0 до 3
                    if (buttonsVariants[k][l] == num) { // если массив numbers[k][l] равен переменной num то,
                        i = k; // переменную i приравниваем переменной k
                        j = l; // переменную j приравниваем переменной l
                    }
                }
            }

            /*реализация логики сдвигов кнопок на сетке 4 Х 4*/
            //сдвиг вверх по строкам
            if (i > 0) { // условие отвечающее за то можно ли сдвинуть кнопку по строке
                if (buttonsVariants[i - 1][j] == 0) { //сравниваем значение координат элемента массива с кнопкой которая в текущем массиве равна нулю
                    buttonsVariants[i - 1][j] = num; //присваиваем переменной num значение координат элемента массива
                    buttonsVariants[i][j] = 0; //присваиваем нулевой элемент массива в ячейку которая перед этим смещалась в ноль
                }
            }
            //сдвиг вниз по строкам
            if (i < 3) {
                if (buttonsVariants[i + 1][j] == 0) {
                    buttonsVariants[i + 1][j] = num;
                    buttonsVariants[i][j] = 0;
                }
            }
            //сдвиг влево по столбцам
            if (j > 0) {
                if (buttonsVariants[i][j - 1] == 0) {
                    buttonsVariants[i][j - 1] = num;
                    buttonsVariants[i][j] = 0;
                }
            }
            //сдвиг вправо по столбцам
            if (j < 3) {
                if (buttonsVariants[i][j + 1] == 0) {
                    buttonsVariants[i][j + 1] = num;
                    buttonsVariants[i][j] = 0;
                }
            }
            repaintField();
            if (checkWin()) {
                UIManager.put("OptionPane.yesButtonText"   , "Да" );
                UIManager.put("OptionPane.noButtonText"   , "Нет" );
                JOptionPane.showMessageDialog(null, "ВЫ ВЫИГРАЛИ!", "Поздравляем", 1);
                init();
                repaintField();
                setVisible(false);
                setVisible(true);
            }
        }
    }
    class optionPanel {
        private JPanel optionPanel;
        public optionPanel() {
            optionPanel = new JPanel();
            optionPanel.setBackground(new Color(228, 203, 138));
            optionPanel.setSize(frame.getWidth() / 2, frame.getHeight() - 100);

        }
        public JPanel getOptionPanel() {
            return optionPanel;
        }
    }
}
