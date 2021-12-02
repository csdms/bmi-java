package edu.colorado.csdms.bmi;

/**
 * Get variables from a model.
 * <p>
 * See the BMI <a href="https://bmi.readthedocs.io">documentation</a> for
 * detailed information about each function.
 */ 
public interface BmiGetter {

  public void getValue(String varName, double[] dest);
  public void getValue(String varName, int[] dest);
  public void getValue(String varName, String[] dest);

  public <T> T getValuePtr(String varName);

  public void getValueAtIndices(String varName, double[] dest, int[] indices);
  public void getValueAtIndices(String varName, int[] dest, int[] indices);
  public void getValueAtIndices(String varName, String[] dest, int[] indices);
}
