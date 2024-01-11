import javax.swing.*;

public class Main extends JFrame {
    public LoginPanel loginPanel = null;
    public SignupPanel signupPanel = null;
    public SelectServicePanel selectServicePanel = null;
    public SelectEquipPanel selectEquipPanel = null;
    public ListLaptopPanel listLaptopPanel = null;
    public ListPadPanel listPadPanel = null;
    public ListMobilePanel listMobilePanel = null;
    public ListOtherPanel listOtherPanel = null;
    public MyPagePanel_1 myPagePanel1 = null;
    public MyPagePanel_2 myPagePanel2 = null;
    public ResLaptopPanel_1 resLaptopPanel1 = null;
    public ResLaptopPanel_2 resLaptopPanel2 = null;
    public ResMobilePanel_1 resMobilePanel1 = null;
    public ResMobilePanel_2 resMobilePanel2 = null;
    public ResOtherPanel resOtherPanel= null;
    public ResPadPanel_1 resPadPanel1= null;
    public ResPadPanel_2 resPadPanel2= null;



    public void change(String panelName) {
        getContentPane().removeAll();

        if (panelName.equals("로그인 화면으로")) {
            getContentPane().add(loginPanel);
        }
        else if (panelName.equals("회원가입 화면으로")) {
            getContentPane().add(signupPanel);
        }
        else if (panelName.equals("대여/문의 선택 화면으로")) {
            getContentPane().add(selectServicePanel);
        }
        else if (panelName.equals("장비 선택 화면으로")) {
            getContentPane().add(selectEquipPanel);
        }
        else if (panelName.equals("랩탑 선택 화면으로")) {
            getContentPane().add(listLaptopPanel);
        }
        else if (panelName.equals("패드 선택 화면으로")) {
            getContentPane().add(listPadPanel);
        }
        else if (panelName.equals("모바일 기기 선택 화면으로")) {
            getContentPane().add(listMobilePanel);
        }
        else if (panelName.equals("기타 기기 선택 화면으로")) {
            getContentPane().add(listOtherPanel);
        }
        else if (panelName.equals("랩탑")) {
            getContentPane().add(resLaptopPanel1);
        }
        else if (panelName.equals("랩탑2")) {
            getContentPane().add(resLaptopPanel2);
        }
        else if (panelName.equals("모바일")) {
            getContentPane().add(resMobilePanel1);
        }
        else if (panelName.equals("모바일2")) {
            getContentPane().add(resMobilePanel2);
        }
        else if (panelName.equals("패드")) {
            getContentPane().add(resPadPanel1);
        }
        else if (panelName.equals("패드2")) {
            getContentPane().add(resPadPanel2);
        }
        else if (panelName.equals("기타 기기")) {
            getContentPane().add(resOtherPanel);
        }
        else if (panelName.equals("마이페이지 수령 대기 화면으로")) {
            getContentPane().add(myPagePanel1);
        }
        else if (panelName.equals("마이페이지 대여중 화면으로")) {
            getContentPane().add(myPagePanel2);
        }
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        Main win = new Main();
        win.setTitle("IT공학과 기기 대여 시스템");
        win.loginPanel = new LoginPanel(win);
        win.signupPanel = new SignupPanel(win);
        win.selectServicePanel = new SelectServicePanel(win);
        win.selectEquipPanel = new SelectEquipPanel(win);
        win.listLaptopPanel = new ListLaptopPanel(win);
        win.listPadPanel = new ListPadPanel(win);
        win.listMobilePanel = new ListMobilePanel(win);
        win.listOtherPanel = new ListOtherPanel(win);
        win.resLaptopPanel1 = new ResLaptopPanel_1("눈송이", win);
        win.resLaptopPanel2 = new ResLaptopPanel_2("눈송이", win);
        win.resMobilePanel1 = new ResMobilePanel_1("눈송이", win);
        win.resMobilePanel2 = new ResMobilePanel_2("눈송이", win);
        win.resOtherPanel = new ResOtherPanel("눈송이", win);
        win.resPadPanel1 = new ResPadPanel_1("눈송이", win);
        win.resPadPanel2 = new ResPadPanel_2("눈송이", win);
        win.myPagePanel1 = new MyPagePanel_1(win);
        win.myPagePanel2 = new MyPagePanel_2(win);

        win.add(win.loginPanel);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setSize(860, 740); // 크기수정
        win.setVisible(true);
        win.setResizable(true); // 최대화 설정 여부
    }
}