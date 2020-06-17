package com.medicalcorp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;


class GUI91  {
    static JFrame jFrame3 = Main.getFrame();


    public GUI91() throws Exception{
        JPanel jPanel = new JPanel();
        jFrame3.add(jPanel);
        jPanel.setLayout(null);

        JLabel mc = new JLabel("ПАЦИЕНТЫ");
        mc.setFont( new Font("Verdana", Font.PLAIN, 25));
        mc.setBounds(20, 5, 400, 50);

        JButton gm = new JButton("Главное меню");
        gm.setFont( new Font("Verdana", Font.PLAIN, 10));
        gm.setBounds(630, 15, 120, 30);

        gm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame3.dispose();
                jFrame3.setVisible(false);
                GUI2.jFrame2.show();
                GUI2.jFrame2.setVisible(true);
            }
        });





        Vector data = getDatafromDB();
        Vector headers = new Vector();
        headers.add("ФИО");
        headers.add("Лечащий врач");
        headers.add("Дата посещения");
        headers.add("Адрес");
        headers.add("Диагноз");


        JTable patients;
        patients = new JTable(data, headers);
        JScrollPane sr = new JScrollPane(patients);


        patients.setPreferredScrollableViewportSize(new Dimension(650, 350));
        sr.setBounds(70, 70, 650, 350);
        patients.setBounds(70, 70, 650, 350);





        jPanel.add(gm);
        jPanel.add(mc);

        jPanel.add(sr);




        jPanel.revalidate();
    }



    public Vector getDatafromDB() throws Exception{
        Vector result = new Vector();
        Statement statement = Main.worker.getConnection().createStatement();

        String query = "select * from clinical_record \n" +
                "INNER JOIN user on clinical_record.patient = user.id \n" +
                "INNER JOIN location on clinical_record.location = location.id\n" +
                "INNER JOIN clinical_record__diagnosis on clinical_record.id = clinical_record__diagnosis.clinical_record\n" +
                "where created like '%"+GUI9.date+"%'";
        ResultSet resultSet = statement.executeQuery(query);

//        String query1 = "select name from user where id ='"+ resultSet.getString("doctor") +"' and password is null";
//        ResultSet resultSet1 = statement.executeQuery(query1);
        String p1,p2,p3,p4,p5;
        while(resultSet.next())
        {


            Vector element = new Vector();

            // Первой колонкой у нас объявлен P_1
            p1 = resultSet.getString("name");
            p2 = GUI2.name;
            p3 = resultSet.getString("created");
            p4 = resultSet.getString("city")+" "+resultSet.getString("street")+" "+resultSet.getString("address");
            p5 = resultSet.getString("diagnosis");


            // Добавляем по порядку
            element.add(p1);
            element.add(p2);
            element.add(p3);
            element.add(p4);
            element.add(p5);
            // Присоединяем список к результату
            result.add(element);
        }

        return result;
    }

}