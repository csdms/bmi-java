package edu.colorado.csdms.bmi;

/**
 * Get variables from a model.
 * <p>
 * See the BMI <a href="https://bmi.readthedocs.io">documentation</a> for
 * detailed information about each function.
 */ 
public interface BmiGetter {

  public <T> T getValue(String varName);
  public <T> T getValueRef(String varName);
  public <T> T getValueAtIndices(String varName, int[] indices);
}
