/**
 * Interface for getting a model's internal variables.
 */
package edu.colorado.csdms.bmi;

/**
 * Methods that get variables from a model's state. Often a model's state
 * variables are changing with each time step, so getters are called to get
 * current values.
 */
public interface BmiGetter {

  /**
   * This is a getter for the model, used to access the model's current state.
   * It returns a <em>copy</em> of a model variable, with the return type, size
   * and rank dependent on the variable.
   * 
   * @param varName an input or output variable name, a CSDMS Standard Name
   * @return the value of a model variable
   */
  public <T> T getValue(String varName);

  /**
   * This is a getter for the model, used to access the model's current state.
   * It returns a <em>reference</em> to a model variable, with the return type,
   * size and rank dependent on the variable.
   * 
   * @param varName an input or output variable name, a CSDMS Standard Name
   * @return a reference to a model variable
   */
  public <T> T getValueRef(String varName);
  
  /**
   * Gets values at particular locations in a model variable.
   *  
   * @param varName an input or output variable name, a CSDMS Standard Name
   * @param indices the indices into the variable array
   * @return the value of the variable at the given location
   */
  public <T> T getValueAtIndices(String varName, int[] indices);
  
}
