package com.medicalcorp;

import java.awt.*;
import javax.swing.*;

public class GUI1 {

    JFrame window1 = getFrame();

    public static void main(String[] args) {
        JPanel panel1 = new JPanel();
        JFrame window1 = getFrame();
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
    }


    private static JFrame getFrame() {
        JFrame window1 = new JFrame();
        window1.setVisible(true);
        window1.setDefaultCloseOperation(window1.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        window1.setBounds(dimension.width/2 -400, dimension.height/2 - 250 , 800, 500);
        window1.setTitle("MedicalCorp.");
        return window1;
    }}



