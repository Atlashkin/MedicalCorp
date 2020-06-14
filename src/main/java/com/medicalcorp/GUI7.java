package com.medicalcorp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class GUI7 {
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


        Object[] headers = { "№", "Название", "Способ приема", "Описание", "Побочное действие"};
        Object[][] data = {{"1", "oo", "pp", "rr", "gh"},{"1", "oo", "pp", "rr", "gh"},{"1", "oo", "pp", "rr", "gh"},{"1", "oo", "pp", "rr", "gh"},{"1", "oo", "pp", "rr", "gh"},{"1", "oo", "pp", "rr", "gh"},{"1", "oo", "pp", "rr", "gh"},{"1", "oo", "pp", "rr", "gh"},{"1", "oo", "pp", "rr", "gh"}};


        JTable medicines;
        medicines = new JTable(data, headers);
        JScrollPane sr = new JScrollPane(medicines);


        medicines.setPreferredScrollableViewportSize(new Dimension(650, 350));
        sr.setBounds(70, 70, 650, 350);
        medicines.setBounds(70, 70, 650, 350);

        //patients.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        medicines.getColumnModel().getColumn(0).setMinWidth(10);
        medicines.getColumnModel().getColumn(0).setMaxWidth(50);

        medicines.getColumnModel().getColumn(1).setMinWidth(50);
        medicines.getColumnModel().getColumn(1).setMaxWidth(150);

        medicines.getColumnModel().getColumn(2).setMinWidth(50);
        medicines.getColumnModel().getColumn(2).setMaxWidth(150);

        medicines.getColumnModel().getColumn(3).setMinWidth(50);
        medicines.getColumnModel().getColumn(3).setMaxWidth(150);

        medicines.getColumnModel().getColumn(4).setMinWidth(50);
        medicines.getColumnModel().getColumn(4).setMaxWidth(150);




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

}