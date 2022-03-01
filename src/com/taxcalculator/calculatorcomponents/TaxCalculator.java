package com.taxcalculator.calculatorcomponents;

import com.taxcalculator.UserInterface;
import com.taxcalculator.income.*;
import com.taxcalculator.expense.*;


public class TaxCalculator {

  private final UserInterface userInterface = new UserInterface();

  private final TaxTable taxTable = new TaxTable();

  private final TaxRebate taxRebate = new TaxRebate();

  private TaxPayer taxPayer;

  private double netTaxableIncome;

  private double taxTableTaxPayable;

  private double taxPayableAfterRebates;

  private double netTaxPayable;

  public void inputTaxPayerDetails() {
    this.taxPayer = userInterface.userInput();
  }

  public void outputPayableTax() {
    userInterface.taxCalculatorOutput(Math.round(netTaxPayable * 100.0) / 100.0,
        Math.round(taxTableTaxPayable * 100.0) / 100.0, Math.round(taxPayableAfterRebates * 100.0) / 100.0,
        Math.round(netTaxableIncome * 100.0) / 100.0);
  }

  private double calculateTotalIncome(Income... setOfIncomes) {
    double totalTaxableIncome = 0;

    for (Income i : setOfIncomes) {
      totalTaxableIncome += i.calculateTaxableAmount();
    }
    return totalTaxableIncome;
  }

  private double calculateTotalExpenses(final TravelAllowance travelAllowance, final RetirementFund retirementFund) {
    double totalDeductible;
    totalDeductible = travelAllowance.calculateDeductible() + retirementFund
        .calculateDeductible(taxPayer.getSalary(),
            taxPayer.getBonus());
    return totalDeductible;
  }

  private double calculateTaxableIncome() {
    double totalIncome = calculateTotalIncome(taxPayer.getSalary(), taxPayer.getBonus(),
        taxPayer.getInterestReceived(), taxPayer.getCapitalGain());
    double totalDeductible = calculateTotalExpenses(taxPayer.getTravelAllowance(),
        taxPayer.getRetirementFund());

    return totalIncome - totalDeductible;
  }

  public void calculateTaxPayable() {
    this.netTaxableIncome = calculateTaxableIncome();

    this.taxTableTaxPayable = Math.max(0, this.taxTable.taxPayable(netTaxableIncome));

    this.taxPayableAfterRebates = Math.max(0, this.taxRebate.taxPayable(this.taxTableTaxPayable, taxPayer.getAge()));

    this.netTaxPayable = Math
        .max(0, taxPayableAfterRebates - taxPayer.getMedicalExpense().calculateDeductible(netTaxableIncome,
            taxPayer.getNumberOfDependents(), taxPayer.getAge(), taxPayer.getDisabilityFlag()));
  }

}
