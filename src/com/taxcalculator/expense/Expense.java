package com.taxcalculator.expense;

public abstract class Expense {

  protected double amount;

  protected double exemption;

  public Expense(final double amount, final double exemption) {
    this.amount = amount;
    this.exemption = exemption;
  }

  public double getAmount() {
    return amount;
  }

  public double getExemption() {
    return exemption;
  }

  public abstract double calculateDeductible();

}
