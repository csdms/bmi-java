package edu.colorado.csdms.bmi;

/**
 * Set variables in a model.
 * <p>
 * See the BMI <a href="https://bmi.readthedocs.io">documentation</a> for
 * detailed information about each function.
 */
public interface BmiSetter {

  public void setValue(String varName, double[] src);
  public void setValue(String varName, int[] src);
  public void setValue(String varName, String[] src);

  public void setValueAtIndices(String varName, int[] indices, double[] src);
  public void setValueAtIndices(String varName, int[] indices, int[] src);
  public void setValueAtIndices(String varName, int[] indices, String[] src);
}
