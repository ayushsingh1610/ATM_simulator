package com.atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class changepin extends JFrame implements ActionListener {
    JLabel tittle, oldpin, pin, newpin;
    JTextField oldpintext, pintext, newpintext;
    JButton submitbtn, backbtn;
    changepin()
    {
        setTitle("Change PIN");
        setLayout(null);

        tittle = new JLabel("Change Old pin ");
        tittle.setBounds(100,25,500,40);
        tittle.setForeground(Color.WHITE);
        tittle.setFont(new Font("System", Font.BOLD,30));
        add(tittle);

        oldpin = new JLabel("Enter new pin : ");
        oldpin.setBounds(100,100,200,30);
        oldpin.setForeground(Color.WHITE);
        oldpin.setFont(new Font("System", Font.BOLD,15));
        add(oldpin);

        pin = new JLabel("Enter new pin : ");
        pin.setBounds(100,150,200,30);
        pin.setForeground(Color.WHITE);
        pin.setFont(new Font("System", Font.BOLD,15));
        add(pin);

        newpin = new JLabel("Re - enter your new pin : ");
        newpin.setBounds(100,200,200,30);
        newpin.setForeground(Color.WHITE);
        newpin.setFont(new Font("System", Font.BOLD,15));
        add(newpin);

        oldpintext = new JTextField();
        oldpintext.setBounds(300,100,200,30);
        oldpintext.setForeground(Color.BLACK);
        oldpintext.setBorder(BorderFactory.createLineBorder(Color.white));
        oldpintext.setFont(new Font("System", Font.PLAIN, 15));
        add(oldpintext);

        pintext = new JTextField();
        pintext.setBounds(300,150,200,30);
        pintext.setForeground(Color.BLACK);
        pintext.setBorder(BorderFactory.createLineBorder(Color.white));
        pintext.setFont(new Font("System", Font.PLAIN, 15));
        add(pintext);

        newpintext = new JTextField();
        newpintext.setBounds(300,200,200,30);
        newpintext.setForeground(Color.BLACK);
        newpintext.setBorder(BorderFactory.createLineBorder(Color.white));
        newpintext.setFont(new Font("System", Font.PLAIN, 15));
        add(newpintext);

        submitbtn = new JButton("Submit");
        submitbtn.setBounds(200,275,100,30);
        submitbtn.setFont(new Font("Osward",Font.BOLD,15));
        submitbtn.setForeground(Color.white);
        submitbtn.setBackground(Color.black);
        submitbtn.setBorder(BorderFactory.createLineBorder(Color.white));
        submitbtn.addActionListener(this);
        add(submitbtn);

        backbtn = new JButton("Back");
        backbtn.setBounds(350,275,100,30);
        backbtn.setFont(new Font("Osward",Font.BOLD,15));
        backbtn.setForeground(Color.white);
        backbtn.setBackground(Color.black);
        backbtn.setBorder(BorderFactory.createLineBorder(Color.white));
        backbtn.addActionListener(this);
        add(backbtn);

        getContentPane().setBackground(Color.BLACK);
        setSize(800,600);
        setLocation(500,50);
        setVisible(true);

    }

    public static void main(String[] args) {
        new changepin();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String op = oldpintext.getText();
        String p = pintext.getText();
        String np = newpintext.getText();

        if(e.getSource()==submitbtn){
            if (!p.equals(np)) {
                JOptionPane.showMessageDialog(null, "Both PIN does not match.");
            } else {
                try {
                    conn con = new conn();
                    String query = "UPDATE login SET Card_Pin = " + np + " WHERE Card_Pin = " + op + ";";
                    con.s.execute(query);

                    setVisible(false);
                    new transaction().setVisible(true);
                } catch (Exception exception) {
                    System.out.println(exception);
                }
            }
        } else if (e.getSource()==backbtn) {
            setVisible(false);
            new transaction().setVisible(true);
        }
    }
}
