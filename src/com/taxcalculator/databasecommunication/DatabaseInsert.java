package com.taxcalculator.databasecommunication;

import java.sql.*;

public class DatabaseInsert {

  private static Statement statement;

  public DatabaseInsert() {
    DatabaseCreateStatement connectionStatement = new DatabaseCreateStatement();
    statement = connectionStatement.createConnection("TaxCalculator");
  }

  public void addTaxPayerToTable(final long taxNumber, final int age, final String firstName, final String lastName,
                                 final int numberOfDependants, final boolean disabilityFlag)
      throws SQLException {
    String sql = "INSERT INTO taxpayer (tax_number, age, first_name, last_name,number_dependants,disability_status)" +
        " VALUES (" +
        taxNumber + "," + age + "," + "'" + firstName + "'" + "," + "'" + lastName + "'" + "," + numberOfDependants + "," + disabilityFlag + ")";

    statement.executeUpdate(sql);
  }

  public void addBonusToTable(final double amount, final long taxNumber) throws SQLException {
    String sql = "INSERT INTO bonus (amount, tax_number) VALUES (" +
        amount + "," + taxNumber + ")";

    statement.executeUpdate(sql);
  }

  public void addCapitalGainsToTable(final double amount, final double exemption, final long taxNumber)
      throws SQLException {
    String sql = "INSERT INTO capitalgain (CG_amount, exemption, tax_number) VALUES (" +
        amount + "," + exemption + "," + taxNumber + ")";

    statement.executeUpdate(sql);
  }

  public void addInterestReceivedToTable(final double amount, final long taxNumber) throws SQLException {
    String sql = "INSERT INTO interestreceived (IR_amount, tax_number) VALUES (" +
        amount + "," + taxNumber + ")";

    statement.executeUpdate(sql);
  }

  public void addSalaryToTable(final double amount, final long taxNumber) throws SQLException {
    String sql = "INSERT INTO salary (salary_amount, tax_number) VALUES (" +
        amount + "," + taxNumber + ")";

    statement.executeUpdate(sql);
  }

  public void addMedicalExpenseToTable(final double contribution, final long medicalExpense, final long taxNumber)
      throws SQLException {

    String sql = "INSERT INTO medicalexpense (contribution,medical_expense, tax_number) VALUES (" +
        contribution + "," + medicalExpense + "," + taxNumber + ")";

    statement.executeUpdate(sql);

  }

  public void addRetirementFundToTable(final double deductible, final long taxNumber) throws SQLException {
    String sql = "INSERT INTO retirementfund (rf_deductible, tax_number) VALUES (" +
        deductible + "," + taxNumber + ")";

    statement.executeUpdate(sql);
  }

  public void addTravelAllowanceToTable(final double vehicleValue, final double distanceTravelled, final long taxNumber)
      throws SQLException {
    String sql = "INSERT INTO travelallowance (vehicle_value, distance_travelled, tax_number) VALUES (" +
        vehicleValue + "," + distanceTravelled + "," + taxNumber + ")";

    statement.executeUpdate(sql);

  }

  public void addTaxBracketToTable(final int taxYear, final double firstLow, final double firstHigh,
                                   final double secondLow,
                                   final double secondHigh, final double thirdLow, final double thirdHigh,
                                   final double fourthLow,
                                   final double fourthHigh, final double fifthLow, final double fifthHigh,
                                   final double sixthLow,
                                   final double sixthHigh, final double seventhLow, final double seventhHigh,
                                   final double firstPercent,
                                   final double secondPercent, final double thirdPercent, final double fourthPercent,
                                   final double fifthPercent, final double sixthPercent, final double seventhPercent)
      throws SQLException {
    String sql = "INSERT INTO taxbracket (TAX_YEAR, FIRST_TB_LOW, FIRST_TB_HIGH, SECOND_TB_LOW, SECOND_TB_HIGH, " +
        "THIRD_TB_LOW, " +
        "THIRD_TB_HIGH, FOURTH_TB_LOW, FOURTH_TB_HIGH, FIFTH_TB_LOW, FIFTH_TB_HIGH, SIXTH_TB_LOW, SIXTH_TB_HIGH," +
        " SEVENTH_TB_LOW,SEVENTH_TB_HIGH, FIRST_PERCENT, SECOND_PERCENT,THIRD_PERCENT,FOURTH_PERCENT,FIFTH_PERCENT," +
        "SIXTH_PERCENT,SEVENTH_PERCENT) VALUES (" +
        taxYear + "," + firstLow + "," + firstHigh + "," + secondLow + "," + secondHigh + "," + thirdLow + "," + thirdHigh +
        "," + fourthLow + "," + fourthHigh + "," + fifthLow + "," + fifthHigh + "," + sixthLow + "," + sixthHigh +
        "," +
        seventhLow + "," + seventhHigh + "," + firstPercent + "," + secondPercent + "," + thirdPercent + "," +
        fourthPercent + "," + fifthPercent + "," + sixthPercent + "," + seventhPercent + ")";

    statement.executeUpdate(sql);
  }

  public void addTaxRebateToTable(final int taxYear, final double primaryRebate, final double secondaryRebate,
                                  final double tertiaryRebate)
      throws SQLException {
    String sql = "INSERT INTO taxrebate (tax_year, primary_rebate, secondary_rebate, tertiary_rebate) VALUES (" +
        taxYear + "," + primaryRebate + "," + secondaryRebate + "," + tertiaryRebate + ")";

    statement.executeUpdate(sql);
  }

}
