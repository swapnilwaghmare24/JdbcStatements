package com.bridgelabz.jdbcrunner;

import com.bridgelabz.jdbcconnection.JdbcConnection;
import com.bridgelabz.payrollservice.PayrollService;

public class JdbcRunner
{
    public static void main(String[] args)
    {
        JdbcConnection jdbcConnection = new JdbcConnection();
        jdbcConnection.getConnection();
        PayrollService payrollService=new PayrollService();
        payrollService.getData();
        payrollService.updateSalaryStatement(1,5000000);
    }
}
