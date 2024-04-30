import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.metal.MetalBorders;
import java.awt.*;

public class startPanel {
    private JPanel startPanel;
    public startPanel() {
        startPanel = new JPanel();
        startPanel.setBackground(Color.ORANGE);
        startPanel.setSize(600, 600);
        startPanel.setPreferredSize(new Dimension(600, 552));
        //startPanel.setLayout();
        startPanel.setLayout(new BoxLayout(this.getStartPanel(), BoxLayout.Y_AXIS));
        decorateStartPanel(new Dimension(300, 80));
    }
    public JPanel getStartPanel() {
        return startPanel;
    }
    private void decorateStartPanel(Dimension dimension) {
        JButton buttonStart     = new JButton("Начать");
        JButton buttonOptions   = new JButton("Настройки");
        JButton buttonClose     = new JButton("Выйти");
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

        buttonStart.setBorder(new MetalBorders.MenuBarBorder());
        buttonClose.setBorder(new MetalBorders.MenuBarBorder());

        Font font = new Font("Times New Roman", Font.BOLD, 40);
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
