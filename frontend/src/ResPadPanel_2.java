import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class ResPadPanel_2 extends JPanel implements ActionListener {

    private Main win;
    private JLabel remainingDeviceLabel;
    private JLabel dateLabel;
    private HintTextField dateTextField;
    private JButton backButton, homeButton;

    public ResPadPanel_2(String userName, Main win) {
        this.win = win;
        setLayout(new BorderLayout(10, 10));
        setBackground(Color.WHITE);

        // topPanel: 백 버튼, 제목, 눈송이님 포함
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBorder(new EmptyBorder(10, 20, 10, 20));
        topPanel.setBackground(new Color(210, 86, 106)); // 핑크색 배경

        // 버튼 패널 (왼쪽애 백과 홈 모두 두기 위해)
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.setOpaque(false);

        // backbutton
        ImageIcon backIconOriginal = new ImageIcon(getClass().getResource("/images/back.png"));
        Image backImageScaled = backIconOriginal.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon backIconScaled = new ImageIcon(backImageScaled);
        backButton = new JButton(backIconScaled);
        backButton.addActionListener(this);
        buttonPanel.add(backButton);

        // homebutton
        ImageIcon homeIconOriginal = new ImageIcon(getClass().getResource("/images/home.png"));
        Image homeImageScaled = homeIconOriginal.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon homeIconScaled = new ImageIcon(homeImageScaled);
        homeButton = new JButton(homeIconScaled);
        homeButton.addActionListener(this);
        buttonPanel.add(homeButton);

        topPanel.add(buttonPanel, BorderLayout.WEST);

        // 가운데 제목 라벨
        JLabel titleLabel = new JLabel("예약 페이지", SwingConstants.CENTER);
        titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 25));
        titleLabel.setForeground(Color.WHITE);
        topPanel.add(titleLabel, BorderLayout.CENTER);

        // 눈송이님, 환영합니다!
        JLabel welcomeLabel = new JLabel(userName + "님, 환영합니다!", SwingConstants.RIGHT);
        welcomeLabel.setForeground(Color.WHITE);
        topPanel.add(welcomeLabel, BorderLayout.EAST);
        add(topPanel, BorderLayout.NORTH);

        // centerPanel
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBorder(new EmptyBorder(10, 20, 10, 20));
        centerPanel.setBackground(Color.WHITE);

        // 제목 라벨 추가
        JLabel deviceTitleLabel = new JLabel("갤럭시탭 s9");
        deviceTitleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        deviceTitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(deviceTitleLabel);

        // tablet icon + 크기고정
        ImageIcon tabletIconOriginal = new ImageIcon(getClass().getResource("/images/samsung_tablet.jpeg"));
        Image tabletImageScaled = tabletIconOriginal.getImage().getScaledInstance(400, 300, Image.SCALE_SMOOTH);
        ImageIcon tabletIconScaled = new ImageIcon(tabletImageScaled);
        JLabel tabletLabel = new JLabel(tabletIconScaled);
        tabletLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(Box.createVerticalStrut(20));
        centerPanel.add(tabletLabel);

        // 상세 사양 Panel
        JPanel infoPanel = createInfoPanel(tabletIconScaled.getIconWidth());
        centerPanel.add(Box.createVerticalStrut(20));
        centerPanel.add(infoPanel);

        // 예약 패널 생성
        JPanel reservationPanel = createReservationPanel(tabletIconScaled.getIconWidth());
        centerPanel.add(Box.createVerticalStrut(20));
        centerPanel.add(reservationPanel);

        add(centerPanel, BorderLayout.CENTER);

        // bottomPanel
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        bottomPanel.setBorder(new EmptyBorder(10, 20, 10, 20));
        bottomPanel.setBackground(Color.WHITE);

        // '규정 확인하기' -> 규정 확인 창으로 넘어가는 버튼
        JButton reserveButton = new JButton("예약하기");
        reserveButton.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        reserveButton.setPreferredSize(new Dimension(200, 50));
        styleButton(reserveButton, new Color(210, 86, 106));
        reserveButton.addActionListener(e -> showRulesDialog());
        bottomPanel.add(reserveButton);

        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    // 규정 확인하기 버튼 눌렀을 때 Rules Dialog 보여주는 메서드
    private void showRulesDialog() {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        RulesPanel dialog = new RulesPanel(frame);
        dialog.setVisible(true);
    }

    // styleButton
    private void styleButton(JButton button, Color color) {
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setForeground(Color.WHITE);
        button.setBackground(color);
        button.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        button.setOpaque(true);
    }

    // 상세 사양 패널 Detail
    private JPanel createInfoPanel(int width) {
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(4, 1, 0, 0));
        infoPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        infoPanel.setBackground(new Color(230, 244, 250));
        infoPanel.setMaximumSize(new Dimension(width, 120));

        JLabel infoTitleLabel = new JLabel("상세 사양", SwingConstants.CENTER);
        infoTitleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        infoTitleLabel.setFont(infoTitleLabel.getFont().deriveFont(Font.BOLD));
        infoPanel.add(infoTitleLabel);

        String[] specs = {"OS: Android", "Display: 10 inch", "Battery: 6000mAh"};
        for (String spec : specs) {
            JLabel label = new JLabel(spec, SwingConstants.CENTER);
            infoTitleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
            infoPanel.add(label);
        }
        return infoPanel;
    }

    // 예약 패널 생성
    private JPanel createReservationPanel(int width) {
        JPanel reservationPanel = new JPanel();
        reservationPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        reservationPanel.setBackground(new Color(255, 250, 205));
        reservationPanel.setMaximumSize(new Dimension(400, 70));

        dateLabel = new JLabel("대여 날짜 입력: ");
        dateLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        reservationPanel.add(dateLabel);

        dateTextField = new ResPadPanel_2.HintTextField("YYYY-MM-DD"); // 힌트 텍스트 설정
        dateTextField.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        reservationPanel.add(dateTextField);

        // 남은 기기 수량 라벨
        remainingDeviceLabel = new JLabel("남은 기기 수량: 10", SwingConstants.CENTER); // 예시 수량
        remainingDeviceLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
        reservationPanel.add(remainingDeviceLabel);

        return reservationPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            win.change("기기 선택 화면으로");
        } else if (e.getSource() == homeButton) {
            win.change("대여/문의 선택 화면으로");
        }
    }

    // HintTextField 클래스 정의 (hint text가 있는 JTextField)
    class HintTextField extends JTextField implements FocusListener {
        private String hint;

        public HintTextField(String hint) {
            this.hint = hint;
            addFocusListener(this);
            setText(hint);
            setForeground(Color.GRAY);
        }

        @Override
        public void focusGained(FocusEvent e) {
            if (getText().equals(hint)) {
                setText("");
                setForeground(Color.BLACK);
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            if (getText().isEmpty()) {
                setText(hint);
                setForeground(Color.GRAY);
            }
        }
    }

}
