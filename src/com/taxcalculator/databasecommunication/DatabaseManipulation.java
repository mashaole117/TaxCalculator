package com.taxcalculator.databasecommunication;

import com.taxcalculator.calculatorcomponents.TaxPayer;
import com.taxcalculator.expense.*;
import com.taxcalculator.income.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DatabaseManipulation implements DatabaseName {

  private static Statement statement;



  public DatabaseManipulation() {
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
  public TaxPayer retrieveTaxPayerDetails(final long taxNumber) {
    TaxPayer taxPayer = new TaxPayer();

    String sql = "SELECT tax_number, age, first_name, last_name, number_dependants, disability_status, salary, bonus," +
        " interest_amount, medical_contribution, medical_expense, retirement_fund_amount, ta_vehicle_value, ta_distance FROM" +
        " taxpayer"
        + " WHERE tax_number = " + taxNumber;
    try {
      ResultSet resultSet = statement.executeQuery(sql);
      if (resultSet.next()) {
        taxPayer.setTaxNumber(taxNumber);
        taxPayer.setAge(resultSet.getInt("age"));
        taxPayer.setFirstName(resultSet.getString("first_name"));
        taxPayer.setLastName(resultSet.getString("last_name"));
        taxPayer.setNumberOfDependents(resultSet.getInt("number_dependants"));
        taxPayer.setDisabilityFlag(resultSet.getBoolean("disability_status"));
        taxPayer.setMedicalExpense(
            new MedicalExpense(resultSet.getDouble("medical_contribution"), resultSet.getDouble("medical_expense")));
        taxPayer.setSalary(new Salary(resultSet.getDouble("salary")));
        taxPayer.setBonus(new Bonus(resultSet.getDouble("bonus")));
        taxPayer.setInterestReceived(new InterestReceived(resultSet.getDouble("interest_amount"), taxPayer.getAge()));
        taxPayer.setRetirementFund(new RetirementFund(resultSet.getDouble("retirement_fund_amount")));
        taxPayer.setTravelAllowance(
            new TravelAllowance(resultSet.getDouble("ta_vehicle_value"), resultSet.getDouble("ta_distance")));
      }
      else
        taxPayer = null;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return taxPayer;
  }

}
