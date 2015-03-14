/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package international;


import CustomExceptions.TerminateException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author yousufkhan
 */
public class InternationalConnect {
    
    public static Connection CreateConntection(){
        Connection c = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager
                    .getConnection("jdbc:mysql://localhost/thesis",
                            "root", "");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");
            return c;
            

        }catch(Exception e){
            throw new NullPointerException();
        }
        
    }
    
    public static Statement CreateStatement(Connection c){

        Statement stmt = null;
        try {
            System.out.println("Create statement successfully");
            return stmt = c.createStatement();
            
        }catch(Exception e){
            throw new NullPointerException();
        }
        
    }
    public static void insertData(Statement stmt, String link) {
        
        try {
            String sql = "INSERT INTO international (link,status) "
                    + "VALUES ('"+link+"',0);";
            try {
                stmt.executeUpdate(sql);
            } catch (SQLException e) {
                throw new TerminateException();
            }

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Records created successfully");
    }
    
}
