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

    Integer topRow = shape.get(0) - 1;
    Integer topCol = shape.get(1) - 1;
    Double dx2 = Math.pow(spacing.get(1), 2.0);
    Double dy2 = Math.pow(spacing.get(0), 2.0);
    Double c = alpha * timeStep / (dx2 + dy2);
    double[][] newTemperature = new double[shape.get(0)][shape.get(1)];
    
    for (int i = 1; i < topRow; i++) {
      for (int j = 1; j < topCol; j++) {
        Double rowOp = dx2 * (temperature[i][j - 1] + temperature[i][j + 1]);
        Double colOp = dy2 * (temperature[i - 1][j] + temperature[i + 1][j]);
        newTemperature[i][j] =
            c * (rowOp + colOp - 2.0 * (dx2 + dy2) * temperature[i][j]);
      }
    }

    for (int i = 0; i < shape.get(0); i++) {
      newTemperature[i][0] = 0.0;
      newTemperature[i][topCol] = 0.0;
    }

    for (int j = 0; j < shape.get(1); j++) {
      newTemperature[0][j] = 0.0;
      newTemperature[topRow][j] = 0.0;
    }

    for (int i = 1; i < topRow; i++) {
      for (int j = 1; j < topCol; j++) {
        newTemperature[i][j] += temperature[i][j];
      }
    }
    
    return newTemperature;
  }
}
