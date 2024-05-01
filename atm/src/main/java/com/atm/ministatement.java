package com.atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ministatement extends JFrame implements ActionListener {

    JLabel l1;
    JTable table;
    ministatement()
    {
        setTitle("Mini Statement");
        setLayout(null);

        l1 = new JLabel("Your Last Transactions are :");
        l1.setBounds(100,100,500,30);
        l1.setFont(new Font("Osward",Font.BOLD,20));
        l1.setForeground(Color.WHITE);
        l1.setBackground(Color.BLACK);
        add(l1);
        String rows[][] = new String[10][3];

        try
        {
            conn con = new conn();
            String query = "SELECT * FROM statement";
            ResultSet rs = con.s.executeQuery(query);

            while ((rs.next()))
            {
                /*System.out.print(rs.getString(1) + "    \t");
                System.out.print(rs.getString(2) + "    \t");
                System.out.print(rs.getString(3) + "    \t");
                System.out.println();*/

                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 3; j++) {
                        rows[i][j] = rs.getString(i);
                    }
                }
            }
        }

        catch(Exception exception)
        {
            System.out.println(exception);
        }
        String column[] ={"Date","Amount","Type"};
        table = new JTable(rows,column);
        table.setBounds(100,200,600,300);
        table.setFont(new Font("Osward",Font.PLAIN,15));
        table.setForeground(Color.WHITE);
        add(table);

        getContentPane().setBackground(Color.BLACK);
        setSize(800,600);
        setLocation(500,50);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ministatement();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
