package edu.colorado.csdms.bmi;

/**
 * Describe a model grid. Used for all grid types.
 * <p>
 * See the BMI <a href="https://bmi.readthedocs.io">documentation</a> for
 * detailed information about each function.
 */
public interface BmiGrid {

  public int getGridRank(int gridId);
  public int getGridSize(int gridId);
  public String getGridType(int gridId);
}
