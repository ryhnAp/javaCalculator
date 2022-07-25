package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Calculator implements ActionListener{
    private static final int WIDTH = 420, HEIGH = 550, FUNC_BUTTON_COUNT=8, NUM_BUTTON_COUNT=10;

    JFrame frame;
    JTextField textField;
    JButton[] numButtons = new JButton[10];
    JButton[] funcButtons = new JButton[8];
    JButton[] buttons = new JButton[16];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, eqButton, delButton, clrButton; // decimal
    JPanel panel;

    Font fonti = new Font("Ink free", Font.BOLD, 30); //button font.

    double num1 = 0,num2 = 0,res = 0;
    char operator;
//        System.out.println("#1");

    Calculator(){

        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGH);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(fonti);
        textField.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        eqButton = new JButton("=");
        delButton = new JButton("DEL");
        clrButton = new JButton("CLR");


        funcButtons[0] = addButton;
        buttons[12] = addButton;
        funcButtons[1] = subButton;
        buttons[14] = subButton;
        funcButtons[2] = mulButton;
        buttons[11] = mulButton;
        funcButtons[3] = divButton;
        buttons[7] = divButton;
        funcButtons[4] = decButton;
        buttons[3] = decButton;
        funcButtons[5] = eqButton;
        buttons[15] = eqButton;
        funcButtons[6] = delButton;
        funcButtons[7] = clrButton;

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.setBackground(Color.GRAY);

        for (int i=0; i<FUNC_BUTTON_COUNT; i++){
            funcButtons[i].addActionListener(this);
            funcButtons[i].setFont(fonti);
            funcButtons[i].setFocusable(false); //button choose
        }

        for (int i=0; i<NUM_BUTTON_COUNT; i++){
            numButtons[i] = new JButton(String.valueOf(i));
            numButtons[i].addActionListener(this);
            numButtons[i].setFont(fonti);
            numButtons[i].setFocusable(false); //button choose

            if (i > 0) buttons[(((i-1)%3)+(4*((i-1)/3)))] = numButtons[i];
        }
        buttons[13] = numButtons[0];//button "0" in all nums

        for (int i=0; i< 2*FUNC_BUTTON_COUNT; i++){
            panel.add(buttons[i]);
        }

        delButton.setBounds(50, 430, 145, 50);
        clrButton.setBounds(205, 430, 145, 50);

        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i=0; i<NUM_BUTTON_COUNT; i++){
            if (e.getSource() == numButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decButton){
            textField.setText(textField.getText().concat("."));
        }
        if (e.getSource() == addButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if (e.getSource() == subButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if (e.getSource() == mulButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if (e.getSource() == divButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if (e.getSource() == eqButton){
            num2 = Double.parseDouble(textField.getText());

            switch (operator) {
                case '+':
                    res = num1 + num2;
                    break;
                case '-':
                    res = num1 - num2;
                    break;
                case '*':
                    res = num1 * num2;
                    break;
                case '/':
                    res = num1 / num2;
                    break;
            }
            textField.setText(String.valueOf(res));
            num1 = res;
        }
        if (e.getSource() == delButton){
            String temp = textField.getText();
            textField.setText("");
            for (int i=0; i<temp.length(); i++){
                textField.setText(textField.getText()+temp.charAt(i));
            }
        }
        if (e.getSource() == clrButton){
            textField.setText("");
        }
    }
}
