package com.medicalcorp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;


class GUI8 {
    static JFrame jFrame8 = Main.getFrame();


    public GUI8() throws Exception{
        JPanel jPanel = new JPanel();
        jFrame8.add(jPanel);
        jPanel.setLayout(null);

        JLabel mc = new JLabel("ПЕРСОНАЛ");
        mc.setFont( new Font("Verdana", Font.PLAIN, 25));
        mc.setBounds(20, 5, 400, 50);

        JButton gm = new JButton("Главное меню");
        gm.setFont( new Font("Verdana", Font.PLAIN, 10));
        gm.setBounds(630, 15, 120, 30);
        gm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame8.dispose();
                jFrame8.setVisible(false);
                GUI2.jFrame2.show();
                GUI2.jFrame2.setVisible(true);
            }
        });

        Vector data = getDatafromDB();
        Vector headers = new Vector();
        headers.add("ФИО");
        headers.add("Дата рождения");
        headers.add("Должность");




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

        String query = "select name, birthdate, position from user where password IS NOT NULL" ;
        ResultSet resultSet = statement.executeQuery(query);


        String p1,p2,p3;
        while(resultSet.next())
        {


            Vector element = new Vector();

            // Первой колонкой у нас объявлен P_1
            p1 = resultSet.getString("name");
            p2 = resultSet.getString("birthdate");
            p3 = resultSet.getString("position");



            // Добавляем по порядку
            element.add(p1);
            element.add(p2);
            element.add(p3);

            // Присоединяем список к результату
            result.add(element);
        }

        return result;
    }
}