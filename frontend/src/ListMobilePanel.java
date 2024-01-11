import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListMobilePanel extends JPanel implements ActionListener {
    private Main win;
    private JList<String> mobileList;
    private JButton selectBtn, backBtn;

    public ListMobilePanel(String userName, Main win) {
        this.win = win;
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // 탑 패널
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(Color.WHITE);

        // 버튼 패널
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.setOpaque(false);

        // 뒤로 가기 버튼
        ImageIcon backIcon = new ImageIcon(getClass().getResource("/images/back.png"));
        Image backIconScaled = backIcon.getImage().getScaledInstance(48, 38, Image.SCALE_SMOOTH);
        backBtn = new JButton(new ImageIcon(backIconScaled));
        backBtn.addActionListener(this);
        backBtn.setBorderPainted(false);
        backBtn.setContentAreaFilled(false);
        backBtn.setMargin(new Insets(10, 10, 0, 0));
        buttonPanel.add(backBtn);
        topPanel.add(buttonPanel, BorderLayout.WEST);

        // 눈송이님, 환영합니다!
        JLabel welcomeLabel = new JLabel(userName + "님, 환영합니다!", SwingConstants.RIGHT);
        welcomeLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
        welcomeLabel.setBorder(new EmptyBorder(-4, 0, 0, 15));
        topPanel.add(welcomeLabel, BorderLayout.EAST);
        add(topPanel, BorderLayout.NORTH);

        // 중앙 패널
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Color customColor = new Color(0, 48, 135);

        // 제목 라벨
        JLabel title = new JLabel("모바일 기기");
        title.setFont(new Font("맑은 고딕", Font.BOLD, 35));
        SetupUI.setupGBC(gbc, 0, 0, 3, GridBagConstraints.CENTER);
        gbc.insets = new Insets(0, 0, 20, 0);
        centerPanel.add(title, gbc);

        // 모바일 기기 리스트
        String[] mobiles = {"갤럭시 s23", "아이폰 15"};
        mobileList = new JList<>(mobiles);
        mobileList.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
        JScrollPane scrollPane = new JScrollPane(mobileList);
        scrollPane.setPreferredSize(new Dimension(400, 100));
        SetupUI.setupGBC(gbc, 0, 1, 2, GridBagConstraints.CENTER);
        centerPanel.add(scrollPane, gbc);

        // 선택 버튼
        selectBtn = SetupUI.createButton("선택", customColor, 20, 400, 70, this);
        SetupUI.setupGBC(gbc, 0, 2, 2, GridBagConstraints.CENTER);
        centerPanel.add(selectBtn, gbc);

        add(centerPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == selectBtn) {
            String selectedmobile = mobileList.getSelectedValue();
            if ("갤럭시 s23".equals(selectedmobile)) {
                win.change("모바일");
            } else if ("아이폰 15".equals(selectedmobile)) {
                win.change("모바일2");
            }
        } else if (e.getSource() == backBtn) {
            win.change("기기 선택 화면으로");
        }
    }
}