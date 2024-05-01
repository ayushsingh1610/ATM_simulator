package com.atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class transaction extends JFrame implements ActionListener {
    JButton depositbtn, withdrawbtn, fastcashbtn, balancebtn, ministatementbtn, changepin, exitbtn;
    transaction()
    {
        setTitle("Transaction Page");
        setLayout(null);

        JLabel tittle = new JLabel("Transaction Page");
        tittle.setBounds(300,75,500,40);
        tittle.setFont(new Font("Osward",Font.BOLD,35));
        tittle.setForeground(Color.white);
        add(tittle);

        depositbtn = new JButton("Deposit");
        depositbtn.setBounds(200,200,200,30);
        depositbtn.setFont(new Font("Osward",Font.BOLD,15));
        depositbtn.setForeground(Color.white);
        depositbtn.setBackground(Color.black);
        depositbtn.setBorder(BorderFactory.createLineBorder(Color.white));
        depositbtn.addActionListener(this);
        add(depositbtn);

        withdrawbtn = new JButton("Withdrawal");
        withdrawbtn.setBounds(500,200,200,30);
        withdrawbtn.setFont(new Font("Osward",Font.BOLD,15));
        withdrawbtn.setForeground(Color.white);
        withdrawbtn.setBackground(Color.black);
        withdrawbtn.setBorder(BorderFactory.createLineBorder(Color.white));
        withdrawbtn.addActionListener(this);
        add(withdrawbtn);

        fastcashbtn = new JButton("Fast Cash");
        fastcashbtn.setBounds(200,300,200,30);
        fastcashbtn.setFont(new Font("Osward",Font.BOLD,15));
        fastcashbtn.setForeground(Color.white);
        fastcashbtn.setBackground(Color.black);
        fastcashbtn.setBorder(BorderFactory.createLineBorder(Color.white));
        fastcashbtn.addActionListener(this);
        add(fastcashbtn);

        balancebtn = new JButton("Balance Enquiry");
        balancebtn.setBounds(500,300,200,30);
        balancebtn.setFont(new Font("Osward",Font.BOLD,15));
        balancebtn.setForeground(Color.white);
        balancebtn.setBackground(Color.black);
        balancebtn.setBorder(BorderFactory.createLineBorder(Color.white));
        balancebtn.addActionListener(this);
        add(balancebtn);

        changepin = new JButton("Change Pin");
        changepin.setBounds(200,400,200,30);
        changepin.setFont(new Font("Osward",Font.BOLD,15));
        changepin.setForeground(Color.white);
        changepin.setBackground(Color.black);
        changepin.setBorder(BorderFactory.createLineBorder(Color.white));
        changepin.addActionListener(this);
        add(changepin);

        ministatementbtn = new JButton("Mini Statement");
        ministatementbtn.setBounds(500,400,200,30);
        ministatementbtn.setFont(new Font("Osward",Font.BOLD,15));
        ministatementbtn.setForeground(Color.white);
        ministatementbtn.setBackground(Color.black);
        ministatementbtn.setBorder(BorderFactory.createLineBorder(Color.white));
        ministatementbtn.addActionListener(this);
        add(ministatementbtn);

        exitbtn = new JButton("Exit");
        exitbtn.setBounds(500,500,200,30);
        exitbtn.setFont(new Font("Osward",Font.BOLD,15));
        exitbtn.setForeground(Color.white);
        exitbtn.setBackground(Color.black);
        exitbtn.setBorder(BorderFactory.createLineBorder(Color.white));
        exitbtn.addActionListener(this);
        add(exitbtn);

        getContentPane().setBackground(Color.BLACK);
        setSize(900,800);
        setLocation(350,25);
        setUndecorated(true);
        setVisible(true);

    }

    public static void main(String[] args) {
        new transaction();
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==depositbtn)
        {
            setVisible(false);
            new deposit().setVisible(true);
        }
        if(e.getSource()==withdrawbtn)
        {
            setVisible(false);
            new withdraw().setVisible(true);
        }
        if(e.getSource()==fastcashbtn)
        {
            setVisible(false);
            new fast_cash().setVisible(true);
        }
        if(e.getSource()==balancebtn)
        {
            setVisible(false);
            new balance().setVisible(true);
        }
        if(e.getSource()==ministatementbtn)
        {
            setVisible(false);
            new ministatement().setVisible(true);
        }
        if(e.getSource()==changepin)
        {
            setVisible(false);
            new changepin().setVisible(true);
        }
        if(e.getSource()==exitbtn)
        {
            System.exit(0);
        }
    }
}
