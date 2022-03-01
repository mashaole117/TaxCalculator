package com.taxcalculator.unittest;

import com.taxcalculator.calculatorcomponents.TaxPayer;
import com.taxcalculator.databasecommunication.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.sql.SQLException;

public class TestDBCommunication {
  DatabaseInsert databaseInsert = new DatabaseInsert();

  DatabaseCreate databaseCreate = new DatabaseCreate();

  DatabaseSelect databaseSelect = new DatabaseSelect();

  @Test
  @DisplayName("Test database creation")
  public void testDatabaseCreation() {
    try {
      databaseCreate.createDatabase();
    } catch (SQLException e) {
      Assertions.fail("Exception " + e);
    }
  }

  @Test
  @DisplayName("Test taxpayer table creation")
  public void testTaxPayerTableCreation() {
    try {
      databaseCreate.createTaxPayerTable();
    } catch (SQLException e) {
      Assertions.fail("Exception " + e);
    }
  }

  @Test
  @DisplayName("Test adding tax payer to table")
  public void testAddTaxPayerToTable() {
    try {
      databaseInsert.addTaxPayerToTable(1234567890L, 30, "FName", "LName", 3, false);
    } catch (SQLException e) {
      Assertions.fail("Exception " + e);
    }
  }

  @Test
  @DisplayName("Test creating bonus table")
  public void testCreatingBonusTable() {
    try {
      databaseCreate.createBonusTable();
    } catch (SQLException e) {
      Assertions.fail("Exception " + e);
    }
  }

  @Test
  @DisplayName("Test adding bonus to table")
  public void testAddBonusToTable() {
    try {
      databaseInsert.addBonusToTable(25000, 1234567890L);
    } catch (SQLException e) {
      Assertions.fail("Exception " + e);
    }
  }

  @Test
  @DisplayName("Test creating capital gains table")
  public void testCreatingCapitalGainsTable() {
    try {
      databaseCreate.createCapitalGainTable();
    } catch (SQLException e) {
      Assertions.fail("Exception " + e);
    }
  }

  @Test
  @DisplayName("Test adding capital gains to table")
  public void testAddCapitalGainsToTable() {
    try {
      databaseInsert.addCapitalGainsToTable(800000, 40000, 1234567890L);
    } catch (SQLException e) {
      Assertions.fail("Exception " + e);
    }
  }

  @Test
  @DisplayName("Test creating interest received table")
  public void testCreatingInterestReceivedTable() {
    try {
      databaseCreate.createInterestReceivedTable();
    } catch (SQLException e) {
      Assertions.fail("Exception " + e);
    }
  }

  @Test
  @DisplayName("Test adding capital gains to table")
  public void testAddInterestReceivedToTable() {
    try {
      databaseInsert.addInterestReceivedToTable(45000, 1234567890L);
    } catch (SQLException e) {
      Assertions.fail("Exception " + e);
    }
  }

  @Test
  @DisplayName("Test creating salary table")
  public void testCreatingSalaryTable() {
    try {
      databaseCreate.createSalaryTable();
    } catch (SQLException e) {
      Assertions.fail("Exception " + e);
    }
  }

  @Test
  @DisplayName("Test adding salary to table")
  public void testAddSalaryToTable() {
    try {
      databaseInsert.addSalaryToTable(500000, 1234567890L);
    } catch (SQLException e) {
      Assertions.fail("Exception " + e);
    }
  }

  @Test
  @DisplayName("Test creating medical expense table")
  public void testCreatingMedicalExpenseTable() {
    try {
      databaseCreate.createMedicalExpenseTable();
    } catch (SQLException e) {
      Assertions.fail("Exception " + e);
    }
  }

  @Test
  @DisplayName("Test adding medical expense to table")
  public void testAddToMedicalExpenseToTable() {
    try {
      databaseInsert.addMedicalExpenseToTable(48000, 42000, 1234567890L);
    } catch (SQLException e) {
      Assertions.fail("Exception " + e);
    }
  }

  @Test
  @DisplayName("Test creating retirement fund table")
  public void testCreatingRetirementFundTable() {
    try {
      databaseCreate.createRetirementFundTable();
    } catch (SQLException e) {
      Assertions.fail("Exception " + e);
    }
  }

  @Test
  @DisplayName("Test adding retirement fund to table")
  public void testAddToRetirementFund() {
    try {
      databaseInsert.addRetirementFundToTable(150000, 1234567890L);
    } catch (SQLException e) {
      Assertions.fail("Exception " + e);
    }
  }

  @Test
  @DisplayName("Test creating travel allowance table")
  public void testCreatingTravelAllowanceTable() {
    try {
      databaseCreate.createTravelAllowanceTable();
    } catch (SQLException e) {
      Assertions.fail("Exception " + e);
    }
  }

  @Test
  @DisplayName("Test adding travel allowance to table")
  public void testAddToTravelAllowance() {
    try {
      databaseInsert.addTravelAllowanceToTable(300000, 10000, 1234567890L);
    } catch (SQLException e) {
      Assertions.fail("Exception " + e);
    }
  }

  @Test
  @DisplayName("Test creating tax bracket table")
  public void testCreatingTaxBracketTable() {
    try {
      databaseCreate.createTaxBracketTable();
    } catch (SQLException e) {
      Assertions.fail("Exception " + e);
    }
  }

  @Test
  @DisplayName("Test adding tax bracket to table")
  public void testAddToTaxBracketTable() {
    try {
      databaseInsert.addTaxBracketToTable(2021, 0, 216200, 216201, 337800,
          337801, 467500, 467501, 613600, 613601, 782200, 782201,
          1656600, 1656601, 1000000000, 0.18, 0.26, 0.31, 0.36,
          0.39, 0.41, 0.45);
    } catch (SQLException e) {
      Assertions.fail("Exception " + e);
    }
  }

  @Test
  @DisplayName("Test creating tax rebate table")
  public void testCreatingTaxRebateTable() {
    try {
      databaseCreate.createTaxRebateTable();
    } catch (SQLException e) {
      Assertions.fail("Exception " + e);
    }
  }

  @Test
  @DisplayName("Test adding tax rebate to table")
  public void testAddToTaxRebateTable() {
    try {
      databaseInsert.addTaxRebateToTable(2021, 15714, 8613, 2817);
    } catch (SQLException e) {
      Assertions.fail("Exception " + e);
    }
  }

  @Test
  @DisplayName("Test retrieving taxpayer details")
  public void testRetrieveTaxPayerDetails() {
    TaxPayer taxPayer = databaseSelect.retrieveTaxPayerDetails(12345L);
    if(taxPayer == null){
      Assertions.fail("Could not retrieve taxpayer");
    }
  }

}

