import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.*;

public class DeviceDisplay {

    private JLabel nameLabel;
    private JLabel osLabel;
    private JLabel cpuLabel;
    private JLabel ramLabel;
    private JLabel statusLabel;

    public DeviceDisplay(JLabel nameLabel, JLabel osLabel, JLabel cpuLabel, JLabel ramLabel, JLabel statusLabel) {
        this.nameLabel = nameLabel;
        this.osLabel = osLabel;
        this.cpuLabel = cpuLabel;
        this.ramLabel = ramLabel;
        this.statusLabel = statusLabel;
    }

    public void displayDevice(Device device) {
        nameLabel.setText("기기 이름: " + device.getDevname());
        osLabel.setText("OS: " + device.getOs());
        cpuLabel.setText("CPU: " + device.getCpu());
        ramLabel.setText("RAM: " + device.getRam());
        statusLabel.setText("상태: " + device.getStatus());
    }
}
