package edu.colorado.csdms.bmi;

/**
 * Describe a grid of type <em>uniform_rectilinear</em>.
 * <p>
 * See the BMI <a href="https://bmi.readthedocs.io">documentation</a> for
 * detailed information about each function.
 */
public interface BmiGridUniformRectilinear extends BmiGrid {

  public int[] getGridShape(int gridId);
  public double[] getGridSpacing(int gridId);
  public double[] getGridOrigin(int gridId);
}
