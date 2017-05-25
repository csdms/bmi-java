/**
 * The complete Basic Model Interface (BMI) in Java.
 */
package edu.colorado.csdms.bmi;

/**
 * The complete Basic Model Interface (BMI). Defines an interface for converting
 * a standalone model into an integrated modeling framework component.
 * <p>
 * See the <a href="http://csdms.colorado.edu">CSDMS</a> web page for more
 * information about BMI.
 */
public interface BMI extends BmiBase, BmiInfo, BmiTime, BmiVars, BmiGetter,
    BmiSetter, BmiGridRectilinear, BmiGridUniformRectilinear,
    BmiGridStructuredQuad, BmiGridUnstructured {
}
