package Caculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MayTinh {

    public MayTinh(){
        JFrame f = new JFrame("May tinh");
        f.setLayout(new  GridLayout(4, 4));
        JPanel p = new JPanel();
        JTextField field = new JTextField();
       // field.setLayout(null);
        field.setPreferredSize(new Dimension(500, 100));
        field.setBackground(Color.pink);
        JButton clear = new JButton("clear");
        p.add(field);
        p.setBackground(Color.yellow);
        String[] str = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "+", "-", "*", "/", "="};
        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                JButton b = new JButton(str[5 * i + j]);
                b.setSize(100, 100);
                b.setBackground(Color.GRAY);
                b.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                            if (field.getText() != "" && b.getText() != "=") {
                                System.out.println(field.getText() + "" + b.getText());
                                field.setText(field.getText() + b.getText());
                        }
                        if (b.getText() == "=") {
                            int tam = PhuongThucTinhToan.CaculateString(field.getText());
                            String str = Integer.toString(tam);
                            field.setText("");
                            field.setText(str);
                        }
                    }
                });
                p.add(b);
                p.add(clear);
                clear.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (clear.getText() == "clear"){
                            field.setText("");
                        }
                    }
                });
                b.setSize(100, 100);
            }
        }
        f.add(p);
        f.setLocation(200, 200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(400, 600);
        f.setVisible(true);
    }



    public static void main(String[] args) {
            new MayTinh();

    }
}