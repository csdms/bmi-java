package edu.colorado.csdms.bmi;

/**
 * Get model information.
 * <p>
 * See the BMI <a href="https://bmi.readthedocs.io">documentation</a> for
 * detailed information about each function.
 */
public interface BmiInfo {

  public String getComponentName();
  public int getInputItemCount();
  public int getOutputItemCount();
  public String[] getInputVarNames();
  public String[] getOutputVarNames();
}
