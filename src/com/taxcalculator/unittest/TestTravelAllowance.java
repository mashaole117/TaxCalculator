package com.taxcalculator.unittest;

import com.taxcalculator.expense.TravelAllowance;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TestTravelAllowance {
  @Test
  @DisplayName("Testing travel allowance deductible")
  public void testDeductibleCalculation() {
    TravelAllowance travelAllowance = new TravelAllowance(180000, 10000);
    double deductible = travelAllowance.calculateDeductible();
    Assertions.assertEquals(68676, deductible);
  }

}
