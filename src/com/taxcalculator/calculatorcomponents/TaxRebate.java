package com.taxcalculator.calculatorcomponents;

import com.taxcalculator.taxconstants.TaxRebates;

public class TaxRebate implements TaxRebates {

  public double taxPayable(double taxTableTaxPayable, final int age) {

    if (age < 65)
      return taxTableTaxPayable -= REBATES[0];
    else if (age <= 75)
      return taxTableTaxPayable -= (REBATES[0] + REBATES[1]);
    else
      return taxTableTaxPayable -= (REBATES[0] + REBATES[1] + REBATES[2]);

  }

}
