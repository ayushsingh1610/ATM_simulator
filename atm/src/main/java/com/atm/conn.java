package com.atm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;
public class conn {
    Connection c;
    Statement s;
    conn()
    {
        try
        {
            //1. Register the Driver
//             Class.forName(com.mysql.cj.jdbc.Drivers);

            //2. Creating the connection
//            String url = "jdbc:sql6.freesqldatabase.com///ATM_Simulator";
//            String root = "sql6703628";
//            String psd = "tdnqMY5nAA";
            c = DriverManager.getConnection("jdbc:mysql:///ATM_Simulator","root", "root@12345");

            //3.
            s = c.createStatement();



        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

}
