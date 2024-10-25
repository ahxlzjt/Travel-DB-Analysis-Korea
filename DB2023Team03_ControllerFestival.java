package DB2023Team03_FINAL;

import java.sql.*;
import java.util.ArrayList;

public class DB2023Team03_ControllerFestival {
	  // Connection은 데이터베이스와 연결하는 객체이다.
    Connection conn = null;
    // ResultSet : 실행한 쿼리문의 값을 받는 객체
    ResultSet rs = null;
    Statement st = null; // 그냥 가져오는거
    // PreparedStatement는 쿼리문에 ?를 사용해서 추가로 ?에 변수를 할당해 줄수 있도록 하는 객체
    PreparedStatement ps = null; // ?넣어서 집어넣는거

    //데이터베이스에 접속하기 위해 사용되는 connection, statement 객체 생성
    public DB2023Team03_ControllerFestival() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DB2023Team03", "DB2023Team03",
                    "DB2023Team03");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //데이터베이스에 tuple insert
    public void insertDB2023Team03(int festival_id, String name, String region, String theme, String season, String description, int score, String date) {
        try {
            conn.setAutoCommit(true);

            String sql = "INSERT INTO DB2023_festival(festival_id, name, region, theme, season, description, score, date) values(?,?,?,?,?,?,?,?)";
            // PreparedStatment객체 생성, 인자로 sql문이 주어짐

            ps = conn.prepareStatement(sql);
            conn.setAutoCommit(false); // 트랜잭션
            ps.setInt(1, festival_id);
            ps.setString(2, name);
            ps.setString(3, region);
            ps.setString(4, theme);
            ps.setString(5, season);
            ps.setString(6, description);
            ps.setInt(7, score);
            ps.setString(8, date);
            // executeUpdate : insert, delete, update와 같이 값을 받아오지 않는 쿼리문 실행
            ps.executeUpdate();

            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null)
                conn.rollback();
        } catch (SQLException se2) {
            se2.printStackTrace();
        } finally {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //목록 출력
    public ArrayList<DB2023Team03_ModelFestival> readDB2023Team03() {
        ArrayList<DB2023Team03_ModelFestival> arr = new ArrayList<DB2023Team03_ModelFestival>();
        System.out.println(arr);
        try {
            st = conn.createStatement();
            rs = st.executeQuery("select * from DB2023_festival;");
            while (rs.next()) {
                arr.add(new DB2023Team03_ModelFestival(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8)));
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
    public void updateDB2023Team03(String NAME, int score) {
        try {
            conn.setAutoCommit(false); // 트랜잭션
            st = conn.createStatement();
            int stmt = st.executeUpdate("update DB2023_festival set score = '" + score + "' where NAME = '" + NAME + "';");
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
    public void deleteDB2023Team03(String NAME) {
        try {
        	
            conn.setAutoCommit(false); // 트랜잭션
            st = conn.createStatement();
            int stmt = st.executeUpdate("delete from DB2023_festival where name = '" + NAME + "';");
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
    public ArrayList<DB2023Team03_ModelFestival> searchDB2023Team03(String content) {
        ArrayList<DB2023Team03_ModelFestival> arr = new ArrayList<DB2023Team03_ModelFestival>();
        System.out.println(arr);
        try {
            st = conn.createStatement();
            rs = st.executeQuery("select * from DB2023_festival where NAME like '%" + content + "%' ;");
            while (rs.next()) {
                arr.add(new DB2023Team03_ModelFestival(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8)));
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
