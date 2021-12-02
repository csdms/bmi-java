package edu.colorado.csdms.bmi;

/**
 * Control model execution.
 * <p>
 * See the BMI <a href="https://bmi.readthedocs.io">documentation</a> for
 * detailed information about each function.
 */
public interface BmiControl {

  public void initialize(String configFile);
  public void initialize();
  public void update();
  public void updateUntil(double time);
  public void finalize();
}
