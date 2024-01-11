import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignupPanel extends JPanel implements ActionListener {
    private Main win;
    private JButton signinBtn, backBtn;
    private JTextField nameField, idField;

    public SignupPanel(Main win) {
        this.win = win;
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        setBackground(new Color(255, 255, 255));

        Color customColor = new Color(0, 48, 135);

        // 타이틀
        JLabel title = new JLabel("회원가입");
        title.setFont(new Font("맑은 고딕", Font.BOLD, 35));
        SetupUI.setupGBC(gbc, 0, 0, 3, GridBagConstraints.CENTER);
        add(title, gbc);

        // 눈송이 이미지
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/images/snow_signup.png"));
        JLabel imageLabel = new JLabel(imageIcon);
        SetupUI.setupGBC(gbc, 0, 1, 3, GridBagConstraints.CENTER);
        add(imageLabel, gbc);

        // 학번 라벨
        JLabel idLabel = new JLabel("학번");
        idLabel.setFont(new Font("맑은 고딕", Font.BOLD, 17));
        SetupUI.setupGBC(gbc, 0, 2, 1, GridBagConstraints.CENTER);
        add(idLabel, gbc);

        // 학번 필드
        idField = new JTextField();
        idField.setPreferredSize(new Dimension(350, 45));
        SetupUI.setupGBC(gbc, 1, 2, 1, GridBagConstraints.BOTH);
        add(idField, gbc);

        // 이름 라벨
        JLabel nameLabel = new JLabel("이름");
        nameLabel.setFont(new Font("맑은 고딕", Font.BOLD, 17));
        SetupUI.setupGBC(gbc, 0, 3, 1, GridBagConstraints.CENTER);
        add(nameLabel, gbc);

        // 이름 필드
        nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(350, 45));
        SetupUI.setupGBC(gbc, 1, 3, 1, GridBagConstraints.BOTH);
        add(nameField, gbc);

        // 완료 버튼
        signinBtn = new JButton("완료");
        SetupUI.setupButton(signinBtn, gbc, 0, 4, customColor, this);
        add(signinBtn, gbc);

        // 뒤로가기 버튼
        ImageIcon backIcon = new ImageIcon(getClass().getResource("/images/mypage.png"));
        backBtn = new JButton(backIcon);
        backBtn.setPreferredSize(new Dimension(20, 20));
        backBtn.addActionListener(this);
        SetupUI.setupGBC(gbc, 0, 0, 1, GridBagConstraints.NORTHWEST);
        gbc.insets = new Insets(0, 0, 0, 0);
        add(backBtn, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backBtn) {
            win.change("로그인 화면으로");
        } else if (e.getSource() == signinBtn) {
            Dialog.showDialog(win, "알림", "회원가입이 완료되었습니다!");
            win.change("로그인 화면으로");
        }
    }
}
