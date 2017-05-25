package edu.colorado.csdms.heat;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit tests for the grid information methods of the {@link BmiHeat} class.
 */
public class TestGridInfo {
  
  private String varName;
  private int gridId;
  private int[] shape;
  private double[] spacing;
  private double[] origin;
  private int size;
  private String type;
  private Double delta; // maximum difference to be considered equal

  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
    varName = "plate_surface__temperature";
    gridId = 0;
    shape = new int[] {10, 20};
    spacing = new double[] {1.0, 1.0};
    origin = new double[] {0.0, 0.0};
    size = 200;
    type = "uniform_rectilinear_grid";
    delta = 0.1;
  }

  /**
   * @throws java.lang.Exception
   */
  @After
  public void tearDown() throws Exception {
  }

  /**
   * Test method for {@link BmiHeat#getVarGrid(java.lang.String)}.
   */
  @Test
  public final void testGetVarGrid() {
    BmiHeat component = new BmiHeat();
    component.initialize();
    assertEquals(gridId, component.getVarGrid(varName));
  }

  /**
   * Test method for {@link BmiHeat#getGridShape(int)}.
   */
  @Test
  public final void testGetGridShape() {
    BmiHeat component = new BmiHeat();
    component.initialize();
    assertArrayEquals(shape, component.getGridShape(gridId));
  }

  /**
   * Test method for {@link BmiHeat#getGridX(int)}.
   */
  @Test
  public final void testGetGridX() {
    return; // Not implemented for Heat
  }

  /**
   * Test method for {@link BmiHeat#getGridY(int)}.
   */
  @Test
  public final void testGetGridY() {
    return; // Not implemented for Heat
  }

  /**
   * Test method for {@link BmiHeat#getGridZ(int)}.
   */
  @Test
  public final void testGetGridZ() {
    return; // Not implemented for Heat
  }

  /**
   * Test method for {@link BmiHeat#getGridRank(int)}.
   */
  @Test
  public final void testGetGridRank() {
    BmiHeat component = new BmiHeat();
    component.initialize();
    assertEquals(shape.length, component.getGridRank(gridId));
  }

  /**
   * Test method for {@link BmiHeat#getGridSize(int)}.
   */
  @Test
  public final void testGetGridSize() {
    BmiHeat component = new BmiHeat();
    component.initialize();
    assertEquals(size, component.getGridSize(gridId));
  }

  /**
   * Test method for {@link BmiHeat#getGridType(int)}.
   */
  @Test
  public final void testGetGridType() {
    BmiHeat component = new BmiHeat();
    component.initialize();
    assertEquals(type, component.getGridType(gridId));
  }

  /**
   * Test method for {@link BmiHeat#getGridSpacing(int)}.
   */
  @Test
  public final void testGetGridSpacing() {
    BmiHeat component = new BmiHeat();
    component.initialize();
    assertArrayEquals(spacing, component.getGridSpacing(gridId), delta);
  }

  /**
   * Test method for {@link BmiHeat#getGridOrigin(int)}.
   */
  @Test
  public final void testGetGridOrigin() {
    BmiHeat component = new BmiHeat();
    component.initialize();
    assertArrayEquals(origin, component.getGridOrigin(gridId), delta);
  }

  /**
   * Test method for {@link BmiHeat#getGridConnectivity(int)}.
   */
  @Test
  public final void testGetGridConnectivity() {
    return; // Not implemented for Heat
  }

  /**
   * Test method for {@link BmiHeat#getGridOffset(int)}.
   */
  @Test
  public final void testGetGridOffset() {
    return; // Not implemented for Heat
  }

}
