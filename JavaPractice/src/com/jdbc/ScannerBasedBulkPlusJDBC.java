package com.jdbc;

import java.sql.*;
import java.util.Scanner;

public class ScannerBasedBulkPlusJDBC {


    static final String url = "jdbc:mysql://localhost:3306/sample";
    static final String userName = "root";
    static final String password = "root";

    public static void main(String[] args) throws ClassNotFoundException {

        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("\n====================================");
        System.out.println("    EMPLOYEE MANAGEMENT SYSTEM ");
        System.out.println("====================================");

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = null;

        try{
            connection = DriverManager.getConnection(url, userName, password);

            connection.setAutoCommit(false);

            do {

                System.out.println("1. Add / Create Employee");
                System.out.println("2. Read Employees");
                System.out.println("3. Update Employee");
                System.out.println("4. Delete Employee");
                System.out.println("5. Search Employee");
                System.out.println("6. Bulk Insert Employees");
                System.out.println("7. Exit The Program");
                System.out.print("Enter your choice : ");

                choice = scanner.nextInt();

                switch(choice) {
                    case 1:
                        addOrCreateEmployee(connection, scanner);
                        break;
                    case 2:
                        readEmployees(connection);
                        break;
                    case 3:
                        updateEmployee(connection, scanner);
                        break;
                    case 4:
                        deleteEmployee(connection, scanner);
                        break;
                    case 5:
                        searchEmployee(connection, scanner);
                        break;
                    case 6:
                        bulkInsertEmployees(connection, scanner);
                        break;
                    case 7:
                        System.out.println("Exiting ...........");
                        break;
                    default:
                        System.out.println("Please enter a valid choice.");
                }

            } while(choice != 7);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }



    public static void addOrCreateEmployee(Connection connection, Scanner scanner) throws SQLException {
        try {
            scanner.nextLine();

            String addStudent = "insert into employee1 (ename, esalary, email, edept) values (?,?,?,?)";

            PreparedStatement ps = connection.prepareStatement(addStudent);

            System.out.print("\nEnter your name : ");
            String name = scanner.nextLine();

            System.out.print("Enter your salary : ");
            double salary = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Enter your email : ");
            String email = scanner.nextLine();

            System.out.print("Enter your department : ");
            String dept = scanner.nextLine();

            ps.setString(1, name);
            ps.setDouble(2, salary);
            ps.setString(3, email);
            ps.setString(4,dept);
            ps.executeUpdate();

            connection.commit();
            System.out.println("\nAdd Employee Success...\n");

            ps.close();
        } catch (SQLException ex) {
            connection.rollback();
            System.out.println(ex.getMessage());
        }
    }


    public static void readEmployees (Connection connection) throws SQLException{

        Statement statement = connection.createStatement();
        String sql = "select * from employee1";
        ResultSet rs = statement.executeQuery(sql);

        System.out.println("\n+----+-----------------+----------+----------------------+------------+");
        System.out.printf("| %-2s | %-15s | %-8s | %-20s | %-10s |\n", "ID", "Employee Name", "Salary", "Email", "Department");
        System.out.println("+----+-----------------+----------+----------------------+------------+");
        while (rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            int salary = rs.getInt(3);
            String email = rs.getString(4);
            String dept = rs.getString(5);

            System.out.printf("| %-2d | %-15s | %-8d | %-20s | %-10s |\n", id, name, salary, email, dept);
        }
        System.out.println("+----+-----------------+----------+----------------------+------------+\n");

        rs.close();
        statement.close();

    }

    public static void updateEmployee (Connection connection, Scanner scanner) throws SQLException{
        try{
            scanner.nextLine();

            String sql = "update employee1 set ename = ?, esalary = ?, email = ?, edept = ? where id = ?";

            PreparedStatement ps = connection.prepareStatement(sql);

            System.out.print("\nEnter the ID to update : ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter your name : ");
            String name = scanner.nextLine();

            System.out.print("Enter your salary : ");
            int salary = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter your email : ");
            String email = scanner.nextLine();

            System.out.print("Enter your department : ");
            String dept = scanner.nextLine();

            ps.setString(1, name);
            ps.setDouble(2, salary);
            ps.setString(3, email);
            ps.setString(4, dept);
            ps.setInt(5, id);

            int row = ps.executeUpdate();

            if(row > 0) {
                System.out.println("\nUpdate Employee Success...\n");
            } else {
                System.out.println("\nUpdate Employee Fail, Not Found The ID...\n");
            }

            connection.commit();
            ps.close();

        } catch (SQLException ex) {
            connection.rollback();
            System.out.println(ex.getMessage());
        }
    }

    public static void deleteEmployee (Connection connection, Scanner scanner) throws SQLException{

        try{
            String selectSql = "select * from employee1 where id = ?";
            String deleteSql = "delete from employee1 where id = ?";
            System.out.print("\nEnter the ID to remove : ");
            int id = scanner.nextInt();
            scanner.nextLine();

            try (PreparedStatement psDetail = connection.prepareStatement(selectSql)) {
                psDetail.setInt(1, id);
                try (ResultSet rs = psDetail.executeQuery();) {
                    if (!rs.next()) {
                        System.out.println("\nEmployee ID not found.\n");
                        return;
                    }
                    System.out.println("Employee found : " + rs.getString("ename"));
                }
            }

            System.out.print("Are you sure you want to delete this record? (yes/no): ");
            String option = scanner.nextLine().trim();

            if (option.equalsIgnoreCase("yes")) {

                try (PreparedStatement psDelete = connection.prepareStatement(deleteSql)) {
                    psDelete.setInt(1, id);

                    int row = psDelete.executeUpdate();

                    if (row > 0) {
                        System.out.println("\nRemoved the Employee Success...\n");
                    } else {
                        System.out.println("\nRemoval Employee Fail, Not Found The ID...\n");
                    }
                }
            } else {
                System.out.println("\nDeletion cancelled by the user..\n");
            }
            connection.commit();
        } catch (SQLException ex) {
            connection.rollback();
            System.out.println(ex.getMessage());
        }
    }




    public static void searchEmployee(Connection connection, Scanner scanner) throws SQLException{
        int choice;
        do{
            System.out.println();
            System.out.println("1. Search by ID");
            System.out.println("2. Search by Name");
            System.out.println("3. Search by Department");
            System.out.println("4. Exit");
            System.out.print("Please select the option : ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> searchByID(connection, scanner);
                case 2 -> searchByName(connection, scanner);
                case 3 -> searchByDepartment(connection, scanner);
                case 4 -> System.out.println("\nExiting search functionality\n");
                default -> System.out.println("Select from 1 or 2 or 3 only.");
            }
        } while (choice != 4);
    }


    public static void searchByID(Connection connection, Scanner scanner) throws SQLException{
        String byId = "select * from employee1 where id = ?";
        PreparedStatement psByID = connection.prepareStatement(byId);

        System.out.print("\nEnter the ID : ");
        int id = scanner.nextInt();
        scanner.nextLine();

        psByID.setInt(1,id);

        ResultSet rs = psByID.executeQuery();

        if(rs.next()) {
            System.out.println("\n+----+-----------------+---------------+----------------------+------------+");
            System.out.printf("| %-2s | %-15s | %-13s | %-20s | %-10s |\n", "ID", "Employee Name", "Salary", "Email", "Department");
            System.out.println("+----+-----------------+---------------+----------------------+------------+");
            do{
                int id1 = rs.getInt("id");
                String ename = rs.getString("ename");
                double salary = rs.getDouble("esalary");
                String email = rs.getString("email");
                String dept = rs.getString("edept");
                System.out.printf("| %-2d | %-15s | %-13f | %-20s | %-10s |\n", id1, ename, salary, email, dept);
            } while(rs.next());
            System.out.println("+----+-----------------+---------------+----------------------+------------+\n");

            rs.close();
            psByID.close();
        } else {
            System.out.println("\nEmployee ID not found.\n");
        }
    }



    public static void searchByName(Connection connection, Scanner scanner) throws SQLException{
        String byName = "select * from employee1 where ename like ?";
        PreparedStatement psByName = connection.prepareStatement(byName);

        System.out.print("\nSearch by Name : ");
        String name = scanner.nextLine();

        psByName.setString(1, "%" + name + "%");

        ResultSet rsByName = psByName.executeQuery();

        if(rsByName.next()) {
            System.out.println("\n+----+-----------------+---------------+----------------------+------------+");
            System.out.printf("| %-2s | %-15s | %-13s | %-20s | %-10s |\n", "ID", "Employee Name", "Salary", "Email", "Department");
            System.out.println("+----+-----------------+---------------+----------------------+------------+");
            do{
                int id = rsByName.getInt("id");
                String ename = rsByName.getString("ename");
                double salary = rsByName.getDouble("esalary");
                String email = rsByName.getString("email");
                String dept = rsByName.getString("edept");
                System.out.printf("| %-2d | %-15s | %-13f | %-20s | %-10s |\n", id, ename, salary, email, dept);
            } while (rsByName.next());
            System.out.println("+----+-----------------+---------------+----------------------+------------+\n");
            psByName.close();
            rsByName.close();
        } else {
            System.out.println("\nEmployee Name Not Found.\n");
        }
    }



    public static void searchByDepartment(Connection connection, Scanner scanner) throws SQLException{
        String sql = "select * from employee1 where edept = ?";
        PreparedStatement psByDept = connection.prepareStatement(sql);

        System.out.print("Enter the department name : ");
        String dept = scanner.nextLine().trim();

        psByDept.setString(1, dept);

        ResultSet rsByDept = psByDept.executeQuery();

        if(rsByDept.next()) {
            System.out.println("\n+----+-----------------+---------------+----------------------+------------+");
            System.out.printf("| %-2s | %-15s | %-13s | %-20s | %-10s |\n", "ID", "Employee Name", "Salary", "Email", "Department");
            System.out.println("+----+-----------------+---------------+----------------------+------------+");
            do{
                int id1 = rsByDept.getInt("id");
                String ename = rsByDept.getString("ename");
                double salary = rsByDept.getDouble("esalary");
                String email = rsByDept.getString("email");
                String edept = rsByDept.getString("edept");
                System.out.printf("| %-2d | %-15s | %-13f | %-20s | %-10s |\n", id1, ename, salary, email, edept);
            } while (rsByDept.next());
            System.out.println("+----+-----------------+---------------+----------------------+------------+\n");
            psByDept.close();
            rsByDept.close();
        } else {
            System.out.println("\nEmployee Department Not Found.\n");
        }
    }



    public static void bulkInsertEmployees(Connection connection, Scanner scanner) throws SQLException {
        try{
            scanner.nextLine();
            String insertQuery = "insert into employee1 (ename, esalary, email, edept) values (?,?,?,?)";
            try (PreparedStatement ps = connection.prepareStatement(insertQuery)) {
                System.out.print("\nHow many employees do you want to insert : ");
                int count = scanner.nextInt();
                scanner.nextLine();

                for(int i=1; i<=count; i++) {
                    System.out.println("\nEnter details for Employee " + i);

                    System.out.print("Enter the name : ");
                    String name = scanner.nextLine();

                    System.out.print("Enter the salary : ");
                    double salary = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Enter the email : ");
                    String email = scanner.nextLine();

                    System.out.print("Enter the department : ");
                    String department = scanner.nextLine();

                    ps.setString(1, name);
                    ps.setDouble(2, salary);
                    ps.setString(3, email);
                    ps.setString(4, department);

                    ps.addBatch();
                }

                int[] results = ps.executeBatch();

                connection.commit();

                System.out.println("\nBulk Insert Completed Successfully.");
                System.out.println("Employees Processed : " + results.length + "\n");

            }
        } catch (SQLException ex) {
            connection.rollback();
            System.out.println(ex.getMessage());
        }
    }

}
