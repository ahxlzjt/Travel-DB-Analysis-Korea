package DB2023Team03_FINAL;

import java.sql.*;
import java.util.ArrayList;

public class DB2023Team03_ControllerMenu {
    // Connection�� �����ͺ��̽��� �����ϴ� ��ü�̴�.
    Connection conn = null;
    // ResultSet : ������ �������� ���� �޴� ��ü
    ResultSet rs = null;
    Statement st = null; // �׳� �������°�
    // PreparedStatement�� �������� ?�� ����ؼ� �߰��� ?�� ������ �Ҵ��� �ټ� �ֵ��� �ϴ� ��ü
    PreparedStatement ps = null; // ?�־ ����ִ°�

    // connection, statement ��ü ����
    public DB2023Team03_ControllerMenu() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DB2023Team03", "DB2023Team03",
                    "DB2023Team03");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //�����ͺ��̽��� tuple insert
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

            // executeUpdate : insert, delete, update�� ���� ���� �޾ƿ��� �ʴ� ������ ����

            ps.executeUpdate();
            conn.commit(); // Ʈ����� ����
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

    //��� ���
    public ArrayList<DB2023Team03_ModelMenu> readDB2023Team03() {
        ArrayList<DB2023Team03_ModelMenu> arr = new ArrayList<DB2023Team03_ModelMenu>();
        System.out.println(arr);
        try {
            // �������� db�� �ѱ�, ������ ���ڿ� ����
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM DB2023_Menu;");
            // ���� ������� ���
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

    //�����ͺ��̽��� tuple modify
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

    //�����ͺ��̽��� tuple delete
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

    //�����ͺ��̽��� tuple search
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