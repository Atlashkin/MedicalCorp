package com.medicalcorp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


class GUI4 {
    static JFrame jFrame = Main.getFrame();

    Statement statement = Main.worker.getConnection().createStatement();
    public GUI4() throws Exception{
        JPanel jPanel = new JPanel();
        jFrame.add(jPanel);
        jPanel.setLayout(null);

        JLabel pat = new JLabel("Пациент:");
        pat.setFont( new Font("Verdana", Font.PLAIN, 12));
        pat.setBounds(20, 5, 400, 50);

        JTextField patText = new JTextField(100);
        patText.setBounds(150, 15, 250, 30);

        JTextField patIDText = new JTextField(30);
        patIDText.setBounds(410, 15, 30, 30);
        jPanel.add(patIDText);
        JLabel dr = new JLabel("Дата рождения:");
        dr.setFont( new Font("Verdana", Font.PLAIN, 12));
        dr.setBounds(20, 45, 400, 50);

        JTextField drText = new JTextField(100);
        drText.setBounds(150, 55, 250, 30);

        JLabel adr = new JLabel("Адрес:");
        adr.setFont( new Font("Verdana", Font.PLAIN, 12));
        adr.setBounds(20, 85, 400, 50);

        JTextField adrText = new JTextField(100);
        adrText.setBounds(150, 95, 250, 30);



        JLabel dia = new JLabel("Диагноз:");
        dia.setFont( new Font("Verdana", Font.PLAIN, 12));
        dia.setBounds(20, 325, 400, 50);

        JTextArea diaText = new JTextArea();
        diaText.setLineWrap(true);
        diaText.setWrapStyleWord(true);
        JScrollPane srr = new JScrollPane(diaText);
        srr.setBounds(150, 320, 400, 60);




        JLabel med = new JLabel("Результат осмотра:");
        med.setFont( new Font("Verdana", Font.PLAIN, 12));
        med.setBounds(20, 225, 400, 50);
        JTextArea osText = new JTextArea();
        osText.setLineWrap(true);
        osText.setWrapStyleWord(true);
        JScrollPane scrrr = new JScrollPane(osText);
        scrrr.setBounds(150, 220, 400, 60);




        JButton gm = new JButton("Главное меню");
        gm.setFont( new Font("Verdana", Font.PLAIN, 10));
        gm.setBounds(630, 15, 120, 30);

        gm.addActionListener(new ActionListener() { //кнопка главного меню
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
                jFrame.setVisible(false);
                GUI3.jFrame3.dispose();
                GUI3.jFrame3.setVisible(false);
                GUI2.jFrame2.show();
                GUI2.jFrame2.setVisible(true);

            }
        });

        JButton back = new JButton("Назад");
        back.setFont( new Font("Verdana", Font.PLAIN, 10));
        back.setBounds(630, 55, 120, 30);

        back.addActionListener(new ActionListener() { //кнопка главного меню
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
                jFrame.setVisible(false);
                GUI3.jFrame3.show();
                GUI3.jFrame3.setVisible(true);

            }
        });



        JButton save = new JButton("Сохранить");
        save.setFont( new Font("Verdana", Font.PLAIN, 10));
        save.setBounds(630, 400, 120, 30);

        save.addActionListener(new ActionListener() { //кнопка главного меню
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
                jFrame.setVisible(false);
                GUI3.jFrame3.setVisible(true);

                String str1,str2,str3,str4,str5,str6;
                str1 = patText.getText();
                str2 = drText.getText();
                str3 = adrText.getText();
                str4 = diaText.getText();
                str5 = osText.getText();
                str6 = patIDText.getText();
                try {
                    statement.executeUpdate("INSERT INTO user ( name, birthdate) VALUES ('"+str1+"','"+str2+"')");
                    ResultSet resultSet = statement.executeQuery("SELECT id FROM user where name = '"+str1+"'");
                    resultSet.next();
                    int in1 = resultSet.getInt("id");
                    resultSet.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                try {
                    statement.executeUpdate("INSERT INTO clinical_record (id, patient, doctor, conclusion) VALUES ('"+str6+"','"+str6+"',2,'"+str5+"')");
                    statement.executeUpdate("INSERT INTO clinical_record__diagnosis ( clinical_record, diagnosis) VALUES ('"+str6+"','"+str4+"')");

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        });










        jPanel.add(gm);
        jPanel.add(pat);
        jPanel.add(patText);
        jPanel.add(back);
        jPanel.add(srr);
        jPanel.add(save);
        jPanel.add(scrrr);
        jPanel.add(dr);
        jPanel.add(drText);
        jPanel.add(adr);
        jPanel.add(adrText);

        jPanel.add(dia);
//        jPanel.add(diaText);
        jPanel.add(med);





        jPanel.revalidate();
    }

}