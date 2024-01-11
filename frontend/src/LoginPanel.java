import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LoginPanel extends JPanel implements ActionListener {
    private Main win;
    private JButton loginBtn, signupBtn;
    private JTextField idField;

    public LoginPanel(Main win) {
        this.win = win;
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        setBackground(new Color(255, 255, 255));

        Color customColor = new Color(0, 48, 135);

        // 타이틀
        JLabel title = new JLabel("IT공학과 기기 대여 시스템");
        title.setFont(new Font("맑은 고딕", Font.BOLD, 35));
        SetupUI.setupGBC(gbc, 0, 0, 3, GridBagConstraints.CENTER);
        add(title, gbc);

        // 눈송이 이미지
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/images/snow_login.png"));
        JLabel imageLabel = new JLabel(imageIcon);
        SetupUI.setupGBC(gbc, 0, 1, 3, GridBagConstraints.CENTER);
        add(imageLabel, gbc);

        // 학번 라벨
        JLabel idFieldLabel = new JLabel("학번");
        idFieldLabel.setFont(new Font("맑은 고딕", Font.BOLD, 17));
        SetupUI.setupGBC(gbc, 0, 2, 1, GridBagConstraints.CENTER);
        add(idFieldLabel, gbc);

        // 학번 필드
        idField = new JTextField();
        idField.setPreferredSize(new Dimension(350, 45));
        SetupUI.setupGBC(gbc, 1, 2, 1, GridBagConstraints.BOTH);
        add(idField, gbc);

        // 로그인 버튼
        loginBtn = new JButton("로그인");
        SetupUI.setupButton(loginBtn, gbc, 0, 3, customColor, this);
        add(loginBtn, gbc);

        // 회원가입 버튼
        signupBtn = new JButton("회원가입");
        SetupUI.setupButton(signupBtn, gbc, 0, 4, customColor, this);
        add(signupBtn, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginBtn) {
            win.change("대여/문의 선택 화면으로");
        } else if (e.getSource() == signupBtn) {
            win.change("회원가입 화면으로");
        }
    }
}
