package com.taxcalculator.income;

public class InterestReceived extends Income {

  private static final double EXEMPTION = 23800;

  private final int age;

  public InterestReceived(final double amount, final int age) {
    super(amount, EXEMPTION);
    this.age = age;
  }

  public double calculateTaxableAmount() {
    double taxable;
    if (this.age < 65)
      taxable = this.amount - this.exemption;
    else
      taxable = this.amount - 34500;
    if (taxable < 0)
      return 0;
    else
      return taxable;
  }

}
