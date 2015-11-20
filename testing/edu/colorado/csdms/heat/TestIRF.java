package edu.colorado.csdms.heat;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit tests for the IRF methods of the {@link BmiHeat} class.
 */
public class TestIRF {
  
  private String name;
  private Double delta; // maximum difference to be considered equal
  private String[] inputVarNames;
  private String[] outputVarNames;

  @Before
  public void setUp() throws Exception {
    name = "The 2D Heat equation";
    delta = 0.1;
    inputVarNames = new String[] {"plate_surface__temperature"};
    outputVarNames = new String[] {"plate_surface__temperature"};
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public final void testInitializeString() {
    BmiHeat component = new BmiHeat();
    component.initialize("testing/data/heat.xml");
    assertNotNull(component);
    assertEquals(0.0, component.getCurrentTime(), delta);
  }

  @Test
  public final void testInitialize() {
    BmiHeat component = new BmiHeat();
    component.initialize();
    assertNotNull(component);
    assertEquals(0.0, component.getCurrentTime(), delta);
  }

  @Test
  public final void testUpdate() {
    BmiHeat component = new BmiHeat();
    component.initialize();
    
    Integer maxIter = 10;
    Double finalTime = maxIter * component.getTimeStep();
    for (int i = 0; i < maxIter; i++) {
      component.update();
    }
    assertEquals(finalTime, component.getCurrentTime(), delta);
  }

  @Test
  public final void testUpdateUntil() {
    BmiHeat component = new BmiHeat();
    component.initialize();
    component.updateUntil(10.1);
    assertEquals(10.1, component.getCurrentTime(), delta);
  }

  @Test
  public final void testFinalize() {
    return; // Nothing to test
  }

  @Test
  public final void testGetComponentName() {
    BmiHeat component = new BmiHeat();
    assertEquals(name, component.getComponentName());
  }

  @Test
  public final void testGetInputVarNames() {
    BmiHeat component = new BmiHeat();
    assertArrayEquals(inputVarNames, component.getInputVarNames());
  }

  @Test
  public final void testGetInputVarNameCount() {
    BmiHeat component = new BmiHeat();
    assertEquals(inputVarNames.length, component.getInputVarNameCount());
  }

  @Test
  public final void testGetOutputVarNames() {
    BmiHeat component = new BmiHeat();
    assertArrayEquals(outputVarNames, component.getOutputVarNames());
  }

  @Test
  public final void testGetOutputVarNameCount() {
    BmiHeat component = new BmiHeat();
    assertEquals(outputVarNames.length, component.getOutputVarNameCount());
  }

  @Test
  public final void testGetStartTime() {
    BmiHeat component = new BmiHeat();
    component.initialize();
    assertEquals(0.0, component.getStartTime(), delta);
  }

  @Test
  public final void testGetEndTime() {
    BmiHeat component = new BmiHeat();
    component.initialize();
    assertEquals(Double.MAX_VALUE, component.getEndTime(), delta);
  }

}
