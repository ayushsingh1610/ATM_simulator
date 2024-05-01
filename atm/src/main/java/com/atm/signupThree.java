package com.atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class signupThree extends JFrame implements ActionListener {
    JLabel accounttype, cardnum, pinnum, service;
    JRadioButton acc_btn1, acc_btn2, acc_btn3, acc_btn4;
    ButtonGroup bg;
    JCheckBox ser_btn1, ser_btn2, ser_btn3, ser_btn4, ser_btn5, ser_btn6, declare;
    JTextField cardtext, pintext;
    JButton signup;

    signupThree()
    {
        setTitle("Sign Up Page 3");
        setLayout(null);

        JLabel tittle = new JLabel("3.  Addition Details");
        tittle.setBounds(200,50,500,35);
        tittle.setFont(new Font("Osward", Font.BOLD,30));
        add(tittle);

        //All Label Tags
        accounttype = new JLabel("Select Account Type : ");
        cardnum = new JLabel("Enter the Card Details :");
        pinnum = new JLabel("Enter the PIN : ");
        service = new JLabel("Enter the Service Required : ");

        // All Text Field
        cardtext = new JTextField();
        pintext = new JTextField();

        //All Radio Button
        acc_btn1 = new JRadioButton(" Saving's Account");
        acc_btn2 = new JRadioButton(" Current Account");
        acc_btn3 = new JRadioButton(" Fixed Deposit");
        acc_btn4 = new JRadioButton(" Recurring Account");

        ser_btn1 = new JCheckBox(" ATM Card");
        ser_btn2 = new JCheckBox(" Internet Banking");
        ser_btn3 = new JCheckBox(" Cheque Book");
        ser_btn4 = new JCheckBox(" Mobile Banking");
        ser_btn5 = new JCheckBox(" Email Alerts");
        ser_btn6 = new JCheckBox(" Mini Statement");
        declare = new JCheckBox("I hereby declare that the above given details are correct.");

        //Declaring Location
        accounttype.setBounds(100,150,300,30);
        acc_btn1.setBounds(100,200,200,30);
        acc_btn2.setBounds(100,250,200,30);
        acc_btn3.setBounds(400,200,200,30);
        acc_btn4.setBounds(400,250,200,30);

        cardnum.setBounds(100,350,300,30);
        cardtext.setBounds(400,350,200,30);

        pinnum.setBounds(100,400,300,30);
        pintext.setBounds(400,400,200,30);

        service.setBounds(100,450,400,30);
        ser_btn1.setBounds(100,500,200,30);
        ser_btn2.setBounds(400,500,200,30);
        ser_btn3.setBounds(100,550,200,30);
        ser_btn4.setBounds(400,550,200,30);
        ser_btn5.setBounds(100,600,200,30);
        ser_btn6.setBounds(400,600,200,30);

        declare.setBounds(100,650,600,30);

        //Set Font
        tittle.setFont(new Font("Osward", Font.BOLD,30));
        int textsize = 15;
        accounttype.setFont(new Font("Osward", Font.BOLD,20));
        acc_btn1.setFont(new Font("Osward", Font.BOLD,15));
        acc_btn2.setFont(new Font("Osward", Font.BOLD,15));
        acc_btn3.setFont(new Font("Osward", Font.BOLD,15));
        acc_btn4.setFont(new Font("Osward", Font.BOLD,15));

        cardnum.setFont(new Font("Osward", Font.BOLD,20));
        cardtext.setFont(new Font("Osward", Font.PLAIN,15));

        pinnum.setFont(new Font("Osward", Font.BOLD,20));
        pintext.setFont(new Font("Osward", Font.PLAIN,15));
        service.setFont(new Font("Osward", Font.BOLD,20));
        ser_btn1.setFont(new Font("Osward", Font.BOLD,15));
        ser_btn2.setFont(new Font("Osward", Font.BOLD,15));
        ser_btn3.setFont(new Font("Osward", Font.BOLD,15));
        ser_btn4.setFont(new Font("Osward", Font.BOLD,15));
        ser_btn5.setFont(new Font("Osward", Font.BOLD,15));
        ser_btn6.setFont(new Font("Osward", Font.BOLD,15));

        declare.setFont(new Font("Osward",Font.PLAIN,14));

        //Adding Color
        acc_btn1.setBackground(Color.WHITE);
        acc_btn2.setBackground(Color.WHITE);
        acc_btn3.setBackground(Color.WHITE);
        acc_btn4.setBackground(Color.WHITE);
        ser_btn1.setBackground(Color.WHITE);
        ser_btn2.setBackground(Color.WHITE);
        ser_btn3.setBackground(Color.WHITE);
        ser_btn4.setBackground(Color.WHITE);
        ser_btn5.setBackground(Color.WHITE);
        ser_btn6.setBackground(Color.WHITE);
        declare.setBackground(Color.WHITE);

        bg = new ButtonGroup();
        bg.add(acc_btn1);
        bg.add(acc_btn2);
        bg.add(acc_btn3);
        bg.add(acc_btn4);

        //Adding all label to frame
        add(accounttype);
        add(acc_btn1);
        add(acc_btn2);
        add(acc_btn3);
        add(acc_btn4);
        add(cardnum);
        add(cardtext);
        add(pinnum);
        add(pintext);
        add(service);
        add(ser_btn1);
        add(ser_btn2);
        add(ser_btn3);
        add(ser_btn4);
        add(ser_btn5);
        add(ser_btn6);
        add(declare);

        signup = new JButton("Sign Up ");
        signup.setBounds(300,700,125,30);
        /*signup.setFont(new Font("Osward",Font.BOLD,15));*/
        signup.setForeground(Color.WHITE);
        signup.setBackground(Color.BLACK);
        signup.addActionListener(this);
        add(signup);

        setLocation(350,35);
        setSize(900,800);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new signupThree();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String ac = " ";
        if(acc_btn1.isSelected()){
            ac = "Saving Account";
        }
        else if(acc_btn2.isSelected()){
            ac = "Current Account";
        }
        else if(acc_btn3.isSelected()){
            ac = "Fixed Deposit";
        }
        else if(acc_btn4.isSelected()){
            ac = "Recurring Deposit";
        }

        String ser = " ";
        if(ser_btn1.isSelected())
        {
            ser = ser + " ATM Card, ";
        }
        if(ser_btn2.isSelected())
        {
            ser = ser + " Internet Banking, ";
        }
        if(ser_btn3.isSelected())
        {
            ser = ser + " Cheque Book, ";
        }
        if(ser_btn4.isSelected())
        {
            ser = ser + " Mobile Banking, ";
        }
        if(ser_btn5.isSelected())
        {
            ser = ser + " Email & Sms Alerts, ";
        }
        if(ser_btn6.isSelected())
        {
            ser = ser + " Mini Statement ";
        }
        String cn = cardtext.getText();
        String p = pintext.getText();

        try
        {
            if(!declare.isSelected())
            {
                JOptionPane.showMessageDialog(null, "Please check the confirmation.");
            }
            else
            {
                conn con = new conn();
                String query = "INSERT INTO form3 VALUES ('" +ac +"' ,'" + ser + "');";
                String loginquery = "INSERT INTO login VALUES ('" + cn + "','" + p + "');";
                con.s.executeUpdate(query);
                con.s.executeUpdate(loginquery);
                setVisible(false);
                new transaction().setVisible(true);
            }
        }catch(Exception exception) {
            System.out.println(exception);
        }


    }
}
