package com.taxcalculator.expense;

public class MedicalExpense extends Expense {

  private static final double EXEMPTION = 12000;

  private final double contributions;

  private final double qualifyingMedicalExpense;

  private double deductible;

  public MedicalExpense(final double contributions, final double qualifyingMedicalExpense) {
    super(0, EXEMPTION);
    this.contributions = contributions;
    this.qualifyingMedicalExpense = qualifyingMedicalExpense;
  }

  public double calculateDeductible(final double taxableIncome, final int numberOfDependants, final int age,
                                    final boolean disabilityFlag) {
    double rebate;
    double taxCredit;

    if (numberOfDependants == 0)
      taxCredit = 12 * 257;
    else
      taxCredit = 12 * ((numberOfDependants - 1) * 224 + 2 * 332);

    if (age < 65 && !disabilityFlag)
      rebate = 0.25 * ((this.contributions - 4 * taxCredit) + this.qualifyingMedicalExpense - 0.075 * taxableIncome);
    else
      rebate = 0.333 * ((this.contributions - 3 * taxCredit) + this.qualifyingMedicalExpense);

    if (rebate < 0)
      return this.deductible = 0;
    else
      return this.deductible = Math.min(rebate, EXEMPTION);
  }

  public double getContributions() {
    return contributions;
  }

  public double getQualifyingMedicalExpense() {
    return qualifyingMedicalExpense;
  }

  public double calculateDeductible() {
    return 0;
  }

}
