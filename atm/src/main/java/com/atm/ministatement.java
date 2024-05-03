package com.atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ministatement extends JFrame implements ActionListener {

    JLabel l1, card, mini;
    JButton backbtn;
    String cardnumber,s;
    JTable table;
    ministatement()
    {
        setTitle("Mini Statement");
        setLayout(null);

        l1 = new JLabel("Ayush Bank");
        l1.setBounds(300,50,500,40);
        l1.setFont(new Font("Osward",Font.BOLD,30));
        l1.setForeground(Color.WHITE);
        l1.setBackground(Color.BLACK);
        add(l1);


        mini = new JLabel();
        try
        {
            conn con = new conn();
            String query1 = "SELECT * FROM statement";
            ResultSet rs = con.s.executeQuery(query1);
            while ((rs.next()))
            {
                if(rs.next())
                {
                    mini.setText(mini.getText() + "<html>  " + rs.getString(1) + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString(2) + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString(3) + "<br><br><html>");
                }
            }
        }

        catch(Exception exception)
        {
            System.out.println(exception);
        }

        card = new JLabel("Card Number :" + cardnumber);
        card.setBounds(100,120,500,30);
        card.setFont(new Font("Osward",Font.BOLD,20));
        card.setForeground(Color.WHITE);
        card.setBackground(Color.BLACK);
        add(card);

        mini.setBounds(100,135,500,600);
        mini.setFont(new Font("System",Font.PLAIN,15));
        mini.setForeground(Color.WHITE);
        mini.setBackground(Color.BLACK);
        add(mini);

        backbtn = new JButton("Back");
        backbtn.setBounds(500,700,200,30);
        backbtn.setFont(new Font("Osward",Font.BOLD,15));
        backbtn.setForeground(Color.BLACK);
        backbtn.setBackground(Color.WHITE);
        backbtn.setBorder(BorderFactory.createLineBorder(Color.white));
        backbtn.addActionListener(this);
        add(backbtn);

        getContentPane().setBackground(Color.BLACK);
        setSize(800,800);
        setLocation(450,50);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ministatement();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backbtn)
        {
            new transaction().setVisible(true);
        }
    }
}
