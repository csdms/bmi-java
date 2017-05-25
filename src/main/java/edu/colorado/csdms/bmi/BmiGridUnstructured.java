/**
 * Interface that describes unstructured grids.
 */
package edu.colorado.csdms.bmi;

/**
 * Methods that describe an unstructured grid.
 */
public interface BmiGridUnstructured extends BmiGrid {

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

  /**
   * Get the connectivity array of the grid.
   *  
   * @param gridId a grid identifier from {@link BmiVars#getVarGrid(String)}
   * @return the graph of connections between the grid nodes
   */
  public int[] getGridConnectivity(int gridId);
  
  /**
   * Get offsets for the grid nodes.
   * 
   * @param gridId a grid identifier from {@link BmiVars#getVarGrid(String)}
   * @return the offsets for the grid nodes
   */
  public int[] getGridOffset(int gridId);
  
}
