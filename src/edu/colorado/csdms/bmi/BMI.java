/**
 * The complete Basic Model Interface.
 */
package edu.colorado.csdms.bmi;

/**
 * The complete Basic Model Interface. Defines an interface for converting a
 * standalone model into an integrated modeling framework component.
 * 
 * @see http://csdms.colorado.edu
 */
public interface BMI extends BmiBase, BmiInfo, BmiTime, BmiVars, BmiGetter,
    BmiSetter, BmiGridRectilinear, BmiGridUniformRectilinear,
    BmiGridStructuredQuad, BmiGridUnstructured {
}
