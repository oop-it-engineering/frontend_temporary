import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SetupUI {
    public static void setupGBC(GridBagConstraints gbc, int x, int y, int width, int fill) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = width;
        gbc.fill = fill;
        gbc.insets = new Insets(12, 10, 12, 10);
    }

    public static void setupButton(JButton button, GridBagConstraints gbc, int x, int y, Color color, ActionListener listener) {
        button.setFont(new Font("맑은 고딕", Font.BOLD, 17));
        button.setPreferredSize(new Dimension(350, 50));
        button.setForeground(Color.WHITE);
        button.setBackground(color);
        button.addActionListener(listener);
        setupGBC(gbc, x, y, 2, GridBagConstraints.BOTH);
    }
}