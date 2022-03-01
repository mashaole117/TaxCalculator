package com.taxcalculator.databasecommunication;

import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseDefinition implements DatabaseName {

  private static Statement statement;

  public DatabaseDefinition() {
    DatabaseCreateStatement connectionStatement = new DatabaseCreateStatement();
    statement = connectionStatement.createConnection(DATABASE_NAME);
  }

  public void createDatabase() throws SQLException {
    String sql = "CREATE DATABASE \"" + DATABASE_NAME + "\"";
    statement.executeUpdate(sql);
  }

  public void createTaxPayerTable() throws SQLException {
    String sql = "CREATE TABLE public.TaxPayer ( " +
        "TAX_NUMBER integer NOT NULL, " +
        "AGE integer NOT NULL, " +
        "FIRST_NAME text NOT NULL, " +
        "LAST_NAME text NOT NULL, " +
        "NUMBER_DEPENDANTS integer NOT NULL, " +
        "DISABILITY_STATUS boolean NOT NULL, " +
        "SALARY numeric NOT NULL, " +
        "BONUS numeric NOT NULL, " +
        "INTEREST_AMOUNT numeric NOT NULL, " +
        "MEDICAL_CONTRIBUTION numeric NOT NULL, " +
        "MEDICAL_EXPENSE numeric NOT NULL, " +
        "RETIREMENT_FUND_AMOUNT numeric NOT NULL, " +
        "TA_VEHICLE_VALUE numeric NOT NULL, " +
        "TA_DISTANCE numeric NOT NULL, " +
        "CONSTRAINT TaxPayer_pkey PRIMARY KEY (TAX_NUMBER) )";

    statement.executeUpdate(sql);
  }

}
