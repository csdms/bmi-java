/**
 * The 2D heat equation.
 */
package edu.colorado.csdms.heat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Solve the heat equation on a grid.
 *
 * @author mpiper
 * @version $Id: $Id
 */
public class Heat {

  private List<Integer> shape;
  private List<Double> spacing;
  private List<Double> origin;
  private Double alpha;
  private Double time;
  private Double timeStep;
  private double[][] temperature;

  /**
   * Create a new Heat model.
   *
   * @param nRows the number of rows in the solution grid
   * @param nCols the number of columns in the solution grid
   * @param dx distance between columns in grid
   * @param dy distance between rows in grid
   * @param xStart coordinates of lower left corner of grid
   * @param yStart coordinates of lower left corner of grid
   * @param alpha parameter in heat equation
   */
  public Heat(Integer nRows, Integer nCols, Double dx, Double dy,
      Double xStart, Double yStart, Double alpha) {

    shape = new ArrayList<Integer>(Arrays.asList(nRows, nCols));
    spacing = new ArrayList<Double>(Arrays.asList(dx, dy));
    origin = new ArrayList<Double>(Arrays.asList(xStart, yStart));
    this.alpha = alpha;
    time = 0.0;

    Double minSpacing = Math.min(spacing.get(0), spacing.get(1));
    timeStep = Math.pow(minSpacing, 2.0) / (4.0 * this.alpha);

    // Initialize temperature of plate. The top row is hot.
    temperature = new double[shape.get(1)][shape.get(0)];
    for (int i = 0; i < shape.get(1); i++) {
      temperature[i][0] = 20.0;
    }
  }

  /**
   * Create a Heat model using default parameter values.
   */
  public Heat() {
    this(10, 20, 1.0, 1.0, 0.0, 0.0, 1.0);
  }

  /**
   * Create a Heat model from settings in a file.
   *
   * @param fileName an XML file with Heat model settings
   */
  public Heat(String fileName) {
    this(config(fileName).get("nRows").intValue(),
        config(fileName).get("nCols").intValue(),
        config(fileName).get("dx"),
        config(fileName).get("dy"),
        config(fileName).get("xStart"),
        config(fileName).get("yStart"),
        config(fileName).get("alpha"));
  }

  /**
   * A helper method for returning parameters read from a model configuration
   * file. This is a workaround for requiring "this()" to be the first statement
   * in a constructor.
   */
  private static HashMap<String, Double> config(String fileName) {
    HeatConfigFile h = new HeatConfigFile(fileName);
    return h.load();
  }

  /**
   * <p>Getter for the field <code>shape</code>.</p>
   *
   * @return a {@link java.util.List} object.
   */
  public List<Integer> getShape() {
    return shape;
  }

  /**
   * <p>Setter for the field <code>shape</code>.</p>
   *
   * @param shape a {@link java.util.List} object.
   */
  public void setShape(List<Integer> shape) {
    this.shape = shape;
  }

  /**
   * <p>Getter for the field <code>spacing</code>.</p>
   *
   * @return a {@link java.util.List} object.
   */
  public List<Double> getSpacing() {
    return spacing;
  }

  /**
   * <p>Setter for the field <code>spacing</code>.</p>
   *
   * @param spacing a {@link java.util.List} object.
   */
  public void setSpacing(List<Double> spacing) {
    this.spacing = spacing;
  }

  /**
   * <p>Getter for the field <code>origin</code>.</p>
   *
   * @return a {@link java.util.List} object.
   */
  public List<Double> getOrigin() {
    return origin;
  }

  /**
   * <p>Setter for the field <code>origin</code>.</p>
   *
   * @param origin a {@link java.util.List} object.
   */
  public void setOrigin(List<Double> origin) {
    this.origin = origin;
  }

  /**
   * <p>Getter for the field <code>alpha</code>.</p>
   *
   * @return a {@link java.lang.Double} object.
   */
  public Double getAlpha() {
    return alpha;
  }

  /**
   * <p>Setter for the field <code>alpha</code>.</p>
   *
   * @param alpha a {@link java.lang.Double} object.
   */
  public void setAlpha(Double alpha) {
    this.alpha = alpha;
  }

  /**
   * <p>Getter for the field <code>time</code>.</p>
   *
   * @return a {@link java.lang.Double} object.
   */
  public Double getTime() {
    return time;
  }

  /**
   * <p>Setter for the field <code>time</code>.</p>
   *
   * @param time a {@link java.lang.Double} object.
   */
  public void setTime(Double time) {
    this.time = time;
  }

  /**
   * <p>Getter for the field <code>timeStep</code>.</p>
   *
   * @return a {@link java.lang.Double} object.
   */
  public Double getTimeStep() {
    return timeStep;
  }

  /**
   * <p>Setter for the field <code>timeStep</code>.</p>
   *
   * @param timeStep a {@link java.lang.Double} object.
   */
  public void setTimeStep(Double timeStep) {
    this.timeStep = timeStep;
  }

  /**
   * <p>Getter for the field <code>temperature</code>.</p>
   *
   * @return an array of double.
   */
  public double[][] getTemperature() {
    return temperature;
  }

  /**
   * <p>Setter for the field <code>temperature</code>.</p>
   *
   * @param temperature an array of double.
   */
  public void setTemperature(double[][] temperature) {
    this.temperature = temperature;
  }

  /**
   * Clones a 2D double array.
   * <p>
   * See http://stackoverflow.com/a/1686523/1563298
   * 
   * @param array a 2d array of type double
   * @return a clone of the input array
   */
  private double[][] cloneArray2D(double[][] array) {
    double [][] clone = new double[array.length][];
    for (int i = 0; i < array.length; i++) {
      clone[i] = array[i].clone();
    }
    return clone;
  }

  /**
   * Calculate new temperatures for the next time step.
   */
  public void advanceInTime() {
    double[][] copy = cloneArray2D(temperature);
    temperature = Solve2D.solve(copy, shape, spacing, alpha, timeStep);
    time += timeStep;
  }

  /**
   * <p>main.</p>
   *
   * @param args an array of {@link java.lang.String} objects.
   */
  public static void main(String[] args) {
    System.out.println("Example of using Heat class");
    Heat heat = new Heat("src/test/resources/data/heat.xml");
    System.out.println("shape: " + heat.getShape().toString());
    System.out.println("spacing: " + heat.getSpacing().toString());
    System.out.println("origin: " + heat.getOrigin().toString());

    double[][] temp = heat.getTemperature();

    // Print first column.
    double[] col0 = temp[0];
    System.out.println("Col0 = ");
    System.out.println(Arrays.toString(col0));

    // Print first row.
    double[] row0 = new double[heat.getShape().get(1)];
    for (int i = 0; i < row0.length; i++) {
      row0[i] = temp[i][0];
    }
    System.out.println("Row0 = ");
    System.out.println(Arrays.toString(row0));

    // Advance over several time steps.
    Double currentTime = heat.getTime();
    while (currentTime < 1.0) {
      System.out.println("time = " + currentTime.toString());
      System.out.println("temperature: "
          + Arrays.deepToString(heat.getTemperature()));
      heat.advanceInTime();
      currentTime = heat.getTime();
    }
  }

}
