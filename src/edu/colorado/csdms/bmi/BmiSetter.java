/**
 * Interface for setting a model's internal variables.
 */
package edu.colorado.csdms.bmi;

/**
 * Methods that set variables of a model's state.
 * <p>
 * <b>Note:</b> Setters are explicitly defined for types <b>double</b>,
 * <b>int</b>, and <b>String</b>; setters for other types may be added as
 * needed.
 */
public interface BmiSetter {

  /**
   * This is a setter for the model, used to change the model's current state.
   * It accepts, through <tt>src</tt>, a new value for a model variable, with
   * the size of <tt>src</tt> dependent on the variable.
   *
   * @param varName an input or output variable name, a CSDMS Standard Name
   * @param src the new value for the specified variable
   */
  public void setValue(String varName, double[] src);

  /**
   * This is a setter for the model, used to change the model's current state.
   * It accepts, through <tt>src</tt>, a new value for a model variable, with
   * the size of <tt>src</tt> dependent on the variable.
   *
   * @param varName an input or output variable name, a CSDMS Standard Name
   * @param src the new value for the specified variable
   */
  public void setValue(String varName, int[] src);

  /**
   * This is a setter for the model, used to change the model's current state.
   * It accepts, through <tt>src</tt>, a new value for a model variable, with
   * the size of <tt>src</tt> dependent on the variable.
   *
   * @param varName an input or output variable name, a CSDMS Standard Name
   * @param src the new value for the specified variable
   */
  public void setValue(String varName, String[] src);

  /**
   * Specifies a new value for a model variable at a particular location.
   *
   * @param varName an input or output variable name, a CSDMS Standard Name
   * @param indices the indices into the variable array
   * @param src the new value for the specified variable
   */
  public void setValueAtIndices(String varName, int[] indices, double[] src);

  /**
   * Specifies a new value for a model variable at a particular location.
   *
   * @param varName an input or output variable name, a CSDMS Standard Name
   * @param indices the indices into the variable array
   * @param src the new value for the specified variable
   */
  public void setValueAtIndices(String varName, int[] indices, int[] src);

  /**
   * Specifies a new value for a model variable at a particular location.
   *
   * @param varName an input or output variable name, a CSDMS Standard Name
   * @param indices the indices into the variable array
   * @param src the new value for the specified variable
   */
  public void setValueAtIndices(String varName, int[] indices, String[] src);
}
