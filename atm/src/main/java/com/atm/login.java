package com.atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class login extends JFrame implements ActionListener {

    JLabel text, cardno, pin;
    JTextField cardtext;
    JPasswordField pintext;
    JButton signinbtn,clrbtn,signupbtn;
    login()
    {
        setTitle("Automatic Teller Machine");
        setLayout(null);

        text = new JLabel("Welcome to ATM machine");
        text.setBounds(200,50,500,40);
        text.setFont(new Font("Osward", Font.BOLD,38));
        add(text);


        cardno = new JLabel("Enter Card No : ");
        cardno.setBounds(100,150,300,40);
        cardno.setFont(new Font("Osward", Font.BOLD,18));
        add(cardno);


        cardtext = new JTextField(10);
        cardtext.setBounds(400,150,250,40);
        cardtext.setFont(new Font("Osward", Font.BOLD, 18));
        add(cardtext);


        pin = new JLabel("PIN:");
        pin.setFont(new Font("Osward", Font.BOLD, 18));
        pin.setBounds(100,220,375,18);
        add(pin);


        pintext = new JPasswordField();
        pintext.setFont(new Font("Osward", Font.BOLD, 18));
        pintext.setBounds(400,220,250,40);
        pintext.setVisible(true);
        add(pintext);

        signinbtn = new JButton("Sign In");
        signinbtn.setBounds(400,300,100,30);
        signinbtn.setBackground(Color.BLACK);
        signinbtn.setForeground(Color.WHITE);
        signinbtn.setLayout(null);
        add(signinbtn);

        clrbtn = new JButton("Clear");
        clrbtn.setBounds(550,300,100,30);
        clrbtn.setBackground(Color.BLACK);
        clrbtn.setForeground(Color.WHITE);
        clrbtn.setLayout(null);
        add(clrbtn);

        signupbtn = new JButton("Sign Up");
        signupbtn.setBounds(400,350,250,30);
        signupbtn.setBackground(Color.BLACK);
        signupbtn.setForeground(Color.WHITE);
        signupbtn.setLayout(null);
        add(signupbtn);

        // Add Action Listner to Buttons
        signinbtn.addActionListener(this);
        clrbtn.addActionListener(this);
        signupbtn.addActionListener(this);

        getContentPane().setBackground(Color.WHITE);
        setSize(1000, 600);
        setLocation(350,100);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== signinbtn){
            conn con = new conn();
            String ct = cardtext.getText();
            String pt = pintext.getText();
            String query = "SELECT * FROM login WHERE Card_Num = '" + ct +"' AND Card_Pin = '"+pt+"' ;";
            try
            {
                ResultSet rs = con.s.executeQuery(query);
                if(rs.next())
                {
                    setVisible(false);
                    new transaction().setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Invaild Details.");
                }

            }
            catch(Exception exception)
            {
                System.out.println(exception);
            }
        }
        else if (e.getSource()==clrbtn) {
            cardtext.setText("");
            pintext.setText("");
        }
        else if (e.getSource()==signupbtn) {
            setVisible(false);
            new signupOne().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new login();
    }


}
