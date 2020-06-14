package com.medicalcorp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main extends JFrame  {
    String salt = "sol";
    static BDW1 worker = new BDW1();
    static String Email;
    public void GUI1()  {
        JFrame window1 = getFrame();
        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        JLabel mc = new JLabel("MEDICAL CORP");
        mc.setFont(new Font("Verdana", Font.PLAIN, 25));
        mc.setBounds(271, 50, 200, 40);
        JButton button1 = new JButton("ВОЙТИ");
        button1.setBounds(325, 350, 85, 40);
        JTextField pole1 = new JTextField("");
        pole1.setBounds(220, 150, 300, 40);
        pole1.setFont(new Font("Verdana", Font.PLAIN, 16));
        JTextField pole2 = new JPasswordField("");
        pole2.setBounds(220, 250, 300, 40);
        pole2.setFont(new Font("Verdana", Font.PLAIN, 16));
        Label lab1 = new Label("Имя пользователя");
        lab1.setFont(new Font("Verdana", Font.PLAIN, 16));
        lab1.setBounds(220, 110, 200, 40);
        Label lab2 = new Label("Пароль");
        lab2.setFont(new Font("Verdana", Font.PLAIN, 16));
        lab2.setBounds(220, 210, 200, 40);

        panel1.add(mc);
        panel1.add(lab1);
        panel1.add(pole1);
        panel1.add(lab2);
        panel1.add(pole2);
        panel1.add(button1);
        window1.add(panel1);


        button1.addActionListener(new ActionListener() {


                                      @Override
                                      public void actionPerformed(ActionEvent e) {
                                           Email = pole1.getText() ;

                                          try {

                                              Statement statement = worker.getConnection().createStatement();


                                              String querry = "select password from users where email = '" + pole1.getText()+"'" ;
                                              ResultSet resultSet = statement.executeQuery(querry);
                                              resultSet.next();
                                              String pas1 = resultSet.getString("password");
                                              String pas13 = pas1+salt;
                                              int pas12 = pas13.hashCode();
                                              String pas2 = pole2.getText();
                                              String pas23 = pas2+salt;
                                              int pas22 = pas23.hashCode();
                                              resultSet.close();
//                                              ResultSet resultSet1 = statement.executeQuery();

                                              if (pas12 == pas22) {
                                                  dispose();
                                                  window1.setVisible(false);
                                                  new GUI2();
                                              }
                                              else {
                                                  String messageerror = "Неверный пароль";
                                                  JOptionPane.showMessageDialog(null,messageerror,"Ошибка",JOptionPane.PLAIN_MESSAGE);
                                              }
                                          } catch (SQLException ex) {
                                              ex.printStackTrace();
                                          }

                                      }
                                  }

        );

        pack();


    }

public String getEmail() {
        return Email;
    }




    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {

                new Main().GUI1();

            }
        });

    }


    public static JFrame getFrame() {
        JFrame window1 = new JFrame();
        window1.setVisible(true);
        window1.setDefaultCloseOperation(window1.EXIT_ON_CLOSE);
        window1.setSize(800, 500);
        window1.setResizable(false);
        window1.setLocationRelativeTo(null);
        return window1 ;
    }


}


