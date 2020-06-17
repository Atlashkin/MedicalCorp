package com.medicalcorp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class GUI5 {
    static JFrame jFrame = Main.getFrame();

    public GUI5() throws Exception{
        JPanel jPanel = new JPanel();
        jFrame.add(jPanel);
        jPanel.setLayout(null);
        JLabel mc = new JLabel("ПРОФИЛЬ");
        mc.setFont( new Font("Verdana", Font.PLAIN, 25));
        mc.setBounds(20, 5, 400, 50);

        JButton gm = new JButton("Главное меню");
        gm.setFont( new Font("Verdana", Font.PLAIN, 10));
        gm.setBounds(590, 15, 120, 30);



        JLabel name = new JLabel("ФИО:");
        name.setFont( new Font("Verdana", Font.PLAIN, 20));
        name.setBounds(100, 89, 250, 40);

        JLabel nameText = new JLabel(GUI2.name);
        nameText.setFont( new Font("Verdana", Font.PLAIN, 20));
        nameText.setBounds(240, 90, 400, 38);



        JButton mail = new JButton("Изменить e-mail");
        mail.setFont( new Font("Verdana", Font.PLAIN, 15));
        mail.setBounds(30, 160, 350, 36);

        JButton pas = new JButton("Изменить пароль");
        pas.setFont( new Font("Verdana", Font.PLAIN, 15));
        pas.setBounds(400, 160, 350, 36);

        JLabel sex = new JLabel("Пол:");
        sex.setFont( new Font("Verdana", Font.PLAIN, 15));
        sex.setBounds(270, 220, 200, 40);

        ButtonGroup group = new ButtonGroup();

        JRadioButton sex1= new JRadioButton("Женский");
        sex1.setFont( new Font("Verdana", Font.PLAIN, 15));
        sex1.setBounds(310, 220, 120, 40);

        JRadioButton sex2= new JRadioButton("Мужской");
        sex2.setFont( new Font("Verdana", Font.PLAIN, 15));
        sex2.setBounds(430, 220, 120, 40);
        sex2.setSelected(true);
        group.add(sex1);
        group.add(sex2);

        JLabel about = new JLabel("О себе:");
        about.setFont( new Font("Verdana", Font.PLAIN, 15));
        about.setBounds(30, 290, 200, 40);



        JTextArea aboutText = new JTextArea();
        aboutText.setBounds(30, 325, 350, 60);
        aboutText.setLineWrap(true);
        aboutText.setWrapStyleWord(true);
        JScrollPane scrr = new JScrollPane(aboutText);
        scrr.setBounds(30, 325, 350, 60);




        JButton save = new JButton("Сохранить");
        save.setFont( new Font("Verdana", Font.PLAIN, 10));
        save.setBounds(500, 340, 150, 36);

        gm.addActionListener(new ActionListener() { //кнопка главного меню
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



        pas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
                jFrame.setVisible(false);
                try {
                    new GUI52();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                GUI52.jFrame.setVisible(true);
            }
        });

        mail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
                jFrame.setVisible(false);
                try {
                    new GUI53();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                GUI53.jFrame.setVisible(true);
            }
        });

        jPanel.add(scrr);
        jPanel.add(gm);
        jPanel.add(mc);

        jPanel.add(nameText);

        jPanel.add(mail);
        jPanel.add(pas);
        jPanel.add(sex);
        jPanel.add(sex1);
        jPanel.add(sex2);
        jPanel.add(about);
//        jPanel.add(aboutText);
        jPanel.add(save);

        jPanel.revalidate();
        jFrame.setVisible(true);


    }




}