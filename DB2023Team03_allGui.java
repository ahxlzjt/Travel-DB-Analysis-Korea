package DB2023Team03_FINAL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class DB2023Team03_allGui {

    JFrame jframe = new JFrame();
    JPanel jpanel = new JPanel();
    JButton btn1;
    JButton btn2;
    private JButton btn3;
    private JButton btn4;
    private JButton btn5;
    private JButton btn6;


    DB2023Team03_allGui() {
        GUI_init();
    }

    public void GUI_init() {

        jframe.setTitle("데이터베이스 2023 Team 03");
        jframe.setBounds(50, 50, 680, 740);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(true);
        Container con = jframe.getContentPane();
        con.setLayout(new BoxLayout(con, BoxLayout.Y_AXIS));

        jpanel.setBackground(new Color(121, 121, 121));
        con.add(jpanel);

        Box titleBox = Box.createVerticalBox();
        JLabel titleLabel1 = new JLabel("데이터베이스 2023 3조");
        JLabel titleLabel2 = new JLabel("데베디바비디부");
        Font font1 = new Font("Arial", Font.BOLD, 24);
        Font font2 = new Font("Arial", Font.BOLD, 40);
        titleLabel1.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel2.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel1.setFont(font1);
        titleLabel2.setFont(font2);

        titleLabel1.setForeground(new Color(255, 255, 255));
        titleLabel2.setForeground(new Color(255, 255, 255));

        titleBox.add(titleLabel1);
        titleBox.add(titleLabel2);
        jpanel.add(titleBox);

        //DB2023_Festival
        jpanel.add(btn1 = new JButton("축제 정보"));
        btn1.setPreferredSize(new Dimension(600, 60));

        //DB2023_Entertainment
        jpanel.add(btn2 = new JButton("관광지 목록"));
        btn2.setPreferredSize(new Dimension(600, 60));

        //DB2023_Eating
        jpanel.add(btn3 = new JButton("맛집"));
        btn3.setPreferredSize(new Dimension(600, 60));

        //DB2023_Bookmarks
        jpanel.add(btn4 = new JButton("북마크"));
        btn4.setPreferredSize(new Dimension(600, 60));

        //DB2023_Menu
        jpanel.add(btn5 = new JButton("menu"));
        btn5.setPreferredSize(new Dimension(600, 60));


        //뷰와 인덱스 출력
        jpanel.add(btn6 = new JButton("view & Index"));
        btn6.setPreferredSize(new Dimension(600, 60));

        jframe.revalidate();

        //축제 정보
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DB2023Team03_ViewFestival gui1 = new DB2023Team03_ViewFestival();
                jframe.setVisible(false);
            }
        });

        //관광지 목록
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DB2023Team03_ViewEntertainment gui2 = new DB2023Team03_ViewEntertainment();
                jframe.setVisible(false);
            }
        });

        //맛집
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DB2023Team03_ViewEating gui3 = new DB2023Team03_ViewEating();
                jframe.setVisible(false);
            }
        });

        //북마크
        btn4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DB2023Team03_ViewBookmarks gui4 = new DB2023Team03_ViewBookmarks();
                jframe.setVisible(false);
            }
        });

        //메뉴
        btn5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DB2023Team03_ViewMenu gui5 = new DB2023Team03_ViewMenu();
                jframe.setVisible(false);
            }
        });

        //view & Index
        btn6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    DB2023Team03_ViewViewIndex gui7 = new DB2023Team03_ViewViewIndex();
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                //setVisible(false);
            }
        });

    }
}

