package DB2023Team03_FINAL;

import java.sql.*;
import java.util.ArrayList;

public class DB2023Team03_ControllerMenu {
    // Connection은 데이터베이스와 연결하는 객체이다.
    Connection conn = null;
    // ResultSet : 실행한 쿼리문의 값을 받는 객체
    ResultSet rs = null;
    Statement st = null; // 그냥 가져오는거
    // PreparedStatement는 쿼리문에 ?를 사용해서 추가로 ?에 변수를 할당해 줄수 있도록 하는 객체
    PreparedStatement ps = null; // ?넣어서 집어넣는거

    // connection, statement 객체 생성
    public DB2023Team03_ControllerMenu() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DB2023Team03", "DB2023Team03",
                    "DB2023Team03");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //데이터베이스에 tuple insert
    public void insertDB2023Team03(int num_registered, int eating_id, String name, String menu, String cost) {
        try {
            conn.setAutoCommit(true);
            String sql = "INSERT INTO DB2023_Menu values(?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            conn.setAutoCommit(false);
            ps.setInt(1, num_registered);
            ps.setInt(2, eating_id);
            ps.setString(3, name);
            ps.setString(4, menu);
            ps.setString(5, cost);

            // executeUpdate : insert, delete, update와 같이 값을 받아오지 않는 쿼리문 실행

            ps.executeUpdate();
            conn.commit(); // 트랜잭션 수행
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null)
                conn.rollback();
        } catch (SQLException se2) {
            se2.printStackTrace();
        } finally {
            {
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    //목록 출력
    public ArrayList<DB2023Team03_ModelMenu> readDB2023Team03() {
        ArrayList<DB2023Team03_ModelMenu> arr = new ArrayList<DB2023Team03_ModelMenu>();
        System.out.println(arr);
        try {
            // 쿼리문을 db에 넘김, 온전한 문자열 대입
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM DB2023_Menu;");
            // 받은 결과값을 출력
            while (rs.next()) {
                arr.add(new DB2023Team03_ModelMenu(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                st.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arr;
    }

    //데이터베이스에 tuple modify
    public void updateDB2023Team06(String name, int cost) {
        try {
            conn.setAutoCommit(false); 
            st = conn.createStatement();
            int stmt = st.executeUpdate("UPDATE DB2023_Menu SET cost=" + cost + " WHERE menu_ = '" + name + "';");
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                st.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //데이터베이스에 tuple delete
    public void deleteDB2023Team03(int id) {
        try {
            conn.setAutoCommit(false); 
            st = conn.createStatement();
            int stmt = st.executeUpdate("DELETE FROM DB2023_menu WHERE num_registed= '" + id + "';");
            conn.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                st.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //데이터베이스에 tuple search
    public ArrayList<DB2023Team03_ModelMenu> searchDB2023Team03(String content) {
        ArrayList<DB2023Team03_ModelMenu> arr = new ArrayList<DB2023Team03_ModelMenu>();
        System.out.println(arr);
        try {
            st = conn.createStatement();
            rs = st.executeQuery("select * from DB2023_menu where menu_ like '%" + content + "%' ;");
            while (rs.next()) {
                arr.add(new DB2023Team03_ModelMenu(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                st.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arr;
    }
}