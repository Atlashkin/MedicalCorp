package com.medicalcorp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class GUI3 {
    static JFrame jFrame = getFrame();
    static JFrame getFrame() {


        JFrame jFrame = new JFrame() {};
        //jFrame.getContentPane().setLayout(null);
        jFrame.setSize(800, 500);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.setLocationRelativeTo(null);




        return jFrame;

    }

    public static void main(String[] args) throws Exception{
        JPanel jPanel = new JPanel();
        jFrame.add(jPanel);
        jPanel.setLayout(null);

        JLabel mc = new JLabel("ПАЦИЕНТЫ");
        mc.setFont( new Font("Verdana", Font.PLAIN, 25));
        mc.setBounds(20, 5, 400, 50);

        JButton gm = new JButton("Главное меню");
        gm.setFont( new Font("Verdana", Font.PLAIN, 10));
        gm.setBounds(630, 15, 120, 30);

        JButton ad = new JButton("Добавить нового пациента");
        ad.setFont( new Font("Verdana", Font.PLAIN, 10));
        ad.setBounds(370, 15, 250, 30);

        Object[] headers = { "№", "ФИО", "Лечащий врач", "Дата посещения", "Дата выписки", "Диагноз"};
        Object[][] data = {{"1", "oo", "pp", "rr", "gh", "fh"},{"1", "o000000000000000000000o", "pp", "rr", "gh", "fh"},{"1", "oo", "pp", "rr", "gh", "fh"},{"1", "oo", "pp", "rr", "gh", "fh"},{"1", "oo", "pp", "rr", "gh", "fh"},{"1", "oo", "pp", "rr", "gh", "fh"},{"1", "oo", "pp", "rr", "gh", "fh"},{"1", "oo", "pp", "rr", "gh", "fh"}};


        JTable patients;
        patients = new JTable(data, headers);
        JScrollPane sr = new JScrollPane(patients);


        patients.setPreferredScrollableViewportSize(new Dimension(650, 350));
        sr.setBounds(70, 70, 650, 350);
        patients.setBounds(70, 70, 650, 350);

        //patients.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        patients.getColumnModel().getColumn(0).setMinWidth(10);
        patients.getColumnModel().getColumn(0).setMaxWidth(50);

        patients.getColumnModel().getColumn(1).setMinWidth(50);
        patients.getColumnModel().getColumn(1).setMaxWidth(150);

        patients.getColumnModel().getColumn(2).setMinWidth(50);
        patients.getColumnModel().getColumn(2).setMaxWidth(150);

        patients.getColumnModel().getColumn(3).setMinWidth(50);
        patients.getColumnModel().getColumn(3).setMaxWidth(150);

        patients.getColumnModel().getColumn(4).setMinWidth(50);
        patients.getColumnModel().getColumn(4).setMaxWidth(150);

        patients.getColumnModel().getColumn(5).setMinWidth(50);
        patients.getColumnModel().getColumn(5).setMaxWidth(150);



        jPanel.add(gm);
        jPanel.add(mc);
        jPanel.add(ad);
        jPanel.add(sr);

        SwingUtilities.invokeLater((new Runnable() {
            public void run() {
                new GUI3();
            }
        }));
        jFrame.setVisible(true);


        jPanel.revalidate();
    }

}