package edu.colorado.csdms.bmi;

/**
 * Describe a grid of type <em>rectilinear</em>.
 * <p>
 * See the BMI <a href="https://bmi.readthedocs.io">documentation</a> for
 * detailed information about each function.
 */
public interface BmiGridRectilinear extends BmiGrid {

  public int[] getGridShape(int gridId);
  public double[] getGridX(int gridId);
  public double[] getGridY(int gridId);
  public double[] getGridZ(int gridId);
}
