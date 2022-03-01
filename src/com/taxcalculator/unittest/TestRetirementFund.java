package com.taxcalculator.unittest;

import com.taxcalculator.expense.RetirementFund;
import com.taxcalculator.income.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TestRetirementFund {
  @Test
  @DisplayName("Testing retirement fund deductible")
  public void testDeductibleCalculation() {
    Salary salary = new Salary(500000);
    Bonus bonus = new Bonus(25000);
    RetirementFund retirementFund = new RetirementFund(150000);
    double deductible = retirementFund.calculateDeductible(salary,bonus);
    Assertions.assertEquals(144375, deductible);
  }
}
