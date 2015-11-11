/**
 * Interface that describes a model and its input and output variables.
 */
package edu.colorado.csdms.bmi;

/**
 * Get metadata about a model.
 */
public interface BmiInfo {

  /**
   * The name of the component.
   * 
   * @return the name of the component
   */
  public String getComponentName();
  
  /**
   * Lists a model's input variables. The variable names must be CSDMS Standard
   * Names, also known as <em>long variable names</em>.
   * <p>
   * Standard Names enable the CSDMS framework to determine whether an input
   * variable in one model is equivalent to, or compatible with, an output
   * variable in another model. This allows the framework to automatically
   * connect components. Standard Names do not have to be used within the model.
   * 
   * @return the input variables for the model
   */
  public String[] getInputVarNames();
  
  /**
   * The number of input variables used by the model.
   * 
   * @see BmiInfo#getInputVarNames()
   * @return the number of input variables
   */
  public int getInputVarNameCount();
  
  /**
   * Lists a model's output variables. The variable names must be CSDMS Standard
   * Names, also known as <em>long variable names</em>.
   * 
   * @see BmiInfo#getInputVarNames()
   * @return the output variable names for the model
   */
  public String[] getOutputVarNames();
  
  /**
   * The number of output variables provided by the model.
   * 
   * @see BmiInfo#getInputVarNames()
   * @return the number of output variables
   */
  public int getOutputVarNameCount();

}
