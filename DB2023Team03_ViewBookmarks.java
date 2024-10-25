package DB2023Team03_FINAL;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DB2023Team03_ViewBookmarks {

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
    JTextField t8 = new JTextField(8);
    JTextArea ta = new JTextArea(30, 50);
    JButton btn1, btn2, btn3, btn4, btn5, btn6;
    
    //라벨

    JLabel ㅣ1 = new JLabel("ID : ");
    JLabel ㅣ2 = new JLabel("이름 : ");
    JLabel ㅣ3 = new JLabel("지역 : ");
    JLabel ㅣ6 = new JLabel("설명 : ");
    JLabel ㅣ7 = new JLabel("점수 : ");
    JLabel ㅣ8 = new JLabel("날짜 : ");

//북마크 창 보기 
    DB2023Team03_ViewBookmarks() {
        GUI_init();
    }
    
    //창 깨끗하게 하기
    public void setTextFieldtoNull() {
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t6.setText("");
        t7.setText("");
        t8.setText("");
    }

    //get the text of selected radio btn
    public String getRadioButtonSelection(JRadioButton[] radioButtons) {
        for (int i = 0; i < radioButtons.length; i++) {
            if (radioButtons[i].isSelected()) return radioButtons[i].getText();
        }
        return null;
    }
   
    public void drawTextArea(ArrayList<DB2023Team03_ModelBookmarks> arr) {
        int space = 20;

        ta.append("id" + "\t" + "name" + new String(new char[space]).replace('\0', ' ') + "\t" + "region" + " \t " + "Theme " + "\t" + "season" + "\t" + "score" + "\t" + "description\n");
        ta.append("---------------------------------------------------------------------------------------------------------------------------------------------------------\n");

        //글자 길이에 따라 정렬이 바뀌어 예쁘게 보이도록 하기
        for (int i = 0; i < arr.size(); i++) {
            String name = arr.get(i).getName();
            if (name.length() > 15) {
                space = 0;
            } else if (name.length() > 7) {
                space = 5;
            } else {
                space = 20;
            }
            ta.append(arr.get(i).getId() + " \t " + name + new String(new char[space]).replace('\0', ' ') + " \t " + arr.get(i).getRegion() + " \t "
                    + arr.get(i).getTheme() + " \t " + arr.get(i).getSeason() + " \t " + arr.get(i).getScore() + "\t" + arr.get(i).getDescription() + "\n");
        }
    }

    public void GUI_init() {
        jframe.setTitle("북마크");
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

        //테마
        //themeBtnPanel에 테마 버튼 붙이기
        ButtonGroup themeBtnSet = new ButtonGroup();
        JRadioButton themeBtn[] = new JRadioButton[6];
        String themeBtnName[] = {"activity", "history", "healing", "walking", "shopping", "event"};

        for (int i = 0; i < themeBtnName.length; i++) {
            themeBtn[i] = new JRadioButton(themeBtnName[i]);
            themeBtnSet.add(themeBtn[i]);
            themeBtnPanel.add(themeBtn[i]);
        }
        btnPanel.add(themeBtnPanel);

        //계절
        //themeBtnPanel에 테마 버튼 붙이기
        ButtonGroup seasonBtnSet = new ButtonGroup();
        JRadioButton seasonBtn[] = new JRadioButton[4];
        String seasonBtnName[] = {"봄", "여름", "가을", "겨울"};

        for (int i = 0; i < seasonBtnName.length; i++) {
            seasonBtn[i] = new JRadioButton(seasonBtnName[i]);
            seasonBtnSet.add(seasonBtn[i]);
            seasonBtnPanel.add(seasonBtn[i]);
        }
        btnPanel.add(seasonBtnPanel);

        //btn2Panel에 설명, 점수, 날짜 붙이기
        //설명
        btn2Panel.add(ㅣ6);
        btn2Panel.add(t6);

        //점수
        btn2Panel.add(ㅣ7);
        btn2Panel.add(t7);

        //날짜
        btn2Panel.add(ㅣ8);
        btn2Panel.add(t8);

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
        DB2023Team03_ControllerBookmarks dao = new DB2023Team03_ControllerBookmarks();


        // 추가
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                ta.setText("");

                int id = Integer.parseInt(t1.getText());
                String name = t2.getText();
                String region = t3.getText();
                String theme = getRadioButtonSelection(themeBtn);
                String season = getRadioButtonSelection(seasonBtn);
                String description = t6.getText();
                int score = Integer.parseInt(t7.getText());
                String date = t8.getText();

                dao.insertDB2023Team03(id, name, region, theme, season, description, score, date);

                ta.append("입력 완료 \n");

                setTextFieldtoNull();
                seasonBtnSet.clearSelection();
                themeBtnSet.clearSelection();
            }
        });

        //목록 출력
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                ta.setText("");
                ArrayList<DB2023Team03_ModelBookmarks> arr = new ArrayList<DB2023Team03_ModelBookmarks>();
                arr = dao.readDB2023Team03();

                drawTextArea(arr);
            }
        });

        // 수정
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                ta.setText("");

                String name = t2.getText();
                int score = Integer.parseInt(t7.getText());

                dao.updateDB2023Team03(name, score);
                ta.append("수정 완료 \n");

                setTextFieldtoNull();
            }
        });

        // 삭제
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                ta.setText("");

                int id = Integer.parseInt(t1.getText());
                dao.deleteDB2023Team03(id);
                ta.append("삭제 완료 \n");

                setTextFieldtoNull();
            }
        });

        // 검색
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                ta.setText("");
                String content = t2.getText();

                ArrayList<DB2023Team03_ModelBookmarks> arr = new ArrayList<DB2023Team03_ModelBookmarks>();
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