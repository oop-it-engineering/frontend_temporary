public class Device {
    private String imagePath;
    private String name;
    private String os;
    private String cpu;
    private String ram;
    private String status;

    public Device(String imagePath, String name, String os, String cpu, String ram, String status) {
        this.imagePath = "/images/" + imagePath;  // 수정
        this.name = name;
        this.os = os;
        this.cpu = cpu;
        this.ram = ram;
        this.status = status;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getDevname() {
        return name;
    }

    public String getOs() {
        return os;
    }

    public String getCpu() {
        return cpu;
    }

    public String getRam() {
        return ram;
    }

    public String getStatus() {
        return status;
    }
}