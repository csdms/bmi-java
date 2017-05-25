/**
 * Interface that describes uniform rectilinear grids.
 */
package edu.colorado.csdms.bmi;

/**
 * Methods that describe a uniform rectilinear grid.
 * <p>
 * In a 2D uniform grid, every grid cell (or element) is a rectangle and all
 * cells have the same dimensions. If the dimensions are equal, then the grid is
 * a tiling of squares.
 * <p>
 * Each of these functions returns information about each dimension of a grid.
 * The dimensions are ordered with "ij" indexing (as opposed to "xy"). If there
 * were a third dimension, the length of the z dimension would be listed first.
 * Note that the grid shape is the number of nodes in the coordinate directions
 * and not the number of cells or elements. It is possible for grid values to be
 * associated with the nodes or with the cells.
 */
public interface BmiGridUniformRectilinear extends BmiGrid {

  /**
   * Get the dimensions of the computational grid.
   * 
   * @param gridId a grid identifier from {@link BmiVars#getVarGrid(String)}
   * @return the dimensions of the grid
   */
  public int[] getGridShape(int gridId);
  
  /**
   * Get the distance between the nodes of the computational grid.
   * 
   * @param gridId a grid identifier from {@link BmiVars#getVarGrid(String)}
   * @return the grid spacing
   */
  public double[] getGridSpacing(int gridId);

  /**
   * Get the coordinates for the origin of the computational grid.
   * 
   * @param gridId a grid identifier from {@link BmiVars#getVarGrid(String)}
   * @return the coordinates of the lower left corner of the grid
   */
  public double[] getGridOrigin(int gridId);
  
}
