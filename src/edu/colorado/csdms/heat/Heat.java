/**
 * The 2D heat equation.
 */
package edu.colorado.csdms.heat;

import java.util.List;

/**
 * Solve the heat equation on a grid.
 */
public class Heat {

  private List<Double> shape;
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
   * @param shape the shape of the solution grid as (rows,columns)
   * @param spacing distance between rows and columns
   * @param origin coordinates of lower left corner of grid
   * @param alpha parameter in heat equation
   */
  public Heat(List<Double> shape, List<Double> spacing, List<Double> origin,
      Double alpha) {
    ;
  }

  /**
   * Create a Heat model from settings in a file.
   * 
   * @param fileName a YAML file with Heat model settings
   */
  public Heat(String fileName) {
    ;
  }

  public List<Double> getShape() {
    return shape;
  }

  public void setShape(List<Double> shape) {
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
