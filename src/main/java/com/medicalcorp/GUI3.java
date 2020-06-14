package com.medicalcorp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class GUI3  {
    static JFrame jFrame3 = Main.getFrame();


    public GUI3() throws Exception{
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

        JButton ad = new JButton("Добавить нового пациента");
        ad.setFont( new Font("Verdana", Font.PLAIN, 10));
        ad.setBounds(370, 15, 250, 30);

        ad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                jFrame3.dispose();
//                jFrame3.setVisible(false);
                try {
                    new GUI4();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                GUI4.jFrame.setVisible(true);
            }
        });

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

//        SwingUtilities.invokeLater((new Runnable() {
//            public void run() {
//                try {
//                    new GUI3();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }));
//        jFrame3.setVisible(true);


        jPanel.revalidate();
    }

}