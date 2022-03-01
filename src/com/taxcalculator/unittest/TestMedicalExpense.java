package com.taxcalculator.unittest;

import com.taxcalculator.expense.MedicalExpense;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TestMedicalExpense {

  @Test
  @DisplayName("Testing medical expenses deductible no disability")
  public void testDeductibleCalculationWithoutDisability() {
    MedicalExpense medicalExpense = new MedicalExpense(48000, 42000);
    double deductible = medicalExpense.calculateDeductible(450000, 3, 38, false);
    Assertions.assertEquals(718.5, deductible);
  }

  @Test
  @DisplayName("Testing medical expenses deductible with disability or older than 65")
  public void testDeductibleCalculationWithDisability() {
    MedicalExpense medicalExpense = new MedicalExpense(22800, 20000);
    double deductible = medicalExpense.calculateDeductible(450000, 0, 38, true);
    Assertions.assertEquals(11171.484, deductible);
  }

}
