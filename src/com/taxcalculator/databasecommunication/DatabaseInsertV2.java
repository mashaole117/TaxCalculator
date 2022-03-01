package com.taxcalculator.databasecommunication;

import java.sql.SQLException;
import java.sql.Statement;
import com.taxcalculator.calculatorcomponents.TaxPayer;

public class DatabaseInsertV2 {

  private static Statement statement;

  private static final String DATABASE_NAME = "Play";

  public DatabaseInsertV2() {
    DatabaseCreateStatement connectionStatement = new DatabaseCreateStatement();
    statement = connectionStatement.createConnection(DATABASE_NAME);
  }

  public void addTaxPayerToTable(final TaxPayer taxPayer)
      throws SQLException {
    String sql =
        "INSERT INTO taxpayer (tax_number, age, first_name, last_name, number_dependants, disability_status, salary, " +
            "bonus, interest_amount, medical_contribution, medical_expense, retirement_fund_amount, ta_vehicle_value, " +
            "ta_distance) VALUES (" + taxPayer.getTaxNumber() + "," + taxPayer.getAge() + "," + "'" +
            taxPayer.getFirstName() + "'" + "," + "'" + taxPayer.getLastName() + "'" + "," + taxPayer.getNumberOfDependents()
            + "," + taxPayer.getDisabilityFlag() + "," + taxPayer.getSalary().getAmount() + "," + taxPayer.getBonus().getAmount() + "," +
            taxPayer.getInterestReceived().getAmount() + "," + taxPayer.getMedicalExpense().getContributions() + "," +
            taxPayer.getMedicalExpense().getQualifyingMedicalExpense() + "," + taxPayer.getRetirementFund().getAmount() + ","
            + taxPayer.getTravelAllowance().getVehicleValue() + "," + taxPayer.getTravelAllowance().getDistanceTravelled() + ")";

    statement.executeUpdate(sql);
  }

}
