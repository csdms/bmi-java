/**
 * The 2D heat equation.
 */
package edu.colorado.csdms.heat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Solve the heat equation on a grid.
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
    temperature = new double[shape.get(0)][shape.get(1)];
    for (int i = 0; i < shape.get(1); i++) {
      temperature[0][i] = 20.0;
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
   * @param fileName a YAML file with Heat model settings
   */
  public Heat(String fileName) {
    ;
  }

  public List<Integer> getShape() {
    return shape;
  }

  public void setShape(List<Integer> shape) {
    this.shape = shape;
  }

  public List<Double> getSpacing() {
    return spacing;
  }

  public void setSpacing(List<Double> spacing) {
    this.spacing = spacing;
  }

  public List<Double> getOrigin() {
    return origin;
  }

  public void setOrigin(List<Double> origin) {
    this.origin = origin;
  }

  public Double getAlpha() {
    return alpha;
  }

  public void setAlpha(Double alpha) {
    this.alpha = alpha;
  }

  public Double getTime() {
    return time;
  }

  public void setTime(Double time) {
    this.time = time;
  }

  public Double getTimeStep() {
    return timeStep;
  }

  public void setTimeStep(Double timeStep) {
    this.timeStep = timeStep;
  }

  public double[][] getTemperature() {
    return temperature;
  }

  public void setTemperature(double[][] temperature) {
    this.temperature = temperature;
  }

  /**
   * Clones a 2D double array.
   *
   * @param array a 2d array of type double
   * @return a clone of the input array
   * @see http://stackoverflow.com/a/1686523/1563298
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
   * @param args
   */
  public static void main(String[] args) {
    System.out.println("Example of using Heat class");
    Heat heat = new Heat();
    System.out.println("shape: " + heat.getShape().toString());
    System.out.println("spacing: " + heat.getSpacing().toString());
    System.out.println("origin: " + heat.getOrigin().toString());

    Double currentTime = heat.getTime();
    while (currentTime < 1.0) {
      System.out.println("time = " + currentTime.toString());
      double[][] temp = heat.getTemperature();
      System.out.println("temperature: " + Arrays.deepToString(temp));
      heat.advanceInTime();
      currentTime = heat.getTime();
    }
  }

}
