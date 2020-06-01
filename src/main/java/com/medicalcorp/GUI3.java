package com.medicalcorp;

import java.awt.*;
import javax.swing.*;

class GUI3 {
    public static void main(String[] args) {
        JFrame mn = new JFrame("MEDICAL CORP");
        mn.setVisible(true);
        mn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mn.setSize(750, 500);
        mn.setResizable(false);
        mn.setLocationRelativeTo(null);

        JPanel grid = new JPanel();
        grid.setLayout(new GridLayout(7, 1, 20, 5));

        JLabel l1 = new JLabel(" ГЛАВНОЕ МЕНЮ");
        l1.setFont( new Font("Verdana", Font.PLAIN, 20));
        JButton b1 = new JButton("ПАЦИЕНТЫ" );
        JButton b2 = new JButton("ПЕРСОНАЛ" );
        JButton b3 = new JButton("БАЗА ЛЕКАРСТВ" );
        JButton b4 = new JButton("ПОИСК ПАЦИЕНТОВ" );
        JButton b5 = new JButton("ПРОФИЛЬ" );
        JLabel l2 = new JLabel("");
        grid.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        grid.add(l1);
        grid.add(b1);
        grid.add(b2);
        grid.add(b3);
        grid.add(b4);
        grid.add(b5);
        grid.add(l2);
        mn.add(grid);
    }
}