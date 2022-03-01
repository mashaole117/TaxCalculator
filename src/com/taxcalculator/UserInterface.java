package com.taxcalculator;

import com.taxcalculator.calculatorcomponents.TaxPayer;
import com.taxcalculator.databasecommunication.DatabaseManipulation;
import com.taxcalculator.expense.*;
import com.taxcalculator.income.*;

import java.sql.SQLException;
import java.util.Scanner;

public class UserInterface {

  private final Scanner in = new Scanner(System.in);

  private final DatabaseManipulation databaseManipulation = new DatabaseManipulation();

  public TaxPayer taxPayer;

  private void newUserInput(TaxPayer taxPayer){
    System.out.println("Enter your first name: ");
    in.nextLine();
    taxPayer.setFirstName(in.nextLine());

    System.out.println("Enter your last name: ");
    taxPayer.setLastName(in.nextLine());

    System.out.println("Enter your age: ");
    taxPayer.setAge(in.nextInt());

    System.out.println("Do you have a disability (y/n)?: ");
    if (in.next().charAt(0) == 'y')
      taxPayer.setDisabilityFlag(true);

    System.out.println("How many dependants do you have (including a spouse)?: ");
    taxPayer.setNumberOfDependents(in.nextInt());

    System.out.println("Enter your salary earned over the year: ");
    taxPayer.setSalary(new Salary(in.nextDouble()));

    System.out.println("Enter your bonuses earned over the year: ");
    taxPayer.setBonus(new Bonus(in.nextDouble()));

    System.out.println("Enter the interest received over for the year: ");
    taxPayer.setInterestReceived(new InterestReceived(in.nextDouble(), taxPayer.getAge()));

    System.out.println("Enter the capital gains received over the year: ");
    double gain = in.nextDouble();
    System.out.println("Enter the exemption received over the year: ");
    double capitalGainExemption = in.nextDouble();
    taxPayer.setCapitalGain(new CapitalGain(gain, capitalGainExemption));

    System.out.println("Enter your retirement funding for the year: ");
    taxPayer.setRetirementFund(new RetirementFund(in.nextDouble()));

    System.out.println("Enter your medical aid contributions for the year: ");
    double contributions = in.nextDouble();
    System.out.println("Enter your medical expenses for the year: ");
    double qualifyingMedicalExpense = in.nextDouble();
    taxPayer.setMedicalExpense(new MedicalExpense(contributions, qualifyingMedicalExpense));

    System.out.println("To calculate travel allowance, enter the value of the vehicle: ");
    double vehicleValue = in.nextDouble();
    System.out.println("To calculate travel allowance, enter the distance travelled: ");
    double distanceTravelled = in.nextDouble();
    taxPayer.setTravelAllowance(new TravelAllowance(vehicleValue, distanceTravelled));

    try {
      databaseManipulation.addTaxPayerToTable(taxPayer);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public TaxPayer userInput() {
    System.out.println("Enter your tax number: ");
    long taxNumber = in.nextLong();
    if (databaseManipulation.retrieveTaxPayerDetails(taxNumber) == null) {
      System.out.println("Could not find tax number in our records. Create a new user? (y/n)");
      if (in.next().charAt(0) == 'y') {
        taxPayer.setTaxNumber(taxNumber);
        newUserInput(taxPayer);
      } else {
        System.out.println("Try again.");
        System.exit(0);
      }
    } else {
      taxPayer = databaseManipulation.retrieveTaxPayerDetails(taxNumber);
      System.out.println("Welcome back " + taxPayer.getFirstName() + " " + taxPayer.getLastName() + ", your tax number is in our records.\n");
    }
    return taxPayer;
  }

  public void taxCalculatorOutput(final double netTaxPayable, final double taxTableTaxPayable,
                                  final double taxPayableAfterRebates, final double netTaxableIncome) {
    System.out.println("Your net taxable income is: " + netTaxableIncome);
    System.out.println("Your tax payable from the tax tables: " + taxTableTaxPayable);
    System.out.println("Your tax payable after subtracting rebates: " + taxPayableAfterRebates);
    System.out.println("Your final net tax payable is: " + netTaxPayable);
  }

}
