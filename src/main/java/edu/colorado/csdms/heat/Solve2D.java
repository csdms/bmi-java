package edu.colorado.csdms.heat;

import java.util.List;

/**
 * A solver for the 2D heat equation on a uniform grid.
 */
public class Solve2D {

  /**
   * Solve the 2D heat equation on a uniform grid.
   * 
   * @param temperature a 2D array of temperatures
   * @param shape the dimensions of the grid, in (rows, cols)
   * @param spacing the distance between rows and columns, respectively
   * @param alpha parameter in heat equation
   * @param timeStep current time step
   * @return the temperatures after timeStep
   */
  public static double[][] solve(double[][] temperature, List<Integer> shape,
      List<Double> spacing, Double alpha, Double timeStep) {

    Integer topRowIndex = shape.get(1) - 1;
    Integer topColIndex = shape.get(0) - 1;
    Double dx2 = Math.pow(spacing.get(0), 2.0);
    Double dy2 = Math.pow(spacing.get(1), 2.0);
    Double c = alpha * timeStep / (dx2 + dy2);
    double[][] newTemperature = new double[shape.get(1)][shape.get(0)];
    
    for (int i = 1; i < topRowIndex; i++) {
      for (int j = 1; j < topColIndex; j++) {
        Double rowOp = dx2 * (temperature[i][j - 1] + temperature[i][j + 1]);
        Double colOp = dy2 * (temperature[i - 1][j] + temperature[i + 1][j]);
        newTemperature[i][j] =
            c * (rowOp + colOp - 2.0 * (dx2 + dy2) * temperature[i][j]);
      }
    }

    for (int j = 0; j < shape.get(0); j++) {
      newTemperature[0][j] = 0.0;
      newTemperature[topRowIndex][j] = 0.0;
    }

    for (int i = 0; i < shape.get(1); i++) {
      newTemperature[i][0] = 0.0;
      newTemperature[i][topColIndex] = 0.0;
    }

    for (int i = 1; i < topRowIndex; i++) {
      for (int j = 1; j < topColIndex; j++) {
        newTemperature[i][j] += temperature[i][j];
      }
    }
    
    return newTemperature;
  }
}
