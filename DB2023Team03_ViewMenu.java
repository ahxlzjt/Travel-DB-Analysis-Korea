package DB2023Team03_FINAL;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class DB2023Team03_ViewMenu {
	
	//GUI 객체 추가
    JFrame jframe = new JFrame();
    JPanel jpanel = new JPanel();
    JPanel themeBtnPanel = new JPanel();
    JPanel seasonBtnPanel = new JPanel();
    JPanel btnPanel = new JPanel();
    JPanel btn1Panel = new JPanel();
    JPanel btn2Panel = new JPanel();
    JPanel funcBtnPanel = new JPanel();
    JTextField t1 = new JTextField(8);
    JTextField t2 = new JTextField(8);
    JTextField t3 = new JTextField(8);
    JTextField t6 = new JTextField(8);
    JTextField t7 = new JTextField(8);
    //	JTextField t8 = new JTextField(8);
    JTextArea ta = new JTextArea(30, 50);
    JButton btn1, btn2, btn3, btn4, btn5, btn6;
    JLabel ㅣ1 = new JLabel("num_registed : ");
    JLabel ㅣ2 = new JLabel("ID : ");
    JLabel ㅣ3 = new JLabel("이름 : ");
    JLabel ㅣ6 = new JLabel("메뉴 : ");
    JLabel ㅣ7 = new JLabel("가격 : ");
//	JLabel ㅣ8 = new JLabel("날짜 : ");


    //메뉴 창 보기
    DB2023Team03_ViewMenu() {
        GUI_init();
    }

    public void drawTextArea(ArrayList<DB2023Team03_ModelMenu> arr) {

        int menu_space = 20;
        int name_space = 20;

        ta.append("num" + "\t" + "식당아이디" + "\t" + "이름" + new String(new char[name_space]).replace('\0', ' ') + "\t" + "메뉴"
                + new String(new char[menu_space]).replace('\0', ' ') + "\t" + "COST\n");
        ta.append("-----------------------------------------------------------------------\n");

        //글자 길이에 따라 정렬이 바뀌어 예쁘게 보이도록 하기
        for (int i = 0; i < arr.size(); i++) {
            String menu = arr.get(i).getMenu();
            String name = arr.get(i).getMenu();
            if (menu.length() > 15) {
                menu_space = 0;
            } else if (menu.length() > 7) {
                menu_space = 10;
            } else {
                menu_space = 20;
                if (name.length() > 7) {
                    name_space = 10;
                } else {
                    name_space = 20;
                }
            }
            ta.append(arr.get(i).getNum_registed() + " \t " + arr.get(i).getEating_id() + " \t "
                    + arr.get(i).getName() + new String(new char[name_space]).replace('\0', ' ') + " \t " + arr.get(i).getMenu()
                    + new String(new char[menu_space]).replace('\0', ' ') + " \t " + arr.get(i).getCost() + "\n");
        }
    }
    //창 깨끗하게 하기
    public void setTextFieldtoNull() {
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t6.setText("");
        t7.setText("");
//		t8.setText("");
    }

    public void GUI_init() {
        jframe.setTitle("메뉴");
        jframe.setBounds(50, 50, 680, 740);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(true);

        jpanel.setBackground(SystemColor.info);
        jpanel.setLayout(new BorderLayout());

        themeBtnPanel.setLayout(new FlowLayout());
        themeBtnPanel.setBackground(new Color(159, 159, 159));

        seasonBtnPanel.setLayout(new FlowLayout());
        seasonBtnPanel.setBackground(new Color(255, 199, 133));

        funcBtnPanel.setLayout(new FlowLayout());

        //btn1Panel에 ID, 이름, 지역까지 붙이기
        //ID
        btn1Panel.add(ㅣ1);
        btn1Panel.add(t1);

        //이름
        btn1Panel.add(ㅣ2);
        btn1Panel.add(t2);

        //지역
        btn1Panel.add(ㅣ3);
        btn1Panel.add(t3);

        btnPanel.add(btn1Panel);


        //btn2Panel에 설명, 점수, 날짜 붙이기
        //설명
        btn2Panel.add(ㅣ6);
        btn2Panel.add(t6);

        //점수
        btn2Panel.add(ㅣ7);
        btn2Panel.add(t7);


        btnPanel.add(btn2Panel);

        JScrollPane jsp = new JScrollPane(ta);
        jsp.setBounds(23, 240, 420, 250);
        btnPanel.add(jsp);

        funcBtnPanel.add(btn1 = new JButton("입력"));
        funcBtnPanel.add(btn2 = new JButton("출력"));
        funcBtnPanel.add(btn3 = new JButton("수정"));
        funcBtnPanel.add(btn4 = new JButton("삭제"));
        funcBtnPanel.add(btn5 = new JButton("검색"));
        funcBtnPanel.add(btn6 = new JButton("목록"));

        btnPanel.add(funcBtnPanel);
        jpanel.add(btnPanel);

        Container con = jframe.getContentPane();
        con.add(jpanel);

        DB2023Team03_ControllerMenu dao = new DB2023Team03_ControllerMenu();

        // 추가
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                ta.setText("");
                int num_registered = Integer.parseInt(t1.getText());
                int menu_id = Integer.parseInt(t2.getText());
                String menu_name = t3.getText();
                String menu_menu = t6.getText();
                String menu_cost = t7.getText();

                dao.insertDB2023Team03(num_registered, menu_id, menu_name, menu_menu, menu_cost);

                ta.append("입력 완료 \n");

                setTextFieldtoNull();
            }
        });

        // 출력 버튼 이벤트
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                ta.setText("");
                ArrayList<DB2023Team03_ModelMenu> arr = new ArrayList<DB2023Team03_ModelMenu>();
                arr = dao.readDB2023Team03();
                drawTextArea(arr);
            }
        });

        // 수정 버튼 이벤트
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                ta.setText("");

                String name = t6.getText();
                int cost = Integer.parseInt(t7.getText());

                dao.updateDB2023Team06(name, cost);
                ta.append("수정 완료 \n");

                setTextFieldtoNull();
            }
        });

        // 삭제 버튼 이벤트
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                ta.setText("");

                int num = Integer.parseInt(t1.getText());
                dao.deleteDB2023Team03(num);
                ta.append("삭제 완료 \n");

                t1.setText("");
            }
        });
        // 검색
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                ta.setText("");
                String content = t6.getText();

                ArrayList<DB2023Team03_ModelMenu> arr = new ArrayList<DB2023Team03_ModelMenu>();
                arr = dao.searchDB2023Team03(content);
                drawTextArea(arr);

                setTextFieldtoNull();
            }
        });

        btn6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DB2023Team03_allGui gui = new DB2023Team03_allGui();
                jframe.setVisible(false);
            }
        });
    }
}