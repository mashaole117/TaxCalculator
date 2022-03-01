package com.taxcalculator.unittest;

import com.taxcalculator.calculatorcomponents.TaxRebate;
import com.taxcalculator.calculatorcomponents.TaxTable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestTaxTable {
  private TaxRebate taxRebate = new TaxRebate();

  private TaxTable taxTable = new TaxTable();

  @Test
  @DisplayName("Testing tax payable after rebates under 65")
  public void testTaxPayable400K() {
    double payable = taxRebate.taxPayable(this.taxTable.taxPayable(400000), 30);
    Assertions.assertEquals(74100, Math.round(payable));
  }

  @Test
  @DisplayName("Testing tax payable after rebates under 65")
  public void testTaxPayableUnder65() {
    double payable = taxRebate.taxPayable(this.taxTable.taxPayable(625825), 30);
    Assertions.assertEquals(152389, Math.round(payable));
  }

  @Test
  @DisplayName("Testing tax payable after rebates over 65")
  public void testTaxPayableOver65() {
    double payable = taxRebate.taxPayable(this.taxTable.taxPayable(625825), 70);
    Assertions.assertEquals(143776, Math.round(payable));
  }

  @Test
  @DisplayName("Testing tax payable after rebates over 75")
  public void testTaxPayableOver75() {
    double payable = taxRebate.taxPayable(this.taxTable.taxPayable(625825), 80);
    Assertions.assertEquals(140959, Math.round(payable));
  }

}
