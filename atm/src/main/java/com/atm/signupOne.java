package com.atm;

import com.toedter.calendar.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class signupOne extends JFrame implements ActionListener {

    JLabel name, fname, dob, gender, email, marital, address, city, state, pincode;
    JTextField nametext, fnametext, emailtext, addresstext, citytext, statetext, pintext;
    ButtonGroup gendergp, maritalgp;
    JRadioButton m, f, other, single, married;
    JDateChooser dateChooser;
    JButton nextbtn;

    signupOne() {

        setTitle("Sign Up Page 1");
        setLayout(null);

        JLabel tittle = new JLabel("1.  Application Form");
        tittle.setBounds(250, 25, 500, 35);
        tittle.setFont(new Font("System", Font.BOLD, 30));
        add(tittle);


        // NAME
        name = new JLabel("Name : ");
        name.setBounds(100, 100, 200, 25);
        name.setFont(new Font("Osward", Font.BOLD, 20));
        add(name);

        nametext = new JTextField();
        nametext.setBounds(400, 100, 200, 25);
        nametext.setFont(new Font("Osward", Font.PLAIN, 15));
        add(nametext);
        //_____________________________________________________________

        //Father's name
        fname = new JLabel("Father's name : ");
        fname.setBounds(100, 150, 200, 25);
        fname.setFont(new Font("Osward", Font.BOLD, 20));
        add(fname);

        fnametext = new JTextField();
        fnametext.setBounds(400, 150, 200, 25);
        fnametext.setFont(new Font("Osward", Font.PLAIN, 15));
        add(fnametext);

        //_______________________________________________________________

        // Date of Birth
        dob = new JLabel("Date of birth : ");
        dob.setBounds(100, 200, 200, 25);
        dob.setFont(new Font("Osward", Font.BOLD, 20));
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(400, 200, 200, 25);
        dateChooser.setForeground(Color.BLACK);
        add(dateChooser);
        //_______________________________________________________________

        // Gender
        gender = new JLabel("Gender : ");
        gender.setBounds(100, 250, 200, 25);
        gender.setFont(new Font("Osward", Font.BOLD, 20));
        add(gender);

        m = new JRadioButton("Male");
        m.setBounds(400, 250, 75, 25);
        m.setBackground(Color.WHITE);

        f = new JRadioButton("Female");
        f.setBounds(475, 250, 75, 25);
        f.setBackground(Color.WHITE);

        other = new JRadioButton("Other");
        other.setBounds(550, 250, 75, 25);
        other.setBackground(Color.WHITE);

        gendergp = new ButtonGroup();
        gendergp.add(m);
        gendergp.add(f);
        gendergp.add(other);

        add(m);
        add(f);
        add(other);

        //_______________________________________________________________

        //Email
        email = new JLabel("Email : ");
        email.setBounds(100, 300, 200, 25);
        email.setFont(new Font("Osward", Font.BOLD, 20));
        add(email);

        emailtext = new JTextField();
        emailtext.setBounds(400, 300, 200, 25);
        emailtext.setFont(new Font("Osward", Font.PLAIN, 15));
        add(emailtext);
        //_______________________________________________________________

        //Marital
        marital = new JLabel("Marital Status : ");
        marital.setBounds(100, 350, 200, 25);
        marital.setFont(new Font("Osward", Font.BOLD, 20));
        add(marital);

        single = new JRadioButton("Single");
        single.setBounds(400, 350, 100, 25);
        single.setBackground(Color.WHITE);

        married = new JRadioButton("Married");
        married.setBounds(500, 350, 100, 25);
        married.setBackground(Color.WHITE);

        maritalgp = new ButtonGroup();
        maritalgp.add(single);
        maritalgp.add(married);

        add(single);
        add(married);
        //_______________________________________________________________

        //Address
        address = new JLabel("Address : ");
        address.setBounds(100, 400, 200, 25);
        address.setFont(new Font("Osward", Font.BOLD, 20));
        add(address);

        addresstext = new JTextField();
        addresstext.setBounds(400, 400, 200, 70);
        addresstext.setFont(new Font("Osward", Font.PLAIN, 15));
        add(addresstext);

        //_______________________________________________________________

        //City
        city = new JLabel("City : ");
        city.setBounds(100, 500, 200, 25);
        city.setFont(new Font("Osward", Font.BOLD, 20));
        add(city);

        citytext = new JTextField();
        citytext.setBounds(400, 500, 200, 25);
        citytext.setFont(new Font("Osward", Font.PLAIN, 15));
        add(citytext);
        //_______________________________________________________________

        //State
        state = new JLabel("State : ");
        state.setBounds(100, 550, 200, 25);
        state.setFont(new Font("Osward", Font.BOLD, 20));
        add(state);

        statetext = new JTextField();
        statetext.setBounds(400, 550, 200, 25);
        statetext.setFont(new Font("Osward", Font.PLAIN, 15));
        add(statetext);
        //_______________________________________________________________

        //Pin Code
        pincode = new JLabel("Pin Code : ");
        pincode.setBounds(100, 600, 200, 25);
        pincode.setFont(new Font("Osward", Font.BOLD, 20));
        add(pincode);

        pintext = new JTextField();
        pintext.setBounds(400, 600, 200, 25);
        pintext.setFont(new Font("Osward", Font.PLAIN, 15));
        add(pintext);
        //_______________________________________________________________

        nextbtn = new JButton("Next");
        nextbtn.setBounds(300, 700, 200, 30);
        nextbtn.setForeground(Color.WHITE);
        nextbtn.setBackground(Color.black);
        nextbtn.addActionListener(this);
        add(nextbtn);


        getContentPane().setBackground(Color.WHITE);
        setSize(900, 800);
        setLocation(350, 20);
        setVisible(true);
    }

    public static void main(String[] args) {
        new signupOne();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String n = nametext.getText();
        String fn = fnametext.getText();

        String d = dateChooser.getDate().toString();
        String em = emailtext.getText();
        String add = addresstext.getText();
        String c = citytext.getText();
        String s = statetext.getText();
        String p = pintext.getText();

        String g = null;
        if (m.isSelected()) {
            g = "Male";
        } else if (f.isSelected()) {
            g = "Female";
        } else if (other.isSelected()) {
            g = "Other";
        }

        String marry = null;
        if (single.isSelected()) {
            marry = "Single";
        } else if (married.isSelected()) {
            marry = "Married";
        }

        try {
            if (n == null || fn == null || em == null || add == null || s == null || g == null || marry == null || c == null || p == null) {
                JOptionPane.showMessageDialog(null, "Fill All Required Fields");
                setVisible(true);
            }
            else {
                conn conn = new conn();
                String query;
                query =
                        "INSERT INTO form1 values ('" + n +"','"+ fn +"','"+ g +"','"+ d + "','"+ em +"','"+ marry +
                                "','"+ add +
                        "','"+ s +"','"+ c +"','"+ p + "');";

                conn.s.execute(query);

                setVisible(false);
                new signupTwo().setVisible(true);
            }

        } catch (Exception exception) {
            System.out.println(exception);
        }


    }
}
