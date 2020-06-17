package com.medicalcorp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class GUI921 {
    static JFrame jFrame = getFrame();
    public static JFrame getFrame() {
        JFrame window1 = new JFrame();
        window1.setTitle("MedicalCorp.");
        window1.setDefaultCloseOperation(window1.EXIT_ON_CLOSE);
        window1.setSize(500, 300);
        window1.setResizable(false);
        window1.setLocationRelativeTo(null);
        return window1 ;
    }
    public static String str1;
    public static String str2;
    public static String str3;
    public static String str4;
    public static String str5;
    Statement statement = Main.worker.getConnection().createStatement();
    public GUI921() throws SQLException {

        JPanel jPanel = new JPanel();
        jFrame.add(jPanel);
        jPanel.setLayout(null);
        JLabel mc = new JLabel("Добавление лекарств");
        mc.setFont( new Font("Verdana", Font.PLAIN, 25));
        mc.setBounds(100, 3, 400, 30);

        JLabel label1 = new JLabel("Название:");
        label1.setFont( new Font("Verdana", Font.PLAIN, 12));
        label1.setBounds(5, 55, 100, 20);

        JLabel label2 = new JLabel("Способ приёма:");
        label2.setFont( new Font("Verdana", Font.PLAIN, 12));
        label2.setBounds(5, 95, 100, 20);

        JLabel label3 = new JLabel("Описание:");
        label3.setFont( new Font("Verdana", Font.PLAIN, 12));
        label3.setBounds(5, 135, 100, 20);

        JLabel label4 = new JLabel("Побочные действия:");
        label4.setFont( new Font("Verdana", Font.PLAIN, 12));
        label4.setBounds(5, 175, 130, 20);

        JTextField pText1 = new JTextField(100);
        pText1.setBounds(135, 50, 250, 30);

        JTextField pText5 = new JTextField(1);
        pText5.setBounds(400, 50, 30, 30);

        JTextField pText2 = new JTextField(100);
        pText2.setBounds(135, 90, 250, 30);

        JTextField pText3 = new JTextField(100);
        pText3.setBounds(135, 130, 250, 30);

        JTextField pText4 = new JTextField(100);
        pText4.setBounds(135, 170, 250, 30);

        JButton button = new JButton("Добавить");
        button.setFont( new Font("Verdana", Font.PLAIN, 10));
        button.setBounds(110, 220, 120, 30);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
                jFrame.setVisible(false);
                try {
                    new GUI92();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                GUI92.jFrame.show();
                GUI92.jFrame.setVisible(true);
                str1 = pText1.getText();
                str2 = pText2.getText();
                str3 = pText3.getText();
                str4 = pText4.getText();
                str5 = pText5.getText();
                int str7 = Integer.parseInt(str5);
                try {
                    statement.executeUpdate("INSERT INTO medicine (id, name, method, description, side_efects) VALUES ('"+str7+"','"+str1+"','"+ str2+"','"+str3+"','"+str4+"')");
                    ResultSet resultSet = statement.executeQuery("select clinical_record.id from clinical_record\n" +
                            "inner join user on clinical_record.patient = user.id\n" +
                            "where user.name like '%"+GUI9.fio+"%'");
                    resultSet.next();
                    String str6 = resultSet.getString("id");
                    statement.executeUpdate("INSERT INTO clinical_record__medicine (clinical_record, medicine) VALUES ('"+str6+"','"+str5+"')");



                } catch (SQLException ex) {
                    ex.printStackTrace();

                }
            }
        });

        JButton button1 = new JButton("Отменить");
        button1.setFont( new Font("Verdana", Font.PLAIN, 10));
        button1.setBounds(250, 220, 120, 30);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
                jFrame.setVisible(false);
                GUI92.jFrame.show();
                GUI92.jFrame.setVisible(true);
            }
        });


        jPanel.add(button);
        jPanel.add(button1);
        jPanel.add(pText1);
        jPanel.add(pText2);
        jPanel.add(pText3);
        jPanel.add(pText4);
        jPanel.add(pText5);
        jPanel.add(label1);
        jPanel.add(label2);
        jPanel.add(label3);
        jPanel.add(label4);

        jPanel.add(mc);
        jFrame.setVisible(true);
    }
}

