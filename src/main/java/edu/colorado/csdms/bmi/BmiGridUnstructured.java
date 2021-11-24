package edu.colorado.csdms.bmi;

/**
 * Describe a grid of type <em>unstructured</em>, which includes the special
 * cases <em>scalar</em>, <em>points</em>, and <em>vector</em>.
 * <p>
 * See the BMI <a href="https://bmi.readthedocs.io">documentation</a> for
 * detailed information about each function.
 */
public interface BmiGridUnstructured extends BmiGrid {


  public double[] getGridX(int gridId);
  public double[] getGridY(int gridId);
  public double[] getGridZ(int gridId);
  public int getGridNodeCount(int gridId);
  public int getGridEdgeCount(int gridId);
  public int getGridFaceCount(int gridId);
  public int[] getGridEdgeNodes(int gridId);
  public int[] getGridFaceEdges(int gridId);
  public int[] getGridFaceNodes(int gridId);
  public int[] getGridNodesPerFace(int gridId);
}
