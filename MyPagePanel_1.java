import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MyPagePanel_1 extends JPanel implements ActionListener {
    private Main win;
    private DeviceDisplay deviceDisplay;
    private List<Device> devices;
    private JButton confirmed, renting, backBtn;

    public MyPagePanel_1(String userName, Main win) {
        this.win = win;
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // 상단 패널
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
        welcomeLabel.setBorder(new EmptyBorder(-6, 0, 0, 15));
        topPanel.add(welcomeLabel, BorderLayout.EAST);
        add(topPanel, BorderLayout.NORTH);

        // 중앙 패널
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();

        Color onColor = new Color(184, 207, 229);
        Color offColor = new Color(0, 48, 135);

        // 제목 라벨
        JLabel title = new JLabel("마이페이지");
        title.setFont(new Font("맑은 고딕", Font.BOLD, 35));
        SetupUI.setupGBC(gbc, 0, 0, 2, GridBagConstraints.CENTER);
        gbc.insets = new Insets(0, 0, 40, 0);
        centerPanel.add(title, gbc);

        // 수령 대기 버튼
        confirmed = SetupUI.createButton("수령 대기", onColor, 20, 175, 40, this);
        SetupUI.setupGBC(gbc, 0, 1, 1, GridBagConstraints.CENTER);
        centerPanel.add(confirmed, gbc);
        
        // 대여중 버튼
        renting = SetupUI.createButton("대여중", offColor, 20, 175, 40, this);
        SetupUI.setupGBC(gbc, 1, 1, 1, GridBagConstraints.CENTER);
        centerPanel.add(renting, gbc);
        
        // 기기 목록
        devices = new ArrayList<>();
        devices.add(new Device("samsung_tablet.jpeg", "타블렛", "Android", "Snapdragon 865", "8GB", "수령 대기"));
        devices.add(new Device("samsung_mobile.jpeg", "스마트폰", "iOS", "A14 Bionic", "6GB", "예약중"));
        devices.add(new Device("samsung_laptop.png", "노트북", "Windows 10", "Intel i7", "16GB", "예약중"));

        // 기기 목록 패널
        Font infoFont = new Font("맑은 고딕", Font.PLAIN, 16);
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        for (int i = 0; i < devices.size(); i++) {
            Device device = devices.get(i);

            // 이미지 설정
            ImageIcon originalIcon = new ImageIcon(getClass().getResource(device.getImagePath()));
            Image scaledImage = originalIcon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
            JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));

            // 기기 정보 패널 설정
            JPanel infoPanel = new JPanel();
            infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
            infoPanel.setOpaque(false);

            JLabel nameLabel = new JLabel();
            nameLabel.setFont(infoFont);
            infoPanel.add(nameLabel);

            JLabel osLabel = new JLabel();
            osLabel.setFont(infoFont);
            infoPanel.add(osLabel);

            JLabel cpuLabel = new JLabel();
            cpuLabel.setFont(infoFont);
            infoPanel.add(cpuLabel);

            JLabel ramLabel = new JLabel();
            ramLabel.setFont(infoFont);
            infoPanel.add(ramLabel);

            JLabel statusLabel = new JLabel();
            statusLabel.setFont(infoFont);
            infoPanel.add(statusLabel);

            // 각 기기를 새 행에 배치
            gbc.gridx = 0; // 첫 번째 열
            gbc.gridy = i + 2; // 행은 제목 및 버튼 아래 시작
            centerPanel.add(imageLabel, gbc);

            gbc.gridx = 1; // 두 번째 열
            centerPanel.add(infoPanel, gbc);

            this.deviceDisplay = new DeviceDisplay(nameLabel, osLabel, cpuLabel, ramLabel, statusLabel);
            this.showDeviceDetails(this.deviceDisplay, (Device)this.devices.get(i));
        }

        add(centerPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backBtn) {
            win.change("대여/문의 선택 화면으로");
        }
        else if (e.getSource() == renting) {
            win.change("마이페이지 대여중 화면으로");
        }
    }

    private void showDeviceDetails(DeviceDisplay deviceDisplay, Device device) {
        deviceDisplay.displayDevice(device);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.getStackTrace();
        }
    }
}