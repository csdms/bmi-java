/**
 * Interface that describes structured and unstructured grids.
 */
package edu.colorado.csdms.bmi;

/**
 * Methods that describe a grid.
 */
public interface BmiGrid {

  /**
   * Get the number of dimensions of the computational grid.
   * 
   * @param gridId a grid identifier from {@link BmiVars#getVarGrid(String)}
   * @return the rank of the grid 
   */
  public int getGridRank(int gridId);
  
  /**
   * Get the total number of elements in the computational grid.
   * 
   * @param gridId a grid identifier from {@link BmiVars#getVarGrid(String)}
   * @return the size of the grid
   */
  public int getGridSize(int gridId);
  
  /**
   * Get the grid type as a String. 
   *
   * @param gridId a grid identifier from {@link BmiVars#getVarGrid(String)}
   * @return the type of grid
   */
  public String getGridType(int gridId);
  
}
