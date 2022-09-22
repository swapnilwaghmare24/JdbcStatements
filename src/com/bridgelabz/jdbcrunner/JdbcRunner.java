package com.bridgelabz.jdbcrunner;

import com.bridgelabz.jdbcconnection.JdbcConnection;

public class JdbcRunner
{
    public static void main(String[] args)
    {
        JdbcConnection jdbcConnection = new JdbcConnection();
        jdbcConnection.getConnection();
    }
}
