package com.taxcalculator.databasecommunication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseCreateStatement {

  private static final String USER_NAME = "postgres";

  private static final String PASSWORD = "password";

  private static String JDBC_URL = "jdbc:postgresql://localhost/";

  public Statement createConnection(String databaseName) {
    try {
      Connection connection = DriverManager.getConnection(JDBC_URL+databaseName, USER_NAME, PASSWORD);
      Statement statement;
      return statement = connection.createStatement();
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  public Statement createConnection() {
    return createConnection("");
  }

}
