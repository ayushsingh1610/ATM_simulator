package com.atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class balance extends JFrame implements ActionListener {
    JLabel tittle, info;
    JButton backbtn;
    long amt;
    balance()
    {
        setTitle("Balance Enquiry");
        setLayout(null);

        tittle = new JLabel("Balance Equiry : ");
        tittle.setBounds(225,50,500,40);
        tittle.setForeground(Color.WHITE);
        tittle.setFont(new Font("System", Font.BOLD,30));
        add(tittle);

        try{
            conn con = new conn();
            String query1 = "SELECT * FROM amount;";
            ResultSet rs = con.s.executeQuery(query1);
            if(rs.next()){
                amt = Long.parseLong(rs.getString("amt"));
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Amount Not Fetched.");
            }
        }
        catch (Exception exception)
        {
            System.out.println(exception);
        }

        info = new JLabel("Your Balance is : Rs. " + amt);
        info.setBounds(200,150,300,30);
        info.setFont(new Font("Osward",Font.BOLD,20));
//      info.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        info.setForeground(Color.white);
        add(info);

        backbtn = new JButton("Back");
        backbtn.setBounds(250,250,150,30);
        backbtn.setFont(new Font("Osward",Font.BOLD,15));
        backbtn.setForeground(Color.BLACK);
        backbtn.setBackground(Color.WHITE);
        backbtn.setBorder(BorderFactory.createLineBorder(Color.white));
        backbtn.addActionListener(this);
        add(backbtn);

        getContentPane().setBackground(Color.BLACK);
        setSize(800,600);
        setLocation(400,50);
        setVisible(true);

    }

    public static void main(String[] args) {
        new balance();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backbtn)
        {
            setVisible(false);
            new transaction().setVisible(true);
        }
    }
}
