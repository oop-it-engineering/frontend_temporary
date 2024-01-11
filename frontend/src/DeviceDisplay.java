import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.*;

public class DeviceDisplay {

    private JLabel imageLabel;
    private JLabel devnameLabel;
    private JLabel osLabel;
    private JLabel cpuLabel;
    private JLabel ramLabel;
    private JLabel statusLabel;

    public DeviceDisplay(JLabel imageLabel, JLabel devnameLabel, JLabel osLabel, JLabel cpuLabel, JLabel ramLabel, JLabel statusLabel) {
        this.imageLabel = imageLabel;
        this.devnameLabel = devnameLabel;
        this.osLabel = osLabel;
        this.cpuLabel = cpuLabel;
        this.ramLabel = ramLabel;
        this.statusLabel = statusLabel;
    }

    public void displayDevice(Device device) {
        ImageIcon iconOriginal = new ImageIcon(device.getImagePath());
        Image imageScaled = iconOriginal.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon iconScaled = new ImageIcon(imageScaled);
        imageLabel.setIcon(iconScaled);

        devnameLabel.setText("기기 이름: " + device.getDevname());
        osLabel.setText("OS: " + device.getOs());
        cpuLabel.setText("CPU: " + device.getCpu());
        ramLabel.setText("RAM: " + device.getRam());
        statusLabel.setText("상태: " + device.getStatus());
    }
}
