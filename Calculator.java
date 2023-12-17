package com.example.javafxprojects.SWING.Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {
    JButton[] numbutton = new JButton[10];
    JButton[] functionbutton = new JButton[8];
    JButton addbutton,subbutton,multbutton,divbutton;
    JButton delbutton,clearbutton,equibutton,decbutton;
    JPanel panel;
    Font myfont = new Font("Ink Free",Font.BOLD,30);
    JTextField text;
    double num1,num2,result;
    char operator;
    Calculator(){
        JFrame frame  = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);
        addbutton = new JButton("+");
        subbutton = new JButton("-");
        multbutton = new JButton("*");
        divbutton = new JButton("/");
        delbutton = new JButton("DELETE");
        clearbutton = new JButton("CLEAR");
        equibutton = new JButton("=");
        decbutton = new JButton(".");


        functionbutton[0] = addbutton;
        functionbutton[1] = subbutton;
        functionbutton[2] = multbutton;
        functionbutton[3] = divbutton;
        functionbutton[4] = delbutton;
        functionbutton[5] = clearbutton;
        functionbutton[6] = equibutton;
        functionbutton[7] = decbutton;
        for(int i=0;i<8;i++){
            functionbutton[i].addActionListener(this);
            functionbutton[i].setFont(myfont);
            functionbutton[i].setFocusable(false);
        }

        //--------------arrange the numbers----------------------
        for(int i=0;i<10;i++){
            numbutton[i] = new JButton(String.valueOf(i));
            numbutton[i].addActionListener(this);
            numbutton[i].setFont(myfont);
            numbutton[i].setFocusable(false);
        }

        panel = new JPanel();
        panel.setBounds(30,80,350,325);
//        panel.setBackground(Color.green);
        panel.setLayout(new GridLayout(4,4,10,10));

        panel.add(numbutton[1]);
        panel.add(numbutton[2]);
        panel.add(numbutton[3]);
        panel.add(addbutton);
        panel.add(numbutton[4]);
        panel.add(numbutton[5]);
        panel.add(numbutton[6]);
        panel.add(subbutton);
        panel.add(numbutton[7]);
        panel.add(numbutton[8]);
        panel.add(numbutton[9]);
        panel.add(multbutton);
        panel.add(decbutton);
        panel.add(numbutton[0]);
        panel.add(equibutton);
        panel.add(divbutton);

        frame.add(panel);
        delbutton.setBounds( 35,430,175,50);
        clearbutton.setBounds(225,430,145,50);
        frame.add(delbutton);
        frame.add(clearbutton);

        text = new JTextField();
        text .setBounds(30,25,350,50);
        text.setFont(myfont);
        frame.add(text);

        frame.setVisible(true);

    }

    public static void main(String[] args) {
        Calculator cal = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<10;i++){
            if(e.getSource()==numbutton[i]){
                text.setText(text.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource()==decbutton){
            text.setText(text.getText().concat("."));
        }
        if(e.getSource()==addbutton){
            num1 = Double.parseDouble(text.getText());
            text.setText("");
            operator = '+';
        }
        if(e.getSource()==subbutton){
            num1 = Double.parseDouble(text.getText());
            text.setText("");
            operator = '-';
        }
        if(e.getSource()==multbutton){
            num1 = Double.parseDouble(text.getText());
            text.setText("");
            operator = '*';
        }
        if(e.getSource()==divbutton){
            num1 = Double.parseDouble(text.getText());
            text.setText("");
            operator = '/';
        }
        if(e.getSource()==equibutton){
            num2 = Double.parseDouble(text.getText());
            text.setText("");
            switch (operator){
                case '+':
                    result = num1+num2;
                    break;
                case '-':
                    result = num1-num2;
                    break;
                case '*' : result = num1*num2;
                    break;
                case '/' : result = num1/num2;
                    break;
            }
            text.setText(text.getText().concat(String.valueOf(result)));
        }
        if(e.getSource()==delbutton){
            String str = text.getText();
            text.setText("");
            for(int i=0;i<str.length()-1;i++){
                text.setText(text.getText()+str.charAt(i));
            }
        }
        if(e.getSource()==clearbutton){
            text.setText("");
        }
    }
}
