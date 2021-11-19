/**
 * Interface that describes a model's input and output variables.
 */
package edu.colorado.csdms.bmi;

/**
 * Methods that get information about input and output variables. These BMI
 * functions obtain information about a particular input or output variable.
 * They must accommodate any variable that is returned by the BMI functions
 * {@link edu.colorado.csdms.bmi.BmiInfo#getInputVarNames()} or
 * {@link edu.colorado.csdms.bmi.BmiInfo#getOutputVarNames()}.
 *
 * @author mpiper
 * @version $Id: $Id
 */
public interface BmiVars {

  /**
   * Get the data type of the given variable.
   *
   * @param varName an input or output variable name, a CSDMS Standard Name
   * @return the variable type; e.g., <code>int</code>, <code>double</code>,
   *         <code>String</code>.
   */
  String getVarType(String varName);

  /**
   * Get units of the given variable. Standard unit names, in lower case, should
   * be used, such as "meters" or "seconds". Standard
   * abbreviations, like "m" for meters, are also supported. For
   * variables with compound units, each unit name is separated by a single
   * space, with exponents other than 1 placed immediately after the name, as in
   * "m s-1" for velocity, "W m-2" for an energy flux, or
   * "km2" for an area.
   *
   * @param varName an input or output variable name, a CSDMS Standard Name
   * @return the variable units
   */
  String getVarUnits(String varName);

  /**
   * Gets the memory use for each array element in bytes.
   *
   * @param varName an input or output variable name, a CSDMS Standard Name
   * @return item size in bytes
   */
  int getVarItemsize(String varName);

  /**
   * Gets the total size, in bytes, of the given variable.
   *
   * @param varName an input or output variable name, a CSDMS Standard Name
   * @return the size of the variable, counted in bytes.
   */
  int getVarNbytes(String varName);

  /**
   * Gets the <em>grid identifier</em> for the given variable.
   * <p>
   * Get <code>varName</code> from {@link edu.colorado.csdms.bmi.BmiInfo#getInputVarNames()} or
   * {@link edu.colorado.csdms.bmi.BmiInfo#getOutputVarNames()}
   *
   * @param varName an input or output variable name, a CSDMS Standard Name
   * @return the grid id
   */
  int getVarGrid(String varName);

}
