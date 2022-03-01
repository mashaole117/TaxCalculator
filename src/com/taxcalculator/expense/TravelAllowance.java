package com.taxcalculator.expense;

public class TravelAllowance extends Expense {

  private static final double EXEMPTION = 80000;

  private final double vehicleValue;

  private final double distanceTravelled;

  private double deductible;

  public TravelAllowance(final double vehicleValue, final double distanceTravelled) {
    super(0, EXEMPTION);
    this.vehicleValue = vehicleValue;
    this.distanceTravelled = distanceTravelled;
  }

  public double getVehicleValue() {
    return vehicleValue;
  }

  public double getDistanceTravelled() {
    return distanceTravelled;
  }

  public double calculateDeductible() {
    if (this.vehicleValue <= 95000)
      this.amount = 29504 + 1.401 * this.distanceTravelled + 0.386 * this.distanceTravelled;
    else if (this.vehicleValue <= 190000)
      this.amount = 52226 + 1.162 * this.distanceTravelled + 0.483 * this.distanceTravelled;
    else if (this.vehicleValue <= 285000)
      this.amount = 75039 + 1.263 * this.distanceTravelled + 0.532 * this.distanceTravelled;
    else if (this.vehicleValue <= 380000)
      this.amount = 94871 + 1.358 * this.distanceTravelled + 0.581 * this.distanceTravelled;
    else if (this.vehicleValue <= 475000)
      this.amount = 114781 + 1.453 * this.distanceTravelled + 0.683 * this.distanceTravelled;
    else if (this.vehicleValue <= 570000)
      this.amount = 135746 + 1.667 * this.distanceTravelled + 0.802 * this.distanceTravelled;
    else
      this.amount = 156711 + 1.724 * this.distanceTravelled + 0.996 * this.distanceTravelled;

    return this.deductible = Math.min(this.amount, EXEMPTION);
  }

}
