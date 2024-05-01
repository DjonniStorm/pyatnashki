import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.metal.MetalBorders;
import java.awt.*;
import java.util.ArrayList;

public class startPanel {
    private JPanel startPanel;
    private ArrayList<JButton> buttonsList;
    public startPanel() {
        startPanel = new JPanel();
        buttonsList = new ArrayList<>();
        startPanel.setBackground(Color.ORANGE);
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


        buttonsList.add(buttonStart);
        buttonsList.add(buttonClose);
        buttonsList.add(buttonOptions);
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
    }
}
