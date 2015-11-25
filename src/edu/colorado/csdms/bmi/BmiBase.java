/**
 * Interface to the basic control functions of a model.
 */
package edu.colorado.csdms.bmi;

/**
 * Functions that control model execution. These BMI functions are critical to
 * plug-and-play modeling because they give a calling component fine-grained
 * control over the model execution.
 */
public interface BmiBase {

  /**
   * Performs all tasks that take place before entering the model's time loop,
   * including opening files and initializing the model state. Model inputs are
   * read from a text-based configuration file, specified by <tt>fileName</tt>.
   * 
   * @param fileName the path to the model configuration file
   */
  public void initialize(String fileName);

  /**
   * Performs all tasks that take place before entering the model's time loop,
   * including opening files and initializing the model state. Default model
   * inputs are provided.
   */
  public void initialize();

  /**
   * Performs all tasks that take place within one pass through the model's time
   * loop. This typically includes incrementing all of the model's state
   * variables. If the model's state variables don't change in time, then they
   * can be computed by the {@link BMI#initialize(String)} method and this
   * method can return with no action.
   */
  public void update();
  
  /**
   * Advance model state until the given time.
   * 
   * @param time a model time value
   */
  public void updateUntil(double time);
  
  /**
   * Advance model state by a fraction of a time step.
   * 
   * @param timeFrac a fraction of a model time step value
   */
  public void updateFrac(double timeFrac);
  
  /**
   * Performs all tasks that take place after exiting the model's time loop.
   * This typically includes deallocating memory, closing files and printing
   * reports.
   */
  public void finalize();

}
