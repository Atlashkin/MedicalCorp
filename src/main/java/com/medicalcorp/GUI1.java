package com.medicalcorp;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI1 {
    public static void main(String[] args) {
        JFrame window1 = getFrame();
//        JPanel panel1 = new JPanel();
//        window1.add(panel1);
//        JButton button1 = new JButton("ВОЙТИ");
//        JTextField pole1 = new JTextField("", 20);
//        JTextField pole2 = new JPasswordField("", 20);
//        Label lab1 = new Label("имя пользователя");
//        Label lab2 = new Label("пароль");
//        panel1.add(lab1);
//        panel1.add(pole1);
//        panel1.add(lab2);
//        panel1.add(pole2);
//        panel1.add(button1);
        window1.add(new MyComponent() );
//        panel1.revalidate();



    }
    static class MyComponent extends JComponent {
        @Override
        protected void paintComponent(Graphics g) {
            Font font = new Font("Times New Roman", Font.PLAIN , 45);
            Graphics2D g2 = (Graphics2D)g;
            g2.setFont(font);
            g2.drawString("МЕДИЦИНСКИЙ КООПЕРАТИВ",70,150);
        }
    }
    static JFrame getFrame() {
        JFrame window1 = new JFrame();
        window1.setVisible(true);
        window1.setDefaultCloseOperation(window1.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        window1.setBounds(dimension.width/2 -400, dimension.height/2 - 250 , 800, 500);
        window1.setTitle("MedicalCorp.");
        return window1;
    }

}

