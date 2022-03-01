package com.taxcalculator.income;

public class CapitalGain extends Income {

  private static final double INCLUSION_RATE = 0.4;
  private double taxableAmount;

  public CapitalGain(final double amount, final double exemption) {
    super(amount, exemption);
  }

  public double calculateTaxableAmount() {
    double taxable = this.amount - this.exemption;

    if (taxable < 0)
      return 0;
    else
      return this.taxableAmount = taxable * INCLUSION_RATE;
  }

}
