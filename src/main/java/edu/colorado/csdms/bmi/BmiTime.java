package edu.colorado.csdms.bmi;

/**
 * Get model time information.
 * <p>
 * See the BMI <a href="https://bmi.readthedocs.io">documentation</a> for
 * detailed information about each function.
 */
public interface BmiTime {

  public double getCurrentTime();
  public double getStartTime();
  public double getEndTime();
  public String getTimeUnits();
  public double getTimeStep();
}
