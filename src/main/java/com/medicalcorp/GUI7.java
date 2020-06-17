package com.medicalcorp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;


class GUI7 {
    static JFrame jFrame = Main.getFrame();


    public GUI7() throws Exception{
        JPanel jPanel = new JPanel();
        jFrame.add(jPanel);
        jPanel.setLayout(null);

        JLabel mc = new JLabel("БАЗА ЛЕКАРСТВ");
        mc.setFont( new Font("Verdana", Font.PLAIN, 25));
        mc.setBounds(20, 5, 400, 50);

        JButton gm = new JButton("Главное меню");
        gm.setFont( new Font("Verdana", Font.PLAIN, 10));
        gm.setBounds(630, 15, 120, 30);

        Vector data = getDatafromDB();
        Vector headers = new Vector();
        headers.add("Название");
        headers.add("Способ приёма");
        headers.add("Описание");
        headers.add("Побочные действия");


        JTable medicines;
        medicines = new JTable(data, headers);
        JScrollPane sr = new JScrollPane(medicines);


        medicines.setPreferredScrollableViewportSize(new Dimension(650, 350));
        sr.setBounds(70, 70, 650, 350);
        medicines.setBounds(70, 70, 650, 350);





        jPanel.add(gm);
        jPanel.add(mc);
        jPanel.add(sr);


        jFrame.setVisible(true);


        jPanel.revalidate();



        gm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
                jFrame.setVisible(false);
                try {
                    new GUI2();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }


            }
        });
    }
    public Vector getDatafromDB() throws Exception{
        Vector result = new Vector();
        Statement statement = Main.worker.getConnection().createStatement();

        String query = "select name, method, description, side_efects from medicine" ;
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