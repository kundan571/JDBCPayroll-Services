package com.jdbcemploye_payroll;

import java.sql.*;

public class EmployeePayrollDBConnection {

    static Connection con;
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
        while (rs.next()) {
            System.out.println(rs.getInt("empid") + " " + rs.getString("name") + " "
                    + rs.getString("gender") + " " + rs.getInt("salary") + " " + rs.getDate("start_date") +
                    " " + rs.getString("Address") + " " + rs.getString("basic_pay"));
        }
    }

    void update() throws SQLException {
        Statement statement = con.createStatement();
        String query = "update Employee_payroll set basic_pay = '3000000' Where name = 'satya'";
        int rowsAffected = statement.executeUpdate(query);
        System.out.println("Rows Affected: " + rowsAffected);
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println("Welcome to Employee Payroll DataBase:");
        EmployeePayrollDBConnection empDBConnect = new EmployeePayrollDBConnection();
        empDBConnect.databaseConnect();
        empDBConnect.update();
        empDBConnect.display();
        con.close();
        System.out.println("Connection closed:");
    }
}
