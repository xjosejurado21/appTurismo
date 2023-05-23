package jbdc;

import java.sql.*;

public class ConectorDataBase {

  public static void main(String[] args) {
    String url = "jdbc:mysql://localhost:3306/proyectoprogramación"; // replace 'yourDatabase' with your actual database name
    String user = "root"; // replace 'username' with your actual username
    String password = ""; // replace 'password' with your actual password

    try {
      // Establecer conexion
      Connection myConn = DriverManager.getConnection(url, user, password);

      // crear un statement
      Statement myStmt = myConn.createStatement();

      // Ejecutar  SQL query
      ResultSet myRs = myStmt.executeQuery("select * from yourTable"); // replace 'yourTable' with your actual table name

      //Procesa el resultado
      while (myRs.next()) {
        System.out.println(myRs.getString("columnName")); // replace 'columnName' with your actual column name
      }
    } catch (Exception exc) {
      exc.printStackTrace();
    }
  }
}
