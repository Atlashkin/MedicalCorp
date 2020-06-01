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

public class Test {

    static JFrame window1 = getFrame();
    public static void main(String[] args) {
        BDW1 worker = new BDW1();

        JPanel panel1 = new JPanel();
        window1.add(panel1);
        JButton button1 = new JButton("ВОЙТИ");
        JTextField pole1 = new JTextField("", 20);
        JTextField pole2 = new JPasswordField("", 20);
        Label lab1 = new Label("имя пользователя");
        Label lab2 = new Label("пароль");
        panel1.add(lab1);
        panel1.add(pole1);
        panel1.add(lab2);
        panel1.add(pole2);
        panel1.add(button1);
        panel1.add(new com.medicalcorp.GUI1.MyComponent());
        panel1.revalidate();


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
                        String pas2 = pole2.getText();
                        if (pas1.equals(pas2)) {
                            System.out.println("OK");
                        }
                        else {
                            String messageerror = "неверный пароль";
                            JOptionPane.showMessageDialog(null,messageerror,"error",JOptionPane.PLAIN_MESSAGE);
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

