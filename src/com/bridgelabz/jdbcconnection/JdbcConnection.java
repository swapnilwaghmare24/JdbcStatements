package com.bridgelabz.jdbcconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {

    public static Connection getConnection()
    {
        String jdbcPath = "jdbc:mysql://localhost:3306/payroll_service";
        String userName = "root";
        String password = "root";
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(jdbcPath, userName, password);

            System.out.println("connection success to database");
        } catch (ClassNotFoundException e) {
            System.out.println("unable to load driver class");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("unable to connect to database");
            e.printStackTrace();
        }
        return con;
    }

}
