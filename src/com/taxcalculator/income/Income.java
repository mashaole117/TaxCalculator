package com.taxcalculator.income;

public abstract class Income {

  protected double amount;

  protected double exemption;

  public Income(final double amount, final double exemption) {
    this.amount = amount;
    this.exemption = exemption;
  }

  public double getAmount() {
    return amount;
  }

  public double getExemption() {
    return exemption;
  }

  public abstract double calculateTaxableAmount();

}
