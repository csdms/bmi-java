package edu.colorado.csdms.bmi;

/**
 * Describe a grid of type <em>rectilinear</em>.
 * <p>
 * See the BMI <a href="https://bmi.readthedocs.io">documentation</a> for
 * detailed information about each function.
 */
public interface BmiGridRectilinear extends BmiGrid {

  public void getGridShape(int gridId, int[] gridShape);
  public void getGridX(int gridId, double[] gridX);
  public void getGridY(int gridId, double[] gridY);
  public void getGridZ(int gridId, double[] gridZ);
}
