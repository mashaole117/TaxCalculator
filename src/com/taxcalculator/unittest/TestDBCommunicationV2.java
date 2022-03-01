package com.taxcalculator.unittest;

import com.taxcalculator.calculatorcomponents.TaxPayer;
import com.taxcalculator.databasecommunication.*;
import com.taxcalculator.expense.*;
import com.taxcalculator.income.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.sql.SQLException;

public class TestDBCommunicationV2 {

  DatabaseManipulation databaseManipulation = new DatabaseManipulation();
  DatabaseDefinition databaseDefinition = new DatabaseDefinition();
  @Test
  @DisplayName("Test database creation")
  public void testDatabaseCreation() {
    try {
      databaseDefinition.createDatabase();
    } catch (SQLException e) {
      Assertions.fail("Exception " + e);
    }
  }

  @Test
  @DisplayName("Test taxpayer table creation")
  public void testTaxPayerTableCreation() {
    try {
      databaseDefinition.createTaxPayerTable();
    } catch (SQLException e) {
      Assertions.fail("Exception " + e);
    }
  }

  @Test
  @DisplayName("Test adding tax payer to table")
  public void testAddTaxPayerToTable() {
    try {
      TaxPayer taxPayer = new TaxPayer();
      taxPayer.setTaxNumber(1234567890L);
      taxPayer.setAge(30);
      taxPayer.setFirstName("FName");
      taxPayer.setLastName("LName");
      taxPayer.setNumberOfDependents(3);
      taxPayer.setDisabilityFlag(false);
      taxPayer.setBonus(new Bonus(25000));
      taxPayer.setCapitalGain(new CapitalGain(80000,40000));
      taxPayer.setInterestReceived(new InterestReceived(45000,30));
      taxPayer.setSalary(new Salary(500000));
      taxPayer.setMedicalExpense(new MedicalExpense(48000,42000));
      taxPayer.setRetirementFund(new RetirementFund(150000));
      taxPayer.setTravelAllowance(new TravelAllowance(300000,10000));
      databaseManipulation.addTaxPayerToTable(taxPayer);
    } catch (SQLException e) {
      Assertions.fail("Exception " + e);
    }
  }

  @Test
  @DisplayName("Test retrieving taxpayer details")
  public void testRetrieveTaxPayerDetails() {
    TaxPayer taxPayer = databaseManipulation.retrieveTaxPayerDetails(1234567890L);
    if(taxPayer == null){
      Assertions.fail("Could not retrieve taxpayer");
    }
  }
}
