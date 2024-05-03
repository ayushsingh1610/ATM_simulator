package com.atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class withdraw extends JFrame implements ActionListener {
    JLabel l1;
    JTextField input;
    JButton submitbtn, backbtn;
    withdraw()
    {
        setTitle("Withdrawal Page");
        setLayout(null);

        JLabel tittle = new JLabel("Withdrawal Page");
        tittle.setBounds(175,50,500,40);
        tittle.setFont(new Font("Osward",Font.BOLD,35));
        tittle.setForeground(Color.white);
        add(tittle);


        l1 = new JLabel("Enter the Amount :");
        l1.setBounds(200,150,500,30);
        l1.setFont(new Font("Osward",Font.BOLD,20));
        l1.setForeground(Color.white);
        add(l1);

        input = new JTextField();
        input.setBounds(200,225,175,30);
        input.setFont(new Font("Osward",Font.PLAIN,15));
        input.setForeground(Color.white);
        input.setBackground(Color.black);
        input.setBorder(BorderFactory.createLineBorder(Color.white));
        input.addActionListener(this);
        add(input);


        submitbtn = new JButton("Submit");
        submitbtn.setBounds(200,300,75,30);
        submitbtn.setFont(new Font("Osward",Font.BOLD,15));
        submitbtn.setForeground(Color.white);
        submitbtn.setBackground(Color.black);
        submitbtn.setBorder(BorderFactory.createLineBorder(Color.white));
        submitbtn.addActionListener(this);
        add(submitbtn);

        backbtn = new JButton("Back");
        backbtn.setBounds(300,300,75,30);
        backbtn.setFont(new Font("Osward",Font.BOLD,15));
        backbtn.setForeground(Color.white);
        backbtn.setBackground(Color.black);
        backbtn.setBorder(BorderFactory.createLineBorder(Color.white));
        backbtn.addActionListener(this);
        add(backbtn);


        getContentPane().setBackground(Color.BLACK);
        setLocation(500,100);
        setUndecorated(true);
        setSize(600,500);
        setVisible(true);

    }

    public static void main(String[] args) {
        new withdraw();
    }

    public void actionPerformed(ActionEvent e)
    {
        String amt = input.getText();
        Date d = new Date();

        try
        {
            if(e.getSource() == submitbtn)
            {
                try{
                    conn con = new conn();
                    String query1 = "SELECT * FROM amount;";
                    ResultSet rs = con.s.executeQuery(query1);
                    if (rs.next()) {
                        long lastamt = Long.parseLong(rs.getString("amt"));
                        if(Long.parseLong(amt) >= lastamt)
                        {
                            JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        }
                        else{
                            long updateamt = lastamt - Long.parseLong(amt);
                            String updatequery =
                                    "UPDATE amount SET amt = '" + Long.toString(updateamt) + "' WHERE amt = '" + Long.toString(lastamt) + "';";
                            con.s.execute(updatequery);


                            String query = "INSERT INTO statement VALUES ('" + d + "', '" + amt + "', 'Withdrawn');";
                            con.s.execute(query);
                            JOptionPane.showMessageDialog(null, "Rs. " + amt + " is withdrawn from your Account.");
                            setVisible(false);
                            new transaction().setVisible(true);
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Empty");
                    }
                }
                catch (SQLException ex)
                {
                    JOptionPane.showMessageDialog(null,ex);
                }
            }
            else if(e.getSource() == backbtn)
            {
                new transaction().setVisible(true);
            }
        }
        catch(Exception exception) {
            JOptionPane.showMessageDialog(null,exception);
        }
    }

}
