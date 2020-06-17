package com.medicalcorp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;


class GUI92 {
    static JFrame jFrame = Main.getFrame();
    public static String string;
    public static JTable medicines;
    public GUI92() throws Exception{
        JPanel jPanel = new JPanel();
        jFrame.add(jPanel);
        jPanel.setLayout(null);

        Statement statement = Main.worker.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("select * from clinical_record\n" +
                "INNER JOIN user on clinical_record.patient = user.id\n" +
                "INNER JOIN location on clinical_record.location = location.id\n" +
                "INNER JOIN clinical_record__diagnosis on clinical_record.id = clinical_record__diagnosis.clinical_record\n"+
                "where user.name like '%"+GUI9.fio+"%'");
        resultSet.next();
        String str1,str2,str3,str4,str5;
        str1 = resultSet.getString("name");
        str2 = resultSet.getString("birthdate");
        str3 = resultSet.getString("city")+" "+resultSet.getString("street")+" "+resultSet.getString("address");
        str4 = resultSet.getString("conclusion");
        str5 = resultSet.getString("diagnosis");
        string = resultSet.getString("clinical_record.id");

        JLabel pat = new JLabel("Пациент:");
        pat.setFont( new Font("Verdana", Font.PLAIN, 12));
        pat.setBounds(20, 5, 400, 50);

        JLabel patText = new JLabel(str1);
        patText.setFont( new Font("Verdana", Font.PLAIN, 12));
        patText.setBounds(150, 15, 250, 30);

//

        JLabel dr = new JLabel("Дата рождения:");
        dr.setFont( new Font("Verdana", Font.PLAIN, 12));
        dr.setBounds(20, 45, 400, 50);

        JLabel drText = new JLabel(str2);
        drText.setFont( new Font("Verdana", Font.PLAIN, 12));
        drText.setBounds(150, 55, 250, 30);



        JLabel adr = new JLabel("Адрес:");
        adr.setFont( new Font("Verdana", Font.PLAIN, 12));
        adr.setBounds(20, 85, 400, 50);

        JLabel adrText = new JLabel(str3);
        adrText.setFont( new Font("Verdana", Font.PLAIN, 12));
        adrText.setBounds(150, 95, 250, 30);










        JLabel med = new JLabel("Результат осмотра:");
        med.setFont( new Font("Verdana", Font.PLAIN, 12));
        med.setBounds(20, 140, 400, 50);
        JTextArea osText = new JTextArea(str4);
        osText.setLineWrap(true);
        osText.setWrapStyleWord(true);
        JScrollPane scrrr = new JScrollPane(osText);
        scrrr.setBounds(150, 135, 400, 60);

        JLabel dia = new JLabel("Диагноз:");
        dia.setFont( new Font("Verdana", Font.PLAIN, 12));
        dia.setBounds(20, 210, 400, 50);

        JTextArea diaText = new JTextArea(str5);
        diaText.setLineWrap(true);
        diaText.setWrapStyleWord(true);
        JScrollPane srr = new JScrollPane(diaText);
        srr.setBounds(150, 205, 400, 60);

        JLabel lek = new JLabel("Назначенные лекарства:");
        lek.setFont( new Font("Verdana", Font.PLAIN, 12));
        lek.setBounds(20, 260, 400, 50);

        Vector data = getDatafromDB();
        Vector headers = new Vector();
        headers.add("Название");
        headers.add("Способ приёма");
        headers.add("Описание");
        headers.add("Побочные действия");


        medicines = new JTable(data, headers);
        JScrollPane sr = new JScrollPane(medicines);


        medicines.setPreferredScrollableViewportSize(new Dimension(550, 120));
        sr.setBounds(40, 300, 550, 120);
        medicines.setBounds(40, 300, 550, 120);




        JButton gm = new JButton("Главное меню");
        gm.setFont( new Font("Verdana", Font.PLAIN, 10));
        gm.setBounds(630, 15, 120, 30);

        gm.addActionListener(new ActionListener() { //кнопка главного меню
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
                jFrame.setVisible(false);
                GUI2.jFrame2.show();
                GUI2.jFrame2.setVisible(true);

            }
        });





        JButton save = new JButton("Сохранить");
        save.setFont( new Font("Verdana", Font.PLAIN, 10));
        save.setBounds(630, 400, 120, 30);

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
                jFrame.setVisible(false);
                GUI9.jFrame.setVisible(true);

            }
        });

        JButton add = new JButton("Добавить");
        add.setFont( new Font("Verdana", Font.PLAIN, 10));
        add.setBounds(630, 350, 120, 30);

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
                jFrame.setVisible(false);
                try {
                    new GUI921();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                GUI921.jFrame.setVisible(true);
            }
        });




        jPanel.add(add);
        jPanel.add(sr);
        jPanel.add(gm);
        jPanel.add(pat);
        jPanel.add(patText);

        jPanel.add(srr);
        jPanel.add(save);
        jPanel.add(scrrr);
        jPanel.add(dr);
        jPanel.add(drText);
        jPanel.add(adr);
        jPanel.add(adrText);
        jPanel.add(lek);
        jPanel.add(dia);
//        jPanel.add(diaText);
        jPanel.add(med);





        jPanel.revalidate();
    }
    public static Vector getDatafromDB() throws Exception{
        Vector result = new Vector();
        Statement statement = Main.worker.getConnection().createStatement();

        String query = "select medicine.name, medicine.method, medicine.description, medicine.side_efects from clinical_record__medicine\n" +
                "inner join medicine on clinical_record__medicine.medicine = medicine.id\n" +
                "where clinical_record__medicine.clinical_record = '"+string+"'" ;
        ResultSet resultSet = statement.executeQuery(query);


        String p1,p2,p3,p4;
        while(resultSet.next())
        {


            Vector element = new Vector();

            // Первой колонкой у нас объявлен P_1
            p1 = resultSet.getString("name");
            p2 = resultSet.getString("method");
            p3 = resultSet.getString("description");
            p4 = resultSet.getString("side_efects");


            // Добавляем по порядку
            element.add(p1);
            element.add(p2);
            element.add(p3);
            element.add(p4);

            // Присоединяем список к результату
            result.add(element);
        }

        return result;
    }

}