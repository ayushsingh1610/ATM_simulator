package com.atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class fast_cash extends JFrame implements ActionListener {
    JLabel l1;
    JButton btn1,btn2,btn3,btn4,btn5,btn6,backbtn;

    fast_cash()
    {
        setTitle("Fast Cash withdrawal Page");
        setLayout(null);

        JLabel tittle = new JLabel("Select Amount: ");
        tittle.setBounds(250,100,500,40);
        tittle.setFont(new Font("Osward",Font.BOLD,35));
        tittle.setForeground(Color.WHITE);
        add(tittle);

        btn1 = new JButton("Rs. 200");
        btn1.setBounds(200,200,150,30);
        btn1.setFont(new Font("Osward",Font.BOLD,15));
        btn1.setForeground(Color.BLACK);
        btn1.setBackground(Color.WHITE);
        btn1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btn1.addActionListener(this);
        add(btn1);

        btn2 = new JButton("Rs. 500");
        btn2.setBounds(400,200,150,30);
        btn2.setFont(new Font("Osward",Font.BOLD,15));
        btn2.setForeground(Color.BLACK);
        btn2.setBackground(Color.WHITE);
        btn2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btn2.addActionListener(this);
        add(btn2);

        btn3 = new JButton("Rs. 1000");
        btn3.setBounds(200,250,150,30);
        btn3.setFont(new Font("Osward",Font.BOLD,15));
        btn3.setForeground(Color.BLACK);
        btn3.setBackground(Color.WHITE);
        btn3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btn3.addActionListener(this);
        add(btn3);

        btn4 = new JButton("Rs. 2000");
        btn4.setBounds(400,250,150,30);
        btn4.setFont(new Font("Osward",Font.BOLD,15));
        btn4.setForeground(Color.BLACK);
        btn4.setBackground(Color.WHITE);
        btn4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btn4.addActionListener(this);
        add(btn4);

        btn5 = new JButton("Rs. 5000");
        btn5.setBounds(200,300,150,30);
        btn5.setFont(new Font("Osward",Font.BOLD,15));
        btn5.setForeground(Color.BLACK);
        btn5.setBackground(Color.WHITE);
        btn5.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btn5.addActionListener(this);
        add(btn5);

        btn6 = new JButton("Rs. 10000");
        btn6.setBounds(400,300,150,30);
        btn6.setFont(new Font("Osward",Font.BOLD,15));
        btn6.setForeground(Color.BLACK);
        btn6.setBackground(Color.WHITE);
        btn6.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btn6.addActionListener(this);
        add(btn6);

        backbtn = new JButton("Back");
        backbtn.setBounds(400,350,150,30);
        backbtn.setFont(new Font("Osward",Font.BOLD,15));
        backbtn.setForeground(Color.BLACK);
        backbtn.setBackground(Color.WHITE);
        backbtn.setBorder(BorderFactory.createLineBorder(Color.white));
        backbtn.addActionListener(this);
        add(backbtn);

        getContentPane().setBackground(Color.BLACK);
        setSize(800,600);
        setLocation(425,100);
        setUndecorated(true);
        setVisible(true);
    }
    public static void main(String[] args) {
        new fast_cash();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String a = "";
        Date d = new Date();
        if(e.getSource() == backbtn)
        {
            new transaction().setVisible(true);
        }
        else {
            try {
                if (e.getSource() == btn1) {
                    a += "200";
                } else if (e.getSource() == btn2) {
                    a += "500";
                } else if (e.getSource() == btn3) {
                    a += "1000";
                } else if (e.getSource() == btn4) {
                    a += "2000";
                } else if (e.getSource() == btn5) {
                    a += "5000";
                } else if (e.getSource() == btn6) {
                    a += "10000";
                } else if (e.getSource() == backbtn) {
                    new transaction().setVisible(true);
                }
                conn con = new conn();
                try {
                    String query1 = "SELECT * FROM amount;";
                    ResultSet rs = con.s.executeQuery(query1);
                    if (rs.next()) {
                        long lastamt = Long.parseLong(rs.getString("amt"));
                        if (Long.parseLong(a) >= lastamt) {
                            JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        } else {
                            long updateamt = lastamt - Long.parseLong(a);
                            String updatequery =
                                    "UPDATE amount SET amt = '" + Long.toString(updateamt) + "' WHERE amt = '" + Long.toString(lastamt) + "';";
                            con.s.execute(updatequery);

                            String query = "INSERT INTO statement VALUES ('" + d + "', '" + a + "', 'Withdrawn');";
                            con.s.execute(query);
                            JOptionPane.showMessageDialog(null, "Rs. " + a + " is withdrawn from your Account.");
                            setVisible(false);
                            new transaction().setVisible(true);
                        }
                    }
                } catch (Exception exception) {
                    System.out.println(exception);
                }

            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
