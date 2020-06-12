import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI1 {
    static JFrame jFrame = getFrame();
    static JFrame getFrame() {
        JFrame jFrame = new JFrame() {};

        jFrame.setSize(750, 500);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.setLocationRelativeTo(null);
        return jFrame;

    }

    public static void main(String[] args) throws Exception{
        JPanel jPanel = new JPanel();
        jFrame.add(jPanel);
        jPanel.setLayout(null);
        JLabel mc = new JLabel("MEDICAL CORP");
        mc.setFont( new Font("Verdana", Font.PLAIN, 25));
        mc.setBounds(271, 50, 200, 40);

        JLabel user = new JLabel("Введите имя пользователя:");
        user.setBounds(285, 110, 200, 40);

        JTextField userText = new JTextField(20);
        userText.setBounds(220, 150, 300, 40);

        JLabel pas = new JLabel("Введите пароль:");
        pas.setBounds(320, 210, 200, 40);

        JTextField pasText = new JTextField();
        pasText.setBounds(220, 250, 300, 40);

        JButton vhod = new JButton("Войти");
        vhod.setFont( new Font("Verdana", Font.PLAIN, 15));
        vhod.setBounds(325, 350, 85, 40);

        jPanel.add(vhod);
        jPanel.add(mc);
        jPanel.add(user);
        jPanel.add(userText);
        jPanel.add(pas);
        jPanel.add(pasText);
        jPanel.revalidate();
        jFrame.setVisible(true);
    }



}