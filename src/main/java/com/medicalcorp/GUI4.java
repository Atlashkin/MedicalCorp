package com.medicalcorp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class GUI4 {
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

        JLabel pat = new JLabel("Пациент:");
        pat.setFont( new Font("Verdana", Font.PLAIN, 12));
        pat.setBounds(20, 5, 400, 50);

        JTextField patText = new JTextField(100);
        patText.setBounds(90, 15, 250, 30);

        JLabel dr = new JLabel("Дата рождения:");
        dr.setFont( new Font("Verdana", Font.PLAIN, 12));
        dr.setBounds(20, 45, 400, 50);

        JTextField drText = new JTextField(100);
        drText.setBounds(150, 55, 250, 30);

        JLabel adr = new JLabel("Адрес:");
        adr.setFont( new Font("Verdana", Font.PLAIN, 12));
        adr.setBounds(20, 85, 400, 50);

        JTextField adrText = new JTextField(100);
        adrText.setBounds(90, 95, 250, 30);

        JLabel plo = new JLabel("Место осмотра:");
        plo.setFont( new Font("Verdana", Font.PLAIN, 12));
        plo.setBounds(20, 125, 400, 50);

        JTextField ploText = new JTextField(100);
        ploText.setBounds(150, 135, 250, 30);

        JLabel datao = new JLabel("Дата осмотра:");
        datao.setFont( new Font("Verdana", Font.PLAIN, 12));
        datao.setBounds(20, 165, 400, 50);

        JTextField dataoText = new JTextField(100);
        dataoText.setBounds(150, 175, 250, 30);

        JLabel dia = new JLabel("Диагноз:");
        dia.setFont( new Font("Verdana", Font.PLAIN, 12));
        dia.setBounds(20, 205, 400, 50);

        JTextField diaText = new JTextField(100);
        diaText.setBounds(90, 215, 250, 30);

        JLabel med = new JLabel("Назначенные лекарства:");
        med.setFont( new Font("Verdana", Font.PLAIN, 12));
        med.setBounds(20, 245, 400, 50);




        JButton gm = new JButton("Главное меню");
        gm.setFont( new Font("Verdana", Font.PLAIN, 10));
        gm.setBounds(630, 15, 120, 30);

        JButton back = new JButton("Назад");
        back.setFont( new Font("Verdana", Font.PLAIN, 10));
        back.setBounds(630, 55, 120, 30);

        JButton away = new JButton("Выписать");
        away.setFont( new Font("Verdana", Font.PLAIN, 10));
        away.setBounds(630, 95, 120, 30);

        JButton save = new JButton("Сохранить");
        save.setFont( new Font("Verdana", Font.PLAIN, 10));
        save.setBounds(630, 400, 120, 30);


        Object[] headers = { "№", "Название", "Способ приема", "Описание", "Побочное действие"};
        Object[][] data = {{"1", "oo", "pp", "rr", "gh"},{"1", "oo", "pp", "rr", "gh"},{"1", "oo", "pp", "rr", "gh"},{"1", "oo", "pp", "rr", "gh"},{"1", "oo", "pp", "rr", "gh"},{"1", "oo", "pp", "rr", "gh"},{"1", "oo", "pp", "rr", "gh"},{"1", "oo", "pp", "rr", "gh"},{"1", "oo", "pp", "rr", "gh"}};


        JTable medicines;
        medicines = new JTable(data, headers);
        JScrollPane sr = new JScrollPane(medicines);


        medicines.setPreferredScrollableViewportSize(new Dimension(550, 120));
        sr.setBounds(40, 300, 550, 120);
        medicines.setBounds(40, 300, 550, 120);

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
        jPanel.add(pat);
        jPanel.add(patText);
        jPanel.add(back);
        jPanel.add(away);
        jPanel.add(save);
        jPanel.add(sr);
        jPanel.add(dr);
        jPanel.add(drText);
        jPanel.add(adr);
        jPanel.add(adrText);
        jPanel.add(plo);
        jPanel.add(ploText);
        jPanel.add(datao);
        jPanel.add(dataoText);
        jPanel.add(dia);
        jPanel.add(diaText);
        jPanel.add(med);


        SwingUtilities.invokeLater((new Runnable() {
            public void run() {
                new GUI4();
            }
        }));
        jFrame.setVisible(true);


        jPanel.revalidate();
    }

}