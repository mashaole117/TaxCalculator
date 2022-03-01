package com.taxcalculator.calculatorcomponents;

import com.taxcalculator.taxconstants.TaxBracket;

public class TaxTable implements TaxBracket {

  public double taxPayable(final double netTaxableIncome) {
    double currentTaxableIncome;
    double leftoverIncome = netTaxableIncome;
    double taxesPayable = 0;

    for (int i = 0; i < 7; i++) {
      if (leftoverIncome <= TAX_BRACKET_HIGH[i] - TAX_BRACKET_LOW[i])
        currentTaxableIncome = leftoverIncome;
      else
        currentTaxableIncome = TAX_BRACKET_HIGH[i] - TAX_BRACKET_LOW[i];
      leftoverIncome -= currentTaxableIncome;
      taxesPayable += currentTaxableIncome * TAX_PERCENTAGES[i];
    }

    return taxesPayable;

  }
}
