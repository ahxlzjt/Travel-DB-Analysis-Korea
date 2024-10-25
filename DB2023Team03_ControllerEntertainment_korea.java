package DB2023Team03_FINAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DB2023Team03_ControllerEntertainment_korea {

	  // Connection�� �����ͺ��̽��� �����ϴ� ��ü�̴�.
    Connection conn = null;
    // ResultSet : ������ �������� ���� �޴� ��ü
    ResultSet rs = null;
    Statement st = null; // �׳� �������°�
    // PreparedStatement�� �������� ?�� ����ؼ� �߰��� ?�� ������ �Ҵ��� �ټ� �ֵ��� �ϴ� ��ü
    PreparedStatement ps = null; // ?�־ ����ִ°�
    

    //�����ͺ��̽��� �����ϱ� ���� ���Ǵ� connection, statement ��ü ����
    public DB2023Team03_ControllerEntertainment_korea() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DB2023Team03", "DB2023Team03",
                    "DB2023Team03");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //�����ͺ��̽��� tuple insert
    public void insertDB2023Team03(int entertainment_id, String name, String region, String theme, String season, String description, int score, String date) {
        try {
            conn.setAutoCommit(true);

            String sql = "INSERT INTO DB2023_entertainment_korea(entertainment_id, name, region, theme, season, description, score, date) values(?,?,?,?,?,?,?,?)";
            // PreparedStatment��ü ����, ���ڷ� sql���� �־���

            ps = conn.prepareStatement(sql);
            conn.setAutoCommit(false); // Ʈ�����
            ps.setInt(1, entertainment_id);
            ps.setString(2, name);
            ps.setString(3, region);
            ps.setString(4, theme);
            ps.setString(5, season);
            ps.setString(6, description);
            ps.setInt(7, score);
            ps.setString(8, date);
            // executeUpdate : insert, delete, update�� ���� ���� �޾ƿ��� �ʴ� ������ ����
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

    //������ ��� ���
    public ArrayList<DB2023Team03_ModelEntertainment_korea> readDB2023Team03() {
        ArrayList<DB2023Team03_ModelEntertainment_korea> arr = new ArrayList<DB2023Team03_ModelEntertainment_korea>();
        System.out.println(arr);
        try {
            st = conn.createStatement();
            rs = st.executeQuery("select * from DB2023_entertainment_korea;");
            while (rs.next()) {
                arr.add(new DB2023Team03_ModelEntertainment_korea(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8)));
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

    // ���� ����s
    public void updateDB2023Team03(String NAME, int score) {
        try {
        	conn.setAutoCommit(false); // Ʈ�����  
            st = conn.createStatement();
            int stmt = st.executeUpdate("update DB2023_entertainment_korea set score = '" + score + "' where NAME = '" + NAME + "';");
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

    //�����ͺ��̽��� tuple delete
    public void deleteDB2023Team03(String NAME) {
        try {
        	conn.setAutoCommit(false); // Ʈ�����  
            st = conn.createStatement();
            int stmt = st.executeUpdate("delete from DB2023_entertainment_korea where name = '" + NAME + "';");
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

    //�����ͺ��̽��� tuple search
    public ArrayList<DB2023Team03_ModelEntertainment_korea> searchDB2023Team03(String content) {
        ArrayList<DB2023Team03_ModelEntertainment_korea> arr = new ArrayList<DB2023Team03_ModelEntertainment_korea>();
        System.out.println(arr);
        try {
            st = conn.createStatement();
            rs = st.executeQuery("select * from DB2023_entertainment_korea where NAME like '%" + content + "%' ;");
            while (rs.next()) {
                arr.add(new DB2023Team03_ModelEntertainment_korea(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8)));
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

