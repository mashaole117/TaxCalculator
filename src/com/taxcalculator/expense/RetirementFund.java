package com.taxcalculator.expense;

import com.taxcalculator.income.*;

public class RetirementFund extends Expense {

  private static final double MAX_PERCENT = 0.275;

  private static final double MAX_EXEMPTION = 350000;

  private double deductible;

  public RetirementFund(double amount) {
    super(amount, MAX_EXEMPTION);
  }

  public double calculateDeductible(Salary salary, Bonus bonus) {
    double incomeExemption = MAX_PERCENT * (salary.getAmount() + bonus.getAmount());
    double finalExemption = Math.min(incomeExemption, this.exemption);

    return this.deductible = Math.min(this.amount, finalExemption);
  }


  public double calculateDeductible() {
    return 0;
  }

}
