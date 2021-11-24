package edu.colorado.csdms.bmi;

/**
 * Set variables in a model.
 * <p>
 * See the BMI <a href="https://bmi.readthedocs.io">documentation</a> for
 * detailed information about each function.
 */
public interface BmiSetter {

  public <T> void setValue(String varName, T[] src);
  public <T> void setValueAtIndices(String varName, int[] indices, T[] src);
}
