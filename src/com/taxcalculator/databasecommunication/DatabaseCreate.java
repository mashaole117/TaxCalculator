package com.taxcalculator.databasecommunication;

import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseCreate {

  private static Statement statement;

  public DatabaseCreate() {
    DatabaseCreateStatement connection = new DatabaseCreateStatement();
    statement = connection.createConnection("TaxCalculator");
  }

  public void createDatabase() throws SQLException {
    String sql = "CREATE DATABASE \"TaxCalculator\"";
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

//  public void createIncomeTable() throws SQLException {
//    String sql = "CREATE TABLE public.Income ( " +
//        "INCOME_ID integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 ), " +
//        "AMOUNT numeric NOT NULL, " +
//        "TYPE text NOT NULL, " +
//        "TAX_NUMBER integer NOT NULL, " +
//        "CONSTRAINT Income_pkey PRIMARY KEY (INCOME_ID), " +
//        "CONSTRAINT TAX_NUMBER FOREIGN KEY (TAX_NUMBER) " +
//        "REFERENCES public.TaxPayer (TAX_NUMBER) MATCH SIMPLE " +
//        "ON DELETE CASCADE)";
//
//    statement.executeUpdate(sql);
//  }
//
//  public void createExpenseTable() throws SQLException {
//    String sql = "CREATE TABLE public.Expense ( " +
//        "EXPENSE_ID integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 ), " +
//        "AMOUNT numeric NOT NULL, " +
//        "TYPE text NOT NULL, " +
//        "TAX_NUMBER integer NOT NULL, " +
//        "CONSTRAINT Expense_pkey PRIMARY KEY (EXPENSE_ID), " +
//        "CONSTRAINT TAX_NUMBER FOREIGN KEY (TAX_NUMBER) " +
//        "REFERENCES public.TaxPayer (TAX_NUMBER) MATCH SIMPLE " +
//        "ON DELETE CASCADE)";
//
//    statement.executeUpdate(sql);
//  }

  public void createBonusTable() throws SQLException {
      String sql = "CREATE TABLE public.Bonus ( " +
          "BONUS_ID integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 ), " +
          "AMOUNT numeric NOT NULL, " +
          "TAX_NUMBER integer NOT NULL, " +
          "CONSTRAINT Bonus_pkey PRIMARY KEY (BONUS_ID), " +
          "CONSTRAINT TAX_NUMBER FOREIGN KEY (TAX_NUMBER) " +
          "REFERENCES public.TaxPayer (TAX_NUMBER) MATCH SIMPLE " +
          "ON DELETE CASCADE )";

      statement.executeUpdate(sql);
  }

  public void createCapitalGainTable() throws SQLException {
      String sql = "CREATE TABLE public.CapitalGain ( " +
          "CG_ID integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 ), " +
          "CG_AMOUNT numeric NOT NULL, " +
          "EXEMPTION numeric NOT NULL, " +
          "TAX_NUMBER integer NOT NULL, " +
          "CONSTRAINT CapitalGain_pkey PRIMARY KEY (CG_ID), " +
          "CONSTRAINT TAX_NUMBER FOREIGN KEY (TAX_NUMBER) " +
          "REFERENCES public.TaxPayer (TAX_NUMBER) MATCH SIMPLE " +
          "ON DELETE CASCADE )";

      statement.executeUpdate(sql);
  }

  public void createInterestReceivedTable() throws SQLException {
      String sql = "CREATE TABLE public.InterestReceived ( " +
          "IR_ID integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 ), " +
          "IR_AMOUNT numeric NOT NULL, " +
          "TAX_NUMBER integer NOT NULL, " +
          "CONSTRAINT InterestReceived_pkey PRIMARY KEY (IR_ID), " +
          "CONSTRAINT TAX_NUMBER FOREIGN KEY (TAX_NUMBER) " +
          "REFERENCES public.TaxPayer (TAX_NUMBER) MATCH SIMPLE " +
          "ON DELETE CASCADE )";

      statement.executeUpdate(sql);
  }

  public void createSalaryTable() throws SQLException {
      String sql = "CREATE TABLE public.Salary ( " +
          "SALARY_ID integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 ), " +
          "SALARY_AMOUNT numeric NOT NULL, " +
          "TAX_NUMBER integer NOT NULL, " +
          "CONSTRAINT Salary_pkey PRIMARY KEY (SALARY_ID), " +
          "CONSTRAINT TAX_NUMBER FOREIGN KEY (TAX_NUMBER) " +
          "REFERENCES public.TaxPayer (TAX_NUMBER) MATCH SIMPLE " +
          "ON DELETE CASCADE )";

      statement.executeUpdate(sql);
  }

  public void createMedicalExpenseTable() throws SQLException {
      String sql = "CREATE TABLE public.MedicalExpense ( " +
          "ME_ID integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 ), " +
          "CONTRIBUTION numeric NOT NULL, " +
          "MEDICAL_EXPENSE numeric NOT NULL, " +
          "TAX_NUMBER integer NOT NULL, " +
          "CONSTRAINT Medical_expense_pkey PRIMARY KEY (ME_ID), " +
          "CONSTRAINT TAX_NUMBER FOREIGN KEY (TAX_NUMBER) " +
          "REFERENCES public.TaxPayer (TAX_NUMBER) MATCH SIMPLE " +
          "ON DELETE CASCADE )";

      statement.executeUpdate(sql);
  }

  public void createRetirementFundTable() throws SQLException {
      String sql = "CREATE TABLE public.RetirementFund ( " +
          "RF_ID integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 ), " +
          "RF_DEDUCTIBLE numeric NOT NULL, " +
          "TAX_NUMBER integer NOT NULL, " +
          "CONSTRAINT Retirement_fund_pkey PRIMARY KEY (RF_ID), " +
          "CONSTRAINT TAX_NUMBER FOREIGN KEY (TAX_NUMBER) " +
          "REFERENCES public.TaxPayer (TAX_NUMBER) MATCH SIMPLE " +
          "ON DELETE CASCADE )";

      statement.executeUpdate(sql);
  }

  public void createTravelAllowanceTable() throws SQLException {
      String sql = "CREATE TABLE public.TravelAllowance ( " +
          "TA_ID integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 ), " +
          "VEHICLE_VALUE numeric NOT NULL, " +
          "DISTANCE_TRAVELLED numeric NOT NULL, " +
          "TAX_NUMBER integer NOT NULL, " +
          "CONSTRAINT Travel_allowance_pkey PRIMARY KEY (TA_ID), " +
          "CONSTRAINT TAX_NUMBER FOREIGN KEY (TAX_NUMBER) " +
          "REFERENCES public.TaxPayer (TAX_NUMBER) MATCH SIMPLE " +
          "ON DELETE CASCADE )";

      statement.executeUpdate(sql);
  }

  public void createTaxBracketTable() throws SQLException {
      String sql = "CREATE TABLE public.TaxBracket (" +
          "TAX_YEAR integer NOT NULL, " +
          "FIRST_TB_LOW numeric NOT NULL, " +
          "FIRST_TB_HIGH numeric NOT NULL, " +
          "SECOND_TB_LOW numeric NOT NULL, " +
          "SECOND_TB_HIGH numeric NOT NULL, " +
          "THIRD_TB_LOW numeric NOT NULL, " +
          "THIRD_TB_HIGH numeric NOT NULL, " +
          "FOURTH_TB_LOW numeric NOT NULL, " +
          "FOURTH_TB_HIGH numeric NOT NULL, " +
          "FIFTH_TB_LOW numeric NOT NULL, " +
          "FIFTH_TB_HIGH numeric NOT NULL, " +
          "SIXTH_TB_LOW numeric NOT NULL, " +
          "SIXTH_TB_HIGH numeric NOT NULL, " +
          "SEVENTH_TB_LOW numeric NOT NULL, " +
          "SEVENTH_TB_HIGH numeric NOT NULL, " +
          "FIRST_PERCENT numeric NOT NULL, " +
          "SECOND_PERCENT numeric NOT NULL, " +
          "THIRD_PERCENT numeric NOT NULL, " +
          "FOURTH_PERCENT numeric NOT NULL, " +
          "FIFTH_PERCENT numeric NOT NULL, " +
          "SIXTH_PERCENT numeric NOT NULL, " +
          "SEVENTH_PERCENT numeric NOT NULL, " +
          "CONSTRAINT TaxTable_pkey PRIMARY KEY (TAX_YEAR) )";

      statement.executeUpdate(sql);
  }

  public void createTaxRebateTable() throws SQLException {
      String sql = "CREATE TABLE public.TaxRebate (" +
          "TAX_YEAR integer NOT NULL, " +
          "PRIMARY_REBATE numeric NOT NULL, " +
          "SECONDARY_REBATE numeric NOT NULL, " +
          "TERTIARY_REBATE numeric NOT NULL, " +
          "CONSTRAINT TaxRebate_pkey PRIMARY KEY (TAX_YEAR) )";

      statement.executeUpdate(sql);
  }

}
