package com.medicalcorp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class GUI2  {
    static JFrame jFrame2 = Main.getFrame();
    static String  firstname ;
    static String  lastname ;
    static String  middlename ;
    public GUI2() throws SQLException {
        JPanel jPanel = new JPanel();
        jFrame2.add(jPanel);
        jPanel.setLayout(null);

        JLabel mc = new JLabel("ГЛАВНОЕ МЕНЮ");
        mc.setFont( new Font("Verdana", Font.PLAIN, 25));
        mc.setBounds(20, 15, 400, 50);



        JButton b1 = new JButton("ПАЦИЕНТЫ");
        b1.setFont( new Font("Verdana", Font.PLAIN, 15));
        b1.setBounds(200, 75, 350, 50);
        JButton b2 = new JButton("ПЕРСОНАЛ");
        b2.setFont( new Font("Verdana", Font.PLAIN, 15));
        b2.setBounds(200, 130, 350, 50);
        JButton b3 = new JButton("БАЗА ЛЕКАРСТВ");
        b3.setFont( new Font("Verdana", Font.PLAIN, 15));
        b3.setBounds(200, 185, 350, 50);
        JButton b4 = new JButton("ПОИСК ПАЦИЕНТОВ");
        b4.setFont( new Font("Verdana", Font.PLAIN, 15));
        b4.setBounds(200, 240, 350, 50);
        JButton b5 = new JButton("ПРОФИЛЬ");
        b5.setFont( new Font("Verdana", Font.PLAIN, 15));
        b5.setBounds(200, 295, 350, 50);

        Statement statement = Main.worker.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("select firstname, lastname, middlename from users where email = '" + Main.Email+"'");
        resultSet.next();
         firstname = resultSet.getString("firstname");
         lastname = resultSet.getString("lastname");
         middlename = resultSet.getString("middlename");
        JLabel l2 = new JLabel("Вы вошли под именем:");
        l2.setFont( new Font("Verdana", Font.PLAIN, 18));
        l2.setBounds(50, 370, 400, 50);
        JLabel l3 = new JLabel(lastname+" "+firstname+" "+middlename);
        l3.setFont( new Font("Verdana", Font.PLAIN, 18));
        l3.setBounds(300, 370, 400, 50);



        jPanel.add(mc);
        jPanel.add(b1);
        jPanel.add(b2);
        jPanel.add(b3);
        jPanel.add(b4);
        jPanel.add(b5);
        jPanel.add(l2);
        jPanel.add(l3);

        jPanel.revalidate();
        jFrame2.setVisible(true);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame2.dispose();
                jFrame2.setVisible(false);
                try {
                    new GUI3();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                GUI3.jFrame3.setVisible(true);
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame2.dispose();
                jFrame2.setVisible(false);
                try {
                    new GUI8();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                GUI8.jFrame8.setVisible(true);
            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame2.dispose();
                jFrame2.setVisible(false);
                try {
                    new GUI7();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame2.dispose();
                jFrame2.setVisible(false);
                try {
                    new GUI5();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }


}