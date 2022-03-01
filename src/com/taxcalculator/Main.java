package com.taxcalculator;

import com.taxcalculator.calculatorcomponents.TaxCalculator;

public class Main {

  public static void main(String[] args) {

    TaxCalculator taxCalculator = new TaxCalculator();
    taxCalculator.inputTaxPayerDetails();
    taxCalculator.calculateTaxPayable();
    taxCalculator.outputPayableTax();

  }

}
