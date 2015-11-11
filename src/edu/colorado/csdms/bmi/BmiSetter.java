/**
 * Interface for setting a model's internal variables.
 */
package edu.colorado.csdms.bmi;

/**
 * Methods that set variables of a model's state.
 */
public interface BmiSetter {

  /**
   * This is the setter for the model, used to change the model's current state.
   * It accepts, through <tt>src</tt>, a new value for a model variable, with
   * the type, size and rank of <tt>src</tt> dependent on the variable.
   * 
   * @param varName an input or output variable name, a CSDMS Standard Name
   * @param src the new value for the specified variable
   */
  public <T> void setValue(String varName, T src);

  /**
   * Specifies a new value for a model variable at a particular location.
   * 
   * @param varName an input or output variable name, a CSDMS Standard Name
   * @param indices the indices into the variable array
   * @param src the new value for the specified variable
   */
  public <T> void setValueAtIndices(String varName, int[] indices, T src);
  
}
