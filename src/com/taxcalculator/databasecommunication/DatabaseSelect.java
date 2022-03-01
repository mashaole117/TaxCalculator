package com.taxcalculator.databasecommunication;

import com.taxcalculator.calculatorcomponents.TaxPayer;
import com.taxcalculator.income.*;
import com.taxcalculator.expense.*;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class DatabaseSelect {

  private static ResultSet resultSet;

  private static Statement statement;

  private TaxPayer taxPayer = new TaxPayer();

  public DatabaseSelect() {
    DatabaseCreateStatement connectionStatement = new DatabaseCreateStatement();
    statement = connectionStatement.createConnection("TaxCalculator");
  }

  private void retrieveTaxPayer(final long taxNumber) {
    String sql = "SELECT tax_number, age, first_name, last_name, number_dependants, disability_status FROM taxpayer"
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
      }
      else
        taxPayer = null;
      resultSet.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private void retrieveSalary(final long taxNumber) {
    String sql = "SELECT salary_amount FROM salary WHERE tax_number = " + taxNumber;
    try {
      resultSet = statement.executeQuery(sql);
      if (resultSet.next()) {

        Salary salary = new Salary(resultSet.getDouble("salary_amount"));
        taxPayer.setSalary(salary);
      }
      resultSet.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private void retrieveBonus(final long taxNumber) {
    String sql = "SELECT amount FROM bonus WHERE tax_number = " + taxNumber;
    try {
      resultSet = statement.executeQuery(sql);

      if (resultSet.next()) {
        Bonus bonus = new Bonus(resultSet.getDouble("amount"));
        taxPayer.setBonus(bonus);
      }
      resultSet.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private void retrieveCapitalGain(final long taxNumber) {
    String sql = "SELECT cg_amount, exemption FROM capitalgain WHERE tax_number = " + taxNumber;
    try {
      resultSet = statement.executeQuery(sql);
      if (resultSet.next()) {
        CapitalGain capitalGain = new CapitalGain(resultSet.getDouble("cg_amount"),
            resultSet.getDouble("exemption"));
        taxPayer.setCapitalGain(capitalGain);
      }
      resultSet.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private void retrieveInterestReceived(final long taxNumber) {
    String sql = "SELECT ir_amount FROM interestreceived WHERE tax_number = " + taxNumber;
    try {
      resultSet = statement.executeQuery(sql);
      if (resultSet.next()) {
        InterestReceived interestReceived = new InterestReceived(resultSet.getDouble("ir_amount"), taxPayer.getAge());
        taxPayer.setInterestReceived(interestReceived);
      }
      resultSet.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private void retrieveRetirementFund(final long taxNumber) {
    String sql = "SELECT rf_deductible FROM retirementfund WHERE tax_number = " + taxNumber;
    try {
      resultSet = statement.executeQuery(sql);

      if (resultSet.next()) {
        RetirementFund retirementFund = new RetirementFund(resultSet.getDouble("rf_deductible"));
        taxPayer.setRetirementFund(retirementFund);
      }
      resultSet.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private void retrieveMedicalExpense(final long taxNumber) {
    String sql = "SELECT contribution, medical_expense FROM medicalexpense WHERE tax_number = " + taxNumber;
    try {
      resultSet = statement.executeQuery(sql);
      if (resultSet.next()) {
        MedicalExpense medicalExpense = new MedicalExpense(resultSet.getDouble("contribution"),
            resultSet.getDouble("medical_expense"));
        taxPayer.setMedicalExpense(medicalExpense);
      }
      resultSet.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private void retrieveTravelAllowance(final long taxNumber) {
    String sql = "SELECT vehicle_value, distance_travelled FROM travelallowance WHERE tax_number = " + taxNumber;
    try {
      resultSet = statement.executeQuery(sql);
      if (resultSet.next()) {
        TravelAllowance travelAllowance = new TravelAllowance(resultSet.getDouble("vehicle_value"),
            resultSet.getDouble("distance_travelled"));
        taxPayer.setTravelAllowance(travelAllowance);
      }
      resultSet.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public TaxPayer retrieveTaxPayerDetails(final long taxNumber) {
    try {
      retrieveTaxPayer(taxNumber);
      retrieveSalary(taxNumber);
      retrieveBonus(taxNumber);
      retrieveInterestReceived(taxNumber);
      retrieveCapitalGain(taxNumber);
      retrieveRetirementFund(taxNumber);
      retrieveTravelAllowance(taxNumber);
      retrieveMedicalExpense(taxNumber);
      resultSet.close();
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
    return taxPayer;
  }

}
