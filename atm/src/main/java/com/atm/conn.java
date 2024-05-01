package com.atm;

import java.sql.*;
public class conn {
    Connection c;
    Statement s;
    conn()
    {
        try
        {
            //1. Register the Driver
            //Class.forName(com.mysql.cj.jdbc.Drivers);

            //2. Creating the connection
            c = DriverManager.getConnection("jdbc:mysql:///ATM_Simulator","root","root@12345");

            //3.
            s = c.createStatement();



        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

}
