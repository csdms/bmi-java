/**
 * Interface that describes rectilinear grids.
 */
package edu.colorado.csdms.bmi;

/**
 * Methods that describe a rectilinear grid.
 * <p>
 * In a 2D rectilinear grid, every grid cell (or element) is a rectangle but
 * different cells can have different dimensions. All cells in the same row have
 * the same grid spacing in the y direction and all cells in the same column
 * have the same grid spacing in the x direction. Grid spacings can be computed
 * as the difference of successive x or y values.
 */
public interface BmiGridRectilinear extends BmiGrid {

  /**
   * Get the dimensions of the computational grid.
   * 
   * @param gridId a grid identifier from {@link BmiVars#getVarGrid(String)}
   * @return the dimensions of the grid
   */
  public int[] getGridShape(int gridId);

  /**
   * Get the coordinates of the grid nodes in the streamwise direction.
   * 
   * @param gridId a grid identifier from {@link BmiVars#getVarGrid(String)}
   * @return the locations of the grid nodes
   */
  public double[] getGridX(int gridId);

  /**
   * Get the coordinates of the grid nodes in the transverse direction.
   * 
   * @param gridId a grid identifier from {@link BmiVars#getVarGrid(String)}
   * @return the locations of the grid nodes
   */
  public double[] getGridY(int gridId);

  /**
   * Get the coordinates of the grid nodes in the normal direction.
   * 
   * @param gridId a grid identifier from {@link BmiVars#getVarGrid(String)}
   * @return the locations of the grid nodes
   */
  public double[] getGridZ(int gridId);
  
}
