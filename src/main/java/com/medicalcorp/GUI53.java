package com.medicalcorp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class GUI53 {
    static JFrame jFrame = getFrame();
    static JFrame getFrame() {
        JFrame jFrame = new JFrame() {};

        jFrame.setSize(500, 300);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.setLocationRelativeTo(null);
        return jFrame;

    }

    public static void main(String[] args) throws Exception{
        JPanel jPanel = new JPanel();
        jFrame.add(jPanel);
        jPanel.setLayout(null);
        JLabel mc = new JLabel("ИЗМЕНЕНИЕ E-MAIL");
        mc.setFont( new Font("Verdana", Font.PLAIN, 20));
        mc.setBounds(20, 2, 400, 50);



        JLabel passw = new JLabel("Пароль:");
        passw.setBounds(100, 55, 200, 40);

        JTextField passwText = new JTextField(20);
        passwText.setBounds(170, 60, 220, 30);


        JLabel nw = new JLabel("Новый e-mail:");
        nw.setBounds(68, 100, 200, 30);

        JTextField nwText = new JTextField(20);
        nwText.setBounds(170, 100, 220, 30);

        JLabel words = new JLabel("После нажатия кнопки «Сохранить» ваш e-mail будет изменен.");
        words.setFont( new Font("Verdana", Font.PLAIN, 13));
        words.setBounds(25, 145, 500, 40);


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
        jPanel.add(words);
        jPanel.add(save);
        jPanel.add(no);

        SwingUtilities.invokeLater((new Runnable() {
            public void run() {
                try {
                    new GUI5();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        }));

        jPanel.revalidate();
        jFrame.setVisible(true);
    }





}
