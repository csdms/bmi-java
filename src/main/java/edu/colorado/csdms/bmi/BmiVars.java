/**
 * Interface that describes a model's input and output variables.
 */
package edu.colorado.csdms.bmi;

/**
 * Methods that get information about input and output variables. These BMI
 * functions obtain information about a particular input or output variable.
 * They must accommodate any variable that is returned by the BMI functions
 * {@link BmiInfo#getInputVarNames()} or {@link BmiInfo#getOutputVarNames()}.
 */
public interface BmiVars {

  /**
   * Get the data type of the given variable.
   * 
   * @param varName an input or output variable name, a CSDMS Standard Name
   * @return the variable type; e.g., <tt>int</tt>, <tt>double</tt>,
   *         <tt>String</tt>.
   */
  public String getVarType(String varName);
  
  /**
   * Get units of the given variable. Standard unit names, in lower case, should
   * be used, such as <tt>meters</tt> or <tt>seconds</tt>. Standard
   * abbreviations, like <tt>m</tt> for meters, are also supported. For
   * variables with compound units, each unit name is separated by a single
   * space, with exponents other than 1 placed immediately after the name, as in
   * <tt>m s-1</tt> for velocity, <tt>W m-2</tt> for an energy flux, or
   * <tt>km2</tt> for an area.
   * 
   * @param varName an input or output variable name, a CSDMS Standard Name
   * @return the variable units
   */
  public String getVarUnits(String varName);
  
  /**
   * Gets the memory use for each array element in bytes.
   * 
   * @param varName an input or output variable name, a CSDMS Standard Name
   * @return item size in bytes
   */
  public int getVarItemsize(String varName);
  
  /**
   * Gets the total size, in bytes, of the given variable.
   * 
   * @param varName an input or output variable name, a CSDMS Standard Name
   * @return the size of the variable, counted in bytes.
   */
  public int getVarNbytes(String varName);
  
  /**
   * Gets the <em>grid identifier</em> for the given variable.
   * <p>
   * Get <tt>varName</tt> from {@link BmiInfo#getInputVarNames()} or
   * {@link BmiInfo#getOutputVarNames()}
   * 
   * @param varName an input or output variable name, a CSDMS Standard Name
   * @return the grid id
   */
  public int getVarGrid(String varName);

}
