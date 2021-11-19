/**
 * Interface that describes structured quadrilateral grids.
 */
package edu.colorado.csdms.bmi;

/**
 * Methods that describe a structured grid of quadrilaterals.
 *
 * @author mpiper
 * @version $Id: $Id
 */
public interface BmiGridStructuredQuad extends BmiGrid {

  /**
   * Get the dimensions of the computational grid.
   *
   * @param gridId a grid identifier from {@link edu.colorado.csdms.bmi.BmiVars#getVarGrid(String)}
   * @return the dimensions of the grid
   */
  int[] getGridShape(int gridId);

  /**
   * Get the coordinates of the grid nodes in the streamwise direction.
   *
   * @param gridId a grid identifier from {@link edu.colorado.csdms.bmi.BmiVars#getVarGrid(String)}
   * @return the locations of the grid nodes
   */
  double[] getGridX(int gridId);

  /**
   * Get the coordinates of the grid nodes in the transverse direction.
   *
   * @param gridId a grid identifier from {@link edu.colorado.csdms.bmi.BmiVars#getVarGrid(String)}
   * @return the locations of the grid nodes
   */
  double[] getGridY(int gridId);

  /**
   * Get the coordinates of the grid nodes in the normal direction.
   *
   * @param gridId a grid identifier from {@link edu.colorado.csdms.bmi.BmiVars#getVarGrid(String)}
   * @return the locations of the grid nodes
   */
  double[] getGridZ(int gridId);

}
