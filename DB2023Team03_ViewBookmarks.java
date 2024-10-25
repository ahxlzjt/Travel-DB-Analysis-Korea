package DB2023Team03_FINAL;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DB2023Team03_ViewBookmarks {

	//GUI ��ü �߰�

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
    
    //��

    JLabel ��1 = new JLabel("ID : ");
    JLabel ��2 = new JLabel("�̸� : ");
    JLabel ��3 = new JLabel("���� : ");
    JLabel ��6 = new JLabel("���� : ");
    JLabel ��7 = new JLabel("���� : ");
    JLabel ��8 = new JLabel("��¥ : ");

//�ϸ�ũ â ���� 
    DB2023Team03_ViewBookmarks() {
        GUI_init();
    }
    
    //â �����ϰ� �ϱ�
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

        //���� ���̿� ���� ������ �ٲ�� ���ڰ� ���̵��� �ϱ�
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
        jframe.setTitle("�ϸ�ũ");
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

        //btn1Panel�� ID, �̸�, �������� ���̱�
        //ID
        btn1Panel.add(��1);
        btn1Panel.add(t1);

        //�̸�
        btn1Panel.add(��2);
        btn1Panel.add(t2);

        //����
        btn1Panel.add(��3);
        btn1Panel.add(t3);

        btnPanel.add(btn1Panel);

        //�׸�
        //themeBtnPanel�� �׸� ��ư ���̱�
        ButtonGroup themeBtnSet = new ButtonGroup();
        JRadioButton themeBtn[] = new JRadioButton[6];
        String themeBtnName[] = {"activity", "history", "healing", "walking", "shopping", "event"};

        for (int i = 0; i < themeBtnName.length; i++) {
            themeBtn[i] = new JRadioButton(themeBtnName[i]);
            themeBtnSet.add(themeBtn[i]);
            themeBtnPanel.add(themeBtn[i]);
        }
        btnPanel.add(themeBtnPanel);

        //����
        //themeBtnPanel�� �׸� ��ư ���̱�
        ButtonGroup seasonBtnSet = new ButtonGroup();
        JRadioButton seasonBtn[] = new JRadioButton[4];
        String seasonBtnName[] = {"��", "����", "����", "�ܿ�"};

        for (int i = 0; i < seasonBtnName.length; i++) {
            seasonBtn[i] = new JRadioButton(seasonBtnName[i]);
            seasonBtnSet.add(seasonBtn[i]);
            seasonBtnPanel.add(seasonBtn[i]);
        }
        btnPanel.add(seasonBtnPanel);

        //btn2Panel�� ����, ����, ��¥ ���̱�
        //����
        btn2Panel.add(��6);
        btn2Panel.add(t6);

        //����
        btn2Panel.add(��7);
        btn2Panel.add(t7);

        //��¥
        btn2Panel.add(��8);
        btn2Panel.add(t8);

        btnPanel.add(btn2Panel);

        JScrollPane jsp = new JScrollPane(ta);
        jsp.setBounds(23, 240, 420, 250);
        btnPanel.add(jsp);

        funcBtnPanel.add(btn1 = new JButton("�Է�"));
        funcBtnPanel.add(btn2 = new JButton("���"));
        funcBtnPanel.add(btn3 = new JButton("����"));
        funcBtnPanel.add(btn4 = new JButton("����"));
        funcBtnPanel.add(btn5 = new JButton("�˻�"));
        funcBtnPanel.add(btn6 = new JButton("���"));

        btnPanel.add(funcBtnPanel);
        jpanel.add(btnPanel);

        Container con = jframe.getContentPane();
        con.add(jpanel);
        DB2023Team03_ControllerBookmarks dao = new DB2023Team03_ControllerBookmarks();


        // �߰�
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

                ta.append("�Է� �Ϸ� \n");

                setTextFieldtoNull();
                seasonBtnSet.clearSelection();
                themeBtnSet.clearSelection();
            }
        });

        //��� ���
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                ta.setText("");
                ArrayList<DB2023Team03_ModelBookmarks> arr = new ArrayList<DB2023Team03_ModelBookmarks>();
                arr = dao.readDB2023Team03();

                drawTextArea(arr);
            }
        });

        // ����
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                ta.setText("");

                String name = t2.getText();
                int score = Integer.parseInt(t7.getText());

                dao.updateDB2023Team03(name, score);
                ta.append("���� �Ϸ� \n");

                setTextFieldtoNull();
            }
        });

        // ����
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                ta.setText("");

                int id = Integer.parseInt(t1.getText());
                dao.deleteDB2023Team03(id);
                ta.append("���� �Ϸ� \n");

                setTextFieldtoNull();
            }
        });

        // �˻�
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