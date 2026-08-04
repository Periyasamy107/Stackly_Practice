package com.jdbc;

import java.sql.*;

public class SimpleJDBC {

    static final String url = "jdbc:mysql://localhost:3306/sample";
    static final String userName = "root";
    static final String password = "root";

    public static void main(String[] args) {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, userName, password);


            // INSERT / CREATE
            String insertQuery = "insert into employee(ename, esalary, ephone) values (?,?,?)";
            PreparedStatement psInsert = con.prepareStatement(insertQuery);
            psInsert.setString(1,"lina");
            psInsert.setInt(2,1550);
            psInsert.setString(3,"674563457");
            psInsert.executeUpdate();

            String insertQuery1 = "insert into employee(ename, esalary, ephone) values (?,?,?)";
            PreparedStatement psInsert1 = con.prepareStatement(insertQuery);
            psInsert1.setString(1,"sam");
            psInsert1.setInt(2,2000);
            psInsert1.setString(3,"7654567654");
            psInsert1.executeUpdate();
            System.out.println("\nInsert success.");
            psInsert.close();


            // UPDATE
            String updateQuery = "update employee set esalary = ? where id = ?";
            PreparedStatement psUpdate = con.prepareStatement(updateQuery);
            psUpdate.setInt(1,1570);
            psUpdate.setInt(2,1);
            psUpdate.executeUpdate();
            System.out.println("\nUpdate Success");
            psUpdate.close();


            // DELETE
            String deleteQuery = "delete from employee where id = ?";
            PreparedStatement psDelete = con.prepareStatement(deleteQuery);
            psDelete.setInt(1,1);
            psDelete.executeUpdate();
            System.out.println("\nDelete success");
            psDelete.close();


            // READ
            String sql = "select * from employee";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            System.out.println("\n+----+-----------------+----------+-----------------+");
            System.out.printf("| %-2s | %-15s | %-8s | %-15s |\n", "ID", "Employee Name", "Salary", "Phone");
            System.out.println("+----+-----------------+----------+-----------------+");
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int salary = rs.getInt(3);
                String phone = rs.getString(4);

                System.out.printf("| %-2d | %-15s | %-8d | %-15s |\n", id, name, salary, phone);
            }
            System.out.println("+----+-----------------+----------+-----------------+");


            con.close();

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }


    }


}
