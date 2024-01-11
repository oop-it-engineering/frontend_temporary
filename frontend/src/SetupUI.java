import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SetupUI {
    // GridBagConstraints 설정 메서드
    public static void setupGBC(GridBagConstraints gbc, int x, int y, int width, int fill) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = width;
        gbc.fill = fill;
        gbc.insets = new Insets(12, 10, 12, 10);
    }

    // 스타일 적용된 버튼 생성 메서드
    public static JButton createButton(String text, Color color, int width, int height, ActionListener listener) {
        JButton button = new JButton(text);
        button.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        button.setPreferredSize(new Dimension(width, height));
        button.setForeground(Color.WHITE);
        button.setBackground(color);
        button.addActionListener(listener);
        return button;
    }
}
