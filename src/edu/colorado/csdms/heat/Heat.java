/**
 * The 2D heat equation.
 */
package edu.colorado.csdms.heat;

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
  private List<Double> temperature;
  private List<Double> nextTemperature;

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

    this.shape.add(0, nRows);
    this.shape.add(1, nCols);
    this.spacing.add(0, dx);
    this.spacing.add(1, dy);
    this.origin.add(0, xStart);
    this.origin.add(1, yStart);
    this.alpha = alpha;
    this.time = 0.0;

    Double minSpacing = Math.min(this.spacing.get(0), this.spacing.get(1));
    this.timeStep = Math.pow(minSpacing, 2.0) / (4.0 * this.alpha);

    // Double ran = Math.random();
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

  public List<Double> getTemperature() {
    return temperature;
  }

  public void setTemperature(List<Double> temperature) {
    this.temperature = temperature;
  }

  public List<Double> getNextTemperature() {
    return nextTemperature;
  }

  public void setNextTemperature(List<Double> nextTemperature) {
    this.nextTemperature = nextTemperature;
  }

  /**
   * Calculate new temperatures for the next time step.
   */
  public void advanceInTime() {
    ;
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    ;
  }

}
