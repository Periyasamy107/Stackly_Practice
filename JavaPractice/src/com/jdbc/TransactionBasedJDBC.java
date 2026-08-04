package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionBasedJDBC {


    static final String url = "jdbc:mysql://localhost:3306/sample";
    static final String userNmae = "root";
    static final String password = "root";

    public static void main(String[] args) throws SQLException {

        Connection conn = null;
        PreparedStatement insert = null;
        PreparedStatement update = null;
        PreparedStatement delete = null;

        try{

            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(url, userNmae, password);

            conn.setAutoCommit(false);

            // BULK INSERTION
            String insertQuery = "insert into employee(ename, esalary, ephone) values (?,?,?)";

            insert = conn.prepareStatement(insertQuery);

            insert.setString(1,"Ram");
            insert.setInt(2, 1000);
            insert.setString(3,"9876567886");
            insert.addBatch();

            insert.setString(1,"Lina");
            insert.setInt(2,1500);
            insert.setString(3,"9086431256");
            insert.addBatch();

            insert.setString(1,"Yuvish");
            insert.setInt(2,4000);
            insert.setString(3,"8787612345");
            insert.addBatch();

            insert.setString(1,"a");
            insert.setInt(2,1);
            insert.setString(3,"5");
            insert.addBatch();

            insert.setString(1,"b");
            insert.setInt(2,2);
            insert.setString(3,"6");
            insert.addBatch();

            insert.executeBatch();

            System.out.println("\nInsertion Successful.");

            // BULK UPDATION

            String updateQuery = "update employee set esalary = ? where id = ?";

            update = conn.prepareStatement(updateQuery);

            update.setInt(1,1111);
            update.setInt(2,1);
            update.addBatch();

            update.setInt(1,333);
            update.setInt(2,3);
            update.addBatch();

            update.executeBatch();

            System.out.println("\nUpdation Successful.");


            // BULK DELETION

            String deleteQuery = "delete from employee where id = ?";

            delete = conn.prepareStatement(deleteQuery);

            delete.setInt(1,4);
            delete.addBatch();

            delete.setInt(1,5);
            delete.addBatch();

            delete.executeBatch();

            System.out.println("\nDeletion Successful");

            conn.commit();
            System.out.println("\nCommit Successfully............");


        } catch(Exception ex) {
            try{
                if(conn != null) {
                    conn.rollback();
                }
                System.out.println("\nRoll Back Successfully!!!!!!!!!!!!!");
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
            ex.printStackTrace();
        } finally {
            conn.close();
            insert.close();
            update.close();
            delete.close();
        }

    }

}
