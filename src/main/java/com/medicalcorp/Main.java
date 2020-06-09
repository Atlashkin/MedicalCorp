package com.medicalcorp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        String salt = "sol";
        BDW1 worker = new BDW1();

        JFrame window1 = getFrame();
        JPanel panel1 = new JPanel();
        window1.add(panel1);
        panel1.setLayout(null);
        JLabel mc = new JLabel("MEDICAL CORP");
        mc.setFont( new Font("Verdana", Font.PLAIN, 25));
        mc.setBounds(271, 50, 200, 40);
        JButton button1 = new JButton("ВОЙТИ");
        button1.setBounds(325, 350, 85, 40);
        JTextField pole1 = new JTextField("");
        pole1.setBounds(220, 150, 300, 40);
        pole1.setFont( new Font("Verdana", Font.PLAIN, 16));
        JTextField pole2 = new JPasswordField("");
        pole2.setBounds(220, 250, 300, 40);
        pole2.setFont( new Font("Verdana", Font.PLAIN, 16));
        Label lab1 = new Label("Имя пользователя");
        lab1.setFont( new Font("Verdana", Font.PLAIN, 16));
        lab1.setBounds(220, 110, 200, 40);
        Label lab2 = new Label("Пароль");
        lab2.setFont( new Font("Verdana", Font.PLAIN, 16));
        lab2.setBounds(220, 210, 200, 40);

        panel1.add(mc);
        panel1.add(lab1);
        panel1.add(pole1);
        panel1.add(lab2);
        panel1.add(pole2);
        panel1.add(button1);
        panel1.revalidate();

        JFrame mn = new JFrame("MEDICAL CORP");
        mn.setVisible(true);
        mn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mn.setSize(800, 500);
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
        mn.setVisible(false);

        try {
            Statement statement = worker.getConnection().createStatement();

           button1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    String querry = "select userpass from authorization where username = '" + pole1.getText()+"'" ;

                    try {

                        ResultSet resultSet = statement.executeQuery(querry);
                        resultSet.next();
                        System.out.println(resultSet.getString("userpass"));
                        System.out.println(pole2.getText());
                        String pas1 = resultSet.getString("userpass");
                        String pas13 = pas1+salt;
                        int pas12 = pas13.hashCode();
                        String pas2 = pole2.getText();
                        String pas23 = pas2+salt;
                        int pas22 = pas23.hashCode();
                        System.out.println(pas12);
                        if (pas12 == pas22) {
                            System.out.println("OK");
                            window1.setVisible(false);
                            mn.setVisible(true);
                        }
                        else {
                            String messageerror = "Неверный пароль";
                            JOptionPane.showMessageDialog(null,messageerror,"Ошибка",JOptionPane.PLAIN_MESSAGE);
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static JFrame getFrame() {
            JFrame window1 = new JFrame();
            window1.setVisible(true);
            window1.setDefaultCloseOperation(window1.EXIT_ON_CLOSE);
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Dimension dimension = toolkit.getScreenSize();
            window1.setBounds(dimension.width / 2 - 400, dimension.height / 2 - 250, 800, 500);
            window1.setTitle("MedicalCorp.");
            return window1;
    }

}
