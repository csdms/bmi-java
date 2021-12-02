package edu.colorado.csdms.bmi;

/**
 * Describe a grid of type <em>unstructured</em>, which includes the special
 * cases <em>scalar</em>, <em>points</em>, and <em>vector</em>.
 * <p>
 * See the BMI <a href="https://bmi.readthedocs.io">documentation</a> for
 * detailed information about each function.
 */
public interface BmiGridUnstructured extends BmiGrid {

  public void getGridX(int gridId, double[] gridX);
  public void getGridY(int gridId, double[] gridY);
  public void getGridZ(int gridId, double[] gridZ);

  public int getGridNodeCount(int gridId);
  public int getGridEdgeCount(int gridId);
  public int getGridFaceCount(int gridId);

  public void getGridEdgeNodes(int gridId, int[] edgeNodes);
  public void getGridFaceEdges(int gridId, int[] faceEdges);
  public void getGridFaceNodes(int gridId, int[] faceNodes);
  public void getGridNodesPerFace(int gridId, int[] nodesPerFace);
}
