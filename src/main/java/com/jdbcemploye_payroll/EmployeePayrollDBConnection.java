package com.jdbcemploye_payroll;

import java.sql.*;

public class EmployeePayrollDBConnection {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    void databaseConnect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/payroll_service";
        String username = "root";
        String password = "Password@121";
        System.out.println("Connecting database...");
        con = DriverManager.getConnection(url, username, password);
        System.out.println("Connection Successful:");
    }


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println("Welcome to Employee Payroll DataBase:");
        EmployeePayrollDBConnection empDBConnect = new EmployeePayrollDBConnection();
        empDBConnect.databaseConnect();
    }
}
