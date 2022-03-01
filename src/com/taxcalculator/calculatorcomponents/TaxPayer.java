package com.taxcalculator.calculatorcomponents;

import com.taxcalculator.expense.*;
import com.taxcalculator.income.*;

public class TaxPayer {
  private String firstName;

  private String lastName;

  private long taxNumber;

  private int age;

  private int numberOfDependents;

  private boolean disabilityFlag = false;

  private Salary salary;

  private Bonus bonus;

  private InterestReceived interestReceived;

  private CapitalGain capitalGain;

  private RetirementFund retirementFund;

  private TravelAllowance travelAllowance;

  private MedicalExpense medicalExpense;

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setTaxNumber(long taxNumber) {
    this.taxNumber = taxNumber;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public void setDisabilityFlag(boolean disabilityFlag) {
    this.disabilityFlag = disabilityFlag;
  }

  public void setBonus(Bonus bonus) {
    this.bonus = bonus;
  }

  public void setCapitalGain(CapitalGain capitalGain) {
    this.capitalGain = capitalGain;
  }

  public void setInterestReceived(InterestReceived interestReceived) {
    this.interestReceived = interestReceived;
  }

  public void setMedicalExpense(MedicalExpense medicalExpense) {
    this.medicalExpense = medicalExpense;
  }

  public void setRetirementFund(RetirementFund retirementFund) {
    this.retirementFund = retirementFund;
  }

  public void setSalary(Salary salary) {
    this.salary = salary;
  }

  public void setTravelAllowance(TravelAllowance travelAllowance) {
    this.travelAllowance = travelAllowance;
  }

  public void setNumberOfDependents(int numberOfDependents) {
    this.numberOfDependents = numberOfDependents;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public long getTaxNumber() {
    return taxNumber;
  }

  public int getAge() {
    return age;
  }

  public Bonus getBonus() {
    return bonus;
  }

  public CapitalGain getCapitalGain() {
    return capitalGain;
  }

  public InterestReceived getInterestReceived() {
    return interestReceived;
  }

  public MedicalExpense getMedicalExpense() {
    return medicalExpense;
  }

  public RetirementFund getRetirementFund() {
    return retirementFund;
  }

  public int getNumberOfDependents() {
    return numberOfDependents;
  }

  public Salary getSalary() {
    return salary;
  }

  public TravelAllowance getTravelAllowance() {
    return travelAllowance;
  }

  public boolean getDisabilityFlag() {
    return disabilityFlag;
  }

}
