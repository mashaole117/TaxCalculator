package com.taxcalculator.databasecommunication;

import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseCreateV2 {

  private static Statement statement;

  private static final String DATABASE_NAME = "Play";

  public DatabaseCreateV2() {
    DatabaseCreateStatement connectionStatement = new DatabaseCreateStatement();
    statement = connectionStatement.createConnection(DATABASE_NAME);
  }

  public void createDatabase() throws SQLException {
    String sql = "CREATE DATABASE \"Play\"";
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

