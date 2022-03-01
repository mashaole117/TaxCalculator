package com.taxcalculator.taxconstants;

import java.math.BigDecimal;

public interface TaxBracket {

  public final static double[] TAX_BRACKET_LOW = {0, 216201, 337801, 467501, 613601, 782201,
      1656601};

  public final static double[] TAX_BRACKET_HIGH = {216200, 337800, 467500, 613600, 782200, 1656600,
      1000000000};

  public final static double[] TAX_PERCENTAGES = {0.18, 0.26, 0.31, 0.36, 0.39, 0.41, 0.45};

}
