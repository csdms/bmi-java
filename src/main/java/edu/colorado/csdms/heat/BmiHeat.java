/**
 * Basic Model Interface implementation for the 2D heat model.
 */
package edu.colorado.csdms.heat;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.colorado.csdms.bmi.BMI;

/**
 * BMI methods that wrap the {@link Heat} class.
 */
public class BmiHeat implements BMI {
  
  public static final String MODEL_NAME = "The 2D Heat equation"; 
  public static final String[] INPUT_VAR_NAMES = 
    {"plate_surface__temperature"};
  public static final String[] OUTPUT_VAR_NAMES = 
    {"plate_surface__temperature"};
  
  private Heat model;
  private HashMap<String, double[]> values;
  private HashMap<String, String> varUnits;
  private HashMap<Integer, String> grids;
  private HashMap<Integer, String> gridType;
  
  /**
   * Creates a new BmiHeat model that is ready for initialization.
   */
  public BmiHeat() {
    model = null;
    values = new HashMap<String, double[]>();
    varUnits = new HashMap<String, String>();
    grids = new HashMap<Integer, String>();
    gridType = new HashMap<Integer, String>();
  }
  
  @Override
  public void initialize(String configFile) {
    File theFile = new File(configFile);
    if (theFile.exists()) {
      model = new Heat(configFile);
      initializeHelper();
    }
  }

  @Override
  public void initialize() {
    model = new Heat();
    initializeHelper();
  }

  /**
   * Initializes BmiHeat properties using properties from the enclosed Heat
   * instance.
   */
  private void initializeHelper() {
    values.put(INPUT_VAR_NAMES[0], flattenArray2D(model.getTemperature()));
    varUnits.put(INPUT_VAR_NAMES[0], "K");
    grids.put(0, INPUT_VAR_NAMES[0]);
    gridType.put(0, "uniform_rectilinear_grid");
  }
  
  /**
   * A helper that converts a 2D array of doubles into a 1D array.
   *
   * @param array2D a 2D array of doubles
   * @return a 1D array of doubles
   */
  private double[] flattenArray2D(double[][] array2D) {
    int size1D = 0;
    for (double[] array : array2D) {
      size1D += array.length;
    }
    double[] array1D = new double[size1D];
    int pos = 0;
    for (double[] array : array2D) {
      System.arraycopy(array, 0, array1D, pos, array.length);
      pos += array.length;
    }
    return array1D;
  }

  @Override
  public void update() {
    model.advanceInTime();
  }

  @Override
  public void updateUntil(double then) {
    Double nSteps = (then - getCurrentTime()) / getTimeStep();
    for (int i = 0; i < Math.floor(nSteps); i++) {
      update();
    }
    updateFrac(nSteps - Math.floor(nSteps));
  }

  @Override
  public void updateFrac(double timeFrac) {
    double timeStep = getTimeStep();
    model.setTimeStep(timeFrac * timeStep);
    update();
    model.setTimeStep(timeStep);
  }

  @Override
  public void finalize() {
    // Nothing to do.
  }

  @Override
  public String getComponentName() {
    return MODEL_NAME;
  }

  @Override
  public String[] getInputVarNames() {
    return INPUT_VAR_NAMES;
  }

  @Override
  public int getInputVarNameCount() {
    return INPUT_VAR_NAMES.length;
  }

  @Override
  public String[] getOutputVarNames() {
    return OUTPUT_VAR_NAMES;
  }

  @Override
  public int getOutputVarNameCount() {
    return OUTPUT_VAR_NAMES.length;
  }

  @Override
  public double getStartTime() {
    return 0;
  }

  @Override
  public double getCurrentTime() {
    return model.getTime();
  }

  @Override
  public double getEndTime() {
    return Double.MAX_VALUE;
  }

  @Override
  public double getTimeStep() {
    return model.getTimeStep();
  }

  @Override
  public String getTimeUnits() {
    return null; // Not implemented for Heat
  }

  @Override
  public String getVarType(String varName) {
    return values.get(varName).getClass().getName();
  }

  @Override
  public String getVarUnits(String varName) {
    return varUnits.get(varName);
  }

  @Override
  public int getVarItemsize(String varName) {
    int itemSize = 0;
    if (getVarType(varName).equals("[D")) {
      itemSize = 8;
    }
    return itemSize;
  }

  @Override
  public int getVarNbytes(String varName) {
    return getVarItemsize(varName) * values.get(varName).length;
  }

  @Override
  public int getVarGrid(String varName) {
    for (Map.Entry<Integer, String> entry : grids.entrySet()) {
      if (entry.getValue().equals(varName)) {
        return entry.getKey();
      }
    }
    return -1;
  }

  @SuppressWarnings("unchecked")
  @Override
  public <T> T getValue(String varName) {
    return (T) values.get(varName).clone();
  }

  @SuppressWarnings("unchecked")
  @Override
  public <T> T getValueRef(String varName) {
    return (T) values.get(varName);
  }

  @Override
  public <T> T getValueAtIndices(String varName, int[] indices) {
    return null; // Not implemented
  }

  @Override
  public int[] getGridShape(int gridId) {
    List<Integer> shapeAsList = model.getShape();
    int[] shapeAsArray = new int[shapeAsList.size()];
    for (int i = 0; i < shapeAsArray.length; i++) {
      shapeAsArray[i] = shapeAsList.get(i);
    }
    return shapeAsArray;
  }

  @Override
  public double[] getGridX(int gridId) {
    return null; // Not implemented for Heat
  }

  @Override
  public double[] getGridY(int gridId) {
    return null; // Not implemented for Heat
  }

  @Override
  public double[] getGridZ(int gridId) {
    return null; // Not implemented for Heat
  }

  @Override
  public int getGridRank(int gridId) {
    List<Integer> shapeAsList = model.getShape();
    return shapeAsList.size();
  }

  @Override
  public int getGridSize(int gridId) {
    List<Integer> shapeAsList = model.getShape();
    int product = 1;
    for (int i = 0; i < shapeAsList.size(); i++) {
      product *= shapeAsList.get(i);
    }
    return product;
  }

  @Override
  public String getGridType(int gridId) {
    return gridType.get(gridId);
  }

  @Override
  public double[] getGridSpacing(int gridId) {
    List<Double> spacingAsList = model.getSpacing();
    double[] spacingAsArray = new double[spacingAsList.size()];
    for (int i = 0; i < spacingAsArray.length; i++) {
      spacingAsArray[i] = spacingAsList.get(i);
    }
    return spacingAsArray;
  }

  @Override
  public double[] getGridOrigin(int gridId) {
    List<Double> originAsList = model.getOrigin();
    double[] originAsArray = new double[originAsList.size()];
    for (int i = 0; i < originAsArray.length; i++) {
      originAsArray[i] = originAsList.get(i);
    }
    return originAsArray;
  }

  @Override
  public int[] getGridConnectivity(int gridId) {
    return null; // Not implemented for Heat
  }

  @Override
  public int[] getGridOffset(int gridId) {
    return null; // Not implemented for Heat
  }

  @Override
  public void setValue(String varName, double[] src) {
    double[] varRef = getValueRef(varName);
    for (int i = 0; i < varRef.length; i++) {
      varRef[i] = src[i];
    }
  }

  @Override
  public void setValue(String varName, int[] src) {
    return; // Not implemented for Heat
  }

  @Override
  public void setValue(String varName, String[] src) {
    return; // Not implemented for Heat
  }

  @Override
  public void setValueAtIndices(String varName, int[] indices, double[] src) {
    return; // Not implemented for Heat
  }

  @Override
  public void setValueAtIndices(String varName, int[] indices, int[] src) {
    return; // Not implemented for Heat
  }

  @Override
  public void setValueAtIndices(String varName, int[] indices, String[] src) {
    return; // Not implemented for Heat
  }
}
