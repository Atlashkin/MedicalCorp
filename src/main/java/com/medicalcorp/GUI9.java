package com.medicalcorp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class GUI9 {
    public static String date;
    public static String fio;
    static JFrame jFrame = getFrame();
    public static JFrame getFrame() {
        JFrame window1 = new JFrame();
        window1.setTitle("MedicalCorp.");
//        window1.setDefaultCloseOperation(window1.EXIT_ON_CLOSE);
        window1.setSize(500, 300);
        window1.setResizable(false);
        window1.setLocationRelativeTo(null);
        return window1 ;
    }

    public GUI9() {
        JPanel jPanel = new JPanel();
        jFrame.add(jPanel);
        jPanel.setLayout(null);
        JLabel mc = new JLabel("ПОИСК ПАЦИЕНТОВ");
        mc.setFont( new Font("Verdana", Font.PLAIN, 25));
        mc.setBounds(100, 5, 400, 50);

        JButton gm = new JButton("Главное меню");
        gm.setFont( new Font("Verdana", Font.PLAIN, 10));
        gm.setBounds(630, 15, 120, 30);



        JLabel data = new JLabel("По дате:");
        data.setBounds(100, 70, 200, 40);

        JTextField dataText = new JTextField(20);
        dataText.setBounds(160, 75, 150, 30);

        JButton ok1 = new JButton("ОК");
        ok1.setFont( new Font("Verdana", Font.PLAIN, 10));
        ok1.setBounds(310, 75, 50, 29);




        JLabel call = new JLabel("По ФИО:");
        call.setBounds(100, 145, 200, 40);

        JTextField callText = new JTextField(20);
        callText.setBounds(160, 150, 150, 30);

        JButton ok2 = new JButton("ОК");
        ok2.setFont( new Font("Verdana", Font.PLAIN, 10));
        ok2.setBounds(310, 150, 50, 29);

        ok1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               date = dataText.getText();
                jFrame.dispose();
                jFrame.setVisible(false);
                GUI2.jFrame2.dispose();
                try {
                    new GUI91();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                GUI91.jFrame3.setVisible(true);
            }
        });
        ok2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fio = callText.getText();
                jFrame.dispose();
                jFrame.setVisible(false);
                GUI2.jFrame2.dispose();
                try {
                    new GUI92();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                GUI92.jFrame.setVisible(true);
            }
        });





        jPanel.add(gm);
        jPanel.add(mc);
        jPanel.add(data);
        jPanel.add(dataText);
        jPanel.add(ok1);

        jPanel.add(call);
        jPanel.add(callText);
        jPanel.add(ok2);


        jPanel.revalidate();
        jFrame.setVisible(true);
    }




}