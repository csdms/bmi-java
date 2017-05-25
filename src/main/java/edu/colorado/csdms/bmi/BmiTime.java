/**
 * Interface that describes the time stepping of a model.
 */
package edu.colorado.csdms.bmi;

/**
 * Methods that get time information from a model.
 */
public interface BmiTime {
  
  /**
   * The start time of the model. Model times should be of type <b>double</b>.
   * The default model start time is 0.0.
   * 
   * @return the model start time
   */
  public double getStartTime();
  
  /**
   * The current time in the model.
   * 
   * @return the current model time
   */
  public double getCurrentTime();
  
  /**
   * The end time of the model.
   * 
   * @return the maximum model time
   */
  public double getEndTime();
  
  /**
   * The time step of the model. The model time step should be of type
   * <b>double</b>. The default time step is 1.0.
   * 
   * @return the time step used in the model
   */
  public double getTimeStep();
  
  /**
   * The time unit of the model. CSDMS uses the UDUNITS standard from Unidata.
   * 
   * @see BmiVars#getVarUnits(String)
   * @return The model time unit; e.g., <em>days</em> or <em>s</em>
   */
  public String getTimeUnits();

}
