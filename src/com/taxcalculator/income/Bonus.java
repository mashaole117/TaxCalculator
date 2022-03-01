package com.taxcalculator.income;

public class Bonus extends Income {

  public Bonus(final double amount) {
    super(amount, 0);
  }

  public double calculateTaxableAmount() {
    return amount;
  }

}
