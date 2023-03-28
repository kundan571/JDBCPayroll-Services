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

    void display() throws SQLException {
        Statement statement = con.createStatement();
        String query = "Select * from Employee_Payroll";
        rs = statement.executeQuery(query);
        while (rs.next()){
            System.out.println(rs.getInt("empid") + " " + rs.getString("name") + " "
              + rs.getString("gender") + " " + rs.getInt("salary") + " " + rs.getDate("start_date") +
                    " " + rs.getString("Address"));
        }
        con.close();
        System.out.println("Connection closed:");
    }
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println("Welcome to Employee Payroll DataBase:");
        EmployeePayrollDBConnection empDBConnect = new EmployeePayrollDBConnection();
        empDBConnect.databaseConnect();
        empDBConnect.display();
    }
}
