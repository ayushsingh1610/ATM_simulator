package com.atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class signupTwo extends JFrame implements ActionListener {
    JLabel religion,category , income, education, occupation, pan, aadharnum, seniorcitizen, existing;
    JComboBox religionbox,categorybox, incomebox, educationbox,occupationbox;
    JTextField pantext, aadhartext;

    JRadioButton sbtn1,sbtn2,exist1,exist2;
    ButtonGroup seniorbtng, existbtng;

    JButton submit;

    signupTwo()
    {
        setTitle("Sign Up Page 2");
        setLayout(null);

        JLabel tittle = new JLabel("2.  Additional Details");
        tittle.setBounds(200,25,500,35);
        tittle.setFont(new Font("Osward", Font.BOLD,30));
        add(tittle);




        // Religion
        religion = new JLabel("Religion : ");
        religion.setBounds(100,150,200,25);
        religion.setFont(new Font("Osward", Font.BOLD,20));
        add(religion);
        String religionarr[] = {"- Select -","Hindu","Muslim","Sikh","Christian"};
        religionbox = new JComboBox(religionarr);
        religionbox.setBounds(300,150,200,25);
        religionbox.setFont(new Font("Osward",Font.PLAIN, 15));
        add(religionbox);
        //_________________________________________________________________

        //Income
        income = new JLabel("Income : ");
        income.setBounds(100,200,200,25);
        income.setFont(new Font("Osward", Font.BOLD,20));
        add(income);

        String incomearr[] = {"- Select -","Upto 100000","100000 - 300000", "300000 - 500000", "500000 - 1000000"};
        incomebox = new JComboBox(incomearr);
        incomebox.setBounds(300,200,200,25);
        incomebox.setFont(new Font("Osward",Font.PLAIN, 15));
        add(incomebox);
        //___________________________________________________________________

        //Category
        category = new JLabel("Category : ");
        category.setBounds(100,250,200,25);
        category.setFont(new Font("Osward", Font.BOLD,20));
        add(category);

        String categoryarr[] = {"- Select -","Unreserved", "Other Backward Class(OBC)", "SC", "ST"};

        categorybox = new JComboBox(categoryarr);
        categorybox.setBounds(300,250,200,25);
        categorybox.setFont(new Font("Osward",Font.PLAIN, 15));
        add(categorybox);
        //_____________________________________________________________________

        //Education
        education = new JLabel("Education : ");
        education.setBounds(100,300,200,25);
        education.setFont(new Font("Osward", Font.BOLD,20));
        add(education);

        String educationarr[] = {"- Select -","Illiterate","10th Pass", "12th Pass", "Graduate", "Post Graduate", "Doctorate" };

        educationbox = new JComboBox(educationarr);
        educationbox.setBounds(300,300,200,25);
        educationbox.setFont(new Font("Osward",Font.PLAIN, 15));
        add(educationbox);
        //______________________________________________________________________

        //Occupation
        occupation = new JLabel("Occupation : ");
        occupation.setBounds(100,350,200,25);
        occupation.setFont(new Font("Osward", Font.BOLD,20));
        add(occupation);

        String occupationarr[] = {"- Select -","UnEmployed","Salaried(Government)", "Freelance","Business", "Agency", "Private Job"};

        occupationbox = new JComboBox(occupationarr);
        occupationbox.setBounds(300,350,200,25);
        occupationbox.setFont(new Font("Osward",Font.PLAIN, 15));
        add(occupationbox);

        //________________________________________________________________________

        // PAN number
        pan = new JLabel("PAN Number : ");
        pan.setBounds(100,400,200,25);
        pan.setFont(new Font("Osward", Font.BOLD,20));
        add(pan);

        pantext = new JTextField();
        pantext.setBounds(300,400,200,25);
        pantext.setFont(new Font("Osward", Font.PLAIN, 15));
        add(pantext);
        //___________________________________________________________________________


        // Aadhar Number
        aadharnum = new JLabel("Aadhar Number : ");
        aadharnum.setBounds(100,450,200,25);
        aadharnum.setFont(new Font("Osward", Font.BOLD,20));
        add(aadharnum);

        aadhartext = new JTextField();
        aadhartext.setBounds(300,450,200,25);
        aadhartext.setFont(new Font("Osward", Font.PLAIN, 15));
        add(aadhartext);
        //_____________________________________________________________________________

        // Senior Citizen
        seniorcitizen = new JLabel("Senior Citizen : ");
        seniorcitizen.setBounds(100,500,200,25);
        seniorcitizen.setFont(new Font("Osward", Font.BOLD,20));
        add(seniorcitizen);

        sbtn1 = new JRadioButton("Yes");
        sbtn1.setBounds(300,500,75,25);
        sbtn1.setBackground(Color.WHITE);

        sbtn2 = new JRadioButton("NO");
        sbtn2.setBounds(400,500,75,25);
        sbtn2.setBackground(Color.WHITE);

        seniorbtng = new ButtonGroup();
        seniorbtng.add(sbtn1);
        seniorbtng.add(sbtn2);
        add(sbtn1);
        add(sbtn2);

        //______________________________________________________________________________


        // Existing Account
        existing = new JLabel("Existing Account : ");
        existing.setBounds(100,550,200,25);
        existing.setFont(new Font("Osward", Font.BOLD,20));
        add(existing);

        exist1 = new JRadioButton("Yes");
        exist1.setBounds(300,550,75,25);
        exist1.setBackground(Color.WHITE);

        exist2 = new JRadioButton("NO");
        exist2.setBounds(400,550,75,25);
        exist2.setBackground(Color.WHITE);

        existbtng = new ButtonGroup();
        existbtng.add(exist1);
        existbtng.add(exist2);
        add(exist1);
        add(exist2);
        //_________________________________________________________________________________________

        //Submit Button
        submit = new JButton("Submit");
        submit.setBounds(200,625,200,30);
        setFont(new Font("Osward", Font.BOLD,25));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);


        getContentPane().setBackground(Color.WHITE);
        setSize(900,800);
        setVisible(true);
        setLocation(350,20);
    }
    public static void main(String[] args) {
        new signupTwo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String p = pantext.getText();
        String aa = aadhartext.getText();
        String r = (String)religionbox.getSelectedItem();
        String c = (String)categorybox.getSelectedItem();
        String i = (String)incomebox.getSelectedItem();
        String edu = (String)educationbox.getSelectedItem();
        String occ = (String)occupationbox.getSelectedItem();

        String sen = null;
        if(sbtn1.isSelected())  {   sen = "Yes";    }
        else if(sbtn2.isSelected())     {   sen = "NO";  }

        String ex = null;
        if(exist1.isSelected()){
            ex = "Yes";
        }
        else if(exist2.isSelected()){
            ex = "NO";
        }

        try{
            if(p == null || aa == null || r == null || c == null || i == null || edu == null || occ == null || sen == null || ex == null) {
                JOptionPane.showMessageDialog(null, "Please Fill the required details.");
                setVisible(true);
            }
            else {
                conn con = new conn();
                String query =
                        "INSERT INTO form2 VALUES ('" + r + "' , '" + c + "' , '" + i + "' , '" + edu + "' , '" + occ +
                                "' , '" + p + "' ,'" + aa + "' , '" + sen + "' , '" + ex + "' );";

                con.s.execute(query);
                setVisible(false);
                new signupThree().setVisible(true);
            }
        }
        catch(Exception exception)
        {
            System.out.println(exception);
        }


    }
}
