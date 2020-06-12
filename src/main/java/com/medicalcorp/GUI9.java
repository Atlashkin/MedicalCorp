import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class GUI9 {
    static JFrame jFrame = getFrame();
    static JFrame getFrame() {
        JFrame jFrame = new JFrame() {};

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
        JLabel mc = new JLabel("ПОИСК ПАЦИЕНТОВ");
        mc.setFont( new Font("Verdana", Font.PLAIN, 25));
        mc.setBounds(20, 5, 400, 50);

        JButton gm = new JButton("Главное меню");
        gm.setFont( new Font("Verdana", Font.PLAIN, 10));
        gm.setBounds(630, 15, 120, 30);



        JLabel data = new JLabel("Введите дату:");
        data.setBounds(220, 115, 200, 40);

        JTextField dataText = new JTextField(20);
        dataText.setBounds(340, 120, 150, 30);

        JButton ok1 = new JButton("ОК");
        ok1.setFont( new Font("Verdana", Font.PLAIN, 10));
        ok1.setBounds(500, 117, 50, 36);

        JLabel num1 = new JLabel("Количество вызовов:");
        num1.setBounds(220, 165, 200, 30);

        JTextField num1Text = new JTextField(20);
        num1Text.setBounds(360, 168, 70, 30);


        JLabel call = new JLabel("Введите диагноз:");
        call.setBounds(220, 235, 200, 40);

        JTextField callText = new JTextField(20);
        callText.setBounds(340, 240, 150, 30);

        JButton ok2 = new JButton("ОК");
        ok2.setFont( new Font("Verdana", Font.PLAIN, 10));
        ok2.setBounds(500, 237, 50, 36);

        JLabel num2 = new JLabel("Количество вызовов:");
        num2.setBounds(220, 285, 200, 40);

        JTextField num2Text = new JTextField(20);
        num2Text.setBounds(360, 288, 70, 30);


        jPanel.add(gm);
        jPanel.add(mc);
        jPanel.add(data);
        jPanel.add(dataText);
        jPanel.add(ok1);
        jPanel.add(num1);
        jPanel.add(num1Text);
        jPanel.add(call);
        jPanel.add(callText);
        jPanel.add(ok2);
        jPanel.add(num2);
        jPanel.add(num2Text);

        jPanel.revalidate();
        jFrame.setVisible(true);
    }




}