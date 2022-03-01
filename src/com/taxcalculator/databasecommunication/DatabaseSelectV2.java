package com.taxcalculator.databasecommunication;

import com.taxcalculator.calculatorcomponents.TaxPayer;
import com.taxcalculator.expense.MedicalExpense;
import com.taxcalculator.expense.RetirementFund;
import com.taxcalculator.expense.TravelAllowance;
import com.taxcalculator.income.Bonus;
import com.taxcalculator.income.InterestReceived;
import com.taxcalculator.income.Salary;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseSelectV2 {

  private static ResultSet resultSet;

  private static Statement statement;

  private TaxPayer taxPayer = new TaxPayer();

  private static final String DATABASE_NAME = "Play";

  public DatabaseSelectV2() {
    DatabaseCreateStatement connectionStatement = new DatabaseCreateStatement();
    statement = connectionStatement.createConnection(DATABASE_NAME);
  }

  public TaxPayer retrieveTaxPayerDetails(final long taxNumber) {
    String sql = "SELECT tax_number, age, first_name, last_name, number_dependants, disability_status, salary, bonus," +
        " interest_amount, medical_contribution, medical_expense, retirement_fund_amount, ta_vehicle_value, ta_distance FROM" +
        " taxpayer"
        + " WHERE tax_number = " + taxNumber;
    try {
      resultSet = statement.executeQuery(sql);
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
      } else
        taxPayer = null;
      resultSet.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return taxPayer;
  }

}
