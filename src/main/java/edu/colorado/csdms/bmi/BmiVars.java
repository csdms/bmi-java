package edu.colorado.csdms.bmi;

/**
 * Get information about model exchange items.
 * <p>
 * See the BMI <a href="https://bmi.readthedocs.io">documentation</a> for
 * detailed information about each function.
 */
public interface BmiVars {

  public int getVarGrid(String varName);
  public String getVarType(String varName);
  public String getVarUnits(String varName);
  public int getVarItemsize(String varName);
  public int getVarNbytes(String varName);  
  public String getVarLocation(String varName);
}
