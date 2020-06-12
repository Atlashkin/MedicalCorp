package com.medicalcorp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class GUI2 extends Main {
    static JFrame jFrame = getFrame();


    public GUI2() throws SQLException {
        JPanel jPanel = new JPanel();
        jFrame.add(jPanel);
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


        JLabel l2 = new JLabel("Вы вошли под именем:");
        l2.setFont( new Font("Verdana", Font.PLAIN, 18));
        l2.setBounds(50, 370, 400, 50);
        JTextField l2Text = new JTextField(20);
        l2Text.setBounds(300, 370, 400, 50);


        jPanel.add(mc);
        jPanel.add(b1);
        jPanel.add(b2);
        jPanel.add(b3);
        jPanel.add(b4);
        jPanel.add(b5);
        jPanel.add(l2);
        jPanel.add(l2Text);

        jPanel.revalidate();
        jFrame.setVisible(true);
    }




}