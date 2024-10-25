package DB2023Team03_FINAL;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;

public class DB2023Team03_ViewViewIndex {

    public DB2023Team03_ViewViewIndex() throws SQLException {
        fun();
    }

    public void fun() throws SQLException {
        //데이터베이스에 접속하기 위해 사용되는 connection, statement 객체 생성
        Connection conn = null;
        Statement st = null;
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DB2023Team03", "DB2023Team03",
                "DB2023Team03");
        //뷰 쿼리문
        String sql1 = "select* from DB2023_cheap_eating";
        String sql2 = "select* from DB2023_high_score_eating";

        //인덱스 쿼리문
        String sql3 = "select * from DB2023_menu use index(idx_menu_num_registed)";
        String sql4 = "select * from DB2023_menu use index(idx_menu_eating_id) where cost<=10000";
        String sql5 = "select * from DB2023_bookmark use index(idx_bookmark_id)";
        String sql6 = "select * from DB2023_bookmark use index(idx_bookmark_theme) where theme='activity'";
        
        //join, nested 사용 쿼리문
        String sql7 = "select * from db2023_eating inner join db2023_menu where db2023_eating.name=db2023_menu.name";
        String sql8 = "select * from db2023_menu where eating_id in(select eating_id from db2023_eating where score >=3)";

        // PreparedStatement
        PreparedStatement pStmt1 = conn.prepareStatement(sql1);
        PreparedStatement pStmt2 = conn.prepareStatement(sql2);
        PreparedStatement pStmt3 = conn.prepareStatement(sql3);
        PreparedStatement pStmt4 = conn.prepareStatement(sql4);
        PreparedStatement pStmt5 = conn.prepareStatement(sql5);
        PreparedStatement pStmt6 = conn.prepareStatement(sql6);
        PreparedStatement pStmt7 = conn.prepareStatement(sql7);
        PreparedStatement pStmt8 = conn.prepareStatement(sql8);


        JOptionPane aa = new JOptionPane();

        String numbere = aa.showInputDialog("(1) 싼 맛집 검색\n"
                + "(2) 평이 좋은 맛집 검색\n" + "(3) 메뉴 인덱스\n" + "(4) 만원 이하인 메뉴\n" + "(5) 북마크 id 인덱스\n"
                + "(6) 북마크 activity 테마 인덱스\n" + "(7) 음식점과 메뉴 정보 함께 보기\n" + "(8) 평점이 3점 이상인 음식점 메뉴 이름\n");

        JTextArea ta = new JTextArea(30, 50);
        JScrollPane scrollPane = new JScrollPane(ta);
        JDialog dialog = new JDialog();
        dialog.setSize(700, 700);
        dialog.setTitle("결과");

        dialog.getContentPane().add(scrollPane);

        int number = Integer.parseInt(numbere);
        int result = JOptionPane.showConfirmDialog(null, numbere, "menu", JOptionPane.YES_NO_OPTION);

        if (result == JOptionPane.CLOSED_OPTION) {

        } else if (result == JOptionPane.YES_OPTION) {
        	//받아온 값에 따라 출력되는 게 다름
            switch (number) {
                //싼 맛집 검색
                case 1:
                    try {
                        ta.setText(""); //ta reset
                        ResultSet rs = pStmt1.executeQuery();

                        ta.append("이름:\t\t\t 장소:\n");
                        while (rs.next()) {
                            String name = rs.getString(1);
                            String description = rs.getString(2);

                            ta.append(name + "\t\t\t" + description + "\n");
                        }
                    } catch (SQLException se) {
                        se.printStackTrace();
                    }
                    dialog.pack();
                    dialog.setVisible(true);
                    ta.revalidate();
                    break;

                //평이 좋은 맛집 검색
                case 2:
                    try {
                        ta.setText(""); //ta reset
                        ResultSet rs = pStmt2.executeQuery();

                        ta.append("name:\t\t\t region:\t\t\ttheme:\t\t\tscore:\t\t\tdescription:\n");
                        while (rs.next()) {
                            String name = rs.getString(1);
                            String region = rs.getString(2);
                            String theme = rs.getString(3);
                            String description = rs.getString(4);
                            int score = rs.getInt(5);

                            ta.append(name + "\t\t\t" + region + "\t\t\t" + theme + "\t\t\t" + score + "\t\t\t" + description + "\n");
                        }
                    } catch (SQLException se) {
                        se.printStackTrace();
                    }
                    dialog.pack();
                    dialog.setVisible(true);
                    ta.revalidate();
                    break;
//                    넘버 인덱스
                case 3:
                    try {
                        ta.setText(""); //ta reset
                        ResultSet rs = pStmt3.executeQuery();

                        ta.append(" num_registed:\t\t\t eating_id:\t\t\t name:\t\t\t menu_:\t\t\t costnum:\n");
                        while (rs.next()) {
                            int num_registed = rs.getInt(1);
                            int eating_id = rs.getInt(2);
                            String name = rs.getString(3);
                            String menu_ = rs.getString(4);
                            int costnum = rs.getInt(5);
                            ta.append(num_registed + "\t\t\t" + eating_id + "\t\t\t" + name + "\t\t\t" + menu_ + "\t\t\t" + costnum + "\n");
                        }
                    } catch (SQLException se) {
                        se.printStackTrace();
                    }
                    dialog.pack();
                    dialog.setVisible(true);
                    ta.revalidate();
                    break;

                //메뉴 인덱스2
                case 4:
                    try {
                        ta.setText(""); //ta reset
                        ResultSet rs = pStmt4.executeQuery();

                        ta.append(" num_registed:\t\t\t eating_id:\t\t\t name:\t\t\t menu_:\t\t\t costnum:\n");
                        while (rs.next()) {
                            int num_registed = rs.getInt(1);
                            int eating_id = rs.getInt(2);
                            String name = rs.getString(3);
                            String menu_ = rs.getString(4);
                            int costnum = rs.getInt(5);

                            ta.append(num_registed + "\t\t\t" + eating_id + "\t\t\t" + name + "\t\t\t" + menu_ + "\t\t\t" + costnum + "\n");
                        }
                    } catch (SQLException se) {
                        se.printStackTrace();
                    }
                    dialog.pack();
                    dialog.setVisible(true);
                    ta.revalidate();
                    break;

                case 5:
                    try {
                        ta.setText(""); //ta reset
                        ResultSet rs = pStmt5.executeQuery();

                        ta.append("id: \t\t\t name:\t\t\t region:\t\t\ttheme:\t\t\tseason:\t\t\tscore:\t\t\tdescription:\n");
                        while (rs.next()) {
                            int id = rs.getInt(1);
                            String name = rs.getString(2);
                            String region = rs.getString(3);
                            String theme = rs.getString(4);
                            String season = rs.getString(5);
                            String description = rs.getString(6);
                            int score = rs.getInt(7);

                            ta.append(id + "\t\t\t" + name + "\t\t\t" + region + "\t\t\t" + theme
                                    + "\t\t\t" + season + "\t\t\t" + score + "\t\t\t" + description + "\n");
                        }
                    } catch (SQLException se) {
                        se.printStackTrace();
                    }
                    dialog.pack();
                    dialog.setVisible(true);
                    ta.revalidate();
                    break;
                case 6:
                    try {
                        ta.setText(""); //ta reset
                        ResultSet rs = pStmt6.executeQuery();

                        ta.append("id: \t\t\t name:\t\t\t region:\t\t\ttheme:\t\t\tseason:\t\t\tscore:\t\t\tdescription:\n");
                        while (rs.next()) {
                            int id = rs.getInt(1);
                            String name = rs.getString(2);
                            String region = rs.getString(3);
                            String theme = rs.getString(4);
                            String season = rs.getString(5);
                            String description = rs.getString(6);
                            int score = rs.getInt(7);

                            ta.append(id + "\t\t\t" + name + "\t\t\t" + region + "\t\t\t" + theme
                                    + "\t\t\t" + season + "\t\t\t" + score + "\t\t\t" + description + "\n");
                        }
                    } catch (SQLException se) {
                        se.printStackTrace();
                    }
                    dialog.pack();
                    dialog.setVisible(true);
                    ta.revalidate();
                    break;
                case 7:
                    try {
                        ta.setText(""); //ta reset
                        ResultSet rs = pStmt7.executeQuery();

                        ta.append("name:\t\t\t menu:\t\t\t\n");
                        while (rs.next()) {
                            String name1 = rs.getString(2);
                            String name2 = rs.getString(12);
                            ta.append(name1 + "\t\t\t" + name2 + "\t\t\t\n");
                        }
                    } catch (SQLException se) {
                        se.printStackTrace();
                    }
                    dialog.pack();
                    dialog.setVisible(true);
                    ta.revalidate();
                    break;
                case 8:
                    try {
                        ta.setText(""); //ta reset
                        ResultSet rs = pStmt8.executeQuery();

                        ta.append(" num_registed:\t\t\t eating_id:\t\t\t name:\t\t\t menu_:\t\t\t costnum:\n");
                        while (rs.next()) {
                            int num_registed = rs.getInt(1);
                            int eating_id = rs.getInt(2);
                            String name = rs.getString(3);
                            String menu_ = rs.getString(4);
                            int costnum = rs.getInt(5);
                            ta.append(num_registed + "\t\t\t" + eating_id + "\t\t\t" + name + "\t\t\t" + menu_ + "\t\t\t" + costnum + "\n");
                        }
                    } catch (SQLException se) {
                        se.printStackTrace();
                    }
                    dialog.pack();
                    dialog.setVisible(true);
                    ta.revalidate();
                    break;
            }
        } else {

        }

    }

}