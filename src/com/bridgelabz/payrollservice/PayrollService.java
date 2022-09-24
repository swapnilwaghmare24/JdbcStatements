package com.bridgelabz.payrollservice;

import com.bridgelabz.jdbcconnection.JdbcConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PayrollService {

    public void getData() {

        Connection connection = JdbcConnection.getConnection();

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from employee_tbl");

            while (rs.next()) {
                System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t"
                        + rs.getDate(3) + "\t" + rs.getString(4));
            }
            connection.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void updateSalaryStatement(int emp_id, double basic_pay) {

        Connection connection = JdbcConnection.getConnection();

        try {
            Statement st = connection.createStatement();
            double deduction = basic_pay * 0.10;
            double taxable_pay = basic_pay - deduction;
            double tax = taxable_pay * 0.20;
            double net_pay = taxable_pay - tax;
            int isUpdated = st
                    .executeUpdate("update payroll_tbl set basic_pay = "
                            + basic_pay + ", deduction = " + deduction
                            + ", taxable_pay = " + taxable_pay + "" + ", tax = "
                            + tax + ", net_pay = " + net_pay
                            + " where emp_id = " + emp_id);

            if (isUpdated == 1) {
                System.out.println("Data is updated");
            } else {
                System.out.println("Data is not updated");
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
