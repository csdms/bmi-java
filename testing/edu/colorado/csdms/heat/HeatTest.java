package edu.colorado.csdms.heat;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit tests for the Heat class.
 */
public class HeatTest {

  private List<Integer> shape;
  private List<Double> spacing;
  private List<Double> origin;
  private Double alpha;
  private Double time;
  private Double timeStep;
  private double[][] temperature;
  private Heat heat;
  
  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
    Integer nRows = 10;
    Integer nCols = 20;
    Double dx = 1.0;
    Double dy = 1.0;
    Double xStart = 0.0;
    Double yStart = 0.0;
    alpha = 1.0;

    heat = new Heat(nRows, nCols, dx, dy, xStart, yStart, alpha);

    time = 0.0;
    timeStep = 0.25;
    shape = new ArrayList<Integer>(Arrays.asList(nRows, nCols));
    spacing = new ArrayList<Double>(Arrays.asList(dx, dy));
    origin = new ArrayList<Double>(Arrays.asList(xStart, yStart));

    temperature = new double[shape.get(0)][shape.get(1)];
    for (int i = 0; i < shape.get(1); i++) {
      temperature[0][i] = 20.0;
    }

  }

  /**
   * @throws java.lang.Exception
   */
  @After
  public void tearDown() throws Exception {
  }

  /**
   * Test method for {@link edu.colorado.csdms.heat.Heat#Heat(java.lang.Integer, java.lang.Integer, java.lang.Double, java.lang.Double, java.lang.Double, java.lang.Double, java.lang.Double)}.
   */
  @Test
  public final void testHeatIntegerIntegerDoubleDoubleDoubleDoubleDouble() {
    Integer nRows = 10;
    Integer nCols = 20;
    Double dx = 1.0;
    Double dy = 1.0;
    Double xStart = 0.0;
    Double yStart = 0.0;
    alpha = 1.0;
    Heat newHeat = new Heat(nRows, nCols, dx, dy, xStart, yStart, alpha);
    assertNotNull(newHeat);
  }

  /**
   * Test method for {@link edu.colorado.csdms.heat.Heat#Heat()}.
   */
  @Test
  public final void testHeat() {
    Heat newHeat = new Heat();
    assertNotNull(newHeat);
  }

  /**
   * Test method for {@link edu.colorado.csdms.heat.Heat#Heat(java.lang.String)}.
   */
  @Test
  public final void testHeatString() {
    fail("Not yet implemented"); // TODO
  }

  /**
   * Test method for {@link edu.colorado.csdms.heat.Heat#getShape()}.
   */
  @Test
  public final void testGetShape() {
    assertEquals(shape, heat.getShape());
  }

  /**
   * Test method for {@link edu.colorado.csdms.heat.Heat#setShape(java.util.List)}.
   */
  @Test
  public final void testSetShape() {
    List<Integer> newShape = new ArrayList<Integer>();
    newShape.add(100);
    newShape.add(50);
    heat.setShape(newShape);
    assertEquals(newShape, heat.getShape());
  }

  /**
   * Test method for {@link edu.colorado.csdms.heat.Heat#getSpacing()}.
   */
  @Test
  public final void testGetSpacing() {
    assertEquals(spacing, heat.getSpacing());
  }

  /**
   * Test method for {@link edu.colorado.csdms.heat.Heat#setSpacing(java.util.List)}.
   */
  @Test
  public final void testSetSpacing() {
    List<Double> newSpacing = new ArrayList<Double>();
    newSpacing.add(500.0);
    newSpacing.add(250.0);
    heat.setSpacing(newSpacing);
    assertEquals(newSpacing, heat.getSpacing());
  }

  /**
   * Test method for {@link edu.colorado.csdms.heat.Heat#getOrigin()}.
   */
  @Test
  public final void testGetOrigin() {
    assertEquals(origin, heat.getOrigin());
  }

  /**
   * Test method for {@link edu.colorado.csdms.heat.Heat#setOrigin(java.util.List)}.
   */
  @Test
  public final void testSetOrigin() {
    List<Double> newOrigin = new ArrayList<Double>();
    newOrigin.add(10.0);
    newOrigin.add(15.0);
    heat.setOrigin(newOrigin);
    assertEquals(newOrigin, heat.getOrigin());
  }

  /**
   * Test method for {@link edu.colorado.csdms.heat.Heat#getAlpha()}.
   */
  @Test
  public final void testGetAlpha() {
    assertEquals(alpha, heat.getAlpha());
  }

  /**
   * Test method for {@link edu.colorado.csdms.heat.Heat#setAlpha(java.lang.Double)}.
   */
  @Test
  public final void testSetAlpha() {
    Double newAlpha = 0.2;
    heat.setAlpha(newAlpha);
    assertEquals(newAlpha, heat.getAlpha());
  }

  /**
   * Test method for {@link edu.colorado.csdms.heat.Heat#getTime()}.
   */
  @Test
  public final void testGetTime() {
    assertEquals(time, heat.getTime());
  }

  /**
   * Test method for {@link edu.colorado.csdms.heat.Heat#setTime(java.lang.Double)}.
   */
  @Test
  public final void testSetTime() {
    Double newTime = 42.0;
    heat.setTime(newTime);
    assertEquals(newTime, heat.getTime());
  }

  /**
   * Test method for {@link edu.colorado.csdms.heat.Heat#getTimeStep()}.
   */
  @Test
  public final void testGetTimeStep() {
    assertTrue(heat.getTimeStep() > 0.0);
  }

  /**
   * Test method for {@link edu.colorado.csdms.heat.Heat#setTimeStep(java.lang.Double)}.
   */
  @Test
  public final void testSetTimeStep() {
    Double newTimeStep = 5.0;
    heat.setTimeStep(newTimeStep);
    assertEquals(newTimeStep, heat.getTimeStep());
  }

  /**
   * Test method for {@link edu.colorado.csdms.heat.Heat#getTemperature()}.
   */
  @Test
  public final void testGetTemperature() {
    fail("Not yet implemented"); // TODO
  }

  /**
   * Test method for {@link edu.colorado.csdms.heat.Heat#setTemperature(double[][])}.
   */
  @Test
  public final void testSetTemperature() {
    fail("Not yet implemented"); // TODO
  }

  /**
   * Test method for {@link edu.colorado.csdms.heat.Heat#advanceInTime()}.
   */
  @Test
  public final void testAdvanceInTime() {
    fail("Not yet implemented"); // TODO
  }

}
