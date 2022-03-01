package com.taxcalculator.income;

public class Salary extends Income {

  public Salary(final double amount) {
    super(amount, 0);
  }

  public double calculateTaxableAmount() {
    return amount;
  }

}
