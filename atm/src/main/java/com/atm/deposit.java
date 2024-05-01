package com.atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.concurrent.ExecutionException;

public class deposit extends JFrame implements ActionListener {
    JLabel l1;
    JTextField input;
    JButton submitbtn, exitbtn;
    deposit()
    {
        setTitle("Deposit Page");
        setLayout(null);

        JLabel tittle = new JLabel("Deposit Page");
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

        exitbtn = new JButton("Exit");
        exitbtn.setBounds(300,300,75,30);
        exitbtn.setFont(new Font("Osward",Font.BOLD,15));
        exitbtn.setForeground(Color.white);
        exitbtn.setBackground(Color.black);
        exitbtn.setBorder(BorderFactory.createLineBorder(Color.white));
        exitbtn.addActionListener(this);
        add(exitbtn);


        getContentPane().setBackground(Color.BLACK);
        setLocation(500,100);
        setSize(600,500);
        setUndecorated(true);
        setVisible(true);

    }

    public static void main(String[] args) {
        new deposit();
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
                        int lastamt = Integer.parseInt(rs.getString("amt"));
                        int updateamt;
                        updateamt = lastamt + Integer.parseInt(amt);
                        String updatequery =
                                "UPDATE amount SET amt = '" + Integer.toString(updateamt) + "' WHERE amt = '" + Integer.toString(lastamt) + "';";
                        con.s.execute(updatequery);


                        String query = "INSERT INTO statement VALUES ('" + d + "', '" + amt + "', 'Deposit');";
                        con.s.execute(query);


                        JOptionPane.showMessageDialog(null, "Rs. " + amt + " is deposited in your Account.");
                        setVisible(false);
                        new transaction().setVisible(true);
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
            else if(e.getSource() == exitbtn)
            {
                new transaction().setVisible(true);
            }
        }
        catch(Exception exception) {
            JOptionPane.showMessageDialog(null,exception);
        }
    }

}
