package com.medicalcorp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class GUI5 {
    static JFrame jFrame = getFrame();
    static JFrame getFrame() {
        JFrame jFrame = new JFrame() {};
        jFrame.setSize(800, 500);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.setLocationRelativeTo(null);
        return jFrame;

    }
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
        name.setFont( new Font("Verdana", Font.PLAIN, 15));
        name.setBounds(350, 89, 250, 40);

        JLabel nameText = new JLabel(GUI2.lastname+" "+GUI2.firstname+" "+GUI2.middlename);
        nameText.setFont( new Font("Verdana", Font.PLAIN, 15));
        nameText.setBounds(400, 90, 300, 38);

        JButton log = new JButton("Изменить логин");
        log.setFont( new Font("Verdana", Font.PLAIN, 15));
        log.setBounds(350, 140, 350, 36);

        JButton mail = new JButton("Изменить e-mail");
        mail.setFont( new Font("Verdana", Font.PLAIN, 15));
        mail.setBounds(350, 180, 350, 36);

        JButton pas = new JButton("Изменить пароль");
        pas.setFont( new Font("Verdana", Font.PLAIN, 15));
        pas.setBounds(350, 220, 350, 36);

        JLabel sex = new JLabel("Пол:");
        sex.setFont( new Font("Verdana", Font.PLAIN, 15));
        sex.setBounds(350, 257, 200, 40);

        ButtonGroup group = new ButtonGroup();

        JRadioButton sex1= new JRadioButton("Женский");
        sex1.setFont( new Font("Verdana", Font.PLAIN, 15));
        sex1.setBounds(400, 257, 120, 40);

        JRadioButton sex2= new JRadioButton("Мужской");
        sex2.setFont( new Font("Verdana", Font.PLAIN, 15));
        sex2.setBounds(520, 257, 120, 40);

        group.add(sex1);
        group.add(sex2);

        JLabel about = new JLabel("О себе:");
        about.setFont( new Font("Verdana", Font.PLAIN, 15));
        about.setBounds(350, 290, 200, 40);

        JTextField aboutText = new JTextField(20);
        aboutText.setFont( new Font("Verdana", Font.PLAIN, 15));
        aboutText.setBounds(350, 325, 350, 60);

        // ImageIcon icon = createIcon("images/settings.jpg");
        //  JLabel photo = new JLabel(icon);
        // photo.setBounds(10,10,60, 70);

        JButton save = new JButton("Сохранить");
        save.setFont( new Font("Verdana", Font.PLAIN, 10));
        save.setBounds(100, 340, 150, 36);


        jPanel.add(gm);
        jPanel.add(mc);
        jPanel.add(name);
        jPanel.add(nameText);
//        jPanel.add(log);
        jPanel.add(mail);
        jPanel.add(pas);
        jPanel.add(sex);
        jPanel.add(sex1);
        jPanel.add(sex2);
        jPanel.add(about);
        jPanel.add(aboutText);
        jPanel.add(save);

        jPanel.revalidate();
        jFrame.setVisible(true);

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

//        log.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                jFrame.dispose();
//                jFrame.setVisible(false);
//                try {
//                    new GUI51();
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
//                GUI51.jFrame.setVisible(true);
//            }
//        });

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
    }




}