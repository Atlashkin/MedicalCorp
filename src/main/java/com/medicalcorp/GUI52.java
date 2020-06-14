package com.medicalcorp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class GUI52 {
    static JFrame jFrame = getFrame();
    static JFrame getFrame() {
        JFrame jFrame = new JFrame() {};

        jFrame.setSize(500, 300);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.setLocationRelativeTo(null);
        return jFrame;

    }

    public GUI52() throws Exception{
        JPanel jPanel = new JPanel();
        jFrame.add(jPanel);
        jPanel.setLayout(null);
        JLabel mc = new JLabel("ИЗМЕНЕНИЕ ПАРОЛЯ");
        mc.setFont( new Font("Verdana", Font.PLAIN, 20));
        mc.setBounds(20, 2, 400, 50);



        JLabel passw = new JLabel("Пароль:");
        passw.setBounds(120, 55, 200, 40);

        JTextField passwText = new JTextField(20);
        passwText.setBounds(190, 60, 220, 30);

        JLabel nw = new JLabel("Новый пароль:");
        nw.setBounds(88, 100, 200, 30);

        JTextField nwText = new JTextField(20);
        nwText.setBounds(190, 101, 220, 30);

        JLabel nw1 = new JLabel("Подтверждение пароля:");
        nw1.setBounds(35, 140, 200, 30);

        JTextField nw1Text = new JTextField(20);
        nw1Text.setBounds(190, 142, 220, 30);


        JButton save = new JButton("Сохранить");
        save.setFont( new Font("Verdana", Font.PLAIN, 11));
        save.setBounds(140, 200, 100, 36);

        JButton no = new JButton("Отменить");
        no.setFont( new Font("Verdana", Font.PLAIN, 11));
        no.setBounds(250, 200, 100, 36);




        jPanel.add(mc);
        jPanel.add(passw);
        jPanel.add(passwText);
        jPanel.add(nw);
        jPanel.add(nwText);
        jPanel.add(nw1);
        jPanel.add(nw1Text);
        jPanel.add(save);
        jPanel.add(no);
        jPanel.revalidate();
       // SwingUtilities.invokeLater((new Runnable() {
       //     public void run() {
         //       try {
          //          new GUI52();
           //     } catch (Exception e1) {
            //        e1.printStackTrace();
             //   }
           // }
       // }));

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = "root";
                String email1 = passwText.getText();
                if (email.equals(email1)) {
                    jFrame.dispose();
                    jFrame.setVisible(false);
                    GUI5.jFrame.show();
                    GUI5.jFrame.setVisible(true);
                    try {

                        new GUI5();

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }


            }
        });

        no.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                jFrame.dispose();
                jFrame.setVisible(false);
                GUI5.jFrame.show();
                GUI5.jFrame.setVisible(true);
                try {

                    new GUI5();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}